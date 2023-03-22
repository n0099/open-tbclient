package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
@Singleton
@Service
/* loaded from: classes5.dex */
public class mt3 implements rr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.rr2
    public Map<Class, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public mt3() {
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

    @Override // com.baidu.tieba.rr2
    public void a(q83 q83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q83Var) == null) {
            it3.b().a(q83Var);
            it3.a().a(q83Var);
        }
    }

    @Override // com.baidu.tieba.rr2
    public Map<String, Object> b(@NonNull uv1 uv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uv1Var)) == null) {
            Map<String, Object> b = it3.b().b(uv1Var);
            Map<String, Object> b2 = it3.a().b(uv1Var);
            HashMap hashMap = new HashMap();
            if (b != null) {
                hashMap.putAll(b);
            }
            if (b2 != null) {
                hashMap.putAll(b2);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rr2
    public Map<String, Object> c(@NonNull uv1 uv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uv1Var)) == null) {
            Map<String, Object> c = it3.b().c(uv1Var);
            Map<String, Object> c2 = it3.a().c(uv1Var);
            HashMap hashMap = new HashMap();
            if (c != null) {
                hashMap.putAll(c);
            }
            if (c2 != null) {
                hashMap.putAll(c2);
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
