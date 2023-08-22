package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class od3 extends nd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public od3(gb3 gb3Var) {
        super(gb3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((gb3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.nd3
    public void I(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && M() && (str2 = this.d) != null && str2.equals(str)) {
            cb3 K = cb3.K();
            if (!K.E()) {
                return;
            }
            if (K.q().n0()) {
                K.n("flag_finish_activity", "flag_remove_task");
                return;
            }
            wm3 wm3Var = new wm3();
            wm3Var.k(10L);
            wm3Var.i(2107L);
            wm3Var.d("app forbidden");
            jb3.y0(aj4.i().u(str), ku2.c(), K.q().W(), false, null, wm3Var);
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (db3.b0() != null && this.b != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wp3
    /* renamed from: N */
    public void a(hb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (p73.J(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.b = aVar.j("ipc_forbidden_flag", 1);
                this.d = aVar.o("mAppId", cb3.K().getAppId());
            }
            if (p73.J(aVar.D(), "swan_kill_to_client")) {
                cb3.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
