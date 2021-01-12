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
/* loaded from: classes7.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] njB = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] njC = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int njD = 2;
    private static int njE = 4;
    private static int njF = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView njG;
    public TbImageView njH;
    public TbImageView njI;
    private MediaData[] njJ;
    private boolean njK;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < njB.length; i++) {
                float[] fArr = njB;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = njC;
                fArr2[i] = fArr2[i] * sRatio;
            }
            njD = (int) (njD * sRatio);
            njE = (int) (njE * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.njK = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ao.getDrawable(R.color.common_color_10220);
        this.njG = new TbImageView(context);
        this.njH = new TbImageView(context);
        this.njI = new TbImageView(context);
        this.njG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.njH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.njI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.njG.setDefaultBg(drawable);
        this.njH.setDefaultBg(drawable);
        this.njI.setDefaultBg(drawable);
        addView(this.njG);
        addView(this.njH);
        addView(this.njI);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.njK = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.njJ = mediaDataArr;
        if (this.njJ == null || this.njJ.length <= 0) {
            if (this.njG != null) {
                this.njG.setTag(null);
            }
            if (this.njH != null) {
                this.njH.setTag(null);
            }
            if (this.njI != null) {
                this.njI.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.njJ.length;
        if (length == 1) {
            a(this.njG, this.njJ[0]);
            if (this.njH != null) {
                this.njH.setTag(null);
                this.njH.setClickable(false);
            }
            if (this.njI != null) {
                this.njI.setTag(null);
                this.njI.setClickable(false);
            }
        } else if (length == 2) {
            a(this.njG, this.njJ[0]);
            a(this.njH, this.njJ[1]);
            if (this.njI != null) {
                this.njI.setTag(null);
                this.njI.setClickable(false);
            }
        } else if (length == 3) {
            a(this.njG, this.njJ[0]);
            a(this.njH, this.njJ[1]);
            a(this.njI, this.njJ[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (njF == 0) {
            njF = i5;
        }
        if (this.njJ == null || this.njJ.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.njK) {
            setMeasuredDimension(njF, (int) (njC[this.njJ.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(njF, (int) (njC[4] + 0.5f));
        }
        switch (this.njJ.length) {
            case 1:
                if (this.njK) {
                    measureChild(this.njG, njF + 1073741824, ((int) (njC[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.njG, ((int) (njB[4] + 0.5f)) + 1073741824, ((int) (njC[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.njH, 0, 0);
                measureChild(this.njI, 0, 0);
                return;
            case 2:
                if (this.njK) {
                    i3 = ((int) (njB[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (njC[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (njB[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (njC[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.njG, i3, i4);
                measureChild(this.njH, i3, i4);
                measureChild(this.njI, 0, 0);
                return;
            case 3:
                if (this.njK) {
                    int i6 = ((int) (njB[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (njC[3] + 0.5f)) + 1073741824;
                    measureChild(this.njG, ((int) (njB[2] + 0.5f)) + 1073741824, ((int) (njC[2] + 0.5f)) + 1073741824);
                    measureChild(this.njH, i6, i7);
                    measureChild(this.njI, i6, i7);
                    return;
                }
                int i8 = ((int) (njB[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (njC[4] + 0.5f)) + 1073741824;
                measureChild(this.njG, i8, i9);
                measureChild(this.njH, i8, i9);
                measureChild(this.njI, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.njJ != null && this.njJ.length != 0) {
            switch (this.njJ.length) {
                case 1:
                    if (this.njK) {
                        int i5 = (int) (njB[0] + 0.5f);
                        this.njG.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.njG.layout(this.mPadding, 0, ((int) (njB[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.njH.layout(0, 0, 0, 0);
                    this.njI.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.njK) {
                        int i6 = (int) (njB[1] + 0.5f);
                        this.njG.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.njH.layout(i6 + this.mPadding + njE, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (njB[4] + 0.5f);
                        this.njG.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.njH.layout(this.mPadding + i7 + njD, 0, (i7 * 2) + this.mPadding + njD, i4 - i2);
                    }
                    this.njI.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.njK) {
                        int i8 = (int) (njB[2] + 0.5f);
                        int i9 = (int) (njB[3] + 0.5f);
                        this.njG.layout(0, 0, i8, i4 - i2);
                        this.njH.layout(njD + i8, 0, i3, i9);
                        this.njI.layout(i8 + njD, i9 + njD, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (njB[4] + 0.5f);
                    this.njG.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.njH.layout(this.mPadding + i10 + njD, 0, (i10 * 2) + this.mPadding + njD, i4 - i2);
                    this.njI.layout((i10 * 2) + this.mPadding + (njD * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.njJ != null && this.njJ.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.njJ.length) {
                case 1:
                    drawChild(canvas, this.njG, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.njG, drawingTime);
                    drawChild(canvas, this.njH, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.njG, drawingTime);
                    drawChild(canvas, this.njH, drawingTime);
                    drawChild(canvas, this.njI, drawingTime);
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
