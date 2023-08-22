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
public class yf4 extends pf4<rx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948328226, "Lcom/baidu/tieba/yf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948328226, "Lcom/baidu/tieba/yf4;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public yf4() {
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

    public static yf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new yf4();
        }
        return (yf4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pf4
    /* renamed from: d */
    public boolean b(Context context, rx2 rx2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rx2Var, mx2Var, db3Var, jSONObject)) == null) {
            return g(context, rx2Var, mx2Var, db3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(rx2 rx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rx2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", rx2Var.c);
            bundle.putDouble("latitude", rx2Var.j.a);
            bundle.putDouble("longitude", rx2Var.j.b);
            bundle.putDouble("scale", rx2Var.k);
            bundle.putString("name", rx2Var.z);
            bundle.putString("address", rx2Var.A);
            bundle.putStringArrayList("ignoredApps", rx2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, rx2 rx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, rx2Var, mx2Var, db3Var)) == null) {
            d82.i("map", "OpenLocationAction start");
            if (!rx2Var.isValid()) {
                d82.c("map", "model is invalid");
                return false;
            }
            kg4.t3(f(rx2Var)).x3();
            d82.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
