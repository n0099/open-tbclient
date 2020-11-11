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
    public static float aGV = -1.0f;
    private float aGQ;
    private float aGR;
    private float aGS;
    private float aGT;
    private int aGY;
    private int mStrokeColor;
    private float mStrokeWidth;
    private ArrowDirection nCw;
    private a nCx;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.aGQ = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aGS = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aGR = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.aGT = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aGY = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, aGV);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.nCw = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.nCx != null) {
            this.nCx.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.nCx = new a(new RectF(i, i3, i2, i4), this.aGQ, this.aGR, this.aGS, this.aGT, this.mStrokeWidth, this.mStrokeColor, this.aGY, this.nCw);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.nCw) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aGQ);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aGQ);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aGS);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aGS);
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

    private void Dk() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.nCw) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aGQ);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aGQ);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aGS);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aGS);
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

    static float b(float f, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }

    public BubbleLayout aR(float f) {
        Dk();
        this.aGT = f;
        initPadding();
        return this;
    }

    public BubbleLayout Lf(int i) {
        this.aGY = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.nCw;
    }

    public float getArrowWidth() {
        return this.aGQ;
    }

    public float getCornersRadius() {
        return this.aGR;
    }

    public float getArrowHeight() {
        return this.aGS;
    }

    public float getArrowPosition() {
        return this.aGT;
    }

    public int getBubbleColor() {
        return this.aGY;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
