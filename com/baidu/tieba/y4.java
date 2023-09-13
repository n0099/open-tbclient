package com.baidu.tieba;

import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class y4 implements b7, i7.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public void a(i7 i7Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, i7Var, jsonValue) == null) {
        }
    }

    @Override // com.baidu.tieba.b7
    public void dispose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void f(g1 g1Var, b5 b5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, g1Var, b5Var) == null) {
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448321074, "Lcom/baidu/tieba/y4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448321074, "Lcom/baidu/tieba/y4;");
                return;
            }
        }
        new Vector3();
        new Vector3();
        new Vector3();
        new Vector3();
        new Vector3();
        new Vector3();
        new Quaternion();
        new Quaternion();
        new Matrix3();
        new Matrix4();
    }

    public y4() {
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
}
