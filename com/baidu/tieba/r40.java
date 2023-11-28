package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.DnsHelper;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class r40 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 2;
    public static List<String> b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes8.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static a b;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        @Override // com.baidu.tieba.r40.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.r40$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0469a extends TimerTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicBoolean a;
            public final /* synthetic */ String b;
            public final /* synthetic */ d c;
            public final /* synthetic */ a d;

            public C0469a(a aVar, AtomicBoolean atomicBoolean, String str, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, atomicBoolean, str, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.a = atomicBoolean;
                this.b = str;
                this.c = dVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "bddns > get IPs too long, bdDnsIps is null");
                    }
                    this.a.set(true);
                    f40 g = e40.h(this.d.a).g(601110);
                    g.d("P9", "BDDNS resovle spend more than 10s");
                    g.d("con_err_code", "P9");
                    r40.g(3, this.d.a);
                    r40.a(this.d.a).b(this.b, this.c);
                }
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Context applicationContext = context.getApplicationContext();
            this.a = applicationContext;
            r40.f(applicationContext);
        }

        public static synchronized a d(Context context) {
            InterceptResult invokeL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = new a(context);
                    }
                    aVar = b;
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r40.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    if (n50.a) {
                        o50.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    }
                    if (r40.b != null && r40.b.size() > 0) {
                        if (r40.c < r40.b.size()) {
                            if (dVar != null) {
                                dVar.a(0, DnsModel.MSG_OK, r40.b.get(r40.c));
                                if (n50.a) {
                                    o50.a("DNSUrlProvider", "retry bddns > return ip = " + r40.b.get(r40.c));
                                }
                            }
                            r40.c++;
                            return;
                        }
                        r40.g(3, this.a);
                        r40.a(this.a).b(str, dVar);
                        return;
                    }
                    Timer timer = new Timer();
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + str);
                    }
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    timer.schedule(new C0469a(this, atomicBoolean, str, dVar), 3000L);
                    DnsHelper dnsHelper = new DnsHelper(this.a);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    r40.h(dnsHelper.getIpList(str), this.a);
                    if (r40.b != null && r40.b.size() > 0) {
                        if (n50.a) {
                            o50.a("DNSUrlProvider", "bddns > resolve ips end, bdDnsIps = " + r40.b);
                        }
                        String str2 = r40.b.get(0);
                        if (dVar != null && !atomicBoolean.get()) {
                            timer.cancel();
                            if (r40.b.size() > 1) {
                                r40.c++;
                                r40.g(1, this.a);
                            }
                            if (n50.a) {
                                o50.a("DNSUrlProvider", "bddns > resolve ips end, return ip = " + str2);
                            }
                            dVar.a(0, DnsModel.MSG_OK, str2);
                        } else if (n50.a) {
                            o50.a("DNSUrlProvider", "bddns > resolve ips end, but out of time, do nothing");
                        }
                        timer.cancel();
                    }
                } catch (Throwable unused) {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    }
                    r40.g(3, this.a);
                    r40.a(this.a).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public static c b;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        @Override // com.baidu.tieba.r40.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context.getApplicationContext();
        }

        public static synchronized b c(Context context) {
            InterceptResult invokeL;
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (c.class) {
                    if (b == null) {
                        b = new c(context);
                    }
                    cVar = b;
                }
                return cVar;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r40.b
        public void b(String str, d dVar) {
            Context context;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                if (n50.a) {
                    o50.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                }
                if (dVar != null && (context = this.a) != null) {
                    r40.f(context);
                    dVar.a(0, DnsModel.MSG_OK, str);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;
        public static e b;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        @Override // com.baidu.tieba.r40.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        public e(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (b == null) {
                        b = new e(context);
                    }
                    eVar = b;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r40.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                if (n50.a) {
                    o50.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                }
                try {
                    k50 k50Var = new k50(this.a);
                    k50Var.a(dVar);
                    j50.d().e(k50Var, k50Var);
                } catch (Exception unused) {
                    r40.g(3, this.a);
                    r40.a(this.a).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class f implements b {
        public static /* synthetic */ Interceptable $ic;
        public static f b;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        @Override // com.baidu.tieba.r40.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        public f(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context.getApplicationContext();
        }

        public static synchronized b c(Context context) {
            InterceptResult invokeL;
            f fVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (f.class) {
                    if (b == null) {
                        b = new f(context);
                    }
                    fVar = b;
                }
                return fVar;
            }
            return (b) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r40.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) && dVar != null) {
                String h = p50.h(this.a);
                if (!TextUtils.isEmpty(h)) {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "LocalCacheProvider " + h);
                    }
                    dVar.a(0, DnsModel.MSG_OK, h);
                    return;
                }
                if (n50.a) {
                    o50.a("DNSUrlProvider", "else POLICY_BDHTTPDNS " + h);
                }
                r40.g(1, this.a);
                r40.a(this.a).b(str, dVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071515, "Lcom/baidu/tieba/r40;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071515, "Lcom/baidu/tieba/r40;");
                return;
            }
        }
        b = Collections.synchronizedList(new ArrayList());
        c = 0;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            List<String> list = b;
            if (list != null && c <= list.size()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static b a(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Context applicationContext = context.getApplicationContext();
            int a2 = n50.a(applicationContext);
            if (a2 != 1 && a2 != 2) {
                if (n50.a) {
                    o50.a("DNSUrlProvider", "DNSUrlProviderInternal " + a);
                }
                if (!TextUtils.isEmpty(p50.h(applicationContext)) && a == 0) {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "LocalCacheProvider ");
                    }
                    return f.c(applicationContext);
                } else if (p50.c(applicationContext) && ((i = a) == 1 || i == 0)) {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "BDHttpDNSUrlProvider ");
                    }
                    return a.d(applicationContext);
                } else if (a == 2) {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "LCPHttpDNSUrlProvider ");
                    }
                    return e.c(applicationContext);
                } else {
                    if (n50.a) {
                        o50.a("DNSUrlProvider", "DefaultUrlProvider ");
                    }
                    return c.c(applicationContext);
                }
            }
            a = 3;
            return c.c(applicationContext);
        }
        return (b) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            if (n50.a) {
                o50.a("DNSUrlProvider", "onConnectSuccess currentPolicy：" + a);
            }
            e(context, str, true);
            int i = a;
            if (i == 0 || i == 1 || i == 2) {
                if (n50.a) {
                    o50.a("DNSUrlProvider", "localcache cached: " + str);
                }
                p50.E(context, str);
            }
        }
    }

    public static int g(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i, context)) == null) {
            int a2 = n50.a(context);
            if (a2 != 1 && a2 != 2) {
                a = i;
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                a = 3;
                            } else {
                                a = 3;
                            }
                        } else {
                            a = 2;
                        }
                    } else {
                        a = 1;
                    }
                } else {
                    a = 0;
                }
            } else {
                a = 3;
            }
            if (n50.a) {
                o50.a("DNSUrlProvider", "try to connect ip, now policy =" + a);
            }
            return a;
        }
        return invokeIL.intValue;
    }

    public static void e(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65541, null, context, str, z) == null) {
            f(context);
            c.c(context).a(str, true);
        }
    }

    public static void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            if (n50.a) {
                o50.a("DNSUrlProvider", "resetBdDns");
            }
            try {
                c = 0;
                b.clear();
                p50.E(context, "");
                a = 0;
            } catch (Exception e2) {
                if (n50.a) {
                    o50.c("DNSUrlProvider", "resetBdDns exception", e2);
                }
            }
        }
    }

    public static void h(List<String> list, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, list, context) == null) {
            b.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (c(list.get(i))) {
                        arrayList.add(list.get(i));
                    } else {
                        arrayList2.add(list.get(i));
                    }
                }
            }
            if (arrayList.size() + arrayList2.size() > 0) {
                int f2 = p50.f(context);
                if (n50.a) {
                    o50.b("DNSUrlProvider", "getIpPriority :" + f2 + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                }
                if (f2 != 1) {
                    if (f2 != 2) {
                        if (f2 != 4) {
                            b.addAll(arrayList);
                            b.addAll(arrayList2);
                            return;
                        }
                        b.addAll(arrayList);
                        return;
                    }
                    b.addAll(arrayList2);
                    b.addAll(arrayList);
                    return;
                }
                b.addAll(arrayList2);
            }
        }
    }
}
