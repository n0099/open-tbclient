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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
    protected int eLF;
    protected View eMA;
    protected View eMB;
    protected View eMC;
    protected ImageView eMD;
    protected a eME;
    protected c eMF;
    protected View eMz;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aQw();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aQy();
        aQz();
        this.isInit = false;
    }

    protected final <S> S t(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aQx() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aQy() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eMz = aQw();
        frameLayout.addView(this.eMz, aQx());
        this.eMA = new View(getContext());
        am.j(this.eMA, d.C0142d.common_color_10205);
        frameLayout.addView(this.eMA, new ViewGroup.LayoutParams(-1, -1));
        this.eMD = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        am.j(this.eMD, d.C0142d.cp_bg_line_d);
        am.c(this.eMD, d.C0142d.cp_bg_line_b);
        this.eMB = new View(getContext());
        this.eMC = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.eLF) {
            case 1:
            case 4:
                this.eMB.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eMB, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.eMD, layoutParams2);
                addView(frameLayout, layoutParams);
                this.eMC.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eMC, layoutParams3);
                return;
            case 2:
                am.j(this.eMB, d.C0142d.cp_bg_line_c);
                addView(this.eMB, layoutParams3);
                addView(this.eMD, layoutParams2);
                addView(frameLayout, layoutParams);
                am.j(this.eMC, d.C0142d.cp_bg_line_c);
                addView(this.eMC, layoutParams3);
                return;
            case 3:
                am.j(this.eMB, d.C0142d.cp_bg_line_c);
                addView(this.eMB, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.eMD, layoutParams2);
                am.j(this.eMC, d.C0142d.cp_bg_line_c);
                addView(this.eMC, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.eMB.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eMB, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.eMD, layoutParams2);
                this.eMC.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eMC, layoutParams3);
                return;
        }
    }

    protected void aQz() {
    }

    protected final void oP(int i) {
        switch (i) {
            case -1:
            case 0:
                this.eMD.setVisibility(8);
                return;
            case 1:
                this.eMD.setPadding(0, 0, 0, 0);
                this.eMD.setVisibility(0);
                return;
            case 2:
                this.eMD.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.eMD.setVisibility(0);
                return;
            case 3:
                this.eMD.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.eMD.setVisibility(0);
                return;
            default:
                this.eMD.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.eMA.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        oP(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.eMB.setVisibility(8);
                this.eMC.setVisibility(8);
                return;
            case 1:
                this.eMB.setVisibility(8);
                this.eMC.setVisibility(0);
                return;
            case 2:
                this.eMB.setVisibility(0);
                this.eMC.setVisibility(8);
                return;
            case 3:
                this.eMB.setVisibility(0);
                this.eMC.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aQA() {
        this.eMz.setVisibility(0);
    }

    public final void d(T t) {
        v.aiz().cK(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void T(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aQB();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aQA();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.eME != null) {
            this.eME.b(e, null);
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
        this.eLF = i;
    }

    public final int getBusinessType() {
        return this.eLF;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || w.A(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.oN(i) || com.baidu.tieba.lego.card.d.a.oN(i2)) {
            am.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.oN(i) || com.baidu.tieba.lego.card.d.a.oN(i2)) {
            am.j(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aQB() {
        am.j(this.eMD, d.C0142d.cp_bg_line_d);
        am.c(this.eMD, d.C0142d.cp_bg_line_b);
        switch (this.eLF) {
            case 1:
                this.eMB.setBackgroundColor(getResources().getColor(17170445));
                this.eMC.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                am.j(this.eMB, d.C0142d.cp_bg_line_c);
                am.j(this.eMC, d.C0142d.cp_bg_line_c);
                return;
            default:
                this.eMB.setBackgroundColor(getResources().getColor(17170445));
                this.eMC.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            am.c(textView, d.C0142d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.c(textView, d.C0142d.btn_forum_focus_color, 1);
        textView.setText(str);
        am.i(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            an anVar = new an(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    anVar.ah(split[0], split[1]);
                }
            }
            anVar.r("obj_locate", getStatPosition());
            anVar.ah("obj_param3", o.aiq());
            v.aiz().a(anVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aQC() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aQD() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aQE() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.eME = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.eMF = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aQF() {
    }
}
