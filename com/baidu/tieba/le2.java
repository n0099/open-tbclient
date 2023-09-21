package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ce2;
import com.baidu.tieba.cu2;
import com.baidu.tieba.ke2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class le2<T extends ke2> extends ui4<hk4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull hk4 hk4Var);

    public abstract void u(hk4 hk4Var, zm3 zm3Var);

    /* loaded from: classes6.dex */
    public class a implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk4 a;
        public final /* synthetic */ le2 b;

        public a(le2 le2Var, hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {le2Var, hk4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = le2Var;
            this.a = hk4Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) == null) {
                this.b.u(this.a, zm3Var);
            }
        }
    }

    public le2(@NonNull T t) {
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
    @Override // com.baidu.tieba.xi4
    /* renamed from: l */
    public String d(hk4 hk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hk4Var)) == null) {
            return cu2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hk4Var) == null) {
            r(hk4Var);
            ce2.c().b(hk4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
    /* renamed from: v */
    public void c(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hk4Var) == null) {
            super.c(hk4Var);
            if (hk4Var != null) {
                y63.b("plugin download start: bundleId = " + hk4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
    /* renamed from: w */
    public void f(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hk4Var) == null) {
            super.f(hk4Var);
            if (hk4Var != null) {
                y63.b("plugin on downloading: bundleId = " + hk4Var.g);
            }
            x(hk4Var);
        }
    }

    public final void x(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hk4Var) == null) {
            ce2.c().d(hk4Var, new a(this, hk4Var));
        }
    }

    @Override // com.baidu.tieba.zi4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(hk4 hk4Var, zm3 zm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk4Var, zm3Var) == null) {
            u(hk4Var, zm3Var);
            ce2.c().a(hk4Var, o(), zm3Var);
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
    @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
    /* renamed from: s */
    public void e(hk4 hk4Var, ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, hk4Var, ak4Var) == null) {
            super.e(hk4Var, ak4Var);
            y63.b("plugin download error: " + ak4Var);
            zm3 zm3Var = new zm3();
            zm3Var.k(17L);
            zm3Var.i((long) ak4Var.a);
            zm3Var.d(ak4Var.b);
            zm3Var.f(ak4Var.toString());
            p(hk4Var, zm3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
    /* renamed from: t */
    public void i(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hk4Var) == null) {
            super.i(hk4Var);
            if (hk4Var == null) {
                y63.b("download finish, plugin is null");
                zm3 zm3Var = new zm3();
                zm3Var.k(17L);
                zm3Var.i(2201L);
                zm3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, zm3Var);
            } else if (!to3.a(new File(hk4Var.a), hk4Var.m)) {
                kr4.M(hk4Var.a);
                y63.b("download finish, check zip sign failure");
                zm3 zm3Var2 = new zm3();
                zm3Var2.k(17L);
                zm3Var2.i(2202L);
                zm3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(hk4Var, zm3Var2);
            } else {
                File t = cu2.t(hk4Var.g, String.valueOf(hk4Var.i));
                kr4.l(t);
                if (t != null && t.exists()) {
                    boolean U = kr4.U(hk4Var.a, t.getAbsolutePath());
                    kr4.M(hk4Var.a);
                    y63.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        zm3 zm3Var3 = new zm3();
                        zm3Var3.k(17L);
                        zm3Var3.i(2320L);
                        zm3Var3.d("plugin unzip fail.");
                        p(hk4Var, zm3Var3);
                        return;
                    }
                    hk4Var.c = hk4Var.b();
                    hk4Var.d = hk4Var.b();
                    dj4.i().m(hk4Var);
                    q(hk4Var);
                    return;
                }
                kr4.M(hk4Var.a);
                y63.b("download finish, create file failure, name = " + hk4Var.g + " ; version = " + hk4Var.i);
                zm3 zm3Var4 = new zm3();
                zm3Var4.k(17L);
                zm3Var4.i(2203L);
                zm3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(hk4Var, zm3Var4);
            }
        }
    }
}
