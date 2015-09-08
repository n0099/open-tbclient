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
    private static int cmA;
    public TbImageView adl;
    public TbImageView adm;
    public TbImageView adn;
    private int cmB;
    public Object[] cmz;
    public final int mPadding;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adl = new TbImageView(context);
        this.adm = new TbImageView(context);
        this.adn = new TbImageView(context);
        this.adl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.adn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.adl);
        addView(this.adm);
        addView(this.adn);
        this.mPadding = com.baidu.adp.lib.util.k.dip2px(context, 6.0f);
    }

    public void setTags(Object[] objArr) {
        this.cmz = objArr;
        if (objArr == null) {
            this.adl.setTag(null);
            this.adm.setTag(null);
            this.adn.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.adl.setTag(null);
            this.adm.setTag(null);
            this.adn.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        this.cmB = 200;
        if (length == 1) {
            a((PersonPostModel.Media) objArr[0], this.adl);
            this.adm.setTag(null);
            this.adn.setTag(null);
        } else if (length == 2) {
            a((PersonPostModel.Media) objArr[0], this.adl);
            a((PersonPostModel.Media) objArr[1], this.adm);
            this.adn.setTag(null);
        } else if (length == 3) {
            a((PersonPostModel.Media) objArr[0], this.adl);
            a((PersonPostModel.Media) objArr[1], this.adm);
            a((PersonPostModel.Media) objArr[2], this.adn);
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
            tbImageView.a(media.big_pic, 10, this.cmB, this.cmB, false);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (cmA == 0) {
            cmA = i3;
        }
        if (this.cmz == null || this.cmz.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * 0.33f) + 0.5f));
        int i4 = ((i3 - (this.mPadding * 4)) / 3) + 1073741824;
        int i5 = ((int) ((i4 * 0.33f) + 0.5f)) + 1073741824;
        measureChild(this.adl, i4, i5);
        measureChild(this.adm, i4, i5);
        measureChild(this.adn, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int min = Math.min(i4, getHeight());
        if (this.cmz != null && this.cmz.length != 0) {
            int measuredWidth = (getMeasuredWidth() - (this.mPadding * 4)) / 3;
            this.adl.layout(this.mPadding, this.mPadding + 0, measuredWidth + this.mPadding, min > this.mPadding ? min - this.mPadding : min);
            this.adm.layout(measuredWidth + (this.mPadding * 2), this.mPadding + 0, (this.mPadding * 2) + (measuredWidth * 2), min > this.mPadding ? min - this.mPadding : min);
            TbImageView tbImageView = this.adn;
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
        if (this.cmz != null && this.cmz.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.cmz.length) {
                case 1:
                    drawChild(canvas, this.adl, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.adl, drawingTime);
                    drawChild(canvas, this.adm, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.adl, drawingTime);
                    drawChild(canvas, this.adm, drawingTime);
                    drawChild(canvas, this.adn, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
