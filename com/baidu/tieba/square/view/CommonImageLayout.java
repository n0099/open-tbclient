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
    private static float[] jft = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] jfu = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int jfv = 2;
    private static int jfw = 4;
    private static int jfx = 0;
    public static float sRatio = -1.0f;
    public TbImageView jfA;
    private MediaData[] jfB;
    private boolean jfC;
    public TbImageView jfy;
    public TbImageView jfz;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < jft.length; i++) {
                float[] fArr = jft;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = jfu;
                fArr2[i] = fArr2[i] * sRatio;
            }
            jfv = (int) (jfv * sRatio);
            jfw = (int) (jfw * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.jfC = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.jfy = new TbImageView(context);
        this.jfz = new TbImageView(context);
        this.jfA = new TbImageView(context);
        this.jfy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jfz.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jfA.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jfy.setDefaultBg(drawable);
        this.jfz.setDefaultBg(drawable);
        this.jfA.setDefaultBg(drawable);
        addView(this.jfy);
        addView(this.jfz);
        addView(this.jfA);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.jfC = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.jfB = mediaDataArr;
        if (this.jfB == null || this.jfB.length <= 0) {
            if (this.jfy != null) {
                this.jfy.setTag(null);
            }
            if (this.jfz != null) {
                this.jfz.setTag(null);
            }
            if (this.jfA != null) {
                this.jfA.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.jfB.length;
        if (length == 1) {
            a(this.jfy, this.jfB[0]);
            if (this.jfz != null) {
                this.jfz.setTag(null);
                this.jfz.setClickable(false);
            }
            if (this.jfA != null) {
                this.jfA.setTag(null);
                this.jfA.setClickable(false);
            }
        } else if (length == 2) {
            a(this.jfy, this.jfB[0]);
            a(this.jfz, this.jfB[1]);
            if (this.jfA != null) {
                this.jfA.setTag(null);
                this.jfA.setClickable(false);
            }
        } else if (length == 3) {
            a(this.jfy, this.jfB[0]);
            a(this.jfz, this.jfB[1]);
            a(this.jfA, this.jfB[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (jfx == 0) {
            jfx = i5;
        }
        if (this.jfB == null || this.jfB.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.jfC) {
            setMeasuredDimension(jfx, (int) (jfu[this.jfB.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(jfx, (int) (jfu[4] + 0.5f));
        }
        switch (this.jfB.length) {
            case 1:
                if (this.jfC) {
                    measureChild(this.jfy, jfx + 1073741824, ((int) (jfu[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.jfy, ((int) (jft[4] + 0.5f)) + 1073741824, ((int) (jfu[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.jfz, 0, 0);
                measureChild(this.jfA, 0, 0);
                return;
            case 2:
                if (this.jfC) {
                    i3 = ((int) (jft[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (jfu[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (jft[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (jfu[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.jfy, i3, i4);
                measureChild(this.jfz, i3, i4);
                measureChild(this.jfA, 0, 0);
                return;
            case 3:
                if (this.jfC) {
                    int i6 = ((int) (jft[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (jfu[3] + 0.5f)) + 1073741824;
                    measureChild(this.jfy, ((int) (jft[2] + 0.5f)) + 1073741824, ((int) (jfu[2] + 0.5f)) + 1073741824);
                    measureChild(this.jfz, i6, i7);
                    measureChild(this.jfA, i6, i7);
                    return;
                }
                int i8 = ((int) (jft[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (jfu[4] + 0.5f)) + 1073741824;
                measureChild(this.jfy, i8, i9);
                measureChild(this.jfz, i8, i9);
                measureChild(this.jfA, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jfB != null && this.jfB.length != 0) {
            switch (this.jfB.length) {
                case 1:
                    if (this.jfC) {
                        int i5 = (int) (jft[0] + 0.5f);
                        this.jfy.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.jfy.layout(this.mPadding, 0, ((int) (jft[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.jfz.layout(0, 0, 0, 0);
                    this.jfA.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.jfC) {
                        int i6 = (int) (jft[1] + 0.5f);
                        this.jfy.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.jfz.layout(i6 + this.mPadding + jfw, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (jft[4] + 0.5f);
                        this.jfy.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.jfz.layout(this.mPadding + i7 + jfv, 0, (i7 * 2) + this.mPadding + jfv, i4 - i2);
                    }
                    this.jfA.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.jfC) {
                        int i8 = (int) (jft[2] + 0.5f);
                        int i9 = (int) (jft[3] + 0.5f);
                        this.jfy.layout(0, 0, i8, i4 - i2);
                        this.jfz.layout(jfv + i8, 0, i3, i9);
                        this.jfA.layout(i8 + jfv, i9 + jfv, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (jft[4] + 0.5f);
                    this.jfy.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.jfz.layout(this.mPadding + i10 + jfv, 0, (i10 * 2) + this.mPadding + jfv, i4 - i2);
                    this.jfA.layout((i10 * 2) + this.mPadding + (jfv * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jfB != null && this.jfB.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.jfB.length) {
                case 1:
                    drawChild(canvas, this.jfy, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.jfy, drawingTime);
                    drawChild(canvas, this.jfz, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.jfy, drawingTime);
                    drawChild(canvas, this.jfz, drawingTime);
                    drawChild(canvas, this.jfA, drawingTime);
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
