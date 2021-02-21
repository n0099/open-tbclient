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
    private int iPL;
    private int iPM;
    private int iPN;
    private int iPO;
    private a iPP;
    private boolean iPQ;
    private int iPR;
    private int iPS;
    public final View.OnClickListener iPT;
    private int iqT;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int nZt;
    private RectF nZu;

    /* loaded from: classes.dex */
    public interface a {
        void dWj();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqT = 10;
        this.iPQ = false;
        this.iPS = 0;
        this.iPT = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.iPP != null) {
                    ImageOverlayView.this.iPP.dWj();
                }
            }
        };
        rX();
        this.nZu = new RectF();
    }

    public void l(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iPL = i;
        this.nZt = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.iPM = i4;
        this.iPN = i5;
        this.iPO = i6;
        cxu();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.iPR = i;
    }

    public void setStrokeStyle(int i) {
        this.iPS = i;
    }

    private void rX() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cxu() {
        for (int i = 0; i < this.iPL; i++) {
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
        int i3 = this.iPM;
        if (this.iPS == 1) {
            i3 = this.iPM * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.nZt * this.mImageWidth)) - ((this.nZt - 1) * this.iPO), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.iPM * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.iPQ) {
            paddingLeft = this.iPM + getPaddingLeft();
            paddingTop = getPaddingTop() + this.iPM;
        } else {
            paddingLeft = this.iPM + getPaddingLeft() + ((this.nZt - 1) * (this.mImageWidth - this.iPO));
            paddingTop = getPaddingTop() + this.iPM;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.nZt; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.iPQ) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.iPO;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.iPO;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.nZt; i7 < this.iPL && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.iPN));
        this.mStrokePaint.setStrokeWidth(this.iPM);
        if (this.iPS != 0) {
            if (this.iPS == 1) {
                this.iPR = this.iPR <= 0 ? this.iPN : this.iPR;
                float f = this.iPM * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.iPO) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.iPQ ? 0 : this.nZt - 1;
                int i3 = 0;
                while (i3 < this.nZt) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.nZu.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.iPR));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.iPN));
                        }
                        canvas.drawArc(this.nZu, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.nZt && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.iPM * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.nZu.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.nZu, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.nZt = Math.min(this.iPL, y.getCount(list));
        for (int i = 0; i < this.nZt; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.iqT == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.iPN));
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
        this.iPP = aVar;
    }

    public void setLoadImageType(int i) {
        this.iqT = i;
    }

    public void setOrientation(boolean z) {
        this.iPQ = z;
    }
}
