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
    private Paint f6770a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f6771b;

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
        this.f6770a = new Paint();
        this.f6770a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6770a.setColor(Color.parseColor("#99333333"));
        this.f6770a.setAntiAlias(true);
        this.f6770a.setStrokeWidth(0.0f);
        this.f6771b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f6771b.right != getMeasuredWidth() || this.f6771b.bottom != getMeasuredHeight()) {
            this.f6771b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.f6771b, this.f6771b.right / 2.0f, this.f6771b.bottom / 2.0f, this.f6770a);
        super.onDraw(canvas);
    }
}
