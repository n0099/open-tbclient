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
/* loaded from: classes8.dex */
public class xg4 extends og4<qy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948299396, "Lcom/baidu/tieba/xg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948299396, "Lcom/baidu/tieba/xg4;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public xg4() {
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

    public static xg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new xg4();
        }
        return (xg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.og4
    /* renamed from: d */
    public boolean b(Context context, qy2 qy2Var, ly2 ly2Var, cc3 cc3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, qy2Var, ly2Var, cc3Var, jSONObject)) == null) {
            return g(context, qy2Var, ly2Var, cc3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(qy2 qy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qy2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", qy2Var.c);
            bundle.putDouble("latitude", qy2Var.j.a);
            bundle.putDouble("longitude", qy2Var.j.b);
            bundle.putDouble("scale", qy2Var.k);
            bundle.putString("name", qy2Var.z);
            bundle.putString("address", qy2Var.A);
            bundle.putStringArrayList("ignoredApps", qy2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, qy2 qy2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, qy2Var, ly2Var, cc3Var)) == null) {
            c92.i("map", "OpenLocationAction start");
            if (!qy2Var.isValid()) {
                c92.c("map", "model is invalid");
                return false;
            }
            jh4.t3(f(qy2Var)).x3();
            c92.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
