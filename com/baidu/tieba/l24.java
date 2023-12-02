package com.baidu.tieba;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.a34;
import com.baidu.tieba.f33;
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l24 extends jj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

    @Override // com.baidu.tieba.jj2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jj2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.s63, com.baidu.tieba.n63
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jj2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jj2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jj2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ep2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l24 a;

        public a(l24 l24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l24Var;
        }

        @Override // com.baidu.tieba.ep2
        public void a(int i, dp2 dp2Var) {
            a34.c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, dp2Var) == null) && (cVar = (a34.c) dp2Var) != null && !TextUtils.isEmpty(cVar.a)) {
                k24.m().I(this.a.Z());
                k24.m().x(cVar);
                n04.h();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f33.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l24 a;

        public b(l24 l24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l24Var;
        }

        @Override // com.baidu.tieba.f33.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i != 102) {
                        if (i != 103) {
                            if (i != 106) {
                                if (i != 107) {
                                    switch (i) {
                                        case 123:
                                            qi3.r(message);
                                            return true;
                                        case 124:
                                            qi3.q(message);
                                            return true;
                                        case 125:
                                            d33.b(message);
                                            return true;
                                        case 126:
                                            d33.d(message);
                                            return true;
                                        default:
                                            return false;
                                    }
                                }
                                m92.a(message);
                                return true;
                            }
                            j63.K().s();
                            return true;
                        }
                        k63 M = k63.M();
                        if (M != null) {
                            M.f0().i();
                            gy2.g().v();
                        }
                        this.a.Q0();
                        k24.m().H();
                        yz3.b();
                        return true;
                    }
                    boolean a = rp2.M().a();
                    rp2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.z(a, false);
                    }
                    return true;
                }
                a33.e().h(new c33(4));
                this.a.Q0();
                k24.m().H();
                j63.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l24 a;

        public c(l24 l24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l24Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (l24.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                h74.f(this.a.Z());
                this.a.b.P();
                pz2.h("preload", "startup");
                int j = k24.m().j();
                HybridUbcFlow p = pz2.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                k24.m().i(new k44(f));
                if (l24.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                x84.A().D();
                b34.f().init();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l24 a;

        public d(l24 l24Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l24Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l24Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.j1();
            this.a.i1();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947890971, "Lcom/baidu/tieba/l24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947890971, "Lcom/baidu/tieba/l24;");
                return;
            }
        }
        r = vm1.a;
    }

    @Override // com.baidu.tieba.jj2
    @NonNull
    public f33.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new b(this);
        }
        return (f33.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jj2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (j63.K().q().Z().e0() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public sd2 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return k24.m().n();
        }
        return (sd2) invokeV.objValue;
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            x84.A().m();
        }
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            x84.A().F();
        }
    }

    public boolean k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.q > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            ek3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            z84.q();
            y84.b();
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.baidu.tieba.jj2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            k24.m().h(this.b);
        }
    }

    @Override // com.baidu.tieba.jj2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            xr2.V().E(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l24(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.jj2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            dd3.E();
            if (z2) {
                h74.f(Z());
                yz3.b();
            }
        }
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            m1();
            if (!j63.K().E()) {
                return;
            }
            xr2.V().G(Z(), new a(this));
            if (k24.m().v() && k24.m().q()) {
                k24.m().F(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.jj2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            xz3.w();
            pi2.i();
            h74.e("exit", Z());
            xr2.V().l(this.b);
            xr2.c0();
            q84.a().b();
            SwanInspectorEndpoint.v().q();
            b74.c().b();
            y44.b().e();
        }
    }

    @Override // com.baidu.tieba.jj2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            k32.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            nd3 nd3Var = new nd3();
            nd3Var.e = "back";
            Q(nd3Var);
            q52 m = this.c.m();
            if (m != null && m.G()) {
                return;
            }
            if (e0()) {
                k63 M = k63.M();
                if (M != null) {
                    M.Q().E();
                }
                h74.e("back", Z());
                yz3.g("0");
                return;
            }
            t52.b i = this.c.i("navigateBack");
            i.n(t52.i, t52.h);
            i.g();
            i.a();
        }
    }

    public final void n1() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !q().I()) {
            return;
        }
        if (zj3.f(Z().b0())) {
            if (r) {
                Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().b0());
            }
            k24.C();
            return;
        }
        SwanCoreVersion k0 = Z().k0();
        if (k0 != null && zj3.f(k0.swanCoreVersionName) && gr2.a(Z().T())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
            }
            k24.C();
        }
    }

    @Override // com.baidu.tieba.jj2
    public void m0() {
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            n1();
            b74.c().b();
            y44.b().e();
            q().J(true);
            f1();
            if (Z() == null) {
                L = "";
            } else {
                L = Z().L();
            }
            V8Engine.setCrashKeyValue("game_title", L);
        }
    }
}
