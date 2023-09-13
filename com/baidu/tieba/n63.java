package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class n63 extends le2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tc2<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final yi4<ik4> g;

    /* loaded from: classes7.dex */
    public class a extends me2<n63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n63 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n63 n63Var, n63 n63Var2) {
            super(n63Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n63Var, n63Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((le2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n63Var;
        }

        @Override // com.baidu.tieba.me2
        public void r(@NonNull ik4 ik4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ik4Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.baidu.tieba.me2
        public void u(ik4 ik4Var, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ik4Var, an3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public n63(String str, String str2, long j, tc2<Boolean> tc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), tc2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this, this);
        this.c = tc2Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.baidu.tieba.cj4
    public void G(po4 po4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, po4Var) == null) {
            super.G(po4Var);
        }
    }

    @Override // com.baidu.tieba.cj4
    public void C(bk4 bk4Var) {
        ik4 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bk4Var) == null) {
            super.C(bk4Var);
            if (bk4Var != null) {
                if (bk4Var.a == 1010 && (p = o63.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    ej4.i().x(p);
                }
                z63.b("fetch plugin error: " + bk4Var.toString());
            } else {
                z63.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.cj4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            z63.b("fetch plugin success");
        }
    }

    @Override // com.baidu.tieba.cj4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            z63.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.cj4
    public yi4<ik4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (yi4) invokeV.objValue;
    }
}
