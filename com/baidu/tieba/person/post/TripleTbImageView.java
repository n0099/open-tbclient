package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int bUQ;
    public TbImageView Yd;
    public TbImageView Ye;
    public TbImageView Yf;
    public Object[] bUP;
    private int bUR;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Yd = new TbImageView(context);
        this.Ye = new TbImageView(context);
        this.Yf = new TbImageView(context);
        this.Yd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Ye.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Yf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.Yd);
        addView(this.Ye);
        addView(this.Yf);
        this.mPadding = com.baidu.adp.lib.util.n.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bUP = objArr;
        if (objArr == null) {
            this.Yd.setTag(null);
            this.Ye.setTag(null);
            this.Yf.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.Yd.setTag(null);
            this.Ye.setTag(null);
            this.Yf.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bUR = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.Yd);
            this.Ye.setTag(null);
            this.Yf.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.Yd);
            a((PersonPostModel.Media) objArr[1], this.Ye);
            this.Yf.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.Yd);
            a((PersonPostModel.Media) objArr[1], this.Ye);
            a((PersonPostModel.Media) objArr[2], this.Yf);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(com.baidu.tieba.p.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(com.baidu.tieba.p.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.bUR, this.bUR, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bUQ == 0) {
            bUQ = i3;
        }
        if (this.bUP == null || this.bUP.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.Yd, i4, i5);
        measureChild(this.Ye, i4, i5);
        measureChild(this.Yf, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bUP != null && this.bUP.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.Yd.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.Ye.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.Yf;
            int i5 = (measuredWidth * 2) + (this.mPadding * 3);
            int i6 = this.mPadding + 0;
            int i7 = (measuredWidth * 3) + (this.mPadding * 3);
            if (min > this.mPadding) {
                min -= this.mPadding;
            }
            tbImageView.layout(i5, i6, i7, min);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bUP != null && this.bUP.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bUP.length) {
                case 1:
                    drawChild(canvas, this.Yd, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Yd, drawingTime);
                    drawChild(canvas, this.Ye, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Yd, drawingTime);
                    drawChild(canvas, this.Ye, drawingTime);
                    drawChild(canvas, this.Yf, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
