package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c33;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j53 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j53(b33 b33Var) {
        super(b33Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b33Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b33) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public void I(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && M() && (str2 = this.d) != null && str2.equals(str)) {
            x23 K = x23.K();
            if (K.E()) {
                if (K.q().n0()) {
                    K.n("flag_finish_activity", "flag_remove_task");
                    return;
                }
                re3 re3Var = new re3();
                re3Var.k(10L);
                re3Var.i(2107L);
                re3Var.d("app forbidden");
                e33.y0(va4.i().u(str), fm2.c(), K.q().W(), false, null, re3Var);
            }
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (y23.b0() == null || this.b == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rh3
    /* renamed from: N */
    public void a(c33.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (kz2.J(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.j("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", x23.K().getAppId());
            }
            if (kz2.J(aVar.D(), "swan_kill_to_client")) {
                x23.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
