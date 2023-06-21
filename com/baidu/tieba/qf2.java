package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.tieba.ve2;
import com.baidu.tieba.vu2;
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
public class qf2 extends df2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public ue2 c;
    public String d;
    public String e;
    public qj4<zk4> f;

    /* loaded from: classes7.dex */
    public class a extends nj4<zk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf2 a;

        public a(qf2 qf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qj4
        /* renamed from: l */
        public String d(zk4 zk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, zk4Var)) == null) {
                return sf2.a(this.a.e);
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: q */
        public void f(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zk4Var) == null) {
                super.f(zk4Var);
                if (qf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.a.V(zk4Var);
            }
        }

        @Override // com.baidu.tieba.sj4
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
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: o */
        public void e(zk4 zk4Var, tk4 tk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, zk4Var, tk4Var) == null) {
                super.e(zk4Var, tk4Var);
                if (qf2.g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + tk4Var.toString());
                }
                sn3 sn3Var = new sn3();
                sn3Var.k(12L);
                sn3Var.i(tk4Var.a);
                sn3Var.d("分包下载失败");
                sn3Var.f(tk4Var.toString());
                this.a.S(3, sn3Var);
                ve2.c().a(zk4Var, PMSDownloadType.ALONE_SUB, sn3Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj4, com.baidu.tieba.qj4
        /* renamed from: p */
        public void i(zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, zk4Var) == null) {
                super.i(zk4Var);
                if (qf2.g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish:" + zk4Var.toString());
                }
                this.a.U(zk4Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ve2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qf2 a;

        public b(qf2 qf2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qf2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qf2Var;
        }

        @Override // com.baidu.tieba.ve2.c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, pMSDownloadType) != null) {
                return;
            }
            this.a.T();
        }

        @Override // com.baidu.tieba.ve2.c
        public void b(PMSDownloadType pMSDownloadType, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, sn3Var) != null) {
                return;
            }
            this.a.S(0, sn3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948089836, "Lcom/baidu/tieba/qf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948089836, "Lcom/baidu/tieba/qf2;");
                return;
            }
        }
        g = js1.a;
    }

    @Override // com.baidu.tieba.uj4
    public qj4<zk4> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            sn3 sn3Var = new sn3();
            sn3Var.k(12L);
            sn3Var.i(2901L);
            sn3Var.d("Server无包");
            S(2, sn3Var);
        }
    }

    public final void T() {
        ue2 ue2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ue2Var = this.c) != null) {
            ue2Var.a();
        }
    }

    public qf2(String str, String str2, ue2 ue2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, ue2Var};
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
        this.c = ue2Var;
        this.e = vu2.e.i(str, str2).getPath();
    }

    @Override // com.baidu.tieba.uj4
    public void C(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tk4Var) == null) {
            super.C(tk4Var);
            sn3 sn3Var = new sn3();
            sn3Var.k(12L);
            sn3Var.c(tk4Var);
            S(1, sn3Var);
        }
    }

    public final void V(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, zk4Var) == null) {
            ve2.c().d(zk4Var, new b(this));
        }
    }

    public final void S(int i, sn3 sn3Var) {
        ue2 ue2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, sn3Var) == null) && (ue2Var = this.c) != null) {
            ue2Var.b(i, sn3Var);
        }
    }

    public final void U(zk4 zk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zk4Var) == null) {
            if (!mp3.a(new File(zk4Var.a), zk4Var.m)) {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                sn3 sn3Var = new sn3();
                sn3Var.k(12L);
                sn3Var.i(2300L);
                sn3Var.d("分包签名校验");
                S(4, sn3Var);
                ve2.c().a(zk4Var, PMSDownloadType.ALONE_SUB, sn3Var);
            } else if (sf2.h(new File(zk4Var.a), new File(this.e, zk4Var.p))) {
                if (g) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                zk4Var.o = this.d;
                wj4.i().m(zk4Var);
                T();
                ve2.c().b(zk4Var, PMSDownloadType.ALONE_SUB);
            } else {
                if (g) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                sn3 sn3Var2 = new sn3();
                sn3Var2.k(12L);
                sn3Var2.i(2320L);
                sn3Var2.d("分包解压失败");
                S(5, sn3Var2);
                ve2.c().a(zk4Var, PMSDownloadType.ALONE_SUB, sn3Var2);
            }
        }
    }
}
