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
    public static float aCS = -1.0f;
    private float aCN;
    private float aCO;
    private float aCP;
    private float aCQ;
    private int aCV;
    private int mStrokeColor;
    private float mStrokeWidth;
    private ArrowDirection mUC;
    private a mUD;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.aCN = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aCP = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aCO = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.aCQ = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aCV = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, aCS);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.mUC = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.mUD != null) {
            this.mUD.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.mUD = new a(new RectF(i, i3, i2, i4), this.aCN, this.aCO, this.aCP, this.aCQ, this.mStrokeWidth, this.mStrokeColor, this.aCV, this.mUC);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.mUC) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aCN);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aCN);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aCP);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aCP);
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

    private void BO() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.mUC) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aCN);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aCN);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aCP);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aCP);
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

    public BubbleLayout aH(float f) {
        BO();
        this.aCQ = f;
        initPadding();
        return this;
    }

    public BubbleLayout JU(int i) {
        this.aCV = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.mUC;
    }

    public float getArrowWidth() {
        return this.aCN;
    }

    public float getCornersRadius() {
        return this.aCO;
    }

    public float getArrowHeight() {
        return this.aCP;
    }

    public float getArrowPosition() {
        return this.aCQ;
    }

    public int getBubbleColor() {
        return this.aCV;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
