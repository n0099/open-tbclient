package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k92;
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
public class n92<T extends k92> extends ud4<gf4> {
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
    public void p(@NonNull gf4 gf4Var, @Nullable zh3 zh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, gf4Var, zh3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947957218, "Lcom/baidu/tieba/n92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947957218, "Lcom/baidu/tieba/n92;");
                return;
            }
        }
        b = rm1.a;
    }

    @Override // com.baidu.tieba.ud4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public n92(@NonNull T t) {
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
    @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
    /* renamed from: s */
    public void c(gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gf4Var) == null) {
            super.c(gf4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + gf4Var);
            }
        }
    }

    @Override // com.baidu.tieba.zd4
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
    @Override // com.baidu.tieba.xd4
    /* renamed from: o */
    public String d(gf4 gf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gf4Var)) == null) {
            if (TextUtils.isEmpty(gf4Var.o)) {
                gf4Var.o = l();
            }
            int i = gf4Var.h;
            if (i == 0) {
                return z92.b(gf4Var.o, String.valueOf(gf4Var.i));
            }
            if (i == 1) {
                return z92.d(gf4Var.o, String.valueOf(gf4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
    /* renamed from: r */
    public final void i(gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gf4Var) == null) {
            super.i(gf4Var);
            p(gf4Var, t(gf4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + gf4Var);
            }
        }
    }

    @CallSuper
    public void q(gf4 gf4Var, af4 af4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gf4Var, af4Var) == null) {
            super.e(gf4Var, af4Var);
            g32.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + gf4Var.a);
            jm4.M(gf4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + gf4Var + ", error=" + af4Var);
            }
        }
    }

    public final zh3 t(gf4 gf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, gf4Var)) == null) {
            if (!tj3.a(new File(gf4Var.a), gf4Var.m)) {
                zh3 zh3Var = new zh3();
                zh3Var.k(12L);
                zh3Var.b(2300L);
                zh3Var.d("分包签名校验失败");
                return zh3Var;
            } else if (!z92.g(gf4Var)) {
                zh3 zh3Var2 = new zh3();
                zh3Var2.k(12L);
                zh3Var2.b(2320L);
                zh3Var2.d("分包解压失败");
                return zh3Var2;
            } else {
                return null;
            }
        }
        return (zh3) invokeL.objValue;
    }
}
