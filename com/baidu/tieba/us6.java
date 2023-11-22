package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class us6 extends yr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kr6 e;

    @Override // com.baidu.tieba.a1
    public void c(x0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.yr6
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public us6(vr6 context) {
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
                super((vr6) newInitContext.callArgs[0]);
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

    public final void n(kr6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    public final kr6 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (kr6) invokeV.objValue;
    }

    public final void m() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            kr6 kr6Var = this.e;
            if (kr6Var != null) {
                kr6 c = j().c();
                if (c.j() != kr6Var.j() || c.g() != kr6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + kr6Var.j());
                    kr6Var.G();
                    kr6Var.I();
                    kr6Var.F();
                    kr6Var.C();
                }
                boolean z2 = true;
                if (c.v() == kr6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + kr6Var.v());
                    kr6Var.I();
                    kr6Var.F();
                    kr6Var.G();
                    kr6Var.C();
                }
                if (c.w() != kr6Var.w()) {
                    kr6Var.J();
                }
                if (c.u() != kr6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != kr6Var.e()) {
                    kr6Var.F();
                    kr6Var.J();
                    kr6Var.I();
                }
                if (c.n().size() != kr6Var.n().size() || c.l() != kr6Var.l()) {
                    kr6Var.D();
                }
                j().h(kr6Var);
            }
            this.e = null;
        }
    }
}
