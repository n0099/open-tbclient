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
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.card.s;
import com.baidu.tieba.lego.card.a;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.lego.card.c.b;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected TbPageContext eXu;
    private boolean isInit;
    protected View kYI;
    protected View kYJ;
    protected View kYK;
    protected View kYL;
    protected ImageView kYM;
    protected a kYN;
    protected c kYO;
    protected int mBusinessType;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    public abstract void d(T t);

    protected abstract View ddH();

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.eXu = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        ddJ();
        aqT();
        this.isInit = false;
    }

    protected final <S> S z(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams ddI() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void ddJ() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.mBusinessType == 4) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
        }
        this.kYI = ddH();
        frameLayout.addView(this.kYI, ddI());
        this.kYJ = new View(getContext());
        ao.setBackgroundColor(this.kYJ, R.color.common_color_10205);
        frameLayout.addView(this.kYJ, new ViewGroup.LayoutParams(-1, -1));
        this.kYM = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        ao.setBackgroundColor(this.kYM, R.color.CAM_X0201);
        ao.setImageResource(this.kYM, R.color.CAM_X0204);
        this.kYK = new View(getContext());
        this.kYL = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        switch (this.mBusinessType) {
            case 1:
            case 4:
                this.kYK.setBackgroundColor(getResources().getColor(17170445));
                addView(this.kYK, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.kYM, layoutParams2);
                addView(frameLayout, layoutParams);
                this.kYL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.kYL, layoutParams3);
                return;
            case 2:
                ao.setBackgroundColor(this.kYK, R.color.CAM_X0204);
                addView(this.kYK, layoutParams3);
                addView(this.kYM, layoutParams2);
                addView(frameLayout, layoutParams);
                ao.setBackgroundColor(this.kYL, R.color.CAM_X0204);
                addView(this.kYL, layoutParams3);
                return;
            case 3:
                ao.setBackgroundColor(this.kYK, R.color.CAM_X0204);
                addView(this.kYK, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.kYM, layoutParams2);
                ao.setBackgroundColor(this.kYL, R.color.CAM_X0204);
                addView(this.kYL, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.kYK.setBackgroundColor(getResources().getColor(17170445));
                addView(this.kYK, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.kYM, layoutParams2);
                this.kYL.setBackgroundColor(getResources().getColor(17170445));
                addView(this.kYL, layoutParams3);
                return;
        }
    }

    protected void aqT() {
    }

    protected final void Fj(int i) {
        switch (i) {
            case -1:
            case 0:
                this.kYM.setVisibility(8);
                return;
            case 1:
                this.kYM.setPadding(0, 0, 0, 0);
                this.kYM.setVisibility(0);
                return;
            case 2:
                this.kYM.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.kYM.setVisibility(0);
                return;
            case 3:
                this.kYM.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.kYM.setVisibility(0);
                return;
            default:
                this.kYM.setVisibility(8);
                return;
        }
    }

    protected final void b(T t) {
        this.kYJ.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        Fj(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.kYK.setVisibility(8);
                this.kYL.setVisibility(8);
                return;
            case 1:
                this.kYK.setVisibility(8);
                this.kYL.setVisibility(0);
                return;
            case 2:
                this.kYK.setVisibility(0);
                this.kYL.setVisibility(8);
                return;
            case 3:
                this.kYK.setVisibility(0);
                this.kYL.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void ddK() {
        this.kYI.setVisibility(0);
    }

    public final void c(T t) {
        s.cva().mG(true);
        e(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.baidu.tieba.lego.card.view.BaseLegoCardView<T extends com.baidu.tieba.lego.card.model.BaseLegoCardInfo> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.lego.card.view.e
    public final void aN(Object obj) {
        ICardInfo updateCard;
        ICardInfo iCardInfo = (ICardInfo) obj;
        if (iCardInfo != null && (updateCard = iCardInfo.getUpdateCard()) != null) {
            f((BaseLegoCardInfo) updateCard);
            if (this.isInit) {
                init();
            }
            if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                ddL();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            ddK();
            d((BaseLegoCardView<T>) ((BaseLegoCardInfo) updateCard));
            b((BaseLegoCardInfo) updateCard);
        }
    }

    public void e(T t) {
        int h = v.h(this.eXu, t.getScheme());
        if (this.kYN != null) {
            this.kYN.d(h, null);
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
        this.mBusinessType = i;
    }

    public final int getBusinessType() {
        return this.mBusinessType;
    }

    public final boolean isNightMode() {
        return 1 == TbadkCoreApplication.getInst().getSkinType();
    }

    protected final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || x.isEmpty(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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
                sb.append(list.get(i4));
                i5 = i3 + "{%s}".length();
                i3 = str.indexOf("{%s}", i3 + "{%s}".length());
                i4++;
            } else {
                i3 = -1;
            }
        }
        if (i5 < str.length()) {
            sb.append(str.substring(i5));
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            int intValue = ((Integer) arrayList.get(i6)).intValue();
            spannableString.setSpan(new ForegroundColorSpan(isNightMode() ? i2 : i), intValue, intValue + list.get(i6).length(), 33);
        }
        return spannableString;
    }

    protected final void a(TextView textView, int i, int i2, int i3) {
        if (b.Fh(i) || b.Fh(i2)) {
            ao.setViewTextColor(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    protected final void e(View view, int i, int i2, int i3) {
        if (b.Fh(i) || b.Fh(i2)) {
            ao.setBackgroundColor(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void ddL() {
        ao.setBackgroundColor(this.kYM, R.color.CAM_X0201);
        ao.setImageResource(this.kYM, R.color.CAM_X0204);
        switch (this.mBusinessType) {
            case 1:
                this.kYK.setBackgroundColor(getResources().getColor(17170445));
                this.kYL.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                ao.setBackgroundColor(this.kYK, R.color.CAM_X0204);
                ao.setBackgroundColor(this.kYL, R.color.CAM_X0204);
                return;
            default:
                this.kYK.setBackgroundColor(getResources().getColor(17170445));
                this.kYL.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    protected final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ao.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ao.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        ao.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.ds18), 0, getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    protected final void f(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            aq aqVar = new aq(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    aqVar.dX(split[0], split[1]);
                }
            }
            aqVar.an("obj_locate", getStatPosition());
            aqVar.dX(TiebaInitialize.Params.OBJ_PARAM3, m.cuR());
            s.cva().e(aqVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void ddM() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aWD() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cUp() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(a aVar) {
        this.kYN = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(c cVar) {
        this.kYO = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void ddN() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(@NonNull AdvertAppInfo advertAppInfo) {
        if (advertAppInfo.bpg()) {
            return "";
        }
        return TextUtils.isEmpty(advertAppInfo.eNW) ? advertAppInfo.eNT : advertAppInfo.eNW;
    }
}
