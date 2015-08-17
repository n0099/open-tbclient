package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int clx;
    public TbImageView ada;
    public TbImageView adb;
    public TbImageView adc;
    public Object[] clw;
    private int cly;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ada = new TbImageView(context);
        this.adb = new TbImageView(context);
        this.adc = new TbImageView(context);
        this.ada.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.ada);
        addView(this.adb);
        addView(this.adc);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.clw = objArr;
        if (objArr == null) {
            this.ada.setTag(null);
            this.adb.setTag(null);
            this.adc.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.ada.setTag(null);
            this.adb.setTag(null);
            this.adc.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.cly = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.ada);
            this.adb.setTag(null);
            this.adc.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.ada);
            a((PersonPostModel.Media) objArr[1], this.adb);
            this.adc.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.ada);
            a((PersonPostModel.Media) objArr[1], this.adb);
            a((PersonPostModel.Media) objArr[2], this.adc);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(i.e.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(i.e.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.cly, this.cly, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (clx == 0) {
            clx = i3;
        }
        if (this.clw == null || this.clw.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.ada, i4, i5);
        measureChild(this.adb, i4, i5);
        measureChild(this.adc, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.clw != null && this.clw.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.ada.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.adb.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.adc;
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
        if (this.clw != null && this.clw.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.clw.length) {
                case 1:
                    drawChild(canvas, this.ada, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.ada, drawingTime);
                    drawChild(canvas, this.adb, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.ada, drawingTime);
                    drawChild(canvas, this.adb, drawingTime);
                    drawChild(canvas, this.adc, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
