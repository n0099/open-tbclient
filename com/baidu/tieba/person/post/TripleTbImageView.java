package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.PersonPostModel;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int bHX;
    public TbImageView LQ;
    public TbImageView LR;
    public TbImageView LS;
    public Object[] bHW;
    private int bHY;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.LQ = new TbImageView(context);
        this.LR = new TbImageView(context);
        this.LS = new TbImageView(context);
        this.LQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.LR.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.LS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.LQ);
        addView(this.LR);
        addView(this.LS);
        this.mPadding = com.baidu.adp.lib.util.l.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.bHW = objArr;
        if (objArr == null) {
            this.LQ.setTag(null);
            this.LR.setTag(null);
            this.LS.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.LQ.setTag(null);
            this.LR.setTag(null);
            this.LS.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bHY = Constants.MEDIA_INFO;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.LQ);
            this.LR.setTag(null);
            this.LS.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.LQ);
            a((PersonPostModel.Media) objArr[1], this.LR);
            this.LS.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.LQ);
            a((PersonPostModel.Media) objArr[1], this.LR);
            a((PersonPostModel.Media) objArr[2], this.LS);
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
            tbImageView.a(media.big_pic, 10, this.bHY, this.bHY, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (bHX == 0) {
            bHX = i3;
        }
        if (this.bHW == null || this.bHW.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.LQ, i4, i5);
        measureChild(this.LR, i4, i5);
        measureChild(this.LS, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.bHW != null && this.bHW.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.LQ.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.LR.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.LS;
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
        if (this.bHW != null && this.bHW.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bHW.length) {
                case 1:
                    drawChild(canvas, this.LQ, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.LQ, drawingTime);
                    drawChild(canvas, this.LR, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.LQ, drawingTime);
                    drawChild(canvas, this.LR, drawingTime);
                    drawChild(canvas, this.LS, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
