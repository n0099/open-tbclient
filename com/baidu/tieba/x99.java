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
/* loaded from: classes8.dex */
public class x99 extends ps5<w99, ks5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public View k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x99(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter) {
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
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092542);
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0907b2);
        this.h = textView;
        textView.setSingleLine();
        this.h.setEllipsize(TextUtils.TruncateAt.END);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09250c);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0915af);
        this.k = view2.findViewById(R.id.obfuscated_res_0x7f091502);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ss5
    /* renamed from: j */
    public void f(w99 w99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w99Var) == null) {
            super.f(w99Var);
            if (w99Var == null) {
                return;
            }
            int i = 0;
            if (this.g != null) {
                if (w99Var.i() == 49) {
                    if (StringUtils.isNull(w99Var.c())) {
                        if (StringUtils.isNull(w99Var.k())) {
                            this.g.setText(e(R.string.obfuscated_res_0x7f0f0fd6));
                        } else {
                            this.g.setText(w99Var.k());
                        }
                    } else {
                        this.g.setText(w99Var.c());
                    }
                } else if (w99Var.h() != null) {
                    if (w99Var.o()) {
                        this.g.setText(String.format("%s%s", e(R.string.obfuscated_res_0x7f0f0fd8), w99Var.h()));
                    } else {
                        this.g.setText(w99Var.h());
                    }
                }
            }
            if (this.h != null) {
                if (w99Var.i() == 49 && !TextUtils.isEmpty(w99Var.k())) {
                    this.h.setText(String.format(e(R.string.obfuscated_res_0x7f0f0fd9), w99Var.k()));
                } else if (w99Var.i() == 49) {
                    this.h.setText(String.format(e(R.string.obfuscated_res_0x7f0f0fd9), e(R.string.obfuscated_res_0x7f0f0fd6)));
                } else if (w99Var.d() != null) {
                    this.h.setText(w99Var.d());
                }
            }
            if (w99Var.i() == 49) {
                TextView textView = this.j;
                if (!w99Var.m()) {
                    i = 8;
                }
                textView.setVisibility(i);
            } else {
                this.j.setVisibility(8);
            }
            if (this.i != null) {
                String postTimeString = StringHelper.getPostTimeString(new Date(w99Var.j()));
                if (postTimeString == null) {
                    postTimeString = "";
                }
                this.i.setText(postTimeString);
            }
        }
    }

    @Override // com.baidu.tieba.vba
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
