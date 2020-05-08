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
    public static float ape = -1.0f;
    private float aoZ;
    private float apa;
    private float apb;
    private float apc;
    private int aph;
    private ArrowDirection lvS;
    private a lvT;
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
        this.aoZ = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.apb = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.apa = obtainStyledAttributes.getDimension(7, 0.0f);
        this.apc = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.aph = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, ape);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.lvS = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.lvT != null) {
            this.lvT.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.lvT = new a(new RectF(i, i3, i2, i4), this.aoZ, this.apa, this.apb, this.apc, this.mStrokeWidth, this.mStrokeColor, this.aph, this.lvS);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.lvS) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aoZ);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aoZ);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.apb);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.apb);
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

    private void ud() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.lvS) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aoZ);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aoZ);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.apb);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.apb);
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

    public BubbleLayout ay(float f) {
        ud();
        this.apc = f;
        initPadding();
        return this;
    }

    public BubbleLayout EH(int i) {
        this.aph = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.lvS;
    }

    public float getArrowWidth() {
        return this.aoZ;
    }

    public float getCornersRadius() {
        return this.apa;
    }

    public float getArrowHeight() {
        return this.apb;
    }

    public float getArrowPosition() {
        return this.apc;
    }

    public int getBubbleColor() {
        return this.aph;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
