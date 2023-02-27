package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ic2;
import com.baidu.tieba.is2;
import com.baidu.tieba.qc2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class rc2<T extends qc2> extends ah4<ni4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull ni4 ni4Var);

    public abstract void u(ni4 ni4Var, fl3 fl3Var);

    /* loaded from: classes6.dex */
    public class a implements ic2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ni4 a;
        public final /* synthetic */ rc2 b;

        public a(rc2 rc2Var, ni4 ni4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc2Var, ni4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rc2Var;
            this.a = ni4Var;
        }

        @Override // com.baidu.tieba.ic2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ic2.c
        public void b(PMSDownloadType pMSDownloadType, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, fl3Var) == null) {
                this.b.u(this.a, fl3Var);
            }
        }
    }

    public rc2(@NonNull T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh4
    /* renamed from: l */
    public String d(ni4 ni4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ni4Var)) == null) {
            return is2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ni4Var) == null) {
            r(ni4Var);
            ic2.c().b(ni4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
    /* renamed from: v */
    public void c(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ni4Var) == null) {
            super.c(ni4Var);
            if (ni4Var != null) {
                e53.b("plugin download start: bundleId = " + ni4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
    /* renamed from: w */
    public void f(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ni4Var) == null) {
            super.f(ni4Var);
            if (ni4Var != null) {
                e53.b("plugin on downloading: bundleId = " + ni4Var.g);
            }
            x(ni4Var);
        }
    }

    public final void x(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ni4Var) == null) {
            ic2.c().d(ni4Var, new a(this, ni4Var));
        }
    }

    @Override // com.baidu.tieba.fh4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(ni4 ni4Var, fl3 fl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ni4Var, fl3Var) == null) {
            u(ni4Var, fl3Var);
            ic2.c().a(ni4Var, o(), fl3Var);
        }
    }

    public PMSDownloadType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return PMSDownloadType.PLUGIN;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
    /* renamed from: s */
    public void e(ni4 ni4Var, gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, ni4Var, gi4Var) == null) {
            super.e(ni4Var, gi4Var);
            e53.b("plugin download error: " + gi4Var);
            fl3 fl3Var = new fl3();
            fl3Var.k(17L);
            fl3Var.i((long) gi4Var.a);
            fl3Var.d(gi4Var.b);
            fl3Var.f(gi4Var.toString());
            p(ni4Var, fl3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ah4, com.baidu.tieba.dh4
    /* renamed from: t */
    public void i(ni4 ni4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ni4Var) == null) {
            super.i(ni4Var);
            if (ni4Var == null) {
                e53.b("download finish, plugin is null");
                fl3 fl3Var = new fl3();
                fl3Var.k(17L);
                fl3Var.i(2201L);
                fl3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, fl3Var);
            } else if (!zm3.a(new File(ni4Var.a), ni4Var.m)) {
                qp4.M(ni4Var.a);
                e53.b("download finish, check zip sign failure");
                fl3 fl3Var2 = new fl3();
                fl3Var2.k(17L);
                fl3Var2.i(2202L);
                fl3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(ni4Var, fl3Var2);
            } else {
                File t = is2.t(ni4Var.g, String.valueOf(ni4Var.i));
                qp4.l(t);
                if (t != null && t.exists()) {
                    boolean U = qp4.U(ni4Var.a, t.getAbsolutePath());
                    qp4.M(ni4Var.a);
                    e53.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        fl3 fl3Var3 = new fl3();
                        fl3Var3.k(17L);
                        fl3Var3.i(2320L);
                        fl3Var3.d("plugin unzip fail.");
                        p(ni4Var, fl3Var3);
                        return;
                    }
                    ni4Var.c = ni4Var.b();
                    ni4Var.d = ni4Var.b();
                    jh4.i().m(ni4Var);
                    q(ni4Var);
                    return;
                }
                qp4.M(ni4Var.a);
                e53.b("download finish, create file failure, name = " + ni4Var.g + " ; version = " + ni4Var.i);
                fl3 fl3Var4 = new fl3();
                fl3Var4.k(17L);
                fl3Var4.i(2203L);
                fl3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(ni4Var, fl3Var4);
            }
        }
    }
}
