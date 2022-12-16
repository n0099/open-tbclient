package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.a72;
import com.baidu.tieba.an2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes6.dex */
public class v72 extends i72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public z62 c;
    public String d;
    public String e;
    public vb4<ed4> f;

    /* loaded from: classes6.dex */
    public class a extends sb4<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v72 a;

        public a(v72 v72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v72Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(ed4 ed4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ed4Var)) == null) {
                return x72.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void f(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ed4Var) == null) {
                super.f(ed4Var);
                if (v72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(ed4Var);
            }
        }

        @Override // com.baidu.tieba.xb4
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
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(ed4 ed4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, ed4Var, yc4Var) == null) {
                super.e(ed4Var, yc4Var);
                if (v72.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + yc4Var.toString());
                }
                xf3 xf3Var = new xf3();
                xf3Var.k(12L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("分包下载失败");
                xf3Var.f(yc4Var.toString());
                this.a.S(3, xf3Var);
                a72.c().a(ed4Var, PMSDownloadType.ALONE_SUB, xf3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, ed4Var) == null) {
                super.i(ed4Var);
                if (v72.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + ed4Var.toString());
                }
                this.a.U(ed4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v72 a;

        public b(v72 v72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v72Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) != null) {
                return;
            }
            this.a.S(0, xf3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948193624, "Lcom/baidu/tieba/v72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948193624, "Lcom/baidu/tieba/v72;");
                return;
            }
        }
        g = ok1.a;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<ed4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            xf3 xf3Var = new xf3();
            xf3Var.k(12L);
            xf3Var.i(2901L);
            xf3Var.d("Server无包");
            S(2, xf3Var);
        }
    }

    public final void T() {
        z62 z62Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (z62Var = this.c) != null) {
            z62Var.a();
        }
    }

    public v72(String str, String str2, z62 z62Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, z62Var};
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
        this.c = z62Var;
        this.e = an2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.zb4
    public void C(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc4Var) == null) {
            super.C(yc4Var);
            xf3 xf3Var = new xf3();
            xf3Var.k(12L);
            xf3Var.c(yc4Var);
            S(1, xf3Var);
        }
    }

    public final void V(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ed4Var) == null) {
            a72.c().d(ed4Var, new b(this));
        }
    }

    public final void S(int i, xf3 xf3Var) {
        z62 z62Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, xf3Var) == null) && (z62Var = this.c) != null) {
            z62Var.b(i, xf3Var);
        }
    }

    public final void U(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ed4Var) == null) {
            if (!rh3.a(new File(ed4Var.a), ed4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                xf3 xf3Var = new xf3();
                xf3Var.k(12L);
                xf3Var.i(2300L);
                xf3Var.d("分包签名校验");
                S(4, xf3Var);
                a72.c().a(ed4Var, PMSDownloadType.ALONE_SUB, xf3Var);
            } else if (x72.h(new File(ed4Var.a), new File(this.e, ed4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                ed4Var.o = this.d;
                bc4.i().m(ed4Var);
                T();
                a72.c().b(ed4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                xf3 xf3Var2 = new xf3();
                xf3Var2.k(12L);
                xf3Var2.i(2320L);
                xf3Var2.d("分包解压失败");
                S(5, xf3Var2);
                a72.c().a(ed4Var, PMSDownloadType.ALONE_SUB, xf3Var2);
            }
        }
    }
}
