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
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.a0.m;
import d.a.s0.a0.t;
import d.a.s0.h3.v;
import d.a.s0.n1.o.a;
import d.a.s0.n1.o.c;
import d.a.s0.n1.o.k.b;
import d.a.s0.n1.o.l.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f18190e;

    /* renamed from: f  reason: collision with root package name */
    public int f18191f;

    /* renamed from: g  reason: collision with root package name */
    public int f18192g;

    /* renamed from: h  reason: collision with root package name */
    public View f18193h;

    /* renamed from: i  reason: collision with root package name */
    public View f18194i;
    public View j;
    public View k;
    public ImageView l;
    public TbPageContext m;
    public int n;
    public a o;
    public boolean p;
    public c q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.p = true;
        this.m = tbPageContext;
        setOrientation(1);
    }

    public final void A(TextView textView, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, textView, i2, i3, i4) == null) {
            if (!b.a(i2) && !b.a(i3)) {
                if (t()) {
                    i2 = i3;
                }
                textView.setTextColor(i2);
                return;
            }
            SkinManager.setViewTextColor(textView, i4);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18193h.setVisibility(0);
        }
    }

    public final void F(TextView textView, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{textView, Boolean.valueOf(z), str, str2}) == null) {
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
            textView.setPadding(getResources().getDimensionPixelSize(R.dimen.ds18), 0, getResources().getDimensionPixelSize(R.dimen.ds10), 0);
        }
    }

    public final void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == -1 || i2 == 0) {
                this.l.setVisibility(8);
            } else if (i2 == 1) {
                this.l.setPadding(0, 0, 0, 0);
                this.l.setVisibility(0);
            } else if (i2 == 2) {
                this.l.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.l.setVisibility(0);
            } else if (i2 != 3) {
                this.l.setVisibility(8);
            } else {
                this.l.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.l.setVisibility(0);
            }
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    public final void g(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, t) == null) {
            this.f18194i.setVisibility(t.isShowCover() ? 0 : 8);
            int showSpace = t.getShowSpace();
            G(showSpace != 0 ? -1 : t.getShowLine());
            if (showSpace == 0) {
                this.j.setVisibility(8);
                this.k.setVisibility(8);
            } else if (showSpace == 1) {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
            } else if (showSpace == 2) {
                this.j.setVisibility(0);
                this.k.setVisibility(8);
            } else if (showSpace != 3) {
            } else {
                this.j.setVisibility(0);
                this.k.setVisibility(0);
            }
        }
    }

    public final int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f18191f : invokeV.intValue;
    }

    public final int getStatPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f18192g + 1 : invokeV.intValue;
    }

    @Override // d.a.s0.n1.o.l.e
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.s0.n1.o.l.e
    public final void i(Object obj) {
        ICardInfo iCardInfo;
        ICardInfo updateCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, obj) == null) || (iCardInfo = (ICardInfo) obj) == null || (updateCard = iCardInfo.getUpdateCard()) == null) {
            return;
        }
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) updateCard;
        u(baseLegoCardInfo);
        if (this.p) {
            p();
        }
        if (this.n != TbadkCoreApplication.getInst().getSkinType()) {
            this.n = TbadkCoreApplication.getInst().getSkinType();
            l();
            v(baseLegoCardInfo, this.n);
        }
        B();
        w(baseLegoCardInfo);
        g(baseLegoCardInfo);
    }

    @Override // d.a.s0.n1.o.l.e
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setImageResource(this.l, R.color.CAM_X0204);
            int i2 = this.f18191f;
            if (i2 == 1) {
                this.j.setBackgroundColor(getResources().getColor(17170445));
                this.k.setBackgroundColor(getResources().getColor(17170445));
            } else if (i2 != 2 && i2 != 3) {
                this.j.setBackgroundColor(getResources().getColor(17170445));
                this.k.setBackgroundColor(getResources().getColor(17170445));
            } else {
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
            }
        }
    }

    public final SpannableString m(String str, List<String> list, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048590, this, str, list, i2, i3)) == null) {
            if (TextUtils.isEmpty(str) || ListUtils.isEmpty(list)) {
                return null;
            }
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
                    spannableString.setSpan(new ForegroundColorSpan(t() ? i3 : i2), intValue, list.get(i7).length() + intValue, 33);
                }
                return spannableString;
            }
            return null;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public final <S> S n(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, view, i2)) == null) ? (S) view.findViewById(i2) : (S) invokeLI.objValue;
    }

    public final void o(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, t) == null) {
            t.b().d(true);
            x(t);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            r();
            y();
            this.p = false;
        }
    }

    public final ViewGroup.LayoutParams q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? new ViewGroup.LayoutParams(-1, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            FrameLayout frameLayout = new FrameLayout(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            if (this.f18191f == 4) {
                layoutParams.setMargins(0, 0, 0, 0);
            } else {
                layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
            }
            View s = s();
            this.f18193h = s;
            frameLayout.addView(s, q());
            View view = new View(getContext());
            this.f18194i = view;
            SkinManager.setBackgroundColor(view, R.color.common_color_10205);
            frameLayout.addView(this.f18194i, new ViewGroup.LayoutParams(-1, -1));
            this.l = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
            SkinManager.setImageResource(this.l, R.color.CAM_X0204);
            this.j = new View(getContext());
            this.k = new View(getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
            int i2 = this.f18191f;
            if (i2 != 1) {
                if (i2 == 2) {
                    SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
                    addView(this.j, layoutParams3);
                    addView(this.l, layoutParams2);
                    addView(frameLayout, layoutParams);
                    SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
                    addView(this.k, layoutParams3);
                    return;
                } else if (i2 == 3) {
                    SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
                    addView(this.j, layoutParams3);
                    addView(frameLayout, layoutParams);
                    layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                    addView(this.l, layoutParams2);
                    SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
                    addView(this.k, layoutParams3);
                    return;
                } else if (i2 != 4) {
                    if (i2 != 5) {
                        this.j.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.j, layoutParams3);
                        layoutParams2.bottomMargin = 0;
                        addView(frameLayout, layoutParams);
                        addView(this.l, layoutParams2);
                        this.k.setBackgroundColor(getResources().getColor(17170445));
                        addView(this.k, layoutParams3);
                        return;
                    }
                    addView(frameLayout, layoutParams);
                    return;
                }
            }
            this.j.setBackgroundColor(getResources().getColor(17170445));
            addView(this.j, layoutParams3);
            layoutParams2.bottomMargin = 0;
            addView(this.l, layoutParams2);
            addView(frameLayout, layoutParams);
            this.k.setBackgroundColor(getResources().getColor(17170445));
            addView(this.k, layoutParams3);
        }
    }

    public abstract View s();

    @Override // d.a.s0.n1.o.l.e
    public final void setAfterClickSchemeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, aVar) == null) {
            this.o = aVar;
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public final void setBusinessType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f18191f = i2;
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            setOnClickListener(onClickListener);
        }
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            setOnLongClickListener(onLongClickListener);
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public final void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    @Override // d.a.s0.n1.o.l.e
    public final void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.f18192g = i2;
        }
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? 1 == TbadkCoreApplication.getInst().getSkinType() : invokeV.booleanValue;
    }

    public final void u(T t) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, t) == null) || t == null || TextUtils.isEmpty(t.getShowKey()) || TextUtils.isEmpty(t.getShowExtra())) {
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
        t.b().a(statisticItem);
    }

    public abstract void v(T t, int i2);

    public abstract void w(T t);

    public void x(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, t) == null) {
            int c2 = v.c(this.m, t.getScheme());
            a aVar = this.o;
            if (aVar != null) {
                aVar.a(c2, null);
            }
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    public final void z(View view, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048610, this, view, i2, i3, i4) == null) {
            if (!b.a(i2) && !b.a(i3)) {
                if (t()) {
                    i2 = i3;
                }
                view.setBackgroundColor(i2);
                return;
            }
            SkinManager.setBackgroundColor(view, i4);
        }
    }
}
