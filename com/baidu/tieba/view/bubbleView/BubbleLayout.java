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
    public static float atY = -1.0f;
    private float atT;
    private float atU;
    private float atV;
    private float atW;
    private int aub;
    private ArrowDirection lOO;
    private a lOP;
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
        this.atT = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.atV = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.atU = obtainStyledAttributes.getDimension(7, 0.0f);
        this.atW = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.aub = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, atY);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.lOO = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.lOP != null) {
            this.lOP.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.lOP = new a(new RectF(i, i3, i2, i4), this.atT, this.atU, this.atV, this.atW, this.mStrokeWidth, this.mStrokeColor, this.aub, this.lOO);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.lOO) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.atT);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.atT);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.atV);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.atV);
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

    private void vk() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.lOO) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.atT);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.atT);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.atV);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.atV);
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

    public BubbleLayout ax(float f) {
        vk();
        this.atW = f;
        initPadding();
        return this;
    }

    public BubbleLayout Fs(int i) {
        this.aub = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.lOO;
    }

    public float getArrowWidth() {
        return this.atT;
    }

    public float getCornersRadius() {
        return this.atU;
    }

    public float getArrowHeight() {
        return this.atV;
    }

    public float getArrowPosition() {
        return this.atW;
    }

    public int getBubbleColor() {
        return this.aub;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
