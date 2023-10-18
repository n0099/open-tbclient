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
/* loaded from: classes7.dex */
public class of4<T> implements gd4<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final ri4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public gd4<T> a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948030316, "Lcom/baidu/tieba/of4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948030316, "Lcom/baidu/tieba/of4;");
                return;
            }
        }
        c = ri4.e();
    }

    @Override // com.baidu.tieba.gd4
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.k();
        }
        return (Map) invokeV.objValue;
    }

    public of4(gd4<T> gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gd4Var};
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
        this.a = gd4Var;
    }

    @Override // com.baidu.tieba.gd4
    public String d(T t) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            gd4<T> gd4Var = this.a;
            if (gd4Var != null) {
                str = gd4Var.d(t);
            } else {
                str = null;
            }
            if (str == null) {
                try {
                    return vi4.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e) {
                    c.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e);
                    return str;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.gd4
    public void a(T t) {
        gd4<T> gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t) == null) && (gd4Var = this.a) != null) {
            try {
                gd4Var.a(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.gd4
    public void c(T t) {
        gd4<T> gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) && (gd4Var = this.a) != null) {
            try {
                gd4Var.c(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.gd4
    public void f(T t) {
        gd4<T> gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, t) == null) && (gd4Var = this.a) != null) {
            try {
                gd4Var.f(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.gd4
    public void i(T t) {
        gd4<T> gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && (gd4Var = this.a) != null) {
            try {
                gd4Var.i(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.gd4
    public void j(T t) {
        gd4<T> gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) && (gd4Var = this.a) != null) {
            try {
                gd4Var.j(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.gd4
    public void e(T t, je4 je4Var) {
        gd4<T> gd4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, t, je4Var) == null) && (gd4Var = this.a) != null) {
            try {
                gd4Var.e(t, je4Var);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.id4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            gd4<T> gd4Var = this.a;
            if (gd4Var == null) {
                return new Bundle();
            }
            return gd4Var.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.gd4
    public je4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            gd4<T> gd4Var = this.a;
            if (gd4Var != null) {
                return gd4Var.h(t, file, j, readableByteChannel);
            }
            return new je4(2302, "业务层默认不处理下载流");
        }
        return (je4) invokeCommon.objValue;
    }
}
