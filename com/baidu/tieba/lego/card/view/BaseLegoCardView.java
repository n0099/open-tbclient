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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected int gGn;
    protected View gHg;
    protected View gHh;
    protected View gHi;
    protected View gHj;
    protected ImageView gHk;
    protected a gHl;
    protected c gHm;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View bAa();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        bAc();
        xt();
        this.isInit = false;
    }

    protected final <S> S A(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams bAb() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void bAc() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.gHg = bAa();
        frameLayout.addView(this.gHg, bAb());
        this.gHh = new View(getContext());
        al.l(this.gHh, d.C0277d.common_color_10205);
        frameLayout.addView(this.gHh, new ViewGroup.LayoutParams(-1, -1));
        this.gHk = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        al.l(this.gHk, d.C0277d.cp_bg_line_d);
        al.c(this.gHk, d.C0277d.cp_bg_line_b);
        this.gHi = new View(getContext());
        this.gHj = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.gGn) {
            case 1:
            case 4:
                this.gHi.setBackgroundColor(getResources().getColor(17170445));
                addView(this.gHi, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.gHk, layoutParams2);
                addView(frameLayout, layoutParams);
                this.gHj.setBackgroundColor(getResources().getColor(17170445));
                addView(this.gHj, layoutParams3);
                return;
            case 2:
                al.l(this.gHi, d.C0277d.cp_bg_line_c);
                addView(this.gHi, layoutParams3);
                addView(this.gHk, layoutParams2);
                addView(frameLayout, layoutParams);
                al.l(this.gHj, d.C0277d.cp_bg_line_c);
                addView(this.gHj, layoutParams3);
                return;
            case 3:
                al.l(this.gHi, d.C0277d.cp_bg_line_c);
                addView(this.gHi, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.gHk, layoutParams2);
                al.l(this.gHj, d.C0277d.cp_bg_line_c);
                addView(this.gHj, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.gHi.setBackgroundColor(getResources().getColor(17170445));
                addView(this.gHi, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.gHk, layoutParams2);
                this.gHj.setBackgroundColor(getResources().getColor(17170445));
                addView(this.gHj, layoutParams3);
                return;
        }
    }

    protected void xt() {
    }

    protected final void uN(int i) {
        switch (i) {
            case -1:
            case 0:
                this.gHk.setVisibility(8);
                return;
            case 1:
                this.gHk.setPadding(0, 0, 0, 0);
                this.gHk.setVisibility(0);
                return;
            case 2:
                this.gHk.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.gHk.setVisibility(0);
                return;
            case 3:
                this.gHk.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.gHk.setVisibility(0);
                return;
            default:
                this.gHk.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.gHh.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        uN(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.gHi.setVisibility(8);
                this.gHj.setVisibility(8);
                return;
            case 1:
                this.gHi.setVisibility(8);
                this.gHj.setVisibility(0);
                return;
            case 2:
                this.gHi.setVisibility(0);
                this.gHj.setVisibility(8);
                return;
            case 3:
                this.gHi.setVisibility(0);
                this.gHj.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void bAd() {
        this.gHg.setVisibility(0);
    }

    public final void d(T t) {
        t.aQD().go(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void am(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                bAe();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            bAd();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.gHl != null) {
            this.gHl.b(e, null);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.mPosition + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setPosition(int i) {
        this.mPosition = i;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setBusinessType(int i) {
        this.gGn = i;
    }

    public final int getBusinessType() {
        return this.gGn;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || v.T(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int i3 = indexOf;
        int i4 = 0;
        int i5 = 0;
        while (i3 >= 0) {
            sb.append(str.substring(i5, i3));
            if (i4 < list.size()) {
                arrayList.add(Integer.valueOf(sb.length()));
                int i6 = i4 + 1;
                sb.append(list.get(i4));
                int length = i3 + "{%s}".length();
                i3 = str.indexOf("{%s}", i3 + "{%s}".length());
                i5 = length;
                i4 = i6;
            } else {
                i3 = -1;
            }
        }
        if (i5 < str.length()) {
            sb.append(str.substring(i5));
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            int intValue = ((Integer) arrayList.get(i7)).intValue();
            spannableString.setSpan(new ForegroundColorSpan(isNightMode() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
        }
        return spannableString;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.uL(i) || com.baidu.tieba.lego.card.d.a.uL(i2)) {
            al.j(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void e(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.uL(i) || com.baidu.tieba.lego.card.d.a.uL(i2)) {
            al.l(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void bAe() {
        al.l(this.gHk, d.C0277d.cp_bg_line_d);
        al.c(this.gHk, d.C0277d.cp_bg_line_b);
        switch (this.gGn) {
            case 1:
                this.gHi.setBackgroundColor(getResources().getColor(17170445));
                this.gHj.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                al.l(this.gHi, d.C0277d.cp_bg_line_c);
                al.l(this.gHj, d.C0277d.cp_bg_line_c);
                return;
            default:
                this.gHi.setBackgroundColor(getResources().getColor(17170445));
                this.gHj.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            al.d(textView, d.C0277d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.d(textView, d.C0277d.btn_forum_focus_color, 1);
        textView.setText(str);
        al.k(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            am amVar = new am(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    amVar.bJ(split[0], split[1]);
                }
            }
            amVar.T("obj_locate", getStatPosition());
            amVar.bJ("obj_param3", n.aQv());
            t.aQD().b(amVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bAf() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void Po() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bAg() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.gHl = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.gHm = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bAh() {
    }
}
