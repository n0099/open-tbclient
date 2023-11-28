package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.d92;
import com.baidu.tieba.dp2;
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
public class y92 extends l92 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public c92 c;
    public String d;
    public String e;
    public yd4<hf4> f;

    /* loaded from: classes9.dex */
    public class a extends vd4<hf4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y92 a;

        public a(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y92Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yd4
        /* renamed from: l */
        public String d(hf4 hf4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hf4Var)) == null) {
                return aa2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: q */
        public void f(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hf4Var) == null) {
                super.f(hf4Var);
                if (y92.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(hf4Var);
            }
        }

        @Override // com.baidu.tieba.ae4
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
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: o */
        public void e(hf4 hf4Var, bf4 bf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, hf4Var, bf4Var) == null) {
                super.e(hf4Var, bf4Var);
                if (y92.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + bf4Var.toString());
                }
                ai3 ai3Var = new ai3();
                ai3Var.k(12L);
                ai3Var.i(bf4Var.a);
                ai3Var.d("分包下载失败");
                ai3Var.f(bf4Var.toString());
                this.a.S(3, ai3Var);
                d92.c().a(hf4Var, PMSDownloadType.ALONE_SUB, ai3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vd4, com.baidu.tieba.yd4
        /* renamed from: p */
        public void i(hf4 hf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, hf4Var) == null) {
                super.i(hf4Var);
                if (y92.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + hf4Var.toString());
                }
                this.a.U(hf4Var);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d92.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y92 a;

        public b(y92 y92Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y92Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y92Var;
        }

        @Override // com.baidu.tieba.d92.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.d92.c
        public void b(PMSDownloadType pMSDownloadType, ai3 ai3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, ai3Var) != null) {
                return;
            }
            this.a.S(0, ai3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284919, "Lcom/baidu/tieba/y92;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284919, "Lcom/baidu/tieba/y92;");
                return;
            }
        }
        g = sm1.a;
    }

    @Override // com.baidu.tieba.ce4
    public yd4<hf4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (yd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ce4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ai3 ai3Var = new ai3();
            ai3Var.k(12L);
            ai3Var.i(2901L);
            ai3Var.d("Server无包");
            S(2, ai3Var);
        }
    }

    public final void T() {
        c92 c92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (c92Var = this.c) != null) {
            c92Var.a();
        }
    }

    public y92(String str, String str2, c92 c92Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, c92Var};
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
        this.c = c92Var;
        this.e = dp2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.ce4
    public void C(bf4 bf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bf4Var) == null) {
            super.C(bf4Var);
            ai3 ai3Var = new ai3();
            ai3Var.k(12L);
            ai3Var.c(bf4Var);
            S(1, ai3Var);
        }
    }

    public final void V(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hf4Var) == null) {
            d92.c().d(hf4Var, new b(this));
        }
    }

    public final void S(int i, ai3 ai3Var) {
        c92 c92Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, ai3Var) == null) && (c92Var = this.c) != null) {
            c92Var.b(i, ai3Var);
        }
    }

    public final void U(hf4 hf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hf4Var) == null) {
            if (!uj3.a(new File(hf4Var.a), hf4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                ai3 ai3Var = new ai3();
                ai3Var.k(12L);
                ai3Var.i(2300L);
                ai3Var.d("分包签名校验");
                S(4, ai3Var);
                d92.c().a(hf4Var, PMSDownloadType.ALONE_SUB, ai3Var);
            } else if (aa2.h(new File(hf4Var.a), new File(this.e, hf4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                hf4Var.o = this.d;
                ee4.i().m(hf4Var);
                T();
                d92.c().b(hf4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                ai3 ai3Var2 = new ai3();
                ai3Var2.k(12L);
                ai3Var2.i(2320L);
                ai3Var2.d("分包解压失败");
                S(5, ai3Var2);
                d92.c().a(hf4Var, PMSDownloadType.ALONE_SUB, ai3Var2);
            }
        }
    }
}
