package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class th4 implements wh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }

    @Nullable
    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }

    public th4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> T e(@Nullable T t, @Nullable uh4<T> uh4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, uh4Var)) == null) {
            if (t != null && uh4Var != null) {
                uh4Var.a(t);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.wh4
    @Nullable
    public JSONObject a(@Nullable uh4<JSONObject> uh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, uh4Var)) == null) {
            JSONObject d = d();
            e(d, uh4Var);
            return d;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wh4
    @Nullable
    public JSONArray b(@Nullable uh4<JSONArray> uh4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uh4Var)) == null) {
            JSONArray c = c();
            e(c, uh4Var);
            return c;
        }
        return (JSONArray) invokeL.objValue;
    }
}
