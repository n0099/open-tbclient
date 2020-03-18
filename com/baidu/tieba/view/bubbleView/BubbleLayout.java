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
    public static float WW = -1.0f;
    private float WR;
    private float WS;
    private float WT;
    private float WU;
    private int WZ;
    private ArrowDirection kLw;
    private a kLx;
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
        this.WR = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.WT = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.WS = obtainStyledAttributes.getDimension(7, 0.0f);
        this.WU = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.WZ = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, WW);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.kLw = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.kLx != null) {
            this.kLx.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.kLx = new a(new RectF(i, i3, i2, i4), this.WR, this.WS, this.WT, this.WU, this.mStrokeWidth, this.mStrokeColor, this.WZ, this.kLw);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kLw) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.WR);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.WR);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.WT);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.WT);
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

    private void pN() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kLw) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.WR);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.WR);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.WT);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.WT);
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

    public BubbleLayout aO(float f) {
        pN();
        this.WU = f;
        initPadding();
        return this;
    }

    public BubbleLayout Ef(int i) {
        this.WZ = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.kLw;
    }

    public float getArrowWidth() {
        return this.WR;
    }

    public float getCornersRadius() {
        return this.WS;
    }

    public float getArrowHeight() {
        return this.WT;
    }

    public float getArrowPosition() {
        return this.WU;
    }

    public int getBubbleColor() {
        return this.WZ;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
