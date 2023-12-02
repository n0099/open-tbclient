package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q13 extends o92 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w72<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final be4<lf4> g;

    /* loaded from: classes7.dex */
    public class a extends p92<q13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q13 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q13 q13Var, q13 q13Var2) {
            super(q13Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q13Var, q13Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((o92) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = q13Var;
        }

        @Override // com.baidu.tieba.p92
        public void r(@NonNull lf4 lf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lf4Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.baidu.tieba.p92
        public void u(lf4 lf4Var, di3 di3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lf4Var, di3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public q13(String str, String str2, long j, w72<Boolean> w72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), w72Var};
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
        this.c = w72Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.baidu.tieba.fe4
    public void G(sj4 sj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sj4Var) == null) {
            super.G(sj4Var);
        }
    }

    @Override // com.baidu.tieba.fe4
    public void C(ef4 ef4Var) {
        lf4 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ef4Var) == null) {
            super.C(ef4Var);
            if (ef4Var != null) {
                if (ef4Var.a == 1010 && (p = r13.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    he4.i().x(p);
                }
                c23.b("fetch plugin error: " + ef4Var.toString());
            } else {
                c23.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.fe4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            c23.b("fetch plugin success");
        }
    }

    @Override // com.baidu.tieba.fe4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            c23.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.fe4
    public be4<lf4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (be4) invokeV.objValue;
    }
}
