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
    public static float axf = -1.0f;
    private float axa;
    private float axb;
    private float axc;
    private float axd;
    private int axi;
    private int mStrokeColor;
    private float mStrokeWidth;
    private ArrowDirection msj;
    private a msk;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.axa = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.axc = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.axb = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.axd = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.axi = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, axf);
        this.mStrokeColor = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.msj = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.msk != null) {
            this.msk.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.msk = new a(new RectF(i, i3, i2, i4), this.axa, this.axb, this.axc, this.axd, this.mStrokeWidth, this.mStrokeColor, this.axi, this.msj);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.msj) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.axa);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.axa);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.axc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.axc);
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

    private void wb() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.msj) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.axa);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.axa);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.axc);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.axc);
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

    public BubbleLayout aB(float f) {
        wb();
        this.axd = f;
        initPadding();
        return this;
    }

    public BubbleLayout GU(int i) {
        this.axi = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.msj;
    }

    public float getArrowWidth() {
        return this.axa;
    }

    public float getCornersRadius() {
        return this.axb;
    }

    public float getArrowHeight() {
        return this.axc;
    }

    public float getArrowPosition() {
        return this.axd;
    }

    public int getBubbleColor() {
        return this.axi;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
