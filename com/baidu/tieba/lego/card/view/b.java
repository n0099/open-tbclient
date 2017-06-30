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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
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
    protected TbPageContext aat;
    public String ahE;
    protected int auq;
    protected View dDZ;
    protected int dDb;
    protected View dEa;
    protected View dEb;
    protected View dEc;
    protected ImageView dEd;
    protected a dEe;
    protected c dEf;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aAF();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aat = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aAH();
        aAI();
        this.isInit = false;
    }

    protected final <S> S w(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aAG() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aAH() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dDZ = aAF();
        frameLayout.addView(this.dDZ, aAG());
        this.dEa = new View(getContext());
        as.k(this.dEa, w.e.common_color_10205);
        frameLayout.addView(this.dEa, new ViewGroup.LayoutParams(-1, -1));
        this.dEd = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds1));
        as.k(this.dEd, w.e.cp_bg_line_d);
        as.c(this.dEd, w.e.cp_bg_line_b);
        this.dEb = new View(getContext());
        this.dEc = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds16));
        switch (this.dDb) {
            case 1:
            case 4:
                this.dEb.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dEb, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.dEd, layoutParams2);
                addView(frameLayout, layoutParams);
                this.dEc.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dEc, layoutParams3);
                return;
            case 2:
                as.k(this.dEb, w.e.cp_bg_line_c);
                addView(this.dEb, layoutParams3);
                addView(this.dEd, layoutParams2);
                addView(frameLayout, layoutParams);
                as.k(this.dEc, w.e.cp_bg_line_c);
                addView(this.dEc, layoutParams3);
                return;
            case 3:
                as.k(this.dEb, w.e.cp_bg_line_c);
                addView(this.dEb, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(w.f.ds1);
                addView(this.dEd, layoutParams2);
                as.k(this.dEc, w.e.cp_bg_line_c);
                addView(this.dEc, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.dEb.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dEb, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.dEd, layoutParams2);
                this.dEc.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dEc, layoutParams3);
                return;
        }
    }

    protected void aAI() {
    }

    protected final void mU(int i) {
        switch (i) {
            case -1:
            case 0:
                this.dEd.setVisibility(8);
                return;
            case 1:
                this.dEd.setPadding(0, 0, 0, 0);
                this.dEd.setVisibility(0);
                return;
            case 2:
                this.dEd.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, 0, 0);
                this.dEd.setVisibility(0);
                return;
            case 3:
                this.dEd.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, getResources().getDimensionPixelSize(w.f.ds24), 0);
                this.dEd.setVisibility(0);
                return;
            default:
                this.dEd.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.dEa.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        mU(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.dEb.setVisibility(8);
                this.dEc.setVisibility(8);
                return;
            case 1:
                this.dEb.setVisibility(8);
                this.dEc.setVisibility(0);
                return;
            case 2:
                this.dEb.setVisibility(0);
                this.dEc.setVisibility(8);
                return;
            case 3:
                this.dEb.setVisibility(0);
                this.dEc.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aAJ() {
        this.dDZ.setVisibility(0);
    }

    public final void d(T t) {
        cf.VN().cw(true);
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
                aAL();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aAJ();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int h = s.h(this.aat, t.getScheme());
        if (this.dEe != null) {
            this.dEe.iT(h);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.auq + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setPosition(int i) {
        this.auq = i;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setBusinessType(int i) {
        this.dDb = i;
    }

    public final int getBusinessType() {
        return this.dDb;
    }

    public final boolean aAK() {
        return 1 == TbadkCoreApplication.m9getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && !z.t(list) && (indexOf = str.indexOf("{%s}", 0)) >= 0) {
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
                spannableString.setSpan(new ForegroundColorSpan(aAK() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
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
                str2 = aw.y(hashMap.get(group).intValue());
            }
            str = str.replace(matcher.group(0), str2);
        }
        return str;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.mS(i) || com.baidu.tieba.lego.card.d.a.mS(i2)) {
            as.i(textView, i3);
            return;
        }
        if (!aAK()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.mS(i) || com.baidu.tieba.lego.card.d.a.mS(i2)) {
            as.k(view, i3);
            return;
        }
        if (!aAK()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aAL() {
        as.k(this.dEd, w.e.cp_bg_line_d);
        as.c(this.dEd, w.e.cp_bg_line_b);
        switch (this.dDb) {
            case 1:
                this.dEb.setBackgroundColor(getResources().getColor(17170445));
                this.dEc.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                as.k(this.dEb, w.e.cp_bg_line_c);
                as.k(this.dEc, w.e.cp_bg_line_c);
                return;
            default:
                this.dEb.setBackgroundColor(getResources().getColor(17170445));
                this.dEc.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            as.c(textView, w.e.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        as.c(textView, w.e.btn_forum_focus_color, 1);
        textView.setText(str);
        as.j(textView, w.g.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(w.g.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(w.f.ds18), 0, getResources().getDimensionPixelSize(w.f.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            au auVar = new au(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    auVar.Z(split[0], split[1]);
                }
            }
            auVar.r("obj_locate", getStatPosition());
            auVar.Z("obj_param3", at.VG());
            cf.VN().a(auVar);
        }
    }

    protected final void by(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            au auVar = new au(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    auVar.Z(split[0], split[1]);
                }
            }
            auVar.r("obj_locate", getStatPosition());
            auVar.Z("obj_param3", at.VG());
            TiebaStatic.log(auVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void aAM() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void aAN() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void aAO() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setAfterClickSchemeListener(a aVar) {
        this.dEe = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void setDownloadAppCallback(c cVar) {
        this.dEf = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void aAP() {
    }
}
