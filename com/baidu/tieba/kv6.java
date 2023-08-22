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
public final class kv6 extends ou6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public au6 e;

    @Override // com.baidu.tieba.j0
    public void c(g0 engine) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, engine) == null) {
            Intrinsics.checkNotNullParameter(engine, "engine");
        }
    }

    @Override // com.baidu.tieba.ou6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv6(lu6 context) {
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
                super((lu6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final au6 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (au6) invokeV.objValue;
    }

    public final void l() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            au6 au6Var = this.e;
            if (au6Var != null) {
                au6 c = i().c();
                if (c.j() != au6Var.j() || c.g() != au6Var.g()) {
                    BdLog.w("DanmakuEngine [Config] density from " + c.j() + " to " + au6Var.j());
                    au6Var.G();
                    au6Var.I();
                    au6Var.F();
                    au6Var.C();
                }
                boolean z2 = true;
                if (c.v() == au6Var.v()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    BdLog.w("DanmakuEngine [Config] textSizeScale change from " + c.v() + " to " + au6Var.v());
                    au6Var.I();
                    au6Var.F();
                    au6Var.G();
                    au6Var.C();
                }
                if (c.w() != au6Var.w()) {
                    au6Var.J();
                }
                if (c.u() != au6Var.u()) {
                    z2 = false;
                }
                if (!z2 || c.e() != au6Var.e()) {
                    au6Var.F();
                    au6Var.J();
                    au6Var.I();
                }
                if (c.n().size() != au6Var.n().size() || c.l() != au6Var.l()) {
                    au6Var.D();
                }
                i().h(au6Var);
            }
            this.e = null;
        }
    }

    public final void m(au6 danmakuConfig) {
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
