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
    private static int dBY;
    private int bwl;
    public TbImageView dBU;
    public TbImageView dBV;
    public TbImageView dBW;
    public Object[] dBX;
    private boolean dBZ;
    private int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBZ = true;
        this.dBU = new TbImageView(context);
        this.dBV = new TbImageView(context);
        this.dBW = new TbImageView(context);
        this.dBU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dBV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dBW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dBU);
        addView(this.dBV);
        addView(this.dBW);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void gQ(boolean z) {
        this.dBZ = z;
    }

    public void setTags(Object[] objArr) {
        this.dBX = objArr;
        if (this.dBZ) {
            this.mPadding = com.baidu.adp.lib.util.k.dip2px(getContext(), 6.0f);
        } else {
            this.mPadding = 0;
        }
        if (objArr == null) {
            this.dBU.setTag(null);
            this.dBV.setTag(null);
            this.dBW.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.dBU.setTag(null);
            this.dBV.setTag(null);
            this.dBW.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bwl = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.dBU);
            this.dBV.setTag(null);
            this.dBW.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.dBU);
            a((PersonPostModel.Media) objArr[1], this.dBV);
            this.dBW.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.dBU);
            a((PersonPostModel.Media) objArr[1], this.dBV);
            a((PersonPostModel.Media) objArr[2], this.dBW);
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
                if (!this.dBZ) {
                    tbImageView.setDefaultErrorResource(t.f.pic_video);
                    str = null;
                } else {
                    tbImageView.setDefaultErrorResource(0);
                }
            }
            tbImageView.setTag(str);
            tbImageView.a(str, 10, this.bwl, this.bwl, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (dBY == 0) {
            dBY = i3;
        }
        if (this.dBX == null || this.dBX.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.dBU, i4, i5);
        measureChild(this.dBV, i4, i5);
        measureChild(this.dBW, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.dBX != null && this.dBX.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.dBU.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.dBV.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.dBW;
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
        if (this.dBX != null && this.dBX.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.dBX.length) {
                case 1:
                    drawChild(canvas, this.dBU, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.dBU, drawingTime);
                    drawChild(canvas, this.dBV, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.dBU, drawingTime);
                    drawChild(canvas, this.dBV, drawingTime);
                    drawChild(canvas, this.dBW, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
