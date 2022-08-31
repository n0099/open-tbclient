package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.hl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hl5 a;
    public nh5 b;
    public TbPageContext c;

    /* loaded from: classes6.dex */
    public class a implements hl5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xh5 a;

        public a(xh5 xh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xh5Var;
        }

        @Override // com.baidu.tieba.hl5.h
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

    public xh5(TbPageContext tbPageContext, nh5 nh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nh5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = nh5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hl5 hl5Var = this.a;
            if (hl5Var != null) {
                hl5Var.u();
                this.a.v();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        nh5 nh5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (nh5Var = this.b) == null || nh5Var.b() == null || this.c == null) {
            return;
        }
        gl5 gl5Var = new gl5(this.b.b().f(), this.b.b().e(), this.b.b().d());
        gl5Var.i(this.b.b().b(), this.b.b().c());
        gl5Var.h(this.b.b().a());
        gl5Var.j(this.b.b().j());
        UserData i2 = this.b.b().i();
        TbPageContext tbPageContext = this.c;
        this.a = new hl5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), gl5Var, i2);
        dq4 dq4Var = new dq4();
        dq4Var.j(this.b.b().h());
        this.a.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c0), this.c.getString(R.string.obfuscated_res_0x7f0f04c1), this.c.getString(R.string.obfuscated_res_0x7f0f04c2), this.c.getString(R.string.obfuscated_res_0x7f0f04c3), this.c.getString(R.string.obfuscated_res_0x7f0f04c4)});
        this.a.D(dq4Var);
        this.a.F(new a(this));
        this.a.G((i == 2 || i == 1) ? "5" : i == 3 ? "6" : "0");
    }
}
