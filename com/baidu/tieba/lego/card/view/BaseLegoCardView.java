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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
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
    protected int ewx;
    protected View exm;
    protected View exn;
    protected View exo;
    protected View exp;
    protected ImageView exq;
    protected a exr;
    protected c exs;
    private boolean isInit;
    protected TbPageContext mContext;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    protected abstract View aKT();

    public abstract void e(T t);

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.mContext = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        aKV();
        aKW();
        this.isInit = false;
    }

    protected final <S> S r(View view2, int i) {
        return (S) view2.findViewById(i);
    }

    protected final ViewGroup.LayoutParams aKU() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void aKV() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.exm = aKT();
        frameLayout.addView(this.exm, aKU());
        this.exn = new View(getContext());
        ak.j(this.exn, d.C0126d.common_color_10205);
        frameLayout.addView(this.exn, new ViewGroup.LayoutParams(-1, -1));
        this.exq = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds1));
        ak.j(this.exq, d.C0126d.cp_bg_line_d);
        ak.c(this.exq, d.C0126d.cp_bg_line_b);
        this.exo = new View(getContext());
        this.exp = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds16));
        switch (this.ewx) {
            case 1:
            case 4:
                this.exo.setBackgroundColor(getResources().getColor(17170445));
                addView(this.exo, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.exq, layoutParams2);
                addView(frameLayout, layoutParams);
                this.exp.setBackgroundColor(getResources().getColor(17170445));
                addView(this.exp, layoutParams3);
                return;
            case 2:
                ak.j(this.exo, d.C0126d.cp_bg_line_c);
                addView(this.exo, layoutParams3);
                addView(this.exq, layoutParams2);
                addView(frameLayout, layoutParams);
                ak.j(this.exp, d.C0126d.cp_bg_line_c);
                addView(this.exp, layoutParams3);
                return;
            case 3:
                ak.j(this.exo, d.C0126d.cp_bg_line_c);
                addView(this.exo, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(d.e.ds1);
                addView(this.exq, layoutParams2);
                ak.j(this.exp, d.C0126d.cp_bg_line_c);
                addView(this.exp, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.exo.setBackgroundColor(getResources().getColor(17170445));
                addView(this.exo, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.exq, layoutParams2);
                this.exp.setBackgroundColor(getResources().getColor(17170445));
                addView(this.exp, layoutParams3);
                return;
        }
    }

    protected void aKW() {
    }

    protected final void ow(int i) {
        switch (i) {
            case -1:
            case 0:
                this.exq.setVisibility(8);
                return;
            case 1:
                this.exq.setPadding(0, 0, 0, 0);
                this.exq.setVisibility(0);
                return;
            case 2:
                this.exq.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, 0, 0);
                this.exq.setVisibility(0);
                return;
            case 3:
                this.exq.setPadding(getResources().getDimensionPixelSize(d.e.ds24), 0, getResources().getDimensionPixelSize(d.e.ds24), 0);
                this.exq.setVisibility(0);
                return;
            default:
                this.exq.setVisibility(8);
                return;
        }
    }

    protected final void c(T t) {
        this.exn.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        ow(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.exo.setVisibility(8);
                this.exp.setVisibility(8);
                return;
            case 1:
                this.exo.setVisibility(8);
                this.exp.setVisibility(0);
                return;
            case 2:
                this.exo.setVisibility(0);
                this.exp.setVisibility(8);
                return;
            case 3:
                this.exo.setVisibility(0);
                this.exp.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void aKX() {
        this.exm.setVisibility(0);
    }

    public final void d(T t) {
        v.afy().cB(true);
        f(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void O(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            g((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                aKY();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            aKX();
            e((BaseLegoCardInfo) updateCard);
            c((BaseLegoCardInfo) updateCard);
        }
    }

    public void f(T t) {
        int e = q.e(this.mContext, t.getScheme());
        if (this.exr != null) {
            this.exr.b(e, null);
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
        this.ewx = i;
    }

    public final int getBusinessType() {
        return this.ewx;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.v.w(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
        if (com.baidu.tieba.lego.card.d.a.ou(i) || com.baidu.tieba.lego.card.d.a.ou(i2)) {
            ak.h(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void c(View view2, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.d.a.ou(i) || com.baidu.tieba.lego.card.d.a.ou(i2)) {
            ak.j(view2, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view2.setBackgroundColor(i2);
    }

    private void aKY() {
        ak.j(this.exq, d.C0126d.cp_bg_line_d);
        ak.c(this.exq, d.C0126d.cp_bg_line_b);
        switch (this.ewx) {
            case 1:
                this.exo.setBackgroundColor(getResources().getColor(17170445));
                this.exp.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                ak.j(this.exo, d.C0126d.cp_bg_line_c);
                ak.j(this.exp, d.C0126d.cp_bg_line_c);
                return;
            default:
                this.exo.setBackgroundColor(getResources().getColor(17170445));
                this.exp.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ak.c(textView, d.C0126d.cp_cont_d, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ak.c(textView, d.C0126d.btn_forum_focus_color, 1);
        textView.setText(str);
        ak.i(textView, d.f.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(d.e.ds18), 0, getResources().getDimensionPixelSize(d.e.ds10), 0);
    }

    protected final void g(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            al alVar = new al(t.getShowKey());
            for (String str : t.getShowExtra().split("&")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    alVar.ac(split[0], split[1]);
                }
            }
            alVar.r("obj_locate", getStatPosition());
            alVar.ac("obj_param3", o.afp());
            v.afy().a(alVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aKZ() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLa() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLb() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void h(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.exr = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.exs = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aLc() {
    }
}
