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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.List;
/* loaded from: classes.dex */
public class ImageOverlayView extends ViewGroup {
    private int gKW;
    private int hjC;
    private int hjD;
    private int hjE;
    private int hjF;
    private a hjG;
    private boolean hjH;
    private int hjI;
    private int hjJ;
    public final View.OnClickListener hjK;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;
    private int miC;
    private RectF miD;

    /* loaded from: classes.dex */
    public interface a {
        void dqA();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKW = 10;
        this.hjH = false;
        this.hjJ = 0;
        this.hjK = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.hjG != null) {
                    ImageOverlayView.this.hjG.dqA();
                }
            }
        };
        qP();
        this.miD = new RectF();
    }

    public void k(int i, int i2, int i3, int i4, int i5, int i6) {
        this.hjC = i;
        this.miC = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.hjD = i4;
        this.hjE = i5;
        this.hjF = i6;
        bTi();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.hjI = i;
    }

    public void setStrokeStyle(int i) {
        this.hjJ = i;
    }

    private void qP() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void bTi() {
        for (int i = 0; i < this.hjC; i++) {
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
        int i3 = this.hjD;
        if (this.hjJ == 1) {
            i3 = this.hjD * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.miC * this.mImageWidth)) - ((this.miC - 1) * this.hjF), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.hjD * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.hjH) {
            paddingLeft = this.hjD + getPaddingLeft();
            paddingTop = getPaddingTop() + this.hjD;
        } else {
            paddingLeft = this.hjD + getPaddingLeft() + ((this.miC - 1) * (this.mImageWidth - this.hjF));
            paddingTop = getPaddingTop() + this.hjD;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.miC; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.hjH) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.hjF;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.hjF;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.miC; i7 < this.hjC && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(an.getColor(this.hjE));
        this.mStrokePaint.setStrokeWidth(this.hjD);
        if (this.hjJ != 0) {
            if (this.hjJ == 1) {
                this.hjI = this.hjI <= 0 ? this.hjE : this.hjI;
                float f = this.hjD * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.hjF) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.hjH ? 0 : this.miC - 1;
                int i3 = 0;
                while (i3 < this.miC) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.miD.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(an.getColor(this.hjI));
                        } else {
                            this.mStrokePaint.setColor(an.getColor(this.hjE));
                        }
                        canvas.drawArc(this.miD, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.miC && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.hjD * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.miD.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.miD, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.miC = Math.min(this.hjC, w.getCount(list));
        for (int i = 0; i < this.miC; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) w.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.gKW == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(an.getColor(this.hjE));
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
        this.hjG = aVar;
    }

    public void setLoadImageType(int i) {
        this.gKW = i;
    }

    public void setOrientation(boolean z) {
        this.hjH = z;
    }
}
