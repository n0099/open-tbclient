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
    private int iCi;
    private int iCj;
    private int iCk;
    private int iCl;
    private a iCm;
    private boolean iCn;
    private int iCo;
    private int iCp;
    public final View.OnClickListener iCq;
    private int idf;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nPW;
    private RectF nPX;

    /* loaded from: classes.dex */
    public interface a {
        void dYa();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.idf = 10;
        this.iCn = false;
        this.iCp = 0;
        this.iCq = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iCm != null) {
                    ImageOverlayView.this.iCm.dYa();
                }
            }
        };
        sz();
        this.nPX = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iCi = i;
        this.nPW = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iCj = i4;
        this.iCk = i5;
        this.iCl = i6;
        cwY();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iCo = i;
    }

    public void setStrokeStyle(int i) {
        this.iCp = i;
    }

    private void sz() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cwY() {
        for (int i = 0; i < this.iCi; i++) {
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
        int i3 = this.iCj;
        if (this.iCp == 1) {
            i3 = this.iCj * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nPW * this.mImageWidth)) - ((this.nPW - 1) * this.iCl), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iCj * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iCn) {
            paddingLeft = this.iCj + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iCj;
        } else {
            paddingLeft = this.iCj + getPaddingLeft() + ((this.nPW - 1) * (this.mImageWidth - this.iCl));
            paddingTop = getPaddingTop() + this.iCj;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nPW; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iCn) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iCl;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iCl;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nPW; i7 < this.iCi && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iCk));
        this.mStrokePaint.setStrokeWidth(this.iCj);
        if (this.iCp != 0) {
            if (this.iCp == 1) {
                this.iCo = this.iCo <= 0 ? this.iCk : this.iCo;
                float f = this.iCj * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iCl) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iCn ? 0 : this.nPW - 1;
                int i3 = 0;
                while (i3 < this.nPW) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nPX.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.iCo));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.iCk));
                        }
                        canvas.drawArc(this.nPX, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nPW && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iCj * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nPX.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nPX, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nPW = Math.min(this.iCi, y.getCount(list));
        for (int i = 0; i < this.nPW; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.idf == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.iCk));
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
        this.iCm = aVar;
    }

    public void setLoadImageType(int i) {
        this.idf = i;
    }

    public void setOrientation(boolean z) {
        this.iCn = z;
    }
}
