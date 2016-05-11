package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int dFg;
    private int bvY;
    public TbImageView dFc;
    public TbImageView dFd;
    public TbImageView dFe;
    public Object[] dFf;
    private boolean dFh;
    private int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dFh = true;
        this.dFc = new TbImageView(context);
        this.dFd = new TbImageView(context);
        this.dFe = new TbImageView(context);
        this.dFc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dFd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dFe.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dFc);
        addView(this.dFd);
        addView(this.dFe);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void hx(boolean z) {
        this.dFh = z;
    }

    public void setTags(Object[] objArr) {
        this.dFf = objArr;
        if (this.dFh) {
            this.mPadding = com.baidu.adp.lib.util.k.dip2px(getContext(), 6.0f);
        } else {
            this.mPadding = 0;
        }
        if (objArr == null) {
            this.dFc.setTag(null);
            this.dFd.setTag(null);
            this.dFe.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.dFc.setTag(null);
            this.dFd.setTag(null);
            this.dFe.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bvY = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.dFc);
            this.dFd.setTag(null);
            this.dFe.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.dFc);
            a((PersonPostModel.Media) objArr[1], this.dFd);
            this.dFe.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.dFc);
            a((PersonPostModel.Media) objArr[1], this.dFd);
            a((PersonPostModel.Media) objArr[2], this.dFe);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            String str = media.big_pic;
            if (media.type == 3) {
                tbImageView.setDefaultResource(t.f.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(t.f.pic_video);
                if (!this.dFh) {
                    tbImageView.setDefaultErrorResource(t.f.pic_video);
                    str = null;
                } else {
                    tbImageView.setDefaultErrorResource(0);
                }
            }
            tbImageView.setTag(str);
            tbImageView.a(str, 10, this.bvY, this.bvY, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (dFg == 0) {
            dFg = i3;
        }
        if (this.dFf == null || this.dFf.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.dFc, i4, i5);
        measureChild(this.dFd, i4, i5);
        measureChild(this.dFe, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.dFf != null && this.dFf.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.dFc.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.dFd.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.dFe;
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
        if (this.dFf != null && this.dFf.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.dFf.length) {
                case 1:
                    drawChild(canvas, this.dFc, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.dFc, drawingTime);
                    drawChild(canvas, this.dFd, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.dFc, drawingTime);
                    drawChild(canvas, this.dFd, drawingTime);
                    drawChild(canvas, this.dFe, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
