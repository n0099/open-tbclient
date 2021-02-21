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
/* loaded from: classes8.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] ntJ = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] ntK = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int ntL = 2;
    private static int ntM = 4;
    private static int ntN = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView ntO;
    public TbImageView ntP;
    public TbImageView ntQ;
    private MediaData[] ntR;
    private boolean ntS;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < ntJ.length; i++) {
                float[] fArr = ntJ;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = ntK;
                fArr2[i] = fArr2[i] * sRatio;
            }
            ntL = (int) (ntL * sRatio);
            ntM = (int) (ntM * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.ntS = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.ntO = new TbImageView(context);
        this.ntP = new TbImageView(context);
        this.ntQ = new TbImageView(context);
        this.ntO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ntP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ntQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ntO.setDefaultBg(drawable);
        this.ntP.setDefaultBg(drawable);
        this.ntQ.setDefaultBg(drawable);
        addView(this.ntO);
        addView(this.ntP);
        addView(this.ntQ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.ntS = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.ntR = mediaDataArr;
        if (this.ntR == null || this.ntR.length <= 0) {
            if (this.ntO != null) {
                this.ntO.setTag(null);
            }
            if (this.ntP != null) {
                this.ntP.setTag(null);
            }
            if (this.ntQ != null) {
                this.ntQ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.ntR.length;
        if (length == 1) {
            a(this.ntO, this.ntR[0]);
            if (this.ntP != null) {
                this.ntP.setTag(null);
                this.ntP.setClickable(false);
            }
            if (this.ntQ != null) {
                this.ntQ.setTag(null);
                this.ntQ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.ntO, this.ntR[0]);
            a(this.ntP, this.ntR[1]);
            if (this.ntQ != null) {
                this.ntQ.setTag(null);
                this.ntQ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.ntO, this.ntR[0]);
            a(this.ntP, this.ntR[1]);
            a(this.ntQ, this.ntR[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (ntN == 0) {
            ntN = i5;
        }
        if (this.ntR == null || this.ntR.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.ntS) {
            setMeasuredDimension(ntN, (int) (ntK[this.ntR.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(ntN, (int) (ntK[4] + 0.5f));
        }
        switch (this.ntR.length) {
            case 1:
                if (this.ntS) {
                    measureChild(this.ntO, ntN + 1073741824, ((int) (ntK[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.ntO, ((int) (ntJ[4] + 0.5f)) + 1073741824, ((int) (ntK[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.ntP, 0, 0);
                measureChild(this.ntQ, 0, 0);
                return;
            case 2:
                if (this.ntS) {
                    i3 = ((int) (ntJ[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (ntK[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (ntJ[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (ntK[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.ntO, i3, i4);
                measureChild(this.ntP, i3, i4);
                measureChild(this.ntQ, 0, 0);
                return;
            case 3:
                if (this.ntS) {
                    int i6 = ((int) (ntJ[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (ntK[3] + 0.5f)) + 1073741824;
                    measureChild(this.ntO, ((int) (ntJ[2] + 0.5f)) + 1073741824, ((int) (ntK[2] + 0.5f)) + 1073741824);
                    measureChild(this.ntP, i6, i7);
                    measureChild(this.ntQ, i6, i7);
                    return;
                }
                int i8 = ((int) (ntJ[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (ntK[4] + 0.5f)) + 1073741824;
                measureChild(this.ntO, i8, i9);
                measureChild(this.ntP, i8, i9);
                measureChild(this.ntQ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.ntR != null && this.ntR.length != 0) {
            switch (this.ntR.length) {
                case 1:
                    if (this.ntS) {
                        int i5 = (int) (ntJ[0] + 0.5f);
                        this.ntO.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.ntO.layout(this.mPadding, 0, ((int) (ntJ[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.ntP.layout(0, 0, 0, 0);
                    this.ntQ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.ntS) {
                        int i6 = (int) (ntJ[1] + 0.5f);
                        this.ntO.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.ntP.layout(i6 + this.mPadding + ntM, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (ntJ[4] + 0.5f);
                        this.ntO.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.ntP.layout(this.mPadding + i7 + ntL, 0, (i7 * 2) + this.mPadding + ntL, i4 - i2);
                    }
                    this.ntQ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.ntS) {
                        int i8 = (int) (ntJ[2] + 0.5f);
                        int i9 = (int) (ntJ[3] + 0.5f);
                        this.ntO.layout(0, 0, i8, i4 - i2);
                        this.ntP.layout(ntL + i8, 0, i3, i9);
                        this.ntQ.layout(i8 + ntL, i9 + ntL, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (ntJ[4] + 0.5f);
                    this.ntO.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.ntP.layout(this.mPadding + i10 + ntL, 0, (i10 * 2) + this.mPadding + ntL, i4 - i2);
                    this.ntQ.layout((i10 * 2) + this.mPadding + (ntL * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ntR != null && this.ntR.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.ntR.length) {
                case 1:
                    drawChild(canvas, this.ntO, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.ntO, drawingTime);
                    drawChild(canvas, this.ntP, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.ntO, drawingTime);
                    drawChild(canvas, this.ntP, drawingTime);
                    drawChild(canvas, this.ntQ, drawingTime);
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
