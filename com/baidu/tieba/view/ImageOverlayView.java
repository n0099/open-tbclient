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
    private int hRM;
    private int iqD;
    private int iqE;
    private int iqF;
    private int iqG;
    private a iqH;
    private boolean iqI;
    private int iqJ;
    private int iqK;
    public final View.OnClickListener iqL;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nAN;
    private RectF nAO;

    /* loaded from: classes.dex */
    public interface a {
        void dSH();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hRM = 10;
        this.iqI = false;
        this.iqK = 0;
        this.iqL = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iqH != null) {
                    ImageOverlayView.this.iqH.dSH();
                }
            }
        };
        sw();
        this.nAO = new RectF();
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iqD = i;
        this.nAN = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iqE = i4;
        this.iqF = i5;
        this.iqG = i6;
        ctg();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iqJ = i;
    }

    public void setStrokeStyle(int i) {
        this.iqK = i;
    }

    private void sw() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void ctg() {
        for (int i = 0; i < this.iqD; i++) {
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
        int i3 = this.iqE;
        if (this.iqK == 1) {
            i3 = this.iqE * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nAN * this.mImageWidth)) - ((this.nAN - 1) * this.iqG), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iqE * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iqI) {
            paddingLeft = this.iqE + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iqE;
        } else {
            paddingLeft = this.iqE + getPaddingLeft() + ((this.nAN - 1) * (this.mImageWidth - this.iqG));
            paddingTop = getPaddingTop() + this.iqE;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nAN; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iqI) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iqG;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iqG;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nAN; i7 < this.iqD && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iqF));
        this.mStrokePaint.setStrokeWidth(this.iqE);
        if (this.iqK != 0) {
            if (this.iqK == 1) {
                this.iqJ = this.iqJ <= 0 ? this.iqF : this.iqJ;
                float f = this.iqE * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iqG) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iqI ? 0 : this.nAN - 1;
                int i3 = 0;
                while (i3 < this.nAN) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nAO.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.iqJ));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.iqF));
                        }
                        canvas.drawArc(this.nAO, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nAN && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iqE * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nAO.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nAO, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nAN = Math.min(this.iqD, y.getCount(list));
        for (int i = 0; i < this.nAN; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.hRM == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.iqF));
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
        this.iqH = aVar;
    }

    public void setLoadImageType(int i) {
        this.hRM = i;
    }

    public void setOrientation(boolean z) {
        this.iqI = z;
    }
}
