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
public class z84 extends q84<sq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948313811, "Lcom/baidu/tieba/z84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948313811, "Lcom/baidu/tieba/z84;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    public z84() {
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

    public static z84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new z84();
        }
        return (z84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q84
    /* renamed from: d */
    public boolean b(Context context, sq2 sq2Var, nq2 nq2Var, e43 e43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sq2Var, nq2Var, e43Var, jSONObject)) == null) {
            return g(context, sq2Var, nq2Var, e43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(sq2 sq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sq2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", sq2Var.c);
            bundle.putDouble("latitude", sq2Var.j.a);
            bundle.putDouble("longitude", sq2Var.j.b);
            bundle.putDouble("scale", sq2Var.k);
            bundle.putString("name", sq2Var.z);
            bundle.putString("address", sq2Var.A);
            bundle.putStringArrayList("ignoredApps", sq2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, sq2 sq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, sq2Var, nq2Var, e43Var)) == null) {
            e12.i("map", "OpenLocationAction start");
            if (!sq2Var.isValid()) {
                e12.c("map", "model is invalid");
                return false;
            }
            l94.r3(f(sq2Var)).v3();
            e12.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
