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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements l<T> {
    protected TbPageContext aaS;
    public String aia;
    protected int avi;
    protected int dLE;
    protected View dMC;
    protected View dMD;
    protected View dME;
    protected View dMF;
    protected ImageView dMG;
    protected a dMH;
    protected c dMI;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aCi();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aaS = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aCk();
        aCl();
        this.isInit = false;
    }

    protected final <S> S x(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aCj() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aCk() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dMC = aCi();
        frameLayout.addView(this.dMC, aCj());
        this.dMD = new View(getContext());
        ai.k(this.dMD, d.e.common_color_10205);
        frameLayout.addView(this.dMD, new ViewGroup.LayoutParams(-1, -1));
        this.dMG = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.f.ds1));
        ai.k(this.dMG, d.e.cp_bg_line_d);
        ai.c(this.dMG, d.e.cp_bg_line_b);
        this.dME = new View(getContext());
        this.dMF = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.f.ds16));
        switch (this.dLE) {
            case 1:
            case 4:
                this.dME.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dME, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.dMG, layoutParams2);
                addView(frameLayout, layoutParams);
                this.dMF.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dMF, layoutParams3);
                return;
            case 2:
                ai.k(this.dME, d.e.cp_bg_line_c);
                addView(this.dME, layoutParams3);
                addView(this.dMG, layoutParams2);
                addView(frameLayout, layoutParams);
                ai.k(this.dMF, d.e.cp_bg_line_c);
                addView(this.dMF, layoutParams3);
                return;
            case 3:
                ai.k(this.dME, d.e.cp_bg_line_c);
                addView(this.dME, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.f.ds1);
                addView(this.dMG, layoutParams2);
                ai.k(this.dMF, d.e.cp_bg_line_c);
                addView(this.dMF, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.dME.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dME, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.dMG, layoutParams2);
                this.dMF.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dMF, layoutParams3);
                return;
        }
    }

    protected void aCl() {
    }

    protected final void nc(int i) {
        switch (i) {
            case -1:
            case 0:
                this.dMG.setVisibility(8);
                return;
            case 1:
                this.dMG.setPadding(0, 0, 0, 0);
                this.dMG.setVisibility(0);
                return;
            case 2:
                this.dMG.setPadding(getResources().getDimensionPixelSize(d.f.ds24), 0, 0, 0);
                this.dMG.setVisibility(0);
                return;
            case 3:
                this.dMG.setPadding(getResources().getDimensionPixelSize(d.f.ds24), 0, getResources().getDimensionPixelSize(d.f.ds24), 0);
                this.dMG.setVisibility(0);
                return;
            default:
                this.dMG.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.dMD.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        nc(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.dME.setVisibility(8);
                this.dMF.setVisibility(8);
                return;
            case 1:
                this.dME.setVisibility(8);
                this.dMF.setVisibility(0);
                return;
            case 2:
                this.dME.setVisibility(0);
                this.dMF.setVisibility(8);
                return;
            case 3:
                this.dME.setVisibility(0);
                this.dMF.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aCm() {
        this.dMC.setVisibility(0);
    }

    public final void d(T t) {
        u.Ww().cA(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.b<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.l
    public final void M(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aCo();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aCm();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int h = n.h(this.aaS, t.getScheme());
        if (this.dMH != null) {
            this.dMH.a(h, null);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.avi + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setPosition(int i) {
        this.avi = i;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setBusinessType(int i) {
        this.dLE = i;
    }

    public final int getBusinessType() {
        return this.dLE;
    }

    public final boolean aCn() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.u.v(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
            spannableString.setSpan(new ForegroundColorSpan(aCn() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
        }
        return spannableString;
    }

    protected final String b(String str, HashMap<String, Integer> hashMap) {
        Matcher matcher = Pattern.compile("\\{(\\w+)\\}").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String str2 = "";
            if (hashMap != null && hashMap.get(group) != null) {
                str2 = al.z(hashMap.get(group).intValue());
            }
            str = str.replace(matcher.group(0), str2);
        }
        return str;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.na(i) || com.baidu.tieba.lego.card.d.a.na(i2)) {
            ai.i(textView, i3);
            return;
        }
        if (!aCn()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.na(i) || com.baidu.tieba.lego.card.d.a.na(i2)) {
            ai.k(view, i3);
            return;
        }
        if (!aCn()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aCo() {
        ai.k(this.dMG, d.e.cp_bg_line_d);
        ai.c(this.dMG, d.e.cp_bg_line_b);
        switch (this.dLE) {
            case 1:
                this.dME.setBackgroundColor(getResources().getColor(17170445));
                this.dMF.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                ai.k(this.dME, d.e.cp_bg_line_c);
                ai.k(this.dMF, d.e.cp_bg_line_c);
                return;
            default:
                this.dME.setBackgroundColor(getResources().getColor(17170445));
                this.dMF.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ai.c(textView, d.e.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ai.c(textView, d.e.btn_forum_focus_color, 1);
        textView.setText(str);
        ai.j(textView, d.g.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.f.ds18), 0, getResources().getDimensionPixelSize(d.f.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            aj ajVar = new aj(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    ajVar.aa(split[0], split[1]);
                }
            }
            ajVar.r("obj_locate", getStatPosition());
            ajVar.aa("obj_param3", m.Wn());
            u.Ww().a(ajVar);
        }
    }

    protected final void by(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            aj ajVar = new aj(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    ajVar.aa(split[0], split[1]);
                }
            }
            ajVar.r("obj_locate", getStatPosition());
            ajVar.aa("obj_param3", m.Wn());
            TiebaStatic.log(ajVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aCp() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aCq() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aCr() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setAfterClickSchemeListener(a aVar) {
        this.dMH = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void setDownloadAppCallback(c cVar) {
        this.dMI = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aCs() {
    }
}
