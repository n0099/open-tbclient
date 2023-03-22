package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.pa2;
import com.baidu.tieba.pq2;
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
public class kb2 extends xa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public oa2 c;
    public String d;
    public String e;
    public kf4<tg4> f;

    /* loaded from: classes5.dex */
    public class a extends hf4<tg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb2 a;

        public a(kb2 kb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kb2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(tg4 tg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tg4Var)) == null) {
                return mb2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void f(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tg4Var) == null) {
                super.f(tg4Var);
                if (kb2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(tg4Var);
            }
        }

        @Override // com.baidu.tieba.mf4
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
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(tg4 tg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, tg4Var, ng4Var) == null) {
                super.e(tg4Var, ng4Var);
                if (kb2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + ng4Var.toString());
                }
                mj3 mj3Var = new mj3();
                mj3Var.k(12L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("分包下载失败");
                mj3Var.f(ng4Var.toString());
                this.a.S(3, mj3Var);
                pa2.c().a(tg4Var, PMSDownloadType.ALONE_SUB, mj3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, tg4Var) == null) {
                super.i(tg4Var);
                if (kb2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + tg4Var.toString());
                }
                this.a.U(tg4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kb2 a;

        public b(kb2 kb2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kb2Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) != null) {
                return;
            }
            this.a.S(0, mj3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947907246, "Lcom/baidu/tieba/kb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947907246, "Lcom/baidu/tieba/kb2;");
                return;
            }
        }
        g = do1.a;
    }

    @Override // com.baidu.tieba.of4
    public kf4<tg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            mj3 mj3Var = new mj3();
            mj3Var.k(12L);
            mj3Var.i(2901L);
            mj3Var.d("Server无包");
            S(2, mj3Var);
        }
    }

    public final void T() {
        oa2 oa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (oa2Var = this.c) != null) {
            oa2Var.a();
        }
    }

    public kb2(String str, String str2, oa2 oa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, oa2Var};
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
        this.c = oa2Var;
        this.e = pq2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.of4
    public void C(ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ng4Var) == null) {
            super.C(ng4Var);
            mj3 mj3Var = new mj3();
            mj3Var.k(12L);
            mj3Var.c(ng4Var);
            S(1, mj3Var);
        }
    }

    public final void V(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tg4Var) == null) {
            pa2.c().d(tg4Var, new b(this));
        }
    }

    public final void S(int i, mj3 mj3Var) {
        oa2 oa2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, mj3Var) == null) && (oa2Var = this.c) != null) {
            oa2Var.b(i, mj3Var);
        }
    }

    public final void U(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tg4Var) == null) {
            if (!gl3.a(new File(tg4Var.a), tg4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                mj3 mj3Var = new mj3();
                mj3Var.k(12L);
                mj3Var.i(2300L);
                mj3Var.d("分包签名校验");
                S(4, mj3Var);
                pa2.c().a(tg4Var, PMSDownloadType.ALONE_SUB, mj3Var);
            } else if (mb2.h(new File(tg4Var.a), new File(this.e, tg4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                tg4Var.o = this.d;
                qf4.i().m(tg4Var);
                T();
                pa2.c().b(tg4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                mj3 mj3Var2 = new mj3();
                mj3Var2.k(12L);
                mj3Var2.i(2320L);
                mj3Var2.d("分包解压失败");
                S(5, mj3Var2);
                pa2.c().a(tg4Var, PMSDownloadType.ALONE_SUB, mj3Var2);
            }
        }
    }
}
