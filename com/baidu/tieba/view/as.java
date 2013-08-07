package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.sdk.contact.RContact;
/* loaded from: classes.dex */
public class as extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f1820a;
    private int b;
    private String c;
    private float d;
    private float e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Bitmap j;
    private Bitmap k;
    private Rect l;
    private Rect m;
    private Rect n;
    private int o;
    private float p;
    private boolean q;
    private PaintFlagsDrawFilter r;

    public as(Context context) {
        super(context);
        this.f1820a = 0;
        this.b = 0;
        this.c = null;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new Rect();
        this.m = new Rect();
        this.n = new Rect();
        this.o = 0;
        this.p = 1.0f;
        this.q = false;
        this.r = null;
        b();
    }

    public void setType(int i) {
        this.o = i;
    }

    public int getType() {
        return this.o;
    }

    private void b() {
        this.g = new Paint();
        this.h = new Paint();
        this.i = new Paint();
        this.h.setColor(-1);
        this.i.setColor(-16777216);
        this.h.setTextAlign(Paint.Align.CENTER);
        this.i.setTextAlign(Paint.Align.CENTER);
        this.i.setAlpha(RContact.MM_CONTACTFLAG_ALL);
        this.f = new Paint();
        this.h.setAntiAlias(true);
        this.i.setAntiAlias(true);
        this.f.setAntiAlias(true);
        this.r = new PaintFlagsDrawFilter(0, 3);
    }

    public void setTextSize(float f) {
        this.e = f;
        this.h.setTextSize(f);
        this.i.setTextSize(f);
    }

    public float getTextSize() {
        return this.e;
    }

    public void setText(String str) {
        this.c = str;
    }

    public void setGradual(float f) {
        this.p = 0.2f + (0.8f * f);
        a((int) (255.0f * this.p));
        this.h.setTextSize(this.e * this.p);
        this.i.setTextSize(this.e * this.p);
    }

    public void a(int i) {
        this.f.setAlpha(i);
        this.g.setAlpha(i);
        this.h.setAlpha(i);
        this.i.setAlpha(i >> 1);
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        this.k = bitmap;
        this.j = bitmap2;
        if (this.k != null) {
            this.l.set(0, 0, this.k.getWidth(), this.k.getHeight());
        }
        if (this.k != null && this.j != null) {
            this.m.set(0, 0, this.k.getWidth(), this.k.getHeight());
        }
    }

    public void setParam(float f) {
        this.g.setAlpha((int) (255.0f * f * 0.6d));
    }

    public void a() {
        if (this.k != null) {
            this.q = true;
            this.f.setAlpha(50);
            this.h.setAlpha(50);
            this.g.setAlpha(0);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.n.set(0, 0, i3 - i, i4 - i2);
    }

    @Override // android.view.View
    protected boolean onSetAlpha(int i) {
        if (this.o == 1) {
            if (!this.q) {
                a(i);
            }
        } else {
            this.g.setAlpha(i);
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.b = getHeight();
        this.f1820a = getWidth();
        canvas.setDrawFilter(this.r);
        this.b = (int) (this.p * this.b);
        this.f1820a = (int) (this.p * this.f1820a);
        this.n.set(0, 0, this.f1820a, this.b);
        if (this.j != null && !this.j.isRecycled()) {
            canvas.drawBitmap(this.j, this.m, this.n, this.g);
        }
        if (this.k != null && !this.k.isRecycled()) {
            canvas.drawBitmap(this.k, this.l, this.n, this.f);
        }
        if (this.c != null) {
            Paint.FontMetrics fontMetrics = this.h.getFontMetrics();
            this.d = (((this.b - ((int) (fontMetrics.descent - fontMetrics.ascent))) - 2) / 2.0f) - fontMetrics.ascent;
            if (this.d < 0.0f) {
                this.d = 0.0f;
            }
            canvas.drawText(this.c, this.f1820a / 2.0f, this.d + 1.0f, this.i);
            canvas.drawText(this.c, this.f1820a / 2.0f, this.d, this.h);
        }
    }
}
