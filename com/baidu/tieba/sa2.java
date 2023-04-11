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
public abstract class sa2 extends ya2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public cl4 d;
    public nj3 e;
    public final lf4<vg4> f;

    public abstract void Q(@NonNull nj3 nj3Var);

    public abstract void R();

    /* loaded from: classes6.dex */
    public class a extends za2<sa2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sa2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(sa2 sa2Var, sa2 sa2Var2) {
            super(sa2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sa2Var, sa2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ya2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sa2Var;
        }

        @Override // com.baidu.tieba.za2
        public void u(vg4 vg4Var, nj3 nj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vg4Var, nj3Var) == null) {
                u42.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + vg4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + nj3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = nj3Var;
            }
        }

        @Override // com.baidu.tieba.za2
        public void r(@NonNull vg4 vg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, vg4Var) == null) {
                if (sa2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + vg4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948144613, "Lcom/baidu/tieba/sa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948144613, "Lcom/baidu/tieba/sa2;");
                return;
            }
        }
        g = eo1.a;
    }

    public sa2() {
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

    @Override // com.baidu.tieba.pf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            u42.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            nj3 nj3Var = new nj3();
            nj3Var.k(17L);
            nj3Var.i(2901L);
            nj3Var.d("Server无包");
            Q(nj3Var);
        }
    }

    @Override // com.baidu.tieba.pf4
    public lf4<vg4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (lf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pf4
    public void C(og4 og4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, og4Var) == null) {
            super.C(og4Var);
            u42.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + og4Var.toString());
            nj3 nj3Var = new nj3();
            nj3Var.k(17L);
            nj3Var.c(og4Var);
            Q(nj3Var);
        }
    }

    @Override // com.baidu.tieba.pf4
    public void G(cl4 cl4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cl4Var) == null) {
            super.G(cl4Var);
            this.d = cl4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (cl4Var == null) {
                    n = 0;
                } else {
                    n = cl4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.pf4, com.baidu.tieba.mf4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            u42.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            cl4 cl4Var = this.d;
            if (cl4Var == null) {
                nj3 nj3Var = new nj3();
                nj3Var.k(17L);
                nj3Var.i(2900L);
                nj3Var.d("unknown error.");
                Q(nj3Var);
                return;
            }
            int n = cl4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                nj3 nj3Var2 = new nj3();
                nj3Var2.k(17L);
                nj3Var2.i(2900L);
                nj3Var2.d("unknown error.");
                this.e = nj3Var2;
            }
            nj3 nj3Var3 = this.e;
            nj3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
