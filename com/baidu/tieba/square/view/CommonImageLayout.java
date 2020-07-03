package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] lCD = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] lCE = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int lCF = 2;
    private static int lCG = 4;
    private static int lCH = 0;
    public static float sRatio = -1.0f;
    public TbImageView lCI;
    public TbImageView lCJ;
    public TbImageView lCK;
    private MediaData[] lCL;
    private boolean lCM;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < lCD.length; i++) {
                float[] fArr = lCD;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = lCE;
                fArr2[i] = fArr2[i] * sRatio;
            }
            lCF = (int) (lCF * sRatio);
            lCG = (int) (lCG * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.lCM = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = an.getDrawable(R.color.common_color_10220);
        this.lCI = new TbImageView(context);
        this.lCJ = new TbImageView(context);
        this.lCK = new TbImageView(context);
        this.lCI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lCJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lCK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lCI.setDefaultBg(drawable);
        this.lCJ.setDefaultBg(drawable);
        this.lCK.setDefaultBg(drawable);
        addView(this.lCI);
        addView(this.lCJ);
        addView(this.lCK);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.lCM = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.lCL = mediaDataArr;
        if (this.lCL == null || this.lCL.length <= 0) {
            if (this.lCI != null) {
                this.lCI.setTag(null);
            }
            if (this.lCJ != null) {
                this.lCJ.setTag(null);
            }
            if (this.lCK != null) {
                this.lCK.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.lCL.length;
        if (length == 1) {
            a(this.lCI, this.lCL[0]);
            if (this.lCJ != null) {
                this.lCJ.setTag(null);
                this.lCJ.setClickable(false);
            }
            if (this.lCK != null) {
                this.lCK.setTag(null);
                this.lCK.setClickable(false);
            }
        } else if (length == 2) {
            a(this.lCI, this.lCL[0]);
            a(this.lCJ, this.lCL[1]);
            if (this.lCK != null) {
                this.lCK.setTag(null);
                this.lCK.setClickable(false);
            }
        } else if (length == 3) {
            a(this.lCI, this.lCL[0]);
            a(this.lCJ, this.lCL[1]);
            a(this.lCK, this.lCL[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (lCH == 0) {
            lCH = i5;
        }
        if (this.lCL == null || this.lCL.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.lCM) {
            setMeasuredDimension(lCH, (int) (lCE[this.lCL.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(lCH, (int) (lCE[4] + 0.5f));
        }
        switch (this.lCL.length) {
            case 1:
                if (this.lCM) {
                    measureChild(this.lCI, lCH + 1073741824, ((int) (lCE[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.lCI, ((int) (lCD[4] + 0.5f)) + 1073741824, ((int) (lCE[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.lCJ, 0, 0);
                measureChild(this.lCK, 0, 0);
                return;
            case 2:
                if (this.lCM) {
                    i3 = ((int) (lCD[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (lCE[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (lCD[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (lCE[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.lCI, i3, i4);
                measureChild(this.lCJ, i3, i4);
                measureChild(this.lCK, 0, 0);
                return;
            case 3:
                if (this.lCM) {
                    int i6 = ((int) (lCD[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (lCE[3] + 0.5f)) + 1073741824;
                    measureChild(this.lCI, ((int) (lCD[2] + 0.5f)) + 1073741824, ((int) (lCE[2] + 0.5f)) + 1073741824);
                    measureChild(this.lCJ, i6, i7);
                    measureChild(this.lCK, i6, i7);
                    return;
                }
                int i8 = ((int) (lCD[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (lCE[4] + 0.5f)) + 1073741824;
                measureChild(this.lCI, i8, i9);
                measureChild(this.lCJ, i8, i9);
                measureChild(this.lCK, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lCL != null && this.lCL.length != 0) {
            switch (this.lCL.length) {
                case 1:
                    if (this.lCM) {
                        int i5 = (int) (lCD[0] + 0.5f);
                        this.lCI.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.lCI.layout(this.mPadding, 0, ((int) (lCD[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.lCJ.layout(0, 0, 0, 0);
                    this.lCK.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.lCM) {
                        int i6 = (int) (lCD[1] + 0.5f);
                        this.lCI.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.lCJ.layout(i6 + this.mPadding + lCG, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (lCD[4] + 0.5f);
                        this.lCI.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.lCJ.layout(this.mPadding + i7 + lCF, 0, (i7 * 2) + this.mPadding + lCF, i4 - i2);
                    }
                    this.lCK.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.lCM) {
                        int i8 = (int) (lCD[2] + 0.5f);
                        int i9 = (int) (lCD[3] + 0.5f);
                        this.lCI.layout(0, 0, i8, i4 - i2);
                        this.lCJ.layout(lCF + i8, 0, i3, i9);
                        this.lCK.layout(i8 + lCF, i9 + lCF, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (lCD[4] + 0.5f);
                    this.lCI.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.lCJ.layout(this.mPadding + i10 + lCF, 0, (i10 * 2) + this.mPadding + lCF, i4 - i2);
                    this.lCK.layout((i10 * 2) + this.mPadding + (lCF * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.lCL != null && this.lCL.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.lCL.length) {
                case 1:
                    drawChild(canvas, this.lCI, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.lCI, drawingTime);
                    drawChild(canvas, this.lCJ, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.lCI, drawingTime);
                    drawChild(canvas, this.lCJ, drawingTime);
                    drawChild(canvas, this.lCK, drawingTime);
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

    private void a(TbImageView tbImageView, final MediaData mediaData) {
        if (tbImageView != null) {
            String picUrl = mediaData.getPicUrl();
            if (mediaData.getType() == 5) {
                picUrl = null;
                tbImageView.setDefaultResource(R.drawable.pic_video);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.view.CommonImageLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.startWebActivity(CommonImageLayout.this.mContext, mediaData.getVideoUrl());
                    }
                });
            } else {
                tbImageView.setClickable(false);
            }
            tbImageView.setTag(picUrl);
            tbImageView.startLoad(picUrl, 13, false);
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
