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
    public int f21728e;

    /* renamed from: f  reason: collision with root package name */
    public int f21729f;

    /* renamed from: g  reason: collision with root package name */
    public int f21730g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f21731h;
    public Paint i;
    public RectF j;
    public int k;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 0;
        a();
    }

    public void a() {
        this.f21728e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f21729f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f21730g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f21731h = paint;
        paint.setStrokeWidth(this.f21729f);
        this.f21731h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f21731h.setStyle(Paint.Style.STROKE);
        this.f21731h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStrokeWidth(this.f21730g);
        this.i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.i.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        int i = this.f21729f;
        int i2 = this.f21728e;
        this.j = new RectF(i, i, i2 + i, i2 + i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f21731h);
    }

    public void setProgress(int i) {
        if (i != this.k) {
            this.k = i;
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
