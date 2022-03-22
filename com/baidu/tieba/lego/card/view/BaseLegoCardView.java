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
import c.a.p0.a4.x;
import c.a.p0.b2.o.a;
import c.a.p0.b2.o.c;
import c.a.p0.b2.o.k.b;
import c.a.p0.b2.o.l.e;
import c.a.p0.h0.m;
import c.a.p0.h0.u;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f34240b;

    /* renamed from: c  reason: collision with root package name */
    public int f34241c;

    /* renamed from: d  reason: collision with root package name */
    public View f34242d;

    /* renamed from: e  reason: collision with root package name */
    public View f34243e;

    /* renamed from: f  reason: collision with root package name */
    public View f34244f;

    /* renamed from: g  reason: collision with root package name */
    public View f34245g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f34246h;
    public TbPageContext i;
    public int j;
    public a k;
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
            textView.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070257), 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229), 0);
        }
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == -1 || i == 0) {
                this.f34246h.setVisibility(8);
            } else if (i == 1) {
                this.f34246h.setPadding(0, 0, 0, 0);
                this.f34246h.setVisibility(0);
            } else if (i == 2) {
                this.f34246h.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0, 0, 0);
                this.f34246h.setVisibility(0);
            } else if (i != 3) {
                this.f34246h.setVisibility(8);
            } else {
                this.f34246h.setPadding(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), 0);
                this.f34246h.setVisibility(0);
            }
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void b(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34240b : invokeV.intValue;
    }

    public final int getStatPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34241c + 1 : invokeV.intValue;
    }

    @Override // c.a.p0.b2.o.l.e
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void i(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, t) == null) {
            this.f34243e.setVisibility(t.isShowCover() ? 0 : 8);
            int showSpace = t.getShowSpace();
            B(showSpace != 0 ? -1 : t.getShowLine());
            if (showSpace == 0) {
                this.f34244f.setVisibility(8);
                this.f34245g.setVisibility(8);
            } else if (showSpace == 1) {
                this.f34244f.setVisibility(8);
                this.f34245g.setVisibility(0);
            } else if (showSpace == 2) {
                this.f34244f.setVisibility(0);
                this.f34245g.setVisibility(8);
            } else if (showSpace != 3) {
            } else {
                this.f34244f.setVisibility(0);
                this.f34245g.setVisibility(0);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SkinManager.setBackgroundColor(this.f34246h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f34246h, R.color.CAM_X0204);
            int i = this.f34240b;
            if (i == 1) {
                this.f34244f.setBackgroundColor(getResources().getColor(17170445));
                this.f34245g.setBackgroundColor(getResources().getColor(17170445));
            } else if (i != 2 && i != 3) {
                this.f34244f.setBackgroundColor(getResources().getColor(17170445));
                this.f34245g.setBackgroundColor(getResources().getColor(17170445));
            } else {
                SkinManager.setBackgroundColor(this.f34244f, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.f34245g, R.color.CAM_X0204);
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

    public final <S> S l(View view, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, view, i)) == null) ? (S) view.findViewById(i) : (S) invokeLI.objValue;
    }

    public final void m(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t) == null) {
            u.b().d(true);
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
            if (this.f34240b == 4) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
            }
            View q = q();
            this.f34242d = q;
            frameLayout.addView(q, o());
            View view = new View(getContext());
            this.f34243e = view;
            SkinManager.setBackgroundColor(view, R.color.common_color_10205);
            frameLayout.addView(this.f34243e, new ViewGroup.LayoutParams(-1, -1));
            this.f34246h = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
            SkinManager.setBackgroundColor(this.f34246h, R.color.CAM_X0201);
            SkinManager.setImageResource(this.f34246h, R.color.CAM_X0204);
            this.f34244f = new View(getContext());
            this.f34245g = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
            int i = this.f34240b;
            if (i != 1) {
                if (i == 2) {
                    SkinManager.setBackgroundColor(this.f34244f, R.color.CAM_X0204);
                    addView(this.f34244f, layoutParams3);
                    addView(this.f34246h, layoutParams2);
                    addView(frameLayout, layoutParams);
                    SkinManager.setBackgroundColor(this.f34245g, R.color.CAM_X0204);
                    addView(this.f34245g, layoutParams3);
                    return;
                } else if (i == 3) {
                    SkinManager.setBackgroundColor(this.f34244f, R.color.CAM_X0204);
                    addView(this.f34244f, layoutParams3);
                    addView(frameLayout, layoutParams);
                    layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198);
                    addView(this.f34246h, layoutParams2);
                    SkinManager.setBackgroundColor(this.f34245g, R.color.CAM_X0204);
                    addView(this.f34245g, layoutParams3);
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        this.f34244f.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.f34244f, layoutParams3);
                        layoutParams2.bottomMargin = 0;
                        addView(frameLayout, layoutParams);
                        addView(this.f34246h, layoutParams2);
                        this.f34245g.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.f34245g, layoutParams3);
                        return;
                    }
                    addView(frameLayout, layoutParams);
                    return;
                }
            }
            this.f34244f.setBackgroundColor(getResources().getColor(17170445));
            addView(this.f34244f, layoutParams3);
            layoutParams2.bottomMargin = 0;
            addView(this.f34246h, layoutParams2);
            addView(frameLayout, layoutParams);
            this.f34245g.setBackgroundColor(getResources().getColor(17170445));
            addView(this.f34245g, layoutParams3);
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
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, m.e());
        u.b().a(statisticItem);
    }

    @Override // c.a.p0.b2.o.l.e
    public final void setAfterClickSchemeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            this.k = aVar;
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public final void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.f34240b = i;
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

    @Override // c.a.p0.b2.o.l.e
    public void setDownloadAppCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public final void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @Override // c.a.p0.b2.o.l.e
    public final void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.f34241c = i;
        }
    }

    public abstract void t(T t, int i);

    public abstract void u(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.p0.b2.o.l.e
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
            int c2 = x.c(this.i, t.getScheme());
            a aVar = this.k;
            if (aVar != null) {
                aVar.a(c2, null);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    public final void x(View view, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048608, this, view, i, i2, i3) == null) {
            if (!b.a(i) && !b.a(i2)) {
                if (r()) {
                    i = i2;
                }
                view.setBackgroundColor(i);
                return;
            }
            SkinManager.setBackgroundColor(view, i3);
        }
    }

    public final void y(TextView textView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048609, this, textView, i, i2, i3) == null) {
            if (!b.a(i) && !b.a(i2)) {
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
            this.f34242d.setVisibility(0);
        }
    }
}
