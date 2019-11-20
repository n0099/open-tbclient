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
    public static float NR = -1.0f;
    private float NL;
    private float NM;
    private float NN;
    private float NP;
    private int NV;
    private a jKA;
    private ArrowDirection jKz;
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
        this.NL = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.NN = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.NM = obtainStyledAttributes.getDimension(7, 0.0f);
        this.NP = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.NV = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, NR);
        this.mStrokeColor = obtainStyledAttributes.getColor(5, -7829368);
        this.jKz = ArrowDirection.fromInt(obtainStyledAttributes.getInt(6, ArrowDirection.LEFT.getValue()));
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
        if (this.jKA != null) {
            this.jKA.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void e(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.jKA = new a(new RectF(i, i3, i2, i4), this.NL, this.NM, this.NN, this.NP, this.mStrokeWidth, this.mStrokeColor, this.NV, this.jKz);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.jKz) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.NL);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.NL);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.NN);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.NN);
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
        switch (this.jKz) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.NL);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.NL);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.NN);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.NN);
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
        this.NP = f;
        initPadding();
        return this;
    }

    public BubbleLayout Bo(int i) {
        this.NV = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.jKz;
    }

    public float getArrowWidth() {
        return this.NL;
    }

    public float getCornersRadius() {
        return this.NM;
    }

    public float getArrowHeight() {
        return this.NN;
    }

    public float getArrowPosition() {
        return this.NP;
    }

    public int getBubbleColor() {
        return this.NV;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
