package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f21701e;

    /* renamed from: f  reason: collision with root package name */
    public Path f21702f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f21703g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f21704h;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.f21701e = 100.0f;
        this.f21704h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f21702f = new Path();
        this.f21703g = new RectF();
    }

    public final boolean b() {
        return getWidth() > l.k(TbadkCoreApplication.getInst());
    }

    public final void c() {
        this.f21702f.addRoundRect(this.f21703g, this.f21704h, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            return;
        }
        canvas.clipPath(this.f21702f);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (b()) {
            return;
        }
        super.onLayout(z, i2, i3, i4, i5);
        this.f21703g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        c();
    }

    public void setAllCornerRound(float f2) {
        this.f21704h = new float[8];
        int i2 = 0;
        while (true) {
            float[] fArr = this.f21704h;
            if (i2 < fArr.length) {
                fArr[i2] = f2;
                i2++;
            } else {
                c();
                invalidate();
                return;
            }
        }
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.f21704h = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            this.f21704h[i2] = fArr[i2];
        }
        c();
        invalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21701e = 100.0f;
        this.f21704h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21701e = 100.0f;
        this.f21704h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }
}
