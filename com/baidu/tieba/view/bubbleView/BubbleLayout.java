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
    public static float aFl = -1.0f;
    private float aFg;
    private float aFh;
    private float aFi;
    private float aFj;
    private int aFo;
    private int aFr;
    private float mStrokeWidth;
    private ArrowDirection oaR;
    private a oaS;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.aFg = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.aFi = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.aFh = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.aFj = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.aFo = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, aFl);
        this.aFr = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.oaR = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.oaS != null) {
            this.oaS.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.oaS = new a(new RectF(i, i3, i2, i4), this.aFg, this.aFh, this.aFi, this.aFj, this.mStrokeWidth, this.aFr, this.aFo, this.oaR);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.oaR) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aFg);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aFg);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aFi);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aFi);
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

    private void Ap() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.oaR) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aFg);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aFg);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aFi);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aFi);
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

    public BubbleLayout be(float f) {
        Ap();
        this.aFj = f;
        initPadding();
        return this;
    }

    public BubbleLayout Lb(int i) {
        this.aFo = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.oaR;
    }

    public float getArrowWidth() {
        return this.aFg;
    }

    public float getCornersRadius() {
        return this.aFh;
    }

    public float getArrowHeight() {
        return this.aFi;
    }

    public float getArrowPosition() {
        return this.aFj;
    }

    public int getBubbleColor() {
        return this.aFo;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.aFr;
    }
}
