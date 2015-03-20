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
    private static int bRS;
    public TbImageView Xo;
    public TbImageView Xp;
    public TbImageView Xq;
    public Object[] bRR;
    private int bRT;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Xo = new TbImageView(context);
        this.Xp = new TbImageView(context);
        this.Xq = new TbImageView(context);
        this.Xo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Xq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.Xo);
        addView(this.Xp);
        addView(this.Xq);
        this.mPadding = com.baidu.adp.lib.util.n.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bRR = objArr;
        if (objArr == null) {
            this.Xo.setTag(null);
            this.Xp.setTag(null);
            this.Xq.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.Xo.setTag(null);
            this.Xp.setTag(null);
            this.Xq.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bRT = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.Xo);
            this.Xp.setTag(null);
            this.Xq.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.Xo);
            a((PersonPostModel.Media) objArr[1], this.Xp);
            this.Xq.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.Xo);
            a((PersonPostModel.Media) objArr[1], this.Xp);
            a((PersonPostModel.Media) objArr[2], this.Xq);
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
            tbImageView.a(media.big_pic, 10, this.bRT, this.bRT, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bRS == 0) {
            bRS = i3;
        }
        if (this.bRR == null || this.bRR.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.Xo, i4, i5);
        measureChild(this.Xp, i4, i5);
        measureChild(this.Xq, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bRR != null && this.bRR.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.Xo.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.Xp.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.Xq;
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
        if (this.bRR != null && this.bRR.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bRR.length) {
                case 1:
                    drawChild(canvas, this.Xo, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.Xo, drawingTime);
                    drawChild(canvas, this.Xp, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.Xo, drawingTime);
                    drawChild(canvas, this.Xp, drawingTime);
                    drawChild(canvas, this.Xq, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
