package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j63 extends he2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pc2<Boolean> c;
    public String d;
    public String e;
    public long f;
    public final ui4<ek4> g;

    /* loaded from: classes6.dex */
    public class a extends ie2<j63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j63 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j63 j63Var, j63 j63Var2) {
            super(j63Var2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j63Var, j63Var2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((he2) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j63Var;
        }

        @Override // com.baidu.tieba.ie2
        public void r(@NonNull ek4 ek4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ek4Var) == null) {
                this.b.c.a(Boolean.TRUE);
            }
        }

        @Override // com.baidu.tieba.ie2
        public void u(ek4 ek4Var, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ek4Var, wm3Var) == null) {
                this.b.c.a(Boolean.FALSE);
            }
        }
    }

    public j63(String str, String str2, long j, pc2<Boolean> pc2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Long.valueOf(j), pc2Var};
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
        this.c = pc2Var;
        this.d = str;
        this.e = str2;
        this.f = j;
    }

    @Override // com.baidu.tieba.yi4
    public void G(lo4 lo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lo4Var) == null) {
            super.G(lo4Var);
        }
    }

    @Override // com.baidu.tieba.yi4
    public void C(xj4 xj4Var) {
        ek4 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xj4Var) == null) {
            super.C(xj4Var);
            if (xj4Var != null) {
                if (xj4Var.a == 1010 && (p = k63.p(this.d, this.e, this.f)) != null) {
                    p.d = p.b();
                    aj4.i().x(p);
                }
                v63.b("fetch plugin error: " + xj4Var.toString());
            } else {
                v63.b("fetch plugin error");
            }
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.yi4
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            v63.b("fetch plugin success");
        }
    }

    @Override // com.baidu.tieba.yi4
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            v63.b("no package");
            this.c.a(Boolean.FALSE);
        }
    }

    @Override // com.baidu.tieba.yi4
    public ui4<ek4> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (ui4) invokeV.objValue;
    }
}
