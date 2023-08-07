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
public abstract class wd2 extends ce2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public go4 d;
    public rm3 e;
    public final pi4<zj4> f;

    public abstract void Q(@NonNull rm3 rm3Var);

    public abstract void R();

    /* loaded from: classes8.dex */
    public class a extends de2<wd2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wd2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(wd2 wd2Var, wd2 wd2Var2) {
            super(wd2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wd2Var, wd2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ce2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wd2Var;
        }

        @Override // com.baidu.tieba.de2
        public void u(zj4 zj4Var, rm3 rm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zj4Var, rm3Var) == null) {
                y72.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + zj4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + rm3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = rm3Var;
            }
        }

        @Override // com.baidu.tieba.de2
        public void r(@NonNull zj4 zj4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zj4Var) == null) {
                if (wd2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + zj4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948266660, "Lcom/baidu/tieba/wd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948266660, "Lcom/baidu/tieba/wd2;");
                return;
            }
        }
        g = ir1.a;
    }

    public wd2() {
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

    @Override // com.baidu.tieba.ti4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            y72.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            rm3 rm3Var = new rm3();
            rm3Var.k(17L);
            rm3Var.i(2901L);
            rm3Var.d("Server无包");
            Q(rm3Var);
        }
    }

    @Override // com.baidu.tieba.ti4
    public pi4<zj4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (pi4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ti4
    public void C(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sj4Var) == null) {
            super.C(sj4Var);
            y72.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + sj4Var.toString());
            rm3 rm3Var = new rm3();
            rm3Var.k(17L);
            rm3Var.c(sj4Var);
            Q(rm3Var);
        }
    }

    @Override // com.baidu.tieba.ti4
    public void G(go4 go4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, go4Var) == null) {
            super.G(go4Var);
            this.d = go4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (go4Var == null) {
                    n = 0;
                } else {
                    n = go4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.ti4, com.baidu.tieba.qi4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            y72.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            go4 go4Var = this.d;
            if (go4Var == null) {
                rm3 rm3Var = new rm3();
                rm3Var.k(17L);
                rm3Var.i(2900L);
                rm3Var.d("unknown error.");
                Q(rm3Var);
                return;
            }
            int n = go4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                rm3 rm3Var2 = new rm3();
                rm3Var2.k(17L);
                rm3Var2.i(2900L);
                rm3Var2.d("unknown error.");
                this.e = rm3Var2;
            }
            rm3 rm3Var3 = this.e;
            rm3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
