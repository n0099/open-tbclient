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
/* loaded from: classes10.dex */
public class CommonImageLayout extends ViewGroup {
    public TbImageView lhE;
    public TbImageView lhF;
    public TbImageView lhG;
    private MediaData[] lhH;
    private boolean lhI;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] lhz = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] lhA = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int lhB = 2;
    private static int lhC = 4;
    private static int lhD = 0;
    public static float sRatio = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < lhz.length; i++) {
                float[] fArr = lhz;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = lhA;
                fArr2[i] = fArr2[i] * sRatio;
            }
            lhB = (int) (lhB * sRatio);
            lhC = (int) (lhC * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.lhI = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.lhE = new TbImageView(context);
        this.lhF = new TbImageView(context);
        this.lhG = new TbImageView(context);
        this.lhE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lhF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lhG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lhE.setDefaultBg(drawable);
        this.lhF.setDefaultBg(drawable);
        this.lhG.setDefaultBg(drawable);
        addView(this.lhE);
        addView(this.lhF);
        addView(this.lhG);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.lhI = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.lhH = mediaDataArr;
        if (this.lhH == null || this.lhH.length <= 0) {
            if (this.lhE != null) {
                this.lhE.setTag(null);
            }
            if (this.lhF != null) {
                this.lhF.setTag(null);
            }
            if (this.lhG != null) {
                this.lhG.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.lhH.length;
        if (length == 1) {
            a(this.lhE, this.lhH[0]);
            if (this.lhF != null) {
                this.lhF.setTag(null);
                this.lhF.setClickable(false);
            }
            if (this.lhG != null) {
                this.lhG.setTag(null);
                this.lhG.setClickable(false);
            }
        } else if (length == 2) {
            a(this.lhE, this.lhH[0]);
            a(this.lhF, this.lhH[1]);
            if (this.lhG != null) {
                this.lhG.setTag(null);
                this.lhG.setClickable(false);
            }
        } else if (length == 3) {
            a(this.lhE, this.lhH[0]);
            a(this.lhF, this.lhH[1]);
            a(this.lhG, this.lhH[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (lhD == 0) {
            lhD = i5;
        }
        if (this.lhH == null || this.lhH.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.lhI) {
            setMeasuredDimension(lhD, (int) (lhA[this.lhH.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(lhD, (int) (lhA[4] + 0.5f));
        }
        switch (this.lhH.length) {
            case 1:
                if (this.lhI) {
                    measureChild(this.lhE, lhD + 1073741824, ((int) (lhA[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.lhE, ((int) (lhz[4] + 0.5f)) + 1073741824, ((int) (lhA[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.lhF, 0, 0);
                measureChild(this.lhG, 0, 0);
                return;
            case 2:
                if (this.lhI) {
                    i3 = ((int) (lhz[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (lhA[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (lhz[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (lhA[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.lhE, i3, i4);
                measureChild(this.lhF, i3, i4);
                measureChild(this.lhG, 0, 0);
                return;
            case 3:
                if (this.lhI) {
                    int i6 = ((int) (lhz[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (lhA[3] + 0.5f)) + 1073741824;
                    measureChild(this.lhE, ((int) (lhz[2] + 0.5f)) + 1073741824, ((int) (lhA[2] + 0.5f)) + 1073741824);
                    measureChild(this.lhF, i6, i7);
                    measureChild(this.lhG, i6, i7);
                    return;
                }
                int i8 = ((int) (lhz[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (lhA[4] + 0.5f)) + 1073741824;
                measureChild(this.lhE, i8, i9);
                measureChild(this.lhF, i8, i9);
                measureChild(this.lhG, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lhH != null && this.lhH.length != 0) {
            switch (this.lhH.length) {
                case 1:
                    if (this.lhI) {
                        int i5 = (int) (lhz[0] + 0.5f);
                        this.lhE.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.lhE.layout(this.mPadding, 0, ((int) (lhz[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.lhF.layout(0, 0, 0, 0);
                    this.lhG.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.lhI) {
                        int i6 = (int) (lhz[1] + 0.5f);
                        this.lhE.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.lhF.layout(i6 + this.mPadding + lhC, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (lhz[4] + 0.5f);
                        this.lhE.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.lhF.layout(this.mPadding + i7 + lhB, 0, (i7 * 2) + this.mPadding + lhB, i4 - i2);
                    }
                    this.lhG.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.lhI) {
                        int i8 = (int) (lhz[2] + 0.5f);
                        int i9 = (int) (lhz[3] + 0.5f);
                        this.lhE.layout(0, 0, i8, i4 - i2);
                        this.lhF.layout(lhB + i8, 0, i3, i9);
                        this.lhG.layout(i8 + lhB, i9 + lhB, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (lhz[4] + 0.5f);
                    this.lhE.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.lhF.layout(this.mPadding + i10 + lhB, 0, (i10 * 2) + this.mPadding + lhB, i4 - i2);
                    this.lhG.layout((i10 * 2) + this.mPadding + (lhB * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.lhH != null && this.lhH.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.lhH.length) {
                case 1:
                    drawChild(canvas, this.lhE, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.lhE, drawingTime);
                    drawChild(canvas, this.lhF, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.lhE, drawingTime);
                    drawChild(canvas, this.lhF, drawingTime);
                    drawChild(canvas, this.lhG, drawingTime);
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
