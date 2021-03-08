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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ImageOverlayView extends ViewGroup {
    private int iRA;
    private int iRB;
    public final View.OnClickListener iRC;
    private int iRu;
    private int iRv;
    private int iRw;
    private int iRx;
    private a iRy;
    private boolean iRz;
    private int isC;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private RectF obA;
    private int obz;

    /* loaded from: classes.dex */
    public interface a {
        void dWr();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isC = 10;
        this.iRz = false;
        this.iRB = 0;
        this.iRC = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iRy != null) {
                    ImageOverlayView.this.iRy.dWr();
                }
            }
        };
        rX();
        this.obA = new RectF();
    }

    public void l(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iRu = i;
        this.obz = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iRv = i4;
        this.iRw = i5;
        this.iRx = i6;
        cxA();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iRA = i;
    }

    public void setStrokeStyle(int i) {
        this.iRB = i;
    }

    private void rX() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cxA() {
        for (int i = 0; i < this.iRu; i++) {
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
        int i3 = this.iRv;
        if (this.iRB == 1) {
            i3 = this.iRv * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.obz * this.mImageWidth)) - ((this.obz - 1) * this.iRx), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iRv * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iRz) {
            paddingLeft = this.iRv + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iRv;
        } else {
            paddingLeft = this.iRv + getPaddingLeft() + ((this.obz - 1) * (this.mImageWidth - this.iRx));
            paddingTop = getPaddingTop() + this.iRv;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.obz; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iRz) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iRx;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iRx;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.obz; i7 < this.iRu && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iRw));
        this.mStrokePaint.setStrokeWidth(this.iRv);
        if (this.iRB != 0) {
            if (this.iRB == 1) {
                this.iRA = this.iRA <= 0 ? this.iRw : this.iRA;
                float f = this.iRv * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iRx) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iRz ? 0 : this.obz - 1;
                int i3 = 0;
                while (i3 < this.obz) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.obA.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.iRA));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.iRw));
                        }
                        canvas.drawArc(this.obA, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.obz && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iRv * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.obA.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.obA, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.obz = Math.min(this.iRu, y.getCount(list));
        for (int i = 0; i < this.obz; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.isC == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.iRw));
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
        this.iRy = aVar;
    }

    public void setLoadImageType(int i) {
        this.isC = i;
    }

    public void setOrientation(boolean z) {
        this.iRz = z;
    }
}
