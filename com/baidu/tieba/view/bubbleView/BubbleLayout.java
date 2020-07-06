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
    public static float awa = -1.0f;
    private float avV;
    private float avW;
    private float avX;
    private float avY;
    private int awd;
    private int mStrokeColor;
    private float mStrokeWidth;
    private ArrowDirection mkg;
    private a mkh;

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BubbleLayout);
        this.avV = obtainStyledAttributes.getDimension(1, c(8.0f, context));
        this.avX = obtainStyledAttributes.getDimension(2, c(8.0f, context));
        this.avW = obtainStyledAttributes.getDimension(7, 0.0f);
        this.avY = obtainStyledAttributes.getDimension(0, c(12.0f, context));
        this.awd = obtainStyledAttributes.getColor(3, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(4, awa);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.mkg = ArrowDirection.fromInt(obtainStyledAttributes.getInt(5, ArrowDirection.LEFT.getValue()));
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
        if (this.mkh != null) {
            this.mkh.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void f(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.mkh = new a(new RectF(i, i3, i2, i4), this.avV, this.avW, this.avX, this.avY, this.mStrokeWidth, this.mStrokeColor, this.awd, this.mkg);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.mkg) {
            case LEFT:
                paddingLeft = (int) (paddingLeft + this.avV);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight + this.avV);
                break;
            case TOP:
                paddingTop = (int) (paddingTop + this.avX);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom + this.avX);
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

    private void vF() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (this.mkg) {
            case LEFT:
                paddingLeft = (int) (paddingLeft - this.avV);
                break;
            case RIGHT:
                paddingRight = (int) (paddingRight - this.avV);
                break;
            case TOP:
                paddingTop = (int) (paddingTop - this.avX);
                break;
            case BOTTOM:
                paddingBottom = (int) (paddingBottom - this.avX);
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

    public BubbleLayout aC(float f) {
        vF();
        this.avY = f;
        initPadding();
        return this;
    }

    public BubbleLayout Gy(int i) {
        this.awd = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.mkg;
    }

    public float getArrowWidth() {
        return this.avV;
    }

    public float getCornersRadius() {
        return this.avW;
    }

    public float getArrowHeight() {
        return this.avX;
    }

    public float getArrowPosition() {
        return this.avY;
    }

    public int getBubbleColor() {
        return this.awd;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
