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
public class k73 extends i73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.j73
    public v32 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (v32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j73
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j73
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements ls1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g73 a;
        public final /* synthetic */ hd2 b;

        public a(k73 k73Var, g73 g73Var, hd2 hd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k73Var, g73Var, hd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g73Var;
            this.b = hd2Var;
        }

        @Override // com.baidu.tieba.ls1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                n73.b("obtain address failure, errCode = " + i);
                this.b.a(this.a);
            }
        }

        @Override // com.baidu.tieba.ls1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                n73.b("obtain address success");
                g73 g73Var = this.a;
                g73Var.d = true;
                if (jSONObject != null) {
                    g73Var.e = jSONObject.toString();
                }
                this.b.a(this.a);
            }
        }
    }

    public k73() {
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

    @Override // com.baidu.tieba.i73
    public void p(SwanAppActivity swanAppActivity, String str, f73 f73Var, hh3 hh3Var, hd2<g73> hd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, f73Var, hh3Var, hd2Var) == null) {
            g73 g73Var = new g73(f73Var.f);
            g73Var.a = f73Var.e;
            if (hh3Var != null && hh3Var.j.a() != 10003) {
                n73.b("obtain address detail");
                cv2.j0().a(swanAppActivity, str, str, new a(this, g73Var, hd2Var));
                return;
            }
            n73.b("user denied");
            hd2Var.a(g73Var);
        }
    }
}
