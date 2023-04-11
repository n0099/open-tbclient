package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.qa2;
import com.baidu.tieba.qq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class lb2 extends ya2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public pa2 c;
    public String d;
    public String e;
    public lf4<ug4> f;

    /* loaded from: classes5.dex */
    public class a extends if4<ug4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb2 a;

        public a(lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4
        /* renamed from: l */
        public String d(ug4 ug4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ug4Var)) == null) {
                return nb2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: q */
        public void f(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ug4Var) == null) {
                super.f(ug4Var);
                if (lb2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(ug4Var);
            }
        }

        @Override // com.baidu.tieba.nf4
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
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: o */
        public void e(ug4 ug4Var, og4 og4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, ug4Var, og4Var) == null) {
                super.e(ug4Var, og4Var);
                if (lb2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + og4Var.toString());
                }
                nj3 nj3Var = new nj3();
                nj3Var.k(12L);
                nj3Var.i(og4Var.a);
                nj3Var.d("分包下载失败");
                nj3Var.f(og4Var.toString());
                this.a.S(3, nj3Var);
                qa2.c().a(ug4Var, PMSDownloadType.ALONE_SUB, nj3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.if4, com.baidu.tieba.lf4
        /* renamed from: p */
        public void i(ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ug4Var) == null) {
                super.i(ug4Var);
                if (lb2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + ug4Var.toString());
                }
                this.a.U(ug4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lb2 a;

        public b(lb2 lb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lb2Var;
        }

        @Override // com.baidu.tieba.qa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.qa2.c
        public void b(PMSDownloadType pMSDownloadType, nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, nj3Var) != null) {
                return;
            }
            this.a.S(0, nj3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947937037, "Lcom/baidu/tieba/lb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947937037, "Lcom/baidu/tieba/lb2;");
                return;
            }
        }
        g = eo1.a;
    }

    @Override // com.baidu.tieba.pf4
    public lf4<ug4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (lf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            nj3 nj3Var = new nj3();
            nj3Var.k(12L);
            nj3Var.i(2901L);
            nj3Var.d("Server无包");
            S(2, nj3Var);
        }
    }

    public final void T() {
        pa2 pa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pa2Var = this.c) != null) {
            pa2Var.a();
        }
    }

    public lb2(String str, String str2, pa2 pa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, pa2Var};
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
        this.c = pa2Var;
        this.e = qq2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.pf4
    public void C(og4 og4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, og4Var) == null) {
            super.C(og4Var);
            nj3 nj3Var = new nj3();
            nj3Var.k(12L);
            nj3Var.c(og4Var);
            S(1, nj3Var);
        }
    }

    public final void V(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ug4Var) == null) {
            qa2.c().d(ug4Var, new b(this));
        }
    }

    public final void S(int i, nj3 nj3Var) {
        pa2 pa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, nj3Var) == null) && (pa2Var = this.c) != null) {
            pa2Var.b(i, nj3Var);
        }
    }

    public final void U(ug4 ug4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ug4Var) == null) {
            if (!hl3.a(new File(ug4Var.a), ug4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                nj3 nj3Var = new nj3();
                nj3Var.k(12L);
                nj3Var.i(2300L);
                nj3Var.d("分包签名校验");
                S(4, nj3Var);
                qa2.c().a(ug4Var, PMSDownloadType.ALONE_SUB, nj3Var);
            } else if (nb2.h(new File(ug4Var.a), new File(this.e, ug4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                ug4Var.o = this.d;
                rf4.i().m(ug4Var);
                T();
                qa2.c().b(ug4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                nj3 nj3Var2 = new nj3();
                nj3Var2.k(12L);
                nj3Var2.i(2320L);
                nj3Var2.d("分包解压失败");
                S(5, nj3Var2);
                qa2.c().a(ug4Var, PMSDownloadType.ALONE_SUB, nj3Var2);
            }
        }
    }
}
