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
import com.baidu.tieba.cs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public final class oe2 {
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
        public static final oe2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-549609489, "Lcom/baidu/tieba/oe2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-549609489, "Lcom/baidu/tieba/oe2$b;");
                    return;
                }
            }
            a = new oe2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029293, "Lcom/baidu/tieba/oe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029293, "Lcom/baidu/tieba/oe2;");
                return;
            }
        }
        b = qp1.a;
    }

    public oe2() {
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

    public static oe2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (oe2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ oe2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            qy1.k(swanAppConfigData);
            qe2.k().x(f93.K().getAppId(), false);
            ci3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013e A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c8 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e3 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0233 A[Catch: all -> 0x02d3, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01df, B:67:0x01e3, B:68:0x01ec, B:70:0x0233, B:71:0x02c8, B:64:0x01d5, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.nv1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull cb2 cb2Var, @NonNull mv1 mv1Var, @NonNull du2 du2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable cs2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        xf2 xf2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{cb2Var, mv1Var, du2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        vf2.c(14);
                    }
                    return;
                }
                if (z) {
                    vf2.c(1);
                }
                String d = rc3.d(tu2.U(), du2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                uf2 uf2Var = new uf2();
                uf2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    uf2Var.b = gVar.a;
                } else {
                    uf2Var.b = cs2.e.i(du2Var.H(), du2Var.v1()).getPath() + File.separator;
                }
                uf2Var.c = mv1Var.a();
                uf2Var.d = d;
                uf2Var.f = String.valueOf(d62.a());
                uf2Var.g = uf2.c(g93.M(), d);
                uf2Var.i = h;
                if (!b && !tu2.U().N()) {
                    z2 = false;
                    uf2Var.h = z2;
                    uf2Var.j = mv1Var.J();
                    uf2Var.l = yf2.b();
                    f0 = du2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        uf2Var.m = f0.userActionApis;
                    }
                    H = f53.H();
                    if (H) {
                        uf2Var.k = j62.b();
                    }
                    P = du2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            uf2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", uf2Var.toString());
                    }
                    l23.o().F(new UbcFlowEvent("master_dispatch_start"));
                    gf3.d().i("master_dispatch_start");
                    cb2Var.D(uf2Var);
                    ag2.U().U0(uf2.b(uf2Var));
                    ns2.m0().a();
                    ag2.U().h1(uf2Var.j);
                    F = f53.F(du2Var.g0());
                    boolean p0 = du2Var.p0();
                    if (!F) {
                        w62.d();
                        w62.g().h("appready");
                    } else if (p0) {
                        p62.e().f("appready");
                    }
                    v93 f = tu2.U().f(yc3.b(ym3.f(d)));
                    xf2Var = new xf2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        xf2Var.a = gVar.a;
                    } else {
                        xf2Var.a = cs2.e.i(du2Var.H(), du2Var.v1()).getPath() + File.separator;
                    }
                    xf2Var.b = d;
                    xf2Var.d = f.g;
                    xf2Var.c = h;
                    xf2Var.k = uf2Var.g;
                    xf2Var.e = String.valueOf(du2Var.m0());
                    xf2Var.g = z2;
                    xf2Var.i = mv1Var.J();
                    xf2Var.m = true;
                    if (H) {
                        xf2Var.j = j62.d();
                    }
                    if (!F) {
                        w62.g().h("pageready");
                    } else if (p0) {
                        p62.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", xf2Var.toString());
                    }
                    l23.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    gf3.d().i("slave_dispatch_start");
                    mv1Var.K(xf2Var);
                    nm3.d();
                    mv1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    mv1Var.R(d);
                    ag2.U().V0(mv1Var.a(), xf2.a(xf2Var));
                    qf3.F(mv1Var.a(), xf2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + uf2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + mv1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + xf2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + xf2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + xf2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                uf2Var.h = z2;
                uf2Var.j = mv1Var.J();
                uf2Var.l = yf2.b();
                f0 = du2Var.f0();
                if (f0 != null) {
                    uf2Var.m = f0.userActionApis;
                }
                H = f53.H();
                if (H) {
                }
                P = du2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                l23.o().F(new UbcFlowEvent("master_dispatch_start"));
                gf3.d().i("master_dispatch_start");
                cb2Var.D(uf2Var);
                ag2.U().U0(uf2.b(uf2Var));
                ns2.m0().a();
                ag2.U().h1(uf2Var.j);
                F = f53.F(du2Var.g0());
                boolean p02 = du2Var.p0();
                if (!F) {
                }
                v93 f2 = tu2.U().f(yc3.b(ym3.f(d)));
                xf2Var = new xf2();
                if (gVar == null) {
                }
                xf2Var.a = cs2.e.i(du2Var.H(), du2Var.v1()).getPath() + File.separator;
                xf2Var.b = d;
                xf2Var.d = f2.g;
                xf2Var.c = h;
                xf2Var.k = uf2Var.g;
                xf2Var.e = String.valueOf(du2Var.m0());
                xf2Var.g = z2;
                xf2Var.i = mv1Var.J();
                xf2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                l23.o().F(new UbcFlowEvent("slave_dispatch_start"));
                gf3.d().i("slave_dispatch_start");
                mv1Var.K(xf2Var);
                nm3.d();
                mv1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                mv1Var.R(d);
                ag2.U().V0(mv1Var.a(), xf2.a(xf2Var));
                qf3.F(mv1Var.a(), xf2Var.b);
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
        cb2 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = e33.b()) != 0 && (W = ag2.U().W()) != null) {
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
