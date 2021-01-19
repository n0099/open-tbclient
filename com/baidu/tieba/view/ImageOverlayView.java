package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ImageOverlayView extends ViewGroup {
    private int iJP;
    private int iJQ;
    private int iJR;
    private int iJS;
    private a iJT;
    private boolean iJU;
    private int iJV;
    private int iJW;
    public final View.OnClickListener iJX;
    private int ikX;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nOP;
    private RectF nOQ;

    /* loaded from: classes.dex */
    public interface a {
        void dTN();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ikX = 10;
        this.iJU = false;
        this.iJW = 0;
        this.iJX = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iJT != null) {
                    ImageOverlayView.this.iJT.dTN();
                }
            }
        };
        sa();
        this.nOQ = new RectF();
    }

    public void l(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iJP = i;
        this.nOP = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iJQ = i4;
        this.iJR = i5;
        this.iJS = i6;
        cwb();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iJV = i;
    }

    public void setStrokeStyle(int i) {
        this.iJW = i;
    }

    private void sa() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cwb() {
        for (int i = 0; i < this.iJP; i++) {
            HeadImageView headImageView = new HeadImageView(getContext());
            headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.mImageWidth, this.mImageHeight));
            headImageView.setIsRound(true);
            headImageView.setBorderSurroundContent(true);
            headImageView.setDrawBorder(true);
            headImageView.setAutoChangeStyle(true);
            headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.setPlaceHolder(1);
            addView(headImageView);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.iJQ;
        if (this.iJW == 1) {
            i3 = this.iJQ * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nOP * this.mImageWidth)) - ((this.nOP - 1) * this.iJS), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iJQ * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iJU) {
            paddingLeft = this.iJQ + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iJQ;
        } else {
            paddingLeft = this.iJQ + getPaddingLeft() + ((this.nOP - 1) * (this.mImageWidth - this.iJS));
            paddingTop = getPaddingTop() + this.iJQ;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nOP; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iJU) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iJS;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iJS;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nOP; i7 < this.iJP && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ao.getColor(this.iJR));
        this.mStrokePaint.setStrokeWidth(this.iJQ);
        if (this.iJW != 0) {
            if (this.iJW == 1) {
                this.iJV = this.iJV <= 0 ? this.iJR : this.iJV;
                float f = this.iJQ * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iJS) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iJU ? 0 : this.nOP - 1;
                int i3 = 0;
                while (i3 < this.nOP) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nOQ.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ao.getColor(this.iJV));
                        } else {
                            this.mStrokePaint.setColor(ao.getColor(this.iJR));
                        }
                        canvas.drawArc(this.nOQ, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nOP && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iJQ * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nOQ.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nOQ, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nOP = Math.min(this.iJP, x.getCount(list));
        for (int i = 0; i < this.nOP; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) x.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.ikX == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ao.getColor(this.iJR));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setPlaceHolder(1);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setImageClickListener(a aVar) {
        this.iJT = aVar;
    }

    public void setLoadImageType(int i) {
        this.ikX = i;
    }

    public void setOrientation(boolean z) {
        this.iJU = z;
    }
}
