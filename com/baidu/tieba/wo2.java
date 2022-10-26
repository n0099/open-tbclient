package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.b73;
import com.baidu.tieba.im2;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class wo2 extends vo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class b implements gm2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;
        public final /* synthetic */ wo2 b;

        /* loaded from: classes6.dex */
        public class a implements b73.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ im2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, im2.g gVar) {
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

            @Override // com.baidu.tieba.b73.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    m02.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.b73.e
            public void b(int i, ff3 ff3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ff3Var) == null) {
                    m02.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    ff3 ff3Var2 = new ff3();
                    ff3Var2.k(5L);
                    ff3Var2.i(38L);
                    ff3Var2.f("download subpackage fail, errcode=" + i);
                    na3 na3Var = new na3();
                    na3Var.q(fa3.n(this.c.a.G()));
                    na3Var.p(ff3Var2);
                    na3Var.r(this.c.a);
                    fa3.R(na3Var);
                }
            }
        }

        public b(wo2 wo2Var, jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var, jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wo2Var;
            this.a = jo2Var;
        }

        @Override // com.baidu.tieba.gm2
        public void a(int i, fm2 fm2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, fm2Var) == null) {
                im2.g gVar = (im2.g) fm2Var;
                if (b73.p(this.a, gVar)) {
                    if (m33.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = eh3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = (String) gVar.b.c.c.get(e73.b(f));
                        b73.m(this.a.H(), this.a.v1(), "3", str, (String) gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    m02.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(wo2 wo2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var, Long.valueOf(j)};
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
                fh3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;

        public c(wo2 wo2Var, jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var, jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                im2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;
        public final /* synthetic */ im2.g b;
        public final /* synthetic */ wo2 c;

        public d(wo2 wo2Var, jo2 jo2Var, im2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var, jo2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wo2Var;
            this.a = jo2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.Y(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jo2 a;

        public e(wo2 wo2Var, jo2 jo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wo2Var, jo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && tm2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948277231, "Lcom/baidu/tieba/wo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948277231, "Lcom/baidu/tieba/wo2;");
                return;
            }
        }
        l = wj1.a;
    }

    public wo2() {
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

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public m33 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return m33.M();
        }
        return (m33) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ga2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public void E(jo2 jo2Var, gm2 gm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jo2Var, gm2Var) == null) {
            super.E(jo2Var, gm2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + jo2Var.j0());
            }
            im2.c(jo2Var, new b(this, jo2Var));
            ga2.U().d1(jo2Var);
            ga2.U().c1(jo2Var);
            ga2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            r92.d();
            ga2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            zf3.j();
            lq2.b();
            cs2.y();
            je3.u();
            PaymentPanelManager.F();
            ld3.n();
            yc3.d();
            ud3.k();
            sg2.d();
            rf4.f();
            au2.e().o();
            c63.h();
            ed3.h();
            zt2.k();
            if (tm2.I() != null) {
                tm2.I().e();
            }
            du1.e().n();
            vv1.b().f();
            z53.b().k();
            di2.d();
            yu1.d().h();
            rt2.g().f();
            ba2.b();
            fo2.c().a();
            gy2.g().b();
            SwanPrefetchImageRes.b().e();
            l72.g().d();
            m12.c().n();
            ej3.c().i();
        }
    }

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            m02.i("SwanApp", "onAppForeground");
            String g0 = m33.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", mx2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                jo2.a S = this.d.S();
                w93.v(S);
                Z(S);
            }
            u(new od2(hashMap));
            m02.i("SwanApp", "onAppShow");
            vv1.b().g(false);
            lq2.h(true);
            cs2.r(false);
            au2.e().h(false);
            du1.e().j();
            zt2.i();
            if (tm2.I() != null) {
                tm2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (nx2.h()) {
                fx2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                gg3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void X(int i, jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, jo2Var, gVar) == null) && i == 0 && jo2Var != null && gVar != null) {
            rw2.o().F(new UbcFlowEvent("na_post_to_main_start"));
            gh3.d0(this.k);
            d dVar = new d(this, jo2Var, gVar);
            this.k = dVar;
            gh3.g0(dVar);
        }
    }

    public final void Y(jo2 jo2Var, im2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, jo2Var, gVar) == null) {
            rw2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            m93.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + zo2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (jo2Var.m0()) {
                n(this.d).setVisibility(0);
                j02.b(true);
                m02.i("AppsControllerImpl", "init sConsole for devHook");
            }
            m02.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            ga2.U().Z0(jo2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public void d(jo2 jo2Var, gm2 gm2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jo2Var, gm2Var) == null) {
            super.d(jo2Var, gm2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + jo2Var.j0());
            }
            ga2.U().d1(jo2Var);
            ga2.U().H0(null);
            SwanAppConfigData Q = l33.K().q().Q();
            if (Q != null) {
                im2.g gVar = new im2.g();
                fx2.e().d(new c(this, jo2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = im2.e.i(jo2Var.H(), jo2Var.v1()).getPath() + File.separator;
                rw2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                m93.d().i("na_post_to_main_start");
                Y(jo2Var, gVar);
            }
        }
    }

    public final void Z(jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, jo2Var) == null) && !TextUtils.isEmpty(jo2Var.n("fromHost")) && !TextUtils.isEmpty(jo2Var.n("spuId")) && !TextUtils.isEmpty(jo2Var.n("contentId"))) {
            gh3.b0(new e(this, jo2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            l33 K = l33.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.xo2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = zo2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            if (this.h && S <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vo2, com.baidu.tieba.xo2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            m02.i("SwanApp", "onAppBackground");
            String g0 = m33.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(oh3.b().a()));
            u(new od2(contentValues));
            m02.i("SwanApp", "onAppHide");
            oh3.b().d();
            vv1.b().g(true);
            lq2.h(false);
            cs2.r(true);
            au2.e().h(true);
            zt2.j(false);
            if (tm2.I() != null) {
                tm2.I().c();
            }
            fh3.h();
            kt2.i();
        }
    }
}
