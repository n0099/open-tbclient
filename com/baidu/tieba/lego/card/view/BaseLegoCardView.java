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
import com.baidu.tieba.dr7;
import com.baidu.tieba.hq7;
import com.baidu.tieba.hw8;
import com.baidu.tieba.l86;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.s86;
import com.baidu.tieba.vq7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements dr7<T> {
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
    public hq7 k;
    public boolean l;

    @Override // com.baidu.tieba.dr7
    public void c(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
        }
    }

    @Override // com.baidu.tieba.dr7
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dr7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dr7
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dr7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public abstract View q();

    @Override // com.baidu.tieba.dr7
    public final void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.dr7
    public void setMulDel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    public abstract void t(T t, int i);

    public abstract void u(T t);

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

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
            if (i != -1 && i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            this.h.setVisibility(8);
                            return;
                        }
                        this.h.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0);
                        this.h.setVisibility(0);
                        return;
                    }
                    this.h.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0, 0, 0);
                    this.h.setVisibility(0);
                    return;
                }
                this.h.setPadding(0, 0, 0, 0);
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public final void i(T t) {
        int i;
        int showLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            View view2 = this.e;
            if (t.isShowCover()) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
            int showSpace = t.getShowSpace();
            if (showSpace != 0) {
                showLine = -1;
            } else {
                showLine = t.getShowLine();
            }
            B(showLine);
            if (showSpace != 0) {
                if (showSpace != 1) {
                    if (showSpace != 2) {
                        if (showSpace == 3) {
                            this.f.setVisibility(0);
                            this.g.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    this.f.setVisibility(0);
                    this.g.setVisibility(8);
                    return;
                }
                this.f.setVisibility(8);
                this.g.setVisibility(0);
                return;
            }
            this.f.setVisibility(8);
            this.g.setVisibility(8);
        }
    }

    public final void s(T t) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, t) == null) && t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            StatisticItem statisticItem = new StatisticItem(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    statisticItem.param(split[0], split[1]);
                }
            }
            statisticItem.param("obj_locate", getStatPosition());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, l86.e());
            s86.b().a(statisticItem);
        }
    }

    public final int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public final int getStatPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c + 1;
        }
        return invokeV.intValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.h, R.color.CAM_X0204);
            int i = this.b;
            if (i != 1) {
                if (i != 2 && i != 3) {
                    this.f.setBackgroundColor(getResources().getColor(17170445));
                    this.g.setBackgroundColor(getResources().getColor(17170445));
                    return;
                }
                SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
                return;
            }
            this.f.setBackgroundColor(getResources().getColor(17170445));
            this.g.setBackgroundColor(getResources().getColor(17170445));
        }
    }

    public final SpannableString k(String str, List<String> list, int i, int i2) {
        InterceptResult invokeLLII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048587, this, str, list, i, i2)) == null) {
            if (!TextUtils.isEmpty(str) && !ListUtils.isEmpty(list)) {
                int indexOf = str.indexOf("{%s}", 0);
                if (indexOf >= 0) {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    int i4 = 0;
                    int i5 = 0;
                    while (indexOf >= 0) {
                        sb.append(str.substring(i4, indexOf));
                        if (i5 < list.size()) {
                            arrayList.add(Integer.valueOf(sb.length()));
                            sb.append(list.get(i5));
                            int i6 = indexOf + 4;
                            i4 = i6;
                            indexOf = str.indexOf("{%s}", i6);
                            i5++;
                        } else {
                            indexOf = -1;
                        }
                    }
                    if (i4 < str.length()) {
                        sb.append(str.substring(i4));
                    }
                    SpannableString spannableString = new SpannableString(sb.toString());
                    for (int i7 = 0; i7 < arrayList.size(); i7++) {
                        int intValue = ((Integer) arrayList.get(i7)).intValue();
                        int length = list.get(i7).length() + intValue;
                        if (r()) {
                            i3 = i2;
                        } else {
                            i3 = i;
                        }
                        spannableString.setSpan(new ForegroundColorSpan(i3), intValue, length, 33);
                    }
                    return spannableString;
                }
                return null;
            }
            return null;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public final <S> S l(View view2, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, view2, i)) == null) {
            return (S) view2.findViewById(i);
        }
        return (S) invokeLI.objValue;
    }

    public final void m(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
            s86.b().d(true);
            v(t);
        }
    }

    @Override // com.baidu.tieba.dr7
    public final void setAfterClickSchemeListener(hq7 hq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hq7Var) == null) {
            this.k = hq7Var;
        }
    }

    @Override // com.baidu.tieba.dr7
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

    @Override // com.baidu.tieba.dr7
    public final void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.c = i;
        }
    }

    public void v(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, t) == null) {
            int c = hw8.c(this.i, t.getScheme());
            hq7 hq7Var = this.k;
            if (hq7Var != null) {
                hq7Var.a(c, null);
            }
        }
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
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
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
                    } else {
                        SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                        addView(this.f, layoutParams3);
                        addView(frameLayout, layoutParams);
                        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
                        addView(this.h, layoutParams2);
                        SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
                        addView(this.g, layoutParams3);
                        return;
                    }
                } else {
                    SkinManager.setBackgroundColor(this.f, R.color.CAM_X0204);
                    addView(this.f, layoutParams3);
                    addView(this.h, layoutParams2);
                    addView(frameLayout, layoutParams);
                    SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
                    addView(this.g, layoutParams3);
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.dr7
    public final void update(Object obj) {
        ICardInfo iCardInfo;
        ICardInfo updateCard;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, obj) != null) || (iCardInfo = (ICardInfo) obj) == null || (updateCard = iCardInfo.getUpdateCard()) == null) {
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

    public final void x(View view2, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048608, this, view2, i, i2, i3) == null) {
            if (!vq7.a(i) && !vq7.a(i2)) {
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
            if (!vq7.a(i) && !vq7.a(i2)) {
                if (r()) {
                    i = i2;
                }
                textView.setTextColor(i);
                return;
            }
            SkinManager.setViewTextColor(textView, i3);
        }
    }
}
