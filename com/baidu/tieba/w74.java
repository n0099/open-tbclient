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
import com.baidu.tieba.eb2;
import com.baidu.tieba.l84;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w74 extends uo2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

    @Override // com.baidu.tieba.uo2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.uo2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dc3, com.baidu.tieba.yb3
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uo2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.uo2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.uo2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements pu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w74 a;

        public a(w74 w74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w74Var;
        }

        @Override // com.baidu.tieba.pu2
        public void a(int i, ou2 ou2Var) {
            l84.c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, ou2Var) == null) && (cVar = (l84.c) ou2Var) != null && !TextUtils.isEmpty(cVar.a)) {
                v74.m().I(this.a.Z());
                v74.m().x(cVar);
                y54.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements q83.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w74 a;

        public b(w74 w74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w74Var;
        }

        @Override // com.baidu.tieba.q83.c
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
                                            bo3.r(message);
                                            return true;
                                        case 124:
                                            bo3.q(message);
                                            return true;
                                        case 125:
                                            o83.b(message);
                                            return true;
                                        case 126:
                                            o83.d(message);
                                            return true;
                                        default:
                                            return false;
                                    }
                                }
                                xe2.a(message);
                                return true;
                            }
                            ub3.K().s();
                            return true;
                        }
                        vb3 M = vb3.M();
                        if (M != null) {
                            M.e0().i();
                            r33.g().v();
                        }
                        this.a.Q0();
                        v74.m().H();
                        j54.b();
                        return true;
                    }
                    boolean a = cv2.M().a();
                    cv2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.y(a, false);
                    }
                    return true;
                }
                l83.e().h(new n83(4));
                this.a.Q0();
                v74.m().H();
                ub3.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w74 a;

        public c(w74 w74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (w74.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                sc4.f(this.a.Z());
                this.a.b.P();
                a53.h("preload", "startup");
                int j = v74.m().j();
                HybridUbcFlow p = a53.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                v74.m().i(new v94(f));
                if (w74.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                ie4.A().D();
                m84.f().init();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w74 a;

        public d(w74 w74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i1();
            this.a.h1();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223477, "Lcom/baidu/tieba/w74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223477, "Lcom/baidu/tieba/w74;");
                return;
            }
        }
        r = fs1.a;
    }

    @Override // com.baidu.tieba.uo2
    @NonNull
    public q83.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new b(this);
        }
        return (q83.c) invokeV.objValue;
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.uo2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (ub3.K().q().Y().d0() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public dj2 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return v74.m().n();
        }
        return (dj2) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ie4.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ie4.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.q > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            pp3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            ke4.q();
            je4.b();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.baidu.tieba.uo2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            v74.m().h(this.b);
        }
    }

    @Override // com.baidu.tieba.uo2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ix2.T().registerReceiver(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w74(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.uo2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            oi3.E();
            if (z2) {
                sc4.f(Z());
                j54.b();
            }
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (!ub3.K().E()) {
                return;
            }
            ix2.T().E(Z(), new a(this));
            if (v74.m().v() && v74.m().q()) {
                v74.m().F(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.uo2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            i54.v();
            ao2.i();
            sc4.e("exit", Z());
            ix2.T().unregisterReceiver(this.b);
            ix2.a0();
            be4.a().b();
            SwanInspectorEndpoint.v().q();
            mc4.c().b();
            ja4.b().e();
        }
    }

    @Override // com.baidu.tieba.uo2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            v82.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            yi3 yi3Var = new yi3();
            yi3Var.e = "back";
            Q(yi3Var);
            bb2 m = this.c.m();
            if (m != null && m.H()) {
                return;
            }
            if (e0()) {
                vb3 M = vb3.M();
                if (M != null) {
                    M.P().E();
                }
                sc4.e("back", Z());
                j54.g("0");
                return;
            }
            eb2.b i = this.c.i("navigateBack");
            i.n(eb2.i, eb2.h);
            i.g();
            i.a();
        }
    }

    public final void m1() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !q().I()) {
            return;
        }
        if (kp3.f(Z().a0())) {
            if (r) {
                Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
            }
            v74.C();
            return;
        }
        SwanCoreVersion j0 = Z().j0();
        if (j0 != null && kp3.f(j0.swanCoreVersionName) && rw2.a(Z().S())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
            }
            v74.C();
        }
    }

    @Override // com.baidu.tieba.uo2
    public void m0() {
        String K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            mc4.c().b();
            ja4.b().e();
            q().J(true);
            e1();
            if (Z() == null) {
                K = "";
            } else {
                K = Z().K();
            }
            V8Engine.setCrashKeyValue("game_title", K);
        }
    }
}
