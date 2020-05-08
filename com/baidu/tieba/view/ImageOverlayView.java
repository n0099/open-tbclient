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
    private RectF cEq;
    private int gHQ;
    private int gHR;
    private int gHS;
    private int gHT;
    private a gHU;
    private boolean gHV;
    private int gHW;
    private int gHX;
    public final View.OnClickListener gHY;
    private int gjj;
    private int luK;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    /* loaded from: classes.dex */
    public interface a {
        void deD();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjj = 10;
        this.gHV = false;
        this.gHX = 0;
        this.gHY = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.gHU != null) {
                    ImageOverlayView.this.gHU.deD();
                }
            }
        };
        qs();
        this.cEq = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gHQ = i;
        this.luK = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.gHR = i4;
        this.gHS = i5;
        this.gHT = i6;
        bJG();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.gHW = i;
    }

    public void setStrokeStyle(int i) {
        this.gHX = i;
    }

    private void qs() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bJG() {
        for (int i = 0; i < this.gHQ; i++) {
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
        int i3 = this.gHR;
        if (this.gHX == 1) {
            i3 = this.gHR * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.luK * this.mImageWidth)) - ((this.luK - 1) * this.gHT), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.gHR * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.gHV) {
            paddingLeft = this.gHR + getPaddingLeft();
            paddingTop = getPaddingTop() + this.gHR;
        } else {
            paddingLeft = this.gHR + getPaddingLeft() + ((this.luK - 1) * (this.mImageWidth - this.gHT));
            paddingTop = getPaddingTop() + this.gHR;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.luK; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.gHV) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.gHT;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.gHT;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.luK; i7 < this.gHQ && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(am.getColor(this.gHS));
        this.mStrokePaint.setStrokeWidth(this.gHR);
        if (this.gHX != 0) {
            if (this.gHX == 1) {
                this.gHW = this.gHW <= 0 ? this.gHS : this.gHW;
                float f = this.gHR * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.gHT) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.gHV ? 0 : this.luK - 1;
                int i3 = 0;
                while (i3 < this.luK) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.cEq.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(am.getColor(this.gHW));
                        } else {
                            this.mStrokePaint.setColor(am.getColor(this.gHS));
                        }
                        canvas.drawArc(this.cEq, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.luK && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.gHR * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.cEq.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.cEq, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.luK = Math.min(this.gHQ, v.getCount(list));
        for (int i = 0; i < this.luK; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) v.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.gjj == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(am.getColor(this.gHS));
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
        this.gHU = aVar;
    }

    public void setLoadImageType(int i) {
        this.gjj = i;
    }

    public void setOrientation(boolean z) {
        this.gHV = z;
    }
}
