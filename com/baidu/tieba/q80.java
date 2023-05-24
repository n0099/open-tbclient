package com.baidu.tieba;

import android.content.Context;
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
/* loaded from: classes7.dex */
public class q80 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 3;
    public static Context b;
    public static List<String> c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface b {
        void a(String str, boolean z);

        void b(String str, d dVar);
    }

    /* loaded from: classes7.dex */
    public interface d {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes7.dex */
    public static class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public static a a;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.q80.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        /* renamed from: com.baidu.tieba.q80$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0440a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ Timer b;
            public final /* synthetic */ d c;

            /* renamed from: com.baidu.tieba.q80$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0441a extends TimerTask {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AtomicBoolean a;
                public final /* synthetic */ RunnableC0440a b;

                public C0441a(RunnableC0440a runnableC0440a, AtomicBoolean atomicBoolean) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {runnableC0440a, atomicBoolean};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = runnableC0440a;
                    this.a = atomicBoolean;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        k90.a("DNSUrlProvider", "bddns > bdDnsIps is null");
                        d dVar = this.b.c;
                        if (dVar != null) {
                            dVar.a(8007, "bddns timeout :", "bddns timeout, bdDnsIps is null");
                            q80.f(true);
                            b c = q80.c(q80.b);
                            RunnableC0440a runnableC0440a = this.b;
                            c.b(runnableC0440a.a, runnableC0440a.c);
                        }
                        this.a.set(true);
                    }
                }
            }

            public RunnableC0440a(a aVar, String str, Timer timer, d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, timer, dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.b = timer;
                this.c = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    k90.a("DNSUrlProvider", "bddns > getUrlAsync in... host is " + this.a);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    this.b.schedule(new C0441a(this, atomicBoolean), 10000L);
                    DnsHelper dnsHelper = new DnsHelper(q80.b);
                    dnsHelper.setHttpDnsState(false, null, false, true);
                    q80.j(dnsHelper.getIpList(this.a));
                    List<String> list = q80.c;
                    if (list != null && list.size() > 0) {
                        k90.a("DNSUrlProvider", "bddns > bdDnsIps = " + q80.c);
                        String str = q80.c.get(0);
                        if (this.c != null && !atomicBoolean.get()) {
                            this.c.a(0, DnsModel.MSG_OK, str);
                            if (q80.c.size() > 1) {
                                q80.d++;
                                q80.f(false);
                            }
                        }
                        k90.a("DNSUrlProvider", "bddns > return ip = " + str);
                        this.b.cancel();
                    }
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
            Context unused = q80.b = context.getApplicationContext();
            q80.i();
        }

        public static synchronized a c(Context context) {
            InterceptResult invokeL;
            a aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a(context);
                    }
                    aVar = a;
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.baidu.tieba.q80.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                try {
                    k90.d("DNSUrlProvider", "BDHttpDNSUrlProvider try to getUrlAsync");
                    if (q80.c != null && q80.c.size() > 0) {
                        if (q80.d < q80.c.size()) {
                            if (dVar != null) {
                                dVar.a(0, DnsModel.MSG_OK, q80.c.get(q80.d));
                                k90.a("DNSUrlProvider", "retry bddns > return ip = " + q80.c.get(q80.d));
                            }
                            q80.d++;
                            return;
                        }
                        q80.f(true);
                        q80.c(q80.b).b(str, dVar);
                        return;
                    }
                    h90.a(q80.b).b(new RunnableC0440a(this, str, new Timer(), dVar));
                } catch (Throwable unused) {
                    k90.a("DNSUrlProvider", "bddns > bdDnsIps get exception ");
                    q80.f(true);
                    q80.c(q80.b).b(str, dVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements b {
        public static /* synthetic */ Interceptable $ic;
        public static c a;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.q80.b
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            }
        }

        public c() {
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

        public static synchronized b c() {
            InterceptResult invokeV;
            c cVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                synchronized (c.class) {
                    if (a == null) {
                        a = new c();
                    }
                    cVar = a;
                }
                return cVar;
            }
            return (b) invokeV.objValue;
        }

        @Override // com.baidu.tieba.q80.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                k90.d("DNSUrlProvider", "DefaultUrlProvider try to getUrlAsync");
                if (dVar != null) {
                    q80.i();
                    dVar.a(0, DnsModel.MSG_OK, str);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements b {
        public static /* synthetic */ Interceptable $ic;
        public static e a;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.q80.b
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
            Context unused = q80.b = context.getApplicationContext();
        }

        public static synchronized e c(Context context) {
            InterceptResult invokeL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                synchronized (e.class) {
                    if (a == null) {
                        a = new e(context);
                    }
                    eVar = a;
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        @Override // com.baidu.tieba.q80.b
        public void b(String str, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
                k90.a("DNSUrlProvider", "will getLCPHttpDnsAddress......");
                try {
                    g90 g90Var = new g90(q80.b);
                    g90Var.a(dVar);
                    f90.d().e(g90Var, g90Var);
                } catch (Exception unused) {
                    q80.f(true);
                    q80.c(q80.b).b(str, dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948045568, "Lcom/baidu/tieba/q80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948045568, "Lcom/baidu/tieba/q80;");
                return;
            }
        }
        c = Collections.synchronizedList(new ArrayList());
        d = 0;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            List<String> list = c;
            if (list != null && d <= list.size()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            try {
                d = 0;
                c.clear();
                a = 2;
            } catch (Exception e2) {
                k90.c("DNSUrlProvider", "resetBdDns exception", e2);
            }
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            b = context.getApplicationContext();
            int a2 = j90.a(context);
            if (a2 != 1 && a2 != 2) {
                k90.b("DNSUrlProvider", "bdDNS :" + l90.c(context) + ", cur :" + a);
                if (l90.c(context) && a == 2) {
                    return a.c(context);
                }
                if (a == 3) {
                    return e.c(context);
                }
                return c.c();
            }
            a = 0;
            return c.c();
        }
        return (b) invokeL.objValue;
    }

    public static int f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            if (z) {
                int a2 = j90.a(b);
                if (a2 != 1 && a2 != 2) {
                    int i = a;
                    if (i != 0) {
                        if (i != 2) {
                            if (i == 3) {
                                a = 0;
                            }
                        } else {
                            a = 3;
                        }
                    } else {
                        a = 2;
                    }
                } else {
                    a = 0;
                }
            }
            k90.a("DNSUrlProvider", "try to connect ip, now policy =" + a);
            return a;
        }
        return invokeZ.intValue;
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            h(context, str, true);
        }
    }

    public static void h(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65544, null, context, str, z) == null) {
            i();
            c.c().a(str, true);
        }
    }

    public static void j(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, list) == null) {
            c.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    if (e(list.get(i))) {
                        arrayList.add(list.get(i));
                    } else {
                        arrayList2.add(list.get(i));
                    }
                }
            }
            if (arrayList.size() + arrayList2.size() > 0) {
                int f = l90.f(b);
                k90.b("DNSUrlProvider", "getIpPriority :" + f + ", ipv4 :" + arrayList.toString() + ", ipv6 :" + arrayList2.toString());
                if (f != 1) {
                    if (f != 2) {
                        if (f != 4) {
                            c.addAll(arrayList);
                            c.addAll(arrayList2);
                            return;
                        }
                        c.addAll(arrayList);
                        return;
                    }
                    c.addAll(arrayList2);
                    c.addAll(arrayList);
                    return;
                }
                c.addAll(arrayList2);
            }
        }
    }
}
