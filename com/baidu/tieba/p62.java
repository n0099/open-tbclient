package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.u52;
import com.baidu.tieba.ul2;
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
public class p62 extends c62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public t52 c;
    public String d;
    public String e;
    public pa4<yb4> f;

    /* loaded from: classes5.dex */
    public class a extends ma4<yb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p62 a;

        public a(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p62Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pa4
        /* renamed from: l */
        public String d(yb4 yb4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yb4Var)) == null) ? r62.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ra4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: o */
        public void e(yb4 yb4Var, sb4 sb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, yb4Var, sb4Var) == null) {
                super.e(yb4Var, sb4Var);
                if (p62.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + sb4Var.toString());
                }
                re3 re3Var = new re3();
                re3Var.k(12L);
                re3Var.i(sb4Var.a);
                re3Var.d("分包下载失败");
                re3Var.f(sb4Var.toString());
                this.a.S(3, re3Var);
                u52.c().a(yb4Var, PMSDownloadType.ALONE_SUB, re3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: p */
        public void i(yb4 yb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, yb4Var) == null) {
                super.i(yb4Var);
                if (p62.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + yb4Var.toString());
                }
                this.a.U(yb4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ma4, com.baidu.tieba.pa4
        /* renamed from: q */
        public void f(yb4 yb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yb4Var) == null) {
                super.f(yb4Var);
                if (p62.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(yb4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements u52.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p62 a;

        public b(p62 p62Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p62Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p62Var;
        }

        @Override // com.baidu.tieba.u52.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.baidu.tieba.u52.c
        public void b(PMSDownloadType pMSDownloadType, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, re3Var) == null) {
                this.a.S(0, re3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948013917, "Lcom/baidu/tieba/p62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948013917, "Lcom/baidu/tieba/p62;");
                return;
            }
        }
        g = ij1.a;
    }

    public p62(String str, String str2, t52 t52Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, t52Var};
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
        this.c = t52Var;
        this.e = ul2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.ta4
    public pa4<yb4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (pa4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ta4
    public void C(sb4 sb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb4Var) == null) {
            super.C(sb4Var);
            re3 re3Var = new re3();
            re3Var.k(12L);
            re3Var.c(sb4Var);
            S(1, re3Var);
        }
    }

    @Override // com.baidu.tieba.ta4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            re3 re3Var = new re3();
            re3Var.k(12L);
            re3Var.i(2901L);
            re3Var.d("Server无包");
            S(2, re3Var);
        }
    }

    public final void S(int i, re3 re3Var) {
        t52 t52Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, re3Var) == null) || (t52Var = this.c) == null) {
            return;
        }
        t52Var.b(i, re3Var);
    }

    public final void T() {
        t52 t52Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (t52Var = this.c) == null) {
            return;
        }
        t52Var.a();
    }

    public final void U(yb4 yb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yb4Var) == null) {
            if (!lg3.a(new File(yb4Var.a), yb4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                re3 re3Var = new re3();
                re3Var.k(12L);
                re3Var.i(2300L);
                re3Var.d("分包签名校验");
                S(4, re3Var);
                u52.c().a(yb4Var, PMSDownloadType.ALONE_SUB, re3Var);
            } else if (r62.h(new File(yb4Var.a), new File(this.e, yb4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                yb4Var.o = this.d;
                va4.i().m(yb4Var);
                T();
                u52.c().b(yb4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                re3 re3Var2 = new re3();
                re3Var2.k(12L);
                re3Var2.i(2320L);
                re3Var2.d("分包解压失败");
                S(5, re3Var2);
                u52.c().a(yb4Var, PMSDownloadType.ALONE_SUB, re3Var2);
            }
        }
    }

    public final void V(yb4 yb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yb4Var) == null) {
            u52.c().d(yb4Var, new b(this));
        }
    }
}
