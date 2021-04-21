package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.pb.view.FallingView;
import d.b.c.e.p.l;
import d.b.j0.d2.p.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class FallingView extends View {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f19820e;

    /* renamed from: f  reason: collision with root package name */
    public int f19821f;

    /* renamed from: g  reason: collision with root package name */
    public int f19822g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19823h;
    public Runnable i;
    public Handler j;
    public Paint k;

    public FallingView(Context context) {
        super(context);
        this.f19823h = false;
        this.i = new Runnable() { // from class: d.b.j0.d2.p.b
            @Override // java.lang.Runnable
            public final void run() {
                FallingView.this.d();
            }
        };
        this.j = new Handler();
        b();
    }

    public void a(c cVar, int i) {
        if (this.f19821f == 0) {
            this.f19821f = l.k(getContext());
        }
        if (this.f19822g == 0) {
            this.f19822g = l.i(getContext());
        }
        for (int i2 = 0; i2 < i; i2++) {
            c cVar2 = new c(cVar.i, this.f19821f, this.f19822g);
            cVar2.f55149e = (-i2) * 180;
            this.f19820e.add(cVar2);
        }
    }

    public final void b() {
        this.f19820e = new ArrayList();
        Paint paint = new Paint();
        this.k = paint;
        paint.setDither(true);
        setLayerType(1, null);
    }

    public boolean c() {
        return this.f19823h;
    }

    public /* synthetic */ void d() {
        invalidate();
    }

    public final int e(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    public void f() {
        this.f19823h = true;
        invalidate();
    }

    public void g() {
        this.f19823h = false;
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.i);
        }
        this.f19820e.clear();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        if (this.f19820e.size() > 0) {
            for (int i = 0; i < this.f19820e.size(); i++) {
                this.f19820e.get(i).b(canvas, this.k);
            }
            this.j.postDelayed(this.i, (currentTimeMillis + 5) - System.currentTimeMillis());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int e2 = e(1000, i2);
        int e3 = e(600, i);
        setMeasuredDimension(e3, e2);
        this.f19821f = e3;
        this.f19822g = e2;
    }

    public FallingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19823h = false;
        this.i = new Runnable() { // from class: d.b.j0.d2.p.b
            @Override // java.lang.Runnable
            public final void run() {
                FallingView.this.d();
            }
        };
        this.j = new Handler();
        b();
    }
}
