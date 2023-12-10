package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class su7 extends nl6<tu7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView i;
    public TextView j;
    public TextView k;
    public View l;
    public RelativeLayout m;
    public ConstrainImageGroup n;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0363 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public su7(TbPageContext<?> tbPageContext) {
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
        View i3 = i();
        this.i = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f09010f);
        this.j = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090127);
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0900bf);
        this.n = (ConstrainImageGroup) i3.findViewById(R.id.obfuscated_res_0x7f0900d7);
        this.l = i3.findViewById(R.id.item_divider);
        this.m = (RelativeLayout) i3.findViewById(R.id.obfuscated_res_0x7f090cb5);
        i3.setOnClickListener(this);
    }

    public void r(pb<TbImageView> pbVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, pbVar) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setImageViewPool(pbVar);
        }
    }

    public void s(pb<ConstrainImageLayout> pbVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, pbVar) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setConstrainLayoutPool(pbVar);
        }
    }

    public void y(double d) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d)}) == null) && (constrainImageGroup = this.n) != null) {
            constrainImageGroup.setSingleImageRatio(d);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
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
    @Override // com.baidu.tieba.nl6
    /* renamed from: p */
    public void j(tu7 tu7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tu7Var) != null) || tu7Var == null) {
            return;
        }
        this.i.setPlaceHolder(1);
        this.i.startLoad(tu7Var.e(), 10, false);
        this.i.setRadius(BdUtilHelper.getDimens(c(), R.dimen.tbds26));
        this.i.setDrawerType(1);
        this.i.setDrawBorder(true);
        this.i.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.i.setBorderWidth(BdUtilHelper.getDimens(c(), R.dimen.tbds1));
        this.i.setDefaultResource(R.drawable.transparent_bg);
        this.i.setDefaultBgResource(R.drawable.transparent_bg);
        this.j.setText(tu7Var.d());
        this.k.setText(tu7Var.c());
        SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.m, R.drawable.ad_list_item_bg);
        if (ListUtils.getCount(tu7Var.h()) > 0) {
            ox5 ox5Var = new ox5(3);
            ox5Var.d(1.0d);
            this.n.setVisibility(0);
            this.n.setFromCDN(true);
            this.n.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.n.setImageProcessor(ox5Var);
            this.n.setImageMediaList(tu7Var.h());
            if (!tu7Var.g()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(c(), R.dimen.tbds16));
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
        if (!tu7Var.g()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BdUtilHelper.getDimens(c(), R.dimen.tbds1));
            layoutParams2.addRule(12);
            this.l.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            this.l.setVisibility(0);
            return;
        }
        this.l.setVisibility(8);
    }
}
