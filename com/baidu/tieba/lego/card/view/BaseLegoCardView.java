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
    protected int eHO;
    protected View eII;
    protected View eIJ;
    protected View eIK;
    protected View eIL;
    protected ImageView eIM;
    protected a eIN;
    protected c eIO;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aPQ();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aPS();
        aPT();
        this.isInit = false;
    }

    protected final <S> S r(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aPR() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aPS() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eII = aPQ();
        frameLayout.addView(this.eII, aPR());
        this.eIJ = new View(getContext());
        al.j(this.eIJ, d.C0141d.common_color_10205);
        frameLayout.addView(this.eIJ, new ViewGroup.LayoutParams(-1, -1));
        this.eIM = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        al.j(this.eIM, d.C0141d.cp_bg_line_d);
        al.c(this.eIM, d.C0141d.cp_bg_line_b);
        this.eIK = new View(getContext());
        this.eIL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.eHO) {
            case 1:
            case 4:
                this.eIK.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eIK, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.eIM, layoutParams2);
                addView(frameLayout, layoutParams);
                this.eIL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eIL, layoutParams3);
                return;
            case 2:
                al.j(this.eIK, d.C0141d.cp_bg_line_c);
                addView(this.eIK, layoutParams3);
                addView(this.eIM, layoutParams2);
                addView(frameLayout, layoutParams);
                al.j(this.eIL, d.C0141d.cp_bg_line_c);
                addView(this.eIL, layoutParams3);
                return;
            case 3:
                al.j(this.eIK, d.C0141d.cp_bg_line_c);
                addView(this.eIK, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.eIM, layoutParams2);
                al.j(this.eIL, d.C0141d.cp_bg_line_c);
                addView(this.eIL, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.eIK.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eIK, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.eIM, layoutParams2);
                this.eIL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eIL, layoutParams3);
                return;
        }
    }

    protected void aPT() {
    }

    protected final void oI(int i) {
        switch (i) {
            case -1:
            case 0:
                this.eIM.setVisibility(8);
                return;
            case 1:
                this.eIM.setPadding(0, 0, 0, 0);
                this.eIM.setVisibility(0);
                return;
            case 2:
                this.eIM.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.eIM.setVisibility(0);
                return;
            case 3:
                this.eIM.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.eIM.setVisibility(0);
                return;
            default:
                this.eIM.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.eIJ.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        oI(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.eIK.setVisibility(8);
                this.eIL.setVisibility(8);
                return;
            case 1:
                this.eIK.setVisibility(8);
                this.eIL.setVisibility(0);
                return;
            case 2:
                this.eIK.setVisibility(0);
                this.eIL.setVisibility(8);
                return;
            case 3:
                this.eIK.setVisibility(0);
                this.eIL.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aPU() {
        this.eII.setVisibility(0);
    }

    public final void d(T t) {
        v.ajh().cG(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void R(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aPV();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aPU();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.eIN != null) {
            this.eIN.b(e, null);
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
        this.eHO = i;
    }

    public final int getBusinessType() {
        return this.eHO;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || w.z(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.oG(i) || com.baidu.tieba.lego.card.d.a.oG(i2)) {
            al.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.oG(i) || com.baidu.tieba.lego.card.d.a.oG(i2)) {
            al.j(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aPV() {
        al.j(this.eIM, d.C0141d.cp_bg_line_d);
        al.c(this.eIM, d.C0141d.cp_bg_line_b);
        switch (this.eHO) {
            case 1:
                this.eIK.setBackgroundColor(getResources().getColor(17170445));
                this.eIL.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                al.j(this.eIK, d.C0141d.cp_bg_line_c);
                al.j(this.eIL, d.C0141d.cp_bg_line_c);
                return;
            default:
                this.eIK.setBackgroundColor(getResources().getColor(17170445));
                this.eIL.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            al.c(textView, d.C0141d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        al.c(textView, d.C0141d.btn_forum_focus_color, 1);
        textView.setText(str);
        al.i(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            am amVar = new am(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    amVar.ah(split[0], split[1]);
                }
            }
            amVar.r("obj_locate", getStatPosition());
            amVar.ah("obj_param3", o.aiY());
            v.ajh().a(amVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aPW() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aPX() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aPY() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.eIN = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.eIO = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aPZ() {
    }
}
