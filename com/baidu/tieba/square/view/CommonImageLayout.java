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
/* loaded from: classes17.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] mbD = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mbE = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mbF = 2;
    private static int mbG = 4;
    private static int mbH = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView mbI;
    public TbImageView mbJ;
    public TbImageView mbK;
    private MediaData[] mbL;
    private boolean mbM;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mbD.length; i++) {
                float[] fArr = mbD;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mbE;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mbF = (int) (mbF * sRatio);
            mbG = (int) (mbG * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mbM = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mbI = new TbImageView(context);
        this.mbJ = new TbImageView(context);
        this.mbK = new TbImageView(context);
        this.mbI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mbJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mbK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mbI.setDefaultBg(drawable);
        this.mbJ.setDefaultBg(drawable);
        this.mbK.setDefaultBg(drawable);
        addView(this.mbI);
        addView(this.mbJ);
        addView(this.mbK);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mbM = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mbL = mediaDataArr;
        if (this.mbL == null || this.mbL.length <= 0) {
            if (this.mbI != null) {
                this.mbI.setTag(null);
            }
            if (this.mbJ != null) {
                this.mbJ.setTag(null);
            }
            if (this.mbK != null) {
                this.mbK.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mbL.length;
        if (length == 1) {
            a(this.mbI, this.mbL[0]);
            if (this.mbJ != null) {
                this.mbJ.setTag(null);
                this.mbJ.setClickable(false);
            }
            if (this.mbK != null) {
                this.mbK.setTag(null);
                this.mbK.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mbI, this.mbL[0]);
            a(this.mbJ, this.mbL[1]);
            if (this.mbK != null) {
                this.mbK.setTag(null);
                this.mbK.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mbI, this.mbL[0]);
            a(this.mbJ, this.mbL[1]);
            a(this.mbK, this.mbL[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mbH == 0) {
            mbH = i5;
        }
        if (this.mbL == null || this.mbL.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mbM) {
            setMeasuredDimension(mbH, (int) (mbE[this.mbL.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mbH, (int) (mbE[4] + 0.5f));
        }
        switch (this.mbL.length) {
            case 1:
                if (this.mbM) {
                    measureChild(this.mbI, mbH + 1073741824, ((int) (mbE[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mbI, ((int) (mbD[4] + 0.5f)) + 1073741824, ((int) (mbE[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mbJ, 0, 0);
                measureChild(this.mbK, 0, 0);
                return;
            case 2:
                if (this.mbM) {
                    i3 = ((int) (mbD[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mbE[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mbD[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mbE[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mbI, i3, i4);
                measureChild(this.mbJ, i3, i4);
                measureChild(this.mbK, 0, 0);
                return;
            case 3:
                if (this.mbM) {
                    int i6 = ((int) (mbD[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mbE[3] + 0.5f)) + 1073741824;
                    measureChild(this.mbI, ((int) (mbD[2] + 0.5f)) + 1073741824, ((int) (mbE[2] + 0.5f)) + 1073741824);
                    measureChild(this.mbJ, i6, i7);
                    measureChild(this.mbK, i6, i7);
                    return;
                }
                int i8 = ((int) (mbD[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mbE[4] + 0.5f)) + 1073741824;
                measureChild(this.mbI, i8, i9);
                measureChild(this.mbJ, i8, i9);
                measureChild(this.mbK, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mbL != null && this.mbL.length != 0) {
            switch (this.mbL.length) {
                case 1:
                    if (this.mbM) {
                        int i5 = (int) (mbD[0] + 0.5f);
                        this.mbI.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mbI.layout(this.mPadding, 0, ((int) (mbD[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mbJ.layout(0, 0, 0, 0);
                    this.mbK.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mbM) {
                        int i6 = (int) (mbD[1] + 0.5f);
                        this.mbI.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mbJ.layout(i6 + this.mPadding + mbG, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mbD[4] + 0.5f);
                        this.mbI.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mbJ.layout(this.mPadding + i7 + mbF, 0, (i7 * 2) + this.mPadding + mbF, i4 - i2);
                    }
                    this.mbK.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mbM) {
                        int i8 = (int) (mbD[2] + 0.5f);
                        int i9 = (int) (mbD[3] + 0.5f);
                        this.mbI.layout(0, 0, i8, i4 - i2);
                        this.mbJ.layout(mbF + i8, 0, i3, i9);
                        this.mbK.layout(i8 + mbF, i9 + mbF, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mbD[4] + 0.5f);
                    this.mbI.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mbJ.layout(this.mPadding + i10 + mbF, 0, (i10 * 2) + this.mPadding + mbF, i4 - i2);
                    this.mbK.layout((i10 * 2) + this.mPadding + (mbF * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mbL != null && this.mbL.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mbL.length) {
                case 1:
                    drawChild(canvas, this.mbI, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mbI, drawingTime);
                    drawChild(canvas, this.mbJ, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mbI, drawingTime);
                    drawChild(canvas, this.mbJ, drawingTime);
                    drawChild(canvas, this.mbK, drawingTime);
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
