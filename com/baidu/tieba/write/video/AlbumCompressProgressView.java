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
    public int f22082e;

    /* renamed from: f  reason: collision with root package name */
    public int f22083f;

    /* renamed from: g  reason: collision with root package name */
    public int f22084g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f22085h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f22086i;
    public RectF j;
    public int k;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f22082e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f22083f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f22084g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f22085h = paint;
        paint.setStrokeWidth(this.f22083f);
        this.f22085h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f22085h.setStyle(Paint.Style.STROKE);
        this.f22085h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f22086i = paint2;
        paint2.setStrokeWidth(this.f22084g);
        this.f22086i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.f22086i.setStyle(Paint.Style.STROKE);
        this.f22086i.setAntiAlias(true);
        int i2 = this.f22083f;
        int i3 = this.f22082e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f22086i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f22085h);
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
