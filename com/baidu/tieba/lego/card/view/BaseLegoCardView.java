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
import com.baidu.tieba.card.o;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected int fmJ;
    protected View fnD;
    protected View fnE;
    protected View fnF;
    protected View fnG;
    protected ImageView fnH;
    protected a fnI;
    protected c fnJ;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aYk();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aYm();
        postInit();
        this.isInit = false;
    }

    protected final <S> S v(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aYl() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aYm() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fnD = aYk();
        frameLayout.addView(this.fnD, aYl());
        this.fnE = new View(getContext());
        al.j(this.fnE, e.d.common_color_10205);
        frameLayout.addView(this.fnE, new ViewGroup.LayoutParams(-1, -1));
        this.fnH = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds1));
        al.j(this.fnH, e.d.cp_bg_line_d);
        al.c(this.fnH, e.d.cp_bg_line_b);
        this.fnF = new View(getContext());
        this.fnG = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds16));
        switch (this.fmJ) {
            case 1:
            case 4:
                this.fnF.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fnF, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.fnH, layoutParams2);
                addView(frameLayout, layoutParams);
                this.fnG.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fnG, layoutParams3);
                return;
            case 2:
                al.j(this.fnF, e.d.cp_bg_line_c);
                addView(this.fnF, layoutParams3);
                addView(this.fnH, layoutParams2);
                addView(frameLayout, layoutParams);
                al.j(this.fnG, e.d.cp_bg_line_c);
                addView(this.fnG, layoutParams3);
                return;
            case 3:
                al.j(this.fnF, e.d.cp_bg_line_c);
                addView(this.fnF, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.ds1);
                addView(this.fnH, layoutParams2);
                al.j(this.fnG, e.d.cp_bg_line_c);
                addView(this.fnG, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.fnF.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fnF, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.fnH, layoutParams2);
                this.fnG.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fnG, layoutParams3);
                return;
        }
    }

    protected void postInit() {
    }

    protected final void qT(int i) {
        switch (i) {
            case -1:
            case 0:
                this.fnH.setVisibility(8);
                return;
            case 1:
                this.fnH.setPadding(0, 0, 0, 0);
                this.fnH.setVisibility(0);
                return;
            case 2:
                this.fnH.setPadding(getResources().getDimensionPixelSize(e.C0210e.ds24), 0, 0, 0);
                this.fnH.setVisibility(0);
                return;
            case 3:
                this.fnH.setPadding(getResources().getDimensionPixelSize(e.C0210e.ds24), 0, getResources().getDimensionPixelSize(e.C0210e.ds24), 0);
                this.fnH.setVisibility(0);
                return;
            default:
                this.fnH.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.fnE.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        qT(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.fnF.setVisibility(8);
                this.fnG.setVisibility(8);
                return;
            case 1:
                this.fnF.setVisibility(8);
                this.fnG.setVisibility(0);
                return;
            case 2:
                this.fnF.setVisibility(0);
                this.fnG.setVisibility(8);
                return;
            case 3:
                this.fnF.setVisibility(0);
                this.fnG.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aYn() {
        this.fnD.setVisibility(0);
    }

    public final void d(T t) {
        v.apD().dQ(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void Z(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aYo();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aYn();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.fnI != null) {
            this.fnI.b(e, null);
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
        this.fmJ = i;
    }

    public final int getBusinessType() {
        return this.fmJ;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.v.I(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.qR(i) || com.baidu.tieba.lego.card.d.a.qR(i2)) {
            al.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.qR(i) || com.baidu.tieba.lego.card.d.a.qR(i2)) {
            al.j(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aYo() {
        al.j(this.fnH, e.d.cp_bg_line_d);
        al.c(this.fnH, e.d.cp_bg_line_b);
        switch (this.fmJ) {
            case 1:
                this.fnF.setBackgroundColor(getResources().getColor(17170445));
                this.fnG.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                al.j(this.fnF, e.d.cp_bg_line_c);
                al.j(this.fnG, e.d.cp_bg_line_c);
                return;
            default:
                this.fnF.setBackgroundColor(getResources().getColor(17170445));
                this.fnG.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            al.c(textView, e.d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.c(textView, e.d.btn_forum_focus_color, 1);
        textView.setText(str);
        al.i(textView, e.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(e.C0210e.ds18), 0, getResources().getDimensionPixelSize(e.C0210e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            am amVar = new am(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    amVar.aA(split[0], split[1]);
                }
            }
            amVar.x("obj_locate", getStatPosition());
            amVar.aA("obj_param3", o.apu());
            v.apD().a(amVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aYp() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aYq() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aYr() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.fnI = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.fnJ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aYs() {
    }
}
