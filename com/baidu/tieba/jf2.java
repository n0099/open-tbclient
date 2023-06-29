package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gf2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class jf2<T extends gf2> extends qj4<cl4> {
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
    public void p(@NonNull cl4 cl4Var, @Nullable vn3 vn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, cl4Var, vn3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947881299, "Lcom/baidu/tieba/jf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947881299, "Lcom/baidu/tieba/jf2;");
                return;
            }
        }
        b = ms1.a;
    }

    @Override // com.baidu.tieba.qj4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public jf2(@NonNull T t) {
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
    @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
    /* renamed from: s */
    public void c(cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cl4Var) == null) {
            super.c(cl4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + cl4Var);
            }
        }
    }

    @Override // com.baidu.tieba.vj4
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
    @Override // com.baidu.tieba.tj4
    /* renamed from: o */
    public String d(cl4 cl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cl4Var)) == null) {
            if (TextUtils.isEmpty(cl4Var.o)) {
                cl4Var.o = l();
            }
            int i = cl4Var.h;
            if (i == 0) {
                return vf2.b(cl4Var.o, String.valueOf(cl4Var.i));
            }
            if (i == 1) {
                return vf2.d(cl4Var.o, String.valueOf(cl4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
    /* renamed from: r */
    public final void i(cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cl4Var) == null) {
            super.i(cl4Var);
            p(cl4Var, t(cl4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + cl4Var);
            }
        }
    }

    @CallSuper
    public void q(cl4 cl4Var, wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cl4Var, wk4Var) == null) {
            super.e(cl4Var, wk4Var);
            c92.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + cl4Var.a);
            gs4.M(cl4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + cl4Var + ", error=" + wk4Var);
            }
        }
    }

    public final vn3 t(cl4 cl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cl4Var)) == null) {
            if (!pp3.a(new File(cl4Var.a), cl4Var.m)) {
                vn3 vn3Var = new vn3();
                vn3Var.k(12L);
                vn3Var.b(2300L);
                vn3Var.d("分包签名校验失败");
                return vn3Var;
            } else if (!vf2.g(cl4Var)) {
                vn3 vn3Var2 = new vn3();
                vn3Var2.k(12L);
                vn3Var2.b(2320L);
                vn3Var2.d("分包解压失败");
                return vn3Var2;
            } else {
                return null;
            }
        }
        return (vn3) invokeL.objValue;
    }
}
