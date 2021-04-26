package com.baidu.wallet.fastpay.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.compromtion.CommonPromotionView;
/* loaded from: classes5.dex */
public class FastPayPromotionView extends CommonPromotionView {
    public FastPayPromotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.baidu.wallet.base.widget.compromtion.CommonPromotionView
    public String getLayout() {
        return "wallet_fp_promotion_layout";
    }

    @Override // com.baidu.wallet.base.widget.compromtion.CommonPromotionView
    public int getMarginLeft() {
        return 51;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.CommonPromotionView
    public int getMarginRight() {
        return 33;
    }

    @Override // com.baidu.wallet.base.widget.compromtion.CommonPromotionView
    public void initViews() {
        super.initViews();
        View view = this.mView;
        if (view != null) {
            view.setBackgroundColor(ResUtils.getColor(view.getContext(), "wallet_fp_promotion_bg"));
        }
    }

    public FastPayPromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FastPayPromotionView(Context context) {
        super(context);
    }
}
