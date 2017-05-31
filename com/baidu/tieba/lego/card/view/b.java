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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.at;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements am<T> {
    protected TbPageContext aas;
    public String agW;
    protected int atn;
    protected int duo;
    protected View dvm;
    protected View dvn;
    protected View dvo;
    protected View dvp;
    protected ImageView dvq;
    protected a dvr;
    protected c dvs;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View awH();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aas = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        awJ();
        awK();
        this.isInit = false;
    }

    protected final <S> S w(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams awI() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void awJ() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dvm = awH();
        frameLayout.addView(this.dvm, awI());
        this.dvn = new View(getContext());
        aq.k(this.dvn, w.e.common_color_10205);
        frameLayout.addView(this.dvn, new ViewGroup.LayoutParams(-1, -1));
        this.dvq = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds1));
        aq.k(this.dvq, w.e.cp_bg_line_d);
        aq.c(this.dvq, w.e.cp_bg_line_b);
        this.dvo = new View(getContext());
        this.dvp = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds16));
        switch (this.duo) {
            case 1:
            case 4:
                this.dvo.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvo, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.dvq, layoutParams2);
                addView(frameLayout, layoutParams);
                this.dvp.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvp, layoutParams3);
                return;
            case 2:
                aq.k(this.dvo, w.e.cp_bg_line_c);
                addView(this.dvo, layoutParams3);
                addView(this.dvq, layoutParams2);
                addView(frameLayout, layoutParams);
                aq.k(this.dvp, w.e.cp_bg_line_c);
                addView(this.dvp, layoutParams3);
                return;
            case 3:
                aq.k(this.dvo, w.e.cp_bg_line_c);
                addView(this.dvo, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(w.f.ds1);
                addView(this.dvq, layoutParams2);
                aq.k(this.dvp, w.e.cp_bg_line_c);
                addView(this.dvp, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.dvo.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvo, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.dvq, layoutParams2);
                this.dvp.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvp, layoutParams3);
                return;
        }
    }

    protected void awK() {
    }

    protected final void mI(int i) {
        switch (i) {
            case -1:
            case 0:
                this.dvq.setVisibility(8);
                return;
            case 1:
                this.dvq.setPadding(0, 0, 0, 0);
                this.dvq.setVisibility(0);
                return;
            case 2:
                this.dvq.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, 0, 0);
                this.dvq.setVisibility(0);
                return;
            case 3:
                this.dvq.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, getResources().getDimensionPixelSize(w.f.ds24), 0);
                this.dvq.setVisibility(0);
                return;
            default:
                this.dvq.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.dvn.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        mI(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.dvo.setVisibility(8);
                this.dvp.setVisibility(8);
                return;
            case 1:
                this.dvo.setVisibility(8);
                this.dvp.setVisibility(0);
                return;
            case 2:
                this.dvo.setVisibility(0);
                this.dvp.setVisibility(8);
                return;
            case 3:
                this.dvo.setVisibility(0);
                this.dvp.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void awL() {
        this.dvm.setVisibility(0);
    }

    public final void d(T t) {
        cf.Uw().ds(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.b<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.am
    public final void M(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                awN();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            awL();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int h = s.h(this.aas, t.getScheme());
        if (this.dvr != null) {
            this.dvr.iH(h);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.atn + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setPosition(int i) {
        this.atn = i;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setBusinessType(int i) {
        this.duo = i;
    }

    public final int getBusinessType() {
        return this.duo;
    }

    public final boolean awM() {
        return 1 == TbadkCoreApplication.m9getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && !x.r(list) && (indexOf = str.indexOf("{%s}", 0)) >= 0) {
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
                spannableString.setSpan(new ForegroundColorSpan(awM() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
            }
            return spannableString;
        }
        return null;
    }

    protected final String b(String str, HashMap<String, Integer> hashMap) {
        Matcher matcher = Pattern.compile("\\{(\\w+)\\}").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String str2 = "";
            if (hashMap != null && hashMap.get(group) != null) {
                str2 = au.x(hashMap.get(group).intValue());
            }
            str = str.replace(matcher.group(0), str2);
        }
        return str;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.mG(i) || com.baidu.tieba.lego.card.d.a.mG(i2)) {
            aq.i(textView, i3);
            return;
        }
        if (!awM()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.mG(i) || com.baidu.tieba.lego.card.d.a.mG(i2)) {
            aq.k(view, i3);
            return;
        }
        if (!awM()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void awN() {
        aq.k(this.dvq, w.e.cp_bg_line_d);
        aq.c(this.dvq, w.e.cp_bg_line_b);
        switch (this.duo) {
            case 1:
                this.dvo.setBackgroundColor(getResources().getColor(17170445));
                this.dvp.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aq.k(this.dvo, w.e.cp_bg_line_c);
                aq.k(this.dvp, w.e.cp_bg_line_c);
                return;
            default:
                this.dvo.setBackgroundColor(getResources().getColor(17170445));
                this.dvp.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            aq.c(textView, w.e.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aq.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(str);
        aq.j(textView, w.g.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(w.f.ds18), 0, getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            as asVar = new as(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    asVar.Z(split[0], split[1]);
                }
            }
            asVar.r("obj_locate", getStatPosition());
            asVar.Z("obj_param3", at.Up());
            cf.Uw().a(asVar);
        }
    }

    protected final void br(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    asVar.Z(split[0], split[1]);
                }
            }
            asVar.r("obj_locate", getStatPosition());
            asVar.Z("obj_param3", at.Up());
            TiebaStatic.log(asVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void awO() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void awP() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void awQ() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setAfterClickSchemeListener(a aVar) {
        this.dvr = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void setDownloadAppCallback(c cVar) {
        this.dvs = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void awR() {
    }
}
