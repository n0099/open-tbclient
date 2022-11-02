package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.i72;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes4.dex */
public class l72<T extends i72> extends sb4<ed4> {
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
    public void p(@NonNull ed4 ed4Var, @Nullable xf3 xf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, ed4Var, xf3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947895714, "Lcom/baidu/tieba/l72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947895714, "Lcom/baidu/tieba/l72;");
                return;
            }
        }
        b = ok1.a;
    }

    @Override // com.baidu.tieba.sb4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public l72(@NonNull T t) {
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
    @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
    /* renamed from: s */
    public void c(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ed4Var) == null) {
            super.c(ed4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + ed4Var);
            }
        }
    }

    @Override // com.baidu.tieba.xb4
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
    @Override // com.baidu.tieba.vb4
    /* renamed from: o */
    public String d(ed4 ed4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ed4Var)) == null) {
            if (TextUtils.isEmpty(ed4Var.o)) {
                ed4Var.o = l();
            }
            int i = ed4Var.h;
            if (i == 0) {
                return x72.b(ed4Var.o, String.valueOf(ed4Var.i));
            }
            if (i == 1) {
                return x72.d(ed4Var.o, String.valueOf(ed4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
    /* renamed from: r */
    public final void i(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ed4Var) == null) {
            super.i(ed4Var);
            p(ed4Var, t(ed4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + ed4Var);
            }
        }
    }

    @CallSuper
    public void q(ed4 ed4Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ed4Var, yc4Var) == null) {
            super.e(ed4Var, yc4Var);
            e12.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + ed4Var.a);
            ik4.M(ed4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + ed4Var + ", error=" + yc4Var);
            }
        }
    }

    public final xf3 t(ed4 ed4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ed4Var)) == null) {
            if (!rh3.a(new File(ed4Var.a), ed4Var.m)) {
                xf3 xf3Var = new xf3();
                xf3Var.k(12L);
                xf3Var.b(2300L);
                xf3Var.d("分包签名校验失败");
                return xf3Var;
            } else if (!x72.g(ed4Var)) {
                xf3 xf3Var2 = new xf3();
                xf3Var2.k(12L);
                xf3Var2.b(2320L);
                xf3Var2.d("分包解压失败");
                return xf3Var2;
            } else {
                return null;
            }
        }
        return (xf3) invokeL.objValue;
    }
}
