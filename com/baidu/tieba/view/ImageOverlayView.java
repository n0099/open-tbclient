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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ImageOverlayView extends ViewGroup {
    private int gQC;
    private int hpk;
    private int hpl;
    private int hpm;
    private int hpn;
    private a hpo;
    private boolean hpp;
    private int hpq;
    private int hpr;
    public final View.OnClickListener hps;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int mqA;
    private RectF mqB;

    /* loaded from: classes.dex */
    public interface a {
        void dtM();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gQC = 10;
        this.hpp = false;
        this.hpr = 0;
        this.hps = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.hpo != null) {
                    ImageOverlayView.this.hpo.dtM();
                }
            }
        };
        qS();
        this.mqB = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.hpk = i;
        this.mqA = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.hpl = i4;
        this.hpm = i5;
        this.hpn = i6;
        bWz();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.hpq = i;
    }

    public void setStrokeStyle(int i) {
        this.hpr = i;
    }

    private void qS() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bWz() {
        for (int i = 0; i < this.hpk; i++) {
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
        int i3 = this.hpl;
        if (this.hpr == 1) {
            i3 = this.hpl * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.mqA * this.mImageWidth)) - ((this.mqA - 1) * this.hpn), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.hpl * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.hpp) {
            paddingLeft = this.hpl + getPaddingLeft();
            paddingTop = getPaddingTop() + this.hpl;
        } else {
            paddingLeft = this.hpl + getPaddingLeft() + ((this.mqA - 1) * (this.mImageWidth - this.hpn));
            paddingTop = getPaddingTop() + this.hpl;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.mqA; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.hpp) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.hpn;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.hpn;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.mqA; i7 < this.hpk && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ao.getColor(this.hpm));
        this.mStrokePaint.setStrokeWidth(this.hpl);
        if (this.hpr != 0) {
            if (this.hpr == 1) {
                this.hpq = this.hpq <= 0 ? this.hpm : this.hpq;
                float f = this.hpl * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.hpn) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.hpp ? 0 : this.mqA - 1;
                int i3 = 0;
                while (i3 < this.mqA) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.mqB.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ao.getColor(this.hpq));
                        } else {
                            this.mStrokePaint.setColor(ao.getColor(this.hpm));
                        }
                        canvas.drawArc(this.mqB, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.mqA && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.hpl * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.mqB.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.mqB, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.mqA = Math.min(this.hpk, x.getCount(list));
        for (int i = 0; i < this.mqA; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) x.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.gQC == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ao.getColor(this.hpm));
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
        this.hpo = aVar;
    }

    public void setLoadImageType(int i) {
        this.gQC = i;
    }

    public void setOrientation(boolean z) {
        this.hpp = z;
    }
}
