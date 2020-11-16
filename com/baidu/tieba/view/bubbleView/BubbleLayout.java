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
    public static float aFk = -1.0f;
    private float aFf;
    private float aFg;
    private float aFh;
    private float aFi;
    private int aFn;
    private int mStrokeColor;
    private float mStrokeWidth;
    private ArrowDirection nDT;
    private a nDU;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.aFf = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aFh = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aFg = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.aFi = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aFn = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, aFk);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.nDT = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.nDU != null) {
            this.nDU.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.nDU = new a(new RectF(i, i3, i2, i4), this.aFf, this.aFg, this.aFh, this.aFi, this.mStrokeWidth, this.mStrokeColor, this.aFn, this.nDT);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.nDT) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aFf);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aFf);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aFh);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aFh);
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

    private void CB() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.nDT) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aFf);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aFf);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aFh);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aFh);
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

    public BubbleLayout aY(float f) {
        CB();
        this.aFi = f;
        initPadding();
        return this;
    }

    public BubbleLayout LI(int i) {
        this.aFn = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.nDT;
    }

    public float getArrowWidth() {
        return this.aFf;
    }

    public float getCornersRadius() {
        return this.aFg;
    }

    public float getArrowHeight() {
        return this.aFh;
    }

    public float getArrowPosition() {
        return this.aFi;
    }

    public int getBubbleColor() {
        return this.aFn;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
