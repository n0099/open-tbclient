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
    private static float[] bQG = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] bQH = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int bQI = 2;
    private static int bQJ = 4;
    private static int bQK = 0;
    public static float vh = -1.0f;
    public TbImageView bEk;
    public TbImageView bEl;
    public TbImageView bEm;
    private MediaData[] bQL;
    private boolean bQM;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (vh < 0.0f) {
            vh = com.baidu.adp.lib.util.m.n(this.mContext) / 320.0f;
            for (int i = 0; i < bQG.length; i++) {
                float[] fArr = bQG;
                fArr[i] = fArr[i] * vh;
                float[] fArr2 = bQH;
                fArr2[i] = fArr2[i] * vh;
            }
            bQI = (int) (bQI * vh);
            bQJ = (int) (bQJ * vh);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.bQM = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkApplication.m251getInst().getSkinType();
        Drawable drawable = aw.getDrawable(com.baidu.tieba.s.pb_default_image_bg);
        this.bEk = new TbImageView(context);
        this.bEl = new TbImageView(context);
        this.bEm = new TbImageView(context);
        this.bEk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bEk.setDefaultBg(drawable);
        this.bEl.setDefaultBg(drawable);
        this.bEm.setDefaultBg(drawable);
        addView(this.bEk);
        addView(this.bEl);
        addView(this.bEm);
        this.mPadding = (int) (this.mPadding * vh);
    }

    public void setShowBig(boolean z) {
        this.bQM = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.bQL = mediaDataArr;
        if (this.bQL == null || this.bQL.length <= 0) {
            if (this.bEk != null) {
                this.bEk.setTag(null);
            }
            if (this.bEl != null) {
                this.bEl.setTag(null);
            }
            if (this.bEm != null) {
                this.bEm.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.bQL.length;
        if (length == 1) {
            a(this.bEk, this.bQL[0]);
            if (this.bEl != null) {
                this.bEl.setTag(null);
                this.bEl.setClickable(false);
            }
            if (this.bEm != null) {
                this.bEm.setTag(null);
                this.bEm.setClickable(false);
            }
        } else if (length == 2) {
            a(this.bEk, this.bQL[0]);
            a(this.bEl, this.bQL[1]);
            if (this.bEm != null) {
                this.bEm.setTag(null);
                this.bEm.setClickable(false);
            }
        } else if (length == 3) {
            a(this.bEk, this.bQL[0]);
            a(this.bEl, this.bQL[1]);
            a(this.bEm, this.bQL[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (bQK == 0) {
            bQK = i5;
        }
        if (this.bQL == null || this.bQL.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.bQM) {
            setMeasuredDimension(bQK, (int) (bQH[this.bQL.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(bQK, (int) (bQH[4] + 0.5f));
        }
        switch (this.bQL.length) {
            case 1:
                if (this.bQM) {
                    measureChild(this.bEk, bQK + 1073741824, ((int) (bQH[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.bEk, ((int) (bQG[4] + 0.5f)) + 1073741824, ((int) (bQH[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.bEl, 0, 0);
                measureChild(this.bEm, 0, 0);
                return;
            case 2:
                if (this.bQM) {
                    i3 = ((int) (bQG[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (bQH[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (bQG[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (bQH[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.bEk, i3, i4);
                measureChild(this.bEl, i3, i4);
                measureChild(this.bEm, 0, 0);
                return;
            case 3:
                if (this.bQM) {
                    int i6 = ((int) (bQG[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (bQH[3] + 0.5f)) + 1073741824;
                    measureChild(this.bEk, ((int) (bQG[2] + 0.5f)) + 1073741824, ((int) (bQH[2] + 0.5f)) + 1073741824);
                    measureChild(this.bEl, i6, i7);
                    measureChild(this.bEm, i6, i7);
                    return;
                }
                int i8 = ((int) (bQG[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (bQH[4] + 0.5f)) + 1073741824;
                measureChild(this.bEk, i8, i9);
                measureChild(this.bEl, i8, i9);
                measureChild(this.bEm, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.bQL != null && this.bQL.length != 0) {
            switch (this.bQL.length) {
                case 1:
                    if (this.bQM) {
                        int i5 = (int) (bQG[0] + 0.5f);
                        this.bEk.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.bEk.layout(this.mPadding, 0, ((int) (bQG[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.bEl.layout(0, 0, 0, 0);
                    this.bEm.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.bQM) {
                        int i6 = (int) (bQG[1] + 0.5f);
                        this.bEk.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.bEl.layout(i6 + this.mPadding + bQJ, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (bQG[4] + 0.5f);
                        this.bEk.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.bEl.layout(this.mPadding + i7 + bQI, 0, (i7 * 2) + this.mPadding + bQI, i4 - i2);
                    }
                    this.bEm.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.bQM) {
                        int i8 = (int) (bQG[2] + 0.5f);
                        int i9 = (int) (bQG[3] + 0.5f);
                        this.bEk.layout(0, 0, i8, i4 - i2);
                        this.bEl.layout(bQI + i8, 0, i3, i9);
                        this.bEm.layout(i8 + bQI, i9 + bQI, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (bQG[4] + 0.5f);
                    this.bEk.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.bEl.layout(this.mPadding + i10 + bQI, 0, (i10 * 2) + this.mPadding + bQI, i4 - i2);
                    this.bEm.layout((i10 * 2) + this.mPadding + (bQI * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bQL != null && this.bQL.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.bQL.length) {
                case 1:
                    drawChild(canvas, this.bEk, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.bEk, drawingTime);
                    drawChild(canvas, this.bEl, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.bEk, drawingTime);
                    drawChild(canvas, this.bEl, drawingTime);
                    drawChild(canvas, this.bEm, drawingTime);
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
