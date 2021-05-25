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
    public Context f18212e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f18213f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f18214g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f18215h;

    /* renamed from: i  reason: collision with root package name */
    public int f18216i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18216i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18212e = context;
        a();
    }

    public final void a() {
        this.l = l.g(this.f18212e, R.dimen.ds4);
        this.f18215h = new RectF();
        Paint paint = new Paint();
        this.f18213f = paint;
        paint.setAntiAlias(true);
        this.f18213f.setStrokeWidth(this.l);
        this.f18213f.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f18214g = paint2;
        paint2.setAntiAlias(true);
        this.f18214g.setStrokeWidth(this.l);
        this.f18214g.setStyle(Paint.Style.STROKE);
        this.j = R.color.common_color_10184;
        this.k = R.color.common_color_10162;
        b();
    }

    public void b() {
        this.f18213f.setColor(SkinManager.getColor(this.j));
        this.f18214g.setColor(SkinManager.getColor(this.k));
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
        RectF rectF = this.f18215h;
        int i3 = this.l;
        rectF.left = i3 / 2.0f;
        rectF.top = i3 / 2.0f;
        rectF.right = height - (i3 / 2);
        rectF.bottom = height - (i3 / 2);
        canvas.drawArc(rectF, 150.0f, 360.0f, false, this.f18214g);
        canvas.drawArc(this.f18215h, 150.0f, this.f18216i, false, this.f18213f);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18216i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18212e = context;
        a();
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f18216i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18212e = context;
        a();
    }
}
