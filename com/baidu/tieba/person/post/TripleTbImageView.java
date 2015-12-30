package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int cWa;
    public TbImageView cVW;
    public TbImageView cVX;
    public TbImageView cVY;
    public Object[] cVZ;
    private int cjt;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cVW = new TbImageView(context);
        this.cVX = new TbImageView(context);
        this.cVY = new TbImageView(context);
        this.cVW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cVX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cVY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.cVW);
        addView(this.cVX);
        addView(this.cVY);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.cVZ = objArr;
        if (objArr == null) {
            this.cVW.setTag(null);
            this.cVX.setTag(null);
            this.cVY.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.cVW.setTag(null);
            this.cVX.setTag(null);
            this.cVY.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.cjt = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.cVW);
            this.cVX.setTag(null);
            this.cVY.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.cVW);
            a((PersonPostModel.Media) objArr[1], this.cVX);
            this.cVY.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.cVW);
            a((PersonPostModel.Media) objArr[1], this.cVX);
            a((PersonPostModel.Media) objArr[2], this.cVY);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(n.f.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(n.f.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.cjt, this.cjt, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (cWa == 0) {
            cWa = i3;
        }
        if (this.cVZ == null || this.cVZ.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.cVW, i4, i5);
        measureChild(this.cVX, i4, i5);
        measureChild(this.cVY, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.cVZ != null && this.cVZ.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.cVW.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.cVX.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.cVY;
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
        if (this.cVZ != null && this.cVZ.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.cVZ.length) {
                case 1:
                    drawChild(canvas, this.cVW, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.cVW, drawingTime);
                    drawChild(canvas, this.cVX, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.cVW, drawingTime);
                    drawChild(canvas, this.cVX, drawingTime);
                    drawChild(canvas, this.cVY, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
