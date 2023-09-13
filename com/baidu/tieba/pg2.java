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
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes7.dex */
public final class pg2 {
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
        public static final pg2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-519133296, "Lcom/baidu/tieba/pg2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-519133296, "Lcom/baidu/tieba/pg2$b;");
                    return;
                }
            }
            a = new pg2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061006, "Lcom/baidu/tieba/pg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061006, "Lcom/baidu/tieba/pg2;");
                return;
            }
        }
        b = rr1.a;
    }

    public pg2() {
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

    public static pg2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (pg2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ pg2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            r02.k(swanAppConfigData);
            rg2.k().x(gb3.K().getAppId(), false);
            dk3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.ox1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull dd2 dd2Var, @NonNull nx1 nx1Var, @NonNull ew2 ew2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable du2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        yh2 yh2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{dd2Var, nx1Var, ew2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        wh2.c(14);
                    }
                    return;
                }
                if (z) {
                    wh2.c(1);
                }
                String d = se3.d(uw2.T(), ew2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                vh2 vh2Var = new vh2();
                vh2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    vh2Var.b = gVar.a;
                } else {
                    vh2Var.b = du2.e.i(ew2Var.H(), ew2Var.v1()).getPath() + File.separator;
                }
                vh2Var.c = nx1Var.a();
                vh2Var.d = d;
                vh2Var.f = String.valueOf(e82.a());
                vh2Var.g = vh2.c(hb3.M(), d);
                vh2Var.i = h;
                if (!b && !uw2.T().M()) {
                    z2 = false;
                    vh2Var.h = z2;
                    vh2Var.j = nx1Var.I();
                    vh2Var.l = zh2.b();
                    f0 = ew2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        vh2Var.m = f0.userActionApis;
                    }
                    H = g73.H();
                    if (H) {
                        vh2Var.k = k82.b();
                    }
                    P = ew2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            vh2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", vh2Var.toString());
                    }
                    m43.o().F(new UbcFlowEvent("master_dispatch_start"));
                    hh3.d().i("master_dispatch_start");
                    dd2Var.C(vh2Var);
                    bi2.U().U0(vh2.b(vh2Var));
                    ou2.m0().a();
                    bi2.U().h1(vh2Var.j);
                    F = g73.F(ew2Var.g0());
                    boolean p0 = ew2Var.p0();
                    if (!F) {
                        x82.d();
                        x82.g().h("appready");
                    } else if (p0) {
                        q82.e().f("appready");
                    }
                    wb3 f = uw2.T().f(ze3.b(zo3.f(d)));
                    yh2Var = new yh2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        yh2Var.a = gVar.a;
                    } else {
                        yh2Var.a = du2.e.i(ew2Var.H(), ew2Var.v1()).getPath() + File.separator;
                    }
                    yh2Var.b = d;
                    yh2Var.d = f.g;
                    yh2Var.c = h;
                    yh2Var.k = vh2Var.g;
                    yh2Var.e = String.valueOf(ew2Var.m0());
                    yh2Var.g = z2;
                    yh2Var.i = nx1Var.I();
                    yh2Var.m = true;
                    if (H) {
                        yh2Var.j = k82.d();
                    }
                    if (!F) {
                        x82.g().h("pageready");
                    } else if (p0) {
                        q82.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", yh2Var.toString());
                    }
                    m43.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    hh3.d().i("slave_dispatch_start");
                    nx1Var.J(yh2Var);
                    oo3.d();
                    nx1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    nx1Var.Q(d);
                    bi2.U().V0(nx1Var.a(), yh2.a(yh2Var));
                    rh3.F(nx1Var.a(), yh2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + vh2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + nx1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + yh2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + yh2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + yh2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                vh2Var.h = z2;
                vh2Var.j = nx1Var.I();
                vh2Var.l = zh2.b();
                f0 = ew2Var.f0();
                if (f0 != null) {
                    vh2Var.m = f0.userActionApis;
                }
                H = g73.H();
                if (H) {
                }
                P = ew2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                m43.o().F(new UbcFlowEvent("master_dispatch_start"));
                hh3.d().i("master_dispatch_start");
                dd2Var.C(vh2Var);
                bi2.U().U0(vh2.b(vh2Var));
                ou2.m0().a();
                bi2.U().h1(vh2Var.j);
                F = g73.F(ew2Var.g0());
                boolean p02 = ew2Var.p0();
                if (!F) {
                }
                wb3 f2 = uw2.T().f(ze3.b(zo3.f(d)));
                yh2Var = new yh2();
                if (gVar == null) {
                }
                yh2Var.a = du2.e.i(ew2Var.H(), ew2Var.v1()).getPath() + File.separator;
                yh2Var.b = d;
                yh2Var.d = f2.g;
                yh2Var.c = h;
                yh2Var.k = vh2Var.g;
                yh2Var.e = String.valueOf(ew2Var.m0());
                yh2Var.g = z2;
                yh2Var.i = nx1Var.I();
                yh2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                m43.o().F(new UbcFlowEvent("slave_dispatch_start"));
                hh3.d().i("slave_dispatch_start");
                nx1Var.J(yh2Var);
                oo3.d();
                nx1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                nx1Var.Q(d);
                bi2.U().V0(nx1Var.a(), yh2.a(yh2Var));
                rh3.F(nx1Var.a(), yh2Var.b);
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
        dd2 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = f53.b()) != 0 && (W = bi2.U().W()) != null) {
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
