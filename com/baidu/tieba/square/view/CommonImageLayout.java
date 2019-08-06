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
/* loaded from: classes5.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] jdh = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] jdi = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int jdj = 2;
    private static int jdk = 4;
    private static int jdl = 0;
    public static float sRatio = -1.0f;
    public TbImageView jdm;
    public TbImageView jdn;
    public TbImageView jdo;
    private MediaData[] jdp;
    private boolean jdq;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.af(this.mContext) / 320.0f;
            for (int i = 0; i < jdh.length; i++) {
                float[] fArr = jdh;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = jdi;
                fArr2[i] = fArr2[i] * sRatio;
            }
            jdj = (int) (jdj * sRatio);
            jdk = (int) (jdk * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.jdq = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.jdm = new TbImageView(context);
        this.jdn = new TbImageView(context);
        this.jdo = new TbImageView(context);
        this.jdm.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdn.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jdm.setDefaultBg(drawable);
        this.jdn.setDefaultBg(drawable);
        this.jdo.setDefaultBg(drawable);
        addView(this.jdm);
        addView(this.jdn);
        addView(this.jdo);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.jdq = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.jdp = mediaDataArr;
        if (this.jdp == null || this.jdp.length <= 0) {
            if (this.jdm != null) {
                this.jdm.setTag(null);
            }
            if (this.jdn != null) {
                this.jdn.setTag(null);
            }
            if (this.jdo != null) {
                this.jdo.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.jdp.length;
        if (length == 1) {
            a(this.jdm, this.jdp[0]);
            if (this.jdn != null) {
                this.jdn.setTag(null);
                this.jdn.setClickable(false);
            }
            if (this.jdo != null) {
                this.jdo.setTag(null);
                this.jdo.setClickable(false);
            }
        } else if (length == 2) {
            a(this.jdm, this.jdp[0]);
            a(this.jdn, this.jdp[1]);
            if (this.jdo != null) {
                this.jdo.setTag(null);
                this.jdo.setClickable(false);
            }
        } else if (length == 3) {
            a(this.jdm, this.jdp[0]);
            a(this.jdn, this.jdp[1]);
            a(this.jdo, this.jdp[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (jdl == 0) {
            jdl = i5;
        }
        if (this.jdp == null || this.jdp.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.jdq) {
            setMeasuredDimension(jdl, (int) (jdi[this.jdp.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(jdl, (int) (jdi[4] + 0.5f));
        }
        switch (this.jdp.length) {
            case 1:
                if (this.jdq) {
                    measureChild(this.jdm, jdl + 1073741824, ((int) (jdi[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.jdm, ((int) (jdh[4] + 0.5f)) + 1073741824, ((int) (jdi[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.jdn, 0, 0);
                measureChild(this.jdo, 0, 0);
                return;
            case 2:
                if (this.jdq) {
                    i3 = ((int) (jdh[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (jdi[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (jdh[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (jdi[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.jdm, i3, i4);
                measureChild(this.jdn, i3, i4);
                measureChild(this.jdo, 0, 0);
                return;
            case 3:
                if (this.jdq) {
                    int i6 = ((int) (jdh[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (jdi[3] + 0.5f)) + 1073741824;
                    measureChild(this.jdm, ((int) (jdh[2] + 0.5f)) + 1073741824, ((int) (jdi[2] + 0.5f)) + 1073741824);
                    measureChild(this.jdn, i6, i7);
                    measureChild(this.jdo, i6, i7);
                    return;
                }
                int i8 = ((int) (jdh[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (jdi[4] + 0.5f)) + 1073741824;
                measureChild(this.jdm, i8, i9);
                measureChild(this.jdn, i8, i9);
                measureChild(this.jdo, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jdp != null && this.jdp.length != 0) {
            switch (this.jdp.length) {
                case 1:
                    if (this.jdq) {
                        int i5 = (int) (jdh[0] + 0.5f);
                        this.jdm.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.jdm.layout(this.mPadding, 0, ((int) (jdh[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.jdn.layout(0, 0, 0, 0);
                    this.jdo.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.jdq) {
                        int i6 = (int) (jdh[1] + 0.5f);
                        this.jdm.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.jdn.layout(i6 + this.mPadding + jdk, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (jdh[4] + 0.5f);
                        this.jdm.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.jdn.layout(this.mPadding + i7 + jdj, 0, (i7 * 2) + this.mPadding + jdj, i4 - i2);
                    }
                    this.jdo.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.jdq) {
                        int i8 = (int) (jdh[2] + 0.5f);
                        int i9 = (int) (jdh[3] + 0.5f);
                        this.jdm.layout(0, 0, i8, i4 - i2);
                        this.jdn.layout(jdj + i8, 0, i3, i9);
                        this.jdo.layout(i8 + jdj, i9 + jdj, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (jdh[4] + 0.5f);
                    this.jdm.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.jdn.layout(this.mPadding + i10 + jdj, 0, (i10 * 2) + this.mPadding + jdj, i4 - i2);
                    this.jdo.layout((i10 * 2) + this.mPadding + (jdj * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jdp != null && this.jdp.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.jdp.length) {
                case 1:
                    drawChild(canvas, this.jdm, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.jdm, drawingTime);
                    drawChild(canvas, this.jdn, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.jdm, drawingTime);
                    drawChild(canvas, this.jdn, drawingTime);
                    drawChild(canvas, this.jdo, drawingTime);
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
                        com.baidu.tbadk.browser.a.ae(CommonImageLayout.this.mContext, mediaData.getVideoUrl());
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
