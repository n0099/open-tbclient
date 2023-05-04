package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ta2;
import com.baidu.tieba.tq2;
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
public class ob2 extends bb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public sa2 c;
    public String d;
    public String e;
    public of4<xg4> f;

    /* loaded from: classes5.dex */
    public class a extends lf4<xg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob2 a;

        public a(ob2 ob2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(xg4 xg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xg4Var)) == null) {
                return qb2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void f(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg4Var) == null) {
                super.f(xg4Var);
                if (ob2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(xg4Var);
            }
        }

        @Override // com.baidu.tieba.qf4
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
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(xg4 xg4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, xg4Var, rg4Var) == null) {
                super.e(xg4Var, rg4Var);
                if (ob2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + rg4Var.toString());
                }
                qj3 qj3Var = new qj3();
                qj3Var.k(12L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("分包下载失败");
                qj3Var.f(rg4Var.toString());
                this.a.S(3, qj3Var);
                ta2.c().a(xg4Var, PMSDownloadType.ALONE_SUB, qj3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, xg4Var) == null) {
                super.i(xg4Var);
                if (ob2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + xg4Var.toString());
                }
                this.a.U(xg4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ob2 a;

        public b(ob2 ob2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ob2Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) != null) {
                return;
            }
            this.a.S(0, qj3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948026410, "Lcom/baidu/tieba/ob2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948026410, "Lcom/baidu/tieba/ob2;");
                return;
            }
        }
        g = ho1.a;
    }

    @Override // com.baidu.tieba.sf4
    public of4<xg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            qj3 qj3Var = new qj3();
            qj3Var.k(12L);
            qj3Var.i(2901L);
            qj3Var.d("Server无包");
            S(2, qj3Var);
        }
    }

    public final void T() {
        sa2 sa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (sa2Var = this.c) != null) {
            sa2Var.a();
        }
    }

    public ob2(String str, String str2, sa2 sa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, sa2Var};
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
        this.c = sa2Var;
        this.e = tq2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.sf4
    public void C(rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rg4Var) == null) {
            super.C(rg4Var);
            qj3 qj3Var = new qj3();
            qj3Var.k(12L);
            qj3Var.c(rg4Var);
            S(1, qj3Var);
        }
    }

    public final void V(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xg4Var) == null) {
            ta2.c().d(xg4Var, new b(this));
        }
    }

    public final void S(int i, qj3 qj3Var) {
        sa2 sa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, qj3Var) == null) && (sa2Var = this.c) != null) {
            sa2Var.b(i, qj3Var);
        }
    }

    public final void U(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xg4Var) == null) {
            if (!kl3.a(new File(xg4Var.a), xg4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                qj3 qj3Var = new qj3();
                qj3Var.k(12L);
                qj3Var.i(2300L);
                qj3Var.d("分包签名校验");
                S(4, qj3Var);
                ta2.c().a(xg4Var, PMSDownloadType.ALONE_SUB, qj3Var);
            } else if (qb2.h(new File(xg4Var.a), new File(this.e, xg4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                xg4Var.o = this.d;
                uf4.i().m(xg4Var);
                T();
                ta2.c().b(xg4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                qj3 qj3Var2 = new qj3();
                qj3Var2.k(12L);
                qj3Var2.i(2320L);
                qj3Var2.d("分包解压失败");
                S(5, qj3Var2);
                ta2.c().a(xg4Var, PMSDownloadType.ALONE_SUB, qj3Var2);
            }
        }
    }
}
