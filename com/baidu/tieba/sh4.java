package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class sh4<T> implements kf4<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final vk4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public kf4<T> a;
    public int b;

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948151402, "Lcom/baidu/tieba/sh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948151402, "Lcom/baidu/tieba/sh4;");
                return;
            }
        }
        c = vk4.e();
    }

    @Override // com.baidu.tieba.kf4
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.k();
        }
        return (Map) invokeV.objValue;
    }

    public sh4(kf4<T> kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kf4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.a = kf4Var;
    }

    @Override // com.baidu.tieba.kf4
    public String d(T t) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            kf4<T> kf4Var = this.a;
            if (kf4Var != null) {
                str = kf4Var.d(t);
            } else {
                str = null;
            }
            if (str == null) {
                try {
                    return zk4.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e) {
                    c.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e);
                    return str;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kf4
    public void a(T t) {
        kf4<T> kf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t) == null) && (kf4Var = this.a) != null) {
            try {
                kf4Var.a(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.kf4
    public void c(T t) {
        kf4<T> kf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) && (kf4Var = this.a) != null) {
            try {
                kf4Var.c(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.kf4
    public void f(T t) {
        kf4<T> kf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, t) == null) && (kf4Var = this.a) != null) {
            try {
                kf4Var.f(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.kf4
    public void i(T t) {
        kf4<T> kf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && (kf4Var = this.a) != null) {
            try {
                kf4Var.i(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.kf4
    public void j(T t) {
        kf4<T> kf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) && (kf4Var = this.a) != null) {
            try {
                kf4Var.j(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.kf4
    public void e(T t, ng4 ng4Var) {
        kf4<T> kf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, t, ng4Var) == null) && (kf4Var = this.a) != null) {
            try {
                kf4Var.e(t, ng4Var);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.mf4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            kf4<T> kf4Var = this.a;
            if (kf4Var == null) {
                return new Bundle();
            }
            return kf4Var.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kf4
    public ng4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            kf4<T> kf4Var = this.a;
            if (kf4Var != null) {
                return kf4Var.h(t, file, j, readableByteChannel);
            }
            return new ng4(2302, "业务层默认不处理下载流");
        }
        return (ng4) invokeCommon.objValue;
    }
}
