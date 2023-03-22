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
public abstract class ra2 extends xa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicInteger c;
    public bl4 d;
    public mj3 e;
    public final kf4<ug4> f;

    public abstract void Q(@NonNull mj3 mj3Var);

    public abstract void R();

    /* loaded from: classes6.dex */
    public class a extends ya2<ra2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ra2 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ra2 ra2Var, ra2 ra2Var2) {
            super(ra2Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ra2Var, ra2Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((xa2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ra2Var;
        }

        @Override // com.baidu.tieba.ya2
        public void u(ug4 ug4Var, mj3 mj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ug4Var, mj3Var) == null) {
                t42.k("SwanAppDependentPkgDownloadCallback", "onDownloadOrUnzipFail:" + ug4Var + StringUtil.ARRAY_ELEMENT_SEPARATOR + mj3Var);
                if (this.b.e != null) {
                    return;
                }
                this.b.e = mj3Var;
            }
        }

        @Override // com.baidu.tieba.ya2
        public void r(@NonNull ug4 ug4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ug4Var) == null) {
                if (ra2.g) {
                    Log.v("SwanAppDependentPkgDownloadCallback", "onDownloadAndUnzipSuccess:" + ug4Var);
                }
                this.b.c.incrementAndGet();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948114822, "Lcom/baidu/tieba/ra2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948114822, "Lcom/baidu/tieba/ra2;");
                return;
            }
        }
        g = do1.a;
    }

    public ra2() {
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

    @Override // com.baidu.tieba.of4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            t42.k("SwanAppDependentPkgDownloadCallback", "onNoPackage");
            mj3 mj3Var = new mj3();
            mj3Var.k(17L);
            mj3Var.i(2901L);
            mj3Var.d("Server无包");
            Q(mj3Var);
        }
    }

    @Override // com.baidu.tieba.of4
    public kf4<ug4> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (kf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.of4
    public void C(ng4 ng4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ng4Var) == null) {
            super.C(ng4Var);
            t42.k("SwanAppDependentPkgDownloadCallback", "onFetchError: " + ng4Var.toString());
            mj3 mj3Var = new mj3();
            mj3Var.k(17L);
            mj3Var.c(ng4Var);
            Q(mj3Var);
        }
    }

    @Override // com.baidu.tieba.of4
    public void G(bl4 bl4Var) {
        int n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bl4Var) == null) {
            super.G(bl4Var);
            this.d = bl4Var;
            if (g) {
                StringBuilder sb = new StringBuilder();
                sb.append("mStartDownload=");
                if (bl4Var == null) {
                    n = 0;
                } else {
                    n = bl4Var.n();
                }
                sb.append(n);
                Log.e("SwanAppDependentPkgDownloadCallback", sb.toString());
            }
        }
    }

    @Override // com.baidu.tieba.of4, com.baidu.tieba.lf4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            t42.k("SwanAppDependentPkgDownloadCallback", "onTotalPkgDownloadFinish");
            bl4 bl4Var = this.d;
            if (bl4Var == null) {
                mj3 mj3Var = new mj3();
                mj3Var.k(17L);
                mj3Var.i(2900L);
                mj3Var.d("unknown error.");
                Q(mj3Var);
                return;
            }
            int n = bl4Var.n() - this.c.get();
            if (n == 0) {
                R();
                return;
            }
            if (this.e == null) {
                mj3 mj3Var2 = new mj3();
                mj3Var2.k(17L);
                mj3Var2.i(2900L);
                mj3Var2.d("unknown error.");
                this.e = mj3Var2;
            }
            mj3 mj3Var3 = this.e;
            mj3Var3.f("failCount:" + n);
            Q(this.e);
        }
    }
}
