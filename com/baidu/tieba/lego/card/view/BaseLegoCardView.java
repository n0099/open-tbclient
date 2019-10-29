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
    protected TbPageContext cfl;
    protected int heO;
    protected View hfI;
    protected View hfJ;
    protected View hfK;
    protected View hfL;
    protected ImageView hfM;
    protected a hfN;
    protected c hfO;
    private boolean isInit;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View bIg();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.cfl = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        bIi();
        DP();
        this.isInit = false;
    }

    protected final <S> S r(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams bIh() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void bIi() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.hfI = bIg();
        frameLayout.addView(this.hfI, bIh());
        this.hfJ = new View(getContext());
        am.setBackgroundColor(this.hfJ, R.color.common_color_10205);
        frameLayout.addView(this.hfJ, new ViewGroup.LayoutParams(-1, -1));
        this.hfM = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        am.setBackgroundColor(this.hfM, R.color.cp_bg_line_d);
        am.setImageResource(this.hfM, R.color.cp_bg_line_c);
        this.hfK = new View(getContext());
        this.hfL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        switch (this.heO) {
            case 1:
            case 4:
                this.hfK.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfK, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.hfM, layoutParams2);
                addView(frameLayout, layoutParams);
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfL, layoutParams3);
                return;
            case 2:
                am.setBackgroundColor(this.hfK, R.color.cp_bg_line_c);
                addView(this.hfK, layoutParams3);
                addView(this.hfM, layoutParams2);
                addView(frameLayout, layoutParams);
                am.setBackgroundColor(this.hfL, R.color.cp_bg_line_c);
                addView(this.hfL, layoutParams3);
                return;
            case 3:
                am.setBackgroundColor(this.hfK, R.color.cp_bg_line_c);
                addView(this.hfK, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.hfM, layoutParams2);
                am.setBackgroundColor(this.hfL, R.color.cp_bg_line_c);
                addView(this.hfL, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.hfK.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfK, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.hfM, layoutParams2);
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.hfL, layoutParams3);
                return;
        }
    }

    protected void DP() {
    }

    protected final void vh(int i) {
        switch (i) {
            case -1:
            case 0:
                this.hfM.setVisibility(8);
                return;
            case 1:
                this.hfM.setPadding(0, 0, 0, 0);
                this.hfM.setVisibility(0);
                return;
            case 2:
                this.hfM.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.hfM.setVisibility(0);
                return;
            case 3:
                this.hfM.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.hfM.setVisibility(0);
                return;
            default:
                this.hfM.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.hfJ.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        vh(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.hfK.setVisibility(8);
                this.hfL.setVisibility(8);
                return;
            case 1:
                this.hfK.setVisibility(8);
                this.hfL.setVisibility(0);
                return;
            case 2:
                this.hfK.setVisibility(0);
                this.hfL.setVisibility(8);
                return;
            case 3:
                this.hfK.setVisibility(0);
                this.hfL.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void bIj() {
        this.hfI.setVisibility(0);
    }

    public final void d(T t) {
        t.baw().gF(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void al(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                bIk();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            bIj();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = s.e(this.cfl, t.getScheme());
        if (this.hfN != null) {
            this.hfN.b(e, null);
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
        this.heO = i;
    }

    public final int getBusinessType() {
        return this.heO;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || v.isEmpty(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.vf(i) || com.baidu.tieba.lego.card.d.a.vf(i2)) {
            am.setViewTextColor(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void f(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.vf(i) || com.baidu.tieba.lego.card.d.a.vf(i2)) {
            am.setBackgroundColor(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void bIk() {
        am.setBackgroundColor(this.hfM, R.color.cp_bg_line_d);
        am.setImageResource(this.hfM, R.color.cp_bg_line_c);
        switch (this.heO) {
            case 1:
                this.hfK.setBackgroundColor(getResources().getColor(17170445));
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                am.setBackgroundColor(this.hfK, R.color.cp_bg_line_c);
                am.setBackgroundColor(this.hfL, R.color.cp_bg_line_c);
                return;
            default:
                this.hfK.setBackgroundColor(getResources().getColor(17170445));
                this.hfL.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            am.setViewTextColor(textView, R.color.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        am.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        am.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
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
                    anVar.bS(split[0], split[1]);
                }
            }
            anVar.O("obj_locate", getStatPosition());
            anVar.bS(TiebaInitialize.Params.OBJ_PARAM3, n.ban());
            t.baw().c(anVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bIl() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void VH() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bIm() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void j(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.hfN = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.hfO = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void bIn() {
    }
}
