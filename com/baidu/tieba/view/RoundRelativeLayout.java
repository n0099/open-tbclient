package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f22172e;

    /* renamed from: f  reason: collision with root package name */
    public Path f22173f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f22174g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f22175h;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.f22172e = 100.0f;
        this.f22175h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f22173f = new Path();
        this.f22174g = new RectF();
    }

    public final boolean b() {
        return getWidth() > l.k(TbadkCoreApplication.getInst());
    }

    public final void c() {
        this.f22173f.addRoundRect(this.f22174g, this.f22175h, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            return;
        }
        canvas.clipPath(this.f22173f);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (b()) {
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        this.f22174g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        c();
    }

    public void setAllCornerRound(float f2) {
        this.f22175h = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.f22175h;
            if (i < fArr.length) {
                fArr[i] = f2;
                i++;
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
        this.f22175h = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            this.f22175h[i] = fArr[i];
        }
        c();
        invalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22172e = 100.0f;
        this.f22175h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22172e = 100.0f;
        this.f22175h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }
}
