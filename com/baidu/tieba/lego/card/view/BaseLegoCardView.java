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
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected int fpB;
    protected a fqA;
    protected c fqB;
    protected View fqv;
    protected View fqw;
    protected View fqx;
    protected View fqy;
    protected ImageView fqz;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aYY();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aZa();
        postInit();
        this.isInit = false;
    }

    protected final <S> S v(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aYZ() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aZa() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.fqv = aYY();
        frameLayout.addView(this.fqv, aYZ());
        this.fqw = new View(getContext());
        al.j(this.fqw, e.d.common_color_10205);
        frameLayout.addView(this.fqw, new ViewGroup.LayoutParams(-1, -1));
        this.fqz = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds1));
        al.j(this.fqz, e.d.cp_bg_line_d);
        al.c(this.fqz, e.d.cp_bg_line_b);
        this.fqx = new View(getContext());
        this.fqy = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds16));
        switch (this.fpB) {
            case 1:
            case 4:
                this.fqx.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fqx, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.fqz, layoutParams2);
                addView(frameLayout, layoutParams);
                this.fqy.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fqy, layoutParams3);
                return;
            case 2:
                al.j(this.fqx, e.d.cp_bg_line_c);
                addView(this.fqx, layoutParams3);
                addView(this.fqz, layoutParams2);
                addView(frameLayout, layoutParams);
                al.j(this.fqy, e.d.cp_bg_line_c);
                addView(this.fqy, layoutParams3);
                return;
            case 3:
                al.j(this.fqx, e.d.cp_bg_line_c);
                addView(this.fqx, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(e.C0210e.ds1);
                addView(this.fqz, layoutParams2);
                al.j(this.fqy, e.d.cp_bg_line_c);
                addView(this.fqy, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.fqx.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fqx, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.fqz, layoutParams2);
                this.fqy.setBackgroundColor(getResources().getColor(17170445));
                addView(this.fqy, layoutParams3);
                return;
        }
    }

    protected void postInit() {
    }

    protected final void rg(int i) {
        switch (i) {
            case -1:
            case 0:
                this.fqz.setVisibility(8);
                return;
            case 1:
                this.fqz.setPadding(0, 0, 0, 0);
                this.fqz.setVisibility(0);
                return;
            case 2:
                this.fqz.setPadding(getResources().getDimensionPixelSize(e.C0210e.ds24), 0, 0, 0);
                this.fqz.setVisibility(0);
                return;
            case 3:
                this.fqz.setPadding(getResources().getDimensionPixelSize(e.C0210e.ds24), 0, getResources().getDimensionPixelSize(e.C0210e.ds24), 0);
                this.fqz.setVisibility(0);
                return;
            default:
                this.fqz.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.fqw.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        rg(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.fqx.setVisibility(8);
                this.fqy.setVisibility(8);
                return;
            case 1:
                this.fqx.setVisibility(8);
                this.fqy.setVisibility(0);
                return;
            case 2:
                this.fqx.setVisibility(0);
                this.fqy.setVisibility(8);
                return;
            case 3:
                this.fqx.setVisibility(0);
                this.fqy.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aZb() {
        this.fqv.setVisibility(0);
    }

    public final void d(T t) {
        v.aqs().dQ(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void Z(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aZc();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aZb();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.fqA != null) {
            this.fqA.b(e, null);
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
        this.fpB = i;
    }

    public final int getBusinessType() {
        return this.fpB;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.v.I(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.re(i) || com.baidu.tieba.lego.card.d.a.re(i2)) {
            al.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.re(i) || com.baidu.tieba.lego.card.d.a.re(i2)) {
            al.j(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void aZc() {
        al.j(this.fqz, e.d.cp_bg_line_d);
        al.c(this.fqz, e.d.cp_bg_line_b);
        switch (this.fpB) {
            case 1:
                this.fqx.setBackgroundColor(getResources().getColor(17170445));
                this.fqy.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                al.j(this.fqx, e.d.cp_bg_line_c);
                al.j(this.fqy, e.d.cp_bg_line_c);
                return;
            default:
                this.fqx.setBackgroundColor(getResources().getColor(17170445));
                this.fqy.setBackgroundColor(getResources().getColor(17170445));
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
        textView.setPadding(getResources().getDimensionPixelSize(e.C0210e.ds18), 0, getResources().getDimensionPixelSize(e.C0210e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            am amVar = new am(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split(ETAG.EQUAL);
                if (split.length == 2) {
                    amVar.aA(split[0], split[1]);
                }
            }
            amVar.x("obj_locate", getStatPosition());
            amVar.aA("obj_param3", o.aqj());
            v.aqs().a(amVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZd() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZe() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZf() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.fqA = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.fqB = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aZg() {
    }
}
