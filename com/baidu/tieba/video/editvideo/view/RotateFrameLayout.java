package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class RotateFrameLayout extends FrameLayout {
    private PaintFlagsDrawFilter goR;

    public RotateFrameLayout(Context context) {
        this(context, null);
    }

    public RotateFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.goR = new PaintFlagsDrawFilter(0, 3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.setDrawFilter(this.goR);
        super.onDraw(canvas);
    }
}
