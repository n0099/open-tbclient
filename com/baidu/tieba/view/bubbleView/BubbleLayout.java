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
    public static float WM = -1.0f;
    private float WH;
    private float WI;
    private float WJ;
    private float WK;
    private int WP;
    private ArrowDirection kJP;
    private a kJQ;
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
        this.WH = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.WJ = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.WI = obtainStyledAttributes.getDimension(7, 0.0f);
        this.WK = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.WP = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, WM);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.kJP = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.kJQ != null) {
            this.kJQ.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.kJQ = new a(new RectF(i, i3, i2, i4), this.WH, this.WI, this.WJ, this.WK, this.mStrokeWidth, this.mStrokeColor, this.WP, this.kJP);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kJP) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.WH);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.WH);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.WJ);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.WJ);
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

    private void pI() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.kJP) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.WH);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.WH);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.WJ);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.WJ);
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
        pI();
        this.WK = f;
        initPadding();
        return this;
    }

    public BubbleLayout DX(int i) {
        this.WP = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.kJP;
    }

    public float getArrowWidth() {
        return this.WH;
    }

    public float getCornersRadius() {
        return this.WI;
    }

    public float getArrowHeight() {
        return this.WJ;
    }

    public float getArrowPosition() {
        return this.WK;
    }

    public int getBubbleColor() {
        return this.WP;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
