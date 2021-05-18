package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f20267e;

    /* renamed from: f  reason: collision with root package name */
    public Path f20268f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f20269g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f20270h;

    public RoundRelativeLayout(Context context) {
        super(context);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.f20267e = g2;
        this.f20270h = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f20268f = new Path();
        this.f20269g = new RectF();
    }

    public final void b() {
        this.f20268f.addRoundRect(this.f20269g, this.f20270h, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.clipPath(this.f20268f);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f20269g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        b();
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.f20270h = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            this.f20270h[i2] = fArr[i2];
        }
        b();
        invalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.f20267e = g2;
        this.f20270h = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        a();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.f20267e = g2;
        this.f20270h = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        a();
    }
}
