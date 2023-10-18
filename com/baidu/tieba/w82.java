package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t82;
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
public class w82<T extends t82> extends dd4<pe4> {
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
    public void p(@NonNull pe4 pe4Var, @Nullable ih3 ih3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pe4Var, ih3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948224376, "Lcom/baidu/tieba/w82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948224376, "Lcom/baidu/tieba/w82;");
                return;
            }
        }
        b = am1.a;
    }

    @Override // com.baidu.tieba.dd4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public w82(@NonNull T t) {
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
    @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
    /* renamed from: s */
    public void c(pe4 pe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pe4Var) == null) {
            super.c(pe4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + pe4Var);
            }
        }
    }

    @Override // com.baidu.tieba.id4
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
    @Override // com.baidu.tieba.gd4
    /* renamed from: o */
    public String d(pe4 pe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, pe4Var)) == null) {
            if (TextUtils.isEmpty(pe4Var.o)) {
                pe4Var.o = l();
            }
            int i = pe4Var.h;
            if (i == 0) {
                return i92.b(pe4Var.o, String.valueOf(pe4Var.i));
            }
            if (i == 1) {
                return i92.d(pe4Var.o, String.valueOf(pe4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
    /* renamed from: r */
    public final void i(pe4 pe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pe4Var) == null) {
            super.i(pe4Var);
            p(pe4Var, t(pe4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + pe4Var);
            }
        }
    }

    @CallSuper
    public void q(pe4 pe4Var, je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pe4Var, je4Var) == null) {
            super.e(pe4Var, je4Var);
            p22.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + pe4Var.a);
            sl4.M(pe4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + pe4Var + ", error=" + je4Var);
            }
        }
    }

    public final ih3 t(pe4 pe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, pe4Var)) == null) {
            if (!cj3.a(new File(pe4Var.a), pe4Var.m)) {
                ih3 ih3Var = new ih3();
                ih3Var.k(12L);
                ih3Var.b(2300L);
                ih3Var.d("分包签名校验失败");
                return ih3Var;
            } else if (!i92.g(pe4Var)) {
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(12L);
                ih3Var2.b(2320L);
                ih3Var2.d("分包解压失败");
                return ih3Var2;
            } else {
                return null;
            }
        }
        return (ih3) invokeL.objValue;
    }
}
