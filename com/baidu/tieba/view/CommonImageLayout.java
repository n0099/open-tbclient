package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] bQV = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] bQW = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int bQX = 2;
    private static int bQY = 4;
    private static int bQZ = 0;
    public static float vh = -1.0f;
    public TbImageView bEA;
    public TbImageView bEy;
    public TbImageView bEz;
    private MediaData[] bRa;
    private boolean bRb;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (vh < 0.0f) {
            vh = com.baidu.adp.lib.util.m.n(this.mContext) / 320.0f;
            for (int i = 0; i < bQV.length; i++) {
                float[] fArr = bQV;
                fArr[i] = fArr[i] * vh;
                float[] fArr2 = bQW;
                fArr2[i] = fArr2[i] * vh;
            }
            bQX = (int) (bQX * vh);
            bQY = (int) (bQY * vh);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.bRb = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkApplication.m251getInst().getSkinType();
        Drawable drawable = aw.getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        this.bEy = new TbImageView(context);
        this.bEz = new TbImageView(context);
        this.bEA = new TbImageView(context);
        this.bEy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEy.setDefaultBg(drawable);
        this.bEz.setDefaultBg(drawable);
        this.bEA.setDefaultBg(drawable);
        addView(this.bEy);
        addView(this.bEz);
        addView(this.bEA);
        this.mPadding = (int) (this.mPadding * vh);
    }

    public void setShowBig(boolean z) {
        this.bRb = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.bRa = mediaDataArr;
        if (this.bRa == null || this.bRa.length <= 0) {
            if (this.bEy != null) {
                this.bEy.setTag(null);
            }
            if (this.bEz != null) {
                this.bEz.setTag(null);
            }
            if (this.bEA != null) {
                this.bEA.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.bRa.length;
        if (length == 1) {
            a(this.bEy, this.bRa[0]);
            if (this.bEz != null) {
                this.bEz.setTag(null);
                this.bEz.setClickable(false);
            }
            if (this.bEA != null) {
                this.bEA.setTag(null);
                this.bEA.setClickable(false);
            }
        } else if (length == 2) {
            a(this.bEy, this.bRa[0]);
            a(this.bEz, this.bRa[1]);
            if (this.bEA != null) {
                this.bEA.setTag(null);
                this.bEA.setClickable(false);
            }
        } else if (length == 3) {
            a(this.bEy, this.bRa[0]);
            a(this.bEz, this.bRa[1]);
            a(this.bEA, this.bRa[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (bQZ == 0) {
            bQZ = i5;
        }
        if (this.bRa == null || this.bRa.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.bRb) {
            setMeasuredDimension(bQZ, (int) (bQW[this.bRa.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(bQZ, (int) (bQW[4] + 0.5f));
        }
        switch (this.bRa.length) {
            case 1:
                if (this.bRb) {
                    measureChild(this.bEy, bQZ + 1073741824, ((int) (bQW[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.bEy, ((int) (bQV[4] + 0.5f)) + 1073741824, ((int) (bQW[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.bEz, 0, 0);
                measureChild(this.bEA, 0, 0);
                return;
            case 2:
                if (this.bRb) {
                    i3 = ((int) (bQV[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (bQW[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (bQV[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (bQW[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.bEy, i3, i4);
                measureChild(this.bEz, i3, i4);
                measureChild(this.bEA, 0, 0);
                return;
            case 3:
                if (this.bRb) {
                    int i6 = ((int) (bQV[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (bQW[3] + 0.5f)) + 1073741824;
                    measureChild(this.bEy, ((int) (bQV[2] + 0.5f)) + 1073741824, ((int) (bQW[2] + 0.5f)) + 1073741824);
                    measureChild(this.bEz, i6, i7);
                    measureChild(this.bEA, i6, i7);
                    return;
                }
                int i8 = ((int) (bQV[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (bQW[4] + 0.5f)) + 1073741824;
                measureChild(this.bEy, i8, i9);
                measureChild(this.bEz, i8, i9);
                measureChild(this.bEA, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.bRa != null && this.bRa.length != 0) {
            switch (this.bRa.length) {
                case 1:
                    if (this.bRb) {
                        int i5 = (int) (bQV[0] + 0.5f);
                        this.bEy.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.bEy.layout(this.mPadding, 0, ((int) (bQV[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.bEz.layout(0, 0, 0, 0);
                    this.bEA.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.bRb) {
                        int i6 = (int) (bQV[1] + 0.5f);
                        this.bEy.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.bEz.layout(i6 + this.mPadding + bQY, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (bQV[4] + 0.5f);
                        this.bEy.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.bEz.layout(this.mPadding + i7 + bQX, 0, (i7 * 2) + this.mPadding + bQX, i4 - i2);
                    }
                    this.bEA.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.bRb) {
                        int i8 = (int) (bQV[2] + 0.5f);
                        int i9 = (int) (bQV[3] + 0.5f);
                        this.bEy.layout(0, 0, i8, i4 - i2);
                        this.bEz.layout(bQX + i8, 0, i3, i9);
                        this.bEA.layout(i8 + bQX, i9 + bQX, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (bQV[4] + 0.5f);
                    this.bEy.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.bEz.layout(this.mPadding + i10 + bQX, 0, (i10 * 2) + this.mPadding + bQX, i4 - i2);
                    this.bEA.layout((i10 * 2) + this.mPadding + (bQX * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bRa != null && this.bRa.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bRa.length) {
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

    public int getPadding() {
        return this.mPadding;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    private void a(TbImageView tbImageView, MediaData mediaData) {
        if (tbImageView != null) {
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(com.baidu.tieba.u.pic_video);
                tbImageView.setOnClickListener(new f(this, mediaData));
            } else {
                tbImageView.setClickable(false);
            }
            tbImageView.setTag(picUrl);
            tbImageView.c(picUrl, 13, false);
        }
    }

    public void setFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public void reset() {
    }
}
