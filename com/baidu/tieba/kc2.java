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
/* loaded from: classes5.dex */
public abstract class kc2 extends qc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public um4 d;
    public fl3 e;
    public final dh4<ni4> f;

    public abstract void Q(@NonNull fl3 fl3Var);

    public abstract void R();

    /* loaded from: classes5.dex */
    public class a extends rc2<kc2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kc2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kc2 kc2Var, kc2 kc2Var2) {
            super(kc2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kc2Var, kc2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((qc2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kc2Var;
        }

        @Override // com.baidu.tieba.rc2
        public void u(ni4 ni4Var, fl3 fl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni4Var, fl3Var) == null) {
                m62.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + ni4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + fl3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = fl3Var;
            }
        }

        @Override // com.baidu.tieba.rc2
        public void r(@NonNull ni4 ni4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ni4Var) == null) {
                if (kc2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + ni4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947908207, "Lcom/baidu/tieba/kc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947908207, "Lcom/baidu/tieba/kc2;");
                return;
            }
        }
        g = wp1.a;
    }

    public kc2() {
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

    @Override // com.baidu.tieba.hh4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            m62.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            fl3 fl3Var = new fl3();
            fl3Var.k(17L);
            fl3Var.i(2901L);
            fl3Var.d("Server无包");
            Q(fl3Var);
        }
    }

    @Override // com.baidu.tieba.hh4
    public dh4<ni4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (dh4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh4
    public void C(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gi4Var) == null) {
            super.C(gi4Var);
            m62.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + gi4Var.toString());
            fl3 fl3Var = new fl3();
            fl3Var.k(17L);
            fl3Var.c(gi4Var);
            Q(fl3Var);
        }
    }

    @Override // com.baidu.tieba.hh4
    public void G(um4 um4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, um4Var) == null) {
            super.G(um4Var);
            this.d = um4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (um4Var == null) {
                    n = 0;
                } else {
                    n = um4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.hh4, com.baidu.tieba.eh4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            m62.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            um4 um4Var = this.d;
            if (um4Var == null) {
                fl3 fl3Var = new fl3();
                fl3Var.k(17L);
                fl3Var.i(2900L);
                fl3Var.d("unknown error.");
                Q(fl3Var);
                return;
            }
            int n = um4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                fl3 fl3Var2 = new fl3();
                fl3Var2.k(17L);
                fl3Var2.i(2900L);
                fl3Var2.d("unknown error.");
                this.e = fl3Var2;
            }
            fl3 fl3Var3 = this.e;
            fl3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
