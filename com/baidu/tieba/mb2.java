package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ra2;
import com.baidu.tieba.rq2;
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
public class mb2 extends za2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public qa2 c;
    public String d;
    public String e;
    public mf4<vg4> f;

    /* loaded from: classes5.dex */
    public class a extends jf4<vg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb2 a;

        public a(mb2 mb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mf4
        /* renamed from: l */
        public String d(vg4 vg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vg4Var)) == null) {
                return ob2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: q */
        public void f(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vg4Var) == null) {
                super.f(vg4Var);
                if (mb2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(vg4Var);
            }
        }

        @Override // com.baidu.tieba.of4
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
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: o */
        public void e(vg4 vg4Var, pg4 pg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, vg4Var, pg4Var) == null) {
                super.e(vg4Var, pg4Var);
                if (mb2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + pg4Var.toString());
                }
                oj3 oj3Var = new oj3();
                oj3Var.k(12L);
                oj3Var.i(pg4Var.a);
                oj3Var.d("分包下载失败");
                oj3Var.f(pg4Var.toString());
                this.a.S(3, oj3Var);
                ra2.c().a(vg4Var, PMSDownloadType.ALONE_SUB, oj3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jf4, com.baidu.tieba.mf4
        /* renamed from: p */
        public void i(vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, vg4Var) == null) {
                super.i(vg4Var);
                if (mb2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + vg4Var.toString());
                }
                this.a.U(vg4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ra2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mb2 a;

        public b(mb2 mb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mb2Var;
        }

        @Override // com.baidu.tieba.ra2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ra2.c
        public void b(PMSDownloadType pMSDownloadType, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, oj3Var) != null) {
                return;
            }
            this.a.S(0, oj3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947966828, "Lcom/baidu/tieba/mb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947966828, "Lcom/baidu/tieba/mb2;");
                return;
            }
        }
        g = fo1.a;
    }

    @Override // com.baidu.tieba.qf4
    public mf4<vg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            oj3 oj3Var = new oj3();
            oj3Var.k(12L);
            oj3Var.i(2901L);
            oj3Var.d("Server无包");
            S(2, oj3Var);
        }
    }

    public final void T() {
        qa2 qa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (qa2Var = this.c) != null) {
            qa2Var.a();
        }
    }

    public mb2(String str, String str2, qa2 qa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, qa2Var};
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
        this.c = qa2Var;
        this.e = rq2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.qf4
    public void C(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg4Var) == null) {
            super.C(pg4Var);
            oj3 oj3Var = new oj3();
            oj3Var.k(12L);
            oj3Var.c(pg4Var);
            S(1, oj3Var);
        }
    }

    public final void V(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vg4Var) == null) {
            ra2.c().d(vg4Var, new b(this));
        }
    }

    public final void S(int i, oj3 oj3Var) {
        qa2 qa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, oj3Var) == null) && (qa2Var = this.c) != null) {
            qa2Var.b(i, oj3Var);
        }
    }

    public final void U(vg4 vg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, vg4Var) == null) {
            if (!il3.a(new File(vg4Var.a), vg4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                oj3 oj3Var = new oj3();
                oj3Var.k(12L);
                oj3Var.i(2300L);
                oj3Var.d("分包签名校验");
                S(4, oj3Var);
                ra2.c().a(vg4Var, PMSDownloadType.ALONE_SUB, oj3Var);
            } else if (ob2.h(new File(vg4Var.a), new File(this.e, vg4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                vg4Var.o = this.d;
                sf4.i().m(vg4Var);
                T();
                ra2.c().b(vg4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                oj3 oj3Var2 = new oj3();
                oj3Var2.k(12L);
                oj3Var2.i(2320L);
                oj3Var2.d("分包解压失败");
                S(5, oj3Var2);
                ra2.c().a(vg4Var, PMSDownloadType.ALONE_SUB, oj3Var2);
            }
        }
    }
}
