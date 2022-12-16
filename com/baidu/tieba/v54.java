package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.a72;
import com.baidu.tieba.s54;
import com.baidu.tieba.u04;
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
public class v54 extends i72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public s54.a c;
    public String d;
    public String e;
    public String f;
    public vb4<ed4> g;

    /* loaded from: classes6.dex */
    public class a extends sb4<ed4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v54 a;

        public a(v54 v54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v54Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vb4
        /* renamed from: l */
        public String d(ed4 ed4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ed4Var)) == null) {
                return x72.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: r */
        public void f(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, ed4Var) == null) {
                super.f(ed4Var);
                if (v54.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(ed4Var);
            }
        }

        @Override // com.baidu.tieba.xb4
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) {
                return this.a.m(bundle, set);
            }
            return (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: o */
        public void e(ed4 ed4Var, yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, ed4Var, yc4Var) == null) {
                super.e(ed4Var, yc4Var);
                if (v54.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + yc4Var.toString());
                }
                this.a.T(2103);
                xf3 xf3Var = new xf3();
                xf3Var.k(12L);
                xf3Var.i(yc4Var.a);
                xf3Var.d("分包下载失败");
                xf3Var.f(yc4Var.toString());
                a72.c().a(ed4Var, PMSDownloadType.ALONE_SUB, xf3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: p */
        public void i(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ed4Var) == null) {
                super.i(ed4Var);
                if (v54.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + ed4Var.toString());
                }
                this.a.W(ed4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sb4, com.baidu.tieba.vb4
        /* renamed from: q */
        public void a(ed4 ed4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, ed4Var) == null) {
                super.a(ed4Var);
                if (v54.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + ed4Var.k + ":" + ed4Var.b);
                }
                this.a.U(ed4Var.b, ed4Var.k);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements a72.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v54 a;

        public b(v54 v54Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v54Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v54Var;
        }

        @Override // com.baidu.tieba.a72.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.a72.c
        public void b(PMSDownloadType pMSDownloadType, xf3 xf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, xf3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948191764, "Lcom/baidu/tieba/v54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948191764, "Lcom/baidu/tieba/v54;");
                return;
            }
        }
        h = ok1.a;
    }

    @Override // com.baidu.tieba.zb4
    public vb4<ed4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (vb4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (h) {
                Log.i("SwanGameSubPkgDownload", "onNoPackage");
            }
            T(2102);
        }
    }

    public final void V() {
        s54.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public v54(String str, String str2, String str3, s54.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.d = str;
        this.e = str3;
        this.c = aVar;
        this.f = u04.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        s54.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ed4Var) == null) {
            a72.c().d(ed4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.zb4
    public void C(yc4 yc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc4Var) == null) {
            super.C(yc4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + yc4Var.toString());
            }
            T(2103);
        }
    }

    public final void U(long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) != null) || this.c == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.c.a(floor, j, j2);
                return;
            }
            return;
        }
        T(2114);
    }

    public final void W(ed4 ed4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ed4Var) == null) {
            if (!rh3.a(new File(ed4Var.a), ed4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(2104);
                xf3 xf3Var = new xf3();
                xf3Var.k(12L);
                xf3Var.i(2300L);
                xf3Var.d("分包签名校验");
                a72.c().a(ed4Var, PMSDownloadType.ALONE_SUB, xf3Var);
            } else if (x72.h(new File(ed4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                ed4Var.o = this.d;
                bc4.i().m(ed4Var);
                a72.c().b(ed4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                xf3 xf3Var2 = new xf3();
                xf3Var2.k(12L);
                xf3Var2.i(2320L);
                xf3Var2.d("分包解压失败");
                a72.c().a(ed4Var, PMSDownloadType.ALONE_SUB, xf3Var2);
            }
        }
    }
}
