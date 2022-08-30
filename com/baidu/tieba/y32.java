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
public abstract class y32 extends e42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public ge4 d;
    public tc3 e;
    public final p84<z94> f;

    /* loaded from: classes6.dex */
    public class a extends f42<y32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y32 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y32 y32Var, y32 y32Var2) {
            super(y32Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y32Var, y32Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((e42) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y32Var;
        }

        @Override // com.baidu.tieba.f42
        public void r(@NonNull z94 z94Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z94Var) == null) {
                if (y32.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + z94Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.baidu.tieba.f42
        public void u(z94 z94Var, tc3 tc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z94Var, tc3Var) == null) {
                ay1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + z94Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + tc3Var);
                if (this.b.e == null) {
                    this.b.e = tc3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948279153, "Lcom/baidu/tieba/y32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948279153, "Lcom/baidu/tieba/y32;");
                return;
            }
        }
        g = kh1.a;
    }

    public y32() {
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

    @Override // com.baidu.tieba.t84
    public void C(s94 s94Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, s94Var) == null) {
            super.C(s94Var);
            ay1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + s94Var.toString());
            tc3 tc3Var = new tc3();
            tc3Var.k(17L);
            tc3Var.c(s94Var);
            Q(tc3Var);
        }
    }

    @Override // com.baidu.tieba.t84
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            ay1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            tc3 tc3Var = new tc3();
            tc3Var.k(17L);
            tc3Var.i(2901L);
            tc3Var.d("Server无包");
            Q(tc3Var);
        }
    }

    @Override // com.baidu.tieba.t84
    public void G(ge4 ge4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ge4Var) == null) {
            super.G(ge4Var);
            this.d = ge4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(ge4Var == null ? 0 : ge4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull tc3 tc3Var);

    public abstract void R();

    @Override // com.baidu.tieba.t84, com.baidu.tieba.q84
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            ay1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            ge4 ge4Var = this.d;
            if (ge4Var == null) {
                tc3 tc3Var = new tc3();
                tc3Var.k(17L);
                tc3Var.i(2900L);
                tc3Var.d("unknown error.");
                Q(tc3Var);
                return;
            }
            int n = ge4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                tc3 tc3Var2 = new tc3();
                tc3Var2.k(17L);
                tc3Var2.i(2900L);
                tc3Var2.d("unknown error.");
                this.e = tc3Var2;
            }
            tc3 tc3Var3 = this.e;
            tc3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.baidu.tieba.t84
    public p84<z94> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (p84) invokeV.objValue;
    }
}
