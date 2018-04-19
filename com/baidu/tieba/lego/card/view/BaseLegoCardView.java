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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
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
    protected TbPageContext adf;
    protected int evs;
    protected View ewh;
    protected View ewi;
    protected View ewj;
    protected View ewk;
    protected ImageView ewl;
    protected a ewm;
    protected c ewn;
    private boolean isInit;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aKU();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.adf = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aKW();
        aKX();
        this.isInit = false;
    }

    protected final <S> S r(View view2, int i) {
        return (S) view2.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aKV() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aKW() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.ewh = aKU();
        frameLayout.addView(this.ewh, aKV());
        this.ewi = new View(getContext());
        ak.j(this.ewi, d.C0126d.common_color_10205);
        frameLayout.addView(this.ewi, new ViewGroup.LayoutParams(-1, -1));
        this.ewl = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        ak.j(this.ewl, d.C0126d.cp_bg_line_d);
        ak.c(this.ewl, d.C0126d.cp_bg_line_b);
        this.ewj = new View(getContext());
        this.ewk = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.evs) {
            case 1:
            case 4:
                this.ewj.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ewj, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.ewl, layoutParams2);
                addView(frameLayout, layoutParams);
                this.ewk.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ewk, layoutParams3);
                return;
            case 2:
                ak.j(this.ewj, d.C0126d.cp_bg_line_c);
                addView(this.ewj, layoutParams3);
                addView(this.ewl, layoutParams2);
                addView(frameLayout, layoutParams);
                ak.j(this.ewk, d.C0126d.cp_bg_line_c);
                addView(this.ewk, layoutParams3);
                return;
            case 3:
                ak.j(this.ewj, d.C0126d.cp_bg_line_c);
                addView(this.ewj, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.ewl, layoutParams2);
                ak.j(this.ewk, d.C0126d.cp_bg_line_c);
                addView(this.ewk, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.ewj.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ewj, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.ewl, layoutParams2);
                this.ewk.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ewk, layoutParams3);
                return;
        }
    }

    protected void aKX() {
    }

    protected final void ox(int i) {
        switch (i) {
            case -1:
            case 0:
                this.ewl.setVisibility(8);
                return;
            case 1:
                this.ewl.setPadding(0, 0, 0, 0);
                this.ewl.setVisibility(0);
                return;
            case 2:
                this.ewl.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.ewl.setVisibility(0);
                return;
            case 3:
                this.ewl.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.ewl.setVisibility(0);
                return;
            default:
                this.ewl.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.ewi.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        ox(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.ewj.setVisibility(8);
                this.ewk.setVisibility(8);
                return;
            case 1:
                this.ewj.setVisibility(8);
                this.ewk.setVisibility(0);
                return;
            case 2:
                this.ewj.setVisibility(0);
                this.ewk.setVisibility(8);
                return;
            case 3:
                this.ewj.setVisibility(0);
                this.ewk.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aKY() {
        this.ewh.setVisibility(0);
    }

    public final void d(T t) {
        v.afy().cB(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void O(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aKZ();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aKY();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.adf, t.getScheme());
        if (this.ewm != null) {
            this.ewm.b(e, null);
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
        this.evs = i;
    }

    public final int getBusinessType() {
        return this.evs;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.v.w(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.ov(i) || com.baidu.tieba.lego.card.d.a.ov(i2)) {
            ak.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view2, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ov(i) || com.baidu.tieba.lego.card.d.a.ov(i2)) {
            ak.j(view2, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view2.setBackgroundColor(i2);
    }

    private void aKZ() {
        ak.j(this.ewl, d.C0126d.cp_bg_line_d);
        ak.c(this.ewl, d.C0126d.cp_bg_line_b);
        switch (this.evs) {
            case 1:
                this.ewj.setBackgroundColor(getResources().getColor(17170445));
                this.ewk.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                ak.j(this.ewj, d.C0126d.cp_bg_line_c);
                ak.j(this.ewk, d.C0126d.cp_bg_line_c);
                return;
            default:
                this.ewj.setBackgroundColor(getResources().getColor(17170445));
                this.ewk.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ak.c(textView, d.C0126d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ak.c(textView, d.C0126d.btn_forum_focus_color, 1);
        textView.setText(str);
        ak.i(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            al alVar = new al(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    alVar.ac(split[0], split[1]);
                }
            }
            alVar.r("obj_locate", getStatPosition());
            alVar.ac("obj_param3", o.afp());
            v.afy().a(alVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLa() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLb() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLc() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.ewm = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.ewn = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLd() {
    }
}
