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
import com.baidu.tieba.card.cc;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class p<T extends BaseLegoCardInfo> extends LinearLayout implements bl<T> {
    protected TbPageContext aaI;
    public String ahy;
    protected int ath;
    protected int duE;
    protected c dwM;
    protected View dwN;
    protected View dwO;
    protected View dwP;
    protected View dwQ;
    protected ImageView dwR;
    protected a dwS;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View ayf();

    public abstract void b(T t);

    public p(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aaI = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        ayj();
        ayk();
        this.isInit = false;
    }

    protected final <S> S y(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams ayi() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void ayj() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dwN = ayf();
        frameLayout.addView(this.dwN, ayi());
        this.dwO = new View(getContext());
        aq.k(this.dwO, w.e.common_color_10205);
        frameLayout.addView(this.dwO, new ViewGroup.LayoutParams(-1, -1));
        this.dwR = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds1));
        aq.k(this.dwR, w.e.cp_bg_line_d);
        aq.c(this.dwR, w.e.cp_bg_line_b);
        this.dwP = new View(getContext());
        this.dwQ = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds16));
        switch (this.duE) {
            case 1:
            case 4:
                this.dwP.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dwP, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.dwR, layoutParams2);
                addView(frameLayout, layoutParams);
                this.dwQ.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dwQ, layoutParams3);
                return;
            case 2:
                aq.k(this.dwP, w.e.cp_bg_line_c);
                addView(this.dwP, layoutParams3);
                addView(this.dwR, layoutParams2);
                addView(frameLayout, layoutParams);
                aq.k(this.dwQ, w.e.cp_bg_line_c);
                addView(this.dwQ, layoutParams3);
                return;
            case 3:
                aq.k(this.dwP, w.e.cp_bg_line_c);
                addView(this.dwP, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(w.f.ds1);
                addView(this.dwR, layoutParams2);
                aq.k(this.dwQ, w.e.cp_bg_line_c);
                addView(this.dwQ, layoutParams3);
                return;
            default:
                this.dwP.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dwP, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.dwR, layoutParams2);
                this.dwQ.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dwQ, layoutParams3);
                return;
        }
    }

    protected void ayk() {
    }

    protected final void mw(int i) {
        switch (i) {
            case -1:
            case 0:
                this.dwR.setVisibility(8);
                return;
            case 1:
                this.dwR.setPadding(0, 0, 0, 0);
                this.dwR.setVisibility(0);
                return;
            case 2:
                this.dwR.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, 0, 0);
                this.dwR.setVisibility(0);
                return;
            case 3:
                this.dwR.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, getResources().getDimensionPixelSize(w.f.ds24), 0);
                this.dwR.setVisibility(0);
                return;
            default:
                this.dwR.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.dwO.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        mw(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.dwP.setVisibility(8);
                this.dwQ.setVisibility(8);
                return;
            case 1:
                this.dwP.setVisibility(8);
                this.dwQ.setVisibility(0);
                return;
            case 2:
                this.dwP.setVisibility(0);
                this.dwQ.setVisibility(8);
                return;
            case 3:
                this.dwP.setVisibility(0);
                this.dwQ.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void ayl() {
        this.dwN.setVisibility(0);
    }

    public final void d(T t) {
        cc.Sv().cM(true);
        e(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.p<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.bl
    public final void N(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            f((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                ayn();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            ayl();
            b((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void e(T t) {
        int i = t.i(this.aaI, t.getScheme());
        if (this.dwS != null) {
            this.dwS.ik(i);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.ath + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public final void setPosition(int i) {
        this.ath = i;
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public final void setBusinessType(int i) {
        this.duE = i;
    }

    public final int getBusinessType() {
        return this.duE;
    }

    public final boolean aym() {
        return 1 == TbadkCoreApplication.m9getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && !x.q(list) && (indexOf = str.indexOf("{%s}", 0)) >= 0) {
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
                spannableString.setSpan(new ForegroundColorSpan(aym() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
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
                str2 = au.w(hashMap.get(group).intValue());
            }
            str = str.replace(matcher.group(0), str2);
        }
        return str;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.c.a.mu(i) || com.baidu.tieba.lego.card.c.a.mu(i2)) {
            aq.i((View) textView, i3);
            return;
        }
        if (!aym()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.c.a.mu(i) || com.baidu.tieba.lego.card.c.a.mu(i2)) {
            aq.k(view, i3);
            return;
        }
        if (!aym()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void ayn() {
        aq.k(this.dwR, w.e.cp_bg_line_d);
        aq.c(this.dwR, w.e.cp_bg_line_b);
        switch (this.duE) {
            case 1:
                this.dwP.setBackgroundColor(getResources().getColor(17170445));
                this.dwQ.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aq.k(this.dwP, w.e.cp_bg_line_c);
                aq.k(this.dwQ, w.e.cp_bg_line_c);
                return;
            default:
                this.dwP.setBackgroundColor(getResources().getColor(17170445));
                this.dwQ.setBackgroundColor(getResources().getColor(17170445));
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

    protected final void f(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            as asVar = new as(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    asVar.Z(split[0], split[1]);
                }
            }
            asVar.s("obj_locate", getStatPosition());
            asVar.Z("obj_param3", at.Sp());
            cc.Sv().a(asVar);
        }
    }

    protected final void bq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    asVar.Z(split[0], split[1]);
                }
            }
            asVar.s("obj_locate", getStatPosition());
            asVar.Z("obj_param3", at.Sp());
            TiebaStatic.log(asVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public void ayo() {
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public void ayp() {
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public void ayq() {
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public final void setAfterClickSchemeListener(a aVar) {
        this.dwS = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public void setDownloadAppCallback(c cVar) {
        this.dwM = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.bl
    public void ayh() {
    }
}
