package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.l94;
import com.baidu.tieba.n44;
import com.baidu.tieba.ta2;
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
public class o94 extends bb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public l94.a c;
    public String d;
    public String e;
    public String f;
    public of4<xg4> g;

    /* loaded from: classes5.dex */
    public class a extends lf4<xg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o94 a;

        public a(o94 o94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.of4
        /* renamed from: l */
        public String d(xg4 xg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xg4Var)) == null) {
                return qb2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: r */
        public void f(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, xg4Var) == null) {
                super.f(xg4Var);
                if (o94.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(xg4Var);
            }
        }

        @Override // com.baidu.tieba.qf4
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
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: o */
        public void e(xg4 xg4Var, rg4 rg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, xg4Var, rg4Var) == null) {
                super.e(xg4Var, rg4Var);
                if (o94.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + rg4Var.toString());
                }
                this.a.T(2103);
                qj3 qj3Var = new qj3();
                qj3Var.k(12L);
                qj3Var.i(rg4Var.a);
                qj3Var.d("分包下载失败");
                qj3Var.f(rg4Var.toString());
                ta2.c().a(xg4Var, PMSDownloadType.ALONE_SUB, qj3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: p */
        public void i(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xg4Var) == null) {
                super.i(xg4Var);
                if (o94.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + xg4Var.toString());
                }
                this.a.W(xg4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf4, com.baidu.tieba.of4
        /* renamed from: q */
        public void a(xg4 xg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, xg4Var) == null) {
                super.a(xg4Var);
                if (o94.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + xg4Var.k + ":" + xg4Var.b);
                }
                this.a.U(xg4Var.b, xg4Var.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ta2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o94 a;

        public b(o94 o94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o94Var;
        }

        @Override // com.baidu.tieba.ta2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.ta2.c
        public void b(PMSDownloadType pMSDownloadType, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, qj3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987071, "Lcom/baidu/tieba/o94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987071, "Lcom/baidu/tieba/o94;");
                return;
            }
        }
        h = ho1.a;
    }

    @Override // com.baidu.tieba.sf4
    public of4<xg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
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
        l94.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public o94(String str, String str2, String str3, l94.a aVar) {
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
        this.f = n44.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        l94.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xg4Var) == null) {
            ta2.c().d(xg4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.sf4
    public void C(rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rg4Var) == null) {
            super.C(rg4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + rg4Var.toString());
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

    public final void W(xg4 xg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xg4Var) == null) {
            if (!kl3.a(new File(xg4Var.a), xg4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                qj3 qj3Var = new qj3();
                qj3Var.k(12L);
                qj3Var.i(2300L);
                qj3Var.d("分包签名校验");
                ta2.c().a(xg4Var, PMSDownloadType.ALONE_SUB, qj3Var);
            } else if (qb2.h(new File(xg4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                xg4Var.o = this.d;
                uf4.i().m(xg4Var);
                ta2.c().b(xg4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                qj3 qj3Var2 = new qj3();
                qj3Var2.k(12L);
                qj3Var2.i(2320L);
                qj3Var2.d("分包解压失败");
                ta2.c().a(xg4Var, PMSDownloadType.ALONE_SUB, qj3Var2);
            }
        }
    }
}
