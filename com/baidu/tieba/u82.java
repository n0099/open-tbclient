package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.l82;
import com.baidu.tieba.lo2;
import com.baidu.tieba.t82;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class u82<T extends t82> extends dd4<qe4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull qe4 qe4Var);

    public abstract void u(qe4 qe4Var, ih3 ih3Var);

    /* loaded from: classes8.dex */
    public class a implements l82.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe4 a;
        public final /* synthetic */ u82 b;

        public a(u82 u82Var, qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u82Var, qe4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u82Var;
            this.a = qe4Var;
        }

        @Override // com.baidu.tieba.l82.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.l82.c
        public void b(PMSDownloadType pMSDownloadType, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ih3Var) == null) {
                this.b.u(this.a, ih3Var);
            }
        }
    }

    public u82(@NonNull T t) {
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
    @Override // com.baidu.tieba.gd4
    /* renamed from: l */
    public String d(qe4 qe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qe4Var)) == null) {
            return lo2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull qe4 qe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, qe4Var) == null) {
            r(qe4Var);
            l82.c().b(qe4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
    /* renamed from: v */
    public void c(qe4 qe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, qe4Var) == null) {
            super.c(qe4Var);
            if (qe4Var != null) {
                h13.b("plugin download start: bundleId = " + qe4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
    /* renamed from: w */
    public void f(qe4 qe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, qe4Var) == null) {
            super.f(qe4Var);
            if (qe4Var != null) {
                h13.b("plugin on downloading: bundleId = " + qe4Var.g);
            }
            x(qe4Var);
        }
    }

    public final void x(qe4 qe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, qe4Var) == null) {
            l82.c().d(qe4Var, new a(this, qe4Var));
        }
    }

    @Override // com.baidu.tieba.id4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(qe4 qe4Var, ih3 ih3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qe4Var, ih3Var) == null) {
            u(qe4Var, ih3Var);
            l82.c().a(qe4Var, o(), ih3Var);
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
    @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
    /* renamed from: s */
    public void e(qe4 qe4Var, je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, qe4Var, je4Var) == null) {
            super.e(qe4Var, je4Var);
            h13.b("plugin download error: " + je4Var);
            ih3 ih3Var = new ih3();
            ih3Var.k(17L);
            ih3Var.i((long) je4Var.a);
            ih3Var.d(je4Var.b);
            ih3Var.f(je4Var.toString());
            p(qe4Var, ih3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dd4, com.baidu.tieba.gd4
    /* renamed from: t */
    public void i(qe4 qe4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, qe4Var) == null) {
            super.i(qe4Var);
            if (qe4Var == null) {
                h13.b("download finish, plugin is null");
                ih3 ih3Var = new ih3();
                ih3Var.k(17L);
                ih3Var.i(2201L);
                ih3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, ih3Var);
            } else if (!cj3.a(new File(qe4Var.a), qe4Var.m)) {
                sl4.M(qe4Var.a);
                h13.b("download finish, check zip sign failure");
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(17L);
                ih3Var2.i(2202L);
                ih3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(qe4Var, ih3Var2);
            } else {
                File t = lo2.t(qe4Var.g, String.valueOf(qe4Var.i));
                sl4.l(t);
                if (t != null && t.exists()) {
                    boolean U = sl4.U(qe4Var.a, t.getAbsolutePath());
                    sl4.M(qe4Var.a);
                    h13.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        ih3 ih3Var3 = new ih3();
                        ih3Var3.k(17L);
                        ih3Var3.i(2320L);
                        ih3Var3.d("plugin unzip fail.");
                        p(qe4Var, ih3Var3);
                        return;
                    }
                    qe4Var.c = qe4Var.b();
                    qe4Var.d = qe4Var.b();
                    md4.i().m(qe4Var);
                    q(qe4Var);
                    return;
                }
                sl4.M(qe4Var.a);
                h13.b("download finish, create file failure, name = " + qe4Var.g + " ; version = " + qe4Var.i);
                ih3 ih3Var4 = new ih3();
                ih3Var4.k(17L);
                ih3Var4.i(2203L);
                ih3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(qe4Var, ih3Var4);
            }
        }
    }
}
