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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] iVN = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] iVO = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int iVP = 2;
    private static int iVQ = 4;
    private static int iVR = 0;
    public static float sRatio = -1.0f;
    public TbImageView iVS;
    public TbImageView iVT;
    public TbImageView iVU;
    private MediaData[] iVV;
    private boolean iVW;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.af(this.mContext) / 320.0f;
            for (int i = 0; i < iVN.length; i++) {
                float[] fArr = iVN;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = iVO;
                fArr2[i] = fArr2[i] * sRatio;
            }
            iVP = (int) (iVP * sRatio);
            iVQ = (int) (iVQ * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.iVW = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = al.getDrawable(R.color.common_color_10220);
        this.iVS = new TbImageView(context);
        this.iVT = new TbImageView(context);
        this.iVU = new TbImageView(context);
        this.iVS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVS.setDefaultBg(drawable);
        this.iVT.setDefaultBg(drawable);
        this.iVU.setDefaultBg(drawable);
        addView(this.iVS);
        addView(this.iVT);
        addView(this.iVU);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.iVW = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.iVV = mediaDataArr;
        if (this.iVV == null || this.iVV.length <= 0) {
            if (this.iVS != null) {
                this.iVS.setTag(null);
            }
            if (this.iVT != null) {
                this.iVT.setTag(null);
            }
            if (this.iVU != null) {
                this.iVU.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.iVV.length;
        if (length == 1) {
            a(this.iVS, this.iVV[0]);
            if (this.iVT != null) {
                this.iVT.setTag(null);
                this.iVT.setClickable(false);
            }
            if (this.iVU != null) {
                this.iVU.setTag(null);
                this.iVU.setClickable(false);
            }
        } else if (length == 2) {
            a(this.iVS, this.iVV[0]);
            a(this.iVT, this.iVV[1]);
            if (this.iVU != null) {
                this.iVU.setTag(null);
                this.iVU.setClickable(false);
            }
        } else if (length == 3) {
            a(this.iVS, this.iVV[0]);
            a(this.iVT, this.iVV[1]);
            a(this.iVU, this.iVV[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (iVR == 0) {
            iVR = i5;
        }
        if (this.iVV == null || this.iVV.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.iVW) {
            setMeasuredDimension(iVR, (int) (iVO[this.iVV.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(iVR, (int) (iVO[4] + 0.5f));
        }
        switch (this.iVV.length) {
            case 1:
                if (this.iVW) {
                    measureChild(this.iVS, iVR + 1073741824, ((int) (iVO[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.iVS, ((int) (iVN[4] + 0.5f)) + 1073741824, ((int) (iVO[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.iVT, 0, 0);
                measureChild(this.iVU, 0, 0);
                return;
            case 2:
                if (this.iVW) {
                    i3 = ((int) (iVN[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (iVO[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (iVN[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (iVO[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.iVS, i3, i4);
                measureChild(this.iVT, i3, i4);
                measureChild(this.iVU, 0, 0);
                return;
            case 3:
                if (this.iVW) {
                    int i6 = ((int) (iVN[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (iVO[3] + 0.5f)) + 1073741824;
                    measureChild(this.iVS, ((int) (iVN[2] + 0.5f)) + 1073741824, ((int) (iVO[2] + 0.5f)) + 1073741824);
                    measureChild(this.iVT, i6, i7);
                    measureChild(this.iVU, i6, i7);
                    return;
                }
                int i8 = ((int) (iVN[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (iVO[4] + 0.5f)) + 1073741824;
                measureChild(this.iVS, i8, i9);
                measureChild(this.iVT, i8, i9);
                measureChild(this.iVU, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVV != null && this.iVV.length != 0) {
            switch (this.iVV.length) {
                case 1:
                    if (this.iVW) {
                        int i5 = (int) (iVN[0] + 0.5f);
                        this.iVS.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.iVS.layout(this.mPadding, 0, ((int) (iVN[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.iVT.layout(0, 0, 0, 0);
                    this.iVU.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.iVW) {
                        int i6 = (int) (iVN[1] + 0.5f);
                        this.iVS.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.iVT.layout(i6 + this.mPadding + iVQ, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (iVN[4] + 0.5f);
                        this.iVS.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.iVT.layout(this.mPadding + i7 + iVP, 0, (i7 * 2) + this.mPadding + iVP, i4 - i2);
                    }
                    this.iVU.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.iVW) {
                        int i8 = (int) (iVN[2] + 0.5f);
                        int i9 = (int) (iVN[3] + 0.5f);
                        this.iVS.layout(0, 0, i8, i4 - i2);
                        this.iVT.layout(iVP + i8, 0, i3, i9);
                        this.iVU.layout(i8 + iVP, i9 + iVP, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (iVN[4] + 0.5f);
                    this.iVS.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.iVT.layout(this.mPadding + i10 + iVP, 0, (i10 * 2) + this.mPadding + iVP, i4 - i2);
                    this.iVU.layout((i10 * 2) + this.mPadding + (iVP * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iVV != null && this.iVV.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.iVV.length) {
                case 1:
                    drawChild(canvas, this.iVS, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.iVS, drawingTime);
                    drawChild(canvas, this.iVT, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.iVS, drawingTime);
                    drawChild(canvas, this.iVT, drawingTime);
                    drawChild(canvas, this.iVU, drawingTime);
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
                        com.baidu.tbadk.browser.a.af(CommonImageLayout.this.mContext, mediaData.getVideoUrl());
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
