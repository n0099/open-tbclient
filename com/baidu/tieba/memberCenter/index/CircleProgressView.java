package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class CircleProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Context f18912e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f18913f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f18914g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f18915h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18912e = context;
        a();
    }

    public final void a() {
        this.l = l.g(this.f18912e, R.dimen.ds4);
        this.f18915h = new RectF();
        Paint paint = new Paint();
        this.f18913f = paint;
        paint.setAntiAlias(true);
        this.f18913f.setStrokeWidth(this.l);
        this.f18913f.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f18914g = paint2;
        paint2.setAntiAlias(true);
        this.f18914g.setStrokeWidth(this.l);
        this.f18914g.setStyle(Paint.Style.STROKE);
        this.j = R.color.common_color_10184;
        this.k = R.color.common_color_10162;
        b();
    }

    public void b() {
        this.f18913f.setColor(SkinManager.getColor(this.j));
        this.f18914g.setColor(SkinManager.getColor(this.k));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.m = getWidth();
        int height = getHeight();
        this.n = height;
        int i = this.m;
        if (i > height) {
            height = i;
        }
        this.o = height;
        RectF rectF = this.f18915h;
        int i2 = this.l;
        rectF.left = i2 / 2.0f;
        rectF.top = i2 / 2.0f;
        rectF.right = height - (i2 / 2);
        rectF.bottom = height - (i2 / 2);
        canvas.drawArc(rectF, 150.0f, 360.0f, false, this.f18914g);
        canvas.drawArc(this.f18915h, 150.0f, this.i, false, this.f18913f);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18912e = context;
        a();
    }

    public CircleProgressView(Context context) {
        super(context);
        this.i = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.f18912e = context;
        a();
    }
}
