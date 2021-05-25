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
    public static final String f23762a = "RefreshLoadingView";

    /* renamed from: d  reason: collision with root package name */
    public int f23765d;

    /* renamed from: e  reason: collision with root package name */
    public int f23766e;

    /* renamed from: f  reason: collision with root package name */
    public int f23767f;

    /* renamed from: i  reason: collision with root package name */
    public int f23770i;
    public Context j;

    /* renamed from: b  reason: collision with root package name */
    public Paint f23763b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public Paint f23764c = new Paint();

    /* renamed from: g  reason: collision with root package name */
    public RectF f23768g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public Path f23769h = new Path();

    public RefreshLoadingDrawable(Context context, int i2, int i3) {
        i2 = i2 < 0 ? 0 : i2;
        this.f23765d = i3;
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        int dip2px = DisplayUtils.dip2px(applicationContext, 1.0f);
        this.f23766e = dip2px;
        int i4 = i2 + (dip2px * 2);
        this.f23770i = i4;
        this.f23763b.setAntiAlias(true);
        this.f23763b.setDither(true);
        this.f23763b.setColor(this.f23765d);
        this.f23763b.setStyle(Paint.Style.STROKE);
        this.f23763b.setStrokeJoin(Paint.Join.ROUND);
        this.f23763b.setStrokeCap(Paint.Cap.ROUND);
        this.f23763b.setStrokeWidth(this.f23766e);
        this.f23764c.set(this.f23763b);
        RectF rectF = this.f23768g;
        int i5 = this.f23766e;
        int i6 = this.f23770i;
        rectF.set(i5, i5, i6 - i5, i6 - i5);
        this.f23769h.reset();
        float f2 = i4;
        float f3 = 0.5f * f2;
        float f4 = 0.25f * f2;
        this.f23769h.moveTo(f3, f4);
        float f5 = f2 * 0.75f;
        this.f23769h.lineTo(f5, f3);
        this.f23769h.lineTo(f3, f5);
        this.f23769h.lineTo(f4, f3);
        this.f23769h.close();
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
        canvas.drawArc(this.f23768g, -90.0f, (this.f23767f * 360.0f) / 100.0f, false, this.f23763b);
        if (this.f23767f >= 100) {
            this.f23764c.setColor(this.f23765d);
            canvas.drawPath(this.f23769h, this.f23764c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f23770i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f23770i;
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
        if (this.f23767f == i2) {
            return;
        }
        this.f23767f = i2;
    }
}
