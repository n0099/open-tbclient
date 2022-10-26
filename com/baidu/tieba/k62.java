package com.baidu.tieba;

import android.util.Log;
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
public abstract class k62 extends q62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public ug4 d;
    public ff3 e;
    public final db4 f;

    public abstract void Q(ff3 ff3Var);

    public abstract void R();

    /* loaded from: classes4.dex */
    public class a extends r62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k62 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k62 k62Var, k62 k62Var2) {
            super(k62Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k62Var, k62Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((q62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = k62Var;
        }

        @Override // com.baidu.tieba.r62
        public void u(nc4 nc4Var, ff3 ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nc4Var, ff3Var) == null) {
                m02.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + nc4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + ff3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = ff3Var;
            }
        }

        @Override // com.baidu.tieba.r62
        public void r(nc4 nc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nc4Var) == null) {
                if (k62.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + nc4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947864962, "Lcom/baidu/tieba/k62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947864962, "Lcom/baidu/tieba/k62;");
                return;
            }
        }
        g = wj1.a;
    }

    public k62() {
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

    @Override // com.baidu.tieba.hb4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            m02.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            ff3 ff3Var = new ff3();
            ff3Var.k(17L);
            ff3Var.i(2901L);
            ff3Var.d("Server无包");
            Q(ff3Var);
        }
    }

    @Override // com.baidu.tieba.hb4
    public db4 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (db4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hb4
    public void C(gc4 gc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gc4Var) == null) {
            super.C(gc4Var);
            m02.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + gc4Var.toString());
            ff3 ff3Var = new ff3();
            ff3Var.k(17L);
            ff3Var.c(gc4Var);
            Q(ff3Var);
        }
    }

    @Override // com.baidu.tieba.hb4
    public void G(ug4 ug4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ug4Var) == null) {
            super.G(ug4Var);
            this.d = ug4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (ug4Var == null) {
                    n = 0;
                } else {
                    n = ug4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.hb4, com.baidu.tieba.eb4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            m02.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            ug4 ug4Var = this.d;
            if (ug4Var == null) {
                ff3 ff3Var = new ff3();
                ff3Var.k(17L);
                ff3Var.i(2900L);
                ff3Var.d("unknown error.");
                Q(ff3Var);
                return;
            }
            int n = ug4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                ff3 ff3Var2 = new ff3();
                ff3Var2.k(17L);
                ff3Var2.i(2900L);
                ff3Var2.d("unknown error.");
                this.e = ff3Var2;
            }
            ff3 ff3Var3 = this.e;
            ff3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
