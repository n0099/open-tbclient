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
public class qc4 extends hc4<ju2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948087015, "Lcom/baidu/tieba/qc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948087015, "Lcom/baidu/tieba/qc4;");
                return;
            }
        }
        boolean z = fo1.a;
    }

    public qc4() {
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

    public static qc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new qc4();
        }
        return (qc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hc4
    /* renamed from: d */
    public boolean b(Context context, ju2 ju2Var, eu2 eu2Var, v73 v73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ju2Var, eu2Var, v73Var, jSONObject)) == null) {
            return g(context, ju2Var, eu2Var, v73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(ju2 ju2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ju2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", ju2Var.c);
            bundle.putDouble("latitude", ju2Var.j.a);
            bundle.putDouble("longitude", ju2Var.j.b);
            bundle.putDouble("scale", ju2Var.k);
            bundle.putString("name", ju2Var.z);
            bundle.putString("address", ju2Var.A);
            bundle.putStringArrayList("ignoredApps", ju2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, ju2 ju2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, ju2Var, eu2Var, v73Var)) == null) {
            v42.i("map", "OpenLocationAction start");
            if (!ju2Var.isValid()) {
                v42.c("map", "model is invalid");
                return false;
            }
            cd4.u3(f(ju2Var)).y3();
            v42.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
