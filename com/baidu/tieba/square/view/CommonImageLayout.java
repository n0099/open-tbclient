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
    private static float[] kfm = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kfn = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kfo = 2;
    private static int kfp = 4;
    private static int kfq = 0;
    public static float sRatio = -1.0f;
    public TbImageView kfr;
    public TbImageView kfs;
    public TbImageView kft;
    private MediaData[] kfu;
    private boolean kfv;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kfm.length; i++) {
                float[] fArr = kfm;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kfn;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kfo = (int) (kfo * sRatio);
            kfp = (int) (kfp * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kfv = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kfr = new TbImageView(context);
        this.kfs = new TbImageView(context);
        this.kft = new TbImageView(context);
        this.kfr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kfs.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kft.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kfr.setDefaultBg(drawable);
        this.kfs.setDefaultBg(drawable);
        this.kft.setDefaultBg(drawable);
        addView(this.kfr);
        addView(this.kfs);
        addView(this.kft);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kfv = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kfu = mediaDataArr;
        if (this.kfu == null || this.kfu.length <= 0) {
            if (this.kfr != null) {
                this.kfr.setTag(null);
            }
            if (this.kfs != null) {
                this.kfs.setTag(null);
            }
            if (this.kft != null) {
                this.kft.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kfu.length;
        if (length == 1) {
            a(this.kfr, this.kfu[0]);
            if (this.kfs != null) {
                this.kfs.setTag(null);
                this.kfs.setClickable(false);
            }
            if (this.kft != null) {
                this.kft.setTag(null);
                this.kft.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kfr, this.kfu[0]);
            a(this.kfs, this.kfu[1]);
            if (this.kft != null) {
                this.kft.setTag(null);
                this.kft.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kfr, this.kfu[0]);
            a(this.kfs, this.kfu[1]);
            a(this.kft, this.kfu[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kfq == 0) {
            kfq = i5;
        }
        if (this.kfu == null || this.kfu.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kfv) {
            setMeasuredDimension(kfq, (int) (kfn[this.kfu.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kfq, (int) (kfn[4] + 0.5f));
        }
        switch (this.kfu.length) {
            case 1:
                if (this.kfv) {
                    measureChild(this.kfr, kfq + 1073741824, ((int) (kfn[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kfr, ((int) (kfm[4] + 0.5f)) + 1073741824, ((int) (kfn[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kfs, 0, 0);
                measureChild(this.kft, 0, 0);
                return;
            case 2:
                if (this.kfv) {
                    i3 = ((int) (kfm[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kfn[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kfm[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kfn[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kfr, i3, i4);
                measureChild(this.kfs, i3, i4);
                measureChild(this.kft, 0, 0);
                return;
            case 3:
                if (this.kfv) {
                    int i6 = ((int) (kfm[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kfn[3] + 0.5f)) + 1073741824;
                    measureChild(this.kfr, ((int) (kfm[2] + 0.5f)) + 1073741824, ((int) (kfn[2] + 0.5f)) + 1073741824);
                    measureChild(this.kfs, i6, i7);
                    measureChild(this.kft, i6, i7);
                    return;
                }
                int i8 = ((int) (kfm[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kfn[4] + 0.5f)) + 1073741824;
                measureChild(this.kfr, i8, i9);
                measureChild(this.kfs, i8, i9);
                measureChild(this.kft, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kfu != null && this.kfu.length != 0) {
            switch (this.kfu.length) {
                case 1:
                    if (this.kfv) {
                        int i5 = (int) (kfm[0] + 0.5f);
                        this.kfr.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kfr.layout(this.mPadding, 0, ((int) (kfm[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kfs.layout(0, 0, 0, 0);
                    this.kft.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kfv) {
                        int i6 = (int) (kfm[1] + 0.5f);
                        this.kfr.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kfs.layout(i6 + this.mPadding + kfp, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kfm[4] + 0.5f);
                        this.kfr.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kfs.layout(this.mPadding + i7 + kfo, 0, (i7 * 2) + this.mPadding + kfo, i4 - i2);
                    }
                    this.kft.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kfv) {
                        int i8 = (int) (kfm[2] + 0.5f);
                        int i9 = (int) (kfm[3] + 0.5f);
                        this.kfr.layout(0, 0, i8, i4 - i2);
                        this.kfs.layout(kfo + i8, 0, i3, i9);
                        this.kft.layout(i8 + kfo, i9 + kfo, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kfm[4] + 0.5f);
                    this.kfr.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kfs.layout(this.mPadding + i10 + kfo, 0, (i10 * 2) + this.mPadding + kfo, i4 - i2);
                    this.kft.layout((i10 * 2) + this.mPadding + (kfo * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kfu != null && this.kfu.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kfu.length) {
                case 1:
                    drawChild(canvas, this.kfr, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kfr, drawingTime);
                    drawChild(canvas, this.kfs, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kfr, drawingTime);
                    drawChild(canvas, this.kfs, drawingTime);
                    drawChild(canvas, this.kft, drawingTime);
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
