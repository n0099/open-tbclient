package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ow6 extends sv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ev6 e;

    @Override // com.baidu.tieba.k0
    public void c(h0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.sv6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow6(pv6 context) {
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
                super((pv6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ev6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (ev6) invokeV.objValue;
    }

    public final void l() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ev6 ev6Var = this.e;
            if (ev6Var != null) {
                ev6 c = i().c();
                if (c.j() != ev6Var.j() || c.g() != ev6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + ev6Var.j());
                    ev6Var.G();
                    ev6Var.I();
                    ev6Var.F();
                    ev6Var.C();
                }
                boolean z2 = true;
                if (c.v() == ev6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + ev6Var.v());
                    ev6Var.I();
                    ev6Var.F();
                    ev6Var.G();
                    ev6Var.C();
                }
                if (c.w() != ev6Var.w()) {
                    ev6Var.J();
                }
                if (c.u() != ev6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != ev6Var.e()) {
                    ev6Var.F();
                    ev6Var.J();
                    ev6Var.I();
                }
                if (c.n().size() != ev6Var.n().size() || c.l() != ev6Var.l()) {
                    ev6Var.D();
                }
                i().h(ev6Var);
            }
            this.e = null;
        }
    }

    public final void m(ev6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    @Override // com.baidu.tieba.k0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            l();
        }
    }
}
