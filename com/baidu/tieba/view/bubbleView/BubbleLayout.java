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
    public static float aGL = -1.0f;
    private float aGG;
    private float aGH;
    private float aGI;
    private float aGJ;
    private int aGO;
    private int aGR;
    private float mStrokeWidth;
    private ArrowDirection ody;
    private a odz;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.aGG = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowWidth, c(8.0f, context));
        this.aGI = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowHeight, c(8.0f, context));
        this.aGH = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.aGJ = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_arrowPosition, c(12.0f, context));
        this.aGO = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_bubbleColor, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(R.styleable.BubbleLayout_bl_strokeWidth, aGL);
        this.aGR = obtainStyledAttributes.getColor(R.styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.ody = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R.styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
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
        if (this.odz != null) {
            this.odz.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.odz = new a(new RectF(i, i3, i2, i4), this.aGG, this.aGH, this.aGI, this.aGJ, this.mStrokeWidth, this.aGR, this.aGO, this.ody);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.ody) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.aGG);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.aGG);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.aGI);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.aGI);
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

    private void As() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.ody) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.aGG);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.aGG);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.aGI);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.aGI);
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

    public BubbleLayout bi(float f) {
        As();
        this.aGJ = f;
        initPadding();
        return this;
    }

    public BubbleLayout Lg(int i) {
        this.aGO = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.ody;
    }

    public float getArrowWidth() {
        return this.aGG;
    }

    public float getCornersRadius() {
        return this.aGH;
    }

    public float getArrowHeight() {
        return this.aGI;
    }

    public float getArrowPosition() {
        return this.aGJ;
    }

    public int getBubbleColor() {
        return this.aGO;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.aGR;
    }
}
