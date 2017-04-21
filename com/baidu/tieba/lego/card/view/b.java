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
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements am<T> {
    protected TbPageContext aaY;
    public String ahN;
    protected int atz;
    protected int duM;
    protected View dvK;
    protected View dvL;
    protected View dvM;
    protected View dvN;
    protected ImageView dvO;
    protected a dvP;
    protected c dvQ;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View ayQ();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aaY = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        ayS();
        ayT();
        this.isInit = false;
    }

    protected final <S> S x(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams ayR() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void ayS() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dvK = ayQ();
        frameLayout.addView(this.dvK, ayR());
        this.dvL = new View(getContext());
        aq.k(this.dvL, w.e.common_color_10205);
        frameLayout.addView(this.dvL, new ViewGroup.LayoutParams(-1, -1));
        this.dvO = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds1));
        aq.k(this.dvO, w.e.cp_bg_line_d);
        aq.c(this.dvO, w.e.cp_bg_line_b);
        this.dvM = new View(getContext());
        this.dvN = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds16));
        switch (this.duM) {
            case 1:
            case 4:
                this.dvM.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvM, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.dvO, layoutParams2);
                addView(frameLayout, layoutParams);
                this.dvN.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvN, layoutParams3);
                return;
            case 2:
                aq.k(this.dvM, w.e.cp_bg_line_c);
                addView(this.dvM, layoutParams3);
                addView(this.dvO, layoutParams2);
                addView(frameLayout, layoutParams);
                aq.k(this.dvN, w.e.cp_bg_line_c);
                addView(this.dvN, layoutParams3);
                return;
            case 3:
                aq.k(this.dvM, w.e.cp_bg_line_c);
                addView(this.dvM, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(w.f.ds1);
                addView(this.dvO, layoutParams2);
                aq.k(this.dvN, w.e.cp_bg_line_c);
                addView(this.dvN, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.dvM.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvM, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.dvO, layoutParams2);
                this.dvN.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dvN, layoutParams3);
                return;
        }
    }

    protected void ayT() {
    }

    protected final void mB(int i) {
        switch (i) {
            case -1:
            case 0:
                this.dvO.setVisibility(8);
                return;
            case 1:
                this.dvO.setPadding(0, 0, 0, 0);
                this.dvO.setVisibility(0);
                return;
            case 2:
                this.dvO.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, 0, 0);
                this.dvO.setVisibility(0);
                return;
            case 3:
                this.dvO.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, getResources().getDimensionPixelSize(w.f.ds24), 0);
                this.dvO.setVisibility(0);
                return;
            default:
                this.dvO.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.dvL.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        mB(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.dvM.setVisibility(8);
                this.dvN.setVisibility(8);
                return;
            case 1:
                this.dvM.setVisibility(8);
                this.dvN.setVisibility(0);
                return;
            case 2:
                this.dvM.setVisibility(0);
                this.dvN.setVisibility(8);
                return;
            case 3:
                this.dvM.setVisibility(0);
                this.dvN.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void ayU() {
        this.dvK.setVisibility(0);
    }

    public final void d(T t) {
        cc.TV().cY(true);
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
                ayW();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            ayU();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int i = t.i(this.aaY, t.getScheme());
        if (this.dvP != null) {
            this.dvP.it(i);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.atz + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setPosition(int i) {
        this.atz = i;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setBusinessType(int i) {
        this.duM = i;
    }

    public final int getBusinessType() {
        return this.duM;
    }

    public final boolean ayV() {
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
                spannableString.setSpan(new ForegroundColorSpan(ayV() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
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
        if (com.baidu.tieba.lego.card.d.a.mz(i) || com.baidu.tieba.lego.card.d.a.mz(i2)) {
            aq.i(textView, i3);
            return;
        }
        if (!ayV()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.mz(i) || com.baidu.tieba.lego.card.d.a.mz(i2)) {
            aq.k(view, i3);
            return;
        }
        if (!ayV()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void ayW() {
        aq.k(this.dvO, w.e.cp_bg_line_d);
        aq.c(this.dvO, w.e.cp_bg_line_b);
        switch (this.duM) {
            case 1:
                this.dvM.setBackgroundColor(getResources().getColor(17170445));
                this.dvN.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aq.k(this.dvM, w.e.cp_bg_line_c);
                aq.k(this.dvN, w.e.cp_bg_line_c);
                return;
            default:
                this.dvM.setBackgroundColor(getResources().getColor(17170445));
                this.dvN.setBackgroundColor(getResources().getColor(17170445));
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
                    asVar.aa(split[0], split[1]);
                }
            }
            asVar.s("obj_locate", getStatPosition());
            asVar.aa("obj_param3", at.TP());
            cc.TV().a(asVar);
        }
    }

    protected final void bt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    asVar.aa(split[0], split[1]);
                }
            }
            asVar.s("obj_locate", getStatPosition());
            asVar.aa("obj_param3", at.TP());
            TiebaStatic.log(asVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void ayX() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void ayY() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void ayZ() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setAfterClickSchemeListener(a aVar) {
        this.dvP = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void setDownloadAppCallback(c cVar) {
        this.dvQ = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void aza() {
    }
}
