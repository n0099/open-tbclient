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
    public TbImageView kdC;
    public TbImageView kdD;
    public TbImageView kdE;
    private MediaData[] kdF;
    private boolean kdG;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] kdx = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kdy = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kdz = 2;
    private static int kdA = 4;
    private static int kdB = 0;
    public static float sRatio = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kdx.length; i++) {
                float[] fArr = kdx;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kdy;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kdz = (int) (kdz * sRatio);
            kdA = (int) (kdA * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kdG = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kdC = new TbImageView(context);
        this.kdD = new TbImageView(context);
        this.kdE = new TbImageView(context);
        this.kdC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdC.setDefaultBg(drawable);
        this.kdD.setDefaultBg(drawable);
        this.kdE.setDefaultBg(drawable);
        addView(this.kdC);
        addView(this.kdD);
        addView(this.kdE);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kdG = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kdF = mediaDataArr;
        if (this.kdF == null || this.kdF.length <= 0) {
            if (this.kdC != null) {
                this.kdC.setTag(null);
            }
            if (this.kdD != null) {
                this.kdD.setTag(null);
            }
            if (this.kdE != null) {
                this.kdE.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kdF.length;
        if (length == 1) {
            a(this.kdC, this.kdF[0]);
            if (this.kdD != null) {
                this.kdD.setTag(null);
                this.kdD.setClickable(false);
            }
            if (this.kdE != null) {
                this.kdE.setTag(null);
                this.kdE.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kdC, this.kdF[0]);
            a(this.kdD, this.kdF[1]);
            if (this.kdE != null) {
                this.kdE.setTag(null);
                this.kdE.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kdC, this.kdF[0]);
            a(this.kdD, this.kdF[1]);
            a(this.kdE, this.kdF[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kdB == 0) {
            kdB = i5;
        }
        if (this.kdF == null || this.kdF.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kdG) {
            setMeasuredDimension(kdB, (int) (kdy[this.kdF.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kdB, (int) (kdy[4] + 0.5f));
        }
        switch (this.kdF.length) {
            case 1:
                if (this.kdG) {
                    measureChild(this.kdC, kdB + 1073741824, ((int) (kdy[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kdC, ((int) (kdx[4] + 0.5f)) + 1073741824, ((int) (kdy[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kdD, 0, 0);
                measureChild(this.kdE, 0, 0);
                return;
            case 2:
                if (this.kdG) {
                    i3 = ((int) (kdx[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kdy[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kdx[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kdy[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kdC, i3, i4);
                measureChild(this.kdD, i3, i4);
                measureChild(this.kdE, 0, 0);
                return;
            case 3:
                if (this.kdG) {
                    int i6 = ((int) (kdx[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kdy[3] + 0.5f)) + 1073741824;
                    measureChild(this.kdC, ((int) (kdx[2] + 0.5f)) + 1073741824, ((int) (kdy[2] + 0.5f)) + 1073741824);
                    measureChild(this.kdD, i6, i7);
                    measureChild(this.kdE, i6, i7);
                    return;
                }
                int i8 = ((int) (kdx[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kdy[4] + 0.5f)) + 1073741824;
                measureChild(this.kdC, i8, i9);
                measureChild(this.kdD, i8, i9);
                measureChild(this.kdE, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kdF != null && this.kdF.length != 0) {
            switch (this.kdF.length) {
                case 1:
                    if (this.kdG) {
                        int i5 = (int) (kdx[0] + 0.5f);
                        this.kdC.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kdC.layout(this.mPadding, 0, ((int) (kdx[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kdD.layout(0, 0, 0, 0);
                    this.kdE.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kdG) {
                        int i6 = (int) (kdx[1] + 0.5f);
                        this.kdC.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kdD.layout(i6 + this.mPadding + kdA, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kdx[4] + 0.5f);
                        this.kdC.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kdD.layout(this.mPadding + i7 + kdz, 0, (i7 * 2) + this.mPadding + kdz, i4 - i2);
                    }
                    this.kdE.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kdG) {
                        int i8 = (int) (kdx[2] + 0.5f);
                        int i9 = (int) (kdx[3] + 0.5f);
                        this.kdC.layout(0, 0, i8, i4 - i2);
                        this.kdD.layout(kdz + i8, 0, i3, i9);
                        this.kdE.layout(i8 + kdz, i9 + kdz, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kdx[4] + 0.5f);
                    this.kdC.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kdD.layout(this.mPadding + i10 + kdz, 0, (i10 * 2) + this.mPadding + kdz, i4 - i2);
                    this.kdE.layout((i10 * 2) + this.mPadding + (kdz * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kdF != null && this.kdF.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kdF.length) {
                case 1:
                    drawChild(canvas, this.kdC, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kdC, drawingTime);
                    drawChild(canvas, this.kdD, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kdC, drawingTime);
                    drawChild(canvas, this.kdD, drawingTime);
                    drawChild(canvas, this.kdE, drawingTime);
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
