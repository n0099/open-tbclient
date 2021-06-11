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
    public int f22000e;

    /* renamed from: f  reason: collision with root package name */
    public int f22001f;

    /* renamed from: g  reason: collision with root package name */
    public int f22002g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f22003h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f22004i;
    public RectF j;
    public int k;

    public AlbumCompressProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f22000e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f22001f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f22002g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f22003h = paint;
        paint.setStrokeWidth(this.f22001f);
        this.f22003h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f22003h.setStyle(Paint.Style.STROKE);
        this.f22003h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f22004i = paint2;
        paint2.setStrokeWidth(this.f22002g);
        this.f22004i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.f22004i.setStyle(Paint.Style.STROKE);
        this.f22004i.setAntiAlias(true);
        int i2 = this.f22001f;
        int i3 = this.f22000e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f22004i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f22003h);
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
