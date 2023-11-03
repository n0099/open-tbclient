package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.cp2;
import com.baidu.tieba.dr2;
import com.baidu.tieba.v93;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class qr2 extends pr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes8.dex */
    public class b implements ap2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr2 a;
        public final /* synthetic */ qr2 b;

        /* loaded from: classes8.dex */
        public class a implements v93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ cp2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, cp2.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = i;
                this.b = gVar;
            }

            @Override // com.baidu.tieba.v93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    g32.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.Y(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.v93.e
            public void b(int i, zh3 zh3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, zh3Var) == null) {
                    g32.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.S0(null);
                    b bVar = this.c;
                    bVar.b.Y(this.a, bVar.a, this.b);
                    zh3 zh3Var2 = new zh3();
                    zh3Var2.k(5L);
                    zh3Var2.i(38L);
                    zh3Var2.f("download subpackage fail, errcode=" + i);
                    hd3 hd3Var = new hd3();
                    hd3Var.q(zc3.n(this.c.a.H()));
                    hd3Var.p(zh3Var2);
                    hd3Var.r(this.c.a);
                    zc3.R(hd3Var);
                }
            }
        }

        public b(qr2 qr2Var, dr2 dr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr2Var, dr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qr2Var;
            this.a = dr2Var;
        }

        @Override // com.baidu.tieba.ap2
        public void a(int i, zo2 zo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, zo2Var) == null) {
                cp2.g gVar = (cp2.g) zo2Var;
                if (v93.p(this.a, gVar)) {
                    if (g63.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = yj3.f(this.a.f0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(y93.b(f));
                        v93.m(this.a.I(), this.a.x1(), "3", str, gVar.b.d.a.get(str), this.b.D(), new a(this, i, gVar));
                        return;
                    }
                    g32.o("SwanApp", "subpackage is invalid");
                }
                this.b.Y(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(qr2 qr2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr2Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zj3.g(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr2 a;

        public c(qr2 qr2Var, dr2 dr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr2Var, dr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cp2.e.c(this.a.I(), this.a.x1());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr2 a;
        public final /* synthetic */ cp2.g b;
        public final /* synthetic */ qr2 c;

        public d(qr2 qr2Var, dr2 dr2Var, cp2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr2Var, dr2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qr2Var;
            this.a = dr2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.Z(this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dr2 a;

        public e(qr2 qr2Var, dr2 dr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qr2Var, dr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dr2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && np2.s0().a(n, n2, n3)) {
                    this.a.z("fromHost", null);
                    this.a.z("spuId", null);
                    this.a.z("contentId", null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948101368, "Lcom/baidu/tieba/qr2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948101368, "Lcom/baidu/tieba/qr2;");
                return;
            }
        }
        l = rm1.a;
    }

    public qr2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    @Nullable
    public g63 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return g63.M();
        }
        return (g63) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ad2.V().e0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void G(dr2 dr2Var, ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dr2Var, ap2Var) == null) {
            super.G(dr2Var, ap2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + dr2Var.k0());
            }
            cp2.c(dr2Var, new b(this, dr2Var));
            ad2.V().e1(dr2Var);
            ad2.V().d1(dr2Var);
            ad2.V().I0(null);
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.P();
            lc2.d();
            ad2.O0(false);
            if (this.a != null) {
                this.a = null;
            }
            ti3.j();
            ft2.b();
            wu2.y();
            dh3.u();
            PaymentPanelManager.F();
            fg3.n();
            sf3.d();
            og3.k();
            mj2.d();
            li4.f();
            uw2.e().o();
            w83.h();
            yf3.i();
            tw2.k();
            if (np2.I() != null) {
                np2.I().e();
            }
            yw1.e().n();
            qy1.b().f();
            t83.b().k();
            xk2.d();
            tx1.d().h();
            lw2.g().f();
            vc2.b();
            zq2.c().a();
            a13.g().b();
            SwanPrefetchImageRes.b().e();
            fa2.g().d();
            g42.c().n();
            yl3.c().i();
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.w();
            g32.i("SwanApp", "onAppForeground");
            String h0 = g63.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, h0);
            hashMap.put("launchId", g03.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                hashMap.put("clkid", this.d.T().M());
                hashMap.put("scene", this.d.T().U());
                dr2.a T2 = this.d.T();
                qc3.v(T2);
                a0(T2);
            }
            v(new ig2(hashMap));
            g32.i("SwanApp", "onAppShow");
            qy1.b().g(false);
            ft2.h(true);
            wu2.r(false);
            uw2.e().h(false);
            yw1.e().j();
            tw2.i();
            if (np2.I() != null) {
                np2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (h03.h()) {
                zz2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                aj3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void Y(int i, dr2 dr2Var, cp2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, dr2Var, gVar) == null) && i == 0 && dr2Var != null && gVar != null) {
            lz2.o().F(new UbcFlowEvent("na_post_to_main_start"));
            ak3.d0(this.k);
            d dVar = new d(this, dr2Var, gVar);
            this.k = dVar;
            ak3.g0(dVar);
        }
    }

    public final void Z(dr2 dr2Var, cp2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, dr2Var, gVar) == null) {
            lz2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            gc3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + tr2.V().A())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            b0(gVar.b);
            if (dr2Var.n0()) {
                o(this.d).setVisibility(0);
                d32.b(true);
                g32.i("AppsControllerImpl", "init sConsole for devHook");
            }
            g32.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            ad2.V().a1(dr2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void d(dr2 dr2Var, ap2 ap2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, dr2Var, ap2Var) == null) {
            super.d(dr2Var, ap2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + dr2Var.k0());
            }
            ad2.V().e1(dr2Var);
            ad2.V().I0(null);
            SwanAppConfigData R = f63.K().q().R();
            if (R != null) {
                cp2.g gVar = new cp2.g();
                zz2.e().d(new c(this, dr2Var), "deleteLowerVersionFolder", true);
                gVar.b = R;
                gVar.a = cp2.e.i(dr2Var.I(), dr2Var.x1()).getPath() + File.separator;
                lz2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                gc3.d().i("na_post_to_main_start");
                Z(dr2Var, gVar);
            }
        }
    }

    public final void a0(dr2 dr2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dr2Var) == null) && !TextUtils.isEmpty(dr2Var.n("fromHost")) && !TextUtils.isEmpty(dr2Var.n("spuId")) && !TextUtils.isEmpty(dr2Var.n("contentId"))) {
            ak3.b0(new e(this, dr2Var), 2000L);
        }
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            f63 K = f63.K();
            if (K.E()) {
                K.q().H0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.rr2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long T2 = tr2.V().T();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + T2);
            }
            if (this.h && T2 <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pr2, com.baidu.tieba.rr2
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.x();
            g32.i("SwanApp", "onAppBackground");
            String h0 = g63.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, h0);
            contentValues.put("hiddenType", Integer.valueOf(ik3.b().a()));
            v(new ig2(contentValues));
            g32.i("SwanApp", "onAppHide");
            ik3.b().d();
            qy1.b().g(true);
            ft2.h(false);
            wu2.r(true);
            uw2.e().h(true);
            tw2.j(false);
            if (np2.I() != null) {
                np2.I().c();
            }
            zj3.h();
            ew2.i();
        }
    }
}
