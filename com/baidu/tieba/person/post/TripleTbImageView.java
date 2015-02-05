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
    private static int bJI;
    public TbImageView Mh;
    public TbImageView Mi;
    public TbImageView Mj;
    public Object[] bJH;
    private int bJJ;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mh = new TbImageView(context);
        this.Mi = new TbImageView(context);
        this.Mj = new TbImageView(context);
        this.Mh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.Mh);
        addView(this.Mi);
        addView(this.Mj);
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bJH = objArr;
        if (objArr == null) {
            this.Mh.setTag(null);
            this.Mi.setTag(null);
            this.Mj.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.Mh.setTag(null);
            this.Mi.setTag(null);
            this.Mj.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bJJ = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.Mh);
            this.Mi.setTag(null);
            this.Mj.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.Mh);
            a((PersonPostModel.Media) objArr[1], this.Mi);
            this.Mj.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.Mh);
            a((PersonPostModel.Media) objArr[1], this.Mi);
            a((PersonPostModel.Media) objArr[2], this.Mj);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(com.baidu.tieba.v.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(com.baidu.tieba.v.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.bJJ, this.bJJ, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bJI == 0) {
            bJI = i3;
        }
        if (this.bJH == null || this.bJH.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.Mh, i4, i5);
        measureChild(this.Mi, i4, i5);
        measureChild(this.Mj, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bJH != null && this.bJH.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.Mh.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.Mi.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.Mj;
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
        if (this.bJH != null && this.bJH.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bJH.length) {
                case 1:
                    drawChild(canvas, this.Mh, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Mh, drawingTime);
                    drawChild(canvas, this.Mi, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Mh, drawingTime);
                    drawChild(canvas, this.Mi, drawingTime);
                    drawChild(canvas, this.Mj, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
