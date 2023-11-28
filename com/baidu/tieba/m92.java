package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.d92;
import com.baidu.tieba.dp2;
import com.baidu.tieba.l92;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class m92<T extends l92> extends vd4<if4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull if4 if4Var);

    public abstract void u(if4 if4Var, ai3 ai3Var);

    /* loaded from: classes7.dex */
    public class a implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ if4 a;
        public final /* synthetic */ m92 b;

        public a(m92 m92Var, if4 if4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m92Var, if4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m92Var;
            this.a = if4Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) == null) {
                this.b.u(this.a, ai3Var);
            }
        }
    }

    public m92(@NonNull T t) {
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
    @Override // com.baidu.tieba.yd4
    /* renamed from: l */
    public String d(if4 if4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, if4Var)) == null) {
            return dp2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull if4 if4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, if4Var) == null) {
            r(if4Var);
            d92.c().b(if4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
    /* renamed from: v */
    public void c(if4 if4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, if4Var) == null) {
            super.c(if4Var);
            if (if4Var != null) {
                z13.b("plugin download start: bundleId = " + if4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
    /* renamed from: w */
    public void f(if4 if4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, if4Var) == null) {
            super.f(if4Var);
            if (if4Var != null) {
                z13.b("plugin on downloading: bundleId = " + if4Var.g);
            }
            x(if4Var);
        }
    }

    public final void x(if4 if4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, if4Var) == null) {
            d92.c().d(if4Var, new a(this, if4Var));
        }
    }

    @Override // com.baidu.tieba.ae4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(if4 if4Var, ai3 ai3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, if4Var, ai3Var) == null) {
            u(if4Var, ai3Var);
            d92.c().a(if4Var, o(), ai3Var);
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
    @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
    /* renamed from: s */
    public void e(if4 if4Var, bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, if4Var, bf4Var) == null) {
            super.e(if4Var, bf4Var);
            z13.b("plugin download error: " + bf4Var);
            ai3 ai3Var = new ai3();
            ai3Var.k(17L);
            ai3Var.i((long) bf4Var.a);
            ai3Var.d(bf4Var.b);
            ai3Var.f(bf4Var.toString());
            p(if4Var, ai3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
    /* renamed from: t */
    public void i(if4 if4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, if4Var) == null) {
            super.i(if4Var);
            if (if4Var == null) {
                z13.b("download finish, plugin is null");
                ai3 ai3Var = new ai3();
                ai3Var.k(17L);
                ai3Var.i(2201L);
                ai3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, ai3Var);
            } else if (!uj3.a(new File(if4Var.a), if4Var.m)) {
                km4.M(if4Var.a);
                z13.b("download finish, check zip sign failure");
                ai3 ai3Var2 = new ai3();
                ai3Var2.k(17L);
                ai3Var2.i(2202L);
                ai3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(if4Var, ai3Var2);
            } else {
                File t = dp2.t(if4Var.g, String.valueOf(if4Var.i));
                km4.l(t);
                if (t != null && t.exists()) {
                    boolean U = km4.U(if4Var.a, t.getAbsolutePath());
                    km4.M(if4Var.a);
                    z13.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        ai3 ai3Var3 = new ai3();
                        ai3Var3.k(17L);
                        ai3Var3.i(2320L);
                        ai3Var3.d("plugin unzip fail.");
                        p(if4Var, ai3Var3);
                        return;
                    }
                    if4Var.c = if4Var.b();
                    if4Var.d = if4Var.b();
                    ee4.i().m(if4Var);
                    q(if4Var);
                    return;
                }
                km4.M(if4Var.a);
                z13.b("download finish, create file failure, name = " + if4Var.g + " ; version = " + if4Var.i);
                ai3 ai3Var4 = new ai3();
                ai3Var4.k(17L);
                ai3Var4.i(2203L);
                ai3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(if4Var, ai3Var4);
            }
        }
    }
}
