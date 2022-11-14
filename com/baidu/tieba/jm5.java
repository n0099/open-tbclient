package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.vp5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class jm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vp5 a;
    public zl5 b;
    public TbPageContext c;

    /* loaded from: classes4.dex */
    public class a implements vp5.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jm5 a;

        public a(jm5 jm5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jm5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jm5Var;
        }

        @Override // com.baidu.tieba.vp5.i
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

    public jm5(TbPageContext tbPageContext, zl5 zl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, zl5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = zl5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            vp5 vp5Var = this.a;
            if (vp5Var != null) {
                vp5Var.w();
                this.a.x();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        zl5 zl5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (zl5Var = this.b) != null && zl5Var.b() != null && this.c != null) {
            up5 up5Var = new up5(this.b.b().f(), this.b.b().e(), this.b.b().d());
            up5Var.i(this.b.b().b(), this.b.b().c());
            up5Var.h(this.b.b().a());
            up5Var.j(this.b.b().j());
            UserData i2 = this.b.b().i();
            TbPageContext tbPageContext = this.c;
            this.a = new vp5(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), up5Var, i2);
            pt4 pt4Var = new pt4();
            pt4Var.j(this.b.b().h());
            this.a.H(new String[]{this.c.getString(R.string.obfuscated_res_0x7f0f04cf), this.c.getString(R.string.obfuscated_res_0x7f0f04d0), this.c.getString(R.string.obfuscated_res_0x7f0f04d1), this.c.getString(R.string.obfuscated_res_0x7f0f04d2), this.c.getString(R.string.obfuscated_res_0x7f0f04d3)});
            this.a.G(pt4Var);
            this.a.I(new a(this));
            if (i != 2 && i != 1) {
                if (i == 3) {
                    str = "6";
                } else {
                    str = "0";
                }
            } else {
                str = "5";
            }
            this.a.J(str);
        }
    }
}
