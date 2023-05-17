package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.cc2;
import com.baidu.tieba.cs2;
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
public class xc2 extends kc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public bc2 c;
    public String d;
    public String e;
    public xg4<gi4> f;

    /* loaded from: classes8.dex */
    public class a extends ug4<gi4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc2 a;

        public a(xc2 xc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg4
        /* renamed from: l */
        public String d(gi4 gi4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gi4Var)) == null) {
                return zc2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: q */
        public void f(gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gi4Var) == null) {
                super.f(gi4Var);
                if (xc2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(gi4Var);
            }
        }

        @Override // com.baidu.tieba.zg4
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
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: o */
        public void e(gi4 gi4Var, ai4 ai4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gi4Var, ai4Var) == null) {
                super.e(gi4Var, ai4Var);
                if (xc2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + ai4Var.toString());
                }
                zk3 zk3Var = new zk3();
                zk3Var.k(12L);
                zk3Var.i(ai4Var.a);
                zk3Var.d("分包下载失败");
                zk3Var.f(ai4Var.toString());
                this.a.S(3, zk3Var);
                cc2.c().a(gi4Var, PMSDownloadType.ALONE_SUB, zk3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ug4, com.baidu.tieba.xg4
        /* renamed from: p */
        public void i(gi4 gi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gi4Var) == null) {
                super.i(gi4Var);
                if (xc2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + gi4Var.toString());
                }
                this.a.U(gi4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements cc2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xc2 a;

        public b(xc2 xc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xc2Var;
        }

        @Override // com.baidu.tieba.cc2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.cc2.c
        public void b(PMSDownloadType pMSDownloadType, zk3 zk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, zk3Var) != null) {
                return;
            }
            this.a.S(0, zk3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295490, "Lcom/baidu/tieba/xc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295490, "Lcom/baidu/tieba/xc2;");
                return;
            }
        }
        g = qp1.a;
    }

    @Override // com.baidu.tieba.bh4
    public xg4<gi4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (xg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            zk3 zk3Var = new zk3();
            zk3Var.k(12L);
            zk3Var.i(2901L);
            zk3Var.d("Server无包");
            S(2, zk3Var);
        }
    }

    public final void T() {
        bc2 bc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bc2Var = this.c) != null) {
            bc2Var.a();
        }
    }

    public xc2(String str, String str2, bc2 bc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bc2Var};
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
        this.c = bc2Var;
        this.e = cs2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.bh4
    public void C(ai4 ai4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ai4Var) == null) {
            super.C(ai4Var);
            zk3 zk3Var = new zk3();
            zk3Var.k(12L);
            zk3Var.c(ai4Var);
            S(1, zk3Var);
        }
    }

    public final void V(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gi4Var) == null) {
            cc2.c().d(gi4Var, new b(this));
        }
    }

    public final void S(int i, zk3 zk3Var) {
        bc2 bc2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, zk3Var) == null) && (bc2Var = this.c) != null) {
            bc2Var.b(i, zk3Var);
        }
    }

    public final void U(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gi4Var) == null) {
            if (!tm3.a(new File(gi4Var.a), gi4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                zk3 zk3Var = new zk3();
                zk3Var.k(12L);
                zk3Var.i(2300L);
                zk3Var.d("分包签名校验");
                S(4, zk3Var);
                cc2.c().a(gi4Var, PMSDownloadType.ALONE_SUB, zk3Var);
            } else if (zc2.h(new File(gi4Var.a), new File(this.e, gi4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                gi4Var.o = this.d;
                dh4.i().m(gi4Var);
                T();
                cc2.c().b(gi4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                zk3 zk3Var2 = new zk3();
                zk3Var2.k(12L);
                zk3Var2.i(2320L);
                zk3Var2.d("分包解压失败");
                S(5, zk3Var2);
                cc2.c().a(gi4Var, PMSDownloadType.ALONE_SUB, zk3Var2);
            }
        }
    }
}
