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
    private static float[] iVH = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] iVI = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int iVJ = 2;
    private static int iVK = 4;
    private static int iVL = 0;
    public static float sRatio = -1.0f;
    public TbImageView iVM;
    public TbImageView iVN;
    public TbImageView iVO;
    private MediaData[] iVP;
    private boolean iVQ;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.af(this.mContext) / 320.0f;
            for (int i = 0; i < iVH.length; i++) {
                float[] fArr = iVH;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = iVI;
                fArr2[i] = fArr2[i] * sRatio;
            }
            iVJ = (int) (iVJ * sRatio);
            iVK = (int) (iVK * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.iVQ = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = al.getDrawable(R.color.common_color_10220);
        this.iVM = new TbImageView(context);
        this.iVN = new TbImageView(context);
        this.iVO = new TbImageView(context);
        this.iVM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVN.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iVM.setDefaultBg(drawable);
        this.iVN.setDefaultBg(drawable);
        this.iVO.setDefaultBg(drawable);
        addView(this.iVM);
        addView(this.iVN);
        addView(this.iVO);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.iVQ = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.iVP = mediaDataArr;
        if (this.iVP == null || this.iVP.length <= 0) {
            if (this.iVM != null) {
                this.iVM.setTag(null);
            }
            if (this.iVN != null) {
                this.iVN.setTag(null);
            }
            if (this.iVO != null) {
                this.iVO.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.iVP.length;
        if (length == 1) {
            a(this.iVM, this.iVP[0]);
            if (this.iVN != null) {
                this.iVN.setTag(null);
                this.iVN.setClickable(false);
            }
            if (this.iVO != null) {
                this.iVO.setTag(null);
                this.iVO.setClickable(false);
            }
        } else if (length == 2) {
            a(this.iVM, this.iVP[0]);
            a(this.iVN, this.iVP[1]);
            if (this.iVO != null) {
                this.iVO.setTag(null);
                this.iVO.setClickable(false);
            }
        } else if (length == 3) {
            a(this.iVM, this.iVP[0]);
            a(this.iVN, this.iVP[1]);
            a(this.iVO, this.iVP[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (iVL == 0) {
            iVL = i5;
        }
        if (this.iVP == null || this.iVP.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.iVQ) {
            setMeasuredDimension(iVL, (int) (iVI[this.iVP.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(iVL, (int) (iVI[4] + 0.5f));
        }
        switch (this.iVP.length) {
            case 1:
                if (this.iVQ) {
                    measureChild(this.iVM, iVL + 1073741824, ((int) (iVI[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.iVM, ((int) (iVH[4] + 0.5f)) + 1073741824, ((int) (iVI[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.iVN, 0, 0);
                measureChild(this.iVO, 0, 0);
                return;
            case 2:
                if (this.iVQ) {
                    i3 = ((int) (iVH[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (iVI[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (iVH[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (iVI[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.iVM, i3, i4);
                measureChild(this.iVN, i3, i4);
                measureChild(this.iVO, 0, 0);
                return;
            case 3:
                if (this.iVQ) {
                    int i6 = ((int) (iVH[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (iVI[3] + 0.5f)) + 1073741824;
                    measureChild(this.iVM, ((int) (iVH[2] + 0.5f)) + 1073741824, ((int) (iVI[2] + 0.5f)) + 1073741824);
                    measureChild(this.iVN, i6, i7);
                    measureChild(this.iVO, i6, i7);
                    return;
                }
                int i8 = ((int) (iVH[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (iVI[4] + 0.5f)) + 1073741824;
                measureChild(this.iVM, i8, i9);
                measureChild(this.iVN, i8, i9);
                measureChild(this.iVO, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVP != null && this.iVP.length != 0) {
            switch (this.iVP.length) {
                case 1:
                    if (this.iVQ) {
                        int i5 = (int) (iVH[0] + 0.5f);
                        this.iVM.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.iVM.layout(this.mPadding, 0, ((int) (iVH[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.iVN.layout(0, 0, 0, 0);
                    this.iVO.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.iVQ) {
                        int i6 = (int) (iVH[1] + 0.5f);
                        this.iVM.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.iVN.layout(i6 + this.mPadding + iVK, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (iVH[4] + 0.5f);
                        this.iVM.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.iVN.layout(this.mPadding + i7 + iVJ, 0, (i7 * 2) + this.mPadding + iVJ, i4 - i2);
                    }
                    this.iVO.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.iVQ) {
                        int i8 = (int) (iVH[2] + 0.5f);
                        int i9 = (int) (iVH[3] + 0.5f);
                        this.iVM.layout(0, 0, i8, i4 - i2);
                        this.iVN.layout(iVJ + i8, 0, i3, i9);
                        this.iVO.layout(i8 + iVJ, i9 + iVJ, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (iVH[4] + 0.5f);
                    this.iVM.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.iVN.layout(this.mPadding + i10 + iVJ, 0, (i10 * 2) + this.mPadding + iVJ, i4 - i2);
                    this.iVO.layout((i10 * 2) + this.mPadding + (iVJ * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iVP != null && this.iVP.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.iVP.length) {
                case 1:
                    drawChild(canvas, this.iVM, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.iVM, drawingTime);
                    drawChild(canvas, this.iVN, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.iVM, drawingTime);
                    drawChild(canvas, this.iVN, drawingTime);
                    drawChild(canvas, this.iVO, drawingTime);
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
