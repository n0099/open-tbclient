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
    private static float[] liI = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] liJ = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int liK = 2;
    private static int liL = 4;
    private static int liM = 0;
    public static float sRatio = -1.0f;
    public TbImageView liN;
    public TbImageView liO;
    public TbImageView liP;
    private MediaData[] liQ;
    private boolean liR;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < liI.length; i++) {
                float[] fArr = liI;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = liJ;
                fArr2[i] = fArr2[i] * sRatio;
            }
            liK = (int) (liK * sRatio);
            liL = (int) (liL * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.liR = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.liN = new TbImageView(context);
        this.liO = new TbImageView(context);
        this.liP = new TbImageView(context);
        this.liN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.liO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.liP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.liN.setDefaultBg(drawable);
        this.liO.setDefaultBg(drawable);
        this.liP.setDefaultBg(drawable);
        addView(this.liN);
        addView(this.liO);
        addView(this.liP);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.liR = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.liQ = mediaDataArr;
        if (this.liQ == null || this.liQ.length <= 0) {
            if (this.liN != null) {
                this.liN.setTag(null);
            }
            if (this.liO != null) {
                this.liO.setTag(null);
            }
            if (this.liP != null) {
                this.liP.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.liQ.length;
        if (length == 1) {
            a(this.liN, this.liQ[0]);
            if (this.liO != null) {
                this.liO.setTag(null);
                this.liO.setClickable(false);
            }
            if (this.liP != null) {
                this.liP.setTag(null);
                this.liP.setClickable(false);
            }
        } else if (length == 2) {
            a(this.liN, this.liQ[0]);
            a(this.liO, this.liQ[1]);
            if (this.liP != null) {
                this.liP.setTag(null);
                this.liP.setClickable(false);
            }
        } else if (length == 3) {
            a(this.liN, this.liQ[0]);
            a(this.liO, this.liQ[1]);
            a(this.liP, this.liQ[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (liM == 0) {
            liM = i5;
        }
        if (this.liQ == null || this.liQ.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.liR) {
            setMeasuredDimension(liM, (int) (liJ[this.liQ.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(liM, (int) (liJ[4] + 0.5f));
        }
        switch (this.liQ.length) {
            case 1:
                if (this.liR) {
                    measureChild(this.liN, liM + 1073741824, ((int) (liJ[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.liN, ((int) (liI[4] + 0.5f)) + 1073741824, ((int) (liJ[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.liO, 0, 0);
                measureChild(this.liP, 0, 0);
                return;
            case 2:
                if (this.liR) {
                    i3 = ((int) (liI[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (liJ[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (liI[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (liJ[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.liN, i3, i4);
                measureChild(this.liO, i3, i4);
                measureChild(this.liP, 0, 0);
                return;
            case 3:
                if (this.liR) {
                    int i6 = ((int) (liI[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (liJ[3] + 0.5f)) + 1073741824;
                    measureChild(this.liN, ((int) (liI[2] + 0.5f)) + 1073741824, ((int) (liJ[2] + 0.5f)) + 1073741824);
                    measureChild(this.liO, i6, i7);
                    measureChild(this.liP, i6, i7);
                    return;
                }
                int i8 = ((int) (liI[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (liJ[4] + 0.5f)) + 1073741824;
                measureChild(this.liN, i8, i9);
                measureChild(this.liO, i8, i9);
                measureChild(this.liP, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.liQ != null && this.liQ.length != 0) {
            switch (this.liQ.length) {
                case 1:
                    if (this.liR) {
                        int i5 = (int) (liI[0] + 0.5f);
                        this.liN.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.liN.layout(this.mPadding, 0, ((int) (liI[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.liO.layout(0, 0, 0, 0);
                    this.liP.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.liR) {
                        int i6 = (int) (liI[1] + 0.5f);
                        this.liN.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.liO.layout(i6 + this.mPadding + liL, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (liI[4] + 0.5f);
                        this.liN.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.liO.layout(this.mPadding + i7 + liK, 0, (i7 * 2) + this.mPadding + liK, i4 - i2);
                    }
                    this.liP.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.liR) {
                        int i8 = (int) (liI[2] + 0.5f);
                        int i9 = (int) (liI[3] + 0.5f);
                        this.liN.layout(0, 0, i8, i4 - i2);
                        this.liO.layout(liK + i8, 0, i3, i9);
                        this.liP.layout(i8 + liK, i9 + liK, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (liI[4] + 0.5f);
                    this.liN.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.liO.layout(this.mPadding + i10 + liK, 0, (i10 * 2) + this.mPadding + liK, i4 - i2);
                    this.liP.layout((i10 * 2) + this.mPadding + (liK * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.liQ != null && this.liQ.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.liQ.length) {
                case 1:
                    drawChild(canvas, this.liN, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.liN, drawingTime);
                    drawChild(canvas, this.liO, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.liN, drawingTime);
                    drawChild(canvas, this.liO, drawingTime);
                    drawChild(canvas, this.liP, drawingTime);
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
