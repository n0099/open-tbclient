package com.baidu.tieba.lego.card.e;

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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.j;
import com.baidu.tieba.card.r;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements k<T> {
    protected TbPageContext aRI;
    protected int faK;
    protected View fbA;
    protected View fbB;
    protected View fbC;
    protected ImageView fbD;
    protected a fbE;
    protected c fbF;
    protected View fbz;
    private boolean isInit;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aPT();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aRI = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aPV();
        aPW();
        this.isInit = false;
    }

    protected final <S> S B(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aPU() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aPV() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fbz = aPT();
        frameLayout.addView(this.fbz, aPU());
        this.fbA = new View(getContext());
        aj.t(this.fbA, d.C0141d.common_color_10205);
        frameLayout.addView(this.fbA, new ViewGroup.LayoutParams(-1, -1));
        this.fbD = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        aj.t(this.fbD, d.C0141d.cp_bg_line_d);
        aj.c(this.fbD, d.C0141d.cp_bg_line_b);
        this.fbB = new View(getContext());
        this.fbC = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.faK) {
            case 1:
            case 4:
                this.fbB.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbB, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.fbD, layoutParams2);
                addView(frameLayout, layoutParams);
                this.fbC.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbC, layoutParams3);
                return;
            case 2:
                aj.t(this.fbB, d.C0141d.cp_bg_line_c);
                addView(this.fbB, layoutParams3);
                addView(this.fbD, layoutParams2);
                addView(frameLayout, layoutParams);
                aj.t(this.fbC, d.C0141d.cp_bg_line_c);
                addView(this.fbC, layoutParams3);
                return;
            case 3:
                aj.t(this.fbB, d.C0141d.cp_bg_line_c);
                addView(this.fbB, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.fbD, layoutParams2);
                aj.t(this.fbC, d.C0141d.cp_bg_line_c);
                addView(this.fbC, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.fbB.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbB, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.fbD, layoutParams2);
                this.fbC.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbC, layoutParams3);
                return;
        }
    }

    protected void aPW() {
    }

    protected final void rc(int i) {
        switch (i) {
            case -1:
            case 0:
                this.fbD.setVisibility(8);
                return;
            case 1:
                this.fbD.setPadding(0, 0, 0, 0);
                this.fbD.setVisibility(0);
                return;
            case 2:
                this.fbD.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.fbD.setVisibility(0);
                return;
            case 3:
                this.fbD.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.fbD.setVisibility(0);
                return;
            default:
                this.fbD.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.fbA.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        rc(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.fbB.setVisibility(8);
                this.fbC.setVisibility(8);
                return;
            case 1:
                this.fbB.setVisibility(8);
                this.fbC.setVisibility(0);
                return;
            case 2:
                this.fbB.setVisibility(0);
                this.fbC.setVisibility(8);
                return;
            case 3:
                this.fbB.setVisibility(0);
                this.fbC.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aPX() {
        this.fbz.setVisibility(0);
    }

    public final void d(T t) {
        r.alt().dk(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.e.b<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.e.k
    public final void aT(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aPZ();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aPX();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int f = com.baidu.tieba.tbadkCore.r.f(this.aRI, t.getScheme());
        if (this.fbE != null) {
            this.fbE.b(f, null);
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

    @Override // com.baidu.tieba.lego.card.e.k
    public final void setPosition(int i) {
        this.mPosition = i;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public final void setBusinessType(int i) {
        this.faK = i;
    }

    public final int getBusinessType() {
        return this.faK;
    }

    public final boolean aPY() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || v.E(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
            spannableString.setSpan(new ForegroundColorSpan(aPY() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
        }
        return spannableString;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ra(i) || com.baidu.tieba.lego.card.d.a.ra(i2)) {
            aj.r(textView, i3);
            return;
        }
        if (!aPY()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ra(i) || com.baidu.tieba.lego.card.d.a.ra(i2)) {
            aj.t(view, i3);
            return;
        }
        if (!aPY()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aPZ() {
        aj.t(this.fbD, d.C0141d.cp_bg_line_d);
        aj.c(this.fbD, d.C0141d.cp_bg_line_b);
        switch (this.faK) {
            case 1:
                this.fbB.setBackgroundColor(getResources().getColor(17170445));
                this.fbC.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aj.t(this.fbB, d.C0141d.cp_bg_line_c);
                aj.t(this.fbC, d.C0141d.cp_bg_line_c);
                return;
            default:
                this.fbB.setBackgroundColor(getResources().getColor(17170445));
                this.fbC.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            aj.e(textView, d.C0141d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aj.e(textView, d.C0141d.btn_forum_focus_color, 1);
        textView.setText(str);
        aj.s(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            ak akVar = new ak(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    akVar.ab(split[0], split[1]);
                }
            }
            akVar.s("obj_locate", getStatPosition());
            akVar.ab("obj_param3", j.alg());
            r.alt().a(akVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQa() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQb() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQc() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public final void setAfterClickSchemeListener(a aVar) {
        this.fbE = aVar;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(c cVar) {
        this.fbF = cVar;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQd() {
    }
}
