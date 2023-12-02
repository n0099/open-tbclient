package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o92;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class r92<T extends o92> extends yd4<kf4> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @CallSuper
    public void p(@NonNull kf4 kf4Var, @Nullable di3 di3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, kf4Var, di3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076382, "Lcom/baidu/tieba/r92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076382, "Lcom/baidu/tieba/r92;");
                return;
            }
        }
        b = vm1.a;
    }

    @Override // com.baidu.tieba.yd4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public r92(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
    /* renamed from: s */
    public void c(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, kf4Var) == null) {
            super.c(kf4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + kf4Var);
            }
        }
    }

    @Override // com.baidu.tieba.de4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
            Bundle bundle2 = new Bundle();
            if (set.contains("event_performance_ubc")) {
                this.a.n(bundle.getString("performance_ubc_event_id"), bundle.getString("performance_ubc_extra_key_for_event"));
                set.remove("event_performance_ubc");
            }
            return bundle2;
        }
        return (Bundle) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.be4
    /* renamed from: o */
    public String d(kf4 kf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, kf4Var)) == null) {
            if (TextUtils.isEmpty(kf4Var.o)) {
                kf4Var.o = l();
            }
            int i = kf4Var.h;
            if (i == 0) {
                return da2.b(kf4Var.o, String.valueOf(kf4Var.i));
            }
            if (i == 1) {
                return da2.d(kf4Var.o, String.valueOf(kf4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
    /* renamed from: r */
    public final void i(kf4 kf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kf4Var) == null) {
            super.i(kf4Var);
            p(kf4Var, t(kf4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + kf4Var);
            }
        }
    }

    @CallSuper
    public void q(kf4 kf4Var, ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kf4Var, ef4Var) == null) {
            super.e(kf4Var, ef4Var);
            k32.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + kf4Var.a);
            nm4.M(kf4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + kf4Var + ", error=" + ef4Var);
            }
        }
    }

    public final di3 t(kf4 kf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, kf4Var)) == null) {
            if (!xj3.a(new File(kf4Var.a), kf4Var.m)) {
                di3 di3Var = new di3();
                di3Var.k(12L);
                di3Var.b(2300L);
                di3Var.d("分包签名校验失败");
                return di3Var;
            } else if (!da2.g(kf4Var)) {
                di3 di3Var2 = new di3();
                di3Var2.k(12L);
                di3Var2.b(2320L);
                di3Var2.d("分包解压失败");
                return di3Var2;
            } else {
                return null;
            }
        }
        return (di3) invokeL.objValue;
    }
}
