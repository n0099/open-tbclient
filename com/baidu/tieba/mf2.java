package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.re2;
import com.baidu.tieba.ru2;
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
public class mf2 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public qe2 c;
    public String d;
    public String e;
    public mj4<vk4> f;

    /* loaded from: classes7.dex */
    public class a extends jj4<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mf2 a;

        public a(mf2 mf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(vk4 vk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vk4Var)) == null) {
                return of2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void f(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var) == null) {
                super.f(vk4Var);
                if (mf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(vk4Var);
            }
        }

        @Override // com.baidu.tieba.oj4
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
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(vk4 vk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, vk4Var, pk4Var) == null) {
                super.e(vk4Var, pk4Var);
                if (mf2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + pk4Var.toString());
                }
                on3 on3Var = new on3();
                on3Var.k(12L);
                on3Var.i(pk4Var.a);
                on3Var.d("分包下载失败");
                on3Var.f(pk4Var.toString());
                this.a.S(3, on3Var);
                re2.c().a(vk4Var, PMSDownloadType.ALONE_SUB, on3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, vk4Var) == null) {
                super.i(vk4Var);
                if (mf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + vk4Var.toString());
                }
                this.a.U(vk4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mf2 a;

        public b(mf2 mf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mf2Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) != null) {
                return;
            }
            this.a.S(0, on3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947970672, "Lcom/baidu/tieba/mf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947970672, "Lcom/baidu/tieba/mf2;");
                return;
            }
        }
        g = fs1.a;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<vk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            on3 on3Var = new on3();
            on3Var.k(12L);
            on3Var.i(2901L);
            on3Var.d("Server无包");
            S(2, on3Var);
        }
    }

    public final void T() {
        qe2 qe2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qe2Var = this.c) != null) {
            qe2Var.a();
        }
    }

    public mf2(String str, String str2, qe2 qe2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, qe2Var};
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
        this.c = qe2Var;
        this.e = ru2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk4Var) == null) {
            super.C(pk4Var);
            on3 on3Var = new on3();
            on3Var.k(12L);
            on3Var.c(pk4Var);
            S(1, on3Var);
        }
    }

    public final void V(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vk4Var) == null) {
            re2.c().d(vk4Var, new b(this));
        }
    }

    public final void S(int i, on3 on3Var) {
        qe2 qe2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, on3Var) == null) && (qe2Var = this.c) != null) {
            qe2Var.b(i, on3Var);
        }
    }

    public final void U(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vk4Var) == null) {
            if (!ip3.a(new File(vk4Var.a), vk4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                on3 on3Var = new on3();
                on3Var.k(12L);
                on3Var.i(2300L);
                on3Var.d("分包签名校验");
                S(4, on3Var);
                re2.c().a(vk4Var, PMSDownloadType.ALONE_SUB, on3Var);
            } else if (of2.h(new File(vk4Var.a), new File(this.e, vk4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                vk4Var.o = this.d;
                sj4.i().m(vk4Var);
                T();
                re2.c().b(vk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                on3 on3Var2 = new on3();
                on3Var2.k(12L);
                on3Var2.i(2320L);
                on3Var2.d("分包解压失败");
                S(5, on3Var2);
                re2.c().a(vk4Var, PMSDownloadType.ALONE_SUB, on3Var2);
            }
        }
    }
}
