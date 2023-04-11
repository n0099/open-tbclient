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
/* loaded from: classes5.dex */
public class kr8 extends hr8 {
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
    public kr8(TbPageContext tbPageContext, View view2) {
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
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0927e7);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((ii.j(tbPageContext.getPageActivity()) / 2) + ii.g(tbPageContext.getPageActivity(), R.dimen.tbds239)) - ii.g(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926b4);
        ViewStub viewStub2 = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0927e4);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923cb);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918d9);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923cc);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09016c);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923cd);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091c10);
    }

    @Override // com.baidu.tieba.hr8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            q25 d = q25.d(this.q);
            d.w(R.color.CAM_X0105);
            d.B(R.dimen.T_X03);
            d.C(R.string.F_X02);
            q25 d2 = q25.d(this.r);
            d2.w(R.color.CAM_X0108);
            d2.B(R.dimen.tbds29);
            d2.C(R.string.F_X01);
            q25 d3 = q25.d(this.t);
            d3.w(R.color.CAM_X0108);
            d3.B(R.dimen.tbds29);
            d3.C(R.string.F_X01);
            q25 d4 = q25.d(this.v);
            d4.w(R.color.CAM_X0108);
            d4.B(R.dimen.tbds29);
            d4.C(R.string.F_X01);
            q25 d5 = q25.d(this.s);
            d5.w(R.color.CAM_X0302);
            d5.B(R.dimen.tbds29);
            d5.C(R.string.F_X01);
            q25 d6 = q25.d(this.u);
            d6.w(R.color.CAM_X0302);
            d6.B(R.dimen.tbds29);
            d6.C(R.string.F_X01);
            q25 d7 = q25.d(this.w);
            d7.w(R.color.CAM_X0302);
            d7.B(R.dimen.tbds29);
            d7.C(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.hr8
    public void c(ir8 ir8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ir8Var) != null) || ir8Var == null) {
            return;
        }
        this.q.setText(ir8Var.a);
        f(ir8Var.a());
    }

    @Override // com.baidu.tieba.hr8
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
                        this.s.setText(R.string.obfuscated_res_0x7f0f0dc8);
                        return;
                    }
                    return;
                }
                this.s.setText(R.string.obfuscated_res_0x7f0f0dc7);
                return;
            }
            this.s.setText(R.string.obfuscated_res_0x7f0f0dc6);
        }
    }
}
