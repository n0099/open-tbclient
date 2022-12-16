package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tz2 extends rz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.sz2
    public ew1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (ew1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sz2
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements uk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pz2 a;
        public final /* synthetic */ q52 b;

        public a(tz2 tz2Var, pz2 pz2Var, q52 q52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tz2Var, pz2Var, q52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pz2Var;
            this.b = q52Var;
        }

        @Override // com.baidu.tieba.uk1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                wz2.b("obtain address failure, errCode = " + i);
                this.b.a(this.a);
            }
        }

        @Override // com.baidu.tieba.uk1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                wz2.b("obtain address success");
                pz2 pz2Var = this.a;
                pz2Var.d = true;
                if (jSONObject != null) {
                    pz2Var.e = jSONObject.toString();
                }
                this.b.a(this.a);
            }
        }
    }

    public tz2() {
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

    @Override // com.baidu.tieba.rz2
    public void p(SwanAppActivity swanAppActivity, String str, oz2 oz2Var, q93 q93Var, q52<pz2> q52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, oz2Var, q93Var, q52Var) == null) {
            pz2 pz2Var = new pz2(oz2Var.f);
            pz2Var.a = oz2Var.e;
            if (q93Var != null && q93Var.j.a() != 10003) {
                wz2.b("obtain address detail");
                ln2.j0().a(swanAppActivity, str, str, new a(this, pz2Var, q52Var));
                return;
            }
            wz2.b("user denied");
            q52Var.a(pz2Var);
        }
    }
}
