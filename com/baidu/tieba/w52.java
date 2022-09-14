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
public abstract class w52 extends c62 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public gg4 d;
    public re3 e;
    public final pa4<zb4> f;

    /* loaded from: classes6.dex */
    public class a extends d62<w52> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w52 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w52 w52Var, w52 w52Var2) {
            super(w52Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w52Var, w52Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((c62) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = w52Var;
        }

        @Override // com.baidu.tieba.d62
        public void r(@NonNull zb4 zb4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zb4Var) == null) {
                if (w52.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + zb4Var);
                }
                this.b.c.incrementAndGet();
            }
        }

        @Override // com.baidu.tieba.d62
        public void u(zb4 zb4Var, re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zb4Var, re3Var) == null) {
                yz1.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + zb4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + re3Var);
                if (this.b.e == null) {
                    this.b.e = re3Var;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221493, "Lcom/baidu/tieba/w52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221493, "Lcom/baidu/tieba/w52;");
                return;
            }
        }
        g = ij1.a;
    }

    public w52() {
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

    @Override // com.baidu.tieba.ta4
    public void C(sb4 sb4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sb4Var) == null) {
            super.C(sb4Var);
            yz1.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + sb4Var.toString());
            re3 re3Var = new re3();
            re3Var.k(17L);
            re3Var.c(sb4Var);
            Q(re3Var);
        }
    }

    @Override // com.baidu.tieba.ta4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            yz1.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            re3 re3Var = new re3();
            re3Var.k(17L);
            re3Var.i(2901L);
            re3Var.d("Server无包");
            Q(re3Var);
        }
    }

    @Override // com.baidu.tieba.ta4
    public void G(gg4 gg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gg4Var) == null) {
            super.G(gg4Var);
            this.d = gg4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                sb.append(gg4Var == null ? 0 : gg4Var.n());
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    public abstract void Q(@NonNull re3 re3Var);

    public abstract void R();

    @Override // com.baidu.tieba.ta4, com.baidu.tieba.qa4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            yz1.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            gg4 gg4Var = this.d;
            if (gg4Var == null) {
                re3 re3Var = new re3();
                re3Var.k(17L);
                re3Var.i(2900L);
                re3Var.d("unknown error.");
                Q(re3Var);
                return;
            }
            int n = gg4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                re3 re3Var2 = new re3();
                re3Var2.k(17L);
                re3Var2.i(2900L);
                re3Var2.d("unknown error.");
                this.e = re3Var2;
            }
            re3 re3Var3 = this.e;
            re3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }

    @Override // com.baidu.tieba.ta4
    public pa4<zb4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f : (pa4) invokeV.objValue;
    }
}
