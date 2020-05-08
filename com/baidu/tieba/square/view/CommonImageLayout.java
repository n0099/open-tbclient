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
    private static float[] kPj = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] kPk = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int kPl = 2;
    private static int kPm = 4;
    private static int kPn = 0;
    public static float sRatio = -1.0f;
    public TbImageView kPo;
    public TbImageView kPp;
    public TbImageView kPq;
    private MediaData[] kPr;
    private boolean kPs;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < kPj.length; i++) {
                float[] fArr = kPj;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = kPk;
                fArr2[i] = fArr2[i] * sRatio;
            }
            kPl = (int) (kPl * sRatio);
            kPm = (int) (kPm * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.kPs = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.kPo = new TbImageView(context);
        this.kPp = new TbImageView(context);
        this.kPq = new TbImageView(context);
        this.kPo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kPp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kPq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kPo.setDefaultBg(drawable);
        this.kPp.setDefaultBg(drawable);
        this.kPq.setDefaultBg(drawable);
        addView(this.kPo);
        addView(this.kPp);
        addView(this.kPq);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.kPs = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.kPr = mediaDataArr;
        if (this.kPr == null || this.kPr.length <= 0) {
            if (this.kPo != null) {
                this.kPo.setTag(null);
            }
            if (this.kPp != null) {
                this.kPp.setTag(null);
            }
            if (this.kPq != null) {
                this.kPq.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.kPr.length;
        if (length == 1) {
            a(this.kPo, this.kPr[0]);
            if (this.kPp != null) {
                this.kPp.setTag(null);
                this.kPp.setClickable(false);
            }
            if (this.kPq != null) {
                this.kPq.setTag(null);
                this.kPq.setClickable(false);
            }
        } else if (length == 2) {
            a(this.kPo, this.kPr[0]);
            a(this.kPp, this.kPr[1]);
            if (this.kPq != null) {
                this.kPq.setTag(null);
                this.kPq.setClickable(false);
            }
        } else if (length == 3) {
            a(this.kPo, this.kPr[0]);
            a(this.kPp, this.kPr[1]);
            a(this.kPq, this.kPr[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (kPn == 0) {
            kPn = i5;
        }
        if (this.kPr == null || this.kPr.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.kPs) {
            setMeasuredDimension(kPn, (int) (kPk[this.kPr.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(kPn, (int) (kPk[4] + 0.5f));
        }
        switch (this.kPr.length) {
            case 1:
                if (this.kPs) {
                    measureChild(this.kPo, kPn + 1073741824, ((int) (kPk[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.kPo, ((int) (kPj[4] + 0.5f)) + 1073741824, ((int) (kPk[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.kPp, 0, 0);
                measureChild(this.kPq, 0, 0);
                return;
            case 2:
                if (this.kPs) {
                    i3 = ((int) (kPj[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (kPk[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (kPj[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (kPk[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.kPo, i3, i4);
                measureChild(this.kPp, i3, i4);
                measureChild(this.kPq, 0, 0);
                return;
            case 3:
                if (this.kPs) {
                    int i6 = ((int) (kPj[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (kPk[3] + 0.5f)) + 1073741824;
                    measureChild(this.kPo, ((int) (kPj[2] + 0.5f)) + 1073741824, ((int) (kPk[2] + 0.5f)) + 1073741824);
                    measureChild(this.kPp, i6, i7);
                    measureChild(this.kPq, i6, i7);
                    return;
                }
                int i8 = ((int) (kPj[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (kPk[4] + 0.5f)) + 1073741824;
                measureChild(this.kPo, i8, i9);
                measureChild(this.kPp, i8, i9);
                measureChild(this.kPq, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kPr != null && this.kPr.length != 0) {
            switch (this.kPr.length) {
                case 1:
                    if (this.kPs) {
                        int i5 = (int) (kPj[0] + 0.5f);
                        this.kPo.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.kPo.layout(this.mPadding, 0, ((int) (kPj[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.kPp.layout(0, 0, 0, 0);
                    this.kPq.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.kPs) {
                        int i6 = (int) (kPj[1] + 0.5f);
                        this.kPo.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.kPp.layout(i6 + this.mPadding + kPm, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (kPj[4] + 0.5f);
                        this.kPo.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.kPp.layout(this.mPadding + i7 + kPl, 0, (i7 * 2) + this.mPadding + kPl, i4 - i2);
                    }
                    this.kPq.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.kPs) {
                        int i8 = (int) (kPj[2] + 0.5f);
                        int i9 = (int) (kPj[3] + 0.5f);
                        this.kPo.layout(0, 0, i8, i4 - i2);
                        this.kPp.layout(kPl + i8, 0, i3, i9);
                        this.kPq.layout(i8 + kPl, i9 + kPl, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (kPj[4] + 0.5f);
                    this.kPo.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.kPp.layout(this.mPadding + i10 + kPl, 0, (i10 * 2) + this.mPadding + kPl, i4 - i2);
                    this.kPq.layout((i10 * 2) + this.mPadding + (kPl * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kPr != null && this.kPr.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.kPr.length) {
                case 1:
                    drawChild(canvas, this.kPo, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.kPo, drawingTime);
                    drawChild(canvas, this.kPp, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.kPo, drawingTime);
                    drawChild(canvas, this.kPp, drawingTime);
                    drawChild(canvas, this.kPq, drawingTime);
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
