package com.baidu.tieba.view.bubbleView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class BubbleLayout extends FrameLayout {
    public static float DEFAULT_STROKE_WIDTH = -1.0f;
    private static /* synthetic */ int[] gbh;
    private ArrowDirection gbi;
    private a gbj;
    private float mArrowHeight;
    private float mArrowPosition;
    private float mArrowWidth;
    private int mBubbleColor;
    private float mCornersRadius;
    private int mStrokeColor;
    private float mStrokeWidth;

    static /* synthetic */ int[] bqG() {
        int[] iArr = gbh;
        if (iArr == null) {
            iArr = new int[ArrowDirection.valuesCustom().length];
            try {
                iArr[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            gbh = iArr;
        }
        return iArr;
    }

    public BubbleLayout(Context context) {
        this(context, null, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, w.n.BubbleLayout);
        this.mArrowWidth = obtainStyledAttributes.getDimension(0, convertDpToPixel(8.0f, context));
        this.mArrowHeight = obtainStyledAttributes.getDimension(2, convertDpToPixel(8.0f, context));
        this.mCornersRadius = obtainStyledAttributes.getDimension(1, 0.0f);
        this.mArrowPosition = obtainStyledAttributes.getDimension(3, convertDpToPixel(12.0f, context));
        this.mBubbleColor = obtainStyledAttributes.getColor(4, -1);
        this.mStrokeWidth = obtainStyledAttributes.getDimension(5, DEFAULT_STROKE_WIDTH);
        this.mStrokeColor = obtainStyledAttributes.getColor(6, -7829368);
        this.gbi = ArrowDirection.fromInt(obtainStyledAttributes.getInt(7, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        initPadding();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        initDrawable(0, getWidth(), 0, getHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gbj != null) {
            this.gbj.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    private void initDrawable(int i, int i2, int i3, int i4) {
        if (i2 >= i && i4 >= i3) {
            this.gbj = new a(new RectF(i, i3, i2, i4), this.mArrowWidth, this.mCornersRadius, this.mArrowHeight, this.mArrowPosition, this.mStrokeWidth, this.mStrokeColor, this.mBubbleColor, this.gbi);
        }
    }

    private void initPadding() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        switch (bqG()[this.gbi.ordinal()]) {
            case 1:
                paddingLeft = (int) (paddingLeft + this.mArrowWidth);
                break;
            case 2:
                paddingRight = (int) (paddingRight + this.mArrowWidth);
                break;
            case 3:
                paddingTop = (int) (paddingTop + this.mArrowHeight);
                break;
            case 4:
                paddingBottom = (int) (paddingBottom + this.mArrowHeight);
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

    static float convertDpToPixel(float f, Context context) {
        return (context.getResources().getDisplayMetrics().densityDpi / 160.0f) * f;
    }

    public BubbleLayout tw(int i) {
        this.mBubbleColor = i;
        requestLayout();
        return this;
    }

    public ArrowDirection getArrowDirection() {
        return this.gbi;
    }

    public float getArrowWidth() {
        return this.mArrowWidth;
    }

    public float getCornersRadius() {
        return this.mCornersRadius;
    }

    public float getArrowHeight() {
        return this.mArrowHeight;
    }

    public float getArrowPosition() {
        return this.mArrowPosition;
    }

    public int getBubbleColor() {
        return this.mBubbleColor;
    }

    public float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public int getStrokeColor() {
        return this.mStrokeColor;
    }
}
