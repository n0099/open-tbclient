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
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import d.b.i0.c3.v;
import d.b.i0.i1.o.a;
import d.b.i0.i1.o.c;
import d.b.i0.i1.o.k.b;
import d.b.i0.i1.o.l.e;
import d.b.i0.x.m;
import d.b.i0.x.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {

    /* renamed from: e  reason: collision with root package name */
    public String f18637e;

    /* renamed from: f  reason: collision with root package name */
    public int f18638f;

    /* renamed from: g  reason: collision with root package name */
    public int f18639g;

    /* renamed from: h  reason: collision with root package name */
    public View f18640h;
    public View i;
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

    public void A(T t) {
        int c2 = v.c(this.m, t.getScheme());
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(c2, null);
        }
    }

    public void B() {
    }

    public final void E(View view, int i, int i2, int i3) {
        if (!b.a(i) && !b.a(i2)) {
            if (w()) {
                i = i2;
            }
            view.setBackgroundColor(i);
            return;
        }
        SkinManager.setBackgroundColor(view, i3);
    }

    public final void F(TextView textView, int i, int i2, int i3) {
        if (!b.a(i) && !b.a(i2)) {
            if (w()) {
                i = i2;
            }
            textView.setTextColor(i);
            return;
        }
        SkinManager.setViewTextColor(textView, i3);
    }

    public final void G() {
        this.f18640h.setVisibility(0);
    }

    public final void I(TextView textView, boolean z, String str, String str2) {
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

    public final void J(int i) {
        if (i == -1 || i == 0) {
            this.l.setVisibility(8);
        } else if (i == 1) {
            this.l.setPadding(0, 0, 0, 0);
            this.l.setVisibility(0);
        } else if (i == 2) {
            this.l.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
            this.l.setVisibility(0);
        } else if (i != 3) {
            this.l.setVisibility(8);
        } else {
            this.l.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
            this.l.setVisibility(0);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.b.i0.i1.o.l.e
    public final void c(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo == null || (updateCard = iCardInfo.getUpdateCard()) == null) {
            return;
        }
        BaseLegoCardInfo baseLegoCardInfo = (BaseLegoCardInfo) updateCard;
        x(baseLegoCardInfo);
        if (this.p) {
            r();
        }
        if (this.n != TbadkCoreApplication.getInst().getSkinType()) {
            this.n = TbadkCoreApplication.getInst().getSkinType();
            m();
            y(baseLegoCardInfo, this.n);
        }
        G();
        z(baseLegoCardInfo);
        g(baseLegoCardInfo);
    }

    @Override // d.b.i0.i1.o.l.e
    public void e() {
    }

    @Override // d.b.i0.i1.o.l.e
    public void f() {
    }

    public final void g(T t) {
        this.i.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        J(showSpace != 0 ? -1 : t.getShowLine());
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
        return this.f18638f;
    }

    public final int getStatPosition() {
        return this.f18639g + 1;
    }

    @Override // d.b.i0.i1.o.l.e
    public void h() {
    }

    @Override // d.b.i0.i1.o.l.e
    public void k() {
    }

    @Override // d.b.i0.i1.o.l.e
    public void l(BdUniqueId bdUniqueId) {
    }

    public final void m() {
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setImageResource(this.l, R.color.CAM_X0204);
        int i = this.f18638f;
        if (i == 1) {
            this.j.setBackgroundColor(getResources().getColor(17170445));
            this.k.setBackgroundColor(getResources().getColor(17170445));
        } else if (i != 2 && i != 3) {
            this.j.setBackgroundColor(getResources().getColor(17170445));
            this.k.setBackgroundColor(getResources().getColor(17170445));
        } else {
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
        }
    }

    public final SpannableString n(String str, List<String> list, int i, int i2) {
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
                spannableString.setSpan(new ForegroundColorSpan(w() ? i2 : i), intValue, list.get(i6).length() + intValue, 33);
            }
            return spannableString;
        }
        return null;
    }

    public final <S> S o(View view, int i) {
        return (S) view.findViewById(i);
    }

    public String p(@NonNull AdvertAppInfo advertAppInfo) {
        return advertAppInfo.C4() ? "" : TextUtils.isEmpty(advertAppInfo.J3) ? advertAppInfo.E3 : advertAppInfo.J3;
    }

    public final void q(T t) {
        t.b().d(true);
        A(t);
    }

    public final void r() {
        u();
        B();
        this.p = false;
    }

    public final ViewGroup.LayoutParams s() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // d.b.i0.i1.o.l.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.o = aVar;
    }

    @Override // d.b.i0.i1.o.l.e
    public final void setBusinessType(int i) {
        this.f18638f = i;
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    @Override // d.b.i0.i1.o.l.e
    public void setDownloadAppCallback(c cVar) {
        this.q = cVar;
    }

    @Override // d.b.i0.i1.o.l.e
    public final void setFromCDN(boolean z) {
    }

    @Override // d.b.i0.i1.o.l.e
    public final void setPosition(int i) {
        this.f18639g = i;
    }

    public final void u() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.f18638f == 4) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
        }
        View v = v();
        this.f18640h = v;
        frameLayout.addView(v, s());
        View view = new View(getContext());
        this.i = view;
        SkinManager.setBackgroundColor(view, R.color.common_color_10205);
        frameLayout.addView(this.i, new ViewGroup.LayoutParams(-1, -1));
        this.l = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0201);
        SkinManager.setImageResource(this.l, R.color.CAM_X0204);
        this.j = new View(getContext());
        this.k = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        int i = this.f18638f;
        if (i != 1) {
            if (i == 2) {
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
                addView(this.j, layoutParams3);
                addView(this.l, layoutParams2);
                addView(frameLayout, layoutParams);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
                addView(this.k, layoutParams3);
                return;
            } else if (i == 3) {
                SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
                addView(this.j, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.l, layoutParams2);
                SkinManager.setBackgroundColor(this.k, R.color.CAM_X0204);
                addView(this.k, layoutParams3);
                return;
            } else if (i != 4) {
                if (i != 5) {
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

    public abstract View v();

    public final boolean w() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    public final void x(T t) {
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

    public abstract void y(T t, int i);

    public abstract void z(T t);
}
