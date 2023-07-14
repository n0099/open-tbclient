package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.jd4;
import com.baidu.tieba.l84;
import com.baidu.tieba.re2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class md4 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public jd4.a c;
    public String d;
    public String e;
    public String f;
    public mj4<vk4> g;

    /* loaded from: classes7.dex */
    public class a extends jj4<vk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md4 a;

        public a(md4 md4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(vk4 vk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vk4Var)) == null) {
                return of2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, vk4Var) == null) {
                super.f(vk4Var);
                if (md4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(vk4Var);
            }
        }

        @Override // com.baidu.tieba.oj4
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
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: o */
        public void e(vk4 vk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, vk4Var, pk4Var) == null) {
                super.e(vk4Var, pk4Var);
                if (md4.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + pk4Var.toString());
                }
                this.a.T(2103);
                on3 on3Var = new on3();
                on3Var.k(12L);
                on3Var.i(pk4Var.a);
                on3Var.d("分包下载失败");
                on3Var.f(pk4Var.toString());
                re2.c().a(vk4Var, PMSDownloadType.ALONE_SUB, on3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk4Var) == null) {
                super.i(vk4Var);
                if (md4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + vk4Var.toString());
                }
                this.a.W(vk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void a(vk4 vk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, vk4Var) == null) {
                super.a(vk4Var);
                if (md4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + vk4Var.k + ":" + vk4Var.b);
                }
                this.a.U(vk4Var.b, vk4Var.k);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements re2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md4 a;

        public b(md4 md4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md4Var;
        }

        @Override // com.baidu.tieba.re2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.re2.c
        public void b(PMSDownloadType pMSDownloadType, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, on3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947968812, "Lcom/baidu/tieba/md4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947968812, "Lcom/baidu/tieba/md4;");
                return;
            }
        }
        h = fs1.a;
    }

    @Override // com.baidu.tieba.qj4
    public mj4<vk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
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
        jd4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public md4(String str, String str2, String str3, jd4.a aVar) {
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
        this.f = l84.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        jd4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vk4Var) == null) {
            re2.c().d(vk4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pk4Var) == null) {
            super.C(pk4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + pk4Var.toString());
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

    public final void W(vk4 vk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vk4Var) == null) {
            if (!ip3.a(new File(vk4Var.a), vk4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                on3 on3Var = new on3();
                on3Var.k(12L);
                on3Var.i(2300L);
                on3Var.d("分包签名校验");
                re2.c().a(vk4Var, PMSDownloadType.ALONE_SUB, on3Var);
            } else if (of2.h(new File(vk4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                vk4Var.o = this.d;
                sj4.i().m(vk4Var);
                re2.c().b(vk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                on3 on3Var2 = new on3();
                on3Var2.k(12L);
                on3Var2.i(2320L);
                on3Var2.d("分包解压失败");
                re2.c().a(vk4Var, PMSDownloadType.ALONE_SUB, on3Var2);
            }
        }
    }
}
