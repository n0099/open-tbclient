package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes6.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f28753a;

    /* renamed from: b  reason: collision with root package name */
    public RectF f28754b;

    public ShadowImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f28753a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f28753a.setColor(Color.parseColor("#99333333"));
        this.f28753a.setAntiAlias(true);
        this.f28753a.setStrokeWidth(0.0f);
        this.f28754b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f28754b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f28753a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f28754b.right == getMeasuredWidth() && this.f28754b.bottom == getMeasuredHeight()) {
            return;
        }
        this.f28754b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    public ShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
