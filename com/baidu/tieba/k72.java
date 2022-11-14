package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.b72;
import com.baidu.tieba.bn2;
import com.baidu.tieba.j72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class k72<T extends j72> extends tb4<gd4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull gd4 gd4Var);

    public abstract void u(gd4 gd4Var, yf3 yf3Var);

    /* loaded from: classes4.dex */
    public class a implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gd4 a;
        public final /* synthetic */ k72 b;

        public a(k72 k72Var, gd4 gd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k72Var, gd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k72Var;
            this.a = gd4Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) == null) {
                this.b.u(this.a, yf3Var);
            }
        }
    }

    public k72(@NonNull T t) {
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
    @Override // com.baidu.tieba.wb4
    /* renamed from: l */
    public String d(gd4 gd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gd4Var)) == null) {
            return bn2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gd4Var) == null) {
            r(gd4Var);
            b72.c().b(gd4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
    /* renamed from: v */
    public void c(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gd4Var) == null) {
            super.c(gd4Var);
            if (gd4Var != null) {
                xz2.b("plugin download start: bundleId = " + gd4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
    /* renamed from: w */
    public void f(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gd4Var) == null) {
            super.f(gd4Var);
            if (gd4Var != null) {
                xz2.b("plugin on downloading: bundleId = " + gd4Var.g);
            }
            x(gd4Var);
        }
    }

    public final void x(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gd4Var) == null) {
            b72.c().d(gd4Var, new a(this, gd4Var));
        }
    }

    @Override // com.baidu.tieba.yb4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(gd4 gd4Var, yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gd4Var, yf3Var) == null) {
            u(gd4Var, yf3Var);
            b72.c().a(gd4Var, o(), yf3Var);
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
    @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
    /* renamed from: s */
    public void e(gd4 gd4Var, zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, gd4Var, zc4Var) == null) {
            super.e(gd4Var, zc4Var);
            xz2.b("plugin download error: " + zc4Var);
            yf3 yf3Var = new yf3();
            yf3Var.k(17L);
            yf3Var.i((long) zc4Var.a);
            yf3Var.d(zc4Var.b);
            yf3Var.f(zc4Var.toString());
            p(gd4Var, yf3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
    /* renamed from: t */
    public void i(gd4 gd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gd4Var) == null) {
            super.i(gd4Var);
            if (gd4Var == null) {
                xz2.b("download finish, plugin is null");
                yf3 yf3Var = new yf3();
                yf3Var.k(17L);
                yf3Var.i(2201L);
                yf3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, yf3Var);
            } else if (!sh3.a(new File(gd4Var.a), gd4Var.m)) {
                jk4.M(gd4Var.a);
                xz2.b("download finish, check zip sign failure");
                yf3 yf3Var2 = new yf3();
                yf3Var2.k(17L);
                yf3Var2.i(2202L);
                yf3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(gd4Var, yf3Var2);
            } else {
                File t = bn2.t(gd4Var.g, String.valueOf(gd4Var.i));
                jk4.l(t);
                if (t != null && t.exists()) {
                    boolean U = jk4.U(gd4Var.a, t.getAbsolutePath());
                    jk4.M(gd4Var.a);
                    xz2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        yf3 yf3Var3 = new yf3();
                        yf3Var3.k(17L);
                        yf3Var3.i(2320L);
                        yf3Var3.d("plugin unzip fail.");
                        p(gd4Var, yf3Var3);
                        return;
                    }
                    gd4Var.c = gd4Var.b();
                    gd4Var.d = gd4Var.b();
                    cc4.i().m(gd4Var);
                    q(gd4Var);
                    return;
                }
                jk4.M(gd4Var.a);
                xz2.b("download finish, create file failure, name = " + gd4Var.g + " ; version = " + gd4Var.i);
                yf3 yf3Var4 = new yf3();
                yf3Var4.k(17L);
                yf3Var4.i(2203L);
                yf3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(gd4Var, yf3Var4);
            }
        }
    }
}
