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
/* loaded from: classes8.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] ntj = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] ntk = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int ntl = 2;
    private static int ntm = 4;
    private static int ntn = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView nto;
    public TbImageView ntp;
    public TbImageView ntq;
    private MediaData[] ntr;
    private boolean nts;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < ntj.length; i++) {
                float[] fArr = ntj;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = ntk;
                fArr2[i] = fArr2[i] * sRatio;
            }
            ntl = (int) (ntl * sRatio);
            ntm = (int) (ntm * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.nts = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.nto = new TbImageView(context);
        this.ntp = new TbImageView(context);
        this.ntq = new TbImageView(context);
        this.nto.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ntp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ntq.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nto.setDefaultBg(drawable);
        this.ntp.setDefaultBg(drawable);
        this.ntq.setDefaultBg(drawable);
        addView(this.nto);
        addView(this.ntp);
        addView(this.ntq);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.nts = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.ntr = mediaDataArr;
        if (this.ntr == null || this.ntr.length <= 0) {
            if (this.nto != null) {
                this.nto.setTag(null);
            }
            if (this.ntp != null) {
                this.ntp.setTag(null);
            }
            if (this.ntq != null) {
                this.ntq.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.ntr.length;
        if (length == 1) {
            a(this.nto, this.ntr[0]);
            if (this.ntp != null) {
                this.ntp.setTag(null);
                this.ntp.setClickable(false);
            }
            if (this.ntq != null) {
                this.ntq.setTag(null);
                this.ntq.setClickable(false);
            }
        } else if (length == 2) {
            a(this.nto, this.ntr[0]);
            a(this.ntp, this.ntr[1]);
            if (this.ntq != null) {
                this.ntq.setTag(null);
                this.ntq.setClickable(false);
            }
        } else if (length == 3) {
            a(this.nto, this.ntr[0]);
            a(this.ntp, this.ntr[1]);
            a(this.ntq, this.ntr[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (ntn == 0) {
            ntn = i5;
        }
        if (this.ntr == null || this.ntr.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.nts) {
            setMeasuredDimension(ntn, (int) (ntk[this.ntr.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(ntn, (int) (ntk[4] + 0.5f));
        }
        switch (this.ntr.length) {
            case 1:
                if (this.nts) {
                    measureChild(this.nto, ntn + 1073741824, ((int) (ntk[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.nto, ((int) (ntj[4] + 0.5f)) + 1073741824, ((int) (ntk[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.ntp, 0, 0);
                measureChild(this.ntq, 0, 0);
                return;
            case 2:
                if (this.nts) {
                    i3 = ((int) (ntj[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (ntk[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (ntj[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (ntk[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.nto, i3, i4);
                measureChild(this.ntp, i3, i4);
                measureChild(this.ntq, 0, 0);
                return;
            case 3:
                if (this.nts) {
                    int i6 = ((int) (ntj[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (ntk[3] + 0.5f)) + 1073741824;
                    measureChild(this.nto, ((int) (ntj[2] + 0.5f)) + 1073741824, ((int) (ntk[2] + 0.5f)) + 1073741824);
                    measureChild(this.ntp, i6, i7);
                    measureChild(this.ntq, i6, i7);
                    return;
                }
                int i8 = ((int) (ntj[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (ntk[4] + 0.5f)) + 1073741824;
                measureChild(this.nto, i8, i9);
                measureChild(this.ntp, i8, i9);
                measureChild(this.ntq, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.ntr != null && this.ntr.length != 0) {
            switch (this.ntr.length) {
                case 1:
                    if (this.nts) {
                        int i5 = (int) (ntj[0] + 0.5f);
                        this.nto.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.nto.layout(this.mPadding, 0, ((int) (ntj[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.ntp.layout(0, 0, 0, 0);
                    this.ntq.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.nts) {
                        int i6 = (int) (ntj[1] + 0.5f);
                        this.nto.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.ntp.layout(i6 + this.mPadding + ntm, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (ntj[4] + 0.5f);
                        this.nto.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.ntp.layout(this.mPadding + i7 + ntl, 0, (i7 * 2) + this.mPadding + ntl, i4 - i2);
                    }
                    this.ntq.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.nts) {
                        int i8 = (int) (ntj[2] + 0.5f);
                        int i9 = (int) (ntj[3] + 0.5f);
                        this.nto.layout(0, 0, i8, i4 - i2);
                        this.ntp.layout(ntl + i8, 0, i3, i9);
                        this.ntq.layout(i8 + ntl, i9 + ntl, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (ntj[4] + 0.5f);
                    this.nto.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.ntp.layout(this.mPadding + i10 + ntl, 0, (i10 * 2) + this.mPadding + ntl, i4 - i2);
                    this.ntq.layout((i10 * 2) + this.mPadding + (ntl * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ntr != null && this.ntr.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.ntr.length) {
                case 1:
                    drawChild(canvas, this.nto, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.nto, drawingTime);
                    drawChild(canvas, this.ntp, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.nto, drawingTime);
                    drawChild(canvas, this.ntp, drawingTime);
                    drawChild(canvas, this.ntq, drawingTime);
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
