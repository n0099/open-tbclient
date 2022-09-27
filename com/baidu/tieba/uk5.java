package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.do5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class uk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public do5 a;
    public kk5 b;
    public TbPageContext c;

    /* loaded from: classes6.dex */
    public class a implements do5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk5 a;

        public a(uk5 uk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uk5Var;
        }

        @Override // com.baidu.tieba.do5.h
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

    public uk5(TbPageContext tbPageContext, kk5 kk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, kk5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = kk5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            do5 do5Var = this.a;
            if (do5Var != null) {
                do5Var.u();
                this.a.v();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        kk5 kk5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || (kk5Var = this.b) == null || kk5Var.b() == null || this.c == null) {
            return;
        }
        co5 co5Var = new co5(this.b.b().f(), this.b.b().e(), this.b.b().d());
        co5Var.i(this.b.b().b(), this.b.b().c());
        co5Var.h(this.b.b().a());
        co5Var.j(this.b.b().j());
        UserData i2 = this.b.b().i();
        TbPageContext tbPageContext = this.c;
        this.a = new do5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), co5Var, i2);
        vs4 vs4Var = new vs4();
        vs4Var.j(this.b.b().h());
        this.a.E(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04c4), this.c.getString(R.string.obfuscated_res_0x7f0f04c5), this.c.getString(R.string.obfuscated_res_0x7f0f04c6), this.c.getString(R.string.obfuscated_res_0x7f0f04c7), this.c.getString(R.string.obfuscated_res_0x7f0f04c8)});
        this.a.D(vs4Var);
        this.a.F(new a(this));
        this.a.G((i == 2 || i == 1) ? "5" : i == 3 ? "6" : "0");
    }
}
