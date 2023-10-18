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
public class ka4 extends ba4<ds2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947906347, "Lcom/baidu/tieba/ka4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947906347, "Lcom/baidu/tieba/ka4;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public ka4() {
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

    public static ka4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ka4();
        }
        return (ka4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ba4
    /* renamed from: d */
    public boolean b(Context context, ds2 ds2Var, yr2 yr2Var, p53 p53Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ds2Var, yr2Var, p53Var, jSONObject)) == null) {
            return g(context, ds2Var, yr2Var, p53Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(ds2 ds2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ds2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", ds2Var.c);
            bundle.putDouble("latitude", ds2Var.j.a);
            bundle.putDouble("longitude", ds2Var.j.b);
            bundle.putDouble("scale", ds2Var.k);
            bundle.putString("name", ds2Var.z);
            bundle.putString("address", ds2Var.A);
            bundle.putStringArrayList("ignoredApps", ds2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, ds2 ds2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, ds2Var, yr2Var, p53Var)) == null) {
            p22.i("map", "OpenLocationAction start");
            if (!ds2Var.isValid()) {
                p22.c("map", "model is invalid");
                return false;
            }
            wa4.y3(f(ds2Var)).C3();
            p22.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
