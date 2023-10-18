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
/* loaded from: classes7.dex */
public abstract class n82 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public xi4 d;
    public ih3 e;
    public final gd4<qe4> f;

    public abstract void Q(@NonNull ih3 ih3Var);

    public abstract void R();

    /* loaded from: classes7.dex */
    public class a extends u82<n82> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n82 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n82 n82Var, n82 n82Var2) {
            super(n82Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n82Var, n82Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t82) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n82Var;
        }

        @Override // com.baidu.tieba.u82
        public void u(qe4 qe4Var, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe4Var, ih3Var) == null) {
                p22.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + qe4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ih3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = ih3Var;
            }
        }

        @Override // com.baidu.tieba.u82
        public void r(@NonNull qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qe4Var) == null) {
                if (n82.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + qe4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947956257, "Lcom/baidu/tieba/n82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947956257, "Lcom/baidu/tieba/n82;");
                return;
            }
        }
        g = am1.a;
    }

    public n82() {
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

    @Override // com.baidu.tieba.kd4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            p22.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            ih3 ih3Var = new ih3();
            ih3Var.k(17L);
            ih3Var.i(2901L);
            ih3Var.d("Server无包");
            Q(ih3Var);
        }
    }

    @Override // com.baidu.tieba.kd4
    public gd4<qe4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (gd4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, je4Var) == null) {
            super.C(je4Var);
            p22.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + je4Var.toString());
            ih3 ih3Var = new ih3();
            ih3Var.k(17L);
            ih3Var.c(je4Var);
            Q(ih3Var);
        }
    }

    @Override // com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xi4Var) == null) {
            super.G(xi4Var);
            this.d = xi4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (xi4Var == null) {
                    n = 0;
                } else {
                    n = xi4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.kd4, com.baidu.tieba.hd4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            p22.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            xi4 xi4Var = this.d;
            if (xi4Var == null) {
                ih3 ih3Var = new ih3();
                ih3Var.k(17L);
                ih3Var.i(2900L);
                ih3Var.d("unknown error.");
                Q(ih3Var);
                return;
            }
            int n = xi4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                ih3 ih3Var2 = new ih3();
                ih3Var2.k(17L);
                ih3Var2.i(2900L);
                ih3Var2.d("unknown error.");
                this.e = ih3Var2;
            }
            ih3 ih3Var3 = this.e;
            ih3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
