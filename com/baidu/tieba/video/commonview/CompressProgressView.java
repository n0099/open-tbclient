package com.baidu.tieba.video.commonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class CompressProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f21213e;

    /* renamed from: f  reason: collision with root package name */
    public int f21214f;

    /* renamed from: g  reason: collision with root package name */
    public int f21215g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21216h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f21217i;
    public RectF j;
    public int k;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f21213e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f21214f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f21215g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f21216h = paint;
        paint.setStrokeWidth(this.f21214f);
        this.f21216h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f21216h.setStyle(Paint.Style.STROKE);
        this.f21216h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f21217i = paint2;
        paint2.setStrokeWidth(this.f21215g);
        this.f21217i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.f21217i.setStyle(Paint.Style.STROKE);
        this.f21217i.setAntiAlias(true);
        int i2 = this.f21214f;
        int i3 = this.f21213e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f21217i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f21216h);
    }

    public void setProgress(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            invalidate();
        }
    }

    public CompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        a();
    }

    public CompressProgressView(Context context) {
        super(context);
        this.k = 0;
        a();
    }
}
