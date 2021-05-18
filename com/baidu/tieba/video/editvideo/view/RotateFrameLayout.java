package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public class RotateFrameLayout extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public PaintFlagsDrawFilter f21371e;

    public RotateFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(this.f21371e);
        super.onDraw(canvas);
    }

    public RotateFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21371e = new PaintFlagsDrawFilter(0, 3);
    }
}
