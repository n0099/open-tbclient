package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.b72;
import com.baidu.tieba.bn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class w72 extends j72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public a72 c;
    public String d;
    public String e;
    public wb4<fd4> f;

    /* loaded from: classes6.dex */
    public class a extends tb4<fd4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w72 a;

        public a(w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wb4
        /* renamed from: l */
        public String d(fd4 fd4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fd4Var)) == null) {
                return y72.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: q */
        public void f(fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fd4Var) == null) {
                super.f(fd4Var);
                if (w72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(fd4Var);
            }
        }

        @Override // com.baidu.tieba.yb4
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
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: o */
        public void e(fd4 fd4Var, zc4 zc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, fd4Var, zc4Var) == null) {
                super.e(fd4Var, zc4Var);
                if (w72.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + zc4Var.toString());
                }
                yf3 yf3Var = new yf3();
                yf3Var.k(12L);
                yf3Var.i(zc4Var.a);
                yf3Var.d("分包下载失败");
                yf3Var.f(zc4Var.toString());
                this.a.S(3, yf3Var);
                b72.c().a(fd4Var, PMSDownloadType.ALONE_SUB, yf3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tb4, com.baidu.tieba.wb4
        /* renamed from: p */
        public void i(fd4 fd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, fd4Var) == null) {
                super.i(fd4Var);
                if (w72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + fd4Var.toString());
                }
                this.a.U(fd4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements b72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w72 a;

        public b(w72 w72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w72Var;
        }

        @Override // com.baidu.tieba.b72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.b72.c
        public void b(PMSDownloadType pMSDownloadType, yf3 yf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, yf3Var) != null) {
                return;
            }
            this.a.S(0, yf3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948223415, "Lcom/baidu/tieba/w72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948223415, "Lcom/baidu/tieba/w72;");
                return;
            }
        }
        g = pk1.a;
    }

    @Override // com.baidu.tieba.ac4
    public wb4<fd4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (wb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ac4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            yf3 yf3Var = new yf3();
            yf3Var.k(12L);
            yf3Var.i(2901L);
            yf3Var.d("Server无包");
            S(2, yf3Var);
        }
    }

    public final void T() {
        a72 a72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (a72Var = this.c) != null) {
            a72Var.a();
        }
    }

    public w72(String str, String str2, a72 a72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, a72Var};
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
        this.c = a72Var;
        this.e = bn2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.ac4
    public void C(zc4 zc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zc4Var) == null) {
            super.C(zc4Var);
            yf3 yf3Var = new yf3();
            yf3Var.k(12L);
            yf3Var.c(zc4Var);
            S(1, yf3Var);
        }
    }

    public final void V(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fd4Var) == null) {
            b72.c().d(fd4Var, new b(this));
        }
    }

    public final void S(int i, yf3 yf3Var) {
        a72 a72Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, yf3Var) == null) && (a72Var = this.c) != null) {
            a72Var.b(i, yf3Var);
        }
    }

    public final void U(fd4 fd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fd4Var) == null) {
            if (!sh3.a(new File(fd4Var.a), fd4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                yf3 yf3Var = new yf3();
                yf3Var.k(12L);
                yf3Var.i(2300L);
                yf3Var.d("分包签名校验");
                S(4, yf3Var);
                b72.c().a(fd4Var, PMSDownloadType.ALONE_SUB, yf3Var);
            } else if (y72.h(new File(fd4Var.a), new File(this.e, fd4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                fd4Var.o = this.d;
                cc4.i().m(fd4Var);
                T();
                b72.c().b(fd4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                yf3 yf3Var2 = new yf3();
                yf3Var2.k(12L);
                yf3Var2.i(2320L);
                yf3Var2.d("分包解压失败");
                S(5, yf3Var2);
                b72.c().a(fd4Var, PMSDownloadType.ALONE_SUB, yf3Var2);
            }
        }
    }
}
