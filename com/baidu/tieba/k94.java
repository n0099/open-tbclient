package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.h94;
import com.baidu.tieba.j44;
import com.baidu.tieba.pa2;
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
public class k94 extends xa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public h94.a c;
    public String d;
    public String e;
    public String f;
    public kf4<tg4> g;

    /* loaded from: classes5.dex */
    public class a extends hf4<tg4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k94 a;

        public a(k94 k94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k94Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kf4
        /* renamed from: l */
        public String d(tg4 tg4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tg4Var)) == null) {
                return mb2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: r */
        public void f(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, tg4Var) == null) {
                super.f(tg4Var);
                if (k94.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(tg4Var);
            }
        }

        @Override // com.baidu.tieba.mf4
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
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: o */
        public void e(tg4 tg4Var, ng4 ng4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, tg4Var, ng4Var) == null) {
                super.e(tg4Var, ng4Var);
                if (k94.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + ng4Var.toString());
                }
                this.a.T(2103);
                mj3 mj3Var = new mj3();
                mj3Var.k(12L);
                mj3Var.i(ng4Var.a);
                mj3Var.d("分包下载失败");
                mj3Var.f(ng4Var.toString());
                pa2.c().a(tg4Var, PMSDownloadType.ALONE_SUB, mj3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: p */
        public void i(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tg4Var) == null) {
                super.i(tg4Var);
                if (k94.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + tg4Var.toString());
                }
                this.a.W(tg4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hf4, com.baidu.tieba.kf4
        /* renamed from: q */
        public void a(tg4 tg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, tg4Var) == null) {
                super.a(tg4Var);
                if (k94.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + tg4Var.k + ":" + tg4Var.b);
                }
                this.a.U(tg4Var.b, tg4Var.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements pa2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k94 a;

        public b(k94 k94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k94Var;
        }

        @Override // com.baidu.tieba.pa2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.pa2.c
        public void b(PMSDownloadType pMSDownloadType, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, mj3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947867907, "Lcom/baidu/tieba/k94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947867907, "Lcom/baidu/tieba/k94;");
                return;
            }
        }
        h = do1.a;
    }

    @Override // com.baidu.tieba.of4
    public kf4<tg4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
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
        h94.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public k94(String str, String str2, String str3, h94.a aVar) {
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
        this.f = j44.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        h94.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tg4Var) == null) {
            pa2.c().d(tg4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.of4
    public void C(ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ng4Var) == null) {
            super.C(ng4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + ng4Var.toString());
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

    public final void W(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tg4Var) == null) {
            if (!gl3.a(new File(tg4Var.a), tg4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                mj3 mj3Var = new mj3();
                mj3Var.k(12L);
                mj3Var.i(2300L);
                mj3Var.d("分包签名校验");
                pa2.c().a(tg4Var, PMSDownloadType.ALONE_SUB, mj3Var);
            } else if (mb2.h(new File(tg4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                tg4Var.o = this.d;
                qf4.i().m(tg4Var);
                pa2.c().b(tg4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                mj3 mj3Var2 = new mj3();
                mj3Var2.k(12L);
                mj3Var2.i(2320L);
                mj3Var2.d("分包解压失败");
                pa2.c().a(tg4Var, PMSDownloadType.ALONE_SUB, mj3Var2);
            }
        }
    }
}
