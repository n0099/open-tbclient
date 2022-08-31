package com.baidu.tieba.lego.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.a06;
import com.baidu.tieba.gk8;
import com.baidu.tieba.hf7;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.pf7;
import com.baidu.tieba.sz5;
import com.baidu.tieba.te7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements pf7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public int c;
    public View d;
    public View e;
    public View f;
    public View g;
    public ImageView h;
    public TbPageContext i;
    public int j;
    public te7 k;
    public boolean l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.j = 3;
        this.l = true;
        this.i = tbPageContext;
        setOrientation(1);
    }

    public final void A(TextView textView, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{textView, Boolean.valueOf(z), str, str2}) == null) {
            if (z) {
                textView.setEnabled(false);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
                textView.setText(str2);
                textView.setBackgroundDrawable(null);
                textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                textView.setPadding(0, 0, 0, 0);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
            textView.setText(str);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
            textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setEnabled(true);
            textView.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07025f), 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230), 0);
        }
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == -1 || i == 0) {
                this.h.setVisibility(8);
            } else if (i == 1) {
                this.h.setPadding(0, 0, 0, 0);
                this.h.setVisibility(0);
            } else if (i == 2) {
                this.h.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0, 0, 0);
                this.h.setVisibility(0);
            } else if (i != 3) {
                this.h.setVisibility(8);
            } else {
                this.h.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0);
                this.h.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.pf7
    public void c(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
        }
    }

    @Override // com.baidu.tieba.pf7
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pf7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pf7
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : invokeV.intValue;
    }

    public final int getStatPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.c + 1 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.pf7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            this.e.setVisibility(t.isShowCover() ? 0 : 8);
            int showSpace = t.getShowSpace();
            B(showSpace != 0 ? -1 : t.getShowLine());
            if (showSpace == 0) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
            } else if (showSpace == 1) {
                this.f.setVisibility(8);
                this.g.setVisibility(0);
            } else if (showSpace == 2) {
                this.f.setVisibility(0);
                this.g.setVisibility(8);
            } else if (showSpace != 3) {
            } else {
                this.f.setVisibility(0);
                this.g.setVisibility(0);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.h, R.color.CAM_X0204);
            int i = this.b;
            if (i == 1) {
                this.f.setBackgroundColor(getResources().getColor(17170445));
                this.g.setBackgroundColor(getResources().getColor(17170445));
            } else if (i != 2 && i != 3) {
                this.f.setBackgroundColor(getResources().getColor(17170445));
                this.g.setBackgroundColor(getResources().getColor(17170445));
            } else {
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            }
        }
    }

    public final SpannableString k(String str, List<String> list, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, str, list, i, i2)) == null) {
            if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
                return null;
            }
            int indexOf = str.indexOf("{%s}", 0);
            if (indexOf >= 0) {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                int i3 = 0;
                int i4 = 0;
                while (indexOf >= 0) {
                    sb.append(str.substring(i3, indexOf));
                    if (i4 < list.size()) {
                        arrayList.add(Integer.valueOf(sb.length()));
                        sb.append(list.get(i4));
                        int i5 = indexOf + 4;
                        i3 = i5;
                        indexOf = str.indexOf("{%s}", i5);
                        i4++;
                    } else {
                        indexOf = -1;
                    }
                }
                if (i3 < str.length()) {
                    sb.append(str.substring(i3));
                }
                SpannableString spannableString = new SpannableString(sb.toString());
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    int intValue = ((Integer) arrayList.get(i6)).intValue();
                    spannableString.setSpan(new ForegroundColorSpan(r() ? i2 : i), intValue, list.get(i6).length() + intValue, 33);
                }
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public final <S> S l(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, view2, i)) == null) ? (S) view2.findViewById(i) : (S) invokeLI.objValue;
    }

    public final void m(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
            a06.b().d(true);
            v(t);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            p();
            w();
            this.l = false;
        }
    }

    public final ViewGroup.LayoutParams o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new ViewGroup.LayoutParams(-1, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (this.b == 4) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
            }
            View q = q();
            this.d = q;
            frameLayout.addView(q, o());
            View view2 = new View(getContext());
            this.e = view2;
            SkinManager.setBackgroundColor(view2, R.color.common_color_10205);
            frameLayout.addView(this.e, new ViewGroup.LayoutParams(-1, -1));
            this.h = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.h, R.color.CAM_X0204);
            this.f = new View(getContext());
            this.g = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            int i = this.b;
            if (i != 1) {
                if (i == 2) {
                    SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                    addView(this.f, layoutParams3);
                    addView(this.h, layoutParams2);
                    addView(frameLayout, layoutParams);
                    SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
                    addView(this.g, layoutParams3);
                    return;
                } else if (i == 3) {
                    SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                    addView(this.f, layoutParams3);
                    addView(frameLayout, layoutParams);
                    layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
                    addView(this.h, layoutParams2);
                    SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
                    addView(this.g, layoutParams3);
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        this.f.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.f, layoutParams3);
                        layoutParams2.bottomMargin = 0;
                        addView(frameLayout, layoutParams);
                        addView(this.h, layoutParams2);
                        this.g.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.g, layoutParams3);
                        return;
                    }
                    addView(frameLayout, layoutParams);
                    return;
                }
            }
            this.f.setBackgroundColor(getResources().getColor(17170445));
            addView(this.f, layoutParams3);
            layoutParams2.bottomMargin = 0;
            addView(this.h, layoutParams2);
            addView(frameLayout, layoutParams);
            this.g.setBackgroundColor(getResources().getColor(17170445));
            addView(this.g, layoutParams3);
        }
    }

    public abstract View q();

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? 1 == TbadkCoreApplication.getInst().getSkinType() : invokeV.booleanValue;
    }

    public final void s(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, t) == null) || t == null || TextUtils.isEmpty(t.getShowKey()) || TextUtils.isEmpty(t.getShowExtra())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(t.getShowKey());
        for (String str : t.getShowExtra().split("&")) {
            String[] split = str.split("=");
            if (split.length == 2) {
                statisticItem.param(split[0], split[1]);
            }
        }
        statisticItem.param("obj_locate", getStatPosition());
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, sz5.e());
        a06.b().a(statisticItem);
    }

    @Override // com.baidu.tieba.pf7
    public final void setAfterClickSchemeListener(te7 te7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, te7Var) == null) {
            this.k = te7Var;
        }
    }

    @Override // com.baidu.tieba.pf7
    public final void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.b = i;
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            setOnLongClickListener(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.pf7
    public final void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.pf7
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.pf7
    public final void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.c = i;
        }
    }

    public abstract void t(T t, int i);

    public abstract void u(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.pf7
    public final void update(Object obj) {
        ICardInfo iCardInfo;
        ICardInfo updateCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, obj) == null) || (iCardInfo = (ICardInfo) obj) == null || (updateCard = iCardInfo.getUpdateCard()) == null) {
            return;
        }
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) updateCard;
        s(baseLegoCardInfo);
        if (this.l) {
            n();
        }
        if (this.j != TbadkCoreApplication.getInst().getSkinType()) {
            this.j = TbadkCoreApplication.getInst().getSkinType();
            j();
            t(baseLegoCardInfo, this.j);
        }
        z();
        u(baseLegoCardInfo);
        i(baseLegoCardInfo);
    }

    public void v(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, t) == null) {
            int c = gk8.c(this.i, t.getScheme());
            te7 te7Var = this.k;
            if (te7Var != null) {
                te7Var.a(c, null);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    public final void x(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048608, this, view2, i, i2, i3) == null) {
            if (!hf7.a(i) && !hf7.a(i2)) {
                if (r()) {
                    i = i2;
                }
                view2.setBackgroundColor(i);
                return;
            }
            SkinManager.setBackgroundColor(view2, i3);
        }
    }

    public final void y(TextView textView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048609, this, textView, i, i2, i3) == null) {
            if (!hf7.a(i) && !hf7.a(i2)) {
                if (r()) {
                    i = i2;
                }
                textView.setTextColor(i);
                return;
            }
            SkinManager.setViewTextColor(textView, i3);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.d.setVisibility(0);
        }
    }
}
