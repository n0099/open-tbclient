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
/* loaded from: classes8.dex */
public class CommonImageLayout extends ViewGroup {
    public TbImageView kcB;
    public TbImageView kcC;
    public TbImageView kcD;
    private MediaData[] kcE;
    private boolean kcF;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private static float[] kcw = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kcx = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kcy = 2;
    private static int kcz = 4;
    private static int kcA = 0;
    public static float sRatio = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kcw.length; i++) {
                float[] fArr = kcw;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kcx;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kcy = (int) (kcy * sRatio);
            kcz = (int) (kcz * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kcF = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kcB = new TbImageView(context);
        this.kcC = new TbImageView(context);
        this.kcD = new TbImageView(context);
        this.kcB.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kcC.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kcD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kcB.setDefaultBg(drawable);
        this.kcC.setDefaultBg(drawable);
        this.kcD.setDefaultBg(drawable);
        addView(this.kcB);
        addView(this.kcC);
        addView(this.kcD);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kcF = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kcE = mediaDataArr;
        if (this.kcE == null || this.kcE.length <= 0) {
            if (this.kcB != null) {
                this.kcB.setTag(null);
            }
            if (this.kcC != null) {
                this.kcC.setTag(null);
            }
            if (this.kcD != null) {
                this.kcD.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kcE.length;
        if (length == 1) {
            a(this.kcB, this.kcE[0]);
            if (this.kcC != null) {
                this.kcC.setTag(null);
                this.kcC.setClickable(false);
            }
            if (this.kcD != null) {
                this.kcD.setTag(null);
                this.kcD.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kcB, this.kcE[0]);
            a(this.kcC, this.kcE[1]);
            if (this.kcD != null) {
                this.kcD.setTag(null);
                this.kcD.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kcB, this.kcE[0]);
            a(this.kcC, this.kcE[1]);
            a(this.kcD, this.kcE[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kcA == 0) {
            kcA = i5;
        }
        if (this.kcE == null || this.kcE.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kcF) {
            setMeasuredDimension(kcA, (int) (kcx[this.kcE.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kcA, (int) (kcx[4] + 0.5f));
        }
        switch (this.kcE.length) {
            case 1:
                if (this.kcF) {
                    measureChild(this.kcB, kcA + 1073741824, ((int) (kcx[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kcB, ((int) (kcw[4] + 0.5f)) + 1073741824, ((int) (kcx[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kcC, 0, 0);
                measureChild(this.kcD, 0, 0);
                return;
            case 2:
                if (this.kcF) {
                    i3 = ((int) (kcw[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kcx[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kcw[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kcx[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kcB, i3, i4);
                measureChild(this.kcC, i3, i4);
                measureChild(this.kcD, 0, 0);
                return;
            case 3:
                if (this.kcF) {
                    int i6 = ((int) (kcw[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kcx[3] + 0.5f)) + 1073741824;
                    measureChild(this.kcB, ((int) (kcw[2] + 0.5f)) + 1073741824, ((int) (kcx[2] + 0.5f)) + 1073741824);
                    measureChild(this.kcC, i6, i7);
                    measureChild(this.kcD, i6, i7);
                    return;
                }
                int i8 = ((int) (kcw[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kcx[4] + 0.5f)) + 1073741824;
                measureChild(this.kcB, i8, i9);
                measureChild(this.kcC, i8, i9);
                measureChild(this.kcD, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kcE != null && this.kcE.length != 0) {
            switch (this.kcE.length) {
                case 1:
                    if (this.kcF) {
                        int i5 = (int) (kcw[0] + 0.5f);
                        this.kcB.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kcB.layout(this.mPadding, 0, ((int) (kcw[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kcC.layout(0, 0, 0, 0);
                    this.kcD.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kcF) {
                        int i6 = (int) (kcw[1] + 0.5f);
                        this.kcB.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kcC.layout(i6 + this.mPadding + kcz, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kcw[4] + 0.5f);
                        this.kcB.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kcC.layout(this.mPadding + i7 + kcy, 0, (i7 * 2) + this.mPadding + kcy, i4 - i2);
                    }
                    this.kcD.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kcF) {
                        int i8 = (int) (kcw[2] + 0.5f);
                        int i9 = (int) (kcw[3] + 0.5f);
                        this.kcB.layout(0, 0, i8, i4 - i2);
                        this.kcC.layout(kcy + i8, 0, i3, i9);
                        this.kcD.layout(i8 + kcy, i9 + kcy, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kcw[4] + 0.5f);
                    this.kcB.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kcC.layout(this.mPadding + i10 + kcy, 0, (i10 * 2) + this.mPadding + kcy, i4 - i2);
                    this.kcD.layout((i10 * 2) + this.mPadding + (kcy * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kcE != null && this.kcE.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kcE.length) {
                case 1:
                    drawChild(canvas, this.kcB, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kcB, drawingTime);
                    drawChild(canvas, this.kcC, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kcB, drawingTime);
                    drawChild(canvas, this.kcC, drawingTime);
                    drawChild(canvas, this.kcD, drawingTime);
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
