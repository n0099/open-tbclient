package com.baidu.tieba;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.i62;
import com.baidu.tieba.im2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public abstract class r62 extends ab4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q62 a;

    public abstract void r(nc4 nc4Var);

    public abstract void u(nc4 nc4Var, ff3 ff3Var);

    /* loaded from: classes5.dex */
    public class a implements i62.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc4 a;
        public final /* synthetic */ r62 b;

        public a(r62 r62Var, nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r62Var, nc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r62Var;
            this.a = nc4Var;
        }

        @Override // com.baidu.tieba.i62.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.b.r(this.a);
            }
        }

        @Override // com.baidu.tieba.i62.c
        public void b(PMSDownloadType pMSDownloadType, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ff3Var) == null) {
                this.b.u(this.a, ff3Var);
            }
        }
    }

    public r62(q62 q62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q62Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = q62Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.db4
    /* renamed from: l */
    public String d(nc4 nc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nc4Var)) == null) {
            return im2.e.h().getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public final void q(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, nc4Var) == null) {
            r(nc4Var);
            i62.c().b(nc4Var, o());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
    /* renamed from: v */
    public void c(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, nc4Var) == null) {
            super.c(nc4Var);
            if (nc4Var != null) {
                ez2.b("plugin download start: bundleId = " + nc4Var.g);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
    /* renamed from: w */
    public void f(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nc4Var) == null) {
            super.f(nc4Var);
            if (nc4Var != null) {
                ez2.b("plugin on downloading: bundleId = " + nc4Var.g);
            }
            x(nc4Var);
        }
    }

    public final void x(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nc4Var) == null) {
            i62.c().d(nc4Var, new a(this, nc4Var));
        }
    }

    @Override // com.baidu.tieba.fb4
    public Bundle m(Bundle bundle, Set set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
            return this.a.m(bundle, set);
        }
        return (Bundle) invokeLL.objValue;
    }

    public final void p(nc4 nc4Var, ff3 ff3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nc4Var, ff3Var) == null) {
            u(nc4Var, ff3Var);
            i62.c().a(nc4Var, o(), ff3Var);
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
    @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
    /* renamed from: s */
    public void e(nc4 nc4Var, gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, nc4Var, gc4Var) == null) {
            super.e(nc4Var, gc4Var);
            ez2.b("plugin download error: " + gc4Var);
            ff3 ff3Var = new ff3();
            ff3Var.k(17L);
            ff3Var.i((long) gc4Var.a);
            ff3Var.d(gc4Var.b);
            ff3Var.f(gc4Var.toString());
            p(nc4Var, ff3Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ab4, com.baidu.tieba.db4
    /* renamed from: t */
    public void i(nc4 nc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, nc4Var) == null) {
            super.i(nc4Var);
            if (nc4Var == null) {
                ez2.b("download finish, plugin is null");
                ff3 ff3Var = new ff3();
                ff3Var.k(17L);
                ff3Var.i(2201L);
                ff3Var.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_NETWORK);
                p(null, ff3Var);
            } else if (!zg3.a(new File(nc4Var.a), nc4Var.m)) {
                qj4.M(nc4Var.a);
                ez2.b("download finish, check zip sign failure");
                ff3 ff3Var2 = new ff3();
                ff3Var2.k(17L);
                ff3Var2.i(2202L);
                ff3Var2.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_MD5);
                p(nc4Var, ff3Var2);
            } else {
                File t = im2.t(nc4Var.g, String.valueOf(nc4Var.i));
                qj4.l(t);
                if (t != null && t.exists()) {
                    boolean U = qj4.U(nc4Var.a, t.getAbsolutePath());
                    qj4.M(nc4Var.a);
                    ez2.b("download finish, unZipSuccess = " + U);
                    if (!U) {
                        ff3 ff3Var3 = new ff3();
                        ff3Var3.k(17L);
                        ff3Var3.i(2320L);
                        ff3Var3.d("plugin unzip fail.");
                        p(nc4Var, ff3Var3);
                        return;
                    }
                    nc4Var.c = nc4Var.b();
                    nc4Var.d = nc4Var.b();
                    jb4.i().m(nc4Var);
                    q(nc4Var);
                    return;
                }
                qj4.M(nc4Var.a);
                ez2.b("download finish, create file failure, name = " + nc4Var.g + " ; version = " + nc4Var.i);
                ff3 ff3Var4 = new ff3();
                ff3Var4.k(17L);
                ff3Var4.i(2203L);
                ff3Var4.d(ErrorConstant.ErrorMsg.DOWNLOAD_ERROR_PATH);
                p(nc4Var, ff3Var4);
            }
        }
    }
}
