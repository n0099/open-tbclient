package com.baidu.tieba;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.pa2;
import com.baidu.tieba.pq2;
import com.baidu.tieba.xa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class ya2<T extends xa2> extends hf4<ug4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final T a;

    public abstract void r(@NonNull ug4 ug4Var);

    public abstract void u(ug4 ug4Var, mj3 mj3Var);

    /* loaded from: classes7.dex */
    public class a implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ug4 a;
        public final /* synthetic */ ya2 b;

        public a(ya2 ya2Var, ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya2Var, ug4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya2Var;
            this.a = ug4Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) == null) {
                this.b.u(this.a, mj3Var);
            }
        }
    }

    public ya2(@NonNull T t) {
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
    @Override // com.baidu.tieba.kf4
    /* renamed from: l */
    public String d(ug4 ug4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ug4Var)) == null) {
            return pq2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(@NonNull ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ug4Var) == null) {
            r(ug4Var);
            pa2.c().b(ug4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
    /* renamed from: v */
    public void c(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ug4Var) == null) {
            super.c(ug4Var);
            if (ug4Var != null) {
                l33.b("plugin download start: bundleId = " + ug4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
    /* renamed from: w */
    public void f(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ug4Var) == null) {
            super.f(ug4Var);
            if (ug4Var != null) {
                l33.b("plugin on downloading: bundleId = " + ug4Var.g);
            }
            x(ug4Var);
        }
    }

    public final void x(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ug4Var) == null) {
            pa2.c().d(ug4Var, new a(this, ug4Var));
        }
    }

    @Override // com.baidu.tieba.mf4
    @NonNull
    public Bundle m(@NonNull Bundle bundle, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(ug4 ug4Var, mj3 mj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ug4Var, mj3Var) == null) {
            u(ug4Var, mj3Var);
            pa2.c().a(ug4Var, o(), mj3Var);
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
    @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
    /* renamed from: s */
    public void e(ug4 ug4Var, ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, ug4Var, ng4Var) == null) {
            super.e(ug4Var, ng4Var);
            l33.b("plugin download error: " + ng4Var);
            mj3 mj3Var = new mj3();
            mj3Var.k(17L);
            mj3Var.i((long) ng4Var.a);
            mj3Var.d(ng4Var.b);
            mj3Var.f(ng4Var.toString());
            p(ug4Var, mj3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
    /* renamed from: t */
    public void i(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ug4Var) == null) {
            super.i(ug4Var);
            if (ug4Var == null) {
                l33.b("download finish, plugin is null");
                mj3 mj3Var = new mj3();
                mj3Var.k(17L);
                mj3Var.i(2201L);
                mj3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, mj3Var);
            } else if (!gl3.a(new File(ug4Var.a), ug4Var.m)) {
                xn4.M(ug4Var.a);
                l33.b("download finish, check zip sign failure");
                mj3 mj3Var2 = new mj3();
                mj3Var2.k(17L);
                mj3Var2.i(2202L);
                mj3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(ug4Var, mj3Var2);
            } else {
                File t = pq2.t(ug4Var.g, String.valueOf(ug4Var.i));
                xn4.l(t);
                if (t != null && t.exists()) {
                    boolean U = xn4.U(ug4Var.a, t.getAbsolutePath());
                    xn4.M(ug4Var.a);
                    l33.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        mj3 mj3Var3 = new mj3();
                        mj3Var3.k(17L);
                        mj3Var3.i(2320L);
                        mj3Var3.d("plugin unzip fail.");
                        p(ug4Var, mj3Var3);
                        return;
                    }
                    ug4Var.c = ug4Var.b();
                    ug4Var.d = ug4Var.b();
                    qf4.i().m(ug4Var);
                    q(ug4Var);
                    return;
                }
                xn4.M(ug4Var.a);
                l33.b("download finish, create file failure, name = " + ug4Var.g + " ; version = " + ug4Var.i);
                mj3 mj3Var4 = new mj3();
                mj3Var4.k(17L);
                mj3Var4.i(2203L);
                mj3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(ug4Var, mj3Var4);
            }
        }
    }
}
