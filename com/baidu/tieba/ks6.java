package com.baidu.tieba;

import android.graphics.Canvas;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ecs.system.DataSystem;
import com.baidu.tieba.danmu.ecs.system.RenderSystem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ks6 extends d1 {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final js6 j;
    public final hu6 k;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947923707, "Lcom/baidu/tieba/ks6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947923707, "Lcom/baidu/tieba/ks6;");
                return;
            }
        }
        m = new a(null);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static /* synthetic */ ks6 c(a aVar, au6 au6Var, st6 st6Var, int i, Object obj) {
            if ((i & 2) != 0) {
                st6Var = aVar.a();
            }
            return aVar.b(au6Var, st6Var);
        }

        public final wt6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new wt6(new tt6(), TuplesKt.to(5, new ut6()), TuplesKt.to(1, new vt6()), TuplesKt.to(4, new rt6()));
            }
            return (wt6) invokeV.objValue;
        }

        public final ks6 b(au6 renderer, st6 layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new ks6(renderer, layouter);
            }
            return (ks6) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ks6(au6 renderer, st6 layouter) {
        super(200, 1000, 200, 1500);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderer, layouter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        js6 js6Var = new js6(renderer);
        this.j = js6Var;
        this.k = js6Var.f();
        it6 it6Var = new it6(this.j);
        it6Var.a = 1;
        g(it6Var);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        g(dataSystem);
        kt6 kt6Var = new kt6(this.j);
        kt6Var.a = 3;
        g(kt6Var);
        gt6 gt6Var = new gt6(this.j);
        gt6Var.a = 4;
        g(gt6Var);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        g(renderSystem);
        kt6 kt6Var2 = (kt6) k(kt6.class);
        if (kt6Var2 != null) {
            kt6Var2.p(layouter);
        }
    }

    public static /* synthetic */ void F(ks6 ks6Var, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        ks6Var.E(f);
    }

    public final void A() {
        DataSystem dataSystem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dataSystem = (DataSystem) k(DataSystem.class)) != null) {
            dataSystem.E();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hu6.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final yr6 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            it6 it6Var = (it6) k(it6.class);
            if (it6Var != null) {
                return it6Var.l();
            }
            return null;
        }
        return (yr6) invokeV.objValue;
    }

    public final js6 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (js6) invokeV.objValue;
    }

    public final long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k.a();
        }
        return invokeV.longValue;
    }

    public final hu6 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (hu6) invokeV.objValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k.c();
        }
        return invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.d(true);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.d(true);
            i1<a1> systems = l();
            Intrinsics.checkNotNullExpressionValue(systems, "systems");
            for (a1 a1Var : systems) {
                p(a1Var);
            }
        }
    }

    public final void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            hu6.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void E(Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f) == null) {
            pt6.b("Engine_step");
            this.k.g(f);
            pt6.a();
        }
    }

    public final void G(yr6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            it6 it6Var = (it6) k(it6.class);
            if (it6Var != null) {
                it6Var.n(danmakuConfig);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            pt6.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            hu6 hu6Var = this.k;
            long a2 = hu6Var.a() - this.l;
            q(hu6Var.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = hu6Var.a();
            pt6.a();
        }
    }

    public final void t(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            RenderSystem renderSystem = (RenderSystem) k(RenderSystem.class);
            if (renderSystem != null) {
                renderSystem.l(canvas, onRenderReady);
            }
        }
    }
}
