package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.de2;
import com.baidu.tieba.vc4;
import com.baidu.tieba.x74;
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
public class yc4 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public vc4.a c;
    public String d;
    public String e;
    public String f;
    public yi4<hk4> g;

    /* loaded from: classes8.dex */
    public class a extends vi4<hk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc4 a;

        public a(yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi4
        /* renamed from: l */
        public String d(hk4 hk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hk4Var)) == null) {
                return af2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: r */
        public void f(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, hk4Var) == null) {
                super.f(hk4Var);
                if (yc4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(hk4Var);
            }
        }

        @Override // com.baidu.tieba.aj4
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
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: o */
        public void e(hk4 hk4Var, bk4 bk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, hk4Var, bk4Var) == null) {
                super.e(hk4Var, bk4Var);
                if (yc4.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + bk4Var.toString());
                }
                this.a.T(2103);
                an3 an3Var = new an3();
                an3Var.k(12L);
                an3Var.i(bk4Var.a);
                an3Var.d("分包下载失败");
                an3Var.f(bk4Var.toString());
                de2.c().a(hk4Var, PMSDownloadType.ALONE_SUB, an3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: p */
        public void i(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hk4Var) == null) {
                super.i(hk4Var);
                if (yc4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + hk4Var.toString());
                }
                this.a.W(hk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vi4, com.baidu.tieba.yi4
        /* renamed from: q */
        public void a(hk4 hk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, hk4Var) == null) {
                super.a(hk4Var);
                if (yc4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + hk4Var.k + ":" + hk4Var.b);
                }
                this.a.U(hk4Var.b, hk4Var.k);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements de2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yc4 a;

        public b(yc4 yc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yc4Var;
        }

        @Override // com.baidu.tieba.de2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.de2.c
        public void b(PMSDownloadType pMSDownloadType, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, an3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948325343, "Lcom/baidu/tieba/yc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948325343, "Lcom/baidu/tieba/yc4;");
                return;
            }
        }
        h = rr1.a;
    }

    @Override // com.baidu.tieba.cj4
    public yi4<hk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (yi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.cj4
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
        vc4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public yc4(String str, String str2, String str3, vc4.a aVar) {
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
        this.f = x74.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        vc4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hk4Var) == null) {
            de2.c().d(hk4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bk4Var) == null) {
            super.C(bk4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + bk4Var.toString());
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

    public final void W(hk4 hk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hk4Var) == null) {
            if (!uo3.a(new File(hk4Var.a), hk4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                an3 an3Var = new an3();
                an3Var.k(12L);
                an3Var.i(2300L);
                an3Var.d("分包签名校验");
                de2.c().a(hk4Var, PMSDownloadType.ALONE_SUB, an3Var);
            } else if (af2.h(new File(hk4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                hk4Var.o = this.d;
                ej4.i().m(hk4Var);
                de2.c().b(hk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                an3 an3Var2 = new an3();
                an3Var2.k(12L);
                an3Var2.i(2320L);
                an3Var2.d("分包解压失败");
                de2.c().a(hk4Var, PMSDownloadType.ALONE_SUB, an3Var2);
            }
        }
    }
}
