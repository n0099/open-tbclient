package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.de2;
import com.baidu.tieba.du2;
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
public class ye2 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public ce2 c;
    public String d;
    public String e;
    public yi4<hk4> f;

    /* loaded from: classes8.dex */
    public class a extends vi4<hk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public a(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(hk4 hk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hk4Var)) == null) {
                return af2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void f(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk4Var) == null) {
                super.f(hk4Var);
                if (ye2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(hk4Var);
            }
        }

        @Override // com.baidu.tieba.aj4
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
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(hk4 hk4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hk4Var, bk4Var) == null) {
                super.e(hk4Var, bk4Var);
                if (ye2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + bk4Var.toString());
                }
                an3 an3Var = new an3();
                an3Var.k(12L);
                an3Var.i(bk4Var.a);
                an3Var.d("分包下载失败");
                an3Var.f(bk4Var.toString());
                this.a.S(3, an3Var);
                de2.c().a(hk4Var, PMSDownloadType.ALONE_SUB, an3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hk4Var) == null) {
                super.i(hk4Var);
                if (ye2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + hk4Var.toString());
                }
                this.a.U(hk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye2 a;

        public b(ye2 ye2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ye2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ye2Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) != null) {
                return;
            }
            this.a.S(0, an3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948327203, "Lcom/baidu/tieba/ye2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948327203, "Lcom/baidu/tieba/ye2;");
                return;
            }
        }
        g = rr1.a;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<hk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            an3 an3Var = new an3();
            an3Var.k(12L);
            an3Var.i(2901L);
            an3Var.d("Server无包");
            S(2, an3Var);
        }
    }

    public final void T() {
        ce2 ce2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ce2Var = this.c) != null) {
            ce2Var.a();
        }
    }

    public ye2(String str, String str2, ce2 ce2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, ce2Var};
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
        this.c = ce2Var;
        this.e = du2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bk4Var) == null) {
            super.C(bk4Var);
            an3 an3Var = new an3();
            an3Var.k(12L);
            an3Var.c(bk4Var);
            S(1, an3Var);
        }
    }

    public final void V(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hk4Var) == null) {
            de2.c().d(hk4Var, new b(this));
        }
    }

    public final void S(int i, an3 an3Var) {
        ce2 ce2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, an3Var) == null) && (ce2Var = this.c) != null) {
            ce2Var.b(i, an3Var);
        }
    }

    public final void U(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hk4Var) == null) {
            if (!uo3.a(new File(hk4Var.a), hk4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                an3 an3Var = new an3();
                an3Var.k(12L);
                an3Var.i(2300L);
                an3Var.d("分包签名校验");
                S(4, an3Var);
                de2.c().a(hk4Var, PMSDownloadType.ALONE_SUB, an3Var);
            } else if (af2.h(new File(hk4Var.a), new File(this.e, hk4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                hk4Var.o = this.d;
                ej4.i().m(hk4Var);
                T();
                de2.c().b(hk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                an3 an3Var2 = new an3();
                an3Var2.k(12L);
                an3Var2.i(2320L);
                an3Var2.d("分包解压失败");
                S(5, an3Var2);
                de2.c().a(hk4Var, PMSDownloadType.ALONE_SUB, an3Var2);
            }
        }
    }
}
