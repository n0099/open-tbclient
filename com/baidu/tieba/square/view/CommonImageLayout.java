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
    private static float[] jfC = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] jfD = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int jfE = 2;
    private static int jfF = 4;
    private static int jfG = 0;
    public static float sRatio = -1.0f;
    public TbImageView jfH;
    public TbImageView jfI;
    public TbImageView jfJ;
    private MediaData[] jfK;
    private boolean jfL;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.af(this.mContext) / 320.0f;
            for (int i = 0; i < jfC.length; i++) {
                float[] fArr = jfC;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = jfD;
                fArr2[i] = fArr2[i] * sRatio;
            }
            jfE = (int) (jfE * sRatio);
            jfF = (int) (jfF * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.jfL = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.jfH = new TbImageView(context);
        this.jfI = new TbImageView(context);
        this.jfJ = new TbImageView(context);
        this.jfH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jfI.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jfJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jfH.setDefaultBg(drawable);
        this.jfI.setDefaultBg(drawable);
        this.jfJ.setDefaultBg(drawable);
        addView(this.jfH);
        addView(this.jfI);
        addView(this.jfJ);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.jfL = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.jfK = mediaDataArr;
        if (this.jfK == null || this.jfK.length <= 0) {
            if (this.jfH != null) {
                this.jfH.setTag(null);
            }
            if (this.jfI != null) {
                this.jfI.setTag(null);
            }
            if (this.jfJ != null) {
                this.jfJ.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.jfK.length;
        if (length == 1) {
            a(this.jfH, this.jfK[0]);
            if (this.jfI != null) {
                this.jfI.setTag(null);
                this.jfI.setClickable(false);
            }
            if (this.jfJ != null) {
                this.jfJ.setTag(null);
                this.jfJ.setClickable(false);
            }
        } else if (length == 2) {
            a(this.jfH, this.jfK[0]);
            a(this.jfI, this.jfK[1]);
            if (this.jfJ != null) {
                this.jfJ.setTag(null);
                this.jfJ.setClickable(false);
            }
        } else if (length == 3) {
            a(this.jfH, this.jfK[0]);
            a(this.jfI, this.jfK[1]);
            a(this.jfJ, this.jfK[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (jfG == 0) {
            jfG = i5;
        }
        if (this.jfK == null || this.jfK.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.jfL) {
            setMeasuredDimension(jfG, (int) (jfD[this.jfK.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(jfG, (int) (jfD[4] + 0.5f));
        }
        switch (this.jfK.length) {
            case 1:
                if (this.jfL) {
                    measureChild(this.jfH, jfG + 1073741824, ((int) (jfD[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.jfH, ((int) (jfC[4] + 0.5f)) + 1073741824, ((int) (jfD[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.jfI, 0, 0);
                measureChild(this.jfJ, 0, 0);
                return;
            case 2:
                if (this.jfL) {
                    i3 = ((int) (jfC[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (jfD[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (jfC[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (jfD[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.jfH, i3, i4);
                measureChild(this.jfI, i3, i4);
                measureChild(this.jfJ, 0, 0);
                return;
            case 3:
                if (this.jfL) {
                    int i6 = ((int) (jfC[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (jfD[3] + 0.5f)) + 1073741824;
                    measureChild(this.jfH, ((int) (jfC[2] + 0.5f)) + 1073741824, ((int) (jfD[2] + 0.5f)) + 1073741824);
                    measureChild(this.jfI, i6, i7);
                    measureChild(this.jfJ, i6, i7);
                    return;
                }
                int i8 = ((int) (jfC[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (jfD[4] + 0.5f)) + 1073741824;
                measureChild(this.jfH, i8, i9);
                measureChild(this.jfI, i8, i9);
                measureChild(this.jfJ, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jfK != null && this.jfK.length != 0) {
            switch (this.jfK.length) {
                case 1:
                    if (this.jfL) {
                        int i5 = (int) (jfC[0] + 0.5f);
                        this.jfH.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.jfH.layout(this.mPadding, 0, ((int) (jfC[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.jfI.layout(0, 0, 0, 0);
                    this.jfJ.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.jfL) {
                        int i6 = (int) (jfC[1] + 0.5f);
                        this.jfH.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.jfI.layout(i6 + this.mPadding + jfF, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (jfC[4] + 0.5f);
                        this.jfH.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.jfI.layout(this.mPadding + i7 + jfE, 0, (i7 * 2) + this.mPadding + jfE, i4 - i2);
                    }
                    this.jfJ.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.jfL) {
                        int i8 = (int) (jfC[2] + 0.5f);
                        int i9 = (int) (jfC[3] + 0.5f);
                        this.jfH.layout(0, 0, i8, i4 - i2);
                        this.jfI.layout(jfE + i8, 0, i3, i9);
                        this.jfJ.layout(i8 + jfE, i9 + jfE, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (jfC[4] + 0.5f);
                    this.jfH.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.jfI.layout(this.mPadding + i10 + jfE, 0, (i10 * 2) + this.mPadding + jfE, i4 - i2);
                    this.jfJ.layout((i10 * 2) + this.mPadding + (jfE * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jfK != null && this.jfK.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.jfK.length) {
                case 1:
                    drawChild(canvas, this.jfH, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.jfH, drawingTime);
                    drawChild(canvas, this.jfI, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.jfH, drawingTime);
                    drawChild(canvas, this.jfI, drawingTime);
                    drawChild(canvas, this.jfJ, drawingTime);
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
