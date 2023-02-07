package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.sb2;
import com.baidu.tieba.sr2;
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
public class nc2 extends ac2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public rb2 c;
    public String d;
    public String e;
    public ng4<wh4> f;

    /* loaded from: classes5.dex */
    public class a extends kg4<wh4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc2 a;

        public a(nc2 nc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ng4
        /* renamed from: l */
        public String d(wh4 wh4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wh4Var)) == null) {
                return pc2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: q */
        public void f(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wh4Var) == null) {
                super.f(wh4Var);
                if (nc2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(wh4Var);
            }
        }

        @Override // com.baidu.tieba.pg4
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
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: o */
        public void e(wh4 wh4Var, qh4 qh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, wh4Var, qh4Var) == null) {
                super.e(wh4Var, qh4Var);
                if (nc2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + qh4Var.toString());
                }
                pk3 pk3Var = new pk3();
                pk3Var.k(12L);
                pk3Var.i(qh4Var.a);
                pk3Var.d("分包下载失败");
                pk3Var.f(qh4Var.toString());
                this.a.S(3, pk3Var);
                sb2.c().a(wh4Var, PMSDownloadType.ALONE_SUB, pk3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg4, com.baidu.tieba.ng4
        /* renamed from: p */
        public void i(wh4 wh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, wh4Var) == null) {
                super.i(wh4Var);
                if (nc2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + wh4Var.toString());
                }
                this.a.U(wh4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements sb2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nc2 a;

        public b(nc2 nc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nc2Var;
        }

        @Override // com.baidu.tieba.sb2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.sb2.c
        public void b(PMSDownloadType pMSDownloadType, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, pk3Var) != null) {
                return;
            }
            this.a.S(0, pk3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947997580, "Lcom/baidu/tieba/nc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947997580, "Lcom/baidu/tieba/nc2;");
                return;
            }
        }
        g = gp1.a;
    }

    @Override // com.baidu.tieba.rg4
    public ng4<wh4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (ng4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            pk3 pk3Var = new pk3();
            pk3Var.k(12L);
            pk3Var.i(2901L);
            pk3Var.d("Server无包");
            S(2, pk3Var);
        }
    }

    public final void T() {
        rb2 rb2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (rb2Var = this.c) != null) {
            rb2Var.a();
        }
    }

    public nc2(String str, String str2, rb2 rb2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, rb2Var};
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
        this.c = rb2Var;
        this.e = sr2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.rg4
    public void C(qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qh4Var) == null) {
            super.C(qh4Var);
            pk3 pk3Var = new pk3();
            pk3Var.k(12L);
            pk3Var.c(qh4Var);
            S(1, pk3Var);
        }
    }

    public final void V(wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wh4Var) == null) {
            sb2.c().d(wh4Var, new b(this));
        }
    }

    public final void S(int i, pk3 pk3Var) {
        rb2 rb2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, pk3Var) == null) && (rb2Var = this.c) != null) {
            rb2Var.b(i, pk3Var);
        }
    }

    public final void U(wh4 wh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wh4Var) == null) {
            if (!jm3.a(new File(wh4Var.a), wh4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                pk3 pk3Var = new pk3();
                pk3Var.k(12L);
                pk3Var.i(2300L);
                pk3Var.d("分包签名校验");
                S(4, pk3Var);
                sb2.c().a(wh4Var, PMSDownloadType.ALONE_SUB, pk3Var);
            } else if (pc2.h(new File(wh4Var.a), new File(this.e, wh4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                wh4Var.o = this.d;
                tg4.i().m(wh4Var);
                T();
                sb2.c().b(wh4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                pk3 pk3Var2 = new pk3();
                pk3Var2.k(12L);
                pk3Var2.i(2320L);
                pk3Var2.d("分包解压失败");
                S(5, pk3Var2);
                sb2.c().a(wh4Var, PMSDownloadType.ALONE_SUB, pk3Var2);
            }
        }
    }
}
