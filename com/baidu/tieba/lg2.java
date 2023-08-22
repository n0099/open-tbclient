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
import com.baidu.tieba.zt2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public final class lg2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final lg2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-633649900, "Lcom/baidu/tieba/lg2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-633649900, "Lcom/baidu/tieba/lg2$b;");
                    return;
                }
            }
            a = new lg2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947941842, "Lcom/baidu/tieba/lg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947941842, "Lcom/baidu/tieba/lg2;");
                return;
            }
        }
        b = nr1.a;
    }

    public lg2() {
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

    public static lg2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (lg2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ lg2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            n02.k(swanAppConfigData);
            ng2.k().x(cb3.K().getAppId(), false);
            zj3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.kx1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull zc2 zc2Var, @NonNull jx1 jx1Var, @NonNull aw2 aw2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable zt2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        uh2 uh2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zc2Var, jx1Var, aw2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        sh2.c(14);
                    }
                    return;
                }
                if (z) {
                    sh2.c(1);
                }
                String d = oe3.d(qw2.T(), aw2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                rh2 rh2Var = new rh2();
                rh2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    rh2Var.b = gVar.a;
                } else {
                    rh2Var.b = zt2.e.i(aw2Var.H(), aw2Var.v1()).getPath() + File.separator;
                }
                rh2Var.c = jx1Var.a();
                rh2Var.d = d;
                rh2Var.f = String.valueOf(a82.a());
                rh2Var.g = rh2.c(db3.M(), d);
                rh2Var.i = h;
                if (!b && !qw2.T().M()) {
                    z2 = false;
                    rh2Var.h = z2;
                    rh2Var.j = jx1Var.I();
                    rh2Var.l = vh2.b();
                    f0 = aw2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        rh2Var.m = f0.userActionApis;
                    }
                    H = c73.H();
                    if (H) {
                        rh2Var.k = g82.b();
                    }
                    P = aw2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            rh2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", rh2Var.toString());
                    }
                    i43.o().F(new UbcFlowEvent("master_dispatch_start"));
                    dh3.d().i("master_dispatch_start");
                    zc2Var.C(rh2Var);
                    xh2.U().U0(rh2.b(rh2Var));
                    ku2.m0().a();
                    xh2.U().h1(rh2Var.j);
                    F = c73.F(aw2Var.g0());
                    boolean p0 = aw2Var.p0();
                    if (!F) {
                        t82.d();
                        t82.g().h("appready");
                    } else if (p0) {
                        m82.e().f("appready");
                    }
                    sb3 f = qw2.T().f(ve3.b(vo3.f(d)));
                    uh2Var = new uh2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        uh2Var.a = gVar.a;
                    } else {
                        uh2Var.a = zt2.e.i(aw2Var.H(), aw2Var.v1()).getPath() + File.separator;
                    }
                    uh2Var.b = d;
                    uh2Var.d = f.g;
                    uh2Var.c = h;
                    uh2Var.k = rh2Var.g;
                    uh2Var.e = String.valueOf(aw2Var.m0());
                    uh2Var.g = z2;
                    uh2Var.i = jx1Var.I();
                    uh2Var.m = true;
                    if (H) {
                        uh2Var.j = g82.d();
                    }
                    if (!F) {
                        t82.g().h("pageready");
                    } else if (p0) {
                        m82.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", uh2Var.toString());
                    }
                    i43.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    dh3.d().i("slave_dispatch_start");
                    jx1Var.J(uh2Var);
                    ko3.d();
                    jx1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    jx1Var.Q(d);
                    xh2.U().V0(jx1Var.a(), uh2.a(uh2Var));
                    nh3.F(jx1Var.a(), uh2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + rh2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + jx1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + uh2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + uh2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + uh2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                rh2Var.h = z2;
                rh2Var.j = jx1Var.I();
                rh2Var.l = vh2.b();
                f0 = aw2Var.f0();
                if (f0 != null) {
                    rh2Var.m = f0.userActionApis;
                }
                H = c73.H();
                if (H) {
                }
                P = aw2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                i43.o().F(new UbcFlowEvent("master_dispatch_start"));
                dh3.d().i("master_dispatch_start");
                zc2Var.C(rh2Var);
                xh2.U().U0(rh2.b(rh2Var));
                ku2.m0().a();
                xh2.U().h1(rh2Var.j);
                F = c73.F(aw2Var.g0());
                boolean p02 = aw2Var.p0();
                if (!F) {
                }
                sb3 f2 = qw2.T().f(ve3.b(vo3.f(d)));
                uh2Var = new uh2();
                if (gVar == null) {
                }
                uh2Var.a = zt2.e.i(aw2Var.H(), aw2Var.v1()).getPath() + File.separator;
                uh2Var.b = d;
                uh2Var.d = f2.g;
                uh2Var.c = h;
                uh2Var.k = rh2Var.g;
                uh2Var.e = String.valueOf(aw2Var.m0());
                uh2Var.g = z2;
                uh2Var.i = jx1Var.I();
                uh2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                i43.o().F(new UbcFlowEvent("slave_dispatch_start"));
                dh3.d().i("slave_dispatch_start");
                jx1Var.J(uh2Var);
                ko3.d();
                jx1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                jx1Var.Q(d);
                xh2.U().V0(jx1Var.a(), uh2.a(uh2Var));
                nh3.F(jx1Var.a(), uh2Var.b);
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
        zc2 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = b53.b()) != 0 && (W = xh2.U().W()) != null) {
            if (b2 < 0) {
                W.o(b2);
            } else if (b2 == 1) {
                W.o(-4);
            } else {
                W.o(-2);
            }
        }
    }
}
