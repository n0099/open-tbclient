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
import com.baidu.tieba.tbadkCore.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements k<T> {
    protected TbPageContext aRG;
    protected int faw;
    protected View fbl;
    protected View fbm;
    protected View fbn;
    protected View fbo;
    protected ImageView fbp;
    protected a fbq;
    protected c fbr;
    private boolean isInit;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aPS();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aRG = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aPU();
        aPV();
        this.isInit = false;
    }

    protected final <S> S B(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aPT() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aPU() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fbl = aPS();
        frameLayout.addView(this.fbl, aPT());
        this.fbm = new View(getContext());
        aj.t(this.fbm, d.C0141d.common_color_10205);
        frameLayout.addView(this.fbm, new ViewGroup.LayoutParams(-1, -1));
        this.fbp = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        aj.t(this.fbp, d.C0141d.cp_bg_line_d);
        aj.c(this.fbp, d.C0141d.cp_bg_line_b);
        this.fbn = new View(getContext());
        this.fbo = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.faw) {
            case 1:
            case 4:
                this.fbn.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbn, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.fbp, layoutParams2);
                addView(frameLayout, layoutParams);
                this.fbo.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbo, layoutParams3);
                return;
            case 2:
                aj.t(this.fbn, d.C0141d.cp_bg_line_c);
                addView(this.fbn, layoutParams3);
                addView(this.fbp, layoutParams2);
                addView(frameLayout, layoutParams);
                aj.t(this.fbo, d.C0141d.cp_bg_line_c);
                addView(this.fbo, layoutParams3);
                return;
            case 3:
                aj.t(this.fbn, d.C0141d.cp_bg_line_c);
                addView(this.fbn, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.fbp, layoutParams2);
                aj.t(this.fbo, d.C0141d.cp_bg_line_c);
                addView(this.fbo, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.fbn.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbn, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.fbp, layoutParams2);
                this.fbo.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fbo, layoutParams3);
                return;
        }
    }

    protected void aPV() {
    }

    protected final void rc(int i) {
        switch (i) {
            case -1:
            case 0:
                this.fbp.setVisibility(8);
                return;
            case 1:
                this.fbp.setPadding(0, 0, 0, 0);
                this.fbp.setVisibility(0);
                return;
            case 2:
                this.fbp.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.fbp.setVisibility(0);
                return;
            case 3:
                this.fbp.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.fbp.setVisibility(0);
                return;
            default:
                this.fbp.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.fbm.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        rc(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.fbn.setVisibility(8);
                this.fbo.setVisibility(8);
                return;
            case 1:
                this.fbn.setVisibility(8);
                this.fbo.setVisibility(0);
                return;
            case 2:
                this.fbn.setVisibility(0);
                this.fbo.setVisibility(8);
                return;
            case 3:
                this.fbn.setVisibility(0);
                this.fbo.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aPW() {
        this.fbl.setVisibility(0);
    }

    public final void d(T t) {
        r.als().dk(true);
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
                aPY();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aPW();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int f = q.f(this.aRG, t.getScheme());
        if (this.fbq != null) {
            this.fbq.b(f, null);
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
        this.faw = i;
    }

    public final int getBusinessType() {
        return this.faw;
    }

    public final boolean aPX() {
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
            spannableString.setSpan(new ForegroundColorSpan(aPX() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
        }
        return spannableString;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ra(i) || com.baidu.tieba.lego.card.d.a.ra(i2)) {
            aj.r(textView, i3);
            return;
        }
        if (!aPX()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ra(i) || com.baidu.tieba.lego.card.d.a.ra(i2)) {
            aj.t(view, i3);
            return;
        }
        if (!aPX()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aPY() {
        aj.t(this.fbp, d.C0141d.cp_bg_line_d);
        aj.c(this.fbp, d.C0141d.cp_bg_line_b);
        switch (this.faw) {
            case 1:
                this.fbn.setBackgroundColor(getResources().getColor(17170445));
                this.fbo.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aj.t(this.fbn, d.C0141d.cp_bg_line_c);
                aj.t(this.fbo, d.C0141d.cp_bg_line_c);
                return;
            default:
                this.fbn.setBackgroundColor(getResources().getColor(17170445));
                this.fbo.setBackgroundColor(getResources().getColor(17170445));
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
            akVar.ab("obj_param3", j.alf());
            r.als().a(akVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aPZ() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQa() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQb() {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public final void setAfterClickSchemeListener(a aVar) {
        this.fbq = aVar;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void setDownloadAppCallback(c cVar) {
        this.fbr = cVar;
    }

    @Override // com.baidu.tieba.lego.card.e.k
    public void aQc() {
    }
}
