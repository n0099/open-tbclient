package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class RoundRelativeLayout extends RelativeLayout {
    private float[] mRadius;
    private RectF mRectF;
    private float mRoundLayoutRadius;
    private Path mRoundPath;

    public RoundRelativeLayout(Context context) {
        super(context);
        this.mRoundLayoutRadius = 100.0f;
        this.mRadius = new float[]{this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius};
        init();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRoundLayoutRadius = 100.0f;
        this.mRadius = new float[]{this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius};
        init();
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRoundLayoutRadius = 100.0f;
        this.mRadius = new float[]{this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius, this.mRoundLayoutRadius};
        init();
    }

    private void init() {
        setWillNotDraw(false);
        this.mRoundPath = new Path();
        this.mRectF = new RectF();
    }

    private void setRoundPath() {
        this.mRoundPath.addRoundRect(this.mRectF, this.mRadius, Path.Direction.CW);
    }

    public void setRoundLayoutRadius(float[] fArr) {
        if (fArr != null && fArr.length > 0) {
            this.mRadius = new float[fArr.length];
            for (int i = 0; i < fArr.length; i++) {
                this.mRadius[i] = fArr[i];
            }
            setRoundPath();
            invalidate();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        setRoundPath();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.clipPath(this.mRoundPath);
        super.draw(canvas);
    }
}
