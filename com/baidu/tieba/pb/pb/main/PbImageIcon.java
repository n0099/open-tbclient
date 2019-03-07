package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class PbImageIcon extends ImageView {
    protected Context mContext;

    public PbImageIcon(Context context) {
        super(context);
        this.mContext = context;
    }

    public PbImageIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        Drawable drawable = getDrawable();
        if (measuredWidth < (drawable != null ? drawable.getIntrinsicWidth() : measuredWidth)) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }
}
