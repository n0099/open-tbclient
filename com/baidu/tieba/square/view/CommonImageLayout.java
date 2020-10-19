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
    private static float[] mAT = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mAU = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mAV = 2;
    private static int mAW = 4;
    private static int mAX = 0;
    public static float sRatio = -1.0f;
    public TbImageView mAY;
    public TbImageView mAZ;
    public TbImageView mBa;
    private MediaData[] mBb;
    private boolean mBc;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mAT.length; i++) {
                float[] fArr = mAT;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mAU;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mAV = (int) (mAV * sRatio);
            mAW = (int) (mAW * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mBc = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mAY = new TbImageView(context);
        this.mAZ = new TbImageView(context);
        this.mBa = new TbImageView(context);
        this.mAY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mAZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mBa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mAY.setDefaultBg(drawable);
        this.mAZ.setDefaultBg(drawable);
        this.mBa.setDefaultBg(drawable);
        addView(this.mAY);
        addView(this.mAZ);
        addView(this.mBa);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mBc = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mBb = mediaDataArr;
        if (this.mBb == null || this.mBb.length <= 0) {
            if (this.mAY != null) {
                this.mAY.setTag(null);
            }
            if (this.mAZ != null) {
                this.mAZ.setTag(null);
            }
            if (this.mBa != null) {
                this.mBa.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mBb.length;
        if (length == 1) {
            a(this.mAY, this.mBb[0]);
            if (this.mAZ != null) {
                this.mAZ.setTag(null);
                this.mAZ.setClickable(false);
            }
            if (this.mBa != null) {
                this.mBa.setTag(null);
                this.mBa.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mAY, this.mBb[0]);
            a(this.mAZ, this.mBb[1]);
            if (this.mBa != null) {
                this.mBa.setTag(null);
                this.mBa.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mAY, this.mBb[0]);
            a(this.mAZ, this.mBb[1]);
            a(this.mBa, this.mBb[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mAX == 0) {
            mAX = i5;
        }
        if (this.mBb == null || this.mBb.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mBc) {
            setMeasuredDimension(mAX, (int) (mAU[this.mBb.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mAX, (int) (mAU[4] + 0.5f));
        }
        switch (this.mBb.length) {
            case 1:
                if (this.mBc) {
                    measureChild(this.mAY, mAX + 1073741824, ((int) (mAU[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mAY, ((int) (mAT[4] + 0.5f)) + 1073741824, ((int) (mAU[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mAZ, 0, 0);
                measureChild(this.mBa, 0, 0);
                return;
            case 2:
                if (this.mBc) {
                    i3 = ((int) (mAT[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mAU[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mAT[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mAU[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mAY, i3, i4);
                measureChild(this.mAZ, i3, i4);
                measureChild(this.mBa, 0, 0);
                return;
            case 3:
                if (this.mBc) {
                    int i6 = ((int) (mAT[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mAU[3] + 0.5f)) + 1073741824;
                    measureChild(this.mAY, ((int) (mAT[2] + 0.5f)) + 1073741824, ((int) (mAU[2] + 0.5f)) + 1073741824);
                    measureChild(this.mAZ, i6, i7);
                    measureChild(this.mBa, i6, i7);
                    return;
                }
                int i8 = ((int) (mAT[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mAU[4] + 0.5f)) + 1073741824;
                measureChild(this.mAY, i8, i9);
                measureChild(this.mAZ, i8, i9);
                measureChild(this.mBa, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mBb != null && this.mBb.length != 0) {
            switch (this.mBb.length) {
                case 1:
                    if (this.mBc) {
                        int i5 = (int) (mAT[0] + 0.5f);
                        this.mAY.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mAY.layout(this.mPadding, 0, ((int) (mAT[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mAZ.layout(0, 0, 0, 0);
                    this.mBa.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mBc) {
                        int i6 = (int) (mAT[1] + 0.5f);
                        this.mAY.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mAZ.layout(i6 + this.mPadding + mAW, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mAT[4] + 0.5f);
                        this.mAY.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mAZ.layout(this.mPadding + i7 + mAV, 0, (i7 * 2) + this.mPadding + mAV, i4 - i2);
                    }
                    this.mBa.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mBc) {
                        int i8 = (int) (mAT[2] + 0.5f);
                        int i9 = (int) (mAT[3] + 0.5f);
                        this.mAY.layout(0, 0, i8, i4 - i2);
                        this.mAZ.layout(mAV + i8, 0, i3, i9);
                        this.mBa.layout(i8 + mAV, i9 + mAV, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mAT[4] + 0.5f);
                    this.mAY.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mAZ.layout(this.mPadding + i10 + mAV, 0, (i10 * 2) + this.mPadding + mAV, i4 - i2);
                    this.mBa.layout((i10 * 2) + this.mPadding + (mAV * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mBb != null && this.mBb.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mBb.length) {
                case 1:
                    drawChild(canvas, this.mAY, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mAY, drawingTime);
                    drawChild(canvas, this.mAZ, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mAY, drawingTime);
                    drawChild(canvas, this.mAZ, drawingTime);
                    drawChild(canvas, this.mBa, drawingTime);
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
