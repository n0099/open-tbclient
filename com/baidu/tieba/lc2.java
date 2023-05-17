package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.cc2;
import com.baidu.tieba.cs2;
import com.baidu.tieba.kc2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class lc2<T extends kc2> extends ug4<hi4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull hi4 hi4Var);

    public abstract void u(hi4 hi4Var, zk3 zk3Var);

    /* loaded from: classes6.dex */
    public class a implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hi4 a;
        public final /* synthetic */ lc2 b;

        public a(lc2 lc2Var, hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lc2Var, hi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lc2Var;
            this.a = hi4Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) == null) {
                this.b.u(this.a, zk3Var);
            }
        }
    }

    public lc2(@NonNull T t) {
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
    @Override // com.baidu.tieba.xg4
    /* renamed from: l */
    public String d(hi4 hi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hi4Var)) == null) {
            return cs2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull hi4 hi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hi4Var) == null) {
            r(hi4Var);
            cc2.c().b(hi4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
    /* renamed from: v */
    public void c(hi4 hi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hi4Var) == null) {
            super.c(hi4Var);
            if (hi4Var != null) {
                y43.b("plugin download start: bundleId = " + hi4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
    /* renamed from: w */
    public void f(hi4 hi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hi4Var) == null) {
            super.f(hi4Var);
            if (hi4Var != null) {
                y43.b("plugin on downloading: bundleId = " + hi4Var.g);
            }
            x(hi4Var);
        }
    }

    public final void x(hi4 hi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hi4Var) == null) {
            cc2.c().d(hi4Var, new a(this, hi4Var));
        }
    }

    @Override // com.baidu.tieba.zg4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(hi4 hi4Var, zk3 zk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hi4Var, zk3Var) == null) {
            u(hi4Var, zk3Var);
            cc2.c().a(hi4Var, o(), zk3Var);
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
    @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
    /* renamed from: s */
    public void e(hi4 hi4Var, ai4 ai4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, hi4Var, ai4Var) == null) {
            super.e(hi4Var, ai4Var);
            y43.b("plugin download error: " + ai4Var);
            zk3 zk3Var = new zk3();
            zk3Var.k(17L);
            zk3Var.i((long) ai4Var.a);
            zk3Var.d(ai4Var.b);
            zk3Var.f(ai4Var.toString());
            p(hi4Var, zk3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
    /* renamed from: t */
    public void i(hi4 hi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hi4Var) == null) {
            super.i(hi4Var);
            if (hi4Var == null) {
                y43.b("download finish, plugin is null");
                zk3 zk3Var = new zk3();
                zk3Var.k(17L);
                zk3Var.i(2201L);
                zk3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, zk3Var);
            } else if (!tm3.a(new File(hi4Var.a), hi4Var.m)) {
                kp4.M(hi4Var.a);
                y43.b("download finish, check zip sign failure");
                zk3 zk3Var2 = new zk3();
                zk3Var2.k(17L);
                zk3Var2.i(2202L);
                zk3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(hi4Var, zk3Var2);
            } else {
                File t = cs2.t(hi4Var.g, String.valueOf(hi4Var.i));
                kp4.l(t);
                if (t != null && t.exists()) {
                    boolean U = kp4.U(hi4Var.a, t.getAbsolutePath());
                    kp4.M(hi4Var.a);
                    y43.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        zk3 zk3Var3 = new zk3();
                        zk3Var3.k(17L);
                        zk3Var3.i(2320L);
                        zk3Var3.d("plugin unzip fail.");
                        p(hi4Var, zk3Var3);
                        return;
                    }
                    hi4Var.c = hi4Var.b();
                    hi4Var.d = hi4Var.b();
                    dh4.i().m(hi4Var);
                    q(hi4Var);
                    return;
                }
                kp4.M(hi4Var.a);
                y43.b("download finish, create file failure, name = " + hi4Var.g + " ; version = " + hi4Var.i);
                zk3 zk3Var4 = new zk3();
                zk3Var4.k(17L);
                zk3Var4.i(2203L);
                zk3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(hi4Var, zk3Var4);
            }
        }
    }
}
