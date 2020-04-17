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
    public static float aoY = -1.0f;
    private float aoT;
    private float aoU;
    private float aoV;
    private float aoW;
    private int apb;
    private ArrowDirection lvO;
    private a lvP;
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
        this.aoT = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.aoV = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.aoU = obtainStyledAttributes.getDimension(7, 0.0f);
        this.aoW = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.apb = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, aoY);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.lvO = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.lvP != null) {
            this.lvP.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.lvP = new a(new RectF(i, i3, i2, i4), this.aoT, this.aoU, this.aoV, this.aoW, this.mStrokeWidth, this.mStrokeColor, this.apb, this.lvO);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.lvO) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aoT);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aoT);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aoV);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aoV);
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

    private void ue() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.lvO) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aoT);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aoT);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aoV);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aoV);
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
        ue();
        this.aoW = f;
        initPadding();
        return this;
    }

    public BubbleLayout EH(int i) {
        this.apb = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.lvO;
    }

    public float getArrowWidth() {
        return this.aoT;
    }

    public float getCornersRadius() {
        return this.aoU;
    }

    public float getArrowHeight() {
        return this.aoV;
    }

    public float getArrowPosition() {
        return this.aoW;
    }

    public int getBubbleColor() {
        return this.apb;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
