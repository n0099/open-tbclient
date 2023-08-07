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
import com.baidu.tieba.ne3;
import com.baidu.tieba.ut2;
import com.baidu.tieba.vv2;
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
public class iw2 extends hw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes6.dex */
    public class b implements st2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv2 a;
        public final /* synthetic */ iw2 b;

        /* loaded from: classes6.dex */
        public class a implements ne3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ut2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, ut2.g gVar) {
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

            @Override // com.baidu.tieba.ne3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    y72.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.ne3.e
            public void b(int i, rm3 rm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, rm3Var) == null) {
                    y72.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    rm3 rm3Var2 = new rm3();
                    rm3Var2.k(5L);
                    rm3Var2.i(38L);
                    rm3Var2.f("download subpackage fail, errcode=" + i);
                    zh3 zh3Var = new zh3();
                    zh3Var.q(rh3.n(this.c.a.G()));
                    zh3Var.p(rm3Var2);
                    zh3Var.r(this.c.a);
                    rh3.R(zh3Var);
                }
            }
        }

        public b(iw2 iw2Var, vv2 vv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, vv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iw2Var;
            this.a = vv2Var;
        }

        @Override // com.baidu.tieba.st2
        public void a(int i, rt2 rt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, rt2Var) == null) {
                ut2.g gVar = (ut2.g) rt2Var;
                if (ne3.p(this.a, gVar)) {
                    if (ya3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = qo3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(qe3.b(f));
                        ne3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    y72.o("SwanApp", "subpackage is invalid");
                }
                this.b.W(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(iw2 iw2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, Long.valueOf(j)};
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
                ro3.g(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv2 a;

        public c(iw2 iw2Var, vv2 vv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, vv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ut2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv2 a;
        public final /* synthetic */ ut2.g b;
        public final /* synthetic */ iw2 c;

        public d(iw2 iw2Var, vv2 vv2Var, ut2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, vv2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iw2Var;
            this.a = vv2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.X(this.a, this.b);
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vv2 a;

        public e(iw2 iw2Var, vv2 vv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iw2Var, vv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vv2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && fu2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867845, "Lcom/baidu/tieba/iw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867845, "Lcom/baidu/tieba/iw2;");
                return;
            }
        }
        l = ir1.a;
    }

    public iw2() {
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

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    @Nullable
    public ya3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ya3.M();
        }
        return (ya3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return sh2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    public void E(vv2 vv2Var, st2 st2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vv2Var, st2Var) == null) {
            super.E(vv2Var, st2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + vv2Var.j0());
            }
            ut2.c(vv2Var, new b(this, vv2Var));
            sh2.U().d1(vv2Var);
            sh2.U().c1(vv2Var);
            sh2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            dh2.d();
            sh2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            ln3.j();
            xx2.b();
            oz2.y();
            vl3.u();
            PaymentPanelManager.F();
            xk3.n();
            kk3.d();
            gl3.k();
            eo2.d();
            dn4.f();
            m13.e().o();
            od3.h();
            qk3.h();
            l13.k();
            if (fu2.I() != null) {
                fu2.I().e();
            }
            p12.e().n();
            h32.b().f();
            ld3.b().k();
            pp2.d();
            k22.d().h();
            d13.g().f();
            nh2.b();
            rv2.c().a();
            s53.g().b();
            SwanPrefetchImageRes.b().e();
            xe2.g().d();
            y82.c().n();
            qq3.c().i();
        }
    }

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            y72.i("SwanApp", "onAppForeground");
            String g0 = ya3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", y43.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                hashMap.put("clkid", this.d.T().L());
                hashMap.put("scene", this.d.T().T());
                vv2.a T2 = this.d.T();
                ih3.v(T2);
                Y(T2);
            }
            u(new al2(hashMap));
            y72.i("SwanApp", "onAppShow");
            h32.b().g(false);
            xx2.h(true);
            oz2.r(false);
            m13.e().h(false);
            p12.e().j();
            l13.i();
            if (fu2.I() != null) {
                fu2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (z43.h()) {
                r43.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                sn3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, vv2 vv2Var, ut2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, vv2Var, gVar) == null) && i == 0 && vv2Var != null && gVar != null) {
            d43.o().F(new UbcFlowEvent("na_post_to_main_start"));
            so3.d0(this.k);
            d dVar = new d(this, vv2Var, gVar);
            this.k = dVar;
            so3.g0(dVar);
        }
    }

    public final void X(vv2 vv2Var, ut2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, vv2Var, gVar) == null) {
            d43.o().F(new UbcFlowEvent("na_post_to_main_end"));
            yg3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + lw2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (vv2Var.m0()) {
                n(this.d).setVisibility(0);
                v72.b(true);
                y72.i("AppsControllerImpl", "init sConsole for devHook");
            }
            y72.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            sh2.U().Z0(vv2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    public void d(vv2 vv2Var, st2 st2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, vv2Var, st2Var) == null) {
            super.d(vv2Var, st2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + vv2Var.j0());
            }
            sh2.U().d1(vv2Var);
            sh2.U().H0(null);
            SwanAppConfigData Q = xa3.K().q().Q();
            if (Q != null) {
                ut2.g gVar = new ut2.g();
                r43.e().d(new c(this, vv2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = ut2.e.i(vv2Var.H(), vv2Var.v1()).getPath() + File.separator;
                d43.o().F(new UbcFlowEvent("na_post_to_main_start"));
                yg3.d().i("na_post_to_main_start");
                X(vv2Var, gVar);
            }
        }
    }

    public final void Y(vv2 vv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, vv2Var) == null) && !TextUtils.isEmpty(vv2Var.n("fromHost")) && !TextUtils.isEmpty(vv2Var.n("spuId")) && !TextUtils.isEmpty(vv2Var.n("contentId"))) {
            so3.b0(new e(this, vv2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            xa3 K = xa3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.jw2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = lw2.T().R();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + R);
            }
            if (this.h && R <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hw2, com.baidu.tieba.jw2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            y72.i("SwanApp", "onAppBackground");
            String g0 = ya3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(ap3.b().a()));
            u(new al2(contentValues));
            y72.i("SwanApp", "onAppHide");
            ap3.b().d();
            h32.b().g(true);
            xx2.h(false);
            oz2.r(true);
            m13.e().h(true);
            l13.j(false);
            if (fu2.I() != null) {
                fu2.I().c();
            }
            ro3.h();
            w03.i();
        }
    }
}
