package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.jl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class zh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jl5 a;
    public ph5 b;
    public TbPageContext c;

    /* loaded from: classes6.dex */
    public class a implements jl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zh5 a;

        public a(zh5 zh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zh5Var;
        }

        @Override // com.baidu.tieba.jl5.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                String JsonArrayToString = StringHelper.JsonArrayToString(jSONArray);
                if (this.a.b != null) {
                    this.a.b.g(JsonArrayToString);
                    this.a.b.e();
                }
            }
        }
    }

    public zh5(TbPageContext tbPageContext, ph5 ph5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ph5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = ph5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            jl5 jl5Var = this.a;
            if (jl5Var != null) {
                jl5Var.u();
                this.a.v();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        ph5 ph5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (ph5Var = this.b) == null || ph5Var.b() == null || this.c == null) {
            return;
        }
        il5 il5Var = new il5(this.b.b().f(), this.b.b().e(), this.b.b().d());
        il5Var.i(this.b.b().b(), this.b.b().c());
        il5Var.h(this.b.b().a());
        il5Var.j(this.b.b().j());
        UserData i2 = this.b.b().i();
        TbPageContext tbPageContext = this.c;
        this.a = new jl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), il5Var, i2);
        eq4 eq4Var = new eq4();
        eq4Var.j(this.b.b().h());
        this.a.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3), this.c.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.a.D(eq4Var);
        this.a.F(new a(this));
        this.a.G((i == 2 || i == 1) ? "5" : i == 3 ? "6" : "0");
    }
}
