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
    private static float[] nog = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] noh = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int noi = 2;
    private static int noj = 4;
    private static int nok = 0;
    public static float sRatio = -1.0f;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;
    public TbImageView nol;
    public TbImageView nom;
    public TbImageView non;
    private MediaData[] noo;
    private boolean nop;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.getEquipmentWidth(this.mContext) / 320.0f;
            for (int i = 0; i < nog.length; i++) {
                float[] fArr = nog;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = noh;
                fArr2[i] = fArr2[i] * sRatio;
            }
            noi = (int) (noi * sRatio);
            noj = (int) (noj * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.nop = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = ao.getDrawable(R.color.common_color_10220);
        this.nol = new TbImageView(context);
        this.nom = new TbImageView(context);
        this.non = new TbImageView(context);
        this.nol.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nom.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.non.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.nol.setDefaultBg(drawable);
        this.nom.setDefaultBg(drawable);
        this.non.setDefaultBg(drawable);
        addView(this.nol);
        addView(this.nom);
        addView(this.non);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.nop = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.noo = mediaDataArr;
        if (this.noo == null || this.noo.length <= 0) {
            if (this.nol != null) {
                this.nol.setTag(null);
            }
            if (this.nom != null) {
                this.nom.setTag(null);
            }
            if (this.non != null) {
                this.non.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.noo.length;
        if (length == 1) {
            a(this.nol, this.noo[0]);
            if (this.nom != null) {
                this.nom.setTag(null);
                this.nom.setClickable(false);
            }
            if (this.non != null) {
                this.non.setTag(null);
                this.non.setClickable(false);
            }
        } else if (length == 2) {
            a(this.nol, this.noo[0]);
            a(this.nom, this.noo[1]);
            if (this.non != null) {
                this.non.setTag(null);
                this.non.setClickable(false);
            }
        } else if (length == 3) {
            a(this.nol, this.noo[0]);
            a(this.nom, this.noo[1]);
            a(this.non, this.noo[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (nok == 0) {
            nok = i5;
        }
        if (this.noo == null || this.noo.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.nop) {
            setMeasuredDimension(nok, (int) (noh[this.noo.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(nok, (int) (noh[4] + 0.5f));
        }
        switch (this.noo.length) {
            case 1:
                if (this.nop) {
                    measureChild(this.nol, nok + 1073741824, ((int) (noh[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.nol, ((int) (nog[4] + 0.5f)) + 1073741824, ((int) (noh[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.nom, 0, 0);
                measureChild(this.non, 0, 0);
                return;
            case 2:
                if (this.nop) {
                    i3 = ((int) (nog[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (noh[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (nog[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (noh[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.nol, i3, i4);
                measureChild(this.nom, i3, i4);
                measureChild(this.non, 0, 0);
                return;
            case 3:
                if (this.nop) {
                    int i6 = ((int) (nog[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (noh[3] + 0.5f)) + 1073741824;
                    measureChild(this.nol, ((int) (nog[2] + 0.5f)) + 1073741824, ((int) (noh[2] + 0.5f)) + 1073741824);
                    measureChild(this.nom, i6, i7);
                    measureChild(this.non, i6, i7);
                    return;
                }
                int i8 = ((int) (nog[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (noh[4] + 0.5f)) + 1073741824;
                measureChild(this.nol, i8, i9);
                measureChild(this.nom, i8, i9);
                measureChild(this.non, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.noo != null && this.noo.length != 0) {
            switch (this.noo.length) {
                case 1:
                    if (this.nop) {
                        int i5 = (int) (nog[0] + 0.5f);
                        this.nol.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.nol.layout(this.mPadding, 0, ((int) (nog[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.nom.layout(0, 0, 0, 0);
                    this.non.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.nop) {
                        int i6 = (int) (nog[1] + 0.5f);
                        this.nol.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.nom.layout(i6 + this.mPadding + noj, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (nog[4] + 0.5f);
                        this.nol.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.nom.layout(this.mPadding + i7 + noi, 0, (i7 * 2) + this.mPadding + noi, i4 - i2);
                    }
                    this.non.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.nop) {
                        int i8 = (int) (nog[2] + 0.5f);
                        int i9 = (int) (nog[3] + 0.5f);
                        this.nol.layout(0, 0, i8, i4 - i2);
                        this.nom.layout(noi + i8, 0, i3, i9);
                        this.non.layout(i8 + noi, i9 + noi, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (nog[4] + 0.5f);
                    this.nol.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.nom.layout(this.mPadding + i10 + noi, 0, (i10 * 2) + this.mPadding + noi, i4 - i2);
                    this.non.layout((i10 * 2) + this.mPadding + (noi * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.noo != null && this.noo.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.noo.length) {
                case 1:
                    drawChild(canvas, this.nol, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.nol, drawingTime);
                    drawChild(canvas, this.nom, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.nol, drawingTime);
                    drawChild(canvas, this.nom, drawingTime);
                    drawChild(canvas, this.non, drawingTime);
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
