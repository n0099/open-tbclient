package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes5.dex */
public class CommonImageLayout extends ViewGroup {
    public static float[] l = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    public static float[] m = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    public static int n = 2;
    public static int o = 4;
    public static int p = 0;
    public static float q = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f20881e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20882f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20883g;

    /* renamed from: h  reason: collision with root package name */
    public MediaData[] f20884h;

    /* renamed from: i  reason: collision with root package name */
    public int f20885i;
    public boolean j;
    public final Context k;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaData f20886e;

        public a(MediaData mediaData) {
            this.f20886e = mediaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.l.a.l(CommonImageLayout.this.k, this.f20886e.getVideoUrl());
        }
    }

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    public final void b() {
        if (q >= 0.0f) {
            return;
        }
        q = l.k(this.k) / 320.0f;
        int i2 = 0;
        while (true) {
            float[] fArr = l;
            if (i2 < fArr.length) {
                float f2 = fArr[i2];
                float f3 = q;
                fArr[i2] = f2 * f3;
                float[] fArr2 = m;
                fArr2[i2] = fArr2[i2] * f3;
                i2++;
            } else {
                float f4 = q;
                n = (int) (n * f4);
                o = (int) (o * f4);
                return;
            }
        }
    }

    public void c() {
    }

    public final void d(TbImageView tbImageView, MediaData mediaData) {
        if (tbImageView == null) {
            return;
        }
        String picUrl = mediaData.getPicUrl();
        if (mediaData.getType() == 5) {
            picUrl = null;
            tbImageView.setDefaultResource(R.drawable.pic_video);
            tbImageView.setOnClickListener(new a(mediaData));
        } else {
            tbImageView.setClickable(false);
        }
        tbImageView.setTag(picUrl);
        tbImageView.U(picUrl, 13, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr = this.f20884h;
        if (mediaDataArr == null || mediaDataArr.length == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        int length = this.f20884h.length;
        if (length == 1) {
            drawChild(canvas, this.f20881e, drawingTime);
        } else if (length == 2) {
            drawChild(canvas, this.f20881e, drawingTime);
            drawChild(canvas, this.f20882f, drawingTime);
        } else if (length != 3) {
        } else {
            drawChild(canvas, this.f20881e, drawingTime);
            drawChild(canvas, this.f20882f, drawingTime);
            drawChild(canvas, this.f20883g, drawingTime);
        }
    }

    public int getPadding() {
        return this.f20885i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        MediaData[] mediaDataArr = this.f20884h;
        if (mediaDataArr == null || mediaDataArr.length == 0) {
            return;
        }
        int length = mediaDataArr.length;
        if (length == 1) {
            if (this.j) {
                float f2 = l[0];
                this.f20881e.layout(0, 0, i4, i5 - i3);
            } else {
                TbImageView tbImageView = this.f20881e;
                int i6 = this.f20885i;
                tbImageView.layout(i6, 0, ((int) (l[4] + 0.5f)) + i6, i5 - i3);
            }
            this.f20882f.layout(0, 0, 0, 0);
            this.f20883g.layout(0, 0, 0, 0);
        } else if (length == 2) {
            if (this.j) {
                int i7 = (int) (l[1] + 0.5f);
                TbImageView tbImageView2 = this.f20881e;
                int i8 = this.f20885i;
                int i9 = i5 - i3;
                tbImageView2.layout(i8, 0, i8 + i7, i9);
                TbImageView tbImageView3 = this.f20882f;
                int i10 = this.f20885i;
                tbImageView3.layout(i7 + i10 + o, 0, (i4 - i10) - i2, i9);
            } else {
                int i11 = (int) (l[4] + 0.5f);
                TbImageView tbImageView4 = this.f20881e;
                int i12 = this.f20885i;
                int i13 = i5 - i3;
                tbImageView4.layout(i12, 0, i12 + i11, i13);
                TbImageView tbImageView5 = this.f20882f;
                int i14 = this.f20885i;
                int i15 = n;
                tbImageView5.layout(i14 + i11 + i15, 0, i14 + (i11 * 2) + i15, i13);
            }
            this.f20883g.layout(0, 0, 0, 0);
        } else if (length != 3) {
        } else {
            if (this.j) {
                float[] fArr = l;
                int i16 = (int) (fArr[2] + 0.5f);
                int i17 = (int) (fArr[3] + 0.5f);
                int i18 = i5 - i3;
                this.f20881e.layout(0, 0, i16, i18);
                this.f20882f.layout(n + i16, 0, i4, i17);
                TbImageView tbImageView6 = this.f20883g;
                int i19 = n;
                tbImageView6.layout(i16 + i19, i17 + i19, i4, i18);
                return;
            }
            int i20 = (int) (l[4] + 0.5f);
            TbImageView tbImageView7 = this.f20881e;
            int i21 = this.f20885i;
            int i22 = i5 - i3;
            tbImageView7.layout(i21, 0, i20 + i21, i22);
            TbImageView tbImageView8 = this.f20882f;
            int i23 = this.f20885i;
            int i24 = n;
            int i25 = i20 * 2;
            tbImageView8.layout(i20 + i23 + i24, 0, i23 + i25 + i24, i22);
            TbImageView tbImageView9 = this.f20883g;
            int i26 = this.f20885i;
            tbImageView9.layout(i25 + i26 + (n * 2), 0, (i4 - i26) - i2, i22);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        float f2;
        int i5 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        if (p == 0) {
            p = i5;
        }
        MediaData[] mediaDataArr = this.f20884h;
        if (mediaDataArr != null && mediaDataArr.length != 0) {
            if (this.j) {
                setMeasuredDimension(p, (int) (m[mediaDataArr.length - 1] + 0.5f));
            } else {
                setMeasuredDimension(p, (int) (m[4] + 0.5f));
            }
            int length = this.f20884h.length;
            if (length == 1) {
                if (this.j) {
                    measureChild(this.f20881e, p + 1073741824, ((int) (m[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.f20881e, ((int) (l[4] + 0.5f)) + 1073741824, ((int) (m[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.f20882f, 0, 0);
                measureChild(this.f20883g, 0, 0);
                return;
            } else if (length == 2) {
                if (this.j) {
                    i4 = ((int) (l[1] + 0.5f)) + 1073741824;
                    f2 = m[1];
                } else {
                    i4 = ((int) (l[4] + 0.5f)) + 1073741824;
                    f2 = m[4];
                }
                int i6 = ((int) (f2 + 0.5f)) + 1073741824;
                measureChild(this.f20881e, i4, i6);
                measureChild(this.f20882f, i4, i6);
                measureChild(this.f20883g, 0, 0);
                return;
            } else if (length != 3) {
                return;
            } else {
                if (this.j) {
                    float[] fArr = l;
                    float[] fArr2 = m;
                    int i7 = ((int) (fArr[3] + 0.5f)) + 1073741824;
                    int i8 = ((int) (fArr2[3] + 0.5f)) + 1073741824;
                    measureChild(this.f20881e, ((int) (fArr[2] + 0.5f)) + 1073741824, ((int) (fArr2[2] + 0.5f)) + 1073741824);
                    measureChild(this.f20882f, i7, i8);
                    measureChild(this.f20883g, i7, i8);
                    return;
                }
                int i9 = ((int) (l[4] + 0.5f)) + 1073741824;
                int i10 = ((int) (m[4] + 0.5f)) + 1073741824;
                measureChild(this.f20881e, i9, i10);
                measureChild(this.f20882f, i9, i10);
                measureChild(this.f20883g, i9, i10);
                return;
            }
        }
        setMeasuredDimension(0, 0);
    }

    public void setData(MediaData[] mediaDataArr) {
        this.f20884h = mediaDataArr;
        if (mediaDataArr != null && mediaDataArr.length > 0) {
            int length = mediaDataArr.length;
            if (length == 1) {
                d(this.f20881e, mediaDataArr[0]);
                TbImageView tbImageView = this.f20882f;
                if (tbImageView != null) {
                    tbImageView.setTag(null);
                    this.f20882f.setClickable(false);
                }
                TbImageView tbImageView2 = this.f20883g;
                if (tbImageView2 != null) {
                    tbImageView2.setTag(null);
                    this.f20883g.setClickable(false);
                }
            } else if (length == 2) {
                d(this.f20881e, mediaDataArr[0]);
                d(this.f20882f, this.f20884h[1]);
                TbImageView tbImageView3 = this.f20883g;
                if (tbImageView3 != null) {
                    tbImageView3.setTag(null);
                    this.f20883g.setClickable(false);
                }
            } else if (length == 3) {
                d(this.f20881e, mediaDataArr[0]);
                d(this.f20882f, this.f20884h[1]);
                d(this.f20883g, this.f20884h[2]);
            }
            requestLayout();
            invalidate();
            return;
        }
        TbImageView tbImageView4 = this.f20881e;
        if (tbImageView4 != null) {
            tbImageView4.setTag(null);
        }
        TbImageView tbImageView5 = this.f20882f;
        if (tbImageView5 != null) {
            tbImageView5.setTag(null);
        }
        TbImageView tbImageView6 = this.f20883g;
        if (tbImageView6 != null) {
            tbImageView6.setTag(null);
        }
        requestLayout();
        invalidate();
    }

    public void setFromCDN(boolean z) {
    }

    public void setPadding(int i2) {
        this.f20885i = i2;
    }

    public void setShowBig(boolean z) {
        this.j = z;
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20885i = 7;
        this.j = false;
        this.k = context;
        b();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = SkinManager.getDrawable(R.color.common_color_10220);
        this.f20881e = new TbImageView(context);
        this.f20882f = new TbImageView(context);
        this.f20883g = new TbImageView(context);
        this.f20881e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20882f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20883g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20881e.setDefaultBg(drawable);
        this.f20882f.setDefaultBg(drawable);
        this.f20883g.setDefaultBg(drawable);
        addView(this.f20881e);
        addView(this.f20882f);
        addView(this.f20883g);
        this.f20885i = (int) (this.f20885i * q);
    }
}
