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
    private static float[] mTG = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mTH = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mTI = 2;
    private static int mTJ = 4;
    private static int mTK = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView mTL;
    public TbImageView mTM;
    public TbImageView mTN;
    private MediaData[] mTO;
    private boolean mTP;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mTG.length; i++) {
                float[] fArr = mTG;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mTH;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mTI = (int) (mTI * sRatio);
            mTJ = (int) (mTJ * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mTP = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mTL = new TbImageView(context);
        this.mTM = new TbImageView(context);
        this.mTN = new TbImageView(context);
        this.mTL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTL.setDefaultBg(drawable);
        this.mTM.setDefaultBg(drawable);
        this.mTN.setDefaultBg(drawable);
        addView(this.mTL);
        addView(this.mTM);
        addView(this.mTN);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mTP = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mTO = mediaDataArr;
        if (this.mTO == null || this.mTO.length <= 0) {
            if (this.mTL != null) {
                this.mTL.setTag(null);
            }
            if (this.mTM != null) {
                this.mTM.setTag(null);
            }
            if (this.mTN != null) {
                this.mTN.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mTO.length;
        if (length == 1) {
            a(this.mTL, this.mTO[0]);
            if (this.mTM != null) {
                this.mTM.setTag(null);
                this.mTM.setClickable(false);
            }
            if (this.mTN != null) {
                this.mTN.setTag(null);
                this.mTN.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mTL, this.mTO[0]);
            a(this.mTM, this.mTO[1]);
            if (this.mTN != null) {
                this.mTN.setTag(null);
                this.mTN.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mTL, this.mTO[0]);
            a(this.mTM, this.mTO[1]);
            a(this.mTN, this.mTO[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mTK == 0) {
            mTK = i5;
        }
        if (this.mTO == null || this.mTO.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mTP) {
            setMeasuredDimension(mTK, (int) (mTH[this.mTO.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mTK, (int) (mTH[4] + 0.5f));
        }
        switch (this.mTO.length) {
            case 1:
                if (this.mTP) {
                    measureChild(this.mTL, mTK + 1073741824, ((int) (mTH[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mTL, ((int) (mTG[4] + 0.5f)) + 1073741824, ((int) (mTH[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mTM, 0, 0);
                measureChild(this.mTN, 0, 0);
                return;
            case 2:
                if (this.mTP) {
                    i3 = ((int) (mTG[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mTH[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mTG[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mTH[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mTL, i3, i4);
                measureChild(this.mTM, i3, i4);
                measureChild(this.mTN, 0, 0);
                return;
            case 3:
                if (this.mTP) {
                    int i6 = ((int) (mTG[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mTH[3] + 0.5f)) + 1073741824;
                    measureChild(this.mTL, ((int) (mTG[2] + 0.5f)) + 1073741824, ((int) (mTH[2] + 0.5f)) + 1073741824);
                    measureChild(this.mTM, i6, i7);
                    measureChild(this.mTN, i6, i7);
                    return;
                }
                int i8 = ((int) (mTG[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mTH[4] + 0.5f)) + 1073741824;
                measureChild(this.mTL, i8, i9);
                measureChild(this.mTM, i8, i9);
                measureChild(this.mTN, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mTO != null && this.mTO.length != 0) {
            switch (this.mTO.length) {
                case 1:
                    if (this.mTP) {
                        int i5 = (int) (mTG[0] + 0.5f);
                        this.mTL.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mTL.layout(this.mPadding, 0, ((int) (mTG[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mTM.layout(0, 0, 0, 0);
                    this.mTN.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mTP) {
                        int i6 = (int) (mTG[1] + 0.5f);
                        this.mTL.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mTM.layout(i6 + this.mPadding + mTJ, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mTG[4] + 0.5f);
                        this.mTL.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mTM.layout(this.mPadding + i7 + mTI, 0, (i7 * 2) + this.mPadding + mTI, i4 - i2);
                    }
                    this.mTN.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mTP) {
                        int i8 = (int) (mTG[2] + 0.5f);
                        int i9 = (int) (mTG[3] + 0.5f);
                        this.mTL.layout(0, 0, i8, i4 - i2);
                        this.mTM.layout(mTI + i8, 0, i3, i9);
                        this.mTN.layout(i8 + mTI, i9 + mTI, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mTG[4] + 0.5f);
                    this.mTL.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mTM.layout(this.mPadding + i10 + mTI, 0, (i10 * 2) + this.mPadding + mTI, i4 - i2);
                    this.mTN.layout((i10 * 2) + this.mPadding + (mTI * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mTO != null && this.mTO.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mTO.length) {
                case 1:
                    drawChild(canvas, this.mTL, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mTL, drawingTime);
                    drawChild(canvas, this.mTM, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mTL, drawingTime);
                    drawChild(canvas, this.mTM, drawingTime);
                    drawChild(canvas, this.mTN, drawingTime);
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
