package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.post.PersonPostModel;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int bEC;
    public TbImageView bEA;
    public Object[] bEB;
    private int bED;
    public TbImageView bEy;
    public TbImageView bEz;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bEy = new TbImageView(context);
        this.bEz = new TbImageView(context);
        this.bEA = new TbImageView(context);
        this.bEy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.bEy);
        addView(this.bEz);
        addView(this.bEA);
        this.mPadding = com.baidu.adp.lib.util.m.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bEB = objArr;
        if (objArr == null) {
            this.bEy.setTag(null);
            this.bEz.setTag(null);
            this.bEA.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.bEy.setTag(null);
            this.bEz.setTag(null);
            this.bEA.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bED = Constants.MEDIA_INFO;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.bEy);
            this.bEz.setTag(null);
            this.bEA.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.bEy);
            a((PersonPostModel.Media) objArr[1], this.bEz);
            this.bEA.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.bEy);
            a((PersonPostModel.Media) objArr[1], this.bEz);
            a((PersonPostModel.Media) objArr[2], this.bEA);
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
            tbImageView.a(media.big_pic, 10, this.bED, this.bED, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bEC == 0) {
            bEC = i3;
        }
        if (this.bEB == null || this.bEB.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.bEy, i4, i5);
        measureChild(this.bEz, i4, i5);
        measureChild(this.bEA, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bEB != null && this.bEB.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.bEy.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.bEz.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.bEA;
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
        if (this.bEB != null && this.bEB.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bEB.length) {
                case 1:
                    drawChild(canvas, this.bEy, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.bEy, drawingTime);
                    drawChild(canvas, this.bEz, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.bEy, drawingTime);
                    drawChild(canvas, this.bEz, drawingTime);
                    drawChild(canvas, this.bEA, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
