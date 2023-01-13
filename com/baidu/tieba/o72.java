package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.f72;
import com.baidu.tieba.fn2;
import com.baidu.tieba.n72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class o72<T extends n72> extends xb4<kd4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull kd4 kd4Var);

    public abstract void u(kd4 kd4Var, cg3 cg3Var);

    /* loaded from: classes5.dex */
    public class a implements f72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kd4 a;
        public final /* synthetic */ o72 b;

        public a(o72 o72Var, kd4 kd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o72Var, kd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o72Var;
            this.a = kd4Var;
        }

        @Override // com.baidu.tieba.f72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.f72.c
        public void b(PMSDownloadType pMSDownloadType, cg3 cg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, cg3Var) == null) {
                this.b.u(this.a, cg3Var);
            }
        }
    }

    public o72(@NonNull T t) {
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
    @Override // com.baidu.tieba.ac4
    /* renamed from: l */
    public String d(kd4 kd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, kd4Var)) == null) {
            return fn2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kd4Var) == null) {
            r(kd4Var);
            f72.c().b(kd4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
    /* renamed from: v */
    public void c(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kd4Var) == null) {
            super.c(kd4Var);
            if (kd4Var != null) {
                b03.b("plugin download start: bundleId = " + kd4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
    /* renamed from: w */
    public void f(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kd4Var) == null) {
            super.f(kd4Var);
            if (kd4Var != null) {
                b03.b("plugin on downloading: bundleId = " + kd4Var.g);
            }
            x(kd4Var);
        }
    }

    public final void x(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, kd4Var) == null) {
            f72.c().d(kd4Var, new a(this, kd4Var));
        }
    }

    @Override // com.baidu.tieba.cc4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(kd4 kd4Var, cg3 cg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kd4Var, cg3Var) == null) {
            u(kd4Var, cg3Var);
            f72.c().a(kd4Var, o(), cg3Var);
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
    @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
    /* renamed from: s */
    public void e(kd4 kd4Var, dd4 dd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, kd4Var, dd4Var) == null) {
            super.e(kd4Var, dd4Var);
            b03.b("plugin download error: " + dd4Var);
            cg3 cg3Var = new cg3();
            cg3Var.k(17L);
            cg3Var.i((long) dd4Var.a);
            cg3Var.d(dd4Var.b);
            cg3Var.f(dd4Var.toString());
            p(kd4Var, cg3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xb4, com.baidu.tieba.ac4
    /* renamed from: t */
    public void i(kd4 kd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, kd4Var) == null) {
            super.i(kd4Var);
            if (kd4Var == null) {
                b03.b("download finish, plugin is null");
                cg3 cg3Var = new cg3();
                cg3Var.k(17L);
                cg3Var.i(2201L);
                cg3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, cg3Var);
            } else if (!wh3.a(new File(kd4Var.a), kd4Var.m)) {
                nk4.M(kd4Var.a);
                b03.b("download finish, check zip sign failure");
                cg3 cg3Var2 = new cg3();
                cg3Var2.k(17L);
                cg3Var2.i(2202L);
                cg3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(kd4Var, cg3Var2);
            } else {
                File t = fn2.t(kd4Var.g, String.valueOf(kd4Var.i));
                nk4.l(t);
                if (t != null && t.exists()) {
                    boolean U = nk4.U(kd4Var.a, t.getAbsolutePath());
                    nk4.M(kd4Var.a);
                    b03.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        cg3 cg3Var3 = new cg3();
                        cg3Var3.k(17L);
                        cg3Var3.i(2320L);
                        cg3Var3.d("plugin unzip fail.");
                        p(kd4Var, cg3Var3);
                        return;
                    }
                    kd4Var.c = kd4Var.b();
                    kd4Var.d = kd4Var.b();
                    gc4.i().m(kd4Var);
                    q(kd4Var);
                    return;
                }
                nk4.M(kd4Var.a);
                b03.b("download finish, create file failure, name = " + kd4Var.g + " ; version = " + kd4Var.i);
                cg3 cg3Var4 = new cg3();
                cg3Var4.k(17L);
                cg3Var4.i(2203L);
                cg3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(kd4Var, cg3Var4);
            }
        }
    }
}
