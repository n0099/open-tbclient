package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class jp {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jp a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str);
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public a b;
        public final /* synthetic */ jp c;

        public b(jp jpVar, String str, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jpVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jpVar;
            this.a = str;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map d = this.c.d(this.a);
                if (d != null) {
                    arrayList2 = (ArrayList) d.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
                    arrayList = (ArrayList) d.get("ipv4");
                } else {
                    arrayList = null;
                    arrayList2 = null;
                }
                this.b.a(((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? -1 : 0, arrayList, arrayList2, 60L, this.a);
            }
        }
    }

    public jp() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static jp c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (jp.class) {
                    if (a == null) {
                        a = new jp();
                    }
                }
            }
            return a;
        }
        return (jp) invokeV.objValue;
    }

    public void b(String str, a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, aVar) == null) || str == null || str.isEmpty()) {
            return;
        }
        op.b().a().execute(new b(this, str, aVar));
    }

    public final Map<String, ArrayList> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    HashMap hashMap = new HashMap();
                    for (InetAddress inetAddress : allByName) {
                        if (inetAddress instanceof Inet4Address) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (ip.l(hostAddress)) {
                                arrayList.add(hostAddress);
                            }
                        } else if (inetAddress instanceof Inet6Address) {
                            String hostAddress2 = inetAddress.getHostAddress();
                            if (ip.m(hostAddress2)) {
                                arrayList2.add(hostAddress2);
                            }
                        }
                    }
                    hashMap.put("ipv4", arrayList);
                    hashMap.put(HttpDnsCacheForHost.JSON_KEY_IPV6, arrayList2);
                    if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                        np.a("Dns resolve failed, host(%s), get no valid resolve result", str);
                        return null;
                    }
                    np.a("Dns resolve successful, host(%s), ipv4List(%s), ipv6List(%s)", str, arrayList.toString(), arrayList2.toString());
                    return hashMap;
                }
                np.a("Dns resolve failed, host(%s), get empty resolve result", str);
                return null;
            } catch (UnknownHostException e) {
                e.printStackTrace();
                np.a("Dns resolve failed, host(%s), caught UnknownHostException", str);
                return null;
            }
        }
        return (Map) invokeL.objValue;
    }

    public BDHttpDnsResult e(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Map<String, ArrayList> d = d(str);
            ArrayList arrayList2 = null;
            if (d != null) {
                arrayList2 = d.get("ipv4");
                arrayList = d.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
            } else {
                arrayList = null;
            }
            if ((arrayList2 != null && !arrayList2.isEmpty()) || (arrayList != null && !arrayList.isEmpty())) {
                return new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList2, arrayList);
            }
            return new BDHttpDnsResult(BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve);
        }
        return (BDHttpDnsResult) invokeL.objValue;
    }
}
