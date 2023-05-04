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
public abstract class va2 extends bb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public fl4 d;
    public qj3 e;
    public final of4<yg4> f;

    public abstract void Q(@NonNull qj3 qj3Var);

    public abstract void R();

    /* loaded from: classes6.dex */
    public class a extends cb2<va2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ va2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(va2 va2Var, va2 va2Var2) {
            super(va2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, va2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((bb2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = va2Var;
        }

        @Override // com.baidu.tieba.cb2
        public void u(yg4 yg4Var, qj3 qj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg4Var, qj3Var) == null) {
                x42.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + yg4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + qj3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = qj3Var;
            }
        }

        @Override // com.baidu.tieba.cb2
        public void r(@NonNull yg4 yg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, yg4Var) == null) {
                if (va2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + yg4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948233986, "Lcom/baidu/tieba/va2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948233986, "Lcom/baidu/tieba/va2;");
                return;
            }
        }
        g = ho1.a;
    }

    public va2() {
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

    @Override // com.baidu.tieba.sf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            x42.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            qj3 qj3Var = new qj3();
            qj3Var.k(17L);
            qj3Var.i(2901L);
            qj3Var.d("Server无包");
            Q(qj3Var);
        }
    }

    @Override // com.baidu.tieba.sf4
    public of4<yg4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (of4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sf4
    public void C(rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rg4Var) == null) {
            super.C(rg4Var);
            x42.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + rg4Var.toString());
            qj3 qj3Var = new qj3();
            qj3Var.k(17L);
            qj3Var.c(rg4Var);
            Q(qj3Var);
        }
    }

    @Override // com.baidu.tieba.sf4
    public void G(fl4 fl4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fl4Var) == null) {
            super.G(fl4Var);
            this.d = fl4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (fl4Var == null) {
                    n = 0;
                } else {
                    n = fl4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.sf4, com.baidu.tieba.pf4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            x42.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            fl4 fl4Var = this.d;
            if (fl4Var == null) {
                qj3 qj3Var = new qj3();
                qj3Var.k(17L);
                qj3Var.i(2900L);
                qj3Var.d("unknown error.");
                Q(qj3Var);
                return;
            }
            int n = fl4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                qj3 qj3Var2 = new qj3();
                qj3Var2.k(17L);
                qj3Var2.i(2900L);
                qj3Var2.d("unknown error.");
                this.e = qj3Var2;
            }
            qj3 qj3Var3 = this.e;
            qj3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
