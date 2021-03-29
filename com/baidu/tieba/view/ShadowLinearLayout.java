package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class ShadowLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f22193e;

    /* renamed from: f  reason: collision with root package name */
    public int f22194f;

    /* renamed from: g  reason: collision with root package name */
    public float f22195g;

    /* renamed from: h  reason: collision with root package name */
    public float f22196h;
    public float i;
    public float j;
    public float k;
    public float l;
    public Paint m;
    public Path n;
    public RectF o;
    public RectF p;
    public RectF q;
    public RectF r;

    public ShadowLinearLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.m = paint;
        paint.reset();
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.FILL);
        this.m.setDither(true);
        this.k = l.g(context, R.dimen.ds20);
        float g2 = l.g(context, R.dimen.ds25);
        this.l = g2;
        this.f22195g = g2;
        this.f22196h = g2;
        this.n = new Path();
        setLayerType(1, this.m);
        b();
    }

    public void b() {
        this.m.setColor(SkinManager.getColor(R.color.CAM_X0211));
        this.m.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f22193e <= 0 || this.f22194f <= 0) {
            return;
        }
        this.n.moveTo(this.f22195g, this.f22196h + this.k);
        if (this.o == null) {
            float f2 = this.f22195g;
            float f3 = this.f22196h;
            float f4 = this.k;
            this.o = new RectF(f2, f3, (f4 * 2.0f) + f2, (f4 * 2.0f) + f3);
        }
        this.n.arcTo(this.o, 180.0f, 90.0f, false);
        this.n.lineTo(this.i - this.k, this.f22196h);
        if (this.p == null) {
            float f5 = this.i;
            float f6 = this.k;
            float f7 = this.f22196h;
            this.p = new RectF(f5 - (f6 * 2.0f), f7, f5, (f6 * 2.0f) + f7);
        }
        this.n.arcTo(this.p, 270.0f, 90.0f, false);
        this.n.lineTo(this.i, this.j - this.k);
        if (this.q == null) {
            float f8 = this.i;
            float f9 = this.k;
            float f10 = this.j;
            this.q = new RectF(f8 - (f9 * 2.0f), f10 - (f9 * 2.0f), f8, f10);
        }
        this.n.arcTo(this.q, 0.0f, 90.0f, false);
        this.n.lineTo(this.f22195g + this.k, this.j);
        if (this.r == null) {
            float f11 = this.f22195g;
            float f12 = this.j;
            float f13 = this.k;
            this.r = new RectF(f11, f12 - (f13 * 2.0f), (f13 * 2.0f) + f11, f12);
        }
        this.n.arcTo(this.r, 90.0f, 90.0f, false);
        this.n.lineTo(this.f22195g, this.f22196h + this.k);
        canvas.drawPath(this.n, this.m);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f22193e = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f22194f = measuredHeight;
        int i3 = this.f22193e;
        if (i3 <= 0 || measuredHeight <= 0) {
            return;
        }
        float f2 = this.l;
        this.i = i3 - f2;
        this.j = measuredHeight - f2;
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
