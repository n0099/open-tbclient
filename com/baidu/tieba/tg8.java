package com.baidu.tieba;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tg8 extends qg8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public ViewStub p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tg8(TbPageContext tbPageContext, View view2) {
        super(tbPageContext, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0927f9);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((hi.j(tbPageContext.getPageActivity()) / 2) + hi.g(tbPageContext.getPageActivity(), R.dimen.tbds239)) - hi.g(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926bf);
        ViewStub viewStub2 = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0927f6);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923d7);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918d6);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923d8);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09016e);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923d9);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c21);
    }

    @Override // com.baidu.tieba.qg8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            n15 d = n15.d(this.q);
            d.w(R.color.CAM_X0105);
            d.A(R.dimen.T_X03);
            d.B(R.string.F_X02);
            n15 d2 = n15.d(this.r);
            d2.w(R.color.CAM_X0108);
            d2.A(R.dimen.tbds29);
            d2.B(R.string.F_X01);
            n15 d3 = n15.d(this.t);
            d3.w(R.color.CAM_X0108);
            d3.A(R.dimen.tbds29);
            d3.B(R.string.F_X01);
            n15 d4 = n15.d(this.v);
            d4.w(R.color.CAM_X0108);
            d4.A(R.dimen.tbds29);
            d4.B(R.string.F_X01);
            n15 d5 = n15.d(this.s);
            d5.w(R.color.CAM_X0302);
            d5.A(R.dimen.tbds29);
            d5.B(R.string.F_X01);
            n15 d6 = n15.d(this.u);
            d6.w(R.color.CAM_X0302);
            d6.A(R.dimen.tbds29);
            d6.B(R.string.F_X01);
            n15 d7 = n15.d(this.w);
            d7.w(R.color.CAM_X0302);
            d7.A(R.dimen.tbds29);
            d7.B(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.qg8
    public void c(rg8 rg8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rg8Var) != null) || rg8Var == null) {
            return;
        }
        this.q.setText(rg8Var.a);
        f(rg8Var.a());
    }

    @Override // com.baidu.tieba.qg8
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            super.d(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.u.setOnClickListener(onClickListener);
            this.w.setOnClickListener(onClickListener);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.s.setText(R.string.obfuscated_res_0x7f0f0dce);
                        return;
                    }
                    return;
                }
                this.s.setText(R.string.obfuscated_res_0x7f0f0dcd);
                return;
            }
            this.s.setText(R.string.obfuscated_res_0x7f0f0dcc);
        }
    }
}
