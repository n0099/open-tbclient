package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.DnsParseResult;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.http.IHttpDns;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.Dns;
/* loaded from: classes5.dex */
public class q09 implements Dns, IHttpDns {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public long b;
    public long c;
    public DnsParseResult e;
    public boolean f;
    public DnsHelper g;
    public boolean h;
    public a i;

    /* loaded from: classes5.dex */
    public interface a {
        void a(long j, long j2, DnsParseResult dnsParseResult);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038159, "Lcom/baidu/tieba/q09;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038159, "Lcom/baidu/tieba/q09;");
                return;
            }
        }
        j = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public DnsHelper a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (DnsHelper) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.http.IHttpDns
    public boolean getHttpDnsEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public q09(DnsHelper dnsHelper, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dnsHelper, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = z;
        this.b = -1L;
        this.c = -1L;
        this.g = dnsHelper;
        if (dnsHelper != null && dnsHelper.isHttpDnsEnable()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.a = z2;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return j.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj instanceof q09) {
                return true;
            }
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.IHttpDns
    public void setHttpDnsEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.a = z;
            DnsHelper dnsHelper = this.g;
            if (dnsHelper != null) {
                dnsHelper.setHttpDnsEnable(z);
            }
        }
    }

    @Override // com.baidu.searchbox.http.IHttpDns
    public void setHttpDnsIPv4OnlyEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h = z;
        }
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                boolean z = this.f;
                if (z) {
                    this.b = System.currentTimeMillis();
                }
                List arrayList = new ArrayList();
                try {
                    if (b(str)) {
                        return Arrays.asList(InetAddress.getAllByName(str));
                    }
                    if (this.a && this.g != null) {
                        DnsParseResult parseResult = this.g.getParseResult(str);
                        if (parseResult != null) {
                            arrayList = DnsUtil.parseInetAddressList(parseResult.getIpList());
                        }
                        if (z) {
                            long currentTimeMillis = System.currentTimeMillis();
                            this.c = currentTimeMillis;
                            this.e = parseResult;
                            if (this.i != null) {
                                this.i.a(this.b, currentTimeMillis, parseResult);
                            }
                        }
                    } else {
                        arrayList = Arrays.asList(InetAddress.getAllByName(str));
                        if (z) {
                            this.c = System.currentTimeMillis();
                            DnsParseResult dnsParseResult = new DnsParseResult(DnsUtil.parseRawAddressList(arrayList), 0, 1, DnsUtil.stackType);
                            this.e = dnsParseResult;
                            if (this.i != null) {
                                this.i.a(this.b, this.c, dnsParseResult);
                            }
                        }
                    }
                    if (DnsUtil.stackType == 3 && this.h && arrayList != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (InetAddress inetAddress : arrayList) {
                            if (inetAddress instanceof Inet6Address) {
                                arrayList2.add(inetAddress);
                            }
                        }
                        arrayList.removeAll(arrayList2);
                        if (arrayList.isEmpty()) {
                            throw new UnknownHostException("request support ipv4 address only!");
                        }
                    }
                    return arrayList;
                } catch (IllegalArgumentException e) {
                    e = e;
                    throw new UnknownHostException(e.getMessage());
                } catch (NullPointerException e2) {
                    if (e2.getMessage() != null && e2.getMessage().contains("Attempt to get length of null array")) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                        unknownHostException.initCause(e2);
                        throw unknownHostException;
                    }
                    throw e2;
                } catch (SecurityException e3) {
                    e = e3;
                    throw new UnknownHostException(e.getMessage());
                }
            }
            throw new UnknownHostException("hostname == null");
        }
        return (List) invokeL.objValue;
    }
}
