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
    protected TbPageContext aaX;
    public String ahM;
    protected int atx;
    protected int dsv;
    protected View dtt;
    protected View dtu;
    protected View dtv;
    protected View dtw;
    protected ImageView dtx;
    protected a dty;
    protected c dtz;
    private boolean isInit;
    protected boolean mIsFromCDN;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View axP();

    public abstract void e(T t);

    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.aaX = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        axR();
        axS();
        this.isInit = false;
    }

    protected final <S> S x(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams axQ() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void axR() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.dtt = axP();
        frameLayout.addView(this.dtt, axQ());
        this.dtu = new View(getContext());
        aq.k(this.dtu, w.e.common_color_10205);
        frameLayout.addView(this.dtu, new ViewGroup.LayoutParams(-1, -1));
        this.dtx = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds1));
        aq.k(this.dtx, w.e.cp_bg_line_d);
        aq.c(this.dtx, w.e.cp_bg_line_b);
        this.dtv = new View(getContext());
        this.dtw = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(w.f.ds16));
        switch (this.dsv) {
            case 1:
            case 4:
                this.dtv.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dtv, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.dtx, layoutParams2);
                addView(frameLayout, layoutParams);
                this.dtw.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dtw, layoutParams3);
                return;
            case 2:
                aq.k(this.dtv, w.e.cp_bg_line_c);
                addView(this.dtv, layoutParams3);
                addView(this.dtx, layoutParams2);
                addView(frameLayout, layoutParams);
                aq.k(this.dtw, w.e.cp_bg_line_c);
                addView(this.dtw, layoutParams3);
                return;
            case 3:
                aq.k(this.dtv, w.e.cp_bg_line_c);
                addView(this.dtv, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(w.f.ds1);
                addView(this.dtx, layoutParams2);
                aq.k(this.dtw, w.e.cp_bg_line_c);
                addView(this.dtw, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.dtv.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dtv, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.dtx, layoutParams2);
                this.dtw.setBackgroundColor(getResources().getColor(17170445));
                addView(this.dtw, layoutParams3);
                return;
        }
    }

    protected void axS() {
    }

    protected final void mv(int i) {
        switch (i) {
            case -1:
            case 0:
                this.dtx.setVisibility(8);
                return;
            case 1:
                this.dtx.setPadding(0, 0, 0, 0);
                this.dtx.setVisibility(0);
                return;
            case 2:
                this.dtx.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, 0, 0);
                this.dtx.setVisibility(0);
                return;
            case 3:
                this.dtx.setPadding(getResources().getDimensionPixelSize(w.f.ds24), 0, getResources().getDimensionPixelSize(w.f.ds24), 0);
                this.dtx.setVisibility(0);
                return;
            default:
                this.dtx.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.dtu.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        mv(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.dtv.setVisibility(8);
                this.dtw.setVisibility(8);
                return;
            case 1:
                this.dtv.setVisibility(8);
                this.dtw.setVisibility(0);
                return;
            case 2:
                this.dtv.setVisibility(0);
                this.dtw.setVisibility(8);
                return;
            case 3:
                this.dtv.setVisibility(0);
                this.dtw.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void axT() {
        this.dtt.setVisibility(0);
    }

    public final void d(T t) {
        cc.ST().cO(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.b<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.am
    public final void N(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                axV();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            axT();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int i = t.i(this.aaX, t.getScheme());
        if (this.dty != null) {
            this.dty.in(i);
        }
    }

    public final void setCardOnClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public final void setCardOnLongLickListener(View.OnLongClickListener onLongClickListener) {
        setOnLongClickListener(onLongClickListener);
    }

    public final int getStatPosition() {
        return this.atx + 1;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setPosition(int i) {
        this.atx = i;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setBusinessType(int i) {
        this.dsv = i;
    }

    public final int getBusinessType() {
        return this.dsv;
    }

    public final boolean axU() {
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
                spannableString.setSpan(new ForegroundColorSpan(axU() ? i2 : i), intValue, intValue + list.get(i7).length(), 33);
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
        if (com.baidu.tieba.lego.card.d.a.mt(i) || com.baidu.tieba.lego.card.d.a.mt(i2)) {
            aq.i(textView, i3);
            return;
        }
        if (!axU()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.mt(i) || com.baidu.tieba.lego.card.d.a.mt(i2)) {
            aq.k(view, i3);
            return;
        }
        if (!axU()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void axV() {
        aq.k(this.dtx, w.e.cp_bg_line_d);
        aq.c(this.dtx, w.e.cp_bg_line_b);
        switch (this.dsv) {
            case 1:
                this.dtv.setBackgroundColor(getResources().getColor(17170445));
                this.dtw.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                aq.k(this.dtv, w.e.cp_bg_line_c);
                aq.k(this.dtw, w.e.cp_bg_line_c);
                return;
            default:
                this.dtv.setBackgroundColor(getResources().getColor(17170445));
                this.dtw.setBackgroundColor(getResources().getColor(17170445));
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
            asVar.aa("obj_param3", at.SN());
            cc.ST().a(asVar);
        }
    }

    protected final void bu(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            as asVar = new as(str);
            for (String str3 : str2.split("&")) {
                String[] split = str3.split("=");
                if (split.length == 2) {
                    asVar.aa(split[0], split[1]);
                }
            }
            asVar.s("obj_locate", getStatPosition());
            asVar.aa("obj_param3", at.SN());
            TiebaStatic.log(asVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void axW() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void axX() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void axY() {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void i(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setAfterClickSchemeListener(a aVar) {
        this.dty = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void setDownloadAppCallback(c cVar) {
        this.dtz = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.am
    public void axZ() {
    }
}
