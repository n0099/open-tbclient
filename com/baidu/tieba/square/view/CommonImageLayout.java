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
/* loaded from: classes7.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] jYO = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] jYP = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int jYQ = 2;
    private static int jYR = 4;
    private static int jYS = 0;
    public static float sRatio = -1.0f;
    public TbImageView jYT;
    public TbImageView jYU;
    public TbImageView jYV;
    private MediaData[] jYW;
    private boolean jYX;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < jYO.length; i++) {
                float[] fArr = jYO;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = jYP;
                fArr2[i] = fArr2[i] * sRatio;
            }
            jYQ = (int) (jYQ * sRatio);
            jYR = (int) (jYR * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.jYX = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.jYT = new TbImageView(context);
        this.jYU = new TbImageView(context);
        this.jYV = new TbImageView(context);
        this.jYT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jYU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jYV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jYT.setDefaultBg(drawable);
        this.jYU.setDefaultBg(drawable);
        this.jYV.setDefaultBg(drawable);
        addView(this.jYT);
        addView(this.jYU);
        addView(this.jYV);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.jYX = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.jYW = mediaDataArr;
        if (this.jYW == null || this.jYW.length <= 0) {
            if (this.jYT != null) {
                this.jYT.setTag(null);
            }
            if (this.jYU != null) {
                this.jYU.setTag(null);
            }
            if (this.jYV != null) {
                this.jYV.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.jYW.length;
        if (length == 1) {
            a(this.jYT, this.jYW[0]);
            if (this.jYU != null) {
                this.jYU.setTag(null);
                this.jYU.setClickable(false);
            }
            if (this.jYV != null) {
                this.jYV.setTag(null);
                this.jYV.setClickable(false);
            }
        } else if (length == 2) {
            a(this.jYT, this.jYW[0]);
            a(this.jYU, this.jYW[1]);
            if (this.jYV != null) {
                this.jYV.setTag(null);
                this.jYV.setClickable(false);
            }
        } else if (length == 3) {
            a(this.jYT, this.jYW[0]);
            a(this.jYU, this.jYW[1]);
            a(this.jYV, this.jYW[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (jYS == 0) {
            jYS = i5;
        }
        if (this.jYW == null || this.jYW.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.jYX) {
            setMeasuredDimension(jYS, (int) (jYP[this.jYW.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(jYS, (int) (jYP[4] + 0.5f));
        }
        switch (this.jYW.length) {
            case 1:
                if (this.jYX) {
                    measureChild(this.jYT, jYS + 1073741824, ((int) (jYP[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.jYT, ((int) (jYO[4] + 0.5f)) + 1073741824, ((int) (jYP[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.jYU, 0, 0);
                measureChild(this.jYV, 0, 0);
                return;
            case 2:
                if (this.jYX) {
                    i3 = ((int) (jYO[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (jYP[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (jYO[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (jYP[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.jYT, i3, i4);
                measureChild(this.jYU, i3, i4);
                measureChild(this.jYV, 0, 0);
                return;
            case 3:
                if (this.jYX) {
                    int i6 = ((int) (jYO[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (jYP[3] + 0.5f)) + 1073741824;
                    measureChild(this.jYT, ((int) (jYO[2] + 0.5f)) + 1073741824, ((int) (jYP[2] + 0.5f)) + 1073741824);
                    measureChild(this.jYU, i6, i7);
                    measureChild(this.jYV, i6, i7);
                    return;
                }
                int i8 = ((int) (jYO[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (jYP[4] + 0.5f)) + 1073741824;
                measureChild(this.jYT, i8, i9);
                measureChild(this.jYU, i8, i9);
                measureChild(this.jYV, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jYW != null && this.jYW.length != 0) {
            switch (this.jYW.length) {
                case 1:
                    if (this.jYX) {
                        int i5 = (int) (jYO[0] + 0.5f);
                        this.jYT.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.jYT.layout(this.mPadding, 0, ((int) (jYO[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.jYU.layout(0, 0, 0, 0);
                    this.jYV.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.jYX) {
                        int i6 = (int) (jYO[1] + 0.5f);
                        this.jYT.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.jYU.layout(i6 + this.mPadding + jYR, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (jYO[4] + 0.5f);
                        this.jYT.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.jYU.layout(this.mPadding + i7 + jYQ, 0, (i7 * 2) + this.mPadding + jYQ, i4 - i2);
                    }
                    this.jYV.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.jYX) {
                        int i8 = (int) (jYO[2] + 0.5f);
                        int i9 = (int) (jYO[3] + 0.5f);
                        this.jYT.layout(0, 0, i8, i4 - i2);
                        this.jYU.layout(jYQ + i8, 0, i3, i9);
                        this.jYV.layout(i8 + jYQ, i9 + jYQ, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (jYO[4] + 0.5f);
                    this.jYT.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.jYU.layout(this.mPadding + i10 + jYQ, 0, (i10 * 2) + this.mPadding + jYQ, i4 - i2);
                    this.jYV.layout((i10 * 2) + this.mPadding + (jYQ * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jYW != null && this.jYW.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.jYW.length) {
                case 1:
                    drawChild(canvas, this.jYT, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.jYT, drawingTime);
                    drawChild(canvas, this.jYU, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.jYT, drawingTime);
                    drawChild(canvas, this.jYU, drawingTime);
                    drawChild(canvas, this.jYV, drawingTime);
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
