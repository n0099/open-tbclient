package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.c92;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes9.dex */
public class x92 extends k92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public b92 c;
    public String d;
    public String e;
    public xd4<gf4> f;

    /* loaded from: classes9.dex */
    public class a extends ud4<gf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x92 a;

        public a(x92 x92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xd4
        /* renamed from: l */
        public String d(gf4 gf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gf4Var)) == null) {
                return z92.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: q */
        public void f(gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gf4Var) == null) {
                super.f(gf4Var);
                if (x92.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(gf4Var);
            }
        }

        @Override // com.baidu.tieba.zd4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: o */
        public void e(gf4 gf4Var, af4 af4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gf4Var, af4Var) == null) {
                super.e(gf4Var, af4Var);
                if (x92.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + af4Var.toString());
                }
                zh3 zh3Var = new zh3();
                zh3Var.k(12L);
                zh3Var.i(af4Var.a);
                zh3Var.d("分包下载失败");
                zh3Var.f(af4Var.toString());
                this.a.S(3, zh3Var);
                c92.c().a(gf4Var, PMSDownloadType.ALONE_SUB, zh3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ud4, com.baidu.tieba.xd4
        /* renamed from: p */
        public void i(gf4 gf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gf4Var) == null) {
                super.i(gf4Var);
                if (x92.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + gf4Var.toString());
                }
                this.a.U(gf4Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x92 a;

        public b(x92 x92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x92Var;
        }

        @Override // com.baidu.tieba.c92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.c92.c
        public void b(PMSDownloadType pMSDownloadType, zh3 zh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zh3Var) != null) {
                return;
            }
            this.a.S(0, zh3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948255128, "Lcom/baidu/tieba/x92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948255128, "Lcom/baidu/tieba/x92;");
                return;
            }
        }
        g = rm1.a;
    }

    @Override // com.baidu.tieba.be4
    public xd4<gf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (xd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.be4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            zh3 zh3Var = new zh3();
            zh3Var.k(12L);
            zh3Var.i(2901L);
            zh3Var.d("Server无包");
            S(2, zh3Var);
        }
    }

    public final void T() {
        b92 b92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (b92Var = this.c) != null) {
            b92Var.a();
        }
    }

    public x92(String str, String str2, b92 b92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, b92Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        this.d = str;
        this.c = b92Var;
        this.e = cp2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.be4
    public void C(af4 af4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af4Var) == null) {
            super.C(af4Var);
            zh3 zh3Var = new zh3();
            zh3Var.k(12L);
            zh3Var.c(af4Var);
            S(1, zh3Var);
        }
    }

    public final void V(gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gf4Var) == null) {
            c92.c().d(gf4Var, new b(this));
        }
    }

    public final void S(int i, zh3 zh3Var) {
        b92 b92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, zh3Var) == null) && (b92Var = this.c) != null) {
            b92Var.b(i, zh3Var);
        }
    }

    public final void U(gf4 gf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gf4Var) == null) {
            if (!tj3.a(new File(gf4Var.a), gf4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                zh3 zh3Var = new zh3();
                zh3Var.k(12L);
                zh3Var.i(2300L);
                zh3Var.d("分包签名校验");
                S(4, zh3Var);
                c92.c().a(gf4Var, PMSDownloadType.ALONE_SUB, zh3Var);
            } else if (z92.h(new File(gf4Var.a), new File(this.e, gf4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                gf4Var.o = this.d;
                de4.i().m(gf4Var);
                T();
                c92.c().b(gf4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                zh3 zh3Var2 = new zh3();
                zh3Var2.k(12L);
                zh3Var2.i(2320L);
                zh3Var2.d("分包解压失败");
                S(5, zh3Var2);
                c92.c().a(gf4Var, PMSDownloadType.ALONE_SUB, zh3Var2);
            }
        }
    }
}
