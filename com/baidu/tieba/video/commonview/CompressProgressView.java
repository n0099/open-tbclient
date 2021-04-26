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
    public int f22040e;

    /* renamed from: f  reason: collision with root package name */
    public int f22041f;

    /* renamed from: g  reason: collision with root package name */
    public int f22042g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f22043h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f22044i;
    public RectF j;
    public int k;

    public CompressProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = 0;
        a();
    }

    public void a() {
        this.f22040e = getResources().getDimensionPixelSize(R.dimen.ds100);
        this.f22041f = getResources().getDimensionPixelSize(R.dimen.ds4);
        this.f22042g = getResources().getDimensionPixelSize(R.dimen.ds2);
        Paint paint = new Paint();
        this.f22043h = paint;
        paint.setStrokeWidth(this.f22041f);
        this.f22043h.setColor(getResources().getColor(R.color.CAM_X0201));
        this.f22043h.setStyle(Paint.Style.STROKE);
        this.f22043h.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f22044i = paint2;
        paint2.setStrokeWidth(this.f22042g);
        this.f22044i.setColor(getResources().getColor(R.color.CAM_X0101));
        this.f22044i.setStyle(Paint.Style.STROKE);
        this.f22044i.setAntiAlias(true);
        int i2 = this.f22041f;
        int i3 = this.f22040e;
        this.j = new RectF(i2, i2, i3 + i2, i3 + i2);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawArc(this.j, 270.0f, 360.0f, false, this.f22044i);
        canvas.drawArc(this.j, 270.0f, (this.k * 360) / 100, false, this.f22043h);
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
