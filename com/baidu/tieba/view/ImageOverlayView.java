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
    private int iCk;
    private int iCl;
    private int iCm;
    private int iCn;
    private a iCo;
    private boolean iCp;
    private int iCq;
    private int iCr;
    public final View.OnClickListener iCs;
    private int idh;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nPY;
    private RectF nPZ;

    /* loaded from: classes.dex */
    public interface a {
        void dYb();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.idh = 10;
        this.iCp = false;
        this.iCr = 0;
        this.iCs = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iCo != null) {
                    ImageOverlayView.this.iCo.dYb();
                }
            }
        };
        sz();
        this.nPZ = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iCk = i;
        this.nPY = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iCl = i4;
        this.iCm = i5;
        this.iCn = i6;
        cwZ();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iCq = i;
    }

    public void setStrokeStyle(int i) {
        this.iCr = i;
    }

    private void sz() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cwZ() {
        for (int i = 0; i < this.iCk; i++) {
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
        int i3 = this.iCl;
        if (this.iCr == 1) {
            i3 = this.iCl * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nPY * this.mImageWidth)) - ((this.nPY - 1) * this.iCn), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iCl * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iCp) {
            paddingLeft = this.iCl + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iCl;
        } else {
            paddingLeft = this.iCl + getPaddingLeft() + ((this.nPY - 1) * (this.mImageWidth - this.iCn));
            paddingTop = getPaddingTop() + this.iCl;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nPY; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iCp) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iCn;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iCn;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nPY; i7 < this.iCk && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iCm));
        this.mStrokePaint.setStrokeWidth(this.iCl);
        if (this.iCr != 0) {
            if (this.iCr == 1) {
                this.iCq = this.iCq <= 0 ? this.iCm : this.iCq;
                float f = this.iCl * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iCn) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iCp ? 0 : this.nPY - 1;
                int i3 = 0;
                while (i3 < this.nPY) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nPZ.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.iCq));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.iCm));
                        }
                        canvas.drawArc(this.nPZ, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nPY && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iCl * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nPZ.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nPZ, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nPY = Math.min(this.iCk, y.getCount(list));
        for (int i = 0; i < this.nPY; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.idh == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.iCm));
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
        this.iCo = aVar;
    }

    public void setLoadImageType(int i) {
        this.idh = i;
    }

    public void setOrientation(boolean z) {
        this.iCp = z;
    }
}
