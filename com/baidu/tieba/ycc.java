package com.baidu.tieba;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.DnsResultInfo;
import com.yy.gslbsdk.GslbEvent;
import com.yy.gslbsdk.HttpDnsService;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayNetStateStatisticsApi;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Dns;
/* loaded from: classes8.dex */
public class ycc implements Dns {
    public static /* synthetic */ Interceptable $ic;
    public static CopyOnWriteArrayList<IPayNetStateStatisticsApi> c;
    public transient /* synthetic */ FieldHolder $fh;
    public HttpDnsService a;
    public volatile boolean b;

    /* loaded from: classes8.dex */
    public class a implements GslbEvent.GslbEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.yy.gslbsdk.GslbEvent.GslbEventListener
        public void onMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        public a(ycc yccVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yccVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ycc a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-263705262, "Lcom/baidu/tieba/ycc$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-263705262, "Lcom/baidu/tieba/ycc$b;");
                    return;
                }
            }
            a = new ycc(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948326800, "Lcom/baidu/tieba/ycc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948326800, "Lcom/baidu/tieba/ycc;");
                return;
            }
        }
        c = new CopyOnWriteArrayList<>();
    }

    public static ycc c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return b.a;
        }
        return (ycc) invokeV.objValue;
    }

    public ycc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = true;
        RLog.info("YYPayHttpDns", "new OkHttpDns:" + toString());
    }

    public /* synthetic */ ycc(a aVar) {
        this();
    }

    public List<String> d(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void a(IPayNetStateStatisticsApi iPayNetStateStatisticsApi) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, iPayNetStateStatisticsApi) == null) {
            if (!c.contains(iPayNetStateStatisticsApi)) {
                c.add(iPayNetStateStatisticsApi);
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayHttpDns", "addPayNetStatisticsApi add " + z + " payNetReporter:" + iPayNetStateStatisticsApi);
        }
    }

    public static void g(IPayNetStateStatisticsApi iPayNetStateStatisticsApi) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, iPayNetStateStatisticsApi) == null) {
            if (c.contains(iPayNetStateStatisticsApi)) {
                c.remove(iPayNetStateStatisticsApi);
                z = true;
            } else {
                z = false;
            }
            RLog.info("YYPayHttpDns", "removePayNetStatisticsApi remove " + z + " payNetReporter:" + iPayNetStateStatisticsApi);
        }
    }

    public static void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, str, str2, str3) == null) {
            Iterator<IPayNetStateStatisticsApi> it = c.iterator();
            while (it.hasNext()) {
                it.next().reportPayNetEvent(str, str2, str3);
            }
        }
    }

    public List<String> b(String str) throws UnknownHostException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a == null) {
                RLog.error("YYPayHttpDns", "getIPListByHost error mHttpDnsService null", new Object[0]);
                return null;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            DnsResultInfo ipsByHost = this.a.getIpsByHost(str);
            if (ipsByHost != null) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = ipsByHost.mIpsV6;
                if (strArr != null) {
                    arrayList.addAll(d(strArr));
                    if (ipsByHost.mIpsV6.length == 0) {
                        RLog.error("YYPayHttpDns", "getIPListByHost IpsV6 empty hostname " + str + " code " + ipsByHost.mErrorCode, new Object[0]);
                    }
                } else {
                    RLog.error("YYPayHttpDns", "getIPListByHost IpsV6 null hostname " + str + " code " + ipsByHost.mErrorCode, new Object[0]);
                }
                String[] strArr2 = ipsByHost.mIpsV4;
                if (strArr2 != null) {
                    arrayList.addAll(d(strArr2));
                    if (ipsByHost.mIpsV4.length == 0) {
                        RLog.error("YYPayHttpDns", "getIPListByHost IpsV4 empty hostname " + str + " code " + ipsByHost.mErrorCode, new Object[0]);
                    }
                } else {
                    RLog.error("YYPayHttpDns", "getIPListByHost IpsV4 null hostname " + str + " code " + ipsByHost.mErrorCode, new Object[0]);
                }
                e(EventType.PayNetStateID.EVENT_DNS_RESULT, ipsByHost.mErrorCode + "", "ipList " + arrayList.size());
                RLog.info("YYPayHttpDns", "hostname " + str + " mDataSource " + ipsByHost.mDataSource + " code " + ipsByHost.mErrorCode + " res.IPList " + arrayList + " use duration " + (SystemClock.uptimeMillis() - uptimeMillis));
                return arrayList;
            }
            RLog.info("YYPayHttpDns", "getIPListByDns host " + str + "  use duration " + (SystemClock.uptimeMillis() - uptimeMillis));
            return null;
        }
        return (List) invokeL.objValue;
    }

    public List<InetAddress> f(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        arrayList.add(InetAddress.getByName(str));
                    } catch (UnknownHostException e) {
                        RLog.error("YYPayHttpDns", "getByName(" + str + ") error", e);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public synchronized int h(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, str, str2)) == null) {
            synchronized (this) {
                if (!this.b) {
                    RLog.warn("YYPayHttpDns", "tryInitHttpDns but not enable appId:" + str + " hdid:" + str2);
                    return -1;
                } else if (this.a != null) {
                    RLog.warn("YYPayHttpDns", "tryInitHttpDns but mHttpDnsService exit appId:" + str + " hdid:" + str2);
                    return -2;
                } else if (context == null) {
                    RLog.error("YYPayHttpDns", "tryInitHttpDns error context params null", new Object[0]);
                    return -3;
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    HttpDnsService service = HttpDnsService.getService(context, str, (ThreadPoolMgr.ITaskExecutor) null, str2, "CN");
                    this.a = service;
                    service.setLogEnabled(Env.instance().isTestEnv());
                    this.a.setGslbEventMessager(new a(this));
                    this.a.setHttpsEnable(true);
                    this.a.setNetworkStatus(3);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(Env.instance().REVENUE_HTTP_URL);
                    if (!Env.instance().isTestEnv()) {
                        arrayList.addAll(Arrays.asList(Env.instance().BACKUP_DOMAIN_POOL));
                    }
                    RLog.info("YYPayHttpDns", "PreResolveHost hosts " + arrayList.toString());
                    this.a.setPreResolveHosts(arrayList);
                    RLog.info("YYPayHttpDns", "dns init success cost time = " + (System.currentTimeMillis() - currentTimeMillis) + " appId:" + str + " hdid:" + str2);
                    return 1;
                }
            }
        }
        return invokeLLL.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:3|(5:7|8|9|(3:18|19|20)|(2:14|15)(1:17))|27|(1:11)|18|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
        com.yy.mobile.framework.revenuesdk.baseapi.log.RLog.error("YYPayHttpDns", "System lookup dns error", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // okhttp3.Dns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<InetAddress> lookup(String str) {
        InterceptResult invokeL;
        List<InetAddress> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (this.b && this.a != null) {
                RLog.info("YYPayHttpDns", "httpdns lookup ");
                try {
                    list = f(b(str));
                } catch (Exception e) {
                    RLog.error("YYPayHttpDns", "lookup exception:" + e.getLocalizedMessage(), new Object[0]);
                }
                if (list != null || list.isEmpty()) {
                    RLog.info("YYPayHttpDns", "system lookup");
                    list = Dns.SYSTEM.lookup(str);
                }
                if (list != null) {
                    return Collections.emptyList();
                }
                return list;
            }
            list = null;
            if (list != null) {
            }
            RLog.info("YYPayHttpDns", "system lookup");
            list = Dns.SYSTEM.lookup(str);
            if (list != null) {
            }
        } else {
            return (List) invokeL.objValue;
        }
    }
}
