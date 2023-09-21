package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ce2;
import com.baidu.tieba.cu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes8.dex */
public class xe2 extends ke2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public be2 c;
    public String d;
    public String e;
    public xi4<gk4> f;

    /* loaded from: classes8.dex */
    public class a extends ui4<gk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe2 a;

        public a(xe2 xe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi4
        /* renamed from: l */
        public String d(gk4 gk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gk4Var)) == null) {
                return ze2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: q */
        public void f(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gk4Var) == null) {
                super.f(gk4Var);
                if (xe2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(gk4Var);
            }
        }

        @Override // com.baidu.tieba.zi4
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
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: o */
        public void e(gk4 gk4Var, ak4 ak4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gk4Var, ak4Var) == null) {
                super.e(gk4Var, ak4Var);
                if (xe2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + ak4Var.toString());
                }
                zm3 zm3Var = new zm3();
                zm3Var.k(12L);
                zm3Var.i(ak4Var.a);
                zm3Var.d("分包下载失败");
                zm3Var.f(ak4Var.toString());
                this.a.S(3, zm3Var);
                ce2.c().a(gk4Var, PMSDownloadType.ALONE_SUB, zm3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4, com.baidu.tieba.xi4
        /* renamed from: p */
        public void i(gk4 gk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gk4Var) == null) {
                super.i(gk4Var);
                if (xe2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + gk4Var.toString());
                }
                this.a.U(gk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ce2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe2 a;

        public b(xe2 xe2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe2Var;
        }

        @Override // com.baidu.tieba.ce2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ce2.c
        public void b(PMSDownloadType pMSDownloadType, zm3 zm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zm3Var) != null) {
                return;
            }
            this.a.S(0, zm3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948297412, "Lcom/baidu/tieba/xe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948297412, "Lcom/baidu/tieba/xe2;");
                return;
            }
        }
        g = qr1.a;
    }

    @Override // com.baidu.tieba.bj4
    public xi4<gk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (xi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            zm3 zm3Var = new zm3();
            zm3Var.k(12L);
            zm3Var.i(2901L);
            zm3Var.d("Server无包");
            S(2, zm3Var);
        }
    }

    public final void T() {
        be2 be2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (be2Var = this.c) != null) {
            be2Var.a();
        }
    }

    public xe2(String str, String str2, be2 be2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, be2Var};
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
        this.c = be2Var;
        this.e = cu2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.bj4
    public void C(ak4 ak4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ak4Var) == null) {
            super.C(ak4Var);
            zm3 zm3Var = new zm3();
            zm3Var.k(12L);
            zm3Var.c(ak4Var);
            S(1, zm3Var);
        }
    }

    public final void V(gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gk4Var) == null) {
            ce2.c().d(gk4Var, new b(this));
        }
    }

    public final void S(int i, zm3 zm3Var) {
        be2 be2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, zm3Var) == null) && (be2Var = this.c) != null) {
            be2Var.b(i, zm3Var);
        }
    }

    public final void U(gk4 gk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gk4Var) == null) {
            if (!to3.a(new File(gk4Var.a), gk4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                zm3 zm3Var = new zm3();
                zm3Var.k(12L);
                zm3Var.i(2300L);
                zm3Var.d("分包签名校验");
                S(4, zm3Var);
                ce2.c().a(gk4Var, PMSDownloadType.ALONE_SUB, zm3Var);
            } else if (ze2.h(new File(gk4Var.a), new File(this.e, gk4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                gk4Var.o = this.d;
                dj4.i().m(gk4Var);
                T();
                ce2.c().b(gk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                zm3 zm3Var2 = new zm3();
                zm3Var2.k(12L);
                zm3Var2.i(2320L);
                zm3Var2.d("分包解压失败");
                S(5, zm3Var2);
                ce2.c().a(gk4Var, PMSDownloadType.ALONE_SUB, zm3Var2);
            }
        }
    }
}
