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
/* loaded from: classes6.dex */
public abstract class ub2 extends ac2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public em4 d;
    public pk3 e;
    public final ng4<xh4> f;

    public abstract void Q(@NonNull pk3 pk3Var);

    public abstract void R();

    /* loaded from: classes6.dex */
    public class a extends bc2<ub2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ub2 ub2Var, ub2 ub2Var2) {
            super(ub2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub2Var, ub2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ac2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ub2Var;
        }

        @Override // com.baidu.tieba.bc2
        public void u(xh4 xh4Var, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xh4Var, pk3Var) == null) {
                w52.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + xh4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + pk3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = pk3Var;
            }
        }

        @Override // com.baidu.tieba.bc2
        public void r(@NonNull xh4 xh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, xh4Var) == null) {
                if (ub2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + xh4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948205156, "Lcom/baidu/tieba/ub2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948205156, "Lcom/baidu/tieba/ub2;");
                return;
            }
        }
        g = gp1.a;
    }

    public ub2() {
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

    @Override // com.baidu.tieba.rg4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            w52.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            pk3 pk3Var = new pk3();
            pk3Var.k(17L);
            pk3Var.i(2901L);
            pk3Var.d("Server无包");
            Q(pk3Var);
        }
    }

    @Override // com.baidu.tieba.rg4
    public ng4<xh4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (ng4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rg4
    public void C(qh4 qh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qh4Var) == null) {
            super.C(qh4Var);
            w52.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + qh4Var.toString());
            pk3 pk3Var = new pk3();
            pk3Var.k(17L);
            pk3Var.c(qh4Var);
            Q(pk3Var);
        }
    }

    @Override // com.baidu.tieba.rg4
    public void G(em4 em4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, em4Var) == null) {
            super.G(em4Var);
            this.d = em4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (em4Var == null) {
                    n = 0;
                } else {
                    n = em4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.rg4, com.baidu.tieba.og4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            w52.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            em4 em4Var = this.d;
            if (em4Var == null) {
                pk3 pk3Var = new pk3();
                pk3Var.k(17L);
                pk3Var.i(2900L);
                pk3Var.d("unknown error.");
                Q(pk3Var);
                return;
            }
            int n = em4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                pk3 pk3Var2 = new pk3();
                pk3Var2.k(17L);
                pk3Var2.i(2900L);
                pk3Var2.d("unknown error.");
                this.e = pk3Var2;
            }
            pk3 pk3Var3 = this.e;
            pk3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
