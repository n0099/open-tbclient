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
    private int hSm;
    private int irq;
    private int irr;
    private int irs;
    private int irt;
    private a iru;
    private boolean irv;
    private int irw;
    private int irx;
    public final View.OnClickListener iry;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nBU;
    private RectF nBV;

    /* loaded from: classes.dex */
    public interface a {
        void dSG();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hSm = 10;
        this.irv = false;
        this.irx = 0;
        this.iry = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iru != null) {
                    ImageOverlayView.this.iru.dSG();
                }
            }
        };
        sw();
        this.nBV = new RectF();
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.irq = i;
        this.nBU = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.irr = i4;
        this.irs = i5;
        this.irt = i6;
        csJ();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.irw = i;
    }

    public void setStrokeStyle(int i) {
        this.irx = i;
    }

    private void sw() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void csJ() {
        for (int i = 0; i < this.irq; i++) {
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
        int i3 = this.irr;
        if (this.irx == 1) {
            i3 = this.irr * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nBU * this.mImageWidth)) - ((this.nBU - 1) * this.irt), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.irr * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.irv) {
            paddingLeft = this.irr + getPaddingLeft();
            paddingTop = getPaddingTop() + this.irr;
        } else {
            paddingLeft = this.irr + getPaddingLeft() + ((this.nBU - 1) * (this.mImageWidth - this.irt));
            paddingTop = getPaddingTop() + this.irr;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nBU; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.irv) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.irt;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.irt;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nBU; i7 < this.irq && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.irs));
        this.mStrokePaint.setStrokeWidth(this.irr);
        if (this.irx != 0) {
            if (this.irx == 1) {
                this.irw = this.irw <= 0 ? this.irs : this.irw;
                float f = this.irr * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.irt) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.irv ? 0 : this.nBU - 1;
                int i3 = 0;
                while (i3 < this.nBU) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nBV.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.irw));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.irs));
                        }
                        canvas.drawArc(this.nBV, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nBU && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.irr * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nBV.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nBV, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nBU = Math.min(this.irq, y.getCount(list));
        for (int i = 0; i < this.nBU; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.hSm == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.irs));
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
        this.iru = aVar;
    }

    public void setLoadImageType(int i) {
        this.hSm = i;
    }

    public void setOrientation(boolean z) {
        this.irv = z;
    }
}
