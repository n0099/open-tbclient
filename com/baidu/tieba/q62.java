package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.h62;
import com.baidu.tieba.hm2;
import com.baidu.tieba.p62;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class q62<T extends p62> extends za4<mc4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    /* loaded from: classes5.dex */
    public class a implements h62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mc4 a;
        public final /* synthetic */ q62 b;

        public a(q62 q62Var, mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q62Var, mc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q62Var;
            this.a = mc4Var;
        }

        @Override // com.baidu.tieba.h62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.h62.c
        public void b(PMSDownloadType pMSDownloadType, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ef3Var) == null) {
                this.b.u(this.a, ef3Var);
            }
        }
    }

    public q62(@NonNull T t) {
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
    @Override // com.baidu.tieba.cb4
    /* renamed from: l */
    public String d(mc4 mc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mc4Var)) == null) ? hm2.e.h().getAbsolutePath() : (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.eb4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
    }

    public PMSDownloadType o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? PMSDownloadType.PLUGIN : (PMSDownloadType) invokeV.objValue;
    }

    public final void p(mc4 mc4Var, ef3 ef3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mc4Var, ef3Var) == null) {
            u(mc4Var, ef3Var);
            h62.c().a(mc4Var, o(), ef3Var);
        }
    }

    public final void q(@NonNull mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mc4Var) == null) {
            r(mc4Var);
            h62.c().b(mc4Var, o());
        }
    }

    public abstract void r(@NonNull mc4 mc4Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
    /* renamed from: s */
    public void e(mc4 mc4Var, fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, mc4Var, fc4Var) == null) {
            super.e(mc4Var, fc4Var);
            dz2.b("plugin download error: " + fc4Var);
            ef3 ef3Var = new ef3();
            ef3Var.k(17L);
            ef3Var.i((long) fc4Var.a);
            ef3Var.d(fc4Var.b);
            ef3Var.f(fc4Var.toString());
            p(mc4Var, ef3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
    /* renamed from: t */
    public void i(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mc4Var) == null) {
            super.i(mc4Var);
            if (mc4Var == null) {
                dz2.b("download finish, plugin is null");
                ef3 ef3Var = new ef3();
                ef3Var.k(17L);
                ef3Var.i(2201L);
                ef3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, ef3Var);
            } else if (!yg3.a(new File(mc4Var.a), mc4Var.m)) {
                pj4.M(mc4Var.a);
                dz2.b("download finish, check zip sign failure");
                ef3 ef3Var2 = new ef3();
                ef3Var2.k(17L);
                ef3Var2.i(2202L);
                ef3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(mc4Var, ef3Var2);
            } else {
                File t = hm2.t(mc4Var.g, String.valueOf(mc4Var.i));
                pj4.l(t);
                if (t != null && t.exists()) {
                    boolean U = pj4.U(mc4Var.a, t.getAbsolutePath());
                    pj4.M(mc4Var.a);
                    dz2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        ef3 ef3Var3 = new ef3();
                        ef3Var3.k(17L);
                        ef3Var3.i(2320L);
                        ef3Var3.d("plugin unzip fail.");
                        p(mc4Var, ef3Var3);
                        return;
                    }
                    mc4Var.c = mc4Var.b();
                    mc4Var.d = mc4Var.b();
                    ib4.i().m(mc4Var);
                    q(mc4Var);
                    return;
                }
                pj4.M(mc4Var.a);
                dz2.b("download finish, create file failure, name = " + mc4Var.g + " ; version = " + mc4Var.i);
                ef3 ef3Var4 = new ef3();
                ef3Var4.k(17L);
                ef3Var4.i(2203L);
                ef3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(mc4Var, ef3Var4);
            }
        }
    }

    public abstract void u(mc4 mc4Var, ef3 ef3Var);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
    /* renamed from: v */
    public void c(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, mc4Var) == null) {
            super.c(mc4Var);
            if (mc4Var != null) {
                dz2.b("plugin download start: bundleId = " + mc4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.za4, com.baidu.tieba.cb4
    /* renamed from: w */
    public void f(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mc4Var) == null) {
            super.f(mc4Var);
            if (mc4Var != null) {
                dz2.b("plugin on downloading: bundleId = " + mc4Var.g);
            }
            x(mc4Var);
        }
    }

    public final void x(mc4 mc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, mc4Var) == null) {
            h62.c().d(mc4Var, new a(this, mc4Var));
        }
    }
}
