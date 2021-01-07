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
/* loaded from: classes4.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f7068a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f7069b;

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
        this.f7068a = new Paint();
        this.f7068a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7068a.setColor(Color.parseColor("#99333333"));
        this.f7068a.setAntiAlias(true);
        this.f7068a.setStrokeWidth(0.0f);
        this.f7069b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f7069b.right != getMeasuredWidth() || this.f7069b.bottom != getMeasuredHeight()) {
            this.f7069b.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(this.f7069b, this.f7069b.right / 2.0f, this.f7069b.bottom / 2.0f, this.f7068a);
        super.onDraw(canvas);
    }
}
