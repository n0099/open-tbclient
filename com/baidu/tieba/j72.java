package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.a72;
import com.baidu.tieba.an2;
import com.baidu.tieba.i72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class j72<T extends i72> extends sb4<fd4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull fd4 fd4Var);

    public abstract void u(fd4 fd4Var, xf3 xf3Var);

    /* loaded from: classes5.dex */
    public class a implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fd4 a;
        public final /* synthetic */ j72 b;

        public a(j72 j72Var, fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j72Var, fd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j72Var;
            this.a = fd4Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) == null) {
                this.b.u(this.a, xf3Var);
            }
        }
    }

    public j72(@NonNull T t) {
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
    @Override // com.baidu.tieba.vb4
    /* renamed from: l */
    public String d(fd4 fd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fd4Var)) == null) {
            return an2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fd4Var) == null) {
            r(fd4Var);
            a72.c().b(fd4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
    /* renamed from: v */
    public void c(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fd4Var) == null) {
            super.c(fd4Var);
            if (fd4Var != null) {
                wz2.b("plugin download start: bundleId = " + fd4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
    /* renamed from: w */
    public void f(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, fd4Var) == null) {
            super.f(fd4Var);
            if (fd4Var != null) {
                wz2.b("plugin on downloading: bundleId = " + fd4Var.g);
            }
            x(fd4Var);
        }
    }

    public final void x(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fd4Var) == null) {
            a72.c().d(fd4Var, new a(this, fd4Var));
        }
    }

    @Override // com.baidu.tieba.xb4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(fd4 fd4Var, xf3 xf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fd4Var, xf3Var) == null) {
            u(fd4Var, xf3Var);
            a72.c().a(fd4Var, o(), xf3Var);
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
    @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
    /* renamed from: s */
    public void e(fd4 fd4Var, yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, fd4Var, yc4Var) == null) {
            super.e(fd4Var, yc4Var);
            wz2.b("plugin download error: " + yc4Var);
            xf3 xf3Var = new xf3();
            xf3Var.k(17L);
            xf3Var.i((long) yc4Var.a);
            xf3Var.d(yc4Var.b);
            xf3Var.f(yc4Var.toString());
            p(fd4Var, xf3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
    /* renamed from: t */
    public void i(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, fd4Var) == null) {
            super.i(fd4Var);
            if (fd4Var == null) {
                wz2.b("download finish, plugin is null");
                xf3 xf3Var = new xf3();
                xf3Var.k(17L);
                xf3Var.i(2201L);
                xf3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, xf3Var);
            } else if (!rh3.a(new File(fd4Var.a), fd4Var.m)) {
                ik4.M(fd4Var.a);
                wz2.b("download finish, check zip sign failure");
                xf3 xf3Var2 = new xf3();
                xf3Var2.k(17L);
                xf3Var2.i(2202L);
                xf3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(fd4Var, xf3Var2);
            } else {
                File t = an2.t(fd4Var.g, String.valueOf(fd4Var.i));
                ik4.l(t);
                if (t != null && t.exists()) {
                    boolean U = ik4.U(fd4Var.a, t.getAbsolutePath());
                    ik4.M(fd4Var.a);
                    wz2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        xf3 xf3Var3 = new xf3();
                        xf3Var3.k(17L);
                        xf3Var3.i(2320L);
                        xf3Var3.d("plugin unzip fail.");
                        p(fd4Var, xf3Var3);
                        return;
                    }
                    fd4Var.c = fd4Var.b();
                    fd4Var.d = fd4Var.b();
                    bc4.i().m(fd4Var);
                    q(fd4Var);
                    return;
                }
                ik4.M(fd4Var.a);
                wz2.b("download finish, create file failure, name = " + fd4Var.g + " ; version = " + fd4Var.i);
                xf3 xf3Var4 = new xf3();
                xf3Var4.k(17L);
                xf3Var4.i(2203L);
                xf3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(fd4Var, xf3Var4);
            }
        }
    }
}
