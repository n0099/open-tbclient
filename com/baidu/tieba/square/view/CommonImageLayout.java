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
    private static float[] jcd = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] jce = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int jcf = 2;
    private static int jcg = 4;
    private static int jch = 0;
    public static float sRatio = -1.0f;
    public TbImageView jci;
    public TbImageView jcj;
    public TbImageView jck;
    private MediaData[] jcl;
    private boolean jcm;
    private final Context mContext;
    private boolean mIsFromCDN;
    private int mPadding;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void initData() {
        if (sRatio < 0.0f) {
            sRatio = l.af(this.mContext) / 320.0f;
            for (int i = 0; i < jcd.length; i++) {
                float[] fArr = jcd;
                fArr[i] = fArr[i] * sRatio;
                float[] fArr2 = jce;
                fArr2[i] = fArr2[i] * sRatio;
            }
            jcf = (int) (jcf * sRatio);
            jcg = (int) (jcg * sRatio);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPadding = 7;
        this.jcm = false;
        this.mIsFromCDN = false;
        this.mContext = context;
        initData();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = am.getDrawable(R.color.common_color_10220);
        this.jci = new TbImageView(context);
        this.jcj = new TbImageView(context);
        this.jck = new TbImageView(context);
        this.jci.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jcj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jck.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jci.setDefaultBg(drawable);
        this.jcj.setDefaultBg(drawable);
        this.jck.setDefaultBg(drawable);
        addView(this.jci);
        addView(this.jcj);
        addView(this.jck);
        this.mPadding = (int) (this.mPadding * sRatio);
    }

    public void setShowBig(boolean z) {
        this.jcm = z;
    }

    public void setData(MediaData[] mediaDataArr) {
        this.jcl = mediaDataArr;
        if (this.jcl == null || this.jcl.length <= 0) {
            if (this.jci != null) {
                this.jci.setTag(null);
            }
            if (this.jcj != null) {
                this.jcj.setTag(null);
            }
            if (this.jck != null) {
                this.jck.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.jcl.length;
        if (length == 1) {
            a(this.jci, this.jcl[0]);
            if (this.jcj != null) {
                this.jcj.setTag(null);
                this.jcj.setClickable(false);
            }
            if (this.jck != null) {
                this.jck.setTag(null);
                this.jck.setClickable(false);
            }
        } else if (length == 2) {
            a(this.jci, this.jcl[0]);
            a(this.jcj, this.jcl[1]);
            if (this.jck != null) {
                this.jck.setTag(null);
                this.jck.setClickable(false);
            }
        } else if (length == 3) {
            a(this.jci, this.jcl[0]);
            a(this.jcj, this.jcl[1]);
            a(this.jck, this.jcl[2]);
        }
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 1073741823 & i;
        if (jch == 0) {
            jch = i5;
        }
        if (this.jcl == null || this.jcl.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.jcm) {
            setMeasuredDimension(jch, (int) (jce[this.jcl.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(jch, (int) (jce[4] + 0.5f));
        }
        switch (this.jcl.length) {
            case 1:
                if (this.jcm) {
                    measureChild(this.jci, jch + 1073741824, ((int) (jce[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.jci, ((int) (jcd[4] + 0.5f)) + 1073741824, ((int) (jce[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.jcj, 0, 0);
                measureChild(this.jck, 0, 0);
                return;
            case 2:
                if (this.jcm) {
                    i3 = ((int) (jcd[1] + 0.5f)) + 1073741824;
                    i4 = ((int) (jce[1] + 0.5f)) + 1073741824;
                } else {
                    i3 = ((int) (jcd[4] + 0.5f)) + 1073741824;
                    i4 = ((int) (jce[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.jci, i3, i4);
                measureChild(this.jcj, i3, i4);
                measureChild(this.jck, 0, 0);
                return;
            case 3:
                if (this.jcm) {
                    int i6 = ((int) (jcd[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (jce[3] + 0.5f)) + 1073741824;
                    measureChild(this.jci, ((int) (jcd[2] + 0.5f)) + 1073741824, ((int) (jce[2] + 0.5f)) + 1073741824);
                    measureChild(this.jcj, i6, i7);
                    measureChild(this.jck, i6, i7);
                    return;
                }
                int i8 = ((int) (jcd[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (jce[4] + 0.5f)) + 1073741824;
                measureChild(this.jci, i8, i9);
                measureChild(this.jcj, i8, i9);
                measureChild(this.jck, i8, i9);
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jcl != null && this.jcl.length != 0) {
            switch (this.jcl.length) {
                case 1:
                    if (this.jcm) {
                        int i5 = (int) (jcd[0] + 0.5f);
                        this.jci.layout(0, 0, i3, i4 - i2);
                    } else {
                        this.jci.layout(this.mPadding, 0, ((int) (jcd[4] + 0.5f)) + this.mPadding, i4 - i2);
                    }
                    this.jcj.layout(0, 0, 0, 0);
                    this.jck.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.jcm) {
                        int i6 = (int) (jcd[1] + 0.5f);
                        this.jci.layout(this.mPadding, 0, this.mPadding + i6, i4 - i2);
                        this.jcj.layout(i6 + this.mPadding + jcg, 0, (i3 - this.mPadding) - i, i4 - i2);
                    } else {
                        int i7 = (int) (jcd[4] + 0.5f);
                        this.jci.layout(this.mPadding, 0, this.mPadding + i7, i4 - i2);
                        this.jcj.layout(this.mPadding + i7 + jcf, 0, (i7 * 2) + this.mPadding + jcf, i4 - i2);
                    }
                    this.jck.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.jcm) {
                        int i8 = (int) (jcd[2] + 0.5f);
                        int i9 = (int) (jcd[3] + 0.5f);
                        this.jci.layout(0, 0, i8, i4 - i2);
                        this.jcj.layout(jcf + i8, 0, i3, i9);
                        this.jck.layout(i8 + jcf, i9 + jcf, i3, i4 - i2);
                        return;
                    }
                    int i10 = (int) (jcd[4] + 0.5f);
                    this.jci.layout(this.mPadding, 0, this.mPadding + i10, i4 - i2);
                    this.jcj.layout(this.mPadding + i10 + jcf, 0, (i10 * 2) + this.mPadding + jcf, i4 - i2);
                    this.jck.layout((i10 * 2) + this.mPadding + (jcf * 2), 0, (i3 - this.mPadding) - i, i4 - i2);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jcl != null && this.jcl.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.jcl.length) {
                case 1:
                    drawChild(canvas, this.jci, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.jci, drawingTime);
                    drawChild(canvas, this.jcj, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.jci, drawingTime);
                    drawChild(canvas, this.jcj, drawingTime);
                    drawChild(canvas, this.jck, drawingTime);
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
