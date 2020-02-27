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
    private static float[] kdv = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kdw = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kdx = 2;
    private static int kdy = 4;
    private static int kdz = 0;
    public static float sRatio = -1.0f;
    public TbImageView kdA;
    public TbImageView kdB;
    public TbImageView kdC;
    private MediaData[] kdD;
    private boolean kdE;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kdv.length; i++) {
                float[] fArr = kdv;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kdw;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kdx = (int) (kdx * sRatio);
            kdy = (int) (kdy * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kdE = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kdA = new TbImageView(context);
        this.kdB = new TbImageView(context);
        this.kdC = new TbImageView(context);
        this.kdA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kdA.setDefaultBg(drawable);
        this.kdB.setDefaultBg(drawable);
        this.kdC.setDefaultBg(drawable);
        addView(this.kdA);
        addView(this.kdB);
        addView(this.kdC);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kdE = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kdD = mediaDataArr;
        if (this.kdD == null || this.kdD.length <= 0) {
            if (this.kdA != null) {
                this.kdA.setTag(null);
            }
            if (this.kdB != null) {
                this.kdB.setTag(null);
            }
            if (this.kdC != null) {
                this.kdC.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kdD.length;
        if (length == 1) {
            a(this.kdA, this.kdD[0]);
            if (this.kdB != null) {
                this.kdB.setTag(null);
                this.kdB.setClickable(false);
            }
            if (this.kdC != null) {
                this.kdC.setTag(null);
                this.kdC.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kdA, this.kdD[0]);
            a(this.kdB, this.kdD[1]);
            if (this.kdC != null) {
                this.kdC.setTag(null);
                this.kdC.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kdA, this.kdD[0]);
            a(this.kdB, this.kdD[1]);
            a(this.kdC, this.kdD[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kdz == 0) {
            kdz = i5;
        }
        if (this.kdD == null || this.kdD.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kdE) {
            setMeasuredDimension(kdz, (int) (kdw[this.kdD.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kdz, (int) (kdw[4] + 0.5f));
        }
        switch (this.kdD.length) {
            case 1:
                if (this.kdE) {
                    measureChild(this.kdA, kdz + 1073741824, ((int) (kdw[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kdA, ((int) (kdv[4] + 0.5f)) + 1073741824, ((int) (kdw[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kdB, 0, 0);
                measureChild(this.kdC, 0, 0);
                return;
            case 2:
                if (this.kdE) {
                    i3 = ((int) (kdv[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kdw[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kdv[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kdw[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kdA, i3, i4);
                measureChild(this.kdB, i3, i4);
                measureChild(this.kdC, 0, 0);
                return;
            case 3:
                if (this.kdE) {
                    int i6 = ((int) (kdv[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kdw[3] + 0.5f)) + 1073741824;
                    measureChild(this.kdA, ((int) (kdv[2] + 0.5f)) + 1073741824, ((int) (kdw[2] + 0.5f)) + 1073741824);
                    measureChild(this.kdB, i6, i7);
                    measureChild(this.kdC, i6, i7);
                    return;
                }
                int i8 = ((int) (kdv[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kdw[4] + 0.5f)) + 1073741824;
                measureChild(this.kdA, i8, i9);
                measureChild(this.kdB, i8, i9);
                measureChild(this.kdC, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kdD != null && this.kdD.length != 0) {
            switch (this.kdD.length) {
                case 1:
                    if (this.kdE) {
                        int i5 = (int) (kdv[0] + 0.5f);
                        this.kdA.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kdA.layout(this.mPadding, 0, ((int) (kdv[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kdB.layout(0, 0, 0, 0);
                    this.kdC.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kdE) {
                        int i6 = (int) (kdv[1] + 0.5f);
                        this.kdA.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kdB.layout(i6 + this.mPadding + kdy, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kdv[4] + 0.5f);
                        this.kdA.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kdB.layout(this.mPadding + i7 + kdx, 0, (i7 * 2) + this.mPadding + kdx, i4 - i2);
                    }
                    this.kdC.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kdE) {
                        int i8 = (int) (kdv[2] + 0.5f);
                        int i9 = (int) (kdv[3] + 0.5f);
                        this.kdA.layout(0, 0, i8, i4 - i2);
                        this.kdB.layout(kdx + i8, 0, i3, i9);
                        this.kdC.layout(i8 + kdx, i9 + kdx, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kdv[4] + 0.5f);
                    this.kdA.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kdB.layout(this.mPadding + i10 + kdx, 0, (i10 * 2) + this.mPadding + kdx, i4 - i2);
                    this.kdC.layout((i10 * 2) + this.mPadding + (kdx * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kdD != null && this.kdD.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kdD.length) {
                case 1:
                    drawChild(canvas, this.kdA, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kdA, drawingTime);
                    drawChild(canvas, this.kdB, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kdA, drawingTime);
                    drawChild(canvas, this.kdB, drawingTime);
                    drawChild(canvas, this.kdC, drawingTime);
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
