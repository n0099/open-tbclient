package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.itemtab.card.CardItemDetailListItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class lq7 extends xx<sq7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public EMTextView g;
    public ArrayList<xq7> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lq7(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.xx
    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f == null) {
                View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01c2, (ViewGroup) null, true);
                this.f = inflate;
                this.g = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091187);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            d85 d = d85.d(this.f);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            d85 d2 = d85.d(this.g);
            d2.D(R.string.F_X02);
            d2.x(R.color.CAM_X0105);
            for (int i2 = 0; i2 < ((ViewGroup) this.f).getChildCount(); i2++) {
                if (((ViewGroup) this.f).getChildAt(i2) instanceof CardItemDetailListItemLayout) {
                    ((CardItemDetailListItemLayout) ((ViewGroup) this.f).getChildAt(i2)).d();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: u */
    public void b(sq7 sq7Var) {
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, sq7Var) == null) && sq7Var != null && sq7Var.d()) {
            ArrayList<xq7> c = sq7Var.c();
            if (ListUtils.getCount(c) != ListUtils.getCount(this.h)) {
                if (ListUtils.getCount(this.h) > 0) {
                    ((ViewGroup) this.f).removeViews(1, ListUtils.getCount(this.h));
                }
                z = true;
            } else {
                z = false;
            }
            if (c != null) {
                for (int i = 0; i < c.size(); i++) {
                    if (z) {
                        childAt = new CardItemDetailListItemLayout(this.b);
                        ((ViewGroup) this.f).addView(childAt, -1, -2);
                    } else {
                        childAt = ((ViewGroup) this.f).getChildAt(i + 1);
                    }
                    if (childAt instanceof CardItemDetailListItemLayout) {
                        ((CardItemDetailListItemLayout) childAt).setData(c.get(i));
                    }
                }
            }
            ViewGroup viewGroup = (ViewGroup) this.f;
            int childCount = viewGroup.getChildCount() - 1;
            while (true) {
                if (childCount <= 0) {
                    break;
                }
                if ((viewGroup.getChildAt(childCount) instanceof CardItemDetailListItemLayout) && viewGroup.getChildAt(childCount).getVisibility() == 0) {
                    ((CardItemDetailListItemLayout) viewGroup.getChildAt(childCount)).setDividerVisible(false);
                    break;
                }
                childCount--;
            }
            this.h = c;
        }
    }
}
