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
    public static float UO = -1.0f;
    private float UJ;
    private float UK;
    private float UL;
    private float UM;
    private int US;
    private ArrowDirection kFa;
    private a kFb;
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
        this.UJ = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.UL = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.UK = obtainStyledAttributes.getDimension(7, 0.0f);
        this.UM = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.US = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, UO);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.kFa = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.kFb != null) {
            this.kFb.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.kFb = new a(new RectF(i, i3, i2, i4), this.UJ, this.UK, this.UL, this.UM, this.mStrokeWidth, this.mStrokeColor, this.US, this.kFa);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kFa) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.UJ);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.UJ);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.UL);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.UL);
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

    private void oQ() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kFa) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.UJ);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.UJ);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.UL);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.UL);
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

    public BubbleLayout aQ(float f) {
        oQ();
        this.UM = f;
        initPadding();
        return this;
    }

    public BubbleLayout DL(int i) {
        this.US = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.kFa;
    }

    public float getArrowWidth() {
        return this.UJ;
    }

    public float getCornersRadius() {
        return this.UK;
    }

    public float getArrowHeight() {
        return this.UL;
    }

    public float getArrowPosition() {
        return this.UM;
    }

    public int getBubbleColor() {
        return this.US;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
