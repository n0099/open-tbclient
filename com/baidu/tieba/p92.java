package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.g92;
import com.baidu.tieba.gp2;
import com.baidu.tieba.o92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class p92<T extends o92> extends yd4<lf4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull lf4 lf4Var);

    public abstract void u(lf4 lf4Var, di3 di3Var);

    /* loaded from: classes7.dex */
    public class a implements g92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lf4 a;
        public final /* synthetic */ p92 b;

        public a(p92 p92Var, lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p92Var, lf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p92Var;
            this.a = lf4Var;
        }

        @Override // com.baidu.tieba.g92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.g92.c
        public void b(PMSDownloadType pMSDownloadType, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, di3Var) == null) {
                this.b.u(this.a, di3Var);
            }
        }
    }

    public p92(@NonNull T t) {
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
    @Override // com.baidu.tieba.be4
    /* renamed from: l */
    public String d(lf4 lf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, lf4Var)) == null) {
            return gp2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lf4Var) == null) {
            r(lf4Var);
            g92.c().b(lf4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
    /* renamed from: v */
    public void c(lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, lf4Var) == null) {
            super.c(lf4Var);
            if (lf4Var != null) {
                c23.b("plugin download start: bundleId = " + lf4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
    /* renamed from: w */
    public void f(lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, lf4Var) == null) {
            super.f(lf4Var);
            if (lf4Var != null) {
                c23.b("plugin on downloading: bundleId = " + lf4Var.g);
            }
            x(lf4Var);
        }
    }

    public final void x(lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, lf4Var) == null) {
            g92.c().d(lf4Var, new a(this, lf4Var));
        }
    }

    @Override // com.baidu.tieba.de4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(lf4 lf4Var, di3 di3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lf4Var, di3Var) == null) {
            u(lf4Var, di3Var);
            g92.c().a(lf4Var, o(), di3Var);
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
    @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
    /* renamed from: s */
    public void e(lf4 lf4Var, ef4 ef4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, lf4Var, ef4Var) == null) {
            super.e(lf4Var, ef4Var);
            c23.b("plugin download error: " + ef4Var);
            di3 di3Var = new di3();
            di3Var.k(17L);
            di3Var.i((long) ef4Var.a);
            di3Var.d(ef4Var.b);
            di3Var.f(ef4Var.toString());
            p(lf4Var, di3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4, com.baidu.tieba.be4
    /* renamed from: t */
    public void i(lf4 lf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, lf4Var) == null) {
            super.i(lf4Var);
            if (lf4Var == null) {
                c23.b("download finish, plugin is null");
                di3 di3Var = new di3();
                di3Var.k(17L);
                di3Var.i(2201L);
                di3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, di3Var);
            } else if (!xj3.a(new File(lf4Var.a), lf4Var.m)) {
                nm4.M(lf4Var.a);
                c23.b("download finish, check zip sign failure");
                di3 di3Var2 = new di3();
                di3Var2.k(17L);
                di3Var2.i(2202L);
                di3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(lf4Var, di3Var2);
            } else {
                File t = gp2.t(lf4Var.g, String.valueOf(lf4Var.i));
                nm4.l(t);
                if (t != null && t.exists()) {
                    boolean U = nm4.U(lf4Var.a, t.getAbsolutePath());
                    nm4.M(lf4Var.a);
                    c23.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        di3 di3Var3 = new di3();
                        di3Var3.k(17L);
                        di3Var3.i(2320L);
                        di3Var3.d("plugin unzip fail.");
                        p(lf4Var, di3Var3);
                        return;
                    }
                    lf4Var.c = lf4Var.b();
                    lf4Var.d = lf4Var.b();
                    he4.i().m(lf4Var);
                    q(lf4Var);
                    return;
                }
                nm4.M(lf4Var.a);
                c23.b("download finish, create file failure, name = " + lf4Var.g + " ; version = " + lf4Var.i);
                di3 di3Var4 = new di3();
                di3Var4.k(17L);
                di3Var4.i(2203L);
                di3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(lf4Var, di3Var4);
            }
        }
    }
}
