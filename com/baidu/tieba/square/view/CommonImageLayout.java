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
    private static float[] kcr = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kcs = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kct = 2;
    private static int kcu = 4;
    private static int kcv = 0;
    public static float sRatio = -1.0f;
    private boolean kcA;
    public TbImageView kcw;
    public TbImageView kcx;
    public TbImageView kcy;
    private MediaData[] kcz;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kcr.length; i++) {
                float[] fArr = kcr;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kcs;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kct = (int) (kct * sRatio);
            kcu = (int) (kcu * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kcA = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kcw = new TbImageView(context);
        this.kcx = new TbImageView(context);
        this.kcy = new TbImageView(context);
        this.kcw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kcx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kcy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kcw.setDefaultBg(drawable);
        this.kcx.setDefaultBg(drawable);
        this.kcy.setDefaultBg(drawable);
        addView(this.kcw);
        addView(this.kcx);
        addView(this.kcy);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kcA = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kcz = mediaDataArr;
        if (this.kcz == null || this.kcz.length <= 0) {
            if (this.kcw != null) {
                this.kcw.setTag(null);
            }
            if (this.kcx != null) {
                this.kcx.setTag(null);
            }
            if (this.kcy != null) {
                this.kcy.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kcz.length;
        if (length == 1) {
            a(this.kcw, this.kcz[0]);
            if (this.kcx != null) {
                this.kcx.setTag(null);
                this.kcx.setClickable(false);
            }
            if (this.kcy != null) {
                this.kcy.setTag(null);
                this.kcy.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kcw, this.kcz[0]);
            a(this.kcx, this.kcz[1]);
            if (this.kcy != null) {
                this.kcy.setTag(null);
                this.kcy.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kcw, this.kcz[0]);
            a(this.kcx, this.kcz[1]);
            a(this.kcy, this.kcz[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kcv == 0) {
            kcv = i5;
        }
        if (this.kcz == null || this.kcz.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kcA) {
            setMeasuredDimension(kcv, (int) (kcs[this.kcz.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kcv, (int) (kcs[4] + 0.5f));
        }
        switch (this.kcz.length) {
            case 1:
                if (this.kcA) {
                    measureChild(this.kcw, kcv + 1073741824, ((int) (kcs[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kcw, ((int) (kcr[4] + 0.5f)) + 1073741824, ((int) (kcs[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kcx, 0, 0);
                measureChild(this.kcy, 0, 0);
                return;
            case 2:
                if (this.kcA) {
                    i3 = ((int) (kcr[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kcs[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kcr[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kcs[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kcw, i3, i4);
                measureChild(this.kcx, i3, i4);
                measureChild(this.kcy, 0, 0);
                return;
            case 3:
                if (this.kcA) {
                    int i6 = ((int) (kcr[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kcs[3] + 0.5f)) + 1073741824;
                    measureChild(this.kcw, ((int) (kcr[2] + 0.5f)) + 1073741824, ((int) (kcs[2] + 0.5f)) + 1073741824);
                    measureChild(this.kcx, i6, i7);
                    measureChild(this.kcy, i6, i7);
                    return;
                }
                int i8 = ((int) (kcr[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kcs[4] + 0.5f)) + 1073741824;
                measureChild(this.kcw, i8, i9);
                measureChild(this.kcx, i8, i9);
                measureChild(this.kcy, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kcz != null && this.kcz.length != 0) {
            switch (this.kcz.length) {
                case 1:
                    if (this.kcA) {
                        int i5 = (int) (kcr[0] + 0.5f);
                        this.kcw.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kcw.layout(this.mPadding, 0, ((int) (kcr[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kcx.layout(0, 0, 0, 0);
                    this.kcy.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kcA) {
                        int i6 = (int) (kcr[1] + 0.5f);
                        this.kcw.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kcx.layout(i6 + this.mPadding + kcu, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kcr[4] + 0.5f);
                        this.kcw.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kcx.layout(this.mPadding + i7 + kct, 0, (i7 * 2) + this.mPadding + kct, i4 - i2);
                    }
                    this.kcy.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kcA) {
                        int i8 = (int) (kcr[2] + 0.5f);
                        int i9 = (int) (kcr[3] + 0.5f);
                        this.kcw.layout(0, 0, i8, i4 - i2);
                        this.kcx.layout(kct + i8, 0, i3, i9);
                        this.kcy.layout(i8 + kct, i9 + kct, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kcr[4] + 0.5f);
                    this.kcw.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kcx.layout(this.mPadding + i10 + kct, 0, (i10 * 2) + this.mPadding + kct, i4 - i2);
                    this.kcy.layout((i10 * 2) + this.mPadding + (kct * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kcz != null && this.kcz.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kcz.length) {
                case 1:
                    drawChild(canvas, this.kcw, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kcw, drawingTime);
                    drawChild(canvas, this.kcx, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kcw, drawingTime);
                    drawChild(canvas, this.kcx, drawingTime);
                    drawChild(canvas, this.kcy, drawingTime);
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
