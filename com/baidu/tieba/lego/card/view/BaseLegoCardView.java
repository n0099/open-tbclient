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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.v;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseLegoCardView<T extends BaseLegoCardInfo> extends LinearLayout implements e<T> {
    protected TbPageContext eUY;
    private boolean isInit;
    protected com.baidu.tieba.lego.card.a lcA;
    protected com.baidu.tieba.lego.card.c lcB;
    protected View lcv;
    protected View lcw;
    protected View lcx;
    protected View lcy;
    protected ImageView lcz;
    protected int mBusinessType;
    public String mFrom;
    protected boolean mIsFromCDN;
    protected int mPosition;
    protected int mSkinType;

    protected abstract void a(T t, int i);

    public abstract void d(T t);

    protected abstract View dbV();

    public BaseLegoCardView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mSkinType = 3;
        this.isInit = true;
        this.eUY = tbPageContext;
        setOrientation(1);
    }

    private void init() {
        dbX();
        anx();
        this.isInit = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <S> S z(View view, int i) {
        return (S) view.findViewById(i);
    }

    protected final ViewGroup.LayoutParams dbW() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void dbX() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (this.mBusinessType == 4) {
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.M_H_X003), 0, 0);
        }
        this.lcv = dbV();
        frameLayout.addView(this.lcv, dbW());
        this.lcw = new View(getContext());
        ap.setBackgroundColor(this.lcw, R.color.common_color_10205);
        frameLayout.addView(this.lcw, new ViewGroup.LayoutParams(-1, -1));
        this.lcz = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds1));
        ap.setBackgroundColor(this.lcz, R.color.CAM_X0201);
        ap.setImageResource(this.lcz, R.color.CAM_X0204);
        this.lcx = new View(getContext());
        this.lcy = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds16));
        switch (this.mBusinessType) {
            case 1:
            case 4:
                this.lcx.setBackgroundColor(getResources().getColor(17170445));
                addView(this.lcx, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(this.lcz, layoutParams2);
                addView(frameLayout, layoutParams);
                this.lcy.setBackgroundColor(getResources().getColor(17170445));
                addView(this.lcy, layoutParams3);
                return;
            case 2:
                ap.setBackgroundColor(this.lcx, R.color.CAM_X0204);
                addView(this.lcx, layoutParams3);
                addView(this.lcz, layoutParams2);
                addView(frameLayout, layoutParams);
                ap.setBackgroundColor(this.lcy, R.color.CAM_X0204);
                addView(this.lcy, layoutParams3);
                return;
            case 3:
                ap.setBackgroundColor(this.lcx, R.color.CAM_X0204);
                addView(this.lcx, layoutParams3);
                addView(frameLayout, layoutParams);
                layoutParams2.bottomMargin = getResources().getDimensionPixelSize(R.dimen.ds1);
                addView(this.lcz, layoutParams2);
                ap.setBackgroundColor(this.lcy, R.color.CAM_X0204);
                addView(this.lcy, layoutParams3);
                return;
            case 5:
                addView(frameLayout, layoutParams);
                return;
            default:
                this.lcx.setBackgroundColor(getResources().getColor(17170445));
                addView(this.lcx, layoutParams3);
                layoutParams2.bottomMargin = 0;
                addView(frameLayout, layoutParams);
                addView(this.lcz, layoutParams2);
                this.lcy.setBackgroundColor(getResources().getColor(17170445));
                addView(this.lcy, layoutParams3);
                return;
        }
    }

    protected void anx() {
    }

    protected final void DV(int i) {
        switch (i) {
            case -1:
            case 0:
                this.lcz.setVisibility(8);
                return;
            case 1:
                this.lcz.setPadding(0, 0, 0, 0);
                this.lcz.setVisibility(0);
                return;
            case 2:
                this.lcz.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, 0, 0);
                this.lcz.setVisibility(0);
                return;
            case 3:
                this.lcz.setPadding(getResources().getDimensionPixelSize(R.dimen.ds24), 0, getResources().getDimensionPixelSize(R.dimen.ds24), 0);
                this.lcz.setVisibility(0);
                return;
            default:
                this.lcz.setVisibility(8);
                return;
        }
    }

    protected final void b(T t) {
        this.lcw.setVisibility(t.isShowCover() ? 0 : 8);
        int showSpace = t.getShowSpace();
        DV(showSpace != 0 ? -1 : t.getShowLine());
        switch (showSpace) {
            case 0:
                this.lcx.setVisibility(8);
                this.lcy.setVisibility(8);
                return;
            case 1:
                this.lcx.setVisibility(8);
                this.lcy.setVisibility(0);
                return;
            case 2:
                this.lcx.setVisibility(0);
                this.lcy.setVisibility(8);
                return;
            case 3:
                this.lcx.setVisibility(0);
                this.lcy.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void dbY() {
        this.lcv.setVisibility(0);
    }

    public final void c(T t) {
        t.csB().mG(true);
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
                dbZ();
                a((BaseLegoCardInfo) updateCard, this.mSkinType);
            }
            dbY();
            d((BaseLegoCardView<T>) ((BaseLegoCardInfo) updateCard));
            b((BaseLegoCardInfo) updateCard);
        }
    }

    public void e(T t) {
        int j = v.j(this.eUY, t.getScheme());
        if (this.lcA != null) {
            this.lcA.d(j, null);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final SpannableString a(String str, List<String> list, int i, int i2) {
        int indexOf;
        if (TextUtils.isEmpty(str) || y.isEmpty(list) || (indexOf = str.indexOf("{%s}", 0)) < 0) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(TextView textView, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.c.b.DT(i) || com.baidu.tieba.lego.card.c.b.DT(i2)) {
            ap.setViewTextColor(textView, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        textView.setTextColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(View view, int i, int i2, int i3) {
        if (com.baidu.tieba.lego.card.c.b.DT(i) || com.baidu.tieba.lego.card.c.b.DT(i2)) {
            ap.setBackgroundColor(view, i3);
            return;
        }
        if (!isNightMode()) {
            i2 = i;
        }
        view.setBackgroundColor(i2);
    }

    private void dbZ() {
        ap.setBackgroundColor(this.lcz, R.color.CAM_X0201);
        ap.setImageResource(this.lcz, R.color.CAM_X0204);
        switch (this.mBusinessType) {
            case 1:
                this.lcx.setBackgroundColor(getResources().getColor(17170445));
                this.lcy.setBackgroundColor(getResources().getColor(17170445));
                return;
            case 2:
            case 3:
                ap.setBackgroundColor(this.lcx, R.color.CAM_X0204);
                ap.setBackgroundColor(this.lcy, R.color.CAM_X0204);
                return;
            default:
                this.lcx.setBackgroundColor(getResources().getColor(17170445));
                this.lcy.setBackgroundColor(getResources().getColor(17170445));
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            ap.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        ap.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        ap.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.ds18), 0, getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    protected final void f(T t) {
        if (t != null && !TextUtils.isEmpty(t.getShowKey()) && !TextUtils.isEmpty(t.getShowExtra())) {
            ar arVar = new ar(t.getShowKey());
            for (String str : t.getShowExtra().split(ETAG.ITEM_SEPARATOR)) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    arVar.dR(split[0], split[1]);
                }
            }
            arVar.ap("obj_locate", getStatPosition());
            arVar.dR(TiebaInitialize.Params.OBJ_PARAM3, com.baidu.tieba.card.m.csr());
            t.csB().e(arVar);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void dca() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void aSW() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void cSE() {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void l(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setAfterClickSchemeListener(com.baidu.tieba.lego.card.a aVar) {
        this.lcA = aVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public final void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void setDownloadAppCallback(com.baidu.tieba.lego.card.c cVar) {
        this.lcB = cVar;
    }

    @Override // com.baidu.tieba.lego.card.view.e
    public void dcb() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d(@NonNull AdvertAppInfo advertAppInfo) {
        if (advertAppInfo.blF()) {
            return "";
        }
        return TextUtils.isEmpty(advertAppInfo.eLw) ? advertAppInfo.eLt : advertAppInfo.eLw;
    }
}
