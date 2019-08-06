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
    protected int heP;
    protected View hfJ;
    protected View hfK;
    protected View hfL;
    protected View hfM;
    protected ImageView hfN;
    protected a hfO;
    protected c hfP;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View bKJ();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        bKL();
        yQ();
        this.isInit = false;
    }

    protected final <S> S C(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams bKK() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void bKL() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.hfJ = bKJ();
        frameLayout.addView(this.hfJ, bKK());
        this.hfK = new View(getContext());
        am.l(this.hfK, R.color.common_color_10205);
        frameLayout.addView(this.hfK, new ViewGroup.LayoutParams(-1, -1));
        this.hfN = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        am.l(this.hfN, R.color.cp_bg_line_d);
        am.c(this.hfN, (int) R.color.cp_bg_line_b);
        this.hfL = new View(getContext());
        this.hfM = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        switch (this.heP) {
            case 1:
            case 4:
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfL, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.hfN, layoutParams2);
                addView(frameLayout, layoutParams);
                this.hfM.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfM, layoutParams3);
                return;
            case 2:
                am.l(this.hfL, R.color.cp_bg_line_c);
                addView(this.hfL, layoutParams3);
                addView(this.hfN, layoutParams2);
                addView(frameLayout, layoutParams);
                am.l(this.hfM, R.color.cp_bg_line_c);
                addView(this.hfM, layoutParams3);
                return;
            case 3:
                am.l(this.hfL, R.color.cp_bg_line_c);
                addView(this.hfL, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.hfN, layoutParams2);
                am.l(this.hfM, R.color.cp_bg_line_c);
                addView(this.hfM, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfL, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.hfN, layoutParams2);
                this.hfM.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfM, layoutParams3);
                return;
        }
    }

    protected void yQ() {
    }

    protected final void wy(int i) {
        switch (i) {
            case -1:
            case 0:
                this.hfN.setVisibility(8);
                return;
            case 1:
                this.hfN.setPadding(0, 0, 0, 0);
                this.hfN.setVisibility(0);
                return;
            case 2:
                this.hfN.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.hfN.setVisibility(0);
                return;
            case 3:
                this.hfN.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.hfN.setVisibility(0);
                return;
            default:
                this.hfN.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.hfK.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        wy(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.hfL.setVisibility(8);
                this.hfM.setVisibility(8);
                return;
            case 1:
                this.hfL.setVisibility(8);
                this.hfM.setVisibility(0);
                return;
            case 2:
                this.hfL.setVisibility(0);
                this.hfM.setVisibility(8);
                return;
            case 3:
                this.hfL.setVisibility(0);
                this.hfM.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void bKM() {
        this.hfJ.setVisibility(0);
    }

    public final void d(T t) {
        t.aZP().gS(true);
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
                bKN();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            bKM();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = s.e(this.mContext, t.getScheme());
        if (this.hfO != null) {
            this.hfO.b(e, null);
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
        this.heP = i;
    }

    public final int getBusinessType() {
        return this.heP;
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
        if (com.baidu.tieba.lego.card.d.a.ww(i) || com.baidu.tieba.lego.card.d.a.ww(i2)) {
            am.j(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void g(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ww(i) || com.baidu.tieba.lego.card.d.a.ww(i2)) {
            am.l(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void bKN() {
        am.l(this.hfN, R.color.cp_bg_line_d);
        am.c(this.hfN, (int) R.color.cp_bg_line_b);
        switch (this.heP) {
            case 1:
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                this.hfM.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                am.l(this.hfL, R.color.cp_bg_line_c);
                am.l(this.hfM, R.color.cp_bg_line_c);
                return;
            default:
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                this.hfM.setBackgroundColor(getResources().getColor(17170445));
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
            anVar.bT("obj_param3", n.aZG());
            t.aZP().c(anVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bKO() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void QN() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bKP() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void j(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.hfO = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.hfP = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bKQ() {
    }
}
