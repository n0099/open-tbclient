package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.fn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public final class r92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final r92 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-504356960, "Lcom/baidu/tieba/r92$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-504356960, "Lcom/baidu/tieba/r92$b;");
                    return;
                }
            }
            a = new r92(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076382, "Lcom/baidu/tieba/r92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076382, "Lcom/baidu/tieba/r92;");
                return;
            }
        }
        b = tk1.a;
    }

    public r92() {
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
        this.a = false;
    }

    public static r92 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (r92) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ r92(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            tt1.k(swanAppConfigData);
            t92.k().x(i43.K().getAppId(), false);
            fd3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013e A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c8 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e1 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.qq1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull f62 f62Var, @NonNull pq1 pq1Var, @NonNull gp2 gp2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable fn2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        ab2 ab2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{f62Var, pq1Var, gp2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ya2.c(14);
                    }
                    return;
                }
                if (z) {
                    ya2.c(1);
                }
                String d = u73.d(wp2.U(), gp2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                xa2 xa2Var = new xa2();
                xa2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    xa2Var.b = gVar.a;
                } else {
                    xa2Var.b = fn2.e.i(gp2Var.H(), gp2Var.v1()).getPath() + File.separator;
                }
                xa2Var.c = pq1Var.a();
                xa2Var.d = d;
                xa2Var.f = String.valueOf(g12.a());
                xa2Var.g = xa2.c(j43.M(), d);
                xa2Var.i = h;
                if (!b && !wp2.U().N()) {
                    z2 = false;
                    xa2Var.h = z2;
                    xa2Var.j = pq1Var.K();
                    xa2Var.l = bb2.b();
                    f0 = gp2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        xa2Var.m = f0.userActionApis;
                    }
                    H = i03.H();
                    if (H) {
                        xa2Var.k = m12.b();
                    }
                    P = gp2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            xa2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", xa2Var.toString());
                    }
                    ox2.o().F(new UbcFlowEvent("master_dispatch_start"));
                    ja3.d().i("master_dispatch_start");
                    f62Var.D(xa2Var);
                    db2.U().U0(xa2.b(xa2Var));
                    qn2.m0().a();
                    db2.U().h1(xa2Var.j);
                    F = i03.F(gp2Var.g0());
                    boolean p0 = gp2Var.p0();
                    if (!F) {
                        z12.d();
                        z12.g().h("appready");
                    } else if (p0) {
                        s12.e().f("appready");
                    }
                    y43 f = wp2.U().f(b83.b(bi3.f(d)));
                    ab2Var = new ab2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        ab2Var.a = gVar.a;
                    } else {
                        ab2Var.a = fn2.e.i(gp2Var.H(), gp2Var.v1()).getPath() + File.separator;
                    }
                    ab2Var.b = d;
                    ab2Var.d = f.g;
                    ab2Var.c = h;
                    ab2Var.k = xa2Var.g;
                    ab2Var.e = String.valueOf(gp2Var.m0());
                    ab2Var.g = z2;
                    ab2Var.i = pq1Var.K();
                    ab2Var.m = true;
                    if (H) {
                        ab2Var.j = m12.d();
                    }
                    if (!F) {
                        z12.g().h("pageready");
                    } else if (p0) {
                        s12.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", ab2Var.toString());
                    }
                    ox2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    ja3.d().i("slave_dispatch_start");
                    pq1Var.L(ab2Var);
                    qh3.d();
                    pq1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    pq1Var.R(d);
                    db2.U().V0(pq1Var.a(), ab2.a(ab2Var));
                    ta3.F(pq1Var.a(), ab2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + xa2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + pq1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + ab2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + ab2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + ab2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                xa2Var.h = z2;
                xa2Var.j = pq1Var.K();
                xa2Var.l = bb2.b();
                f0 = gp2Var.f0();
                if (f0 != null) {
                    xa2Var.m = f0.userActionApis;
                }
                H = i03.H();
                if (H) {
                }
                P = gp2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                ox2.o().F(new UbcFlowEvent("master_dispatch_start"));
                ja3.d().i("master_dispatch_start");
                f62Var.D(xa2Var);
                db2.U().U0(xa2.b(xa2Var));
                qn2.m0().a();
                db2.U().h1(xa2Var.j);
                F = i03.F(gp2Var.g0());
                boolean p02 = gp2Var.p0();
                if (!F) {
                }
                y43 f2 = wp2.U().f(b83.b(bi3.f(d)));
                ab2Var = new ab2();
                if (gVar == null) {
                }
                ab2Var.a = fn2.e.i(gp2Var.H(), gp2Var.v1()).getPath() + File.separator;
                ab2Var.b = d;
                ab2Var.d = f2.g;
                ab2Var.c = h;
                ab2Var.k = xa2Var.g;
                ab2Var.e = String.valueOf(gp2Var.m0());
                ab2Var.g = z2;
                ab2Var.i = pq1Var.K();
                ab2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                ox2.o().F(new UbcFlowEvent("slave_dispatch_start"));
                ja3.d().i("slave_dispatch_start");
                pq1Var.L(ab2Var);
                qh3.d();
                pq1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                pq1Var.R(d);
                db2.U().V0(pq1Var.a(), ab2.a(ab2Var));
                ta3.F(pq1Var.a(), ab2Var.b);
                if (b) {
                }
                a(swanAppConfigData);
                this.a = true;
                e();
            }
        }
    }

    public final void e() {
        int b2;
        f62 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = hy2.b()) != 0 && (W = db2.U().W()) != null) {
            if (b2 < 0) {
                W.p(b2);
            } else if (b2 == 1) {
                W.p(-4);
            } else {
                W.p(-2);
            }
        }
    }
}
