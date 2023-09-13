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
public final class qv6 extends n0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final pv6 j;
    public final nx6 k;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948105336, "Lcom/baidu/tieba/qv6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948105336, "Lcom/baidu/tieba/qv6;");
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

        public static /* synthetic */ qv6 c(a aVar, gx6 gx6Var, yw6 yw6Var, int i, Object obj) {
            if ((i & 2) != 0) {
                yw6Var = aVar.a();
            }
            return aVar.b(gx6Var, yw6Var);
        }

        public final cx6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new cx6(new zw6(), TuplesKt.to(5, new ax6()), TuplesKt.to(1, new bx6()), TuplesKt.to(4, new xw6()));
            }
            return (cx6) invokeV.objValue;
        }

        public final qv6 b(gx6 renderer, yw6 layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new qv6(renderer, layouter);
            }
            return (qv6) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qv6(gx6 renderer, yw6 layouter) {
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
        pv6 pv6Var = new pv6(renderer);
        this.j = pv6Var;
        this.k = pv6Var.f();
        ow6 ow6Var = new ow6(this.j);
        ow6Var.a = 1;
        g(ow6Var);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        g(dataSystem);
        qw6 qw6Var = new qw6(this.j);
        qw6Var.a = 3;
        g(qw6Var);
        mw6 mw6Var = new mw6(this.j);
        mw6Var.a = 4;
        g(mw6Var);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        g(renderSystem);
        qw6 qw6Var2 = (qw6) k(qw6.class);
        if (qw6Var2 != null) {
            qw6Var2.o(layouter);
        }
    }

    public static /* synthetic */ void E(qv6 qv6Var, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        qv6Var.D(f);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.d(true);
            s0<k0> systems = l();
            Intrinsics.checkNotNullExpressionValue(systems, "systems");
            for (k0 k0Var : systems) {
                p(k0Var);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nx6.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final ev6 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ow6 ow6Var = (ow6) k(ow6.class);
            if (ow6Var != null) {
                return ow6Var.k();
            }
            return null;
        }
        return (ev6) invokeV.objValue;
    }

    public final pv6 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (pv6) invokeV.objValue;
    }

    public final long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k.a();
        }
        return invokeV.longValue;
    }

    public final nx6 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (nx6) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k.c();
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.d(true);
        }
    }

    public final void z() {
        DataSystem dataSystem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (dataSystem = (DataSystem) k(DataSystem.class)) != null) {
            dataSystem.D();
        }
    }

    public final void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            nx6.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void D(Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f) == null) {
            vw6.b("Engine_step");
            this.k.g(f);
            vw6.a();
        }
    }

    public final void F(ev6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            ow6 ow6Var = (ow6) k(ow6.class);
            if (ow6Var != null) {
                ow6Var.m(danmakuConfig);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vw6.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            nx6 nx6Var = this.k;
            long a2 = nx6Var.a() - this.l;
            update(nx6Var.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = nx6Var.a();
            vw6.a();
        }
    }

    public final void s(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            RenderSystem renderSystem = (RenderSystem) k(RenderSystem.class);
            if (renderSystem != null) {
                renderSystem.k(canvas, onRenderReady);
            }
        }
    }
}
