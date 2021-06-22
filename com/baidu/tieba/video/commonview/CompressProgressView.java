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
    public int f21373e;

    /* renamed from: f  reason: collision with root package name */
    public int f21374f;

    /* renamed from: g  reason: collision with root package name */
    public int f21375g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21376h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f21377i;
    public RectF j;
    public int k;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f21373e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f21374f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f21375g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f21376h = paint;
        paint.setStrokeWidth(this.f21374f);
        this.f21376h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f21376h.setStyle(Paint.Style.STROKE);
        this.f21376h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f21377i = paint2;
        paint2.setStrokeWidth(this.f21375g);
        this.f21377i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.f21377i.setStyle(Paint.Style.STROKE);
        this.f21377i.setAntiAlias(true);
        int i2 = this.f21374f;
        int i3 = this.f21373e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f21377i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f21376h);
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
