package com.baidu.tieba.pb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class PbImageIcon extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    protected Context f2144a;

    public PbImageIcon(Context context) {
        super(context);
        this.f2144a = context;
    }

    public PbImageIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2144a = context;
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
