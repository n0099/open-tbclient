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
    private Paint f4585a;
    private RectF b;

    public ShadowImageView(Context context) {
        super(context);
        a();
    }

    public ShadowImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShadowImageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f4585a = new Paint();
        this.f4585a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4585a.setColor(Color.parseColor("#99333333"));
        this.f4585a.setAntiAlias(true);
        this.f4585a.setStrokeWidth(0.0f);
        this.b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b.right != getMeasuredWidth() || this.b.bottom != getMeasuredHeight()) {
            this.b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.b, this.b.right / 2.0f, this.b.bottom / 2.0f, this.f4585a);
        super.onDraw(canvas);
    }
}
