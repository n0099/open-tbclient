package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class ez extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Paint f23659a;

    /* renamed from: b  reason: collision with root package name */
    public int f23660b;

    /* renamed from: c  reason: collision with root package name */
    public int f23661c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f23662d;

    public ez(Context context) {
        super(context);
        this.f23660b = 5;
        this.f23661c = 5;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f23660b = (int) (this.f23660b * f2);
        this.f23661c = (int) (this.f23661c * f2);
        Paint paint = new Paint();
        this.f23659a = paint;
        paint.setColor(-1);
        this.f23659a.setAntiAlias(true);
        this.f23659a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f23662d = paint2;
        paint2.setXfermode(null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        Path path = new Path();
        path.moveTo(0.0f, this.f23661c);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f23660b, 0.0f);
        path.arcTo(new RectF(0.0f, 0.0f, this.f23660b * 2, this.f23661c * 2), -90.0f, -90.0f);
        path.close();
        canvas2.drawPath(path, this.f23659a);
        Path path2 = new Path();
        path2.moveTo(getWidth(), this.f23661c);
        path2.lineTo(getWidth(), 0.0f);
        path2.lineTo(getWidth() - this.f23660b, 0.0f);
        path2.arcTo(new RectF(getWidth() - (this.f23660b * 2), 0.0f, getWidth(), (this.f23661c * 2) + 0), -90.0f, 90.0f);
        path2.close();
        canvas2.drawPath(path2, this.f23659a);
        Path path3 = new Path();
        path3.moveTo(0.0f, getHeight() - this.f23661c);
        path3.lineTo(0.0f, getHeight());
        path3.lineTo(this.f23660b, getHeight());
        path3.arcTo(new RectF(0.0f, getHeight() - (this.f23661c * 2), (this.f23660b * 2) + 0, getHeight()), 90.0f, 90.0f);
        path3.close();
        canvas2.drawPath(path3, this.f23659a);
        Path path4 = new Path();
        path4.moveTo(getWidth() - this.f23660b, getHeight());
        path4.lineTo(getWidth(), getHeight());
        path4.lineTo(getWidth(), getHeight() - this.f23661c);
        path4.arcTo(new RectF(getWidth() - (this.f23660b * 2), getHeight() - (this.f23661c * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        path4.close();
        canvas2.drawPath(path4, this.f23659a);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.f23662d);
        createBitmap.recycle();
    }
}
