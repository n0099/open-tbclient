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
/* loaded from: classes7.dex */
public class qg4 extends hg4<jy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948090859, "Lcom/baidu/tieba/qg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948090859, "Lcom/baidu/tieba/qg4;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public qg4() {
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

    public static qg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new qg4();
        }
        return (qg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hg4
    /* renamed from: d */
    public boolean b(Context context, jy2 jy2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jy2Var, ey2Var, vb3Var, jSONObject)) == null) {
            return g(context, jy2Var, ey2Var, vb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(jy2 jy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jy2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", jy2Var.c);
            bundle.putDouble("latitude", jy2Var.j.a);
            bundle.putDouble("longitude", jy2Var.j.b);
            bundle.putDouble("scale", jy2Var.k);
            bundle.putString("name", jy2Var.z);
            bundle.putString("address", jy2Var.A);
            bundle.putStringArrayList("ignoredApps", jy2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, jy2 jy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, jy2Var, ey2Var, vb3Var)) == null) {
            v82.i("map", "OpenLocationAction start");
            if (!jy2Var.isValid()) {
                v82.c("map", "model is invalid");
                return false;
            }
            ch4.t3(f(jy2Var)).x3();
            v82.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
