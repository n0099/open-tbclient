package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class sj6 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public View l;
    public RelativeLayout m;
    public ConstrainImageGroup n;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d02f3 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sj6(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View k = k();
        this.i = (TbImageView) k.findViewById(R.id.obfuscated_res_0x7f0900e1);
        this.j = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0900f9);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f09009f);
        this.n = (ConstrainImageGroup) k.findViewById(R.id.obfuscated_res_0x7f0900b2);
        this.l = k.findViewById(R.id.obfuscated_res_0x7f090f90);
        this.m = (RelativeLayout) k.findViewById(R.id.obfuscated_res_0x7f090aee);
        k.setOnClickListener(this);
    }

    public void s(vg vgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, vgVar) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setImageViewPool(vgVar);
        }
    }

    public void t(vg vgVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, vgVar) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setConstrainLayoutPool(vgVar);
        }
    }

    public void u(double d) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d)}) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setSingleImageRatio(d);
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) && this.a != i) {
            this.a = i;
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.m, R.drawable.ad_list_item_bg);
            this.n.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: r */
    public void l(tj6 tj6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tj6Var) != null) || tj6Var == null) {
            return;
        }
        this.i.setPlaceHolder(1);
        this.i.L(tj6Var.h(), 10, false);
        this.i.setRadius(fj.f(getContext(), R.dimen.tbds26));
        this.i.setDrawerType(1);
        this.i.setDrawBorder(true);
        this.i.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.i.setBorderWidth(fj.f(getContext(), R.dimen.tbds1));
        this.i.setDefaultResource(R.drawable.obfuscated_res_0x7f081252);
        this.i.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081252);
        this.j.setText(tj6Var.f());
        this.k.setText(tj6Var.c());
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.m, R.drawable.ad_list_item_bg);
        if (ListUtils.getCount(tj6Var.n()) > 0) {
            mk5 mk5Var = new mk5(3);
            mk5Var.d(1.0d);
            this.n.setVisibility(0);
            this.n.setFromCDN(true);
            this.n.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.n.setImageProcessor(mk5Var);
            this.n.setImageMediaList(tj6Var.n());
            if (!tj6Var.l()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, fj.f(getContext(), R.dimen.tbds16));
                layoutParams.addRule(12);
                this.l.setLayoutParams(layoutParams);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
                this.l.setVisibility(0);
                return;
            }
            this.l.setVisibility(8);
            return;
        }
        this.n.setVisibility(8);
        if (!tj6Var.l()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, fj.f(getContext(), R.dimen.tbds1));
            layoutParams2.addRule(12);
            this.l.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }
}
