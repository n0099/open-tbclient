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
import com.baidu.tieba.e93;
import com.baidu.tieba.lo2;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class zq2 extends yq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes9.dex */
    public class b implements jo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ zq2 b;

        /* loaded from: classes9.dex */
        public class a implements e93.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ lo2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, lo2.g gVar) {
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

            @Override // com.baidu.tieba.e93.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    p22.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.Y(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.e93.e
            public void b(int i, ih3 ih3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                    p22.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.S0(null);
                    b bVar = this.c;
                    bVar.b.Y(this.a, bVar.a, this.b);
                    ih3 ih3Var2 = new ih3();
                    ih3Var2.k(5L);
                    ih3Var2.i(38L);
                    ih3Var2.f("download subpackage fail, errcode=" + i);
                    qc3 qc3Var = new qc3();
                    qc3Var.q(ic3.n(this.c.a.H()));
                    qc3Var.p(ih3Var2);
                    qc3Var.r(this.c.a);
                    ic3.R(qc3Var);
                }
            }
        }

        public b(zq2 zq2Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq2Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zq2Var;
            this.a = mq2Var;
        }

        @Override // com.baidu.tieba.jo2
        public void a(int i, io2 io2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, io2Var) == null) {
                lo2.g gVar = (lo2.g) io2Var;
                if (e93.p(this.a, gVar)) {
                    if (p53.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = hj3.f(this.a.f0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(h93.b(f));
                        e93.m(this.a.I(), this.a.x1(), "3", str, gVar.b.d.a.get(str), this.b.D(), new a(this, i, gVar));
                        return;
                    }
                    p22.o("SwanApp", "subpackage is invalid");
                }
                this.b.Y(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(zq2 zq2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq2Var, Long.valueOf(j)};
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
                ij3.g(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;

        public c(zq2 zq2Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq2Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lo2.e.c(this.a.I(), this.a.x1());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;
        public final /* synthetic */ lo2.g b;
        public final /* synthetic */ zq2 c;

        public d(zq2 zq2Var, mq2 mq2Var, lo2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq2Var, mq2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zq2Var;
            this.a = mq2Var;
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

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mq2 a;

        public e(zq2 zq2Var, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zq2Var, mq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mq2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && wo2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948368526, "Lcom/baidu/tieba/zq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948368526, "Lcom/baidu/tieba/zq2;");
                return;
            }
        }
        l = am1.a;
    }

    public zq2() {
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

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    @Nullable
    public p53 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return p53.M();
        }
        return (p53) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return jc2.V().e0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void G(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mq2Var, jo2Var) == null) {
            super.G(mq2Var, jo2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + mq2Var.k0());
            }
            lo2.c(mq2Var, new b(this, mq2Var));
            jc2.V().e1(mq2Var);
            jc2.V().d1(mq2Var);
            jc2.V().I0(null);
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.P();
            ub2.d();
            jc2.O0(false);
            if (this.a != null) {
                this.a = null;
            }
            ci3.j();
            os2.b();
            fu2.y();
            mg3.u();
            PaymentPanelManager.F();
            of3.n();
            bf3.d();
            xf3.k();
            vi2.d();
            uh4.f();
            dw2.e().o();
            f83.h();
            hf3.i();
            cw2.k();
            if (wo2.I() != null) {
                wo2.I().e();
            }
            hw1.e().n();
            zx1.b().f();
            c83.b().k();
            gk2.d();
            cx1.d().h();
            uv2.g().f();
            ec2.b();
            iq2.c().a();
            j03.g().b();
            SwanPrefetchImageRes.b().e();
            o92.g().d();
            p32.c().n();
            hl3.c().i();
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.w();
            p22.i("SwanApp", "onAppForeground");
            String h0 = p53.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, h0);
            hashMap.put("launchId", pz2.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().M());
                hashMap.put("scene", this.d.S().U());
                mq2.a S = this.d.S();
                zb3.v(S);
                a0(S);
            }
            v(new rf2(hashMap));
            p22.i("SwanApp", "onAppShow");
            zx1.b().g(false);
            os2.h(true);
            fu2.r(false);
            dw2.e().h(false);
            hw1.e().j();
            cw2.i();
            if (wo2.I() != null) {
                wo2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (qz2.h()) {
                iz2.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                ji3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void Y(int i, mq2 mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, mq2Var, gVar) == null) && i == 0 && mq2Var != null && gVar != null) {
            uy2.o().F(new UbcFlowEvent("na_post_to_main_start"));
            jj3.d0(this.k);
            d dVar = new d(this, mq2Var, gVar);
            this.k = dVar;
            jj3.g0(dVar);
        }
    }

    public final void Z(mq2 mq2Var, lo2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, mq2Var, gVar) == null) {
            uy2.o().F(new UbcFlowEvent("na_post_to_main_end"));
            pb3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + cr2.V().A())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            b0(gVar.b);
            if (mq2Var.n0()) {
                o(this.d).setVisibility(0);
                m22.b(true);
                p22.i("AppsControllerImpl", "init sConsole for devHook");
            }
            p22.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            jc2.V().a1(mq2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void d(mq2 mq2Var, jo2 jo2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, mq2Var, jo2Var) == null) {
            super.d(mq2Var, jo2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + mq2Var.k0());
            }
            jc2.V().e1(mq2Var);
            jc2.V().I0(null);
            SwanAppConfigData R = o53.K().q().R();
            if (R != null) {
                lo2.g gVar = new lo2.g();
                iz2.e().d(new c(this, mq2Var), "deleteLowerVersionFolder", true);
                gVar.b = R;
                gVar.a = lo2.e.i(mq2Var.I(), mq2Var.x1()).getPath() + File.separator;
                uy2.o().F(new UbcFlowEvent("na_post_to_main_start"));
                pb3.d().i("na_post_to_main_start");
                Z(mq2Var, gVar);
            }
        }
    }

    public final void a0(mq2 mq2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, mq2Var) == null) && !TextUtils.isEmpty(mq2Var.n("fromHost")) && !TextUtils.isEmpty(mq2Var.n("spuId")) && !TextUtils.isEmpty(mq2Var.n("contentId"))) {
            jj3.b0(new e(this, mq2Var), 2000L);
        }
    }

    public final void b0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            o53 K = o53.K();
            if (K.E()) {
                K.q().H0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.ar2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long T2 = cr2.V().T();
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

    @Override // com.baidu.tieba.yq2, com.baidu.tieba.ar2
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.x();
            p22.i("SwanApp", "onAppBackground");
            String h0 = p53.h0();
            if (TextUtils.isEmpty(h0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, h0);
            contentValues.put("hiddenType", Integer.valueOf(rj3.b().a()));
            v(new rf2(contentValues));
            p22.i("SwanApp", "onAppHide");
            rj3.b().d();
            zx1.b().g(true);
            os2.h(false);
            fu2.r(true);
            dw2.e().h(true);
            cw2.j(false);
            if (wo2.I() != null) {
                wo2.I().c();
            }
            ij3.h();
            nv2.i();
        }
    }
}
