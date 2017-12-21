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
import com.baidu.tieba.card.k;
import com.baidu.tieba.card.s;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public abstract class b<T extends BaseLegoCardInfo> extends LinearLayout implements l<T> {
    protected TbPageContext aca;
    protected int ehj;
    protected View eih;
    protected View eii;
    protected View eij;
    protected View eik;
    protected ImageView eil;
    protected a eim;
    protected c ein;
    private boolean isInit;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aGW();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aca = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aGY();
        aGZ();
        this.isInit = false;
    }

    protected final <S> S t(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aGX() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aGY() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.eih = aGW();
        frameLayout.addView(this.eih, aGX());
        this.eii = new View(getContext());
        aj.k(this.eii, d.C0095d.common_color_10205);
        frameLayout.addView(this.eii, new ViewGroup.LayoutParams(-1, -1));
        this.eil = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        aj.k(this.eil, d.C0095d.cp_bg_line_d);
        aj.c(this.eil, d.C0095d.cp_bg_line_b);
        this.eij = new View(getContext());
        this.eik = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.ehj) {
            case 1:
            case 4:
                this.eij.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eij, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.eil, layoutParams2);
                addView(frameLayout, layoutParams);
                this.eik.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eik, layoutParams3);
                return;
            case 2:
                aj.k(this.eij, d.C0095d.cp_bg_line_c);
                addView(this.eij, layoutParams3);
                addView(this.eil, layoutParams2);
                addView(frameLayout, layoutParams);
                aj.k(this.eik, d.C0095d.cp_bg_line_c);
                addView(this.eik, layoutParams3);
                return;
            case 3:
                aj.k(this.eij, d.C0095d.cp_bg_line_c);
                addView(this.eij, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.eil, layoutParams2);
                aj.k(this.eik, d.C0095d.cp_bg_line_c);
                addView(this.eik, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.eij.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eij, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.eil, layoutParams2);
                this.eik.setBackgroundColor(getResources().getColor(17170445));
                addView(this.eik, layoutParams3);
                return;
        }
    }

    protected void aGZ() {
    }

    protected final void om(int i) {
        switch (i) {
            case -1:
            case 0:
                this.eil.setVisibility(8);
                return;
            case 1:
                this.eil.setPadding(0, 0, 0, 0);
                this.eil.setVisibility(0);
                return;
            case 2:
                this.eil.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.eil.setVisibility(0);
                return;
            case 3:
                this.eil.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.eil.setVisibility(0);
                return;
            default:
                this.eil.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.eii.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        om(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.eij.setVisibility(8);
                this.eik.setVisibility(8);
                return;
            case 1:
                this.eij.setVisibility(8);
                this.eik.setVisibility(0);
                return;
            case 2:
                this.eij.setVisibility(0);
                this.eik.setVisibility(8);
                return;
            case 3:
                this.eij.setVisibility(0);
                this.eik.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aHa() {
        this.eih.setVisibility(0);
    }

    public final void d(T t) {
        s.abW().cC(true);
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
                aHc();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aHa();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int h = p.h(this.aca, t.getScheme());
        if (this.eim != null) {
            this.eim.a(h, null);
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
        this.ehj = i;
    }

    public final int getBusinessType() {
        return this.ehj;
    }

    public final boolean aHb() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || v.w(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
            spannableString.setSpan(new ForegroundColorSpan(aHb() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
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
        if (com.baidu.tieba.lego.card.d.a.ok(i) || com.baidu.tieba.lego.card.d.a.ok(i2)) {
            aj.i(textView, i3);
            return;
        }
        if (!aHb()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ok(i) || com.baidu.tieba.lego.card.d.a.ok(i2)) {
            aj.k(view, i3);
            return;
        }
        if (!aHb()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aHc() {
        aj.k(this.eil, d.C0095d.cp_bg_line_d);
        aj.c(this.eil, d.C0095d.cp_bg_line_b);
        switch (this.ehj) {
            case 1:
                this.eij.setBackgroundColor(getResources().getColor(17170445));
                this.eik.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aj.k(this.eij, d.C0095d.cp_bg_line_c);
                aj.k(this.eik, d.C0095d.cp_bg_line_c);
                return;
            default:
                this.eij.setBackgroundColor(getResources().getColor(17170445));
                this.eik.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            aj.c(textView, d.C0095d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        aj.c(textView, d.C0095d.btn_forum_focus_color, 1);
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
            akVar.ac("obj_param3", k.abJ());
            s.abW().a(akVar);
        }
    }

    protected final void bu(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ak akVar = new ak(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    akVar.ac(split[0], split[1]);
                }
            }
            akVar.r("obj_locate", getStatPosition());
            akVar.ac("obj_param3", k.abJ());
            TiebaStatic.log(akVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aHd() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aHe() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aHf() {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setAfterClickSchemeListener(a aVar) {
        this.eim = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void setDownloadAppCallback(c cVar) {
        this.ein = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.l
    public void aHg() {
    }
}
