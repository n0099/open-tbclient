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
public class th4<T> implements lf4<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final wk4 c;
    public transient /* synthetic */ FieldHolder $fh;
    public lf4<T> a;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181193, "Lcom/baidu/tieba/th4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181193, "Lcom/baidu/tieba/th4;");
                return;
            }
        }
        c = wk4.e();
    }

    @Override // com.baidu.tieba.lf4
    public Map<String, Object> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a.k();
        }
        return (Map) invokeV.objValue;
    }

    public th4(lf4<T> lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lf4Var};
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
        this.a = lf4Var;
    }

    @Override // com.baidu.tieba.lf4
    public String d(T t) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            lf4<T> lf4Var = this.a;
            if (lf4Var != null) {
                str = lf4Var.d(t);
            } else {
                str = null;
            }
            if (str == null) {
                try {
                    return al4.d(AppRuntime.getAppContext()).getAbsolutePath();
                } catch (Exception e) {
                    c.g("PMSDownStreamCallbackGuard", "#getDownloadPath getPmsDir出错", e);
                    return str;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lf4
    public void a(T t) {
        lf4<T> lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, t) == null) && (lf4Var = this.a) != null) {
            try {
                lf4Var.a(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadProgress 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.lf4
    public void c(T t) {
        lf4<T> lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) && (lf4Var = this.a) != null) {
            try {
                lf4Var.c(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadStart 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.lf4
    public void f(T t) {
        lf4<T> lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, t) == null) && (lf4Var = this.a) != null) {
            try {
                lf4Var.f(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloading 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.lf4
    public void i(T t) {
        lf4<T> lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, t) == null) && (lf4Var = this.a) != null) {
            try {
                lf4Var.i(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadFinish 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.lf4
    public void j(T t) {
        lf4<T> lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) && (lf4Var = this.a) != null) {
            try {
                lf4Var.j(t);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadStop 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.lf4
    public void e(T t, og4 og4Var) {
        lf4<T> lf4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, t, og4Var) == null) && (lf4Var = this.a) != null) {
            try {
                lf4Var.e(t, og4Var);
            } catch (Exception e) {
                c.g("PMSDownStreamCallbackGuard", "#onDownloadError 错误", e);
            }
        }
    }

    @Override // com.baidu.tieba.nf4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, bundle, set)) == null) {
            lf4<T> lf4Var = this.a;
            if (lf4Var == null) {
                return new Bundle();
            }
            return lf4Var.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lf4
    public og4 h(T t, File file, long j, ReadableByteChannel readableByteChannel) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{t, file, Long.valueOf(j), readableByteChannel})) == null) {
            lf4<T> lf4Var = this.a;
            if (lf4Var != null) {
                return lf4Var.h(t, file, j, readableByteChannel);
            }
            return new og4(2302, "业务层默认不处理下载流");
        }
        return (og4) invokeCommon.objValue;
    }
}
