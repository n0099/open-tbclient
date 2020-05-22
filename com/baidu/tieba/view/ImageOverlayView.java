package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ImageOverlayView extends ViewGroup {
    private int gWB;
    private int gWC;
    private int gWD;
    private int gWE;
    private a gWF;
    private boolean gWG;
    private int gWH;
    private int gWI;
    public final View.OnClickListener gWJ;
    private int gxZ;
    private int lNs;
    private RectF lNt;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    /* loaded from: classes.dex */
    public interface a {
        void dlU();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxZ = 10;
        this.gWG = false;
        this.gWI = 0;
        this.gWJ = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gWF != null) {
                    ImageOverlayView.this.gWF.dlU();
                }
            }
        };
        qy();
        this.lNt = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gWB = i;
        this.lNs = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gWC = i4;
        this.gWD = i5;
        this.gWE = i6;
        bQc();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.gWH = i;
    }

    public void setStrokeStyle(int i) {
        this.gWI = i;
    }

    private void qy() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bQc() {
        for (int i = 0; i < this.gWB; i++) {
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
        int i3 = this.gWC;
        if (this.gWI == 1) {
            i3 = this.gWC * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.lNs * this.mImageWidth)) - ((this.lNs - 1) * this.gWE), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.gWC * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.gWG) {
            paddingLeft = this.gWC + getPaddingLeft();
            paddingTop = getPaddingTop() + this.gWC;
        } else {
            paddingLeft = this.gWC + getPaddingLeft() + ((this.lNs - 1) * (this.mImageWidth - this.gWE));
            paddingTop = getPaddingTop() + this.gWC;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.lNs; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.gWG) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.gWE;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.gWE;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.lNs; i7 < this.gWB && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(am.getColor(this.gWD));
        this.mStrokePaint.setStrokeWidth(this.gWC);
        if (this.gWI != 0) {
            if (this.gWI == 1) {
                this.gWH = this.gWH <= 0 ? this.gWD : this.gWH;
                float f = this.gWC * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.gWE) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.gWG ? 0 : this.lNs - 1;
                int i3 = 0;
                while (i3 < this.lNs) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.lNt.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(am.getColor(this.gWH));
                        } else {
                            this.mStrokePaint.setColor(am.getColor(this.gWD));
                        }
                        canvas.drawArc(this.lNt, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.lNs && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.gWC * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.lNt.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.lNt, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.lNs = Math.min(this.gWB, v.getCount(list));
        for (int i = 0; i < this.lNs; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) v.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.gxZ == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(am.getColor(this.gWD));
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
        this.gWF = aVar;
    }

    public void setLoadImageType(int i) {
        this.gxZ = i;
    }

    public void setOrientation(boolean z) {
        this.gWG = z;
    }
}
