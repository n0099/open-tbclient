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
    private static int csr;
    private int bOH;
    public TbImageView csn;
    public TbImageView cso;
    public TbImageView csp;
    public Object[] csq;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csn = new TbImageView(context);
        this.cso = new TbImageView(context);
        this.csp = new TbImageView(context);
        this.csn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cso.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.csp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.csn);
        addView(this.cso);
        addView(this.csp);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.csq = objArr;
        if (objArr == null) {
            this.csn.setTag(null);
            this.cso.setTag(null);
            this.csp.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.csn.setTag(null);
            this.cso.setTag(null);
            this.csp.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bOH = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.csn);
            this.cso.setTag(null);
            this.csp.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.csn);
            a((PersonPostModel.Media) objArr[1], this.cso);
            this.csp.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.csn);
            a((PersonPostModel.Media) objArr[1], this.cso);
            a((PersonPostModel.Media) objArr[2], this.csp);
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
            tbImageView.a(media.big_pic, 10, this.bOH, this.bOH, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (csr == 0) {
            csr = i3;
        }
        if (this.csq == null || this.csq.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.csn, i4, i5);
        measureChild(this.cso, i4, i5);
        measureChild(this.csp, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.csq != null && this.csq.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.csn.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.cso.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.csp;
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
        if (this.csq != null && this.csq.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.csq.length) {
                case 1:
                    drawChild(canvas, this.csn, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.csn, drawingTime);
                    drawChild(canvas, this.cso, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.csn, drawingTime);
                    drawChild(canvas, this.cso, drawingTime);
                    drawChild(canvas, this.csp, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
