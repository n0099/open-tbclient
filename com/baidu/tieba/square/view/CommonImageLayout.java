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
    private static float[] niB = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] niC = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int niD = 2;
    private static int niE = 4;
    private static int niF = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView niG;
    public TbImageView niH;
    public TbImageView niI;
    private MediaData[] niJ;
    private boolean niK;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < niB.length; i++) {
                float[] fArr = niB;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = niC;
                fArr2[i] = fArr2[i] * sRatio;
            }
            niD = (int) (niD * sRatio);
            niE = (int) (niE * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.niK = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.niG = new TbImageView(context);
        this.niH = new TbImageView(context);
        this.niI = new TbImageView(context);
        this.niG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.niH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.niI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.niG.setDefaultBg(drawable);
        this.niH.setDefaultBg(drawable);
        this.niI.setDefaultBg(drawable);
        addView(this.niG);
        addView(this.niH);
        addView(this.niI);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.niK = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.niJ = mediaDataArr;
        if (this.niJ == null || this.niJ.length <= 0) {
            if (this.niG != null) {
                this.niG.setTag(null);
            }
            if (this.niH != null) {
                this.niH.setTag(null);
            }
            if (this.niI != null) {
                this.niI.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.niJ.length;
        if (length == 1) {
            a(this.niG, this.niJ[0]);
            if (this.niH != null) {
                this.niH.setTag(null);
                this.niH.setClickable(false);
            }
            if (this.niI != null) {
                this.niI.setTag(null);
                this.niI.setClickable(false);
            }
        } else if (length == 2) {
            a(this.niG, this.niJ[0]);
            a(this.niH, this.niJ[1]);
            if (this.niI != null) {
                this.niI.setTag(null);
                this.niI.setClickable(false);
            }
        } else if (length == 3) {
            a(this.niG, this.niJ[0]);
            a(this.niH, this.niJ[1]);
            a(this.niI, this.niJ[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (niF == 0) {
            niF = i5;
        }
        if (this.niJ == null || this.niJ.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.niK) {
            setMeasuredDimension(niF, (int) (niC[this.niJ.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(niF, (int) (niC[4] + 0.5f));
        }
        switch (this.niJ.length) {
            case 1:
                if (this.niK) {
                    measureChild(this.niG, niF + 1073741824, ((int) (niC[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.niG, ((int) (niB[4] + 0.5f)) + 1073741824, ((int) (niC[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.niH, 0, 0);
                measureChild(this.niI, 0, 0);
                return;
            case 2:
                if (this.niK) {
                    i3 = ((int) (niB[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (niC[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (niB[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (niC[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.niG, i3, i4);
                measureChild(this.niH, i3, i4);
                measureChild(this.niI, 0, 0);
                return;
            case 3:
                if (this.niK) {
                    int i6 = ((int) (niB[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (niC[3] + 0.5f)) + 1073741824;
                    measureChild(this.niG, ((int) (niB[2] + 0.5f)) + 1073741824, ((int) (niC[2] + 0.5f)) + 1073741824);
                    measureChild(this.niH, i6, i7);
                    measureChild(this.niI, i6, i7);
                    return;
                }
                int i8 = ((int) (niB[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (niC[4] + 0.5f)) + 1073741824;
                measureChild(this.niG, i8, i9);
                measureChild(this.niH, i8, i9);
                measureChild(this.niI, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.niJ != null && this.niJ.length != 0) {
            switch (this.niJ.length) {
                case 1:
                    if (this.niK) {
                        int i5 = (int) (niB[0] + 0.5f);
                        this.niG.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.niG.layout(this.mPadding, 0, ((int) (niB[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.niH.layout(0, 0, 0, 0);
                    this.niI.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.niK) {
                        int i6 = (int) (niB[1] + 0.5f);
                        this.niG.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.niH.layout(i6 + this.mPadding + niE, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (niB[4] + 0.5f);
                        this.niG.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.niH.layout(this.mPadding + i7 + niD, 0, (i7 * 2) + this.mPadding + niD, i4 - i2);
                    }
                    this.niI.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.niK) {
                        int i8 = (int) (niB[2] + 0.5f);
                        int i9 = (int) (niB[3] + 0.5f);
                        this.niG.layout(0, 0, i8, i4 - i2);
                        this.niH.layout(niD + i8, 0, i3, i9);
                        this.niI.layout(i8 + niD, i9 + niD, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (niB[4] + 0.5f);
                    this.niG.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.niH.layout(this.mPadding + i10 + niD, 0, (i10 * 2) + this.mPadding + niD, i4 - i2);
                    this.niI.layout((i10 * 2) + this.mPadding + (niD * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.niJ != null && this.niJ.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.niJ.length) {
                case 1:
                    drawChild(canvas, this.niG, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.niG, drawingTime);
                    drawChild(canvas, this.niH, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.niG, drawingTime);
                    drawChild(canvas, this.niH, drawingTime);
                    drawChild(canvas, this.niI, drawingTime);
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
