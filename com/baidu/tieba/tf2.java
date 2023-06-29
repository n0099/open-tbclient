package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ye2;
import com.baidu.tieba.yu2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class tf2 extends gf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public xe2 c;
    public String d;
    public String e;
    public tj4<cl4> f;

    /* loaded from: classes7.dex */
    public class a extends qj4<cl4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf2 a;

        public a(tf2 tf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tj4
        /* renamed from: l */
        public String d(cl4 cl4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cl4Var)) == null) {
                return vf2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: q */
        public void f(cl4 cl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cl4Var) == null) {
                super.f(cl4Var);
                if (tf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(cl4Var);
            }
        }

        @Override // com.baidu.tieba.vj4
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
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: o */
        public void e(cl4 cl4Var, wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, cl4Var, wk4Var) == null) {
                super.e(cl4Var, wk4Var);
                if (tf2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + wk4Var.toString());
                }
                vn3 vn3Var = new vn3();
                vn3Var.k(12L);
                vn3Var.i(wk4Var.a);
                vn3Var.d("分包下载失败");
                vn3Var.f(wk4Var.toString());
                this.a.S(3, vn3Var);
                ye2.c().a(cl4Var, PMSDownloadType.ALONE_SUB, vn3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4, com.baidu.tieba.tj4
        /* renamed from: p */
        public void i(cl4 cl4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, cl4Var) == null) {
                super.i(cl4Var);
                if (tf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + cl4Var.toString());
                }
                this.a.U(cl4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ye2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tf2 a;

        public b(tf2 tf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tf2Var;
        }

        @Override // com.baidu.tieba.ye2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ye2.c
        public void b(PMSDownloadType pMSDownloadType, vn3 vn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, vn3Var) != null) {
                return;
            }
            this.a.S(0, vn3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948179209, "Lcom/baidu/tieba/tf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948179209, "Lcom/baidu/tieba/tf2;");
                return;
            }
        }
        g = ms1.a;
    }

    @Override // com.baidu.tieba.xj4
    public tj4<cl4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (tj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            vn3 vn3Var = new vn3();
            vn3Var.k(12L);
            vn3Var.i(2901L);
            vn3Var.d("Server无包");
            S(2, vn3Var);
        }
    }

    public final void T() {
        xe2 xe2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (xe2Var = this.c) != null) {
            xe2Var.a();
        }
    }

    public tf2(String str, String str2, xe2 xe2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, xe2Var};
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
        this.c = xe2Var;
        this.e = yu2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.xj4
    public void C(wk4 wk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wk4Var) == null) {
            super.C(wk4Var);
            vn3 vn3Var = new vn3();
            vn3Var.k(12L);
            vn3Var.c(wk4Var);
            S(1, vn3Var);
        }
    }

    public final void V(cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cl4Var) == null) {
            ye2.c().d(cl4Var, new b(this));
        }
    }

    public final void S(int i, vn3 vn3Var) {
        xe2 xe2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, vn3Var) == null) && (xe2Var = this.c) != null) {
            xe2Var.b(i, vn3Var);
        }
    }

    public final void U(cl4 cl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cl4Var) == null) {
            if (!pp3.a(new File(cl4Var.a), cl4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                vn3 vn3Var = new vn3();
                vn3Var.k(12L);
                vn3Var.i(2300L);
                vn3Var.d("分包签名校验");
                S(4, vn3Var);
                ye2.c().a(cl4Var, PMSDownloadType.ALONE_SUB, vn3Var);
            } else if (vf2.h(new File(cl4Var.a), new File(this.e, cl4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                cl4Var.o = this.d;
                zj4.i().m(cl4Var);
                T();
                ye2.c().b(cl4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                vn3 vn3Var2 = new vn3();
                vn3Var2.k(12L);
                vn3Var2.i(2320L);
                vn3Var2.d("分包解压失败");
                S(5, vn3Var2);
                ye2.c().a(cl4Var, PMSDownloadType.ALONE_SUB, vn3Var2);
            }
        }
    }
}
