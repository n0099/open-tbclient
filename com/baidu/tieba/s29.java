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
/* loaded from: classes7.dex */
public class s29 extends p29 {
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
    public s29(TbPageContext tbPageContext, View view2) {
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
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0928b9);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((wi.j(tbPageContext.getPageActivity()) / 2) + wi.g(tbPageContext.getPageActivity(), R.dimen.tbds239)) - wi.g(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092781);
        ViewStub viewStub2 = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0928b6);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092486);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09195d);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092487);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090178);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092488);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cac);
    }

    @Override // com.baidu.tieba.p29
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            p75 d = p75.d(this.q);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X03);
            d.D(R.string.F_X02);
            p75 d2 = p75.d(this.r);
            d2.x(R.color.CAM_X0108);
            d2.C(R.dimen.tbds29);
            d2.D(R.string.F_X01);
            p75 d3 = p75.d(this.t);
            d3.x(R.color.CAM_X0108);
            d3.C(R.dimen.tbds29);
            d3.D(R.string.F_X01);
            p75 d4 = p75.d(this.v);
            d4.x(R.color.CAM_X0108);
            d4.C(R.dimen.tbds29);
            d4.D(R.string.F_X01);
            p75 d5 = p75.d(this.s);
            d5.x(R.color.CAM_X0302);
            d5.C(R.dimen.tbds29);
            d5.D(R.string.F_X01);
            p75 d6 = p75.d(this.u);
            d6.x(R.color.CAM_X0302);
            d6.C(R.dimen.tbds29);
            d6.D(R.string.F_X01);
            p75 d7 = p75.d(this.w);
            d7.x(R.color.CAM_X0302);
            d7.C(R.dimen.tbds29);
            d7.D(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.p29
    public void c(q29 q29Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q29Var) != null) || q29Var == null) {
            return;
        }
        this.q.setText(q29Var.a);
        f(q29Var.a());
    }

    @Override // com.baidu.tieba.p29
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
                        this.s.setText(R.string.obfuscated_res_0x7f0f0eaa);
                        return;
                    }
                    return;
                }
                this.s.setText(R.string.obfuscated_res_0x7f0f0ea9);
                return;
            }
            this.s.setText(R.string.obfuscated_res_0x7f0f0ea8);
        }
    }
}
