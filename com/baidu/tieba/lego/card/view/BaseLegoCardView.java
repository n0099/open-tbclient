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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.d.b;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected TbPageContext ehG;
    private boolean isInit;
    protected View jXO;
    protected View jXP;
    protected View jXQ;
    protected View jXR;
    protected ImageView jXS;
    protected a jXT;
    protected c jXU;
    protected int mBusinessType;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View cPW();

    public abstract void d(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.ehG = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        cPY();
        agc();
        this.isInit = false;
    }

    protected final <S> S s(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams cPX() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void cPY() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jXO = cPW();
        frameLayout.addView(this.jXO, cPX());
        this.jXP = new View(getContext());
        ap.setBackgroundColor(this.jXP, R.color.common_color_10205);
        frameLayout.addView(this.jXP, new ViewGroup.LayoutParams(-1, -1));
        this.jXS = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        ap.setBackgroundColor(this.jXS, R.color.cp_bg_line_d);
        ap.setImageResource(this.jXS, R.color.cp_bg_line_c);
        this.jXQ = new View(getContext());
        this.jXR = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        switch (this.mBusinessType) {
            case 1:
            case 4:
                this.jXQ.setBackgroundColor(getResources().getColor(17170445));
                addView(this.jXQ, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.jXS, layoutParams2);
                addView(frameLayout, layoutParams);
                this.jXR.setBackgroundColor(getResources().getColor(17170445));
                addView(this.jXR, layoutParams3);
                return;
            case 2:
                ap.setBackgroundColor(this.jXQ, R.color.cp_bg_line_c);
                addView(this.jXQ, layoutParams3);
                addView(this.jXS, layoutParams2);
                addView(frameLayout, layoutParams);
                ap.setBackgroundColor(this.jXR, R.color.cp_bg_line_c);
                addView(this.jXR, layoutParams3);
                return;
            case 3:
                ap.setBackgroundColor(this.jXQ, R.color.cp_bg_line_c);
                addView(this.jXQ, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.jXS, layoutParams2);
                ap.setBackgroundColor(this.jXR, R.color.cp_bg_line_c);
                addView(this.jXR, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.jXQ.setBackgroundColor(getResources().getColor(17170445));
                addView(this.jXQ, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.jXS, layoutParams2);
                this.jXR.setBackgroundColor(getResources().getColor(17170445));
                addView(this.jXR, layoutParams3);
                return;
        }
    }

    protected void agc() {
    }

    protected final void CQ(int i) {
        switch (i) {
            case -1:
            case 0:
                this.jXS.setVisibility(8);
                return;
            case 1:
                this.jXS.setPadding(0, 0, 0, 0);
                this.jXS.setVisibility(0);
                return;
            case 2:
                this.jXS.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.jXS.setVisibility(0);
                return;
            case 3:
                this.jXS.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.jXS.setVisibility(0);
                return;
            default:
                this.jXS.setVisibility(8);
                return;
        }
    }

    protected final void b(T t) {
        this.jXP.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        CQ(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.jXQ.setVisibility(8);
                this.jXR.setVisibility(8);
                return;
            case 1:
                this.jXQ.setVisibility(8);
                this.jXR.setVisibility(0);
                return;
            case 2:
                this.jXQ.setVisibility(0);
                this.jXR.setVisibility(8);
                return;
            case 3:
                this.jXQ.setVisibility(0);
                this.jXR.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void cPZ() {
        this.jXO.setVisibility(0);
    }

    public final void c(T t) {
        s.cfn().kO(true);
        e(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void aI(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            f((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                cQa();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            cPZ();
            d((BaseLegoCardInfo) updateCard);
            b((BaseLegoCardInfo) updateCard);
        }
    }

    public void e(T t) {
        int h = u.h(this.ehG, t.getScheme());
        if (this.jXT != null) {
            this.jXT.d(h, null);
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
        this.mBusinessType = i;
    }

    public final int getBusinessType() {
        return this.mBusinessType;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || y.isEmpty(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (b.CO(i) || b.CO(i2)) {
            ap.setViewTextColor(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void d(View view, int i, int i2, int i3) {
        if (b.CO(i) || b.CO(i2)) {
            ap.setBackgroundColor(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void cQa() {
        ap.setBackgroundColor(this.jXS, R.color.cp_bg_line_d);
        ap.setImageResource(this.jXS, R.color.cp_bg_line_c);
        switch (this.mBusinessType) {
            case 1:
                this.jXQ.setBackgroundColor(getResources().getColor(17170445));
                this.jXR.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                ap.setBackgroundColor(this.jXQ, R.color.cp_bg_line_c);
                ap.setBackgroundColor(this.jXR, R.color.cp_bg_line_c);
                return;
            default:
                this.jXQ.setBackgroundColor(getResources().getColor(17170445));
                this.jXR.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ap.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        ap.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.ds18), 0, getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    protected final void f(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            aq aqVar = new aq(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    aqVar.dF(split[0], split[1]);
                }
            }
            aqVar.ai("obj_locate", getStatPosition());
            aqVar.dF(TiebaInitialize.Params.OBJ_PARAM3, m.cfe());
            s.cfn().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cQb() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aKJ() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cCW() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.jXT = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.jXU = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cQc() {
    }
}
