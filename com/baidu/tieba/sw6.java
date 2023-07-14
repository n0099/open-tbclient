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
public final class sw6 extends wv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iv6 e;

    @Override // com.baidu.tieba.j0
    public void c(g0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.wv6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sw6(tv6 context) {
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
                super((tv6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final iv6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (iv6) invokeV.objValue;
    }

    public final void l() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            iv6 iv6Var = this.e;
            if (iv6Var != null) {
                iv6 c = i().c();
                if (c.j() != iv6Var.j() || c.g() != iv6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + iv6Var.j());
                    iv6Var.G();
                    iv6Var.I();
                    iv6Var.F();
                    iv6Var.C();
                }
                boolean z2 = true;
                if (c.v() == iv6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + iv6Var.v());
                    iv6Var.I();
                    iv6Var.F();
                    iv6Var.G();
                    iv6Var.C();
                }
                if (c.w() != iv6Var.w()) {
                    iv6Var.J();
                }
                if (c.u() != iv6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != iv6Var.e()) {
                    iv6Var.F();
                    iv6Var.J();
                    iv6Var.I();
                }
                if (c.n().size() != iv6Var.n().size() || c.l() != iv6Var.l()) {
                    iv6Var.D();
                }
                i().h(iv6Var);
            }
            this.e = null;
        }
    }

    public final void m(iv6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            this.e = danmakuConfig;
        }
    }

    @Override // com.baidu.tieba.j0
    public void update(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            l();
        }
    }
}
