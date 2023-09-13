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
/* loaded from: classes7.dex */
public class mg9 extends jg9 {
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
    public mg9(TbPageContext tbPageContext, View view2) {
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
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0929d8);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((BdUtilHelper.getEquipmentHeight(tbPageContext.getPageActivity()) / 2) + BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds239)) - BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09289d);
        ViewStub viewStub2 = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0929d5);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a8);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a1f);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925a9);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090177);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925aa);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d85);
    }

    @Override // com.baidu.tieba.jg9
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

    @Override // com.baidu.tieba.jg9
    public void c(kg9 kg9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg9Var) != null) || kg9Var == null) {
            return;
        }
        this.q.setText(kg9Var.a);
        f(kg9Var.a());
    }

    @Override // com.baidu.tieba.jg9
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
                        this.s.setText(R.string.obfuscated_res_0x7f0f0efb);
                        return;
                    }
                    return;
                }
                this.s.setText(R.string.obfuscated_res_0x7f0f0efa);
                return;
            }
            this.s.setText(R.string.obfuscated_res_0x7f0f0ef9);
        }
    }
}
