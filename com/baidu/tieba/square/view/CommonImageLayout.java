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
    private static float[] mUA = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] mUB = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int mUC = 2;
    private static int mUD = 4;
    private static int mUE = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView mUF;
    public TbImageView mUG;
    public TbImageView mUH;
    private MediaData[] mUI;
    private boolean mUJ;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < mUA.length; i++) {
                float[] fArr = mUA;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = mUB;
                fArr2[i] = fArr2[i] * sRatio;
            }
            mUC = (int) (mUC * sRatio);
            mUD = (int) (mUD * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.mUJ = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ap.getDrawable(R.color.common_color_10220);
        this.mUF = new TbImageView(context);
        this.mUG = new TbImageView(context);
        this.mUH = new TbImageView(context);
        this.mUF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mUG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mUH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mUF.setDefaultBg(drawable);
        this.mUG.setDefaultBg(drawable);
        this.mUH.setDefaultBg(drawable);
        addView(this.mUF);
        addView(this.mUG);
        addView(this.mUH);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.mUJ = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.mUI = mediaDataArr;
        if (this.mUI == null || this.mUI.length <= 0) {
            if (this.mUF != null) {
                this.mUF.setTag(null);
            }
            if (this.mUG != null) {
                this.mUG.setTag(null);
            }
            if (this.mUH != null) {
                this.mUH.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.mUI.length;
        if (length == 1) {
            a(this.mUF, this.mUI[0]);
            if (this.mUG != null) {
                this.mUG.setTag(null);
                this.mUG.setClickable(false);
            }
            if (this.mUH != null) {
                this.mUH.setTag(null);
                this.mUH.setClickable(false);
            }
        } else if (length == 2) {
            a(this.mUF, this.mUI[0]);
            a(this.mUG, this.mUI[1]);
            if (this.mUH != null) {
                this.mUH.setTag(null);
                this.mUH.setClickable(false);
            }
        } else if (length == 3) {
            a(this.mUF, this.mUI[0]);
            a(this.mUG, this.mUI[1]);
            a(this.mUH, this.mUI[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (mUE == 0) {
            mUE = i5;
        }
        if (this.mUI == null || this.mUI.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.mUJ) {
            setMeasuredDimension(mUE, (int) (mUB[this.mUI.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(mUE, (int) (mUB[4] + 0.5f));
        }
        switch (this.mUI.length) {
            case 1:
                if (this.mUJ) {
                    measureChild(this.mUF, mUE + 1073741824, ((int) (mUB[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.mUF, ((int) (mUA[4] + 0.5f)) + 1073741824, ((int) (mUB[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.mUG, 0, 0);
                measureChild(this.mUH, 0, 0);
                return;
            case 2:
                if (this.mUJ) {
                    i3 = ((int) (mUA[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (mUB[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (mUA[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (mUB[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.mUF, i3, i4);
                measureChild(this.mUG, i3, i4);
                measureChild(this.mUH, 0, 0);
                return;
            case 3:
                if (this.mUJ) {
                    int i6 = ((int) (mUA[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (mUB[3] + 0.5f)) + 1073741824;
                    measureChild(this.mUF, ((int) (mUA[2] + 0.5f)) + 1073741824, ((int) (mUB[2] + 0.5f)) + 1073741824);
                    measureChild(this.mUG, i6, i7);
                    measureChild(this.mUH, i6, i7);
                    return;
                }
                int i8 = ((int) (mUA[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (mUB[4] + 0.5f)) + 1073741824;
                measureChild(this.mUF, i8, i9);
                measureChild(this.mUG, i8, i9);
                measureChild(this.mUH, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mUI != null && this.mUI.length != 0) {
            switch (this.mUI.length) {
                case 1:
                    if (this.mUJ) {
                        int i5 = (int) (mUA[0] + 0.5f);
                        this.mUF.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.mUF.layout(this.mPadding, 0, ((int) (mUA[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.mUG.layout(0, 0, 0, 0);
                    this.mUH.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.mUJ) {
                        int i6 = (int) (mUA[1] + 0.5f);
                        this.mUF.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.mUG.layout(i6 + this.mPadding + mUD, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (mUA[4] + 0.5f);
                        this.mUF.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.mUG.layout(this.mPadding + i7 + mUC, 0, (i7 * 2) + this.mPadding + mUC, i4 - i2);
                    }
                    this.mUH.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.mUJ) {
                        int i8 = (int) (mUA[2] + 0.5f);
                        int i9 = (int) (mUA[3] + 0.5f);
                        this.mUF.layout(0, 0, i8, i4 - i2);
                        this.mUG.layout(mUC + i8, 0, i3, i9);
                        this.mUH.layout(i8 + mUC, i9 + mUC, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (mUA[4] + 0.5f);
                    this.mUF.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.mUG.layout(this.mPadding + i10 + mUC, 0, (i10 * 2) + this.mPadding + mUC, i4 - i2);
                    this.mUH.layout((i10 * 2) + this.mPadding + (mUC * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.mUI != null && this.mUI.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.mUI.length) {
                case 1:
                    drawChild(canvas, this.mUF, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.mUF, drawingTime);
                    drawChild(canvas, this.mUG, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.mUF, drawingTime);
                    drawChild(canvas, this.mUG, drawingTime);
                    drawChild(canvas, this.mUH, drawingTime);
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
