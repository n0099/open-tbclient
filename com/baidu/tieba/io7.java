package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes4.dex */
public class io7 extends k95<ho7, f95> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public View k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public io7(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = view2;
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0921c3);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906cd);
        this.h = textView;
        textView.setSingleLine();
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092192);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091394);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0912e8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n95
    /* renamed from: j */
    public void f(ho7 ho7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ho7Var) == null) {
            super.f(ho7Var);
            if (ho7Var == null) {
                return;
            }
            if (this.g != null) {
                if (ho7Var.j() == 49) {
                    if (StringUtils.isNull(ho7Var.c())) {
                        if (StringUtils.isNull(ho7Var.m())) {
                            this.g.setText(e(R.string.obfuscated_res_0x7f0f0dd6));
                        } else {
                            this.g.setText(ho7Var.m());
                        }
                    } else {
                        this.g.setText(ho7Var.c());
                    }
                } else if (ho7Var.i() != null) {
                    if (ho7Var.s()) {
                        this.g.setText(String.format("%s%s", e(R.string.obfuscated_res_0x7f0f0dd8), ho7Var.i()));
                    } else {
                        this.g.setText(ho7Var.i());
                    }
                }
            }
            if (this.h != null) {
                if (ho7Var.j() == 49 && !TextUtils.isEmpty(ho7Var.m())) {
                    this.h.setText(String.format(e(R.string.obfuscated_res_0x7f0f0dd9), ho7Var.m()));
                } else if (ho7Var.j() == 49) {
                    this.h.setText(String.format(e(R.string.obfuscated_res_0x7f0f0dd9), e(R.string.obfuscated_res_0x7f0f0dd6)));
                } else if (ho7Var.d() != null) {
                    this.h.setText(ho7Var.d());
                }
            }
            if (ho7Var.j() == 49) {
                this.j.setVisibility(ho7Var.p() ? 0 : 8);
            } else {
                this.j.setVisibility(8);
            }
            if (this.i != null) {
                String postTimeString = StringHelper.getPostTimeString(new Date(ho7Var.l()));
                if (postTimeString == null) {
                    postTimeString = "";
                }
                this.i.setText(postTimeString);
            }
        }
    }

    @Override // com.baidu.tieba.gk8
    @SuppressLint({"ResourceAsColor"})
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            SkinManager.setBackgroundResource(this.f, R.drawable.list_item_selector);
            SkinManager.setBackgroundResource(this.k, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            TBSelector.makeDrawableSelector().cornerRadius(UtilHelper.getDimenPixelSize(R.dimen.tbds6)).gradientLinear(DrawableSelector.LEFT_RIGHT, R.color.CAM_X0308, R.color.CAM_X0301).into(this.j);
            return true;
        }
        return invokeLI.booleanValue;
    }
}
