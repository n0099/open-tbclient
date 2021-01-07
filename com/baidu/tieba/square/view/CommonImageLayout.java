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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CommonImageLayout extends ViewGroup {
    private static float[] nof = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] nog = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int noh = 2;
    private static int noi = 4;
    private static int noj = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView nok;
    public TbImageView nol;
    public TbImageView nom;
    private MediaData[] non;
    private boolean noo;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < nof.length; i++) {
                float[] fArr = nof;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = nog;
                fArr2[i] = fArr2[i] * sRatio;
            }
            noh = (int) (noh * sRatio);
            noi = (int) (noi * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.noo = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ao.getDrawable(R.color.common_color_10220);
        this.nok = new TbImageView(context);
        this.nol = new TbImageView(context);
        this.nom = new TbImageView(context);
        this.nok.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nol.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nom.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nok.setDefaultBg(drawable);
        this.nol.setDefaultBg(drawable);
        this.nom.setDefaultBg(drawable);
        addView(this.nok);
        addView(this.nol);
        addView(this.nom);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.noo = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.non = mediaDataArr;
        if (this.non == null || this.non.length <= 0) {
            if (this.nok != null) {
                this.nok.setTag(null);
            }
            if (this.nol != null) {
                this.nol.setTag(null);
            }
            if (this.nom != null) {
                this.nom.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.non.length;
        if (length == 1) {
            a(this.nok, this.non[0]);
            if (this.nol != null) {
                this.nol.setTag(null);
                this.nol.setClickable(false);
            }
            if (this.nom != null) {
                this.nom.setTag(null);
                this.nom.setClickable(false);
            }
        } else if (length == 2) {
            a(this.nok, this.non[0]);
            a(this.nol, this.non[1]);
            if (this.nom != null) {
                this.nom.setTag(null);
                this.nom.setClickable(false);
            }
        } else if (length == 3) {
            a(this.nok, this.non[0]);
            a(this.nol, this.non[1]);
            a(this.nom, this.non[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (noj == 0) {
            noj = i5;
        }
        if (this.non == null || this.non.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.noo) {
            setMeasuredDimension(noj, (int) (nog[this.non.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(noj, (int) (nog[4] + 0.5f));
        }
        switch (this.non.length) {
            case 1:
                if (this.noo) {
                    measureChild(this.nok, noj + 1073741824, ((int) (nog[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.nok, ((int) (nof[4] + 0.5f)) + 1073741824, ((int) (nog[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.nol, 0, 0);
                measureChild(this.nom, 0, 0);
                return;
            case 2:
                if (this.noo) {
                    i3 = ((int) (nof[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (nog[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (nof[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (nog[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.nok, i3, i4);
                measureChild(this.nol, i3, i4);
                measureChild(this.nom, 0, 0);
                return;
            case 3:
                if (this.noo) {
                    int i6 = ((int) (nof[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (nog[3] + 0.5f)) + 1073741824;
                    measureChild(this.nok, ((int) (nof[2] + 0.5f)) + 1073741824, ((int) (nog[2] + 0.5f)) + 1073741824);
                    measureChild(this.nol, i6, i7);
                    measureChild(this.nom, i6, i7);
                    return;
                }
                int i8 = ((int) (nof[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (nog[4] + 0.5f)) + 1073741824;
                measureChild(this.nok, i8, i9);
                measureChild(this.nol, i8, i9);
                measureChild(this.nom, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.non != null && this.non.length != 0) {
            switch (this.non.length) {
                case 1:
                    if (this.noo) {
                        int i5 = (int) (nof[0] + 0.5f);
                        this.nok.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.nok.layout(this.mPadding, 0, ((int) (nof[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.nol.layout(0, 0, 0, 0);
                    this.nom.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.noo) {
                        int i6 = (int) (nof[1] + 0.5f);
                        this.nok.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.nol.layout(i6 + this.mPadding + noi, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (nof[4] + 0.5f);
                        this.nok.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.nol.layout(this.mPadding + i7 + noh, 0, (i7 * 2) + this.mPadding + noh, i4 - i2);
                    }
                    this.nom.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.noo) {
                        int i8 = (int) (nof[2] + 0.5f);
                        int i9 = (int) (nof[3] + 0.5f);
                        this.nok.layout(0, 0, i8, i4 - i2);
                        this.nol.layout(noh + i8, 0, i3, i9);
                        this.nom.layout(i8 + noh, i9 + noh, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (nof[4] + 0.5f);
                    this.nok.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.nol.layout(this.mPadding + i10 + noh, 0, (i10 * 2) + this.mPadding + noh, i4 - i2);
                    this.nom.layout((i10 * 2) + this.mPadding + (noh * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.non != null && this.non.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.non.length) {
                case 1:
                    drawChild(canvas, this.nok, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.nok, drawingTime);
                    drawChild(canvas, this.nol, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.nok, drawingTime);
                    drawChild(canvas, this.nol, drawingTime);
                    drawChild(canvas, this.nom, drawingTime);
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
