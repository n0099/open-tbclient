package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.p.l;
/* loaded from: classes5.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f21866e;

    /* renamed from: f  reason: collision with root package name */
    public Path f21867f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f21868g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f21869h;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.f21866e = 100.0f;
        this.f21869h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f21867f = new Path();
        this.f21868g = new RectF();
    }

    public final boolean b() {
        return getWidth() > l.k(TbadkCoreApplication.getInst());
    }

    public final void c() {
        this.f21867f.addRoundRect(this.f21868g, this.f21869h, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (b()) {
            return;
        }
        canvas.clipPath(this.f21867f);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (b()) {
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        this.f21868g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        c();
    }

    public void setAllCornerRound(float f2) {
        this.f21869h = new float[8];
        int i = 0;
        while (true) {
            float[] fArr = this.f21869h;
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
        this.f21869h = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            this.f21869h[i] = fArr[i];
        }
        c();
        invalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21866e = 100.0f;
        this.f21869h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21866e = 100.0f;
        this.f21869h = new float[]{100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f, 100.0f};
        a();
    }
}
