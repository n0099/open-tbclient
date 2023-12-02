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
public final class it6 extends ms6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yr6 e;

    @Override // com.baidu.tieba.a1
    public void c(x0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.ms6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public it6(js6 context) {
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
                super((js6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.baidu.tieba.a1
    public void i(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            m();
        }
    }

    public final void n(yr6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    public final yr6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (yr6) invokeV.objValue;
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            yr6 yr6Var = this.e;
            if (yr6Var != null) {
                yr6 c = j().c();
                if (c.j() != yr6Var.j() || c.g() != yr6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + yr6Var.j());
                    yr6Var.G();
                    yr6Var.I();
                    yr6Var.F();
                    yr6Var.C();
                }
                boolean z2 = true;
                if (c.v() == yr6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + yr6Var.v());
                    yr6Var.I();
                    yr6Var.F();
                    yr6Var.G();
                    yr6Var.C();
                }
                if (c.w() != yr6Var.w()) {
                    yr6Var.J();
                }
                if (c.u() != yr6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != yr6Var.e()) {
                    yr6Var.F();
                    yr6Var.J();
                    yr6Var.I();
                }
                if (c.n().size() != yr6Var.n().size() || c.l() != yr6Var.l()) {
                    yr6Var.D();
                }
                j().h(yr6Var);
            }
            this.e = null;
        }
    }
}
