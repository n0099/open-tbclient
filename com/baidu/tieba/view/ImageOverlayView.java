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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ImageOverlayView extends ViewGroup {
    private int hJj;
    private int hJk;
    private int hJl;
    private int hJm;
    private a hJn;
    private boolean hJo;
    private int hJp;
    private int hJq;
    public final View.OnClickListener hJr;
    private int hky;
    private int mImageHeight;
    private int mImageWidth;
    private int mSQ;
    private RectF mSR;
    private Paint mStrokePaint;

    /* loaded from: classes.dex */
    public interface a {
        void dJl();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hky = 10;
        this.hJo = false;
        this.hJq = 0;
        this.hJr = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.hJn != null) {
                    ImageOverlayView.this.hJn.dJl();
                }
            }
        };
        sw();
        this.mSR = new RectF();
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.hJj = i;
        this.mSQ = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.hJk = i4;
        this.hJl = i5;
        this.hJm = i6;
        ckc();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.hJp = i;
    }

    public void setStrokeStyle(int i) {
        this.hJq = i;
    }

    private void sw() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void ckc() {
        for (int i = 0; i < this.hJj; i++) {
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
        int i3 = this.hJk;
        if (this.hJq == 1) {
            i3 = this.hJk * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.mSQ * this.mImageWidth)) - ((this.mSQ - 1) * this.hJm), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.hJk * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.hJo) {
            paddingLeft = this.hJk + getPaddingLeft();
            paddingTop = getPaddingTop() + this.hJk;
        } else {
            paddingLeft = this.hJk + getPaddingLeft() + ((this.mSQ - 1) * (this.mImageWidth - this.hJm));
            paddingTop = getPaddingTop() + this.hJk;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.mSQ; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.hJo) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.hJm;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.hJm;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.mSQ; i7 < this.hJj && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.hJl));
        this.mStrokePaint.setStrokeWidth(this.hJk);
        if (this.hJq != 0) {
            if (this.hJq == 1) {
                this.hJp = this.hJp <= 0 ? this.hJl : this.hJp;
                float f = this.hJk * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.hJm) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.hJo ? 0 : this.mSQ - 1;
                int i3 = 0;
                while (i3 < this.mSQ) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.mSR.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.hJp));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.hJl));
                        }
                        canvas.drawArc(this.mSR, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.mSQ && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.hJk * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.mSR.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.mSR, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.mSQ = Math.min(this.hJj, y.getCount(list));
        for (int i = 0; i < this.mSQ; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.hky == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.hJl));
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
        this.hJn = aVar;
    }

    public void setLoadImageType(int i) {
        this.hky = i;
    }

    public void setOrientation(boolean z) {
        this.hJo = z;
    }
}
