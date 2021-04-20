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
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class CommonImageLayout extends ViewGroup {
    public static float[] l = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    public static float[] m = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    public static int n = 2;
    public static int o = 4;
    public static int p = 0;
    public static float q = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f20973e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f20974f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f20975g;

    /* renamed from: h  reason: collision with root package name */
    public MediaData[] f20976h;
    public int i;
    public boolean j;
    public final Context k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaData f20977e;

        public a(MediaData mediaData) {
            this.f20977e = mediaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.l.a.l(CommonImageLayout.this.k, this.f20977e.getVideoUrl());
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
        int i = 0;
        while (true) {
            float[] fArr = l;
            if (i < fArr.length) {
                float f2 = fArr[i];
                float f3 = q;
                fArr[i] = f2 * f3;
                float[] fArr2 = m;
                fArr2[i] = fArr2[i] * f3;
                i++;
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
        tbImageView.W(picUrl, 13, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr = this.f20976h;
        if (mediaDataArr == null || mediaDataArr.length == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        int length = this.f20976h.length;
        if (length == 1) {
            drawChild(canvas, this.f20973e, drawingTime);
        } else if (length == 2) {
            drawChild(canvas, this.f20973e, drawingTime);
            drawChild(canvas, this.f20974f, drawingTime);
        } else if (length != 3) {
        } else {
            drawChild(canvas, this.f20973e, drawingTime);
            drawChild(canvas, this.f20974f, drawingTime);
            drawChild(canvas, this.f20975g, drawingTime);
        }
    }

    public int getPadding() {
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        MediaData[] mediaDataArr = this.f20976h;
        if (mediaDataArr == null || mediaDataArr.length == 0) {
            return;
        }
        int length = mediaDataArr.length;
        if (length == 1) {
            if (this.j) {
                float f2 = l[0];
                this.f20973e.layout(0, 0, i3, i4 - i2);
            } else {
                TbImageView tbImageView = this.f20973e;
                int i5 = this.i;
                tbImageView.layout(i5, 0, ((int) (l[4] + 0.5f)) + i5, i4 - i2);
            }
            this.f20974f.layout(0, 0, 0, 0);
            this.f20975g.layout(0, 0, 0, 0);
        } else if (length == 2) {
            if (this.j) {
                int i6 = (int) (l[1] + 0.5f);
                TbImageView tbImageView2 = this.f20973e;
                int i7 = this.i;
                int i8 = i4 - i2;
                tbImageView2.layout(i7, 0, i7 + i6, i8);
                TbImageView tbImageView3 = this.f20974f;
                int i9 = this.i;
                tbImageView3.layout(i6 + i9 + o, 0, (i3 - i9) - i, i8);
            } else {
                int i10 = (int) (l[4] + 0.5f);
                TbImageView tbImageView4 = this.f20973e;
                int i11 = this.i;
                int i12 = i4 - i2;
                tbImageView4.layout(i11, 0, i11 + i10, i12);
                TbImageView tbImageView5 = this.f20974f;
                int i13 = this.i;
                int i14 = n;
                tbImageView5.layout(i13 + i10 + i14, 0, i13 + (i10 * 2) + i14, i12);
            }
            this.f20975g.layout(0, 0, 0, 0);
        } else if (length != 3) {
        } else {
            if (this.j) {
                float[] fArr = l;
                int i15 = (int) (fArr[2] + 0.5f);
                int i16 = (int) (fArr[3] + 0.5f);
                int i17 = i4 - i2;
                this.f20973e.layout(0, 0, i15, i17);
                this.f20974f.layout(n + i15, 0, i3, i16);
                TbImageView tbImageView6 = this.f20975g;
                int i18 = n;
                tbImageView6.layout(i15 + i18, i16 + i18, i3, i17);
                return;
            }
            int i19 = (int) (l[4] + 0.5f);
            TbImageView tbImageView7 = this.f20973e;
            int i20 = this.i;
            int i21 = i4 - i2;
            tbImageView7.layout(i20, 0, i19 + i20, i21);
            TbImageView tbImageView8 = this.f20974f;
            int i22 = this.i;
            int i23 = n;
            int i24 = i19 * 2;
            tbImageView8.layout(i19 + i22 + i23, 0, i22 + i24 + i23, i21);
            TbImageView tbImageView9 = this.f20975g;
            int i25 = this.i;
            tbImageView9.layout(i24 + i25 + (n * 2), 0, (i3 - i25) - i, i21);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        float f2;
        int i4 = i & 1073741823;
        if (p == 0) {
            p = i4;
        }
        MediaData[] mediaDataArr = this.f20976h;
        if (mediaDataArr != null && mediaDataArr.length != 0) {
            if (this.j) {
                setMeasuredDimension(p, (int) (m[mediaDataArr.length - 1] + 0.5f));
            } else {
                setMeasuredDimension(p, (int) (m[4] + 0.5f));
            }
            int length = this.f20976h.length;
            if (length == 1) {
                if (this.j) {
                    measureChild(this.f20973e, p + 1073741824, ((int) (m[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.f20973e, ((int) (l[4] + 0.5f)) + 1073741824, ((int) (m[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.f20974f, 0, 0);
                measureChild(this.f20975g, 0, 0);
                return;
            } else if (length == 2) {
                if (this.j) {
                    i3 = ((int) (l[1] + 0.5f)) + 1073741824;
                    f2 = m[1];
                } else {
                    i3 = ((int) (l[4] + 0.5f)) + 1073741824;
                    f2 = m[4];
                }
                int i5 = ((int) (f2 + 0.5f)) + 1073741824;
                measureChild(this.f20973e, i3, i5);
                measureChild(this.f20974f, i3, i5);
                measureChild(this.f20975g, 0, 0);
                return;
            } else if (length != 3) {
                return;
            } else {
                if (this.j) {
                    float[] fArr = l;
                    float[] fArr2 = m;
                    int i6 = ((int) (fArr[3] + 0.5f)) + 1073741824;
                    int i7 = ((int) (fArr2[3] + 0.5f)) + 1073741824;
                    measureChild(this.f20973e, ((int) (fArr[2] + 0.5f)) + 1073741824, ((int) (fArr2[2] + 0.5f)) + 1073741824);
                    measureChild(this.f20974f, i6, i7);
                    measureChild(this.f20975g, i6, i7);
                    return;
                }
                int i8 = ((int) (l[4] + 0.5f)) + 1073741824;
                int i9 = ((int) (m[4] + 0.5f)) + 1073741824;
                measureChild(this.f20973e, i8, i9);
                measureChild(this.f20974f, i8, i9);
                measureChild(this.f20975g, i8, i9);
                return;
            }
        }
        setMeasuredDimension(0, 0);
    }

    public void setData(MediaData[] mediaDataArr) {
        this.f20976h = mediaDataArr;
        if (mediaDataArr != null && mediaDataArr.length > 0) {
            int length = mediaDataArr.length;
            if (length == 1) {
                d(this.f20973e, mediaDataArr[0]);
                TbImageView tbImageView = this.f20974f;
                if (tbImageView != null) {
                    tbImageView.setTag(null);
                    this.f20974f.setClickable(false);
                }
                TbImageView tbImageView2 = this.f20975g;
                if (tbImageView2 != null) {
                    tbImageView2.setTag(null);
                    this.f20975g.setClickable(false);
                }
            } else if (length == 2) {
                d(this.f20973e, mediaDataArr[0]);
                d(this.f20974f, this.f20976h[1]);
                TbImageView tbImageView3 = this.f20975g;
                if (tbImageView3 != null) {
                    tbImageView3.setTag(null);
                    this.f20975g.setClickable(false);
                }
            } else if (length == 3) {
                d(this.f20973e, mediaDataArr[0]);
                d(this.f20974f, this.f20976h[1]);
                d(this.f20975g, this.f20976h[2]);
            }
            requestLayout();
            invalidate();
            return;
        }
        TbImageView tbImageView4 = this.f20973e;
        if (tbImageView4 != null) {
            tbImageView4.setTag(null);
        }
        TbImageView tbImageView5 = this.f20974f;
        if (tbImageView5 != null) {
            tbImageView5.setTag(null);
        }
        TbImageView tbImageView6 = this.f20975g;
        if (tbImageView6 != null) {
            tbImageView6.setTag(null);
        }
        requestLayout();
        invalidate();
    }

    public void setFromCDN(boolean z) {
    }

    public void setPadding(int i) {
        this.i = i;
    }

    public void setShowBig(boolean z) {
        this.j = z;
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 7;
        this.j = false;
        this.k = context;
        b();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = SkinManager.getDrawable(R.color.common_color_10220);
        this.f20973e = new TbImageView(context);
        this.f20974f = new TbImageView(context);
        this.f20975g = new TbImageView(context);
        this.f20973e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20974f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20975g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20973e.setDefaultBg(drawable);
        this.f20974f.setDefaultBg(drawable);
        this.f20975g.setDefaultBg(drawable);
        addView(this.f20973e);
        addView(this.f20974f);
        addView(this.f20975g);
        this.i = (int) (this.i * q);
    }
}
