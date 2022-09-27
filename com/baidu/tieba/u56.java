package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class u56 extends y46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k46 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u56(v46 context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((v46) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.r0
    public void c(o0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.y46
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final k46 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (k46) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k46 k46Var = this.e;
            if (k46Var != null) {
                k46 c = i().c();
                if (c.j() != k46Var.j() || c.g() != k46Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + k46Var.j());
                    k46Var.G();
                    k46Var.I();
                    k46Var.F();
                    k46Var.C();
                }
                if (!(c.v() == k46Var.v())) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + k46Var.v());
                    k46Var.I();
                    k46Var.F();
                    k46Var.G();
                    k46Var.C();
                }
                if (c.w() != k46Var.w()) {
                    k46Var.J();
                }
                if (!(c.u() == k46Var.u()) || c.e() != k46Var.e()) {
                    k46Var.F();
                    k46Var.J();
                    k46Var.I();
                }
                if (c.n().size() != k46Var.n().size() || c.l() != k46Var.l()) {
                    k46Var.D();
                }
                i().h(k46Var);
            }
            this.e = null;
        }
    }

    public final void m(k46 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    @Override // com.baidu.tieba.r0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            l();
        }
    }
}
