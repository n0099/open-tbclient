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
    private static float[] kPf = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kPg = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kPh = 2;
    private static int kPi = 4;
    private static int kPj = 0;
    public static float sRatio = -1.0f;
    public TbImageView kPk;
    public TbImageView kPl;
    public TbImageView kPm;
    private MediaData[] kPn;
    private boolean kPo;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kPf.length; i++) {
                float[] fArr = kPf;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kPg;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kPh = (int) (kPh * sRatio);
            kPi = (int) (kPi * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kPo = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kPk = new TbImageView(context);
        this.kPl = new TbImageView(context);
        this.kPm = new TbImageView(context);
        this.kPk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kPl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kPm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kPk.setDefaultBg(drawable);
        this.kPl.setDefaultBg(drawable);
        this.kPm.setDefaultBg(drawable);
        addView(this.kPk);
        addView(this.kPl);
        addView(this.kPm);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kPo = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kPn = mediaDataArr;
        if (this.kPn == null || this.kPn.length <= 0) {
            if (this.kPk != null) {
                this.kPk.setTag(null);
            }
            if (this.kPl != null) {
                this.kPl.setTag(null);
            }
            if (this.kPm != null) {
                this.kPm.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kPn.length;
        if (length == 1) {
            a(this.kPk, this.kPn[0]);
            if (this.kPl != null) {
                this.kPl.setTag(null);
                this.kPl.setClickable(false);
            }
            if (this.kPm != null) {
                this.kPm.setTag(null);
                this.kPm.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kPk, this.kPn[0]);
            a(this.kPl, this.kPn[1]);
            if (this.kPm != null) {
                this.kPm.setTag(null);
                this.kPm.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kPk, this.kPn[0]);
            a(this.kPl, this.kPn[1]);
            a(this.kPm, this.kPn[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kPj == 0) {
            kPj = i5;
        }
        if (this.kPn == null || this.kPn.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kPo) {
            setMeasuredDimension(kPj, (int) (kPg[this.kPn.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kPj, (int) (kPg[4] + 0.5f));
        }
        switch (this.kPn.length) {
            case 1:
                if (this.kPo) {
                    measureChild(this.kPk, kPj + 1073741824, ((int) (kPg[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kPk, ((int) (kPf[4] + 0.5f)) + 1073741824, ((int) (kPg[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kPl, 0, 0);
                measureChild(this.kPm, 0, 0);
                return;
            case 2:
                if (this.kPo) {
                    i3 = ((int) (kPf[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kPg[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kPf[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kPg[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kPk, i3, i4);
                measureChild(this.kPl, i3, i4);
                measureChild(this.kPm, 0, 0);
                return;
            case 3:
                if (this.kPo) {
                    int i6 = ((int) (kPf[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kPg[3] + 0.5f)) + 1073741824;
                    measureChild(this.kPk, ((int) (kPf[2] + 0.5f)) + 1073741824, ((int) (kPg[2] + 0.5f)) + 1073741824);
                    measureChild(this.kPl, i6, i7);
                    measureChild(this.kPm, i6, i7);
                    return;
                }
                int i8 = ((int) (kPf[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kPg[4] + 0.5f)) + 1073741824;
                measureChild(this.kPk, i8, i9);
                measureChild(this.kPl, i8, i9);
                measureChild(this.kPm, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kPn != null && this.kPn.length != 0) {
            switch (this.kPn.length) {
                case 1:
                    if (this.kPo) {
                        int i5 = (int) (kPf[0] + 0.5f);
                        this.kPk.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kPk.layout(this.mPadding, 0, ((int) (kPf[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kPl.layout(0, 0, 0, 0);
                    this.kPm.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kPo) {
                        int i6 = (int) (kPf[1] + 0.5f);
                        this.kPk.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kPl.layout(i6 + this.mPadding + kPi, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kPf[4] + 0.5f);
                        this.kPk.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kPl.layout(this.mPadding + i7 + kPh, 0, (i7 * 2) + this.mPadding + kPh, i4 - i2);
                    }
                    this.kPm.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kPo) {
                        int i8 = (int) (kPf[2] + 0.5f);
                        int i9 = (int) (kPf[3] + 0.5f);
                        this.kPk.layout(0, 0, i8, i4 - i2);
                        this.kPl.layout(kPh + i8, 0, i3, i9);
                        this.kPm.layout(i8 + kPh, i9 + kPh, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kPf[4] + 0.5f);
                    this.kPk.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kPl.layout(this.mPadding + i10 + kPh, 0, (i10 * 2) + this.mPadding + kPh, i4 - i2);
                    this.kPm.layout((i10 * 2) + this.mPadding + (kPh * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kPn != null && this.kPn.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kPn.length) {
                case 1:
                    drawChild(canvas, this.kPk, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kPk, drawingTime);
                    drawChild(canvas, this.kPl, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kPk, drawingTime);
                    drawChild(canvas, this.kPl, drawingTime);
                    drawChild(canvas, this.kPm, drawingTime);
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
