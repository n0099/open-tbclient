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
    private static float[] kdJ = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kdK = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kdL = 2;
    private static int kdM = 4;
    private static int kdN = 0;
    public static float sRatio = -1.0f;
    public TbImageView kdO;
    public TbImageView kdP;
    public TbImageView kdQ;
    private MediaData[] kdR;
    private boolean kdS;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kdJ.length; i++) {
                float[] fArr = kdJ;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kdK;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kdL = (int) (kdL * sRatio);
            kdM = (int) (kdM * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kdS = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kdO = new TbImageView(context);
        this.kdP = new TbImageView(context);
        this.kdQ = new TbImageView(context);
        this.kdO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdO.setDefaultBg(drawable);
        this.kdP.setDefaultBg(drawable);
        this.kdQ.setDefaultBg(drawable);
        addView(this.kdO);
        addView(this.kdP);
        addView(this.kdQ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kdS = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kdR = mediaDataArr;
        if (this.kdR == null || this.kdR.length <= 0) {
            if (this.kdO != null) {
                this.kdO.setTag(null);
            }
            if (this.kdP != null) {
                this.kdP.setTag(null);
            }
            if (this.kdQ != null) {
                this.kdQ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kdR.length;
        if (length == 1) {
            a(this.kdO, this.kdR[0]);
            if (this.kdP != null) {
                this.kdP.setTag(null);
                this.kdP.setClickable(false);
            }
            if (this.kdQ != null) {
                this.kdQ.setTag(null);
                this.kdQ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kdO, this.kdR[0]);
            a(this.kdP, this.kdR[1]);
            if (this.kdQ != null) {
                this.kdQ.setTag(null);
                this.kdQ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kdO, this.kdR[0]);
            a(this.kdP, this.kdR[1]);
            a(this.kdQ, this.kdR[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kdN == 0) {
            kdN = i5;
        }
        if (this.kdR == null || this.kdR.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kdS) {
            setMeasuredDimension(kdN, (int) (kdK[this.kdR.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kdN, (int) (kdK[4] + 0.5f));
        }
        switch (this.kdR.length) {
            case 1:
                if (this.kdS) {
                    measureChild(this.kdO, kdN + 1073741824, ((int) (kdK[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kdO, ((int) (kdJ[4] + 0.5f)) + 1073741824, ((int) (kdK[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kdP, 0, 0);
                measureChild(this.kdQ, 0, 0);
                return;
            case 2:
                if (this.kdS) {
                    i3 = ((int) (kdJ[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kdK[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kdJ[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kdK[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kdO, i3, i4);
                measureChild(this.kdP, i3, i4);
                measureChild(this.kdQ, 0, 0);
                return;
            case 3:
                if (this.kdS) {
                    int i6 = ((int) (kdJ[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kdK[3] + 0.5f)) + 1073741824;
                    measureChild(this.kdO, ((int) (kdJ[2] + 0.5f)) + 1073741824, ((int) (kdK[2] + 0.5f)) + 1073741824);
                    measureChild(this.kdP, i6, i7);
                    measureChild(this.kdQ, i6, i7);
                    return;
                }
                int i8 = ((int) (kdJ[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kdK[4] + 0.5f)) + 1073741824;
                measureChild(this.kdO, i8, i9);
                measureChild(this.kdP, i8, i9);
                measureChild(this.kdQ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kdR != null && this.kdR.length != 0) {
            switch (this.kdR.length) {
                case 1:
                    if (this.kdS) {
                        int i5 = (int) (kdJ[0] + 0.5f);
                        this.kdO.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kdO.layout(this.mPadding, 0, ((int) (kdJ[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kdP.layout(0, 0, 0, 0);
                    this.kdQ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kdS) {
                        int i6 = (int) (kdJ[1] + 0.5f);
                        this.kdO.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kdP.layout(i6 + this.mPadding + kdM, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kdJ[4] + 0.5f);
                        this.kdO.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kdP.layout(this.mPadding + i7 + kdL, 0, (i7 * 2) + this.mPadding + kdL, i4 - i2);
                    }
                    this.kdQ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kdS) {
                        int i8 = (int) (kdJ[2] + 0.5f);
                        int i9 = (int) (kdJ[3] + 0.5f);
                        this.kdO.layout(0, 0, i8, i4 - i2);
                        this.kdP.layout(kdL + i8, 0, i3, i9);
                        this.kdQ.layout(i8 + kdL, i9 + kdL, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kdJ[4] + 0.5f);
                    this.kdO.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kdP.layout(this.mPadding + i10 + kdL, 0, (i10 * 2) + this.mPadding + kdL, i4 - i2);
                    this.kdQ.layout((i10 * 2) + this.mPadding + (kdL * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kdR != null && this.kdR.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kdR.length) {
                case 1:
                    drawChild(canvas, this.kdO, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kdO, drawingTime);
                    drawChild(canvas, this.kdP, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kdO, drawingTime);
                    drawChild(canvas, this.kdP, drawingTime);
                    drawChild(canvas, this.kdQ, drawingTime);
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
