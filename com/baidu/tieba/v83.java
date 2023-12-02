package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o63;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v83 extends u83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v83(n63 n63Var) {
        super(n63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n63Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((n63) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.u83
    public void I(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && M() && (str2 = this.d) != null && str2.equals(str)) {
            j63 K = j63.K();
            if (!K.E()) {
                return;
            }
            if (K.q().o0()) {
                K.n("flag_finish_activity", "flag_remove_task");
                return;
            }
            di3 di3Var = new di3();
            di3Var.k(10L);
            di3Var.i(2107L);
            di3Var.d("app forbidden");
            q63.z0(he4.i().u(str), rp2.c(), K.q().X(), false, null, di3Var);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (k63.c0() != null && this.b != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dl3
    /* renamed from: N */
    public void a(o63.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (w23.J(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.i("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", j63.K().getAppId());
            }
            if (w23.J(aVar.D(), "swan_kill_to_client")) {
                j63.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
