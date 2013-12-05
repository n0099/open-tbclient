package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CommonImageLayout extends ViewGroup {
    private static com.baidu.tieba.util.i j;
    public bj b;
    public bj c;
    public bj d;
    private com.baidu.tieba.data.ai[] k;
    private int l;
    private boolean m;
    private boolean n;
    private Context o;
    private String p;
    private static float[] e = {306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static float[] f = {138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
    private static int g = 2;
    private static int h = 4;
    private static int i = 0;

    /* renamed from: a  reason: collision with root package name */
    public static float f2625a = -1.0f;

    public CommonImageLayout(Context context) {
        this(context, null);
    }

    private void b() {
        if (f2625a < 0.0f) {
            f2625a = com.baidu.adp.lib.h.g.b(this.o) / 320.0f;
            for (int i2 = 0; i2 < e.length; i2++) {
                float[] fArr = e;
                fArr[i2] = fArr[i2] * f2625a;
                float[] fArr2 = f;
                fArr2[i2] = fArr2[i2] * f2625a;
            }
            g = (int) (g * f2625a);
            h = (int) (h * f2625a);
        }
    }

    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 7;
        this.m = false;
        this.n = false;
        this.p = "other";
        this.o = context;
        b();
        this.b = new bj(context);
        this.c = new bj(context);
        this.d = new bj(context);
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.b);
        addView(this.c);
        addView(this.d);
        this.l = (int) (this.l * f2625a);
    }

    public void setShowBig(boolean z) {
        this.m = z;
        if (this.m) {
            if (this.b != null) {
                this.b.setSuffix("_small");
            }
            if (this.c != null) {
                this.c.setSuffix("_small");
            }
            if (this.d != null) {
                this.d.setSuffix("_small");
                return;
            }
            return;
        }
        if (this.b != null) {
            this.b.setSuffix("_mobile");
        }
        if (this.c != null) {
            this.c.setSuffix("_mobile");
        }
        if (this.d != null) {
            this.d.setSuffix("_mobile");
        }
    }

    public void setData(com.baidu.tieba.data.ai[] aiVarArr) {
        this.k = aiVarArr;
        if (this.k == null || this.k.length <= 0) {
            if (this.b != null) {
                this.b.setTag(null);
            }
            if (this.c != null) {
                this.c.setTag(null);
            }
            if (this.d != null) {
                this.d.setTag(null);
            }
            requestLayout();
            invalidate();
            return;
        }
        int length = this.k.length;
        if (length == 1) {
            a(this.b, this.k[0]);
            if (this.c != null) {
                this.c.setTag(null);
                this.c.setClickable(false);
            }
            if (this.d != null) {
                this.d.setTag(null);
                this.d.setClickable(false);
            }
        } else if (length == 2) {
            a(this.b, this.k[0]);
            a(this.c, this.k[1]);
            if (this.d != null) {
                this.d.setTag(null);
                this.d.setClickable(false);
            }
        } else if (length == 3) {
            a(this.b, this.k[0]);
            a(this.c, this.k[1]);
            a(this.d, this.k[2]);
        }
        requestLayout();
        invalidate();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6 = 1073741823 & i2;
        if (i == 0) {
            i = i6;
        }
        if (this.k == null || this.k.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (this.m) {
            setMeasuredDimension(i, (int) (f[this.k.length - 1] + 0.5f));
        } else {
            setMeasuredDimension(i, (int) (f[4] + 0.5f));
        }
        switch (this.k.length) {
            case 1:
                if (this.m) {
                    measureChild(this.b, i + 1073741824, ((int) (f[0] + 0.5f)) + 1073741824);
                } else {
                    measureChild(this.b, ((int) (e[4] + 0.5f)) + 1073741824, ((int) (f[4] + 0.5f)) + 1073741824);
                }
                measureChild(this.c, 0, 0);
                measureChild(this.d, 0, 0);
                return;
            case 2:
                if (this.m) {
                    i4 = ((int) (e[1] + 0.5f)) + 1073741824;
                    i5 = ((int) (f[1] + 0.5f)) + 1073741824;
                } else {
                    i4 = ((int) (e[4] + 0.5f)) + 1073741824;
                    i5 = ((int) (f[4] + 0.5f)) + 1073741824;
                }
                measureChild(this.b, i4, i5);
                measureChild(this.c, i4, i5);
                measureChild(this.d, 0, 0);
                break;
            case 3:
                break;
            default:
                return;
        }
        if (this.m) {
            int i7 = ((int) (e[3] + 0.5f)) + 1073741824;
            int i8 = ((int) (f[3] + 0.5f)) + 1073741824;
            measureChild(this.b, ((int) (e[2] + 0.5f)) + 1073741824, ((int) (f[2] + 0.5f)) + 1073741824);
            measureChild(this.c, i7, i8);
            measureChild(this.d, i7, i8);
            return;
        }
        int i9 = ((int) (e[4] + 0.5f)) + 1073741824;
        int i10 = ((int) (f[4] + 0.5f)) + 1073741824;
        measureChild(this.b, i9, i10);
        measureChild(this.c, i9, i10);
        measureChild(this.d, i9, i10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.k != null && this.k.length != 0) {
            switch (this.k.length) {
                case 1:
                    if (this.m) {
                        int i6 = (int) (e[0] + 0.5f);
                        this.b.layout(0, 0, i4, i5 - i3);
                    } else {
                        this.b.layout(this.l, 0, ((int) (e[4] + 0.5f)) + this.l, i5 - i3);
                    }
                    this.c.layout(0, 0, 0, 0);
                    this.d.layout(0, 0, 0, 0);
                    return;
                case 2:
                    if (this.m) {
                        int i7 = (int) (e[1] + 0.5f);
                        this.b.layout(this.l, 0, this.l + i7, i5 - i3);
                        this.c.layout(i7 + this.l + h, 0, (i4 - this.l) - i2, i5 - i3);
                    } else {
                        int i8 = (int) (e[4] + 0.5f);
                        this.b.layout(this.l, 0, this.l + i8, i5 - i3);
                        this.c.layout(this.l + i8 + g, 0, (i8 * 2) + this.l + g, i5 - i3);
                    }
                    this.d.layout(0, 0, 0, 0);
                    return;
                case 3:
                    if (this.m) {
                        int i9 = (int) (e[2] + 0.5f);
                        int i10 = (int) (e[3] + 0.5f);
                        this.b.layout(0, 0, i9, i5 - i3);
                        this.c.layout(g + i9, 0, i4, i10);
                        this.d.layout(i9 + g, i10 + g, i4, i5 - i3);
                        return;
                    }
                    int i11 = (int) (e[4] + 0.5f);
                    this.b.layout(this.l, 0, this.l + i11, i5 - i3);
                    this.c.layout(this.l + i11 + g, 0, (i11 * 2) + this.l + g, i5 - i3);
                    this.d.layout((i11 * 2) + this.l + (g * 2), 0, (i4 - this.l) - i2, i5 - i3);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.k != null && this.k.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.k.length) {
                case 1:
                    drawChild(canvas, this.b, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.b, drawingTime);
                    drawChild(canvas, this.c, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.b, drawingTime);
                    drawChild(canvas, this.c, drawingTime);
                    drawChild(canvas, this.d, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }

    public int getPadding() {
        return this.l;
    }

    public void setPadding(int i2) {
        this.l = i2;
    }

    private void a(TbImageView tbImageView, com.baidu.tieba.data.ai aiVar) {
        if (tbImageView != null) {
            String b = aiVar.b();
            if (aiVar.a() == 5) {
                b = null;
                tbImageView.setDefaultResource(R.drawable.pic_video);
                tbImageView.setNightDefaultResource(R.drawable.pic_video_1);
                tbImageView.setOnClickListener(new i(this, aiVar));
            } else {
                tbImageView.setDefaultResource(R.drawable.pic_baidu_logo_d);
                tbImageView.setNightDefaultResource(R.drawable.pic_baidu_logo_d_1);
                tbImageView.setClickable(false);
            }
            tbImageView.setTag(b);
            if (j != null) {
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.n = z;
        if (j != null) {
            j.d(this.n);
        }
    }

    public void setImageFrom(String str) {
        this.p = str;
        if (j != null) {
            j.f(str);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void a() {
        if (this.b != null) {
            this.b.d();
        }
        if (this.c != null) {
            this.c.d();
        }
        if (this.d != null) {
            this.d.d();
        }
    }
}
