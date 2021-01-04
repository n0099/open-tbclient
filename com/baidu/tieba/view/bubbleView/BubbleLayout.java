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
    public static float aIl = -1.0f;
    private float aIg;
    private float aIh;
    private float aIi;
    private float aIj;
    private int aIo;
    private int aIr;
    private float mStrokeWidth;
    private ArrowDirection nVs;
    private a nVt;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.aIg = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, b(8.0f, context));
        this.aIi = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, b(8.0f, context));
        this.aIh = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.aIj = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, b(12.0f, context));
        this.aIo = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, aIl);
        this.aIr = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.nVs = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.nVt != null) {
            this.nVt.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.nVt = new a(new RectF(i, i3, i2, i4), this.aIg, this.aIh, this.aIi, this.aIj, this.mStrokeWidth, this.aIr, this.aIo, this.nVs);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.nVs) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aIg);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aIg);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aIi);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aIi);
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

    private void DA() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.nVs) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aIg);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aIg);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aIi);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aIi);
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

    public BubbleLayout bb(float f) {
        DA();
        this.aIj = f;
        initPadding();
        return this;
    }

    public BubbleLayout Mn(int i) {
        this.aIo = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.nVs;
    }

    public float getArrowWidth() {
        return this.aIg;
    }

    public float getCornersRadius() {
        return this.aIh;
    }

    public float getArrowHeight() {
        return this.aIi;
    }

    public float getArrowPosition() {
        return this.aIj;
    }

    public int getBubbleColor() {
        return this.aIo;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.aIr;
    }
}
