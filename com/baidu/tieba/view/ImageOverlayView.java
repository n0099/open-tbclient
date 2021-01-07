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
    private a iOA;
    private boolean iOB;
    private int iOC;
    private int iOD;
    public final View.OnClickListener iOE;
    private int iOw;
    private int iOx;
    private int iOy;
    private int iOz;
    private int ipG;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nTt;
    private RectF nTu;

    /* loaded from: classes.dex */
    public interface a {
        void dXF();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ipG = 10;
        this.iOB = false;
        this.iOD = 0;
        this.iOE = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iOA != null) {
                    ImageOverlayView.this.iOA.dXF();
                }
            }
        };
        sa();
        this.nTu = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iOw = i;
        this.nTt = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iOx = i4;
        this.iOy = i5;
        this.iOz = i6;
        czT();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iOC = i;
    }

    public void setStrokeStyle(int i) {
        this.iOD = i;
    }

    private void sa() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void czT() {
        for (int i = 0; i < this.iOw; i++) {
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
        int i3 = this.iOx;
        if (this.iOD == 1) {
            i3 = this.iOx * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nTt * this.mImageWidth)) - ((this.nTt - 1) * this.iOz), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iOx * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iOB) {
            paddingLeft = this.iOx + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iOx;
        } else {
            paddingLeft = this.iOx + getPaddingLeft() + ((this.nTt - 1) * (this.mImageWidth - this.iOz));
            paddingTop = getPaddingTop() + this.iOx;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nTt; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iOB) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iOz;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iOz;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nTt; i7 < this.iOw && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ao.getColor(this.iOy));
        this.mStrokePaint.setStrokeWidth(this.iOx);
        if (this.iOD != 0) {
            if (this.iOD == 1) {
                this.iOC = this.iOC <= 0 ? this.iOy : this.iOC;
                float f = this.iOx * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iOz) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iOB ? 0 : this.nTt - 1;
                int i3 = 0;
                while (i3 < this.nTt) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nTu.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ao.getColor(this.iOC));
                        } else {
                            this.mStrokePaint.setColor(ao.getColor(this.iOy));
                        }
                        canvas.drawArc(this.nTu, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nTt && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iOx * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nTu.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nTu, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nTt = Math.min(this.iOw, x.getCount(list));
        for (int i = 0; i < this.nTt; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) x.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.ipG == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ao.getColor(this.iOy));
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
        this.iOA = aVar;
    }

    public void setLoadImageType(int i) {
        this.ipG = i;
    }

    public void setOrientation(boolean z) {
        this.iOB = z;
    }
}
