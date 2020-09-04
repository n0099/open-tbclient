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
    private static float[] mbS = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mbT = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mbU = 2;
    private static int mbV = 4;
    private static int mbW = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView mbX;
    public TbImageView mbY;
    public TbImageView mbZ;
    private MediaData[] mca;
    private boolean mcb;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mbS.length; i++) {
                float[] fArr = mbS;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mbT;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mbU = (int) (mbU * sRatio);
            mbV = (int) (mbV * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mcb = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mbX = new TbImageView(context);
        this.mbY = new TbImageView(context);
        this.mbZ = new TbImageView(context);
        this.mbX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mbY.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mbZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mbX.setDefaultBg(drawable);
        this.mbY.setDefaultBg(drawable);
        this.mbZ.setDefaultBg(drawable);
        addView(this.mbX);
        addView(this.mbY);
        addView(this.mbZ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mcb = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mca = mediaDataArr;
        if (this.mca == null || this.mca.length <= 0) {
            if (this.mbX != null) {
                this.mbX.setTag(null);
            }
            if (this.mbY != null) {
                this.mbY.setTag(null);
            }
            if (this.mbZ != null) {
                this.mbZ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mca.length;
        if (length == 1) {
            a(this.mbX, this.mca[0]);
            if (this.mbY != null) {
                this.mbY.setTag(null);
                this.mbY.setClickable(false);
            }
            if (this.mbZ != null) {
                this.mbZ.setTag(null);
                this.mbZ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mbX, this.mca[0]);
            a(this.mbY, this.mca[1]);
            if (this.mbZ != null) {
                this.mbZ.setTag(null);
                this.mbZ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mbX, this.mca[0]);
            a(this.mbY, this.mca[1]);
            a(this.mbZ, this.mca[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mbW == 0) {
            mbW = i5;
        }
        if (this.mca == null || this.mca.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mcb) {
            setMeasuredDimension(mbW, (int) (mbT[this.mca.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mbW, (int) (mbT[4] + 0.5f));
        }
        switch (this.mca.length) {
            case 1:
                if (this.mcb) {
                    measureChild(this.mbX, mbW + 1073741824, ((int) (mbT[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mbX, ((int) (mbS[4] + 0.5f)) + 1073741824, ((int) (mbT[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mbY, 0, 0);
                measureChild(this.mbZ, 0, 0);
                return;
            case 2:
                if (this.mcb) {
                    i3 = ((int) (mbS[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mbT[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mbS[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mbT[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mbX, i3, i4);
                measureChild(this.mbY, i3, i4);
                measureChild(this.mbZ, 0, 0);
                return;
            case 3:
                if (this.mcb) {
                    int i6 = ((int) (mbS[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mbT[3] + 0.5f)) + 1073741824;
                    measureChild(this.mbX, ((int) (mbS[2] + 0.5f)) + 1073741824, ((int) (mbT[2] + 0.5f)) + 1073741824);
                    measureChild(this.mbY, i6, i7);
                    measureChild(this.mbZ, i6, i7);
                    return;
                }
                int i8 = ((int) (mbS[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mbT[4] + 0.5f)) + 1073741824;
                measureChild(this.mbX, i8, i9);
                measureChild(this.mbY, i8, i9);
                measureChild(this.mbZ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mca != null && this.mca.length != 0) {
            switch (this.mca.length) {
                case 1:
                    if (this.mcb) {
                        int i5 = (int) (mbS[0] + 0.5f);
                        this.mbX.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mbX.layout(this.mPadding, 0, ((int) (mbS[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mbY.layout(0, 0, 0, 0);
                    this.mbZ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mcb) {
                        int i6 = (int) (mbS[1] + 0.5f);
                        this.mbX.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mbY.layout(i6 + this.mPadding + mbV, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mbS[4] + 0.5f);
                        this.mbX.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mbY.layout(this.mPadding + i7 + mbU, 0, (i7 * 2) + this.mPadding + mbU, i4 - i2);
                    }
                    this.mbZ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mcb) {
                        int i8 = (int) (mbS[2] + 0.5f);
                        int i9 = (int) (mbS[3] + 0.5f);
                        this.mbX.layout(0, 0, i8, i4 - i2);
                        this.mbY.layout(mbU + i8, 0, i3, i9);
                        this.mbZ.layout(i8 + mbU, i9 + mbU, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mbS[4] + 0.5f);
                    this.mbX.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mbY.layout(this.mPadding + i10 + mbU, 0, (i10 * 2) + this.mPadding + mbU, i4 - i2);
                    this.mbZ.layout((i10 * 2) + this.mPadding + (mbU * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mca != null && this.mca.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mca.length) {
                case 1:
                    drawChild(canvas, this.mbX, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mbX, drawingTime);
                    drawChild(canvas, this.mbY, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mbX, drawingTime);
                    drawChild(canvas, this.mbY, drawingTime);
                    drawChild(canvas, this.mbZ, drawingTime);
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
