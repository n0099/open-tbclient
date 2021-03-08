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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] nvO = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] nvP = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int nvQ = 2;
    private static int nvR = 4;
    private static int nvS = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView nvT;
    public TbImageView nvU;
    public TbImageView nvV;
    private MediaData[] nvW;
    private boolean nvX;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < nvO.length; i++) {
                float[] fArr = nvO;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = nvP;
                fArr2[i] = fArr2[i] * sRatio;
            }
            nvQ = (int) (nvQ * sRatio);
            nvR = (int) (nvR * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.nvX = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.nvT = new TbImageView(context);
        this.nvU = new TbImageView(context);
        this.nvV = new TbImageView(context);
        this.nvT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nvU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nvV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nvT.setDefaultBg(drawable);
        this.nvU.setDefaultBg(drawable);
        this.nvV.setDefaultBg(drawable);
        addView(this.nvT);
        addView(this.nvU);
        addView(this.nvV);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.nvX = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.nvW = mediaDataArr;
        if (this.nvW == null || this.nvW.length <= 0) {
            if (this.nvT != null) {
                this.nvT.setTag(null);
            }
            if (this.nvU != null) {
                this.nvU.setTag(null);
            }
            if (this.nvV != null) {
                this.nvV.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.nvW.length;
        if (length == 1) {
            a(this.nvT, this.nvW[0]);
            if (this.nvU != null) {
                this.nvU.setTag(null);
                this.nvU.setClickable(false);
            }
            if (this.nvV != null) {
                this.nvV.setTag(null);
                this.nvV.setClickable(false);
            }
        } else if (length == 2) {
            a(this.nvT, this.nvW[0]);
            a(this.nvU, this.nvW[1]);
            if (this.nvV != null) {
                this.nvV.setTag(null);
                this.nvV.setClickable(false);
            }
        } else if (length == 3) {
            a(this.nvT, this.nvW[0]);
            a(this.nvU, this.nvW[1]);
            a(this.nvV, this.nvW[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (nvS == 0) {
            nvS = i5;
        }
        if (this.nvW == null || this.nvW.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.nvX) {
            setMeasuredDimension(nvS, (int) (nvP[this.nvW.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(nvS, (int) (nvP[4] + 0.5f));
        }
        switch (this.nvW.length) {
            case 1:
                if (this.nvX) {
                    measureChild(this.nvT, nvS + 1073741824, ((int) (nvP[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.nvT, ((int) (nvO[4] + 0.5f)) + 1073741824, ((int) (nvP[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.nvU, 0, 0);
                measureChild(this.nvV, 0, 0);
                return;
            case 2:
                if (this.nvX) {
                    i3 = ((int) (nvO[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (nvP[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (nvO[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (nvP[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.nvT, i3, i4);
                measureChild(this.nvU, i3, i4);
                measureChild(this.nvV, 0, 0);
                return;
            case 3:
                if (this.nvX) {
                    int i6 = ((int) (nvO[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (nvP[3] + 0.5f)) + 1073741824;
                    measureChild(this.nvT, ((int) (nvO[2] + 0.5f)) + 1073741824, ((int) (nvP[2] + 0.5f)) + 1073741824);
                    measureChild(this.nvU, i6, i7);
                    measureChild(this.nvV, i6, i7);
                    return;
                }
                int i8 = ((int) (nvO[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (nvP[4] + 0.5f)) + 1073741824;
                measureChild(this.nvT, i8, i9);
                measureChild(this.nvU, i8, i9);
                measureChild(this.nvV, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.nvW != null && this.nvW.length != 0) {
            switch (this.nvW.length) {
                case 1:
                    if (this.nvX) {
                        int i5 = (int) (nvO[0] + 0.5f);
                        this.nvT.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.nvT.layout(this.mPadding, 0, ((int) (nvO[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.nvU.layout(0, 0, 0, 0);
                    this.nvV.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.nvX) {
                        int i6 = (int) (nvO[1] + 0.5f);
                        this.nvT.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.nvU.layout(i6 + this.mPadding + nvR, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (nvO[4] + 0.5f);
                        this.nvT.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.nvU.layout(this.mPadding + i7 + nvQ, 0, (i7 * 2) + this.mPadding + nvQ, i4 - i2);
                    }
                    this.nvV.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.nvX) {
                        int i8 = (int) (nvO[2] + 0.5f);
                        int i9 = (int) (nvO[3] + 0.5f);
                        this.nvT.layout(0, 0, i8, i4 - i2);
                        this.nvU.layout(nvQ + i8, 0, i3, i9);
                        this.nvV.layout(i8 + nvQ, i9 + nvQ, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (nvO[4] + 0.5f);
                    this.nvT.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.nvU.layout(this.mPadding + i10 + nvQ, 0, (i10 * 2) + this.mPadding + nvQ, i4 - i2);
                    this.nvV.layout((i10 * 2) + this.mPadding + (nvQ * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.nvW != null && this.nvW.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.nvW.length) {
                case 1:
                    drawChild(canvas, this.nvT, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.nvT, drawingTime);
                    drawChild(canvas, this.nvU, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.nvT, drawingTime);
                    drawChild(canvas, this.nvU, drawingTime);
                    drawChild(canvas, this.nvV, drawingTime);
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
