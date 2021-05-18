package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Context f18302e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f18303f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f18304g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f18305h;

    /* renamed from: i  reason: collision with root package name */
    public int f18306i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18306i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18302e = context;
        a();
    }

    public final void a() {
        this.l = l.g(this.f18302e, R.dimen.ds4);
        this.f18305h = new RectF();
        Paint paint = new Paint();
        this.f18303f = paint;
        paint.setAntiAlias(true);
        this.f18303f.setStrokeWidth(this.l);
        this.f18303f.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f18304g = paint2;
        paint2.setAntiAlias(true);
        this.f18304g.setStrokeWidth(this.l);
        this.f18304g.setStyle(Paint.Style.STROKE);
        this.j = R.color.common_color_10184;
        this.k = R.color.common_color_10162;
        b();
    }

    public void b() {
        this.f18303f.setColor(SkinManager.getColor(this.j));
        this.f18304g.setColor(SkinManager.getColor(this.k));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.m = getWidth();
        int height = getHeight();
        this.n = height;
        int i2 = this.m;
        if (i2 > height) {
            height = i2;
        }
        this.o = height;
        RectF rectF = this.f18305h;
        int i3 = this.l;
        rectF.left = i3 / 2.0f;
        rectF.top = i3 / 2.0f;
        rectF.right = height - (i3 / 2);
        rectF.bottom = height - (i3 / 2);
        canvas.drawArc(rectF, 150.0f, 360.0f, false, this.f18304g);
        canvas.drawArc(this.f18305h, 150.0f, this.f18306i, false, this.f18303f);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18306i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18302e = context;
        a();
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f18306i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18302e = context;
        a();
    }
}
