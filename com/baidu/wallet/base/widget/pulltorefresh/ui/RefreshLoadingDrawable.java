package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class RefreshLoadingDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24588a = "RefreshLoadingView";

    /* renamed from: d  reason: collision with root package name */
    public int f24591d;

    /* renamed from: e  reason: collision with root package name */
    public int f24592e;

    /* renamed from: f  reason: collision with root package name */
    public int f24593f;

    /* renamed from: i  reason: collision with root package name */
    public int f24596i;
    public Context j;

    /* renamed from: b  reason: collision with root package name */
    public Paint f24589b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Paint f24590c = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public RectF f24594g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public Path f24595h = new Path();

    public RefreshLoadingDrawable(Context context, int i2, int i3) {
        i2 = i2 < 0 ? 0 : i2;
        this.f24591d = i3;
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        int dip2px = DisplayUtils.dip2px(applicationContext, 1.0f);
        this.f24592e = dip2px;
        int i4 = i2 + (dip2px * 2);
        this.f24596i = i4;
        this.f24589b.setAntiAlias(true);
        this.f24589b.setDither(true);
        this.f24589b.setColor(this.f24591d);
        this.f24589b.setStyle(Paint.Style.STROKE);
        this.f24589b.setStrokeJoin(Paint.Join.ROUND);
        this.f24589b.setStrokeCap(Paint.Cap.ROUND);
        this.f24589b.setStrokeWidth(this.f24592e);
        this.f24590c.set(this.f24589b);
        RectF rectF = this.f24594g;
        int i5 = this.f24592e;
        int i6 = this.f24596i;
        rectF.set(i5, i5, i6 - i5, i6 - i5);
        this.f24595h.reset();
        float f2 = i4;
        float f3 = 0.5f * f2;
        float f4 = 0.25f * f2;
        this.f24595h.moveTo(f3, f4);
        float f5 = f2 * 0.75f;
        this.f24595h.lineTo(f5, f3);
        this.f24595h.lineTo(f3, f5);
        this.f24595h.lineTo(f4, f3);
        this.f24595h.close();
    }

    public static RefreshLoadingDrawable newInstanceBlue(Context context) {
        return new RefreshLoadingDrawable(context, DisplayUtils.dip2px(context.getApplicationContext(), 18.0f), ResUtils.getColor(context, "wallet_base_font_text8Color"));
    }

    public static RefreshLoadingDrawable newInstanceRed(Context context) {
        return new RefreshLoadingDrawable(context, DisplayUtils.dip2px(context.getApplicationContext(), 18.0f), ResUtils.getColor(context, "wallet_base_font_text6Color"));
    }

    public static RefreshLoadingDrawable newInstanceWhite(Context context) {
        return new RefreshLoadingDrawable(context, DisplayUtils.dip2px(context.getApplicationContext(), 18.0f), ResUtils.getColor(context, "wallet_base_whiteColor"));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawArc(this.f24594g, -90.0f, (this.f24593f * 360.0f) / 100.0f, false, this.f24589b);
        if (this.f24593f >= 100) {
            this.f24590c.setColor(this.f24591d);
            canvas.drawPath(this.f24595h, this.f24590c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f24596i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f24596i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        if (this.f24593f == i2) {
            return;
        }
        this.f24593f = i2;
    }
}
