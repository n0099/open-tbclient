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
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView niE;
    public TbImageView niF;
    public TbImageView niG;
    private MediaData[] niH;
    private boolean niI;
    private static float[] niz = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] niA = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int niB = 2;
    private static int niC = 4;
    private static int niD = 0;
    public static float sRatio = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < niz.length; i++) {
                float[] fArr = niz;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = niA;
                fArr2[i] = fArr2[i] * sRatio;
            }
            niB = (int) (niB * sRatio);
            niC = (int) (niC * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.niI = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.niE = new TbImageView(context);
        this.niF = new TbImageView(context);
        this.niG = new TbImageView(context);
        this.niE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.niF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.niG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.niE.setDefaultBg(drawable);
        this.niF.setDefaultBg(drawable);
        this.niG.setDefaultBg(drawable);
        addView(this.niE);
        addView(this.niF);
        addView(this.niG);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.niI = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.niH = mediaDataArr;
        if (this.niH == null || this.niH.length <= 0) {
            if (this.niE != null) {
                this.niE.setTag(null);
            }
            if (this.niF != null) {
                this.niF.setTag(null);
            }
            if (this.niG != null) {
                this.niG.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.niH.length;
        if (length == 1) {
            a(this.niE, this.niH[0]);
            if (this.niF != null) {
                this.niF.setTag(null);
                this.niF.setClickable(false);
            }
            if (this.niG != null) {
                this.niG.setTag(null);
                this.niG.setClickable(false);
            }
        } else if (length == 2) {
            a(this.niE, this.niH[0]);
            a(this.niF, this.niH[1]);
            if (this.niG != null) {
                this.niG.setTag(null);
                this.niG.setClickable(false);
            }
        } else if (length == 3) {
            a(this.niE, this.niH[0]);
            a(this.niF, this.niH[1]);
            a(this.niG, this.niH[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (niD == 0) {
            niD = i5;
        }
        if (this.niH == null || this.niH.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.niI) {
            setMeasuredDimension(niD, (int) (niA[this.niH.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(niD, (int) (niA[4] + 0.5f));
        }
        switch (this.niH.length) {
            case 1:
                if (this.niI) {
                    measureChild(this.niE, niD + 1073741824, ((int) (niA[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.niE, ((int) (niz[4] + 0.5f)) + 1073741824, ((int) (niA[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.niF, 0, 0);
                measureChild(this.niG, 0, 0);
                return;
            case 2:
                if (this.niI) {
                    i3 = ((int) (niz[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (niA[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (niz[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (niA[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.niE, i3, i4);
                measureChild(this.niF, i3, i4);
                measureChild(this.niG, 0, 0);
                return;
            case 3:
                if (this.niI) {
                    int i6 = ((int) (niz[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (niA[3] + 0.5f)) + 1073741824;
                    measureChild(this.niE, ((int) (niz[2] + 0.5f)) + 1073741824, ((int) (niA[2] + 0.5f)) + 1073741824);
                    measureChild(this.niF, i6, i7);
                    measureChild(this.niG, i6, i7);
                    return;
                }
                int i8 = ((int) (niz[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (niA[4] + 0.5f)) + 1073741824;
                measureChild(this.niE, i8, i9);
                measureChild(this.niF, i8, i9);
                measureChild(this.niG, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.niH != null && this.niH.length != 0) {
            switch (this.niH.length) {
                case 1:
                    if (this.niI) {
                        int i5 = (int) (niz[0] + 0.5f);
                        this.niE.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.niE.layout(this.mPadding, 0, ((int) (niz[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.niF.layout(0, 0, 0, 0);
                    this.niG.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.niI) {
                        int i6 = (int) (niz[1] + 0.5f);
                        this.niE.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.niF.layout(i6 + this.mPadding + niC, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (niz[4] + 0.5f);
                        this.niE.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.niF.layout(this.mPadding + i7 + niB, 0, (i7 * 2) + this.mPadding + niB, i4 - i2);
                    }
                    this.niG.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.niI) {
                        int i8 = (int) (niz[2] + 0.5f);
                        int i9 = (int) (niz[3] + 0.5f);
                        this.niE.layout(0, 0, i8, i4 - i2);
                        this.niF.layout(niB + i8, 0, i3, i9);
                        this.niG.layout(i8 + niB, i9 + niB, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (niz[4] + 0.5f);
                    this.niE.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.niF.layout(this.mPadding + i10 + niB, 0, (i10 * 2) + this.mPadding + niB, i4 - i2);
                    this.niG.layout((i10 * 2) + this.mPadding + (niB * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.niH != null && this.niH.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.niH.length) {
                case 1:
                    drawChild(canvas, this.niE, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.niE, drawingTime);
                    drawChild(canvas, this.niF, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.niE, drawingTime);
                    drawChild(canvas, this.niF, drawingTime);
                    drawChild(canvas, this.niG, drawingTime);
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
