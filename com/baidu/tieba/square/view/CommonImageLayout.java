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
    private static float[] iDi = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] iDj = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int iDk = 2;
    private static int iDl = 4;
    private static int iDm = 0;
    public static float sRatio = -1.0f;
    public TbImageView iDn;
    public TbImageView iDo;
    public TbImageView iDp;
    private MediaData[] iDq;
    private boolean iDr;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.aO(this.mContext) / 320.0f;
            for (int i = 0; i < iDi.length; i++) {
                float[] fArr = iDi;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = iDj;
                fArr2[i] = fArr2[i] * sRatio;
            }
            iDk = (int) (iDk * sRatio);
            iDl = (int) (iDl * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.iDr = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = al.getDrawable(d.C0277d.common_color_10220);
        this.iDn = new TbImageView(context);
        this.iDo = new TbImageView(context);
        this.iDp = new TbImageView(context);
        this.iDn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iDo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iDp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.iDn.setDefaultBg(drawable);
        this.iDo.setDefaultBg(drawable);
        this.iDp.setDefaultBg(drawable);
        addView(this.iDn);
        addView(this.iDo);
        addView(this.iDp);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.iDr = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.iDq = mediaDataArr;
        if (this.iDq == null || this.iDq.length <= 0) {
            if (this.iDn != null) {
                this.iDn.setTag(null);
            }
            if (this.iDo != null) {
                this.iDo.setTag(null);
            }
            if (this.iDp != null) {
                this.iDp.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.iDq.length;
        if (length == 1) {
            a(this.iDn, this.iDq[0]);
            if (this.iDo != null) {
                this.iDo.setTag(null);
                this.iDo.setClickable(false);
            }
            if (this.iDp != null) {
                this.iDp.setTag(null);
                this.iDp.setClickable(false);
            }
        } else if (length == 2) {
            a(this.iDn, this.iDq[0]);
            a(this.iDo, this.iDq[1]);
            if (this.iDp != null) {
                this.iDp.setTag(null);
                this.iDp.setClickable(false);
            }
        } else if (length == 3) {
            a(this.iDn, this.iDq[0]);
            a(this.iDo, this.iDq[1]);
            a(this.iDp, this.iDq[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (iDm == 0) {
            iDm = i5;
        }
        if (this.iDq == null || this.iDq.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.iDr) {
            setMeasuredDimension(iDm, (int) (iDj[this.iDq.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(iDm, (int) (iDj[4] + 0.5f));
        }
        switch (this.iDq.length) {
            case 1:
                if (this.iDr) {
                    measureChild(this.iDn, iDm + 1073741824, ((int) (iDj[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.iDn, ((int) (iDi[4] + 0.5f)) + 1073741824, ((int) (iDj[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.iDo, 0, 0);
                measureChild(this.iDp, 0, 0);
                return;
            case 2:
                if (this.iDr) {
                    i3 = ((int) (iDi[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (iDj[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (iDi[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (iDj[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.iDn, i3, i4);
                measureChild(this.iDo, i3, i4);
                measureChild(this.iDp, 0, 0);
                return;
            case 3:
                if (this.iDr) {
                    int i6 = ((int) (iDi[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (iDj[3] + 0.5f)) + 1073741824;
                    measureChild(this.iDn, ((int) (iDi[2] + 0.5f)) + 1073741824, ((int) (iDj[2] + 0.5f)) + 1073741824);
                    measureChild(this.iDo, i6, i7);
                    measureChild(this.iDp, i6, i7);
                    return;
                }
                int i8 = ((int) (iDi[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (iDj[4] + 0.5f)) + 1073741824;
                measureChild(this.iDn, i8, i9);
                measureChild(this.iDo, i8, i9);
                measureChild(this.iDp, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iDq != null && this.iDq.length != 0) {
            switch (this.iDq.length) {
                case 1:
                    if (this.iDr) {
                        int i5 = (int) (iDi[0] + 0.5f);
                        this.iDn.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.iDn.layout(this.mPadding, 0, ((int) (iDi[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.iDo.layout(0, 0, 0, 0);
                    this.iDp.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.iDr) {
                        int i6 = (int) (iDi[1] + 0.5f);
                        this.iDn.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.iDo.layout(i6 + this.mPadding + iDl, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (iDi[4] + 0.5f);
                        this.iDn.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.iDo.layout(this.mPadding + i7 + iDk, 0, (i7 * 2) + this.mPadding + iDk, i4 - i2);
                    }
                    this.iDp.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.iDr) {
                        int i8 = (int) (iDi[2] + 0.5f);
                        int i9 = (int) (iDi[3] + 0.5f);
                        this.iDn.layout(0, 0, i8, i4 - i2);
                        this.iDo.layout(iDk + i8, 0, i3, i9);
                        this.iDp.layout(i8 + iDk, i9 + iDk, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (iDi[4] + 0.5f);
                    this.iDn.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.iDo.layout(this.mPadding + i10 + iDk, 0, (i10 * 2) + this.mPadding + iDk, i4 - i2);
                    this.iDp.layout((i10 * 2) + this.mPadding + (iDk * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iDq != null && this.iDq.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.iDq.length) {
                case 1:
                    drawChild(canvas, this.iDn, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.iDn, drawingTime);
                    drawChild(canvas, this.iDo, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.iDn, drawingTime);
                    drawChild(canvas, this.iDo, drawingTime);
                    drawChild(canvas, this.iDp, drawingTime);
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
