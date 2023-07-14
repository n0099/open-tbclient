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
/* loaded from: classes8.dex */
public abstract class te2 extends ze2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public dp4 d;
    public on3 e;
    public final mj4<wk4> f;

    public abstract void Q(@NonNull on3 on3Var);

    public abstract void R();

    /* loaded from: classes8.dex */
    public class a extends af2<te2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(te2 te2Var, te2 te2Var2) {
            super(te2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te2Var, te2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ze2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = te2Var;
        }

        @Override // com.baidu.tieba.af2
        public void u(wk4 wk4Var, on3 on3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wk4Var, on3Var) == null) {
                v82.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + wk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + on3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = on3Var;
            }
        }

        @Override // com.baidu.tieba.af2
        public void r(@NonNull wk4 wk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wk4Var) == null) {
                if (te2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + wk4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948178248, "Lcom/baidu/tieba/te2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948178248, "Lcom/baidu/tieba/te2;");
                return;
            }
        }
        g = fs1.a;
    }

    public te2() {
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

    @Override // com.baidu.tieba.qj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            v82.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            on3 on3Var = new on3();
            on3Var.k(17L);
            on3Var.i(2901L);
            on3Var.d("Server无包");
            Q(on3Var);
        }
    }

    @Override // com.baidu.tieba.qj4
    public mj4<wk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (mj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj4
    public void C(pk4 pk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pk4Var) == null) {
            super.C(pk4Var);
            v82.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + pk4Var.toString());
            on3 on3Var = new on3();
            on3Var.k(17L);
            on3Var.c(pk4Var);
            Q(on3Var);
        }
    }

    @Override // com.baidu.tieba.qj4
    public void G(dp4 dp4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dp4Var) == null) {
            super.G(dp4Var);
            this.d = dp4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (dp4Var == null) {
                    n = 0;
                } else {
                    n = dp4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.qj4, com.baidu.tieba.nj4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            v82.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            dp4 dp4Var = this.d;
            if (dp4Var == null) {
                on3 on3Var = new on3();
                on3Var.k(17L);
                on3Var.i(2900L);
                on3Var.d("unknown error.");
                Q(on3Var);
                return;
            }
            int n = dp4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                on3 on3Var2 = new on3();
                on3Var2.k(17L);
                on3Var2.i(2900L);
                on3Var2.d("unknown error.");
                this.e = on3Var2;
            }
            on3 on3Var3 = this.e;
            on3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
