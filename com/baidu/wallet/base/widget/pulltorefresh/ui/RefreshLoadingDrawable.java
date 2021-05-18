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
    public static final String f23833a = "RefreshLoadingView";

    /* renamed from: d  reason: collision with root package name */
    public int f23836d;

    /* renamed from: e  reason: collision with root package name */
    public int f23837e;

    /* renamed from: f  reason: collision with root package name */
    public int f23838f;

    /* renamed from: i  reason: collision with root package name */
    public int f23841i;
    public Context j;

    /* renamed from: b  reason: collision with root package name */
    public Paint f23834b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Paint f23835c = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public RectF f23839g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public Path f23840h = new Path();

    public RefreshLoadingDrawable(Context context, int i2, int i3) {
        i2 = i2 < 0 ? 0 : i2;
        this.f23836d = i3;
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        int dip2px = DisplayUtils.dip2px(applicationContext, 1.0f);
        this.f23837e = dip2px;
        int i4 = i2 + (dip2px * 2);
        this.f23841i = i4;
        this.f23834b.setAntiAlias(true);
        this.f23834b.setDither(true);
        this.f23834b.setColor(this.f23836d);
        this.f23834b.setStyle(Paint.Style.STROKE);
        this.f23834b.setStrokeJoin(Paint.Join.ROUND);
        this.f23834b.setStrokeCap(Paint.Cap.ROUND);
        this.f23834b.setStrokeWidth(this.f23837e);
        this.f23835c.set(this.f23834b);
        RectF rectF = this.f23839g;
        int i5 = this.f23837e;
        int i6 = this.f23841i;
        rectF.set(i5, i5, i6 - i5, i6 - i5);
        this.f23840h.reset();
        float f2 = i4;
        float f3 = 0.5f * f2;
        float f4 = 0.25f * f2;
        this.f23840h.moveTo(f3, f4);
        float f5 = f2 * 0.75f;
        this.f23840h.lineTo(f5, f3);
        this.f23840h.lineTo(f3, f5);
        this.f23840h.lineTo(f4, f3);
        this.f23840h.close();
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
        canvas.drawArc(this.f23839g, -90.0f, (this.f23838f * 360.0f) / 100.0f, false, this.f23834b);
        if (this.f23838f >= 100) {
            this.f23835c.setColor(this.f23836d);
            canvas.drawPath(this.f23840h, this.f23835c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f23841i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f23841i;
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
        if (this.f23838f == i2) {
            return;
        }
        this.f23838f = i2;
    }
}
