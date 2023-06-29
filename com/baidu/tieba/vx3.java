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
/* loaded from: classes8.dex */
public class vx3 implements aw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw2
    public Map<Class, Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    public vx3() {
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

    @Override // com.baidu.tieba.aw2
    public void a(zc3 zc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zc3Var) == null) {
            rx3.b().a(zc3Var);
            rx3.a().a(zc3Var);
        }
    }

    @Override // com.baidu.tieba.aw2
    public Map<String, Object> b(@NonNull d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d02Var)) == null) {
            Map<String, Object> b = rx3.b().b(d02Var);
            Map<String, Object> b2 = rx3.a().b(d02Var);
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

    @Override // com.baidu.tieba.aw2
    public Map<String, Object> c(@NonNull d02 d02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d02Var)) == null) {
            Map<String, Object> c = rx3.b().c(d02Var);
            Map<String, Object> c2 = rx3.a().c(d02Var);
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
