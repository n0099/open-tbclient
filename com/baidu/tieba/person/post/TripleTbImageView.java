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
    private static int bSi;
    public TbImageView Xq;
    public TbImageView Xr;
    public TbImageView Xs;
    public Object[] bSh;
    private int bSj;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xq = new TbImageView(context);
        this.Xr = new TbImageView(context);
        this.Xs = new TbImageView(context);
        this.Xq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.Xq);
        addView(this.Xr);
        addView(this.Xs);
        this.mPadding = com.baidu.adp.lib.util.n.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bSh = objArr;
        if (objArr == null) {
            this.Xq.setTag(null);
            this.Xr.setTag(null);
            this.Xs.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.Xq.setTag(null);
            this.Xr.setTag(null);
            this.Xs.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bSj = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.Xq);
            this.Xr.setTag(null);
            this.Xs.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.Xq);
            a((PersonPostModel.Media) objArr[1], this.Xr);
            this.Xs.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.Xq);
            a((PersonPostModel.Media) objArr[1], this.Xr);
            a((PersonPostModel.Media) objArr[2], this.Xs);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(com.baidu.tieba.u.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(com.baidu.tieba.u.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.bSj, this.bSj, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bSi == 0) {
            bSi = i3;
        }
        if (this.bSh == null || this.bSh.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.Xq, i4, i5);
        measureChild(this.Xr, i4, i5);
        measureChild(this.Xs, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bSh != null && this.bSh.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.Xq.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.Xr.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.Xs;
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
        if (this.bSh != null && this.bSh.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bSh.length) {
                case 1:
                    drawChild(canvas, this.Xq, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Xq, drawingTime);
                    drawChild(canvas, this.Xr, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Xq, drawingTime);
                    drawChild(canvas, this.Xr, drawingTime);
                    drawChild(canvas, this.Xs, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
