package com.baidu.tieba;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kc9 extends hc9 {
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
    public kc9(TbPageContext tbPageContext, View view2) {
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
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f092995);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((BdUtilHelper.getEquipmentHeight(tbPageContext.getPageActivity()) / 2) + BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds239)) - BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09285e);
        ViewStub viewStub2 = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f092992);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09257e);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a34);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09257f);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090178);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092580);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d76);
    }

    @Override // com.baidu.tieba.hc9
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            EMManager.from(this.q).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X03).setTextStyle(R.string.F_X02);
            EMManager.from(this.r).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.tbds29).setTextStyle(R.string.F_X01);
            EMManager.from(this.t).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.tbds29).setTextStyle(R.string.F_X01);
            EMManager.from(this.v).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.tbds29).setTextStyle(R.string.F_X01);
            EMManager.from(this.s).setTextColor(R.color.CAM_X0302).setTextSize(R.dimen.tbds29).setTextStyle(R.string.F_X01);
            EMManager.from(this.u).setTextColor(R.color.CAM_X0302).setTextSize(R.dimen.tbds29).setTextStyle(R.string.F_X01);
            EMManager.from(this.w).setTextColor(R.color.CAM_X0302).setTextSize(R.dimen.tbds29).setTextStyle(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.hc9
    public void c(ic9 ic9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ic9Var) != null) || ic9Var == null) {
            return;
        }
        this.q.setText(ic9Var.a);
        f(ic9Var.a());
    }

    @Override // com.baidu.tieba.hc9
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
                        this.s.setText(R.string.obfuscated_res_0x7f0f0f0a);
                        return;
                    }
                    return;
                }
                this.s.setText(R.string.obfuscated_res_0x7f0f0f09);
                return;
            }
            this.s.setText(R.string.obfuscated_res_0x7f0f0f08);
        }
    }
}
