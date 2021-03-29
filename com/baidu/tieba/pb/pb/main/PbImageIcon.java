package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes4.dex */
public class PbImageIcon extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    public Context f19698e;

    public PbImageIcon(Context context) {
        super(context);
        this.f19698e = context;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        Drawable drawable = getDrawable();
        if (measuredWidth < (drawable != null ? drawable.getIntrinsicWidth() : measuredWidth)) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public PbImageIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19698e = context;
    }
}
