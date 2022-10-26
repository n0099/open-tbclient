package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class t62 extends ab4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final q62 a;

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void p(mc4 mc4Var, ff3 ff3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, mc4Var, ff3Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948133081, "Lcom/baidu/tieba/t62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948133081, "Lcom/baidu/tieba/t62;");
                return;
            }
        }
        b = wj1.a;
    }

    @Override // com.baidu.tieba.ab4
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.g();
        }
        return invokeV.intValue;
    }

    public t62(q62 q62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q62Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = q62Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
    /* renamed from: s */
    public void c(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, mc4Var) == null) {
            super.c(mc4Var);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadStart " + mc4Var);
            }
        }
    }

    @Override // com.baidu.tieba.fb4
    public Bundle m(Bundle bundle, Set set) {
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
    @Override // com.baidu.tieba.db4
    /* renamed from: o */
    public String d(mc4 mc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mc4Var)) == null) {
            if (TextUtils.isEmpty(mc4Var.o)) {
                mc4Var.o = l();
            }
            int i = mc4Var.h;
            if (i == 0) {
                return f72.b(mc4Var.o, String.valueOf(mc4Var.i));
            }
            if (i == 1) {
                return f72.d(mc4Var.o, String.valueOf(mc4Var.i));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
    /* renamed from: r */
    public final void i(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mc4Var) == null) {
            super.i(mc4Var);
            p(mc4Var, t(mc4Var));
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadFinish " + mc4Var);
            }
        }
    }

    public void q(mc4 mc4Var, gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc4Var, gc4Var) == null) {
            super.e(mc4Var, gc4Var);
            m02.k("SwanPMSSubDownload", "PMSPkgSub#onDownloadError del:" + mc4Var.a);
            qj4.M(mc4Var.a);
            if (b) {
                Log.d("SwanPMSSubDownload", "PMSPkgSub onDownloadError " + mc4Var + ", error=" + gc4Var);
            }
        }
    }

    public final ff3 t(mc4 mc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, mc4Var)) == null) {
            if (!zg3.a(new File(mc4Var.a), mc4Var.m)) {
                ff3 ff3Var = new ff3();
                ff3Var.k(12L);
                ff3Var.b(2300L);
                ff3Var.d("分包签名校验失败");
                return ff3Var;
            } else if (!f72.g(mc4Var)) {
                ff3 ff3Var2 = new ff3();
                ff3Var2.k(12L);
                ff3Var2.b(2320L);
                ff3Var2.d("分包解压失败");
                return ff3Var2;
            } else {
                return null;
            }
        }
        return (ff3) invokeL.objValue;
    }
}
