package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class sc4 extends jc4<lu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948146597, "Lcom/baidu/tieba/sc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948146597, "Lcom/baidu/tieba/sc4;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    public sc4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static sc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new sc4();
        }
        return (sc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jc4
    /* renamed from: d */
    public boolean b(Context context, lu2 lu2Var, gu2 gu2Var, x73 x73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lu2Var, gu2Var, x73Var, jSONObject)) == null) {
            return g(context, lu2Var, gu2Var, x73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(lu2 lu2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lu2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", lu2Var.c);
            bundle.putDouble("latitude", lu2Var.j.a);
            bundle.putDouble("longitude", lu2Var.j.b);
            bundle.putDouble("scale", lu2Var.k);
            bundle.putString("name", lu2Var.z);
            bundle.putString("address", lu2Var.A);
            bundle.putStringArrayList("ignoredApps", lu2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, lu2 lu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, lu2Var, gu2Var, x73Var)) == null) {
            x42.i("map", "OpenLocationAction start");
            if (!lu2Var.isValid()) {
                x42.c("map", "model is invalid");
                return false;
            }
            ed4.u3(f(lu2Var)).y3();
            x42.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
