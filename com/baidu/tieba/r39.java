package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class r39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public e46 b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r39 a;

        public a(r39 r39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    public r39(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    public void a() {
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (e46Var = this.b) != null) {
            e46Var.h();
        }
    }

    public void b(View view2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (tbPageContext = this.a) != null && view2 != null) {
            if (this.b == null) {
                e46 e46Var = new e46(tbPageContext, view2);
                this.b = e46Var;
                e46Var.L(R.drawable.pic_sign_tip_down);
                this.b.v(1);
                this.b.o(32);
                this.b.l(2);
                this.b.y(false);
                this.b.m(new a(this));
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds44);
                int dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds50);
                int dimensionPixelSize5 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds6);
                this.b.E(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.b.P(-dimensionPixelSize4);
                this.b.Q(-dimensionPixelSize5);
                this.b.n(3000);
            }
            String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1600);
            this.b.D(R.drawable.obfuscated_res_0x7f08095e);
            this.b.u(true);
            this.b.S(string, "commodity_tip_show_controller");
        }
    }
}
