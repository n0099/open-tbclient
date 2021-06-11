package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class ArrowView extends View {

    /* renamed from: i  reason: collision with root package name */
    public static int f20198i = 20;
    public static int j = 13;

    /* renamed from: e  reason: collision with root package name */
    public int f20199e;

    /* renamed from: f  reason: collision with root package name */
    public int f20200f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f20201g;

    /* renamed from: h  reason: collision with root package name */
    public Path f20202h;

    public ArrowView(Context context) {
        super(context);
        a(context);
    }

    public final void a(Context context) {
        f20198i = l.g(context, R.dimen.tbds20);
        j = l.g(context, R.dimen.tbds13);
        Paint paint = new Paint();
        this.f20201g = paint;
        paint.setColor(context.getResources().getColor(R.color.CAM_X0201));
        this.f20201g.setAntiAlias(true);
        this.f20202h = new Path();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f20202h.reset();
        this.f20202h.moveTo(this.f20199e / 2, 0.0f);
        this.f20202h.lineTo(0.0f, this.f20200f);
        this.f20202h.lineTo(this.f20199e, this.f20200f);
        this.f20202h.close();
        canvas.drawPath(this.f20202h, this.f20201g);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(f20198i, j);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(f20198i, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, j);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f20199e = i2;
        this.f20200f = i3;
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }
}
