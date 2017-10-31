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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements l<T> {
    protected TbPageContext abI;
    public String aiB;
    protected int eaf;
    protected View ebd;
    protected View ebe;
    protected View ebf;
    protected View ebg;
    protected ImageView ebh;
    protected a ebi;
    protected c ebj;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aGb();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.abI = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aGd();
        aGe();
        this.isInit = false;
    }

    protected final <S> S x(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aGc() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aGd() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.ebd = aGb();
        frameLayout.addView(this.ebd, aGc());
        this.ebe = new View(getContext());
        aj.k(this.ebe, d.C0080d.common_color_10205);
        frameLayout.addView(this.ebe, new ViewGroup.LayoutParams(-1, -1));
        this.ebh = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        aj.k(this.ebh, d.C0080d.cp_bg_line_d);
        aj.c(this.ebh, d.C0080d.cp_bg_line_b);
        this.ebf = new View(getContext());
        this.ebg = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.eaf) {
            case 1:
            case 4:
                this.ebf.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ebf, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.ebh, layoutParams2);
                addView(frameLayout, layoutParams);
                this.ebg.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ebg, layoutParams3);
                return;
            case 2:
                aj.k(this.ebf, d.C0080d.cp_bg_line_c);
                addView(this.ebf, layoutParams3);
                addView(this.ebh, layoutParams2);
                addView(frameLayout, layoutParams);
                aj.k(this.ebg, d.C0080d.cp_bg_line_c);
                addView(this.ebg, layoutParams3);
                return;
            case 3:
                aj.k(this.ebf, d.C0080d.cp_bg_line_c);
                addView(this.ebf, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.ebh, layoutParams2);
                aj.k(this.ebg, d.C0080d.cp_bg_line_c);
                addView(this.ebg, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.ebf.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ebf, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.ebh, layoutParams2);
                this.ebg.setBackgroundColor(getResources().getColor(17170445));
                addView(this.ebg, layoutParams3);
                return;
        }
    }

    protected void aGe() {
    }

    protected final void nT(int i) {
        switch (i) {
            case -1:
            case 0:
                this.ebh.setVisibility(8);
                return;
            case 1:
                this.ebh.setPadding(0, 0, 0, 0);
                this.ebh.setVisibility(0);
                return;
            case 2:
                this.ebh.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.ebh.setVisibility(0);
                return;
            case 3:
                this.ebh.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.ebh.setVisibility(0);
                return;
            default:
                this.ebh.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.ebe.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        nT(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.ebf.setVisibility(8);
                this.ebg.setVisibility(8);
                return;
            case 1:
                this.ebf.setVisibility(8);
                this.ebg.setVisibility(0);
                return;
            case 2:
                this.ebf.setVisibility(0);
                this.ebg.setVisibility(8);
                return;
            case 3:
                this.ebf.setVisibility(0);
                this.ebg.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aGf() {
        this.ebd.setVisibility(0);
    }

    public final void d(T t) {
        u.ZX().cv(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.b<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.l
    public final void N(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aGh();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aGf();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int h = o.h(this.abI, t.getScheme());
        if (this.ebi != null) {
            this.ebi.a(h, null);
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

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setPosition(int i) {
        this.mPosition = i;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setBusinessType(int i) {
        this.eaf = i;
    }

    public final int getBusinessType() {
        return this.eaf;
    }

    public final boolean aGg() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || v.v(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
            spannableString.setSpan(new ForegroundColorSpan(aGg() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
        }
        return spannableString;
    }

    protected final String b(String str, HashMap<String, Integer> hashMap) {
        Matcher matcher = Pattern.compile("\\{(\\w+)\\}").matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String str2 = "";
            if (hashMap != null && hashMap.get(group) != null) {
                str2 = am.y(hashMap.get(group).intValue());
            }
            str = str.replace(matcher.group(0), str2);
        }
        return str;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.nR(i) || com.baidu.tieba.lego.card.d.a.nR(i2)) {
            aj.i(textView, i3);
            return;
        }
        if (!aGg()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.nR(i) || com.baidu.tieba.lego.card.d.a.nR(i2)) {
            aj.k(view, i3);
            return;
        }
        if (!aGg()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aGh() {
        aj.k(this.ebh, d.C0080d.cp_bg_line_d);
        aj.c(this.ebh, d.C0080d.cp_bg_line_b);
        switch (this.eaf) {
            case 1:
                this.ebf.setBackgroundColor(getResources().getColor(17170445));
                this.ebg.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aj.k(this.ebf, d.C0080d.cp_bg_line_c);
                aj.k(this.ebg, d.C0080d.cp_bg_line_c);
                return;
            default:
                this.ebf.setBackgroundColor(getResources().getColor(17170445));
                this.ebg.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            aj.c(textView, d.C0080d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aj.c(textView, d.C0080d.btn_forum_focus_color, 1);
        textView.setText(str);
        aj.j(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            ak akVar = new ak(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    akVar.ac(split[0], split[1]);
                }
            }
            akVar.r("obj_locate", getStatPosition());
            akVar.ac("obj_param3", m.ZM());
            u.ZX().a(akVar);
        }
    }

    protected final void br(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    akVar.ac(split[0], split[1]);
                }
            }
            akVar.r("obj_locate", getStatPosition());
            akVar.ac("obj_param3", m.ZM());
            TiebaStatic.log(akVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aGi() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aGj() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aGk() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setAfterClickSchemeListener(a aVar) {
        this.ebi = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void setDownloadAppCallback(c cVar) {
        this.ebj = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aGl() {
    }
}
