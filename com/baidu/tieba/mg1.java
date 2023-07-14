package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
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
public class mg1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947971602, "Lcom/baidu/tieba/mg1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947971602, "Lcom/baidu/tieba/mg1;");
        }
    }

    public mg1() {
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

    public static synchronized mg1 f() {
        InterceptResult invokeV;
        mg1 mg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (mg1.class) {
                if (a == null) {
                    synchronized (mg1.class) {
                        if (a == null) {
                            a = new mg1();
                        }
                    }
                }
                mg1Var = a;
            }
            return mg1Var;
        }
        return (mg1) invokeV.objValue;
    }

    public boolean a(Activity activity, String str, qg1 qg1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, str, qg1Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            lg1.a().c(activity, str, qg1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean b(Activity activity, String str, qg1 qg1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, qg1Var)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            lg1.a().e(activity, str, qg1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean c(Activity activity, JSONObject jSONObject, qg1 qg1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, jSONObject, qg1Var)) == null) {
            if (jSONObject == null) {
                return false;
            }
            lg1.a().i(activity, jSONObject, qg1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean e(Context context, JSONObject jSONObject, qg1 qg1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, context, jSONObject, qg1Var)) == null) {
            if (jSONObject == null) {
                return false;
            }
            lg1.a().d(context, jSONObject, qg1Var);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public boolean d(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            lg1.a().f(context, jSONObject);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
