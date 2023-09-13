package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class vi4<T> implements yi4<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yi4
    public void a(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
        }
    }

    @Override // com.baidu.tieba.yi4
    public void c(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
        }
    }

    @Override // com.baidu.tieba.yi4
    public void e(T t, bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t, bk4Var) == null) {
        }
    }

    @Override // com.baidu.tieba.yi4
    public void f(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 100;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yi4
    public void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
        }
    }

    @Override // com.baidu.tieba.yi4
    public void j(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t) == null) {
        }
    }

    public vi4() {
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

    @Override // com.baidu.tieba.yi4
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("queue_priority", Integer.valueOf(g()));
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public bk4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            return new bk4(2302, "业务层默认不处理下载流");
        }
        return (bk4) invokeCommon.objValue;
    }
}
