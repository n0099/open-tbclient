package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public abstract class j62 extends p62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public tg4 d;
    public ef3 e;
    public final cb4<mc4> f;

    /* loaded from: classes4.dex */
    public class a extends q62<j62> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j62 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j62 j62Var, j62 j62Var2) {
            super(j62Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j62Var, j62Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((p62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j62Var;
        }

        @Override // com.baidu.tieba.q62
        public void r(@NonNull mc4 mc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mc4Var) == null) {
                if (j62.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + mc4Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.baidu.tieba.q62
        public void u(mc4 mc4Var, ef3 ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mc4Var, ef3Var) == null) {
                l02.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + mc4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ef3Var);
                if (this.b.e == null) {
                    this.b.e = ef3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835171, "Lcom/baidu/tieba/j62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835171, "Lcom/baidu/tieba/j62;");
                return;
            }
        }
        g = vj1.a;
    }

    public j62() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new AtomicInteger(0);
        this.f = new a(this, this);
    }

    @Override // com.baidu.tieba.gb4
    public void C(fc4 fc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fc4Var) == null) {
            super.C(fc4Var);
            l02.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + fc4Var.toString());
            ef3 ef3Var = new ef3();
            ef3Var.k(17L);
            ef3Var.c(fc4Var);
            Q(ef3Var);
        }
    }

    @Override // com.baidu.tieba.gb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            l02.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            ef3 ef3Var = new ef3();
            ef3Var.k(17L);
            ef3Var.i(2901L);
            ef3Var.d("Server无包");
            Q(ef3Var);
        }
    }

    @Override // com.baidu.tieba.gb4
    public void G(tg4 tg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tg4Var) == null) {
            super.G(tg4Var);
            this.d = tg4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(tg4Var == null ? 0 : tg4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull ef3 ef3Var);

    public abstract void R();

    @Override // com.baidu.tieba.gb4, com.baidu.tieba.db4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            l02.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            tg4 tg4Var = this.d;
            if (tg4Var == null) {
                ef3 ef3Var = new ef3();
                ef3Var.k(17L);
                ef3Var.i(2900L);
                ef3Var.d("unknown error.");
                Q(ef3Var);
                return;
            }
            int n = tg4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                ef3 ef3Var2 = new ef3();
                ef3Var2.k(17L);
                ef3Var2.i(2900L);
                ef3Var2.d("unknown error.");
                this.e = ef3Var2;
            }
            ef3 ef3Var3 = this.e;
            ef3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.baidu.tieba.gb4
    public cb4<mc4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (cb4) invokeV.objValue;
    }
}
