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
    private static int cRz;
    public TbImageView cRv;
    public TbImageView cRw;
    public TbImageView cRx;
    public Object[] cRy;
    private int cfp;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cRv = new TbImageView(context);
        this.cRw = new TbImageView(context);
        this.cRx = new TbImageView(context);
        this.cRv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cRw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cRx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.cRv);
        addView(this.cRw);
        addView(this.cRx);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.cRy = objArr;
        if (objArr == null) {
            this.cRv.setTag(null);
            this.cRw.setTag(null);
            this.cRx.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.cRv.setTag(null);
            this.cRw.setTag(null);
            this.cRx.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.cfp = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.cRv);
            this.cRw.setTag(null);
            this.cRx.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.cRv);
            a((PersonPostModel.Media) objArr[1], this.cRw);
            this.cRx.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.cRv);
            a((PersonPostModel.Media) objArr[1], this.cRw);
            a((PersonPostModel.Media) objArr[2], this.cRx);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(n.e.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(n.e.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.cfp, this.cfp, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (cRz == 0) {
            cRz = i3;
        }
        if (this.cRy == null || this.cRy.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.cRv, i4, i5);
        measureChild(this.cRw, i4, i5);
        measureChild(this.cRx, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.cRy != null && this.cRy.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.cRv.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.cRw.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.cRx;
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
        if (this.cRy != null && this.cRy.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.cRy.length) {
                case 1:
                    drawChild(canvas, this.cRv, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.cRv, drawingTime);
                    drawChild(canvas, this.cRw, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.cRv, drawingTime);
                    drawChild(canvas, this.cRw, drawingTime);
                    drawChild(canvas, this.cRx, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
