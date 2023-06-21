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
public abstract class xe2 extends df2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public hp4 d;
    public sn3 e;
    public final qj4<al4> f;

    public abstract void Q(@NonNull sn3 sn3Var);

    public abstract void R();

    /* loaded from: classes8.dex */
    public class a extends ef2<xe2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xe2 xe2Var, xe2 xe2Var2) {
            super(xe2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe2Var, xe2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((df2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xe2Var;
        }

        @Override // com.baidu.tieba.ef2
        public void u(al4 al4Var, sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, al4Var, sn3Var) == null) {
                z82.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + al4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + sn3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = sn3Var;
            }
        }

        @Override // com.baidu.tieba.ef2
        public void r(@NonNull al4 al4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, al4Var) == null) {
                if (xe2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + al4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948297412, "Lcom/baidu/tieba/xe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948297412, "Lcom/baidu/tieba/xe2;");
                return;
            }
        }
        g = js1.a;
    }

    public xe2() {
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

    @Override // com.baidu.tieba.uj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            z82.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            sn3 sn3Var = new sn3();
            sn3Var.k(17L);
            sn3Var.i(2901L);
            sn3Var.d("Server无包");
            Q(sn3Var);
        }
    }

    @Override // com.baidu.tieba.uj4
    public qj4<al4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (qj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uj4
    public void C(tk4 tk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tk4Var) == null) {
            super.C(tk4Var);
            z82.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + tk4Var.toString());
            sn3 sn3Var = new sn3();
            sn3Var.k(17L);
            sn3Var.c(tk4Var);
            Q(sn3Var);
        }
    }

    @Override // com.baidu.tieba.uj4
    public void G(hp4 hp4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hp4Var) == null) {
            super.G(hp4Var);
            this.d = hp4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (hp4Var == null) {
                    n = 0;
                } else {
                    n = hp4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.uj4, com.baidu.tieba.rj4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            z82.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            hp4 hp4Var = this.d;
            if (hp4Var == null) {
                sn3 sn3Var = new sn3();
                sn3Var.k(17L);
                sn3Var.i(2900L);
                sn3Var.d("unknown error.");
                Q(sn3Var);
                return;
            }
            int n = hp4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                sn3 sn3Var2 = new sn3();
                sn3Var2.k(17L);
                sn3Var2.i(2900L);
                sn3Var2.d("unknown error.");
                this.e = sn3Var2;
            }
            sn3 sn3Var3 = this.e;
            sn3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
