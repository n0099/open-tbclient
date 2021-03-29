package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public float f20787e;

    /* renamed from: f  reason: collision with root package name */
    public Path f20788f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f20789g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f20790h;

    public RoundRelativeLayout(Context context) {
        super(context);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.f20787e = g2;
        this.f20790h = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        a();
    }

    public final void a() {
        setWillNotDraw(false);
        this.f20788f = new Path();
        this.f20789g = new RectF();
    }

    public final void b() {
        this.f20788f.addRoundRect(this.f20789g, this.f20790h, Path.Direction.CW);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.clipPath(this.f20788f);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f20789g.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        b();
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        this.f20790h = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            this.f20790h[i] = fArr[i];
        }
        b();
        invalidate();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.f20787e = g2;
        this.f20790h = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        a();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds20);
        this.f20787e = g2;
        this.f20790h = new float[]{g2, g2, g2, g2, g2, g2, g2, g2};
        a();
    }
}
