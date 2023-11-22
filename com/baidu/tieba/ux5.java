package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.d16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class ux5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d16 a;
    public kx5 b;
    public TbPageContext c;

    /* loaded from: classes8.dex */
    public class a implements d16.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux5 a;

        public a(ux5 ux5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ux5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ux5Var;
        }

        @Override // com.baidu.tieba.d16.i
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

    public ux5(TbPageContext tbPageContext, kx5 kx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, kx5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = kx5Var;
        this.c = tbPageContext;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d16 d16Var = this.a;
            if (d16Var != null) {
                d16Var.x();
                this.a.y();
                this.a = null;
            }
            this.b = null;
            this.c = null;
        }
    }

    public void c(int i) {
        kx5 kx5Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (kx5Var = this.b) != null && kx5Var.b() != null && this.c != null) {
            c16 c16Var = new c16(this.b.b().f(), this.b.b().e(), this.b.b().d());
            c16Var.i(this.b.b().b(), this.b.b().c());
            c16Var.h(this.b.b().a());
            c16Var.j(this.b.b().j());
            UserData i2 = this.b.b().i();
            TbPageContext tbPageContext = this.c;
            this.a = new d16(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), c16Var, i2);
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(this.b.b().h());
            this.a.I(new String[]{this.c.getString(R.string.delete_thread_reason_1), this.c.getString(R.string.delete_thread_reason_2), this.c.getString(R.string.delete_thread_reason_3), this.c.getString(R.string.delete_thread_reason_4), this.c.getString(R.string.delete_thread_reason_5)});
            this.a.H(negativeFeedBackData);
            this.a.J(new a(this));
            if (i != 2 && i != 1) {
                if (i == 3) {
                    str = "6";
                } else {
                    str = "0";
                }
            } else {
                str = "5";
            }
            this.a.K(str);
        }
    }
}
