package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class BottomShadowLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f21717e;

    /* renamed from: f  reason: collision with root package name */
    public int f21718f;

    /* renamed from: g  reason: collision with root package name */
    public float f21719g;

    /* renamed from: h  reason: collision with root package name */
    public float f21720h;
    public Paint i;
    public Paint j;
    public RectF k;
    public RectF l;

    public BottomShadowLinearLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.i = paint;
        paint.reset();
        this.i.setAntiAlias(true);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setDither(true);
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.reset();
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setDither(true);
        this.f21719g = l.g(context, R.dimen.ds20);
        this.f21720h = l.g(context, R.dimen.ds25);
        setLayerType(1, this.i);
        b();
    }

    public void b() {
        this.i.setColor(SkinManager.getColor(R.color.CAM_X0207));
        this.j.setColor(SkinManager.getColor(R.color.CAM_X0207));
        this.i.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f21717e <= 0 || this.f21718f <= 0) {
            return;
        }
        if (this.k == null) {
            this.k = new RectF(0.0f, 0.0f, this.f21717e, this.f21718f - this.f21720h);
        }
        RectF rectF = this.k;
        float f2 = this.f21719g;
        canvas.drawRoundRect(rectF, f2, f2, this.i);
        if (this.l == null) {
            this.l = new RectF(0.0f, 0.0f, this.f21717e, this.f21718f / 2);
        }
        canvas.drawRect(this.l, this.j);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f21717e = getMeasuredWidth();
        this.f21718f = getMeasuredHeight();
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
