package com.baidu.tieba.view.bubbleView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BubbleLayout extends FrameLayout {
    public static float Os = -1.0f;
    private float On;
    private float Oo;
    private float Op;
    private float Oq;
    private int Ov;
    private ArrowDirection jLq;
    private a jLr;
    private int mStrokeColor;
    private float mStrokeWidth;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.On = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.Op = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.Oo = obtainStyledAttributes.getDimension(7, 0.0f);
        this.Oq = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.Ov = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, Os);
        this.mStrokeColor = obtainStyledAttributes.getColor(5, -7829368);
        this.jLq = ArrowDirection.fromInt(obtainStyledAttributes.getInt(6, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        initPadding();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        e(0, getWidth(), 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jLr != null) {
            this.jLr.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void e(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.jLr = new a(new RectF(i, i3, i2, i4), this.On, this.Oo, this.Op, this.Oq, this.mStrokeWidth, this.mStrokeColor, this.Ov, this.jLq);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.jLq) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.On);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.On);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.Op);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.Op);
                break;
        }
        if (this.mStrokeWidth > 0.0f) {
            paddingLeft = (int) (paddingLeft + this.mStrokeWidth);
            paddingRight = (int) (paddingRight + this.mStrokeWidth);
            paddingTop = (int) (paddingTop + this.mStrokeWidth);
            paddingBottom = (int) (paddingBottom + this.mStrokeWidth);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void ny() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.jLq) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.On);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.On);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.Op);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.Op);
                break;
        }
        if (this.mStrokeWidth > 0.0f) {
            paddingLeft = (int) (paddingLeft - this.mStrokeWidth);
            paddingRight = (int) (paddingRight - this.mStrokeWidth);
            paddingTop = (int) (paddingTop - this.mStrokeWidth);
            paddingBottom = (int) (paddingBottom - this.mStrokeWidth);
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    static float c(float f, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }

    public BubbleLayout aA(float f) {
        ny();
        this.Oq = f;
        initPadding();
        return this;
    }

    public BubbleLayout Bp(int i) {
        this.Ov = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.jLq;
    }

    public float getArrowWidth() {
        return this.On;
    }

    public float getCornersRadius() {
        return this.Oo;
    }

    public float getArrowHeight() {
        return this.Op;
    }

    public float getArrowPosition() {
        return this.Oq;
    }

    public int getBubbleColor() {
        return this.Ov;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
