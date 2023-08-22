package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.zd2;
import com.baidu.tieba.zt2;
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
public class ue2 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public yd2 c;
    public String d;
    public String e;
    public ui4<dk4> f;

    /* loaded from: classes8.dex */
    public class a extends ri4<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue2 a;

        public a(ue2 ue2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(dk4 dk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dk4Var)) == null) {
                return we2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void f(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dk4Var) == null) {
                super.f(dk4Var);
                if (ue2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(dk4Var);
            }
        }

        @Override // com.baidu.tieba.wi4
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
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(dk4 dk4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, dk4Var, xj4Var) == null) {
                super.e(dk4Var, xj4Var);
                if (ue2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + xj4Var.toString());
                }
                wm3 wm3Var = new wm3();
                wm3Var.k(12L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("分包下载失败");
                wm3Var.f(xj4Var.toString());
                this.a.S(3, wm3Var);
                zd2.c().a(dk4Var, PMSDownloadType.ALONE_SUB, wm3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, dk4Var) == null) {
                super.i(dk4Var);
                if (ue2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + dk4Var.toString());
                }
                this.a.U(dk4Var);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ue2 a;

        public b(ue2 ue2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ue2Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) != null) {
                return;
            }
            this.a.S(0, wm3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948208039, "Lcom/baidu/tieba/ue2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948208039, "Lcom/baidu/tieba/ue2;");
                return;
            }
        }
        g = nr1.a;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<dk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            wm3 wm3Var = new wm3();
            wm3Var.k(12L);
            wm3Var.i(2901L);
            wm3Var.d("Server无包");
            S(2, wm3Var);
        }
    }

    public final void T() {
        yd2 yd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (yd2Var = this.c) != null) {
            yd2Var.a();
        }
    }

    public ue2(String str, String str2, yd2 yd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, yd2Var};
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
        this.c = yd2Var;
        this.e = zt2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xj4Var) == null) {
            super.C(xj4Var);
            wm3 wm3Var = new wm3();
            wm3Var.k(12L);
            wm3Var.c(xj4Var);
            S(1, wm3Var);
        }
    }

    public final void V(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dk4Var) == null) {
            zd2.c().d(dk4Var, new b(this));
        }
    }

    public final void S(int i, wm3 wm3Var) {
        yd2 yd2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, wm3Var) == null) && (yd2Var = this.c) != null) {
            yd2Var.b(i, wm3Var);
        }
    }

    public final void U(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dk4Var) == null) {
            if (!qo3.a(new File(dk4Var.a), dk4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                wm3 wm3Var = new wm3();
                wm3Var.k(12L);
                wm3Var.i(2300L);
                wm3Var.d("分包签名校验");
                S(4, wm3Var);
                zd2.c().a(dk4Var, PMSDownloadType.ALONE_SUB, wm3Var);
            } else if (we2.h(new File(dk4Var.a), new File(this.e, dk4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                dk4Var.o = this.d;
                aj4.i().m(dk4Var);
                T();
                zd2.c().b(dk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                wm3 wm3Var2 = new wm3();
                wm3Var2.k(12L);
                wm3Var2.i(2320L);
                wm3Var2.d("分包解压失败");
                S(5, wm3Var2);
                zd2.c().a(dk4Var, PMSDownloadType.ALONE_SUB, wm3Var2);
            }
        }
    }
}
