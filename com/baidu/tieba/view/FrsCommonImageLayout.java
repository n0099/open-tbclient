package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FrsCommonImageLayout extends LinearLayout {
    private static com.baidu.tbadk.core.util.b k;
    private o a;
    private boolean b;
    private com.baidu.tbadk.core.data.j[] c;
    private final Context d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private String l;
    private int m;
    private boolean n;
    private String o;
    private String p;
    private String q;
    private String r;

    public void setDrawNum(boolean z) {
        this.n = z;
    }

    public int getNormalShowCount() {
        return this.j;
    }

    public void setNormalShowCount(int i) {
        this.j = i;
    }

    public int getItemSize() {
        return this.f;
    }

    public void setItemSize(int i) {
        this.f = com.baidu.adp.lib.util.i.a(this.d, i);
    }

    public FrsCommonImageLayout(Context context) {
        this(context, null);
    }

    public FrsCommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.e = false;
        this.f = 0;
        this.h = 3;
        this.i = 105;
        this.j = 3;
        this.l = "other";
        this.n = false;
        this.d = context;
        this.h = com.baidu.adp.lib.util.i.a(this.d, this.h);
        this.f = com.baidu.adp.lib.util.i.a(this.d, this.i);
    }

    public void setOnChildClickListener(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        view.setOnClickListener(new n(this, getChildCount() - 1, (byte) 0));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        view.setOnClickListener(new n(this, getChildCount() - 1, (byte) 0));
    }

    public final void a(String str, String str2, String str3) {
        this.p = str;
        this.o = str2;
        this.q = str3;
    }

    public final void a(com.baidu.tbadk.core.data.j[] jVarArr, int i) {
        if (getChildCount() > 0) {
            removeAllViews();
        }
        this.c = jVarArr;
        this.m = i;
        if (this.c == null || this.c.length <= 0) {
            requestLayout();
            invalidate();
            return;
        }
        this.g = this.c.length;
        if (this.g > this.j) {
            this.g = this.j;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.g) {
                x xVar = new x(this.d);
                xVar.setSuffix(this.r);
                xVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                com.baidu.tbadk.core.data.j jVar = this.c[i3];
                if (xVar != null) {
                    String c = jVar.c();
                    if (jVar.b() == 5) {
                        c = null;
                        xVar.setDefaultResource(com.baidu.tieba.a.g.pic_video);
                        xVar.setNightDefaultResource(com.baidu.tieba.a.g.pic_video_1);
                    } else {
                        xVar.setDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d);
                        xVar.setNightDefaultResource(com.baidu.tieba.a.g.pic_baidu_logo_d_1);
                    }
                    xVar.setTag(c);
                }
                addView(xVar);
                i2 = i3 + 1;
            } else {
                requestLayout();
                invalidate();
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (this.g == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int i4 = (this.f * this.g) + (this.h * (this.g - 1));
        if (this.f == 0) {
            this.f = this.i;
        } else if (i4 > i3) {
            this.f = (i3 - (this.h * (this.g - 1))) / this.g;
        } else {
            i3 = i4;
        }
        setMeasuredDimension(i3, this.f);
        for (int i5 = 0; i5 < this.g; i5++) {
            measureChild((x) getChildAt(i5), this.f, this.f);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g != 0) {
            for (int i5 = 0; i5 < this.g; i5++) {
                ((x) getChildAt(i5)).layout((this.h * i5) + (this.f * i5), 0, (this.h * i5) + (this.f * (i5 + 1)), i4 - i2);
            }
        }
    }

    public int getPadding() {
        return this.h;
    }

    public void setPadding(int i) {
        this.h = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        String str;
        if (this.c != null && this.c.length > 0) {
            this.g = getChildCount();
            if (this.g != 0) {
                long drawingTime = getDrawingTime();
                for (int i = 0; i < this.g; i++) {
                    drawChild(canvas, (x) getChildAt(i), drawingTime);
                }
                if (this.m > 3 && this.n) {
                    int a = com.baidu.adp.lib.util.i.a(this.d, 50.0f);
                    int a2 = com.baidu.adp.lib.util.i.a(this.d, 23.0f);
                    Paint paint = new Paint();
                    paint.setDither(true);
                    paint.setFilterBitmap(true);
                    Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), com.baidu.tieba.a.g.bg_look_photo_1);
                    canvas.drawBitmap(decodeResource, new Rect(0, 0, decodeResource.getWidth(), decodeResource.getHeight()), new Rect(getWidth() - a, getHeight() - a2, getWidth(), getHeight()), paint);
                    int a3 = com.baidu.adp.lib.util.i.a(this.d, 10.0f);
                    Paint paint2 = new Paint(257);
                    paint2.setColor(-1);
                    paint2.setTextSize(this.d.getResources().getDimension(com.baidu.tieba.a.f.ds20));
                    canvas.drawText(String.valueOf(this.d.getResources().getString(com.baidu.tieba.a.k.frs_item_common_image_canvas_text1)) + this.m + this.d.getResources().getString(com.baidu.tieba.a.k.frs_item_common_image_canvas_text2), ((a - (((str.length() + 2) * com.baidu.adp.lib.util.i.a(this.d, 10.0f)) / 2)) / 2) + (getWidth() - a), ((a3 - a2) / 2) + getHeight(), paint2);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public final void a() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                x xVar = (x) getChildAt(i);
                if (xVar != null) {
                    xVar.c();
                }
            }
        }
    }

    public void setFromCDN(boolean z) {
        this.b = z;
        if (k != null) {
            k.a(this.b);
        }
    }

    public void setImageFrom(String str) {
        this.l = str;
        if (k != null) {
            k.b(str);
        }
    }

    public void setShowBig(boolean z) {
        this.e = z;
        if (this.e) {
            this.r = "_small";
        } else {
            this.r = "_mobile";
        }
    }
}
