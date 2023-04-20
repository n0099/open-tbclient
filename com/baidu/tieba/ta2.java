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
public abstract class ta2 extends za2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public dl4 d;
    public oj3 e;
    public final mf4<wg4> f;

    public abstract void Q(@NonNull oj3 oj3Var);

    public abstract void R();

    /* loaded from: classes6.dex */
    public class a extends ab2<ta2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ta2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ta2 ta2Var, ta2 ta2Var2) {
            super(ta2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ta2Var, ta2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((za2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ta2Var;
        }

        @Override // com.baidu.tieba.ab2
        public void u(wg4 wg4Var, oj3 oj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wg4Var, oj3Var) == null) {
                v42.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + wg4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + oj3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = oj3Var;
            }
        }

        @Override // com.baidu.tieba.ab2
        public void r(@NonNull wg4 wg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wg4Var) == null) {
                if (ta2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + wg4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948174404, "Lcom/baidu/tieba/ta2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948174404, "Lcom/baidu/tieba/ta2;");
                return;
            }
        }
        g = fo1.a;
    }

    public ta2() {
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

    @Override // com.baidu.tieba.qf4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            v42.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            oj3 oj3Var = new oj3();
            oj3Var.k(17L);
            oj3Var.i(2901L);
            oj3Var.d("Server无包");
            Q(oj3Var);
        }
    }

    @Override // com.baidu.tieba.qf4
    public mf4<wg4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (mf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qf4
    public void C(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pg4Var) == null) {
            super.C(pg4Var);
            v42.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + pg4Var.toString());
            oj3 oj3Var = new oj3();
            oj3Var.k(17L);
            oj3Var.c(pg4Var);
            Q(oj3Var);
        }
    }

    @Override // com.baidu.tieba.qf4
    public void G(dl4 dl4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dl4Var) == null) {
            super.G(dl4Var);
            this.d = dl4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (dl4Var == null) {
                    n = 0;
                } else {
                    n = dl4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.qf4, com.baidu.tieba.nf4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            v42.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            dl4 dl4Var = this.d;
            if (dl4Var == null) {
                oj3 oj3Var = new oj3();
                oj3Var.k(17L);
                oj3Var.i(2900L);
                oj3Var.d("unknown error.");
                Q(oj3Var);
                return;
            }
            int n = dl4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                oj3 oj3Var2 = new oj3();
                oj3Var2.k(17L);
                oj3Var2.i(2900L);
                oj3Var2.d("unknown error.");
                this.e = oj3Var2;
            }
            oj3 oj3Var3 = this.e;
            oj3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
