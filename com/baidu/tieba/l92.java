package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.c92;
import com.baidu.tieba.cp2;
import com.baidu.tieba.k92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class l92<T extends k92> extends ud4<hf4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull hf4 hf4Var);

    public abstract void u(hf4 hf4Var, zh3 zh3Var);

    /* loaded from: classes7.dex */
    public class a implements c92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf4 a;
        public final /* synthetic */ l92 b;

        public a(l92 l92Var, hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l92Var, hf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l92Var;
            this.a = hf4Var;
        }

        @Override // com.baidu.tieba.c92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.c92.c
        public void b(PMSDownloadType pMSDownloadType, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zh3Var) == null) {
                this.b.u(this.a, zh3Var);
            }
        }
    }

    public l92(@NonNull T t) {
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
    @Override // com.baidu.tieba.xd4
    /* renamed from: l */
    public String d(hf4 hf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hf4Var)) == null) {
            return cp2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hf4Var) == null) {
            r(hf4Var);
            c92.c().b(hf4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
    /* renamed from: v */
    public void c(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hf4Var) == null) {
            super.c(hf4Var);
            if (hf4Var != null) {
                y13.b("plugin download start: bundleId = " + hf4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
    /* renamed from: w */
    public void f(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hf4Var) == null) {
            super.f(hf4Var);
            if (hf4Var != null) {
                y13.b("plugin on downloading: bundleId = " + hf4Var.g);
            }
            x(hf4Var);
        }
    }

    public final void x(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hf4Var) == null) {
            c92.c().d(hf4Var, new a(this, hf4Var));
        }
    }

    @Override // com.baidu.tieba.zd4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(hf4 hf4Var, zh3 zh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hf4Var, zh3Var) == null) {
            u(hf4Var, zh3Var);
            c92.c().a(hf4Var, o(), zh3Var);
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
    @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
    /* renamed from: s */
    public void e(hf4 hf4Var, af4 af4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, hf4Var, af4Var) == null) {
            super.e(hf4Var, af4Var);
            y13.b("plugin download error: " + af4Var);
            zh3 zh3Var = new zh3();
            zh3Var.k(17L);
            zh3Var.i((long) af4Var.a);
            zh3Var.d(af4Var.b);
            zh3Var.f(af4Var.toString());
            p(hf4Var, zh3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
    /* renamed from: t */
    public void i(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hf4Var) == null) {
            super.i(hf4Var);
            if (hf4Var == null) {
                y13.b("download finish, plugin is null");
                zh3 zh3Var = new zh3();
                zh3Var.k(17L);
                zh3Var.i(2201L);
                zh3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, zh3Var);
            } else if (!tj3.a(new File(hf4Var.a), hf4Var.m)) {
                jm4.M(hf4Var.a);
                y13.b("download finish, check zip sign failure");
                zh3 zh3Var2 = new zh3();
                zh3Var2.k(17L);
                zh3Var2.i(2202L);
                zh3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(hf4Var, zh3Var2);
            } else {
                File t = cp2.t(hf4Var.g, String.valueOf(hf4Var.i));
                jm4.l(t);
                if (t != null && t.exists()) {
                    boolean U = jm4.U(hf4Var.a, t.getAbsolutePath());
                    jm4.M(hf4Var.a);
                    y13.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        zh3 zh3Var3 = new zh3();
                        zh3Var3.k(17L);
                        zh3Var3.i(2320L);
                        zh3Var3.d("plugin unzip fail.");
                        p(hf4Var, zh3Var3);
                        return;
                    }
                    hf4Var.c = hf4Var.b();
                    hf4Var.d = hf4Var.b();
                    de4.i().m(hf4Var);
                    q(hf4Var);
                    return;
                }
                jm4.M(hf4Var.a);
                y13.b("download finish, create file failure, name = " + hf4Var.g + " ; version = " + hf4Var.i);
                zh3 zh3Var4 = new zh3();
                zh3Var4.k(17L);
                zh3Var4.i(2203L);
                zh3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(hf4Var, zh3Var4);
            }
        }
    }
}
