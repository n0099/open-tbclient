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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] jeC = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] jeD = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int jeE = 2;
    private static int jeF = 4;
    private static int jeG = 0;
    public static float sRatio = -1.0f;
    public TbImageView jeH;
    public TbImageView jeI;
    public TbImageView jeJ;
    private MediaData[] jeK;
    private boolean jeL;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < jeC.length; i++) {
                float[] fArr = jeC;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = jeD;
                fArr2[i] = fArr2[i] * sRatio;
            }
            jeE = (int) (jeE * sRatio);
            jeF = (int) (jeF * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.jeL = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.jeH = new TbImageView(context);
        this.jeI = new TbImageView(context);
        this.jeJ = new TbImageView(context);
        this.jeH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jeI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jeJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jeH.setDefaultBg(drawable);
        this.jeI.setDefaultBg(drawable);
        this.jeJ.setDefaultBg(drawable);
        addView(this.jeH);
        addView(this.jeI);
        addView(this.jeJ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.jeL = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.jeK = mediaDataArr;
        if (this.jeK == null || this.jeK.length <= 0) {
            if (this.jeH != null) {
                this.jeH.setTag(null);
            }
            if (this.jeI != null) {
                this.jeI.setTag(null);
            }
            if (this.jeJ != null) {
                this.jeJ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.jeK.length;
        if (length == 1) {
            a(this.jeH, this.jeK[0]);
            if (this.jeI != null) {
                this.jeI.setTag(null);
                this.jeI.setClickable(false);
            }
            if (this.jeJ != null) {
                this.jeJ.setTag(null);
                this.jeJ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.jeH, this.jeK[0]);
            a(this.jeI, this.jeK[1]);
            if (this.jeJ != null) {
                this.jeJ.setTag(null);
                this.jeJ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.jeH, this.jeK[0]);
            a(this.jeI, this.jeK[1]);
            a(this.jeJ, this.jeK[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (jeG == 0) {
            jeG = i5;
        }
        if (this.jeK == null || this.jeK.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.jeL) {
            setMeasuredDimension(jeG, (int) (jeD[this.jeK.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(jeG, (int) (jeD[4] + 0.5f));
        }
        switch (this.jeK.length) {
            case 1:
                if (this.jeL) {
                    measureChild(this.jeH, jeG + 1073741824, ((int) (jeD[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.jeH, ((int) (jeC[4] + 0.5f)) + 1073741824, ((int) (jeD[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.jeI, 0, 0);
                measureChild(this.jeJ, 0, 0);
                return;
            case 2:
                if (this.jeL) {
                    i3 = ((int) (jeC[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (jeD[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (jeC[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (jeD[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.jeH, i3, i4);
                measureChild(this.jeI, i3, i4);
                measureChild(this.jeJ, 0, 0);
                return;
            case 3:
                if (this.jeL) {
                    int i6 = ((int) (jeC[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (jeD[3] + 0.5f)) + 1073741824;
                    measureChild(this.jeH, ((int) (jeC[2] + 0.5f)) + 1073741824, ((int) (jeD[2] + 0.5f)) + 1073741824);
                    measureChild(this.jeI, i6, i7);
                    measureChild(this.jeJ, i6, i7);
                    return;
                }
                int i8 = ((int) (jeC[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (jeD[4] + 0.5f)) + 1073741824;
                measureChild(this.jeH, i8, i9);
                measureChild(this.jeI, i8, i9);
                measureChild(this.jeJ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jeK != null && this.jeK.length != 0) {
            switch (this.jeK.length) {
                case 1:
                    if (this.jeL) {
                        int i5 = (int) (jeC[0] + 0.5f);
                        this.jeH.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.jeH.layout(this.mPadding, 0, ((int) (jeC[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.jeI.layout(0, 0, 0, 0);
                    this.jeJ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.jeL) {
                        int i6 = (int) (jeC[1] + 0.5f);
                        this.jeH.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.jeI.layout(i6 + this.mPadding + jeF, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (jeC[4] + 0.5f);
                        this.jeH.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.jeI.layout(this.mPadding + i7 + jeE, 0, (i7 * 2) + this.mPadding + jeE, i4 - i2);
                    }
                    this.jeJ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.jeL) {
                        int i8 = (int) (jeC[2] + 0.5f);
                        int i9 = (int) (jeC[3] + 0.5f);
                        this.jeH.layout(0, 0, i8, i4 - i2);
                        this.jeI.layout(jeE + i8, 0, i3, i9);
                        this.jeJ.layout(i8 + jeE, i9 + jeE, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (jeC[4] + 0.5f);
                    this.jeH.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.jeI.layout(this.mPadding + i10 + jeE, 0, (i10 * 2) + this.mPadding + jeE, i4 - i2);
                    this.jeJ.layout((i10 * 2) + this.mPadding + (jeE * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jeK != null && this.jeK.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.jeK.length) {
                case 1:
                    drawChild(canvas, this.jeH, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.jeH, drawingTime);
                    drawChild(canvas, this.jeI, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.jeH, drawingTime);
                    drawChild(canvas, this.jeI, drawingTime);
                    drawChild(canvas, this.jeJ, drawingTime);
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
