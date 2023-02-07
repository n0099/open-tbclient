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
public class rd4 extends id4<kv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117767, "Lcom/baidu/tieba/rd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117767, "Lcom/baidu/tieba/rd4;");
                return;
            }
        }
        boolean z = gp1.a;
    }

    public rd4() {
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

    public static rd4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new rd4();
        }
        return (rd4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.id4
    /* renamed from: d */
    public boolean b(Context context, kv2 kv2Var, fv2 fv2Var, w83 w83Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, kv2Var, fv2Var, w83Var, jSONObject)) == null) {
            return g(context, kv2Var, fv2Var, w83Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(kv2 kv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kv2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", kv2Var.c);
            bundle.putDouble("latitude", kv2Var.j.a);
            bundle.putDouble("longitude", kv2Var.j.b);
            bundle.putDouble("scale", kv2Var.k);
            bundle.putString("name", kv2Var.z);
            bundle.putString("address", kv2Var.A);
            bundle.putStringArrayList("ignoredApps", kv2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, kv2 kv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, kv2Var, fv2Var, w83Var)) == null) {
            w52.i("map", "OpenLocationAction start");
            if (!kv2Var.isValid()) {
                w52.c("map", "model is invalid");
                return false;
            }
            de4.r3(f(kv2Var)).v3();
            w52.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
