package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class BottomShadowLinearLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f22372e;

    /* renamed from: f  reason: collision with root package name */
    public int f22373f;

    /* renamed from: g  reason: collision with root package name */
    public float f22374g;

    /* renamed from: h  reason: collision with root package name */
    public float f22375h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f22376i;
    public Paint j;
    public RectF k;
    public RectF l;

    public BottomShadowLinearLayout(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        Paint paint = new Paint();
        this.f22376i = paint;
        paint.reset();
        this.f22376i.setAntiAlias(true);
        this.f22376i.setStyle(Paint.Style.FILL);
        this.f22376i.setDither(true);
        Paint paint2 = new Paint();
        this.j = paint2;
        paint2.reset();
        this.j.setAntiAlias(true);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setDither(true);
        this.f22374g = l.g(context, R.dimen.ds20);
        this.f22375h = l.g(context, R.dimen.ds25);
        setLayerType(1, this.f22376i);
        b();
    }

    public void b() {
        this.f22376i.setColor(SkinManager.getColor(R.color.CAM_X0207));
        this.j.setColor(SkinManager.getColor(R.color.CAM_X0207));
        this.f22376i.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f22372e <= 0 || this.f22373f <= 0) {
            return;
        }
        if (this.k == null) {
            this.k = new RectF(0.0f, 0.0f, this.f22372e, this.f22373f - this.f22375h);
        }
        RectF rectF = this.k;
        float f2 = this.f22374g;
        canvas.drawRoundRect(rectF, f2, f2, this.f22376i);
        if (this.l == null) {
            this.l = new RectF(0.0f, 0.0f, this.f22372e, this.f22373f / 2);
        }
        canvas.drawRect(this.l, this.j);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f22372e = getMeasuredWidth();
        this.f22373f = getMeasuredHeight();
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
