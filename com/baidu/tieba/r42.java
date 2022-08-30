package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.w32;
import com.baidu.tieba.wj2;
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
public class r42 extends e42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public v32 c;
    public String d;
    public String e;
    public p84<y94> f;

    /* loaded from: classes5.dex */
    public class a extends m84<y94> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r42 a;

        public a(r42 r42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.p84
        /* renamed from: l */
        public String d(y94 y94Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, y94Var)) == null) ? t42.a(this.a.e) : (String) invokeL.objValue;
        }

        @Override // com.baidu.tieba.r84
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: o */
        public void e(y94 y94Var, s94 s94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, y94Var, s94Var) == null) {
                super.e(y94Var, s94Var);
                if (r42.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + s94Var.toString());
                }
                tc3 tc3Var = new tc3();
                tc3Var.k(12L);
                tc3Var.i(s94Var.a);
                tc3Var.d("分包下载失败");
                tc3Var.f(s94Var.toString());
                this.a.S(3, tc3Var);
                w32.c().a(y94Var, PMSDownloadType.ALONE_SUB, tc3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: p */
        public void i(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, y94Var) == null) {
                super.i(y94Var);
                if (r42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + y94Var.toString());
                }
                this.a.U(y94Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m84, com.baidu.tieba.p84
        /* renamed from: q */
        public void f(y94 y94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, y94Var) == null) {
                super.f(y94Var);
                if (r42.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(y94Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements w32.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r42 a;

        public b(r42 r42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r42Var;
        }

        @Override // com.baidu.tieba.w32.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.a.T();
            }
        }

        @Override // com.baidu.tieba.w32.c
        public void b(PMSDownloadType pMSDownloadType, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, tc3Var) == null) {
                this.a.S(0, tc3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948071577, "Lcom/baidu/tieba/r42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948071577, "Lcom/baidu/tieba/r42;");
                return;
            }
        }
        g = kh1.a;
    }

    public r42(String str, String str2, v32 v32Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, v32Var};
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
        this.c = v32Var;
        this.e = wj2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.t84
    public p84<y94> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f : (p84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t84
    public void C(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s94Var) == null) {
            super.C(s94Var);
            tc3 tc3Var = new tc3();
            tc3Var.k(12L);
            tc3Var.c(s94Var);
            S(1, tc3Var);
        }
    }

    @Override // com.baidu.tieba.t84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            tc3 tc3Var = new tc3();
            tc3Var.k(12L);
            tc3Var.i(2901L);
            tc3Var.d("Server无包");
            S(2, tc3Var);
        }
    }

    public final void S(int i, tc3 tc3Var) {
        v32 v32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, tc3Var) == null) || (v32Var = this.c) == null) {
            return;
        }
        v32Var.b(i, tc3Var);
    }

    public final void T() {
        v32 v32Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (v32Var = this.c) == null) {
            return;
        }
        v32Var.a();
    }

    public final void U(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, y94Var) == null) {
            if (!ne3.a(new File(y94Var.a), y94Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                tc3 tc3Var = new tc3();
                tc3Var.k(12L);
                tc3Var.i(2300L);
                tc3Var.d("分包签名校验");
                S(4, tc3Var);
                w32.c().a(y94Var, PMSDownloadType.ALONE_SUB, tc3Var);
            } else if (t42.h(new File(y94Var.a), new File(this.e, y94Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                y94Var.o = this.d;
                v84.i().m(y94Var);
                T();
                w32.c().b(y94Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                tc3 tc3Var2 = new tc3();
                tc3Var2.k(12L);
                tc3Var2.i(2320L);
                tc3Var2.d("分包解压失败");
                S(5, tc3Var2);
                w32.c().a(y94Var, PMSDownloadType.ALONE_SUB, tc3Var2);
            }
        }
    }

    public final void V(y94 y94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, y94Var) == null) {
            w32.c().d(y94Var, new b(this));
        }
    }
}
