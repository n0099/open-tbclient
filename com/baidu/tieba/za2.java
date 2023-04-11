package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.qa2;
import com.baidu.tieba.qq2;
import com.baidu.tieba.ya2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class za2<T extends ya2> extends if4<vg4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull vg4 vg4Var);

    public abstract void u(vg4 vg4Var, nj3 nj3Var);

    /* loaded from: classes7.dex */
    public class a implements qa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vg4 a;
        public final /* synthetic */ za2 b;

        public a(za2 za2Var, vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za2Var, vg4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = za2Var;
            this.a = vg4Var;
        }

        @Override // com.baidu.tieba.qa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.qa2.c
        public void b(PMSDownloadType pMSDownloadType, nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nj3Var) == null) {
                this.b.u(this.a, nj3Var);
            }
        }
    }

    public za2(@NonNull T t) {
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
    @Override // com.baidu.tieba.lf4
    /* renamed from: l */
    public String d(vg4 vg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vg4Var)) == null) {
            return qq2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, vg4Var) == null) {
            r(vg4Var);
            qa2.c().b(vg4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
    /* renamed from: v */
    public void c(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, vg4Var) == null) {
            super.c(vg4Var);
            if (vg4Var != null) {
                m33.b("plugin download start: bundleId = " + vg4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
    /* renamed from: w */
    public void f(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, vg4Var) == null) {
            super.f(vg4Var);
            if (vg4Var != null) {
                m33.b("plugin on downloading: bundleId = " + vg4Var.g);
            }
            x(vg4Var);
        }
    }

    public final void x(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, vg4Var) == null) {
            qa2.c().d(vg4Var, new a(this, vg4Var));
        }
    }

    @Override // com.baidu.tieba.nf4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(vg4 vg4Var, nj3 nj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vg4Var, nj3Var) == null) {
            u(vg4Var, nj3Var);
            qa2.c().a(vg4Var, o(), nj3Var);
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
    @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
    /* renamed from: s */
    public void e(vg4 vg4Var, og4 og4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, vg4Var, og4Var) == null) {
            super.e(vg4Var, og4Var);
            m33.b("plugin download error: " + og4Var);
            nj3 nj3Var = new nj3();
            nj3Var.k(17L);
            nj3Var.i((long) og4Var.a);
            nj3Var.d(og4Var.b);
            nj3Var.f(og4Var.toString());
            p(vg4Var, nj3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
    /* renamed from: t */
    public void i(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, vg4Var) == null) {
            super.i(vg4Var);
            if (vg4Var == null) {
                m33.b("download finish, plugin is null");
                nj3 nj3Var = new nj3();
                nj3Var.k(17L);
                nj3Var.i(2201L);
                nj3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, nj3Var);
            } else if (!hl3.a(new File(vg4Var.a), vg4Var.m)) {
                yn4.M(vg4Var.a);
                m33.b("download finish, check zip sign failure");
                nj3 nj3Var2 = new nj3();
                nj3Var2.k(17L);
                nj3Var2.i(2202L);
                nj3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(vg4Var, nj3Var2);
            } else {
                File t = qq2.t(vg4Var.g, String.valueOf(vg4Var.i));
                yn4.l(t);
                if (t != null && t.exists()) {
                    boolean U = yn4.U(vg4Var.a, t.getAbsolutePath());
                    yn4.M(vg4Var.a);
                    m33.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        nj3 nj3Var3 = new nj3();
                        nj3Var3.k(17L);
                        nj3Var3.i(2320L);
                        nj3Var3.d("plugin unzip fail.");
                        p(vg4Var, nj3Var3);
                        return;
                    }
                    vg4Var.c = vg4Var.b();
                    vg4Var.d = vg4Var.b();
                    rf4.i().m(vg4Var);
                    q(vg4Var);
                    return;
                }
                yn4.M(vg4Var.a);
                m33.b("download finish, create file failure, name = " + vg4Var.g + " ; version = " + vg4Var.i);
                nj3 nj3Var4 = new nj3();
                nj3Var4.k(17L);
                nj3Var4.i(2203L);
                nj3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(vg4Var, nj3Var4);
            }
        }
    }
}
