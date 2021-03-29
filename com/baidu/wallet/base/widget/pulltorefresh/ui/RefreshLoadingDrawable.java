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
    public static final String f24153a = "RefreshLoadingView";

    /* renamed from: d  reason: collision with root package name */
    public int f24156d;

    /* renamed from: e  reason: collision with root package name */
    public int f24157e;

    /* renamed from: f  reason: collision with root package name */
    public int f24158f;
    public int i;
    public Context j;

    /* renamed from: b  reason: collision with root package name */
    public Paint f24154b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Paint f24155c = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public RectF f24159g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public Path f24160h = new Path();

    public RefreshLoadingDrawable(Context context, int i, int i2) {
        i = i < 0 ? 0 : i;
        this.f24156d = i2;
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        int dip2px = DisplayUtils.dip2px(applicationContext, 1.0f);
        this.f24157e = dip2px;
        int i3 = i + (dip2px * 2);
        this.i = i3;
        this.f24154b.setAntiAlias(true);
        this.f24154b.setDither(true);
        this.f24154b.setColor(this.f24156d);
        this.f24154b.setStyle(Paint.Style.STROKE);
        this.f24154b.setStrokeJoin(Paint.Join.ROUND);
        this.f24154b.setStrokeCap(Paint.Cap.ROUND);
        this.f24154b.setStrokeWidth(this.f24157e);
        this.f24155c.set(this.f24154b);
        RectF rectF = this.f24159g;
        int i4 = this.f24157e;
        int i5 = this.i;
        rectF.set(i4, i4, i5 - i4, i5 - i4);
        this.f24160h.reset();
        float f2 = i3;
        float f3 = 0.5f * f2;
        float f4 = 0.25f * f2;
        this.f24160h.moveTo(f3, f4);
        float f5 = f2 * 0.75f;
        this.f24160h.lineTo(f5, f3);
        this.f24160h.lineTo(f3, f5);
        this.f24160h.lineTo(f4, f3);
        this.f24160h.close();
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
        canvas.drawArc(this.f24159g, -90.0f, (this.f24158f * 360.0f) / 100.0f, false, this.f24154b);
        if (this.f24158f >= 100) {
            this.f24155c.setColor(this.f24156d);
            canvas.drawPath(this.f24160h, this.f24155c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        if (this.f24158f == i) {
            return;
        }
        this.f24158f = i;
    }
}
