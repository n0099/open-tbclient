package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ke2;
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
public class ne2<T extends ke2> extends ui4<gk4> {
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
    public void p(@NonNull gk4 gk4Var, @Nullable zm3 zm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, gk4Var, zm3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947999502, "Lcom/baidu/tieba/ne2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947999502, "Lcom/baidu/tieba/ne2;");
                return;
            }
        }
        b = qr1.a;
    }

    @Override // com.baidu.tieba.ui4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public ne2(@NonNull T t) {
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
    @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
    /* renamed from: s */
    public void c(gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gk4Var) == null) {
            super.c(gk4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gk4Var);
            }
        }
    }

    @Override // com.baidu.tieba.zi4
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
    @Override // com.baidu.tieba.xi4
    /* renamed from: o */
    public String d(gk4 gk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gk4Var)) == null) {
            if (TextUtils.isEmpty(gk4Var.o)) {
                gk4Var.o = l();
            }
            int i = gk4Var.h;
            if (i == 0) {
                return ze2.b(gk4Var.o, String.valueOf(gk4Var.i));
            }
            if (i == 1) {
                return ze2.d(gk4Var.o, String.valueOf(gk4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
    /* renamed from: r */
    public final void i(gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gk4Var) == null) {
            super.i(gk4Var);
            p(gk4Var, t(gk4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gk4Var);
            }
        }
    }

    @CallSuper
    public void q(gk4 gk4Var, ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gk4Var, ak4Var) == null) {
            super.e(gk4Var, ak4Var);
            g82.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + gk4Var.a);
            kr4.M(gk4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gk4Var + ", error=" + ak4Var);
            }
        }
    }

    public final zm3 t(gk4 gk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, gk4Var)) == null) {
            if (!to3.a(new File(gk4Var.a), gk4Var.m)) {
                zm3 zm3Var = new zm3();
                zm3Var.k(12L);
                zm3Var.b(2300L);
                zm3Var.d("分包签名校验失败");
                return zm3Var;
            } else if (!ze2.g(gk4Var)) {
                zm3 zm3Var2 = new zm3();
                zm3Var2.k(12L);
                zm3Var2.b(2320L);
                zm3Var2.d("分包解压失败");
                return zm3Var2;
            } else {
                return null;
            }
        }
        return (zm3) invokeL.objValue;
    }
}
