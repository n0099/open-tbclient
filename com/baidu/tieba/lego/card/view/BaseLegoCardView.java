package com.baidu.tieba.lego.card.view;

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
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.a.o0.e3.v;
import d.a.o0.k1.o.a;
import d.a.o0.k1.o.c;
import d.a.o0.k1.o.k.b;
import d.a.o0.k1.o.l.e;
import d.a.o0.z.m;
import d.a.o0.z.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {

    /* renamed from: e  reason: collision with root package name */
    public String f18064e;

    /* renamed from: f  reason: collision with root package name */
    public int f18065f;

    /* renamed from: g  reason: collision with root package name */
    public int f18066g;

    /* renamed from: h  reason: collision with root package name */
    public View f18067h;

    /* renamed from: i  reason: collision with root package name */
    public View f18068i;
    public View j;
    public View k;
    public ImageView l;
    public TbPageContext m;
    public int n;
    public a o;
    public boolean p;
    public c q;

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.n = 3;
        this.p = true;
        this.m = tbPageContext;
        setOrientation(1);
    }

    public final void A(View view, int i2, int i3, int i4) {
        if (!b.a(i2) && !b.a(i3)) {
            if (u()) {
                i2 = i3;
            }
            view.setBackgroundColor(i2);
            return;
        }
        SkinManager.setBackgroundColor(view, i4);
    }

    public final void B(TextView textView, int i2, int i3, int i4) {
        if (!b.a(i2) && !b.a(i3)) {
            if (u()) {
                i2 = i3;
            }
            textView.setTextColor(i2);
            return;
        }
        SkinManager.setViewTextColor(textView, i4);
    }

    public final void F() {
        this.f18067h.setVisibility(0);
    }

    public final void G(TextView textView, boolean z, String str, String str2) {
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

    public final void H(int i2) {
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

    @Override // d.a.o0.k1.o.l.e
    public void c(BdUniqueId bdUniqueId) {
    }

    @Override // d.a.o0.k1.o.l.e
    public void f() {
    }

    public final void g(T t) {
        this.f18068i.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        H(showSpace != 0 ? -1 : t.getShowLine());
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

    public final int getBusinessType() {
        return this.f18065f;
    }

    public final int getStatPosition() {
        return this.f18066g + 1;
    }

    @Override // d.a.o0.k1.o.l.e
    public void h() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.o0.k1.o.l.e
    public final void i(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo == null || (updateCard = iCardInfo.getUpdateCard()) == null) {
            return;
        }
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) updateCard;
        v(baseLegoCardInfo);
        if (this.p) {
            q();
        }
        if (this.n != TbadkCoreApplication.getInst().getSkinType()) {
            this.n = TbadkCoreApplication.getInst().getSkinType();
            m();
            w(baseLegoCardInfo, this.n);
        }
        F();
        x(baseLegoCardInfo);
        g(baseLegoCardInfo);
    }

    @Override // d.a.o0.k1.o.l.e
    public void j() {
    }

    @Override // d.a.o0.k1.o.l.e
    public void k() {
    }

    public final void m() {
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setImageResource(this.l, R.color.CAM_X0204);
        int i2 = this.f18065f;
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

    public final SpannableString n(String str, List<String> list, int i2, int i3) {
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
                spannableString.setSpan(new ForegroundColorSpan(u() ? i3 : i2), intValue, list.get(i7).length() + intValue, 33);
            }
            return spannableString;
        }
        return null;
    }

    public final <S> S o(View view, int i2) {
        return (S) view.findViewById(i2);
    }

    public final void p(T t) {
        t.b().d(true);
        y(t);
    }

    public final void q() {
        s();
        z();
        this.p = false;
    }

    public final ViewGroup.LayoutParams r() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void s() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.f18065f == 4) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
        }
        View t = t();
        this.f18067h = t;
        frameLayout.addView(t, r());
        View view = new View(getContext());
        this.f18068i = view;
        SkinManager.setBackgroundColor(view, R.color.common_color_10205);
        frameLayout.addView(this.f18068i, new ViewGroup.LayoutParams(-1, -1));
        this.l = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setImageResource(this.l, R.color.CAM_X0204);
        this.j = new View(getContext());
        this.k = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        int i2 = this.f18065f;
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

    @Override // d.a.o0.k1.o.l.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.o = aVar;
    }

    @Override // d.a.o0.k1.o.l.e
    public final void setBusinessType(int i2) {
        this.f18065f = i2;
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    @Override // d.a.o0.k1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        this.q = cVar;
    }

    @Override // d.a.o0.k1.o.l.e
    public final void setFromCDN(boolean z) {
    }

    @Override // d.a.o0.k1.o.l.e
    public final void setPosition(int i2) {
        this.f18066g = i2;
    }

    public abstract View t();

    public final boolean u() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    public final void v(T t) {
        if (t == null || TextUtils.isEmpty(t.getShowKey()) || TextUtils.isEmpty(t.getShowExtra())) {
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

    public abstract void w(T t, int i2);

    public abstract void x(T t);

    public void y(T t) {
        int c2 = v.c(this.m, t.getScheme());
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(c2, null);
        }
    }

    public void z() {
    }
}
