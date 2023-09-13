package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.itemtab.card.CardItemDetailListItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class yq7 extends ax<fr7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public EMTextView g;
    public ArrayList<kr7> h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yq7(Context context) {
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

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f == null) {
                View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01cd, (ViewGroup) null, true);
                this.f = inflate;
                this.g = (EMTextView) inflate.findViewById(R.id.obfuscated_res_0x7f0911b4);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            EMManager.from(this.f).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
            EMManager.from(this.g).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            for (int i2 = 0; i2 < ((ViewGroup) this.f).getChildCount(); i2++) {
                if (((ViewGroup) this.f).getChildAt(i2) instanceof CardItemDetailListItemLayout) {
                    ((CardItemDetailListItemLayout) ((ViewGroup) this.f).getChildAt(i2)).d();
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: s */
    public void onBindDataToView(fr7 fr7Var) {
        boolean z;
        View childAt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, fr7Var) == null) && fr7Var != null && fr7Var.d()) {
            ArrayList<kr7> c = fr7Var.c();
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
