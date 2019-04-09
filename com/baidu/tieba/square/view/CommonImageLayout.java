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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] iCT = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] iCU = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int iCV = 2;
    private static int iCW = 4;
    private static int iCX = 0;
    public static float sRatio = -1.0f;
    public TbImageView iCY;
    public TbImageView iCZ;
    public TbImageView iDa;
    private MediaData[] iDb;
    private boolean iDc;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.aO(this.mContext) / 320.0f;
            for (int i = 0; i < iCT.length; i++) {
                float[] fArr = iCT;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = iCU;
                fArr2[i] = fArr2[i] * sRatio;
            }
            iCV = (int) (iCV * sRatio);
            iCW = (int) (iCW * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.iDc = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = al.getDrawable(d.C0277d.common_color_10220);
        this.iCY = new TbImageView(context);
        this.iCZ = new TbImageView(context);
        this.iDa = new TbImageView(context);
        this.iCY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iCZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iDa.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iCY.setDefaultBg(drawable);
        this.iCZ.setDefaultBg(drawable);
        this.iDa.setDefaultBg(drawable);
        addView(this.iCY);
        addView(this.iCZ);
        addView(this.iDa);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.iDc = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.iDb = mediaDataArr;
        if (this.iDb == null || this.iDb.length <= 0) {
            if (this.iCY != null) {
                this.iCY.setTag(null);
            }
            if (this.iCZ != null) {
                this.iCZ.setTag(null);
            }
            if (this.iDa != null) {
                this.iDa.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.iDb.length;
        if (length == 1) {
            a(this.iCY, this.iDb[0]);
            if (this.iCZ != null) {
                this.iCZ.setTag(null);
                this.iCZ.setClickable(false);
            }
            if (this.iDa != null) {
                this.iDa.setTag(null);
                this.iDa.setClickable(false);
            }
        } else if (length == 2) {
            a(this.iCY, this.iDb[0]);
            a(this.iCZ, this.iDb[1]);
            if (this.iDa != null) {
                this.iDa.setTag(null);
                this.iDa.setClickable(false);
            }
        } else if (length == 3) {
            a(this.iCY, this.iDb[0]);
            a(this.iCZ, this.iDb[1]);
            a(this.iDa, this.iDb[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (iCX == 0) {
            iCX = i5;
        }
        if (this.iDb == null || this.iDb.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.iDc) {
            setMeasuredDimension(iCX, (int) (iCU[this.iDb.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(iCX, (int) (iCU[4] + 0.5f));
        }
        switch (this.iDb.length) {
            case 1:
                if (this.iDc) {
                    measureChild(this.iCY, iCX + 1073741824, ((int) (iCU[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.iCY, ((int) (iCT[4] + 0.5f)) + 1073741824, ((int) (iCU[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.iCZ, 0, 0);
                measureChild(this.iDa, 0, 0);
                return;
            case 2:
                if (this.iDc) {
                    i3 = ((int) (iCT[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (iCU[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (iCT[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (iCU[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.iCY, i3, i4);
                measureChild(this.iCZ, i3, i4);
                measureChild(this.iDa, 0, 0);
                return;
            case 3:
                if (this.iDc) {
                    int i6 = ((int) (iCT[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (iCU[3] + 0.5f)) + 1073741824;
                    measureChild(this.iCY, ((int) (iCT[2] + 0.5f)) + 1073741824, ((int) (iCU[2] + 0.5f)) + 1073741824);
                    measureChild(this.iCZ, i6, i7);
                    measureChild(this.iDa, i6, i7);
                    return;
                }
                int i8 = ((int) (iCT[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (iCU[4] + 0.5f)) + 1073741824;
                measureChild(this.iCY, i8, i9);
                measureChild(this.iCZ, i8, i9);
                measureChild(this.iDa, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iDb != null && this.iDb.length != 0) {
            switch (this.iDb.length) {
                case 1:
                    if (this.iDc) {
                        int i5 = (int) (iCT[0] + 0.5f);
                        this.iCY.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.iCY.layout(this.mPadding, 0, ((int) (iCT[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.iCZ.layout(0, 0, 0, 0);
                    this.iDa.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.iDc) {
                        int i6 = (int) (iCT[1] + 0.5f);
                        this.iCY.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.iCZ.layout(i6 + this.mPadding + iCW, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (iCT[4] + 0.5f);
                        this.iCY.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.iCZ.layout(this.mPadding + i7 + iCV, 0, (i7 * 2) + this.mPadding + iCV, i4 - i2);
                    }
                    this.iDa.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.iDc) {
                        int i8 = (int) (iCT[2] + 0.5f);
                        int i9 = (int) (iCT[3] + 0.5f);
                        this.iCY.layout(0, 0, i8, i4 - i2);
                        this.iCZ.layout(iCV + i8, 0, i3, i9);
                        this.iDa.layout(i8 + iCV, i9 + iCV, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (iCT[4] + 0.5f);
                    this.iCY.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.iCZ.layout(this.mPadding + i10 + iCV, 0, (i10 * 2) + this.mPadding + iCV, i4 - i2);
                    this.iDa.layout((i10 * 2) + this.mPadding + (iCV * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iDb != null && this.iDb.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.iDb.length) {
                case 1:
                    drawChild(canvas, this.iCY, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.iCY, drawingTime);
                    drawChild(canvas, this.iCZ, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.iCY, drawingTime);
                    drawChild(canvas, this.iCZ, drawingTime);
                    drawChild(canvas, this.iDa, drawingTime);
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
                tbImageView.setDefaultResource(d.f.pic_video);
                tbImageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.square.view.CommonImageLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tbadk.browser.a.ar(CommonImageLayout.this.mContext, mediaData.getVideoUrl());
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
