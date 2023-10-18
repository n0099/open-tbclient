package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v03 extends t82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b72<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final gd4<qe4> g;

    /* loaded from: classes8.dex */
    public class a extends u82<v03> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v03 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(v03 v03Var, v03 v03Var2) {
            super(v03Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v03Var, v03Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((t82) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v03Var;
        }

        @Override // com.baidu.tieba.u82
        public void r(@NonNull qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qe4Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.baidu.tieba.u82
        public void u(qe4 qe4Var, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe4Var, ih3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public v03(String str, String str2, long j, b72<Boolean> b72Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), b72Var};
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
        this.c = b72Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.baidu.tieba.kd4
    public void G(xi4 xi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xi4Var) == null) {
            super.G(xi4Var);
        }
    }

    @Override // com.baidu.tieba.kd4
    public void C(je4 je4Var) {
        qe4 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, je4Var) == null) {
            super.C(je4Var);
            if (je4Var != null) {
                if (je4Var.a == 1010 && (p = w03.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    md4.i().x(p);
                }
                h13.b("fetch plugin error: " + je4Var.toString());
            } else {
                h13.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.kd4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            h13.b("fetch plugin success");
        }
    }

    @Override // com.baidu.tieba.kd4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            h13.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.kd4
    public gd4<qe4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (gd4) invokeV.objValue;
    }
}
