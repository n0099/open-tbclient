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
    private static float[] iVJ = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] iVK = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int iVL = 2;
    private static int iVM = 4;
    private static int iVN = 0;
    public static float sRatio = -1.0f;
    public TbImageView iVO;
    public TbImageView iVP;
    public TbImageView iVQ;
    private MediaData[] iVR;
    private boolean iVS;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.af(this.mContext) / 320.0f;
            for (int i = 0; i < iVJ.length; i++) {
                float[] fArr = iVJ;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = iVK;
                fArr2[i] = fArr2[i] * sRatio;
            }
            iVL = (int) (iVL * sRatio);
            iVM = (int) (iVM * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.iVS = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = al.getDrawable(R.color.common_color_10220);
        this.iVO = new TbImageView(context);
        this.iVP = new TbImageView(context);
        this.iVQ = new TbImageView(context);
        this.iVO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVO.setDefaultBg(drawable);
        this.iVP.setDefaultBg(drawable);
        this.iVQ.setDefaultBg(drawable);
        addView(this.iVO);
        addView(this.iVP);
        addView(this.iVQ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.iVS = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.iVR = mediaDataArr;
        if (this.iVR == null || this.iVR.length <= 0) {
            if (this.iVO != null) {
                this.iVO.setTag(null);
            }
            if (this.iVP != null) {
                this.iVP.setTag(null);
            }
            if (this.iVQ != null) {
                this.iVQ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.iVR.length;
        if (length == 1) {
            a(this.iVO, this.iVR[0]);
            if (this.iVP != null) {
                this.iVP.setTag(null);
                this.iVP.setClickable(false);
            }
            if (this.iVQ != null) {
                this.iVQ.setTag(null);
                this.iVQ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.iVO, this.iVR[0]);
            a(this.iVP, this.iVR[1]);
            if (this.iVQ != null) {
                this.iVQ.setTag(null);
                this.iVQ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.iVO, this.iVR[0]);
            a(this.iVP, this.iVR[1]);
            a(this.iVQ, this.iVR[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (iVN == 0) {
            iVN = i5;
        }
        if (this.iVR == null || this.iVR.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.iVS) {
            setMeasuredDimension(iVN, (int) (iVK[this.iVR.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(iVN, (int) (iVK[4] + 0.5f));
        }
        switch (this.iVR.length) {
            case 1:
                if (this.iVS) {
                    measureChild(this.iVO, iVN + 1073741824, ((int) (iVK[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.iVO, ((int) (iVJ[4] + 0.5f)) + 1073741824, ((int) (iVK[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.iVP, 0, 0);
                measureChild(this.iVQ, 0, 0);
                return;
            case 2:
                if (this.iVS) {
                    i3 = ((int) (iVJ[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (iVK[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (iVJ[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (iVK[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.iVO, i3, i4);
                measureChild(this.iVP, i3, i4);
                measureChild(this.iVQ, 0, 0);
                return;
            case 3:
                if (this.iVS) {
                    int i6 = ((int) (iVJ[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (iVK[3] + 0.5f)) + 1073741824;
                    measureChild(this.iVO, ((int) (iVJ[2] + 0.5f)) + 1073741824, ((int) (iVK[2] + 0.5f)) + 1073741824);
                    measureChild(this.iVP, i6, i7);
                    measureChild(this.iVQ, i6, i7);
                    return;
                }
                int i8 = ((int) (iVJ[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (iVK[4] + 0.5f)) + 1073741824;
                measureChild(this.iVO, i8, i9);
                measureChild(this.iVP, i8, i9);
                measureChild(this.iVQ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVR != null && this.iVR.length != 0) {
            switch (this.iVR.length) {
                case 1:
                    if (this.iVS) {
                        int i5 = (int) (iVJ[0] + 0.5f);
                        this.iVO.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.iVO.layout(this.mPadding, 0, ((int) (iVJ[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.iVP.layout(0, 0, 0, 0);
                    this.iVQ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.iVS) {
                        int i6 = (int) (iVJ[1] + 0.5f);
                        this.iVO.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.iVP.layout(i6 + this.mPadding + iVM, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (iVJ[4] + 0.5f);
                        this.iVO.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.iVP.layout(this.mPadding + i7 + iVL, 0, (i7 * 2) + this.mPadding + iVL, i4 - i2);
                    }
                    this.iVQ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.iVS) {
                        int i8 = (int) (iVJ[2] + 0.5f);
                        int i9 = (int) (iVJ[3] + 0.5f);
                        this.iVO.layout(0, 0, i8, i4 - i2);
                        this.iVP.layout(iVL + i8, 0, i3, i9);
                        this.iVQ.layout(i8 + iVL, i9 + iVL, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (iVJ[4] + 0.5f);
                    this.iVO.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.iVP.layout(this.mPadding + i10 + iVL, 0, (i10 * 2) + this.mPadding + iVL, i4 - i2);
                    this.iVQ.layout((i10 * 2) + this.mPadding + (iVL * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iVR != null && this.iVR.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.iVR.length) {
                case 1:
                    drawChild(canvas, this.iVO, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.iVO, drawingTime);
                    drawChild(canvas, this.iVP, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.iVO, drawingTime);
                    drawChild(canvas, this.iVP, drawingTime);
                    drawChild(canvas, this.iVQ, drawingTime);
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
