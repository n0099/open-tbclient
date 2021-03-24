package com.baidu.wallet.base.widget.compromtion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes5.dex */
public abstract class BasePromotionAdapter {
    public CommonPromotionView createAdapterView(Context context) {
        CommonPromotionView commonPromotionView = new CommonPromotionView(context);
        commonPromotionView.setTextClickListener(getClickListener()).setDefLeftDrawable(getDefLeftDraw(), getLeftUrl()).setDefRightDrawable(getDefRightDraw()).setBackGroundColor(getBackGround()).setCenText(getCenText()).setCenTextColor(getTextColor());
        return commonPromotionView;
    }

    public int getBackGround() {
        return -1;
    }

    public abstract CharSequence getCenText();

    public abstract View.OnClickListener getClickListener();

    public abstract Drawable getDefLeftDraw();

    public abstract Drawable getDefRightDraw();

    public abstract String getLeftUrl();

    public String getRightUrl() {
        return null;
    }

    public int getTextColor() {
        return -1;
    }
}
