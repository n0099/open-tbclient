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
/* loaded from: classes6.dex */
public class os8 extends xm5<ns8, sm5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public View k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public os8(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09246f);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
        this.h = textView;
        textView.setSingleLine();
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092439);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091568);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f0914c0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.an5
    /* renamed from: j */
    public void f(ns8 ns8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ns8Var) == null) {
            super.f(ns8Var);
            if (ns8Var == null) {
                return;
            }
            int i = 0;
            if (this.g != null) {
                if (ns8Var.i() == 49) {
                    if (StringUtils.isNull(ns8Var.c())) {
                        if (StringUtils.isNull(ns8Var.k())) {
                            this.g.setText(e(R.string.obfuscated_res_0x7f0f0f65));
                        } else {
                            this.g.setText(ns8Var.k());
                        }
                    } else {
                        this.g.setText(ns8Var.c());
                    }
                } else if (ns8Var.h() != null) {
                    if (ns8Var.o()) {
                        this.g.setText(String.format("%s%s", e(R.string.obfuscated_res_0x7f0f0f67), ns8Var.h()));
                    } else {
                        this.g.setText(ns8Var.h());
                    }
                }
            }
            if (this.h != null) {
                if (ns8Var.i() == 49 && !TextUtils.isEmpty(ns8Var.k())) {
                    this.h.setText(String.format(e(R.string.obfuscated_res_0x7f0f0f68), ns8Var.k()));
                } else if (ns8Var.i() == 49) {
                    this.h.setText(String.format(e(R.string.obfuscated_res_0x7f0f0f68), e(R.string.obfuscated_res_0x7f0f0f65)));
                } else if (ns8Var.d() != null) {
                    this.h.setText(ns8Var.d());
                }
            }
            if (ns8Var.i() == 49) {
                TextView textView = this.j;
                if (!ns8Var.m()) {
                    i = 8;
                }
                textView.setVisibility(i);
            } else {
                this.j.setVisibility(8);
            }
            if (this.i != null) {
                String postTimeString = StringHelper.getPostTimeString(new Date(ns8Var.j()));
                if (postTimeString == null) {
                    postTimeString = "";
                }
                this.i.setText(postTimeString);
            }
        }
    }

    @Override // com.baidu.tieba.pq9
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
