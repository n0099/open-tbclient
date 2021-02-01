package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class AlaActiveBannerDot extends LinearLayout {
    private Context mContext;

    public AlaActiveBannerDot(Context context) {
        super(context);
        init(context);
    }

    public AlaActiveBannerDot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaActiveBannerDot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        setOrientation(0);
        setGravity(1);
    }

    public void ub(int i) {
        if (getChildCount() > 0) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (i2 == i) {
                    getChildAt(i2).setBackgroundResource(a.e.active_view_dot_selected);
                } else {
                    getChildAt(i2).setBackgroundResource(a.e.active_view_dot_unselected);
                }
            }
        }
    }

    public void uc(int i) {
        if (i >= 0) {
            removeAllViews();
            if (i == 1) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds12);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
            for (int i2 = 0; i2 < i; i2++) {
                View view = new View(this.mContext);
                view.setBackgroundResource(a.e.active_view_dot_unselected);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                if (i2 != 0) {
                    layoutParams.leftMargin = dimensionPixelSize2;
                }
                addView(view, layoutParams);
            }
            if (getChildAt(0) != null) {
                getChildAt(0).setBackgroundResource(a.e.active_view_dot_selected);
            }
        }
    }
}
