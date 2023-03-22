package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class mt9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ch6 b;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mt9 a;

        public a(mt9 mt9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mt9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mt9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    public mt9(TbPageContext tbPageContext) {
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
        ch6 ch6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ch6Var = this.b) != null) {
            ch6Var.d();
        }
    }

    public void b(View view2) {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && (tbPageContext = this.a) != null && view2 != null) {
            if (this.b == null) {
                ch6 ch6Var = new ch6(tbPageContext, view2);
                this.b = ch6Var;
                ch6Var.C(R.drawable.pic_sign_tip_down);
                this.b.o(1);
                this.b.k(32);
                this.b.h(2);
                this.b.r(false);
                this.b.i(new a(this));
                int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070231);
                int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
                int dimensionPixelSize3 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds44);
                int dimensionPixelSize4 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds50);
                int dimensionPixelSize5 = this.a.getResources().getDimensionPixelSize(R.dimen.tbds6);
                this.b.v(dimensionPixelSize3, dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2);
                this.b.H(-dimensionPixelSize4);
                this.b.I(-dimensionPixelSize5);
                this.b.j(3000);
            }
            String string = this.a.getResources().getString(R.string.write_activity_tip_content);
            this.b.u(R.drawable.icon_pure_guide_haowu16);
            this.b.n(true);
            this.b.K(string, "commodity_tip_show_controller");
        }
    }
}
