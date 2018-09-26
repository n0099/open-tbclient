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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected int eWQ;
    protected View eXK;
    protected View eXL;
    protected View eXM;
    protected View eXN;
    protected ImageView eXO;
    protected a eXP;
    protected c eXQ;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aTI();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aTK();
        aTL();
        this.isInit = false;
    }

    protected final <S> S u(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aTJ() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aTK() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eXK = aTI();
        frameLayout.addView(this.eXK, aTJ());
        this.eXL = new View(getContext());
        al.j(this.eXL, e.d.common_color_10205);
        frameLayout.addView(this.eXL, new ViewGroup.LayoutParams(-1, -1));
        this.eXO = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0141e.ds1));
        al.j(this.eXO, e.d.cp_bg_line_d);
        al.c(this.eXO, e.d.cp_bg_line_b);
        this.eXM = new View(getContext());
        this.eXN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0141e.ds16));
        switch (this.eWQ) {
            case 1:
            case 4:
                this.eXM.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eXM, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.eXO, layoutParams2);
                addView(frameLayout, layoutParams);
                this.eXN.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eXN, layoutParams3);
                return;
            case 2:
                al.j(this.eXM, e.d.cp_bg_line_c);
                addView(this.eXM, layoutParams3);
                addView(this.eXO, layoutParams2);
                addView(frameLayout, layoutParams);
                al.j(this.eXN, e.d.cp_bg_line_c);
                addView(this.eXN, layoutParams3);
                return;
            case 3:
                al.j(this.eXM, e.d.cp_bg_line_c);
                addView(this.eXM, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(e.C0141e.ds1);
                addView(this.eXO, layoutParams2);
                al.j(this.eXN, e.d.cp_bg_line_c);
                addView(this.eXN, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.eXM.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eXM, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.eXO, layoutParams2);
                this.eXN.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eXN, layoutParams3);
                return;
        }
    }

    protected void aTL() {
    }

    protected final void pI(int i) {
        switch (i) {
            case -1:
            case 0:
                this.eXO.setVisibility(8);
                return;
            case 1:
                this.eXO.setPadding(0, 0, 0, 0);
                this.eXO.setVisibility(0);
                return;
            case 2:
                this.eXO.setPadding(getResources().getDimensionPixelSize(e.C0141e.ds24), 0, 0, 0);
                this.eXO.setVisibility(0);
                return;
            case 3:
                this.eXO.setPadding(getResources().getDimensionPixelSize(e.C0141e.ds24), 0, getResources().getDimensionPixelSize(e.C0141e.ds24), 0);
                this.eXO.setVisibility(0);
                return;
            default:
                this.eXO.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.eXL.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        pI(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.eXM.setVisibility(8);
                this.eXN.setVisibility(8);
                return;
            case 1:
                this.eXM.setVisibility(8);
                this.eXN.setVisibility(0);
                return;
            case 2:
                this.eXM.setVisibility(0);
                this.eXN.setVisibility(8);
                return;
            case 3:
                this.eXM.setVisibility(0);
                this.eXN.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aTM() {
        this.eXK.setVisibility(0);
    }

    public final void d(T t) {
        v.akM().dc(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void W(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aTN();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aTM();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.eXP != null) {
            this.eXP.b(e, null);
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
        this.eWQ = i;
    }

    public final int getBusinessType() {
        return this.eWQ;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.v.z(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.pG(i) || com.baidu.tieba.lego.card.d.a.pG(i2)) {
            al.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.pG(i) || com.baidu.tieba.lego.card.d.a.pG(i2)) {
            al.j(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aTN() {
        al.j(this.eXO, e.d.cp_bg_line_d);
        al.c(this.eXO, e.d.cp_bg_line_b);
        switch (this.eWQ) {
            case 1:
                this.eXM.setBackgroundColor(getResources().getColor(17170445));
                this.eXN.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                al.j(this.eXM, e.d.cp_bg_line_c);
                al.j(this.eXN, e.d.cp_bg_line_c);
                return;
            default:
                this.eXM.setBackgroundColor(getResources().getColor(17170445));
                this.eXN.setBackgroundColor(getResources().getColor(17170445));
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
        textView.setPadding(getResources().getDimensionPixelSize(e.C0141e.ds18), 0, getResources().getDimensionPixelSize(e.C0141e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            am amVar = new am(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    amVar.al(split[0], split[1]);
                }
            }
            amVar.w("obj_locate", getStatPosition());
            amVar.al("obj_param3", o.akD());
            v.akM().a(amVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aTO() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aTP() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aTQ() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.eXP = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.eXQ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aTR() {
    }
}
