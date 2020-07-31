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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] lJS = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] lJT = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int lJU = 2;
    private static int lJV = 4;
    private static int lJW = 0;
    public static float sRatio = -1.0f;
    public TbImageView lJX;
    public TbImageView lJY;
    public TbImageView lJZ;
    private MediaData[] lKa;
    private boolean lKb;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < lJS.length; i++) {
                float[] fArr = lJS;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = lJT;
                fArr2[i] = fArr2[i] * sRatio;
            }
            lJU = (int) (lJU * sRatio);
            lJV = (int) (lJV * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.lKb = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ao.getDrawable(R.color.common_color_10220);
        this.lJX = new TbImageView(context);
        this.lJY = new TbImageView(context);
        this.lJZ = new TbImageView(context);
        this.lJX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lJY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lJZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lJX.setDefaultBg(drawable);
        this.lJY.setDefaultBg(drawable);
        this.lJZ.setDefaultBg(drawable);
        addView(this.lJX);
        addView(this.lJY);
        addView(this.lJZ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.lKb = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.lKa = mediaDataArr;
        if (this.lKa == null || this.lKa.length <= 0) {
            if (this.lJX != null) {
                this.lJX.setTag(null);
            }
            if (this.lJY != null) {
                this.lJY.setTag(null);
            }
            if (this.lJZ != null) {
                this.lJZ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.lKa.length;
        if (length == 1) {
            a(this.lJX, this.lKa[0]);
            if (this.lJY != null) {
                this.lJY.setTag(null);
                this.lJY.setClickable(false);
            }
            if (this.lJZ != null) {
                this.lJZ.setTag(null);
                this.lJZ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.lJX, this.lKa[0]);
            a(this.lJY, this.lKa[1]);
            if (this.lJZ != null) {
                this.lJZ.setTag(null);
                this.lJZ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.lJX, this.lKa[0]);
            a(this.lJY, this.lKa[1]);
            a(this.lJZ, this.lKa[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (lJW == 0) {
            lJW = i5;
        }
        if (this.lKa == null || this.lKa.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.lKb) {
            setMeasuredDimension(lJW, (int) (lJT[this.lKa.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(lJW, (int) (lJT[4] + 0.5f));
        }
        switch (this.lKa.length) {
            case 1:
                if (this.lKb) {
                    measureChild(this.lJX, lJW + 1073741824, ((int) (lJT[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.lJX, ((int) (lJS[4] + 0.5f)) + 1073741824, ((int) (lJT[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.lJY, 0, 0);
                measureChild(this.lJZ, 0, 0);
                return;
            case 2:
                if (this.lKb) {
                    i3 = ((int) (lJS[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (lJT[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (lJS[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (lJT[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.lJX, i3, i4);
                measureChild(this.lJY, i3, i4);
                measureChild(this.lJZ, 0, 0);
                return;
            case 3:
                if (this.lKb) {
                    int i6 = ((int) (lJS[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (lJT[3] + 0.5f)) + 1073741824;
                    measureChild(this.lJX, ((int) (lJS[2] + 0.5f)) + 1073741824, ((int) (lJT[2] + 0.5f)) + 1073741824);
                    measureChild(this.lJY, i6, i7);
                    measureChild(this.lJZ, i6, i7);
                    return;
                }
                int i8 = ((int) (lJS[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (lJT[4] + 0.5f)) + 1073741824;
                measureChild(this.lJX, i8, i9);
                measureChild(this.lJY, i8, i9);
                measureChild(this.lJZ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lKa != null && this.lKa.length != 0) {
            switch (this.lKa.length) {
                case 1:
                    if (this.lKb) {
                        int i5 = (int) (lJS[0] + 0.5f);
                        this.lJX.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.lJX.layout(this.mPadding, 0, ((int) (lJS[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.lJY.layout(0, 0, 0, 0);
                    this.lJZ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.lKb) {
                        int i6 = (int) (lJS[1] + 0.5f);
                        this.lJX.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.lJY.layout(i6 + this.mPadding + lJV, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (lJS[4] + 0.5f);
                        this.lJX.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.lJY.layout(this.mPadding + i7 + lJU, 0, (i7 * 2) + this.mPadding + lJU, i4 - i2);
                    }
                    this.lJZ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.lKb) {
                        int i8 = (int) (lJS[2] + 0.5f);
                        int i9 = (int) (lJS[3] + 0.5f);
                        this.lJX.layout(0, 0, i8, i4 - i2);
                        this.lJY.layout(lJU + i8, 0, i3, i9);
                        this.lJZ.layout(i8 + lJU, i9 + lJU, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (lJS[4] + 0.5f);
                    this.lJX.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.lJY.layout(this.mPadding + i10 + lJU, 0, (i10 * 2) + this.mPadding + lJU, i4 - i2);
                    this.lJZ.layout((i10 * 2) + this.mPadding + (lJU * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.lKa != null && this.lKa.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.lKa.length) {
                case 1:
                    drawChild(canvas, this.lJX, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.lJX, drawingTime);
                    drawChild(canvas, this.lJY, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.lJX, drawingTime);
                    drawChild(canvas, this.lJY, drawingTime);
                    drawChild(canvas, this.lJZ, drawingTime);
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
