package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.de2;
import com.baidu.tieba.du2;
import com.baidu.tieba.le2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class me2<T extends le2> extends vi4<ik4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull ik4 ik4Var);

    public abstract void u(ik4 ik4Var, an3 an3Var);

    /* loaded from: classes7.dex */
    public class a implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik4 a;
        public final /* synthetic */ me2 b;

        public a(me2 me2Var, ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me2Var, ik4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = me2Var;
            this.a = ik4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) == null) {
                this.b.u(this.a, an3Var);
            }
        }
    }

    public me2(@NonNull T t) {
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
    @Override // com.baidu.tieba.yi4
    /* renamed from: l */
    public String d(ik4 ik4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ik4Var)) == null) {
            return du2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ik4Var) == null) {
            r(ik4Var);
            de2.c().b(ik4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
    /* renamed from: v */
    public void c(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ik4Var) == null) {
            super.c(ik4Var);
            if (ik4Var != null) {
                z63.b("plugin download start: bundleId = " + ik4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
    /* renamed from: w */
    public void f(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ik4Var) == null) {
            super.f(ik4Var);
            if (ik4Var != null) {
                z63.b("plugin on downloading: bundleId = " + ik4Var.g);
            }
            x(ik4Var);
        }
    }

    public final void x(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ik4Var) == null) {
            de2.c().d(ik4Var, new a(this, ik4Var));
        }
    }

    @Override // com.baidu.tieba.aj4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(ik4 ik4Var, an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ik4Var, an3Var) == null) {
            u(ik4Var, an3Var);
            de2.c().a(ik4Var, o(), an3Var);
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
    @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
    /* renamed from: s */
    public void e(ik4 ik4Var, bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, ik4Var, bk4Var) == null) {
            super.e(ik4Var, bk4Var);
            z63.b("plugin download error: " + bk4Var);
            an3 an3Var = new an3();
            an3Var.k(17L);
            an3Var.i((long) bk4Var.a);
            an3Var.d(bk4Var.b);
            an3Var.f(bk4Var.toString());
            p(ik4Var, an3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
    /* renamed from: t */
    public void i(ik4 ik4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ik4Var) == null) {
            super.i(ik4Var);
            if (ik4Var == null) {
                z63.b("download finish, plugin is null");
                an3 an3Var = new an3();
                an3Var.k(17L);
                an3Var.i(2201L);
                an3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, an3Var);
            } else if (!uo3.a(new File(ik4Var.a), ik4Var.m)) {
                lr4.M(ik4Var.a);
                z63.b("download finish, check zip sign failure");
                an3 an3Var2 = new an3();
                an3Var2.k(17L);
                an3Var2.i(2202L);
                an3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(ik4Var, an3Var2);
            } else {
                File t = du2.t(ik4Var.g, String.valueOf(ik4Var.i));
                lr4.l(t);
                if (t != null && t.exists()) {
                    boolean U = lr4.U(ik4Var.a, t.getAbsolutePath());
                    lr4.M(ik4Var.a);
                    z63.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        an3 an3Var3 = new an3();
                        an3Var3.k(17L);
                        an3Var3.i(2320L);
                        an3Var3.d("plugin unzip fail.");
                        p(ik4Var, an3Var3);
                        return;
                    }
                    ik4Var.c = ik4Var.b();
                    ik4Var.d = ik4Var.b();
                    ej4.i().m(ik4Var);
                    q(ik4Var);
                    return;
                }
                lr4.M(ik4Var.a);
                z63.b("download finish, create file failure, name = " + ik4Var.g + " ; version = " + ik4Var.i);
                an3 an3Var4 = new an3();
                an3Var4.k(17L);
                an3Var4.i(2203L);
                an3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(ik4Var, an3Var4);
            }
        }
    }
}
