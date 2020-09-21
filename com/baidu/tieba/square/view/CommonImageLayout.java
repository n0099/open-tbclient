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
/* loaded from: classes22.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] mls = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mlt = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mlu = 2;
    private static int mlv = 4;
    private static int mlw = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    private MediaData[] mlA;
    private boolean mlB;
    public TbImageView mlx;
    public TbImageView mly;
    public TbImageView mlz;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mls.length; i++) {
                float[] fArr = mls;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mlt;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mlu = (int) (mlu * sRatio);
            mlv = (int) (mlv * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mlB = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mlx = new TbImageView(context);
        this.mly = new TbImageView(context);
        this.mlz = new TbImageView(context);
        this.mlx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mly.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mlz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mlx.setDefaultBg(drawable);
        this.mly.setDefaultBg(drawable);
        this.mlz.setDefaultBg(drawable);
        addView(this.mlx);
        addView(this.mly);
        addView(this.mlz);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mlB = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mlA = mediaDataArr;
        if (this.mlA == null || this.mlA.length <= 0) {
            if (this.mlx != null) {
                this.mlx.setTag(null);
            }
            if (this.mly != null) {
                this.mly.setTag(null);
            }
            if (this.mlz != null) {
                this.mlz.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mlA.length;
        if (length == 1) {
            a(this.mlx, this.mlA[0]);
            if (this.mly != null) {
                this.mly.setTag(null);
                this.mly.setClickable(false);
            }
            if (this.mlz != null) {
                this.mlz.setTag(null);
                this.mlz.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mlx, this.mlA[0]);
            a(this.mly, this.mlA[1]);
            if (this.mlz != null) {
                this.mlz.setTag(null);
                this.mlz.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mlx, this.mlA[0]);
            a(this.mly, this.mlA[1]);
            a(this.mlz, this.mlA[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mlw == 0) {
            mlw = i5;
        }
        if (this.mlA == null || this.mlA.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mlB) {
            setMeasuredDimension(mlw, (int) (mlt[this.mlA.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mlw, (int) (mlt[4] + 0.5f));
        }
        switch (this.mlA.length) {
            case 1:
                if (this.mlB) {
                    measureChild(this.mlx, mlw + 1073741824, ((int) (mlt[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mlx, ((int) (mls[4] + 0.5f)) + 1073741824, ((int) (mlt[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mly, 0, 0);
                measureChild(this.mlz, 0, 0);
                return;
            case 2:
                if (this.mlB) {
                    i3 = ((int) (mls[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mlt[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mls[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mlt[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mlx, i3, i4);
                measureChild(this.mly, i3, i4);
                measureChild(this.mlz, 0, 0);
                return;
            case 3:
                if (this.mlB) {
                    int i6 = ((int) (mls[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mlt[3] + 0.5f)) + 1073741824;
                    measureChild(this.mlx, ((int) (mls[2] + 0.5f)) + 1073741824, ((int) (mlt[2] + 0.5f)) + 1073741824);
                    measureChild(this.mly, i6, i7);
                    measureChild(this.mlz, i6, i7);
                    return;
                }
                int i8 = ((int) (mls[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mlt[4] + 0.5f)) + 1073741824;
                measureChild(this.mlx, i8, i9);
                measureChild(this.mly, i8, i9);
                measureChild(this.mlz, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mlA != null && this.mlA.length != 0) {
            switch (this.mlA.length) {
                case 1:
                    if (this.mlB) {
                        int i5 = (int) (mls[0] + 0.5f);
                        this.mlx.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mlx.layout(this.mPadding, 0, ((int) (mls[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mly.layout(0, 0, 0, 0);
                    this.mlz.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mlB) {
                        int i6 = (int) (mls[1] + 0.5f);
                        this.mlx.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mly.layout(i6 + this.mPadding + mlv, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mls[4] + 0.5f);
                        this.mlx.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mly.layout(this.mPadding + i7 + mlu, 0, (i7 * 2) + this.mPadding + mlu, i4 - i2);
                    }
                    this.mlz.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mlB) {
                        int i8 = (int) (mls[2] + 0.5f);
                        int i9 = (int) (mls[3] + 0.5f);
                        this.mlx.layout(0, 0, i8, i4 - i2);
                        this.mly.layout(mlu + i8, 0, i3, i9);
                        this.mlz.layout(i8 + mlu, i9 + mlu, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mls[4] + 0.5f);
                    this.mlx.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mly.layout(this.mPadding + i10 + mlu, 0, (i10 * 2) + this.mPadding + mlu, i4 - i2);
                    this.mlz.layout((i10 * 2) + this.mPadding + (mlu * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mlA != null && this.mlA.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mlA.length) {
                case 1:
                    drawChild(canvas, this.mlx, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mlx, drawingTime);
                    drawChild(canvas, this.mly, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mlx, drawingTime);
                    drawChild(canvas, this.mly, drawingTime);
                    drawChild(canvas, this.mlz, drawingTime);
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
