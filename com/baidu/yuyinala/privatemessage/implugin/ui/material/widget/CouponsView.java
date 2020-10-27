package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
/* loaded from: classes4.dex */
public class CouponsView extends View {
    public CouponsView(Context context) {
        super(context);
    }

    public CouponsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CouponsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        int i = (int) ((measuredWidth / measuredHeight) / 3.0f);
        Paint paint = new Paint();
        paint.setColor(-1);
        float f = measuredHeight + measuredHeight + ((measuredWidth % measuredHeight) / i);
        float f2 = f + measuredHeight;
        for (int i2 = 0; i2 < i; i2++) {
            canvas.drawCircle(f, 1.0f + measuredHeight, measuredHeight, paint);
            f += f2;
        }
    }
}
