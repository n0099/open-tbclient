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
/* loaded from: classes8.dex */
public final class ez extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f5866a;

    /* renamed from: b  reason: collision with root package name */
    private int f5867b;
    private int c;
    private Paint d;

    public ez(Context context) {
        super(context);
        this.f5867b = 5;
        this.c = 5;
        float f = context.getResources().getDisplayMetrics().density;
        this.f5867b = (int) (this.f5867b * f);
        this.c = (int) (f * this.c);
        this.f5866a = new Paint();
        this.f5866a.setColor(-1);
        this.f5866a.setAntiAlias(true);
        this.f5866a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.d = new Paint();
        this.d.setXfermode(null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas2 = new Canvas(createBitmap);
        super.draw(canvas2);
        Path path = new Path();
        path.moveTo(0.0f, this.c);
        path.lineTo(0.0f, 0.0f);
        path.lineTo(this.f5867b, 0.0f);
        path.arcTo(new RectF(0.0f, 0.0f, this.f5867b * 2, this.c * 2), -90.0f, -90.0f);
        path.close();
        canvas2.drawPath(path, this.f5866a);
        Path path2 = new Path();
        path2.moveTo(getWidth(), this.c);
        path2.lineTo(getWidth(), 0.0f);
        path2.lineTo(getWidth() - this.f5867b, 0.0f);
        path2.arcTo(new RectF(getWidth() - (this.f5867b * 2), 0.0f, getWidth(), (this.c * 2) + 0), -90.0f, 90.0f);
        path2.close();
        canvas2.drawPath(path2, this.f5866a);
        Path path3 = new Path();
        path3.moveTo(0.0f, getHeight() - this.c);
        path3.lineTo(0.0f, getHeight());
        path3.lineTo(this.f5867b, getHeight());
        path3.arcTo(new RectF(0.0f, getHeight() - (this.c * 2), (this.f5867b * 2) + 0, getHeight()), 90.0f, 90.0f);
        path3.close();
        canvas2.drawPath(path3, this.f5866a);
        Path path4 = new Path();
        path4.moveTo(getWidth() - this.f5867b, getHeight());
        path4.lineTo(getWidth(), getHeight());
        path4.lineTo(getWidth(), getHeight() - this.c);
        path4.arcTo(new RectF(getWidth() - (this.f5867b * 2), getHeight() - (this.c * 2), getWidth(), getHeight()), 0.0f, 90.0f);
        path4.close();
        canvas2.drawPath(path4, this.f5866a);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, this.d);
        createBitmap.recycle();
    }
}
