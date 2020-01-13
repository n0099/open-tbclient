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
    public static float Vg = -1.0f;
    private float Va;
    private float Vb;
    private float Vc;
    private float Ve;
    private int Vj;
    private ArrowDirection kIB;
    private a kIC;
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
        this.Va = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.Vc = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.Vb = obtainStyledAttributes.getDimension(7, 0.0f);
        this.Ve = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.Vj = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, Vg);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.kIB = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        initPadding();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        f(0, getWidth(), 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kIC != null) {
            this.kIC.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.kIC = new a(new RectF(i, i3, i2, i4), this.Va, this.Vb, this.Vc, this.Ve, this.mStrokeWidth, this.mStrokeColor, this.Vj, this.kIB);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kIB) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.Va);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.Va);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.Vc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.Vc);
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

    private void oX() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kIB) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.Va);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.Va);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.Vc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.Vc);
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

    public BubbleLayout aP(float f) {
        oX();
        this.Ve = f;
        initPadding();
        return this;
    }

    public BubbleLayout DR(int i) {
        this.Vj = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.kIB;
    }

    public float getArrowWidth() {
        return this.Va;
    }

    public float getCornersRadius() {
        return this.Vb;
    }

    public float getArrowHeight() {
        return this.Vc;
    }

    public float getArrowPosition() {
        return this.Ve;
    }

    public int getBubbleColor() {
        return this.Vj;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
