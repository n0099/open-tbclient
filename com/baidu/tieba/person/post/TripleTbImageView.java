package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {
    private static int eok;
    private int bTJ;
    public TbImageView eog;
    public TbImageView eoh;
    public TbImageView eoi;
    public Object[] eoj;
    private boolean eol;
    private int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eol = true;
        this.eog = new TbImageView(context);
        this.eoh = new TbImageView(context);
        this.eoi = new TbImageView(context);
        this.eog.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eoi.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.eog);
        addView(this.eoh);
        addView(this.eoi);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void is(boolean z) {
        this.eol = z;
    }

    public void setTags(Object[] objArr) {
        this.eoj = objArr;
        if (this.eol) {
            this.mPadding = com.baidu.adp.lib.util.k.dip2px(getContext(), 6.0f);
        } else {
            this.mPadding = 0;
        }
        if (objArr == null) {
            this.eog.setTag(null);
            this.eoh.setTag(null);
            this.eoi.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.eog.setTag(null);
            this.eoh.setTag(null);
            this.eoi.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.bTJ = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.eog);
            this.eoh.setTag(null);
            this.eoi.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.eog);
            a((PersonPostModel.Media) objArr[1], this.eoh);
            this.eoi.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.eog);
            a((PersonPostModel.Media) objArr[1], this.eoh);
            a((PersonPostModel.Media) objArr[2], this.eoi);
        }
        requestLayout();
        invalidate();
    }

    private void a(PersonPostModel.Media media, TbImageView tbImageView) {
        if (media != null && tbImageView != null) {
            String str = media.big_pic;
            if (media.type == 3) {
                tbImageView.setDefaultResource(u.f.img_default_100);
            } else if (media.type == 5) {
                tbImageView.setDefaultResource(u.f.pic_video);
                if (!this.eol) {
                    tbImageView.setDefaultErrorResource(u.f.pic_video);
                    str = null;
                } else {
                    tbImageView.setDefaultErrorResource(0);
                }
            }
            tbImageView.setTag(str);
            tbImageView.a(str, 10, this.bTJ, this.bTJ, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (eok == 0) {
            eok = i3;
        }
        if (this.eoj == null || this.eoj.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.eog, i4, i5);
        measureChild(this.eoh, i4, i5);
        measureChild(this.eoi, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.eoj != null && this.eoj.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.eog.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.eoh.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.eoi;
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
        if (this.eoj != null && this.eoj.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.eoj.length) {
                case 1:
                    drawChild(canvas, this.eog, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.eog, drawingTime);
                    drawChild(canvas, this.eoh, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.eog, drawingTime);
                    drawChild(canvas, this.eoh, drawingTime);
                    drawChild(canvas, this.eoi, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
