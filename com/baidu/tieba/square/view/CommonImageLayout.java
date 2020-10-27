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
/* loaded from: classes23.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] mND = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mNE = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mNF = 2;
    private static int mNG = 4;
    private static int mNH = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    public TbImageView mNI;
    public TbImageView mNJ;
    public TbImageView mNK;
    private MediaData[] mNL;
    private boolean mNM;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mND.length; i++) {
                float[] fArr = mND;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mNE;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mNF = (int) (mNF * sRatio);
            mNG = (int) (mNG * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mNM = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mNI = new TbImageView(context);
        this.mNJ = new TbImageView(context);
        this.mNK = new TbImageView(context);
        this.mNI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mNI.setDefaultBg(drawable);
        this.mNJ.setDefaultBg(drawable);
        this.mNK.setDefaultBg(drawable);
        addView(this.mNI);
        addView(this.mNJ);
        addView(this.mNK);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mNM = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mNL = mediaDataArr;
        if (this.mNL == null || this.mNL.length <= 0) {
            if (this.mNI != null) {
                this.mNI.setTag(null);
            }
            if (this.mNJ != null) {
                this.mNJ.setTag(null);
            }
            if (this.mNK != null) {
                this.mNK.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mNL.length;
        if (length == 1) {
            a(this.mNI, this.mNL[0]);
            if (this.mNJ != null) {
                this.mNJ.setTag(null);
                this.mNJ.setClickable(false);
            }
            if (this.mNK != null) {
                this.mNK.setTag(null);
                this.mNK.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mNI, this.mNL[0]);
            a(this.mNJ, this.mNL[1]);
            if (this.mNK != null) {
                this.mNK.setTag(null);
                this.mNK.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mNI, this.mNL[0]);
            a(this.mNJ, this.mNL[1]);
            a(this.mNK, this.mNL[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mNH == 0) {
            mNH = i5;
        }
        if (this.mNL == null || this.mNL.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mNM) {
            setMeasuredDimension(mNH, (int) (mNE[this.mNL.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mNH, (int) (mNE[4] + 0.5f));
        }
        switch (this.mNL.length) {
            case 1:
                if (this.mNM) {
                    measureChild(this.mNI, mNH + 1073741824, ((int) (mNE[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mNI, ((int) (mND[4] + 0.5f)) + 1073741824, ((int) (mNE[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mNJ, 0, 0);
                measureChild(this.mNK, 0, 0);
                return;
            case 2:
                if (this.mNM) {
                    i3 = ((int) (mND[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mNE[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mND[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mNE[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mNI, i3, i4);
                measureChild(this.mNJ, i3, i4);
                measureChild(this.mNK, 0, 0);
                return;
            case 3:
                if (this.mNM) {
                    int i6 = ((int) (mND[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mNE[3] + 0.5f)) + 1073741824;
                    measureChild(this.mNI, ((int) (mND[2] + 0.5f)) + 1073741824, ((int) (mNE[2] + 0.5f)) + 1073741824);
                    measureChild(this.mNJ, i6, i7);
                    measureChild(this.mNK, i6, i7);
                    return;
                }
                int i8 = ((int) (mND[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mNE[4] + 0.5f)) + 1073741824;
                measureChild(this.mNI, i8, i9);
                measureChild(this.mNJ, i8, i9);
                measureChild(this.mNK, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mNL != null && this.mNL.length != 0) {
            switch (this.mNL.length) {
                case 1:
                    if (this.mNM) {
                        int i5 = (int) (mND[0] + 0.5f);
                        this.mNI.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mNI.layout(this.mPadding, 0, ((int) (mND[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mNJ.layout(0, 0, 0, 0);
                    this.mNK.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mNM) {
                        int i6 = (int) (mND[1] + 0.5f);
                        this.mNI.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mNJ.layout(i6 + this.mPadding + mNG, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mND[4] + 0.5f);
                        this.mNI.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mNJ.layout(this.mPadding + i7 + mNF, 0, (i7 * 2) + this.mPadding + mNF, i4 - i2);
                    }
                    this.mNK.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mNM) {
                        int i8 = (int) (mND[2] + 0.5f);
                        int i9 = (int) (mND[3] + 0.5f);
                        this.mNI.layout(0, 0, i8, i4 - i2);
                        this.mNJ.layout(mNF + i8, 0, i3, i9);
                        this.mNK.layout(i8 + mNF, i9 + mNF, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mND[4] + 0.5f);
                    this.mNI.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mNJ.layout(this.mPadding + i10 + mNF, 0, (i10 * 2) + this.mPadding + mNF, i4 - i2);
                    this.mNK.layout((i10 * 2) + this.mPadding + (mNF * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mNL != null && this.mNL.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mNL.length) {
                case 1:
                    drawChild(canvas, this.mNI, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mNI, drawingTime);
                    drawChild(canvas, this.mNJ, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mNI, drawingTime);
                    drawChild(canvas, this.mNJ, drawingTime);
                    drawChild(canvas, this.mNK, drawingTime);
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
