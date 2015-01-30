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
    private static int bJJ;
    public TbImageView Mk;
    public TbImageView Ml;
    public TbImageView Mm;
    public Object[] bJI;
    private int bJK;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mk = new TbImageView(context);
        this.Ml = new TbImageView(context);
        this.Mm = new TbImageView(context);
        this.Mk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Ml.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Mm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.Mk);
        addView(this.Ml);
        addView(this.Mm);
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bJI = objArr;
        if (objArr == null) {
            this.Mk.setTag(null);
            this.Ml.setTag(null);
            this.Mm.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.Mk.setTag(null);
            this.Ml.setTag(null);
            this.Mm.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bJK = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.Mk);
            this.Ml.setTag(null);
            this.Mm.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.Mk);
            a((PersonPostModel.Media) objArr[1], this.Ml);
            this.Mm.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.Mk);
            a((PersonPostModel.Media) objArr[1], this.Ml);
            a((PersonPostModel.Media) objArr[2], this.Mm);
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
            tbImageView.a(media.big_pic, 10, this.bJK, this.bJK, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bJJ == 0) {
            bJJ = i3;
        }
        if (this.bJI == null || this.bJI.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.Mk, i4, i5);
        measureChild(this.Ml, i4, i5);
        measureChild(this.Mm, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bJI != null && this.bJI.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.Mk.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.Ml.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.Mm;
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
        if (this.bJI != null && this.bJI.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bJI.length) {
                case 1:
                    drawChild(canvas, this.Mk, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Mk, drawingTime);
                    drawChild(canvas, this.Ml, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Mk, drawingTime);
                    drawChild(canvas, this.Ml, drawingTime);
                    drawChild(canvas, this.Mm, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
