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
/* loaded from: classes2.dex */
public class ImageOverlayView extends ViewGroup {
    private int hCb;
    private int hCc;
    private int hCd;
    private int hCe;
    private a hCf;
    private boolean hCg;
    private int hCh;
    private int hCi;
    public final View.OnClickListener hCj;
    private int hds;
    private int mIO;
    private RectF mIP;
    private int mImageHeight;
    private int mImageWidth;
    private Paint mStrokePaint;

    /* loaded from: classes2.dex */
    public interface a {
        void dFi();
    }

    public ImageOverlayView(Context context) {
        this(context, null);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hds = 10;
        this.hCg = false;
        this.hCi = 0;
        this.hCj = new View.OnClickListener() { // from class: com.baidu.tieba.view.ImageOverlayView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ImageOverlayView.this.hCf != null) {
                    ImageOverlayView.this.hCf.dFi();
                }
            }
        };
        sr();
        this.mIP = new RectF();
    }

    public void j(int i, int i2, int i3, int i4, int i5, int i6) {
        this.hCb = i;
        this.mIO = i;
        this.mImageWidth = i2;
        this.mImageHeight = i3;
        this.hCc = i4;
        this.hCd = i5;
        this.hCe = i6;
        cgM();
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        this.hCh = i;
    }

    public void setStrokeStyle(int i) {
        this.hCi = i;
    }

    private void sr() {
        this.mStrokePaint = new Paint();
        this.mStrokePaint.setAntiAlias(true);
        this.mStrokePaint.setStyle(Paint.Style.STROKE);
    }

    private void cgM() {
        for (int i = 0; i < this.hCb; i++) {
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
        int i3 = this.hCc;
        if (this.hCi == 1) {
            i3 = this.hCc * 2;
        }
        setMeasuredDimension(resolveSize(((i3 + (getPaddingLeft() + getPaddingRight())) + (this.mIO * this.mImageWidth)) - ((this.mIO - 1) * this.hCe), i), resolveSize(getPaddingTop() + getPaddingBottom() + this.mImageHeight + (this.hCc * 2), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        View childAt;
        View childAt2;
        if (this.hCg) {
            paddingLeft = this.hCc + getPaddingLeft();
            paddingTop = getPaddingTop() + this.hCc;
        } else {
            paddingLeft = this.hCc + getPaddingLeft() + ((this.mIO - 1) * (this.mImageWidth - this.hCe));
            paddingTop = getPaddingTop() + this.hCc;
        }
        int i5 = paddingLeft;
        for (int i6 = 0; i6 < this.mIO; i6++) {
            if (i6 < getChildCount() && (childAt2 = getChildAt(i6)) != null) {
                childAt2.setVisibility(0);
                if (this.hCg) {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 += this.mImageWidth - this.hCe;
                } else {
                    childAt2.layout(i5, paddingTop, this.mImageWidth + i5, this.mImageHeight + paddingTop);
                    i5 -= this.mImageWidth - this.hCe;
                }
            } else {
                return;
            }
        }
        for (int i7 = this.mIO; i7 < this.hCb && i7 < getChildCount() && (childAt = getChildAt(i7)) != null; i7++) {
            childAt.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        View childAt2;
        int i = 1;
        super.dispatchDraw(canvas);
        this.mStrokePaint.setColor(ap.getColor(this.hCd));
        this.mStrokePaint.setStrokeWidth(this.hCc);
        if (this.hCi != 0) {
            if (this.hCi == 1) {
                this.hCh = this.hCh <= 0 ? this.hCd : this.hCh;
                float f = this.hCc * 0.5f;
                float f2 = this.mImageWidth / 2.0f;
                float acos = ((float) ((Math.acos((((f2 * 2.0f) - this.hCe) / 2.0f) / f2) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(acos * 2.0f);
                int i2 = this.hCg ? 0 : this.mIO - 1;
                int i3 = 0;
                while (i3 < this.mIO) {
                    if (getChildAt(i3) instanceof HeadImageView) {
                        this.mIP.set(childAt2.getLeft() - f, childAt2.getTop() - f, childAt2.getRight() + f, childAt2.getBottom() + f);
                        if (i3 == i2) {
                            this.mStrokePaint.setColor(ap.getColor(this.hCh));
                        } else {
                            this.mStrokePaint.setColor(ap.getColor(this.hCd));
                        }
                        canvas.drawArc(this.mIP, i3 == i2 ? 0.0f : acos, i3 == i2 ? 360.0f : abs, false, this.mStrokePaint);
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        while (true) {
            int i4 = i;
            if (i4 < this.mIO && i4 < getChildCount() && (childAt = getChildAt(i4)) != null) {
                float f3 = this.hCc * 0.5f;
                if (childAt instanceof HeadImageView) {
                    this.mIP.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                    canvas.drawArc(this.mIP, -90.0f, 180.0f, false, this.mStrokePaint);
                }
                i = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        this.mIO = Math.min(this.hCb, y.getCount(list));
        for (int i = 0; i < this.mIO; i++) {
            HeadImageView headImageView = (HeadImageView) getChildAt(i);
            if (headImageView != null && (str = (String) y.getItem(list, (list.size() - i) - 1)) != null) {
                if (this.hds == 12) {
                    headImageView.a(str, 12, this.mImageWidth, this.mImageHeight, false);
                } else {
                    headImageView.a(str, 10, this.mImageWidth, this.mImageHeight, false);
                }
            }
        }
        requestLayout();
    }

    public void onChangeSkinType() {
        this.mStrokePaint.setColor(ap.getColor(this.hCd));
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
        this.hCf = aVar;
    }

    public void setLoadImageType(int i) {
        this.hds = i;
    }

    public void setOrientation(boolean z) {
        this.hCg = z;
    }
}
