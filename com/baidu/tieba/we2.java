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
public abstract class we2 extends cf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public gp4 d;
    public rn3 e;
    public final pj4<zk4> f;

    public abstract void Q(@NonNull rn3 rn3Var);

    public abstract void R();

    /* loaded from: classes8.dex */
    public class a extends df2<we2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ we2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(we2 we2Var, we2 we2Var2) {
            super(we2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we2Var, we2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((cf2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = we2Var;
        }

        @Override // com.baidu.tieba.df2
        public void u(zk4 zk4Var, rn3 rn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zk4Var, rn3Var) == null) {
                y82.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + zk4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + rn3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = rn3Var;
            }
        }

        @Override // com.baidu.tieba.df2
        public void r(@NonNull zk4 zk4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zk4Var) == null) {
                if (we2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + zk4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948267621, "Lcom/baidu/tieba/we2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948267621, "Lcom/baidu/tieba/we2;");
                return;
            }
        }
        g = is1.a;
    }

    public we2() {
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

    @Override // com.baidu.tieba.tj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            y82.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            rn3 rn3Var = new rn3();
            rn3Var.k(17L);
            rn3Var.i(2901L);
            rn3Var.d("Server无包");
            Q(rn3Var);
        }
    }

    @Override // com.baidu.tieba.tj4
    public pj4<zk4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (pj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tj4
    public void C(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sk4Var) == null) {
            super.C(sk4Var);
            y82.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + sk4Var.toString());
            rn3 rn3Var = new rn3();
            rn3Var.k(17L);
            rn3Var.c(sk4Var);
            Q(rn3Var);
        }
    }

    @Override // com.baidu.tieba.tj4
    public void G(gp4 gp4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gp4Var) == null) {
            super.G(gp4Var);
            this.d = gp4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (gp4Var == null) {
                    n = 0;
                } else {
                    n = gp4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.tj4, com.baidu.tieba.qj4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            y82.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            gp4 gp4Var = this.d;
            if (gp4Var == null) {
                rn3 rn3Var = new rn3();
                rn3Var.k(17L);
                rn3Var.i(2900L);
                rn3Var.d("unknown error.");
                Q(rn3Var);
                return;
            }
            int n = gp4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                rn3 rn3Var2 = new rn3();
                rn3Var2.k(17L);
                rn3Var2.i(2900L);
                rn3Var2.d("unknown error.");
                this.e = rn3Var2;
            }
            rn3 rn3Var3 = this.e;
            rn3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
