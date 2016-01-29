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
    private static int dhy;
    private int cnT;
    public TbImageView dhu;
    public TbImageView dhv;
    public TbImageView dhw;
    public Object[] dhx;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dhu = new TbImageView(context);
        this.dhv = new TbImageView(context);
        this.dhw = new TbImageView(context);
        this.dhu.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dhv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dhw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.dhu);
        addView(this.dhv);
        addView(this.dhw);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.dhx = objArr;
        if (objArr == null) {
            this.dhu.setTag(null);
            this.dhv.setTag(null);
            this.dhw.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.dhu.setTag(null);
            this.dhv.setTag(null);
            this.dhw.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.cnT = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.dhu);
            this.dhv.setTag(null);
            this.dhw.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.dhu);
            a((PersonPostModel.Media) objArr[1], this.dhv);
            this.dhw.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.dhu);
            a((PersonPostModel.Media) objArr[1], this.dhv);
            a((PersonPostModel.Media) objArr[2], this.dhw);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            if (media.type == 3) {
                tbImageView.setDefaultResource(t.f.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(t.f.pic_video);
            }
            tbImageView.setTag(media.big_pic);
            tbImageView.a(media.big_pic, 10, this.cnT, this.cnT, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (dhy == 0) {
            dhy = i3;
        }
        if (this.dhx == null || this.dhx.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.dhu, i4, i5);
        measureChild(this.dhv, i4, i5);
        measureChild(this.dhw, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.dhx != null && this.dhx.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.dhu.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.dhv.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.dhw;
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
        if (this.dhx != null && this.dhx.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.dhx.length) {
                case 1:
                    drawChild(canvas, this.dhu, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.dhu, drawingTime);
                    drawChild(canvas, this.dhv, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.dhu, drawingTime);
                    drawChild(canvas, this.dhv, drawingTime);
                    drawChild(canvas, this.dhw, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
