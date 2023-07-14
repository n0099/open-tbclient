package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.l84;
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
public class s64 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public k64 c;
    @NonNull
    public t64 d;
    public mj4<wk4> e;

    /* loaded from: classes7.dex */
    public class a extends jj4<wk4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s64 a;

        public a(s64 s64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s64Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mj4
        /* renamed from: l */
        public String d(wk4 wk4Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, wk4Var)) == null) {
                return l84.d.g().getPath();
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: r */
        public void f(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, wk4Var) == null) {
                super.f(wk4Var);
                if (s64.f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
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
        public void e(wk4 wk4Var, pk4 pk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, wk4Var, pk4Var) == null) {
                super.e(wk4Var, pk4Var);
                if (s64.f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + pk4Var.toString());
                }
                this.a.c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: p */
        public void i(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, wk4Var) == null) {
                super.i(wk4Var);
                if (s64.f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + wk4Var.toString());
                }
                if (!ip3.a(new File(wk4Var.a), wk4Var.m)) {
                    if (s64.f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.c.a(false);
                    return;
                }
                File a = this.a.d.a();
                if (a.exists()) {
                    zr4.j(a);
                } else {
                    zr4.l(a);
                }
                boolean U = zr4.U(wk4Var.a, a.getAbsolutePath());
                if (U) {
                    this.a.d.b(wk4Var.j, wk4Var.i);
                }
                zr4.k(wk4Var.a);
                this.a.c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jj4, com.baidu.tieba.mj4
        /* renamed from: q */
        public void c(wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, wk4Var) == null) {
                super.c(wk4Var);
                if (s64.f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + wk4Var.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948103352, "Lcom/baidu/tieba/s64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948103352, "Lcom/baidu/tieba/s64;");
                return;
            }
        }
        f = fs1.a;
    }

    @Override // com.baidu.tieba.qj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            if (f) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.c.a(false);
        }
    }

    @Override // com.baidu.tieba.qj4
    public mj4<wk4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (mj4) invokeV.objValue;
    }

    public s64(@NonNull t64 t64Var, @NonNull k64 k64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t64Var, k64Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.c = k64Var;
        this.d = t64Var;
    }

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dp4Var) == null) {
            super.G(dp4Var);
            if (f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pk4Var) == null) {
            super.C(pk4Var);
            if (f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + pk4Var.toString());
            }
            this.c.a(false);
        }
    }
}
