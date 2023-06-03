package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ue2;
import com.baidu.tieba.uu2;
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
public class pf2 extends cf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public te2 c;
    public String d;
    public String e;
    public pj4<yk4> f;

    /* loaded from: classes7.dex */
    public class a extends mj4<yk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf2 a;

        public a(pf2 pf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pj4
        /* renamed from: l */
        public String d(yk4 yk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yk4Var)) == null) {
                return rf2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: q */
        public void f(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yk4Var) == null) {
                super.f(yk4Var);
                if (pf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(yk4Var);
            }
        }

        @Override // com.baidu.tieba.rj4
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
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: o */
        public void e(yk4 yk4Var, sk4 sk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, yk4Var, sk4Var) == null) {
                super.e(yk4Var, sk4Var);
                if (pf2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + sk4Var.toString());
                }
                rn3 rn3Var = new rn3();
                rn3Var.k(12L);
                rn3Var.i(sk4Var.a);
                rn3Var.d("分包下载失败");
                rn3Var.f(sk4Var.toString());
                this.a.S(3, rn3Var);
                ue2.c().a(yk4Var, PMSDownloadType.ALONE_SUB, rn3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4, com.baidu.tieba.pj4
        /* renamed from: p */
        public void i(yk4 yk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yk4Var) == null) {
                super.i(yk4Var);
                if (pf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + yk4Var.toString());
                }
                this.a.U(yk4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ue2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf2 a;

        public b(pf2 pf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf2Var;
        }

        @Override // com.baidu.tieba.ue2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ue2.c
        public void b(PMSDownloadType pMSDownloadType, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, rn3Var) != null) {
                return;
            }
            this.a.S(0, rn3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948060045, "Lcom/baidu/tieba/pf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948060045, "Lcom/baidu/tieba/pf2;");
                return;
            }
        }
        g = is1.a;
    }

    @Override // com.baidu.tieba.tj4
    public pj4<yk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            rn3 rn3Var = new rn3();
            rn3Var.k(12L);
            rn3Var.i(2901L);
            rn3Var.d("Server无包");
            S(2, rn3Var);
        }
    }

    public final void T() {
        te2 te2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (te2Var = this.c) != null) {
            te2Var.a();
        }
    }

    public pf2(String str, String str2, te2 te2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, te2Var};
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
        this.c = te2Var;
        this.e = uu2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.tj4
    public void C(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sk4Var) == null) {
            super.C(sk4Var);
            rn3 rn3Var = new rn3();
            rn3Var.k(12L);
            rn3Var.c(sk4Var);
            S(1, rn3Var);
        }
    }

    public final void V(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yk4Var) == null) {
            ue2.c().d(yk4Var, new b(this));
        }
    }

    public final void S(int i, rn3 rn3Var) {
        te2 te2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, rn3Var) == null) && (te2Var = this.c) != null) {
            te2Var.b(i, rn3Var);
        }
    }

    public final void U(yk4 yk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yk4Var) == null) {
            if (!lp3.a(new File(yk4Var.a), yk4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                rn3 rn3Var = new rn3();
                rn3Var.k(12L);
                rn3Var.i(2300L);
                rn3Var.d("分包签名校验");
                S(4, rn3Var);
                ue2.c().a(yk4Var, PMSDownloadType.ALONE_SUB, rn3Var);
            } else if (rf2.h(new File(yk4Var.a), new File(this.e, yk4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                yk4Var.o = this.d;
                vj4.i().m(yk4Var);
                T();
                ue2.c().b(yk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                rn3 rn3Var2 = new rn3();
                rn3Var2.k(12L);
                rn3Var2.i(2320L);
                rn3Var2.d("分包解压失败");
                S(5, rn3Var2);
                ue2.c().a(yk4Var, PMSDownloadType.ALONE_SUB, rn3Var2);
            }
        }
    }
}
