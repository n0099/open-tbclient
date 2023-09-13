package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.le2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class oe2<T extends le2> extends vi4<hk4> {
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
    public void p(@NonNull hk4 hk4Var, @Nullable an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, hk4Var, an3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029293, "Lcom/baidu/tieba/oe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029293, "Lcom/baidu/tieba/oe2;");
                return;
            }
        }
        b = rr1.a;
    }

    @Override // com.baidu.tieba.vi4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public oe2(@NonNull T t) {
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
    @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
    /* renamed from: s */
    public void c(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, hk4Var) == null) {
            super.c(hk4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + hk4Var);
            }
        }
    }

    @Override // com.baidu.tieba.aj4
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
    @Override // com.baidu.tieba.yi4
    /* renamed from: o */
    public String d(hk4 hk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hk4Var)) == null) {
            if (TextUtils.isEmpty(hk4Var.o)) {
                hk4Var.o = l();
            }
            int i = hk4Var.h;
            if (i == 0) {
                return af2.b(hk4Var.o, String.valueOf(hk4Var.i));
            }
            if (i == 1) {
                return af2.d(hk4Var.o, String.valueOf(hk4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
    /* renamed from: r */
    public final void i(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hk4Var) == null) {
            super.i(hk4Var);
            p(hk4Var, t(hk4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + hk4Var);
            }
        }
    }

    @CallSuper
    public void q(hk4 hk4Var, bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk4Var, bk4Var) == null) {
            super.e(hk4Var, bk4Var);
            h82.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + hk4Var.a);
            lr4.M(hk4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + hk4Var + ", error=" + bk4Var);
            }
        }
    }

    public final an3 t(hk4 hk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hk4Var)) == null) {
            if (!uo3.a(new File(hk4Var.a), hk4Var.m)) {
                an3 an3Var = new an3();
                an3Var.k(12L);
                an3Var.b(2300L);
                an3Var.d("分包签名校验失败");
                return an3Var;
            } else if (!af2.g(hk4Var)) {
                an3 an3Var2 = new an3();
                an3Var2.k(12L);
                an3Var2.b(2320L);
                an3Var2.d("分包解压失败");
                return an3Var2;
            } else {
                return null;
            }
        }
        return (an3) invokeL.objValue;
    }
}
