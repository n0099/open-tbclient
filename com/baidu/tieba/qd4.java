package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.nd4;
import com.baidu.tieba.p84;
import com.baidu.tieba.ve2;
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
public class qd4 extends df2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean h;
    public transient /* synthetic */ FieldHolder $fh;
    public nd4.a c;
    public String d;
    public String e;
    public String f;
    public qj4<zk4> g;

    /* loaded from: classes7.dex */
    public class a extends nj4<zk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qd4 a;

        public a(qd4 qd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qd4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(zk4 zk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, zk4Var)) == null) {
                return sf2.c(this.a.f);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: r */
        public void f(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, zk4Var) == null) {
                super.f(zk4Var);
                if (qd4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.a.X(zk4Var);
            }
        }

        @Override // com.baidu.tieba.sj4
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
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(zk4 zk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, zk4Var, tk4Var) == null) {
                super.e(zk4Var, tk4Var);
                if (qd4.h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + tk4Var.toString());
                }
                this.a.T(2103);
                sn3 sn3Var = new sn3();
                sn3Var.k(12L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("分包下载失败");
                sn3Var.f(tk4Var.toString());
                ve2.c().a(zk4Var, PMSDownloadType.ALONE_SUB, sn3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zk4Var) == null) {
                super.i(zk4Var);
                if (qd4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + zk4Var.toString());
                }
                this.a.W(zk4Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void a(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, zk4Var) == null) {
                super.a(zk4Var);
                if (qd4.h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + zk4Var.k + ":" + zk4Var.b);
                }
                this.a.U(zk4Var.b, zk4Var.k);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qd4 a;

        public b(qd4 qd4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qd4Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.V();
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) != null) {
                return;
            }
            this.a.T(2103);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948087976, "Lcom/baidu/tieba/qd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948087976, "Lcom/baidu/tieba/qd4;");
                return;
            }
        }
        h = js1.a;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<zk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
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
        nd4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (aVar = this.c) != null) {
            aVar.success();
        }
    }

    public qd4(String str, String str2, String str3, nd4.a aVar) {
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
        this.f = p84.d.h(str, str2).getPath();
    }

    public final void T(int i) {
        nd4.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && (aVar = this.c) != null) {
            aVar.b(i);
        }
    }

    public final void X(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zk4Var) == null) {
            ve2.c().d(zk4Var, new b(this));
        }
    }

    @Override // com.baidu.tieba.uj4
    public void C(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tk4Var) == null) {
            super.C(tk4Var);
            if (h) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + tk4Var.toString());
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

    public final void W(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zk4Var) == null) {
            if (!mp3.a(new File(zk4Var.a), zk4Var.m)) {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                T(RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4);
                sn3 sn3Var = new sn3();
                sn3Var.k(12L);
                sn3Var.i(2300L);
                sn3Var.d("分包签名校验");
                ve2.c().a(zk4Var, PMSDownloadType.ALONE_SUB, sn3Var);
            } else if (sf2.h(new File(zk4Var.a), new File(this.f, this.e))) {
                if (h) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                V();
                zk4Var.o = this.d;
                wj4.i().m(zk4Var);
                ve2.c().b(zk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (h) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                T(2105);
                sn3 sn3Var2 = new sn3();
                sn3Var2.k(12L);
                sn3Var2.i(2320L);
                sn3Var2.d("分包解压失败");
                ve2.c().a(zk4Var, PMSDownloadType.ALONE_SUB, sn3Var2);
            }
        }
    }
}
