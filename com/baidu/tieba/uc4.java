package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.rc4;
import com.baidu.tieba.t74;
import com.baidu.tieba.zd2;
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
public class uc4 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public rc4.a c;
    public String d;
    public String e;
    public String f;
    public ui4<dk4> g;

    /* loaded from: classes8.dex */
    public class a extends ri4<dk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc4 a;

        public a(uc4 uc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ui4
        /* renamed from: l */
        public String d(dk4 dk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dk4Var)) == null) {
                return we2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: r */
        public void f(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, dk4Var) == null) {
                super.f(dk4Var);
                if (uc4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(dk4Var);
            }
        }

        @Override // com.baidu.tieba.wi4
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
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: o */
        public void e(dk4 dk4Var, xj4 xj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, dk4Var, xj4Var) == null) {
                super.e(dk4Var, xj4Var);
                if (uc4.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + xj4Var.toString());
                }
                this.a.T(2103);
                wm3 wm3Var = new wm3();
                wm3Var.k(12L);
                wm3Var.i(xj4Var.a);
                wm3Var.d("分包下载失败");
                wm3Var.f(xj4Var.toString());
                zd2.c().a(dk4Var, PMSDownloadType.ALONE_SUB, wm3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: p */
        public void i(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dk4Var) == null) {
                super.i(dk4Var);
                if (uc4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + dk4Var.toString());
                }
                this.a.W(dk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ri4, com.baidu.tieba.ui4
        /* renamed from: q */
        public void a(dk4 dk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, dk4Var) == null) {
                super.a(dk4Var);
                if (uc4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + dk4Var.k + ":" + dk4Var.b);
                }
                this.a.U(dk4Var.b, dk4Var.k);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zd2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uc4 a;

        public b(uc4 uc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uc4Var;
        }

        @Override // com.baidu.tieba.zd2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.zd2.c
        public void b(PMSDownloadType pMSDownloadType, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, wm3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948206179, "Lcom/baidu/tieba/uc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948206179, "Lcom/baidu/tieba/uc4;");
                return;
            }
        }
        h = nr1.a;
    }

    @Override // com.baidu.tieba.yi4
    public ui4<dk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ui4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yi4
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
        rc4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public uc4(String str, String str2, String str3, rc4.a aVar) {
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
        this.f = t74.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        rc4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dk4Var) == null) {
            zd2.c().d(dk4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xj4Var) == null) {
            super.C(xj4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + xj4Var.toString());
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

    public final void W(dk4 dk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dk4Var) == null) {
            if (!qo3.a(new File(dk4Var.a), dk4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                wm3 wm3Var = new wm3();
                wm3Var.k(12L);
                wm3Var.i(2300L);
                wm3Var.d("分包签名校验");
                zd2.c().a(dk4Var, PMSDownloadType.ALONE_SUB, wm3Var);
            } else if (we2.h(new File(dk4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                dk4Var.o = this.d;
                aj4.i().m(dk4Var);
                zd2.c().b(dk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                wm3 wm3Var2 = new wm3();
                wm3Var2.k(12L);
                wm3Var2.i(2320L);
                wm3Var2.d("分包解压失败");
                zd2.c().a(dk4Var, PMSDownloadType.ALONE_SUB, wm3Var2);
            }
        }
    }
}
