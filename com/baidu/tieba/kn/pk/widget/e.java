package com.baidu.tieba.kn.pk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.baidu.browser.explorer.BdWebErrorView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends View {

    /* renamed from: a  reason: collision with root package name */
    private long f1302a;
    private long b;
    private Bitmap[] c;
    private Bitmap[] d;
    private Bitmap[] e;
    private Bitmap f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private Scroller l;
    private int m;
    private ArrayList<a> n;
    private ArrayList<a> o;
    private ArrayList<Scroller> p;
    private boolean q;
    private boolean r;
    private Rect s;
    private Rect t;
    private Matrix u;
    private int v;
    private boolean w;
    private Runnable x;
    private Runnable y;

    public e(Context context) {
        super(context);
        this.m = BdWebErrorView.ERROR_CODE_500;
        this.n = new ArrayList<>();
        this.o = new ArrayList<>();
        this.p = new ArrayList<>();
        this.w = true;
        this.x = new f(this);
        this.y = new g(this);
        f();
    }

    private void f() {
        int[] iArr = {R.drawable.pk_energyball_one, R.drawable.pk_energyball_two, R.drawable.pk_energyball_three, R.drawable.pk_energyball_four};
        this.c = new Bitmap[iArr.length];
        Resources resources = getResources();
        for (int i = 0; i < iArr.length; i++) {
            this.c[i] = BitmapFactory.decodeResource(resources, iArr[i]);
            int width = this.c[i].getWidth();
            if (width > this.v) {
                this.v = width;
            }
        }
        int[] iArr2 = {R.drawable.pk_current_blue_one, R.drawable.pk_current_blue_two};
        this.d = new Bitmap[iArr2.length];
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            this.d[i2] = BitmapFactory.decodeResource(resources, iArr2[i2]);
        }
        int[] iArr3 = {R.drawable.pk_current_yellow_one, R.drawable.pk_current_yellow_two};
        this.e = new Bitmap[iArr3.length];
        for (int i3 = 0; i3 < iArr3.length; i3++) {
            this.e[i3] = BitmapFactory.decodeResource(resources, iArr3[i3]);
        }
        this.f = BitmapFactory.decodeResource(resources, R.drawable.pk_energyball1);
        this.l = new Scroller(getContext(), new AccelerateDecelerateInterpolator());
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Matrix();
    }

    public long getLeftCount() {
        return this.f1302a;
    }

    public void setLeftCount(long j) {
        this.f1302a = j;
        a();
    }

    private void g() {
        if (this.q) {
            long j = this.b + this.f1302a;
            int measuredWidth = getMeasuredWidth();
            int i = measuredWidth / 2;
            int i2 = j != 0 ? (int) ((this.f1302a * measuredWidth) / j) : i;
            if (i2 < this.v / 2) {
                i2 = this.v / 2;
            }
            if (i2 > measuredWidth - (this.v / 2)) {
                i2 = measuredWidth - (this.v / 2);
            }
            if (!this.l.isFinished()) {
                this.l.forceFinished(true);
            }
            int i3 = i2 - this.j;
            this.l.startScroll(this.j, 0, i3, 0, Math.abs((this.m * i3) / i));
            post(this.y);
        }
    }

    public long getRightCount() {
        return this.b;
    }

    public void setRightCount(long j) {
        this.b = j;
        b();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.x);
        removeCallbacks(this.y);
        if (this.c != null) {
            for (int i = 0; i < this.c.length; i++) {
                this.c[i].recycle();
            }
        }
        if (this.d != null) {
            for (int i2 = 0; i2 < this.d.length; i2++) {
                this.d[i2].recycle();
            }
        }
        if (this.e != null) {
            for (int i3 = 0; i3 < this.e.length; i3++) {
                this.e[i3].recycle();
            }
        }
        if (this.f != null) {
            this.f.recycle();
        }
    }

    public void a() {
        if (this.q && this.r) {
            a remove = this.o.size() > 0 ? this.o.remove(0) : null;
            a aVar = remove == null ? new a() : remove;
            aVar.f1298a = 0;
            aVar.b = getHeight() / 2;
            aVar.f = true;
            aVar.c = this.f;
            aVar.d = this.f.getWidth();
            aVar.e = this.f.getHeight();
            aVar.h = getWidth() / 2;
            Scroller remove2 = this.p.size() > 0 ? this.p.remove(0) : null;
            if (remove2 == null) {
                remove2 = new Scroller(getContext());
            }
            aVar.g = remove2;
            aVar.a(this.j);
            this.n.add(aVar);
        }
    }

    public void b() {
        if (this.q && this.r) {
            a remove = this.o.size() > 0 ? this.o.remove(0) : null;
            a aVar = remove == null ? new a() : remove;
            aVar.f1298a = getWidth();
            aVar.b = getHeight() / 2;
            aVar.f = false;
            aVar.c = this.f;
            aVar.d = this.f.getWidth();
            aVar.e = this.f.getHeight();
            aVar.h = getWidth() / 2;
            Scroller remove2 = this.p.size() > 0 ? this.p.remove(0) : null;
            if (remove2 == null) {
                remove2 = new Scroller(getContext());
            }
            aVar.g = remove2;
            aVar.a(this.j);
            this.n.add(aVar);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        boolean z = false;
        this.q = true;
        int height = getHeight();
        int width = getWidth();
        if (this.w) {
            long j = this.f1302a + this.b;
            int i = width / 2;
            if (j != 0) {
                i = (int) ((this.f1302a * width) / j);
            }
            if (i < this.v / 2) {
                i = this.v / 2;
            }
            if (i > width - (this.v / 2)) {
                i = width - (this.v / 2);
            }
            this.j = i;
            this.w = false;
        }
        if (this.c != null && !this.k) {
            this.k = true;
            this.g %= this.c.length;
            this.g++;
            if (this.g == this.c.length) {
                this.g = 0;
            }
            if (this.r) {
                this.h++;
                if (this.h >= this.d.length) {
                    this.h = 0;
                }
                this.i++;
                if (this.i >= this.e.length) {
                    this.i = 0;
                }
            }
            removeCallbacks(this.x);
            postDelayed(this.x, 100L);
        }
        canvas.save();
        Bitmap bitmap = this.d[this.h];
        this.s.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        this.t.set(0, 0, this.j, height);
        canvas.drawBitmap(bitmap, this.s, this.t, (Paint) null);
        canvas.restore();
        canvas.save();
        Bitmap bitmap2 = this.e[this.i];
        this.s.set(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        this.t.set(this.j, 0, width, height);
        canvas.drawBitmap(bitmap2, this.s, this.t, (Paint) null);
        canvas.restore();
        Iterator<a> it = this.n.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.f && next.f1298a >= this.j) {
                it.remove();
                this.o.add(next);
                this.p.add(next.g);
                z = true;
            } else if (!next.f && next.f1298a <= this.j) {
                it.remove();
                this.o.add(next);
                this.p.add(next.g);
                z = true;
            } else {
                next.a(canvas);
            }
        }
        if (z) {
            g();
        }
        canvas.save();
        Bitmap bitmap3 = this.c[this.g];
        canvas.translate(this.j - (bitmap3.getWidth() / 2), (getHeight() / 2) - (bitmap3.getHeight() / 2));
        canvas.drawBitmap(bitmap3, this.u, null);
        canvas.restore();
        postInvalidateDelayed(16L);
    }

    public void c() {
        this.r = false;
    }

    public void d() {
        this.r = true;
    }

    public void e() {
        this.r = false;
    }
}
