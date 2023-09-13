package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class w63 extends u63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.v63
    public h32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (h32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v63
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v63
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements xr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s63 a;
        public final /* synthetic */ tc2 b;

        public a(w63 w63Var, s63 s63Var, tc2 tc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w63Var, s63Var, tc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s63Var;
            this.b = tc2Var;
        }

        @Override // com.baidu.tieba.xr1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                z63.b("obtain address failure, errCode = " + i);
                this.b.a(this.a);
            }
        }

        @Override // com.baidu.tieba.xr1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                z63.b("obtain address success");
                s63 s63Var = this.a;
                s63Var.d = true;
                if (jSONObject != null) {
                    s63Var.e = jSONObject.toString();
                }
                this.b.a(this.a);
            }
        }
    }

    public w63() {
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

    @Override // com.baidu.tieba.u63
    public void p(SwanAppActivity swanAppActivity, String str, r63 r63Var, tg3 tg3Var, tc2<s63> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, r63Var, tg3Var, tc2Var) == null) {
            s63 s63Var = new s63(r63Var.f);
            s63Var.a = r63Var.e;
            if (tg3Var != null && tg3Var.j.a() != 10003) {
                z63.b("obtain address detail");
                ou2.j0().a(swanAppActivity, str, str, new a(this, s63Var, tc2Var));
                return;
            }
            z63.b("user denied");
            tc2Var.a(s63Var);
        }
    }
}
