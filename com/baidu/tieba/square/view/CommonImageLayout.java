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
    private static float[] lJU = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] lJV = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int lJW = 2;
    private static int lJX = 4;
    private static int lJY = 0;
    public static float sRatio = -1.0f;
    public TbImageView lJZ;
    public TbImageView lKa;
    public TbImageView lKb;
    private MediaData[] lKc;
    private boolean lKd;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < lJU.length; i++) {
                float[] fArr = lJU;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = lJV;
                fArr2[i] = fArr2[i] * sRatio;
            }
            lJW = (int) (lJW * sRatio);
            lJX = (int) (lJX * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.lKd = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ao.getDrawable(R.color.common_color_10220);
        this.lJZ = new TbImageView(context);
        this.lKa = new TbImageView(context);
        this.lKb = new TbImageView(context);
        this.lJZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lKa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lKb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lJZ.setDefaultBg(drawable);
        this.lKa.setDefaultBg(drawable);
        this.lKb.setDefaultBg(drawable);
        addView(this.lJZ);
        addView(this.lKa);
        addView(this.lKb);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.lKd = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.lKc = mediaDataArr;
        if (this.lKc == null || this.lKc.length <= 0) {
            if (this.lJZ != null) {
                this.lJZ.setTag(null);
            }
            if (this.lKa != null) {
                this.lKa.setTag(null);
            }
            if (this.lKb != null) {
                this.lKb.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.lKc.length;
        if (length == 1) {
            a(this.lJZ, this.lKc[0]);
            if (this.lKa != null) {
                this.lKa.setTag(null);
                this.lKa.setClickable(false);
            }
            if (this.lKb != null) {
                this.lKb.setTag(null);
                this.lKb.setClickable(false);
            }
        } else if (length == 2) {
            a(this.lJZ, this.lKc[0]);
            a(this.lKa, this.lKc[1]);
            if (this.lKb != null) {
                this.lKb.setTag(null);
                this.lKb.setClickable(false);
            }
        } else if (length == 3) {
            a(this.lJZ, this.lKc[0]);
            a(this.lKa, this.lKc[1]);
            a(this.lKb, this.lKc[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (lJY == 0) {
            lJY = i5;
        }
        if (this.lKc == null || this.lKc.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.lKd) {
            setMeasuredDimension(lJY, (int) (lJV[this.lKc.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(lJY, (int) (lJV[4] + 0.5f));
        }
        switch (this.lKc.length) {
            case 1:
                if (this.lKd) {
                    measureChild(this.lJZ, lJY + 1073741824, ((int) (lJV[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.lJZ, ((int) (lJU[4] + 0.5f)) + 1073741824, ((int) (lJV[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.lKa, 0, 0);
                measureChild(this.lKb, 0, 0);
                return;
            case 2:
                if (this.lKd) {
                    i3 = ((int) (lJU[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (lJV[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (lJU[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (lJV[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.lJZ, i3, i4);
                measureChild(this.lKa, i3, i4);
                measureChild(this.lKb, 0, 0);
                return;
            case 3:
                if (this.lKd) {
                    int i6 = ((int) (lJU[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (lJV[3] + 0.5f)) + 1073741824;
                    measureChild(this.lJZ, ((int) (lJU[2] + 0.5f)) + 1073741824, ((int) (lJV[2] + 0.5f)) + 1073741824);
                    measureChild(this.lKa, i6, i7);
                    measureChild(this.lKb, i6, i7);
                    return;
                }
                int i8 = ((int) (lJU[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (lJV[4] + 0.5f)) + 1073741824;
                measureChild(this.lJZ, i8, i9);
                measureChild(this.lKa, i8, i9);
                measureChild(this.lKb, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lKc != null && this.lKc.length != 0) {
            switch (this.lKc.length) {
                case 1:
                    if (this.lKd) {
                        int i5 = (int) (lJU[0] + 0.5f);
                        this.lJZ.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.lJZ.layout(this.mPadding, 0, ((int) (lJU[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.lKa.layout(0, 0, 0, 0);
                    this.lKb.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.lKd) {
                        int i6 = (int) (lJU[1] + 0.5f);
                        this.lJZ.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.lKa.layout(i6 + this.mPadding + lJX, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (lJU[4] + 0.5f);
                        this.lJZ.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.lKa.layout(this.mPadding + i7 + lJW, 0, (i7 * 2) + this.mPadding + lJW, i4 - i2);
                    }
                    this.lKb.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.lKd) {
                        int i8 = (int) (lJU[2] + 0.5f);
                        int i9 = (int) (lJU[3] + 0.5f);
                        this.lJZ.layout(0, 0, i8, i4 - i2);
                        this.lKa.layout(lJW + i8, 0, i3, i9);
                        this.lKb.layout(i8 + lJW, i9 + lJW, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (lJU[4] + 0.5f);
                    this.lJZ.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.lKa.layout(this.mPadding + i10 + lJW, 0, (i10 * 2) + this.mPadding + lJW, i4 - i2);
                    this.lKb.layout((i10 * 2) + this.mPadding + (lJW * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.lKc != null && this.lKc.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.lKc.length) {
                case 1:
                    drawChild(canvas, this.lJZ, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.lJZ, drawingTime);
                    drawChild(canvas, this.lKa, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.lJZ, drawingTime);
                    drawChild(canvas, this.lKa, drawingTime);
                    drawChild(canvas, this.lKb, drawingTime);
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
