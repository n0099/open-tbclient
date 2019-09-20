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
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.card.n;
import com.baidu.tieba.card.t;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected int hgJ;
    protected View hhD;
    protected View hhE;
    protected View hhF;
    protected View hhG;
    protected ImageView hhH;
    protected a hhI;
    protected c hhJ;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View bLw();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        bLy();
        yU();
        this.isInit = false;
    }

    protected final <S> S C(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams bLx() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void bLy() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.hhD = bLw();
        frameLayout.addView(this.hhD, bLx());
        this.hhE = new View(getContext());
        am.l(this.hhE, R.color.common_color_10205);
        frameLayout.addView(this.hhE, new ViewGroup.LayoutParams(-1, -1));
        this.hhH = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        am.l(this.hhH, R.color.cp_bg_line_d);
        am.c(this.hhH, (int) R.color.cp_bg_line_c);
        this.hhF = new View(getContext());
        this.hhG = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        switch (this.hgJ) {
            case 1:
            case 4:
                this.hhF.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hhF, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.hhH, layoutParams2);
                addView(frameLayout, layoutParams);
                this.hhG.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hhG, layoutParams3);
                return;
            case 2:
                am.l(this.hhF, R.color.cp_bg_line_c);
                addView(this.hhF, layoutParams3);
                addView(this.hhH, layoutParams2);
                addView(frameLayout, layoutParams);
                am.l(this.hhG, R.color.cp_bg_line_c);
                addView(this.hhG, layoutParams3);
                return;
            case 3:
                am.l(this.hhF, R.color.cp_bg_line_c);
                addView(this.hhF, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.hhH, layoutParams2);
                am.l(this.hhG, R.color.cp_bg_line_c);
                addView(this.hhG, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.hhF.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hhF, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.hhH, layoutParams2);
                this.hhG.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hhG, layoutParams3);
                return;
        }
    }

    protected void yU() {
    }

    protected final void wB(int i) {
        switch (i) {
            case -1:
            case 0:
                this.hhH.setVisibility(8);
                return;
            case 1:
                this.hhH.setPadding(0, 0, 0, 0);
                this.hhH.setVisibility(0);
                return;
            case 2:
                this.hhH.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.hhH.setVisibility(0);
                return;
            case 3:
                this.hhH.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.hhH.setVisibility(0);
                return;
            default:
                this.hhH.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.hhE.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        wB(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.hhF.setVisibility(8);
                this.hhG.setVisibility(8);
                return;
            case 1:
                this.hhF.setVisibility(8);
                this.hhG.setVisibility(0);
                return;
            case 2:
                this.hhF.setVisibility(0);
                this.hhG.setVisibility(8);
                return;
            case 3:
                this.hhF.setVisibility(0);
                this.hhG.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void bLz() {
        this.hhD.setVisibility(0);
    }

    public final void d(T t) {
        t.bat().gV(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void ao(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                bLA();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            bLz();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = s.e(this.mContext, t.getScheme());
        if (this.hhI != null) {
            this.hhI.b(e, null);
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
        this.hgJ = i;
    }

    public final int getBusinessType() {
        return this.hgJ;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || v.aa(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.wz(i) || com.baidu.tieba.lego.card.d.a.wz(i2)) {
            am.j(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void h(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.wz(i) || com.baidu.tieba.lego.card.d.a.wz(i2)) {
            am.l(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void bLA() {
        am.l(this.hhH, R.color.cp_bg_line_d);
        am.c(this.hhH, (int) R.color.cp_bg_line_c);
        switch (this.hgJ) {
            case 1:
                this.hhF.setBackgroundColor(getResources().getColor(17170445));
                this.hhG.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                am.l(this.hhF, R.color.cp_bg_line_c);
                am.l(this.hhG, R.color.cp_bg_line_c);
                return;
            default:
                this.hhF.setBackgroundColor(getResources().getColor(17170445));
                this.hhG.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            am.f(textView, R.color.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.f(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        am.k(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.ds18), 0, getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            an anVar = new an(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    anVar.bT(split[0], split[1]);
                }
            }
            anVar.P("obj_locate", getStatPosition());
            anVar.bT("obj_param3", n.bak());
            t.bat().c(anVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bLB() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void QR() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bLC() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void j(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.hhI = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.hhJ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bLD() {
    }
}
