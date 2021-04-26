package com.baidu.tieba.write.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class AlbumCompressProgressView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f22724e;

    /* renamed from: f  reason: collision with root package name */
    public int f22725f;

    /* renamed from: g  reason: collision with root package name */
    public int f22726g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f22727h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f22728i;
    public RectF j;
    public int k;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f22724e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f22725f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f22726g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f22727h = paint;
        paint.setStrokeWidth(this.f22725f);
        this.f22727h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f22727h.setStyle(Paint.Style.STROKE);
        this.f22727h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f22728i = paint2;
        paint2.setStrokeWidth(this.f22726g);
        this.f22728i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.f22728i.setStyle(Paint.Style.STROKE);
        this.f22728i.setAntiAlias(true);
        int i2 = this.f22725f;
        int i3 = this.f22724e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f22728i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f22727h);
    }

    public void setProgress(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            invalidate();
        }
    }

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = 0;
        a();
    }

    public AlbumCompressProgressView(Context context) {
        super(context);
        this.k = 0;
        a();
    }
}
