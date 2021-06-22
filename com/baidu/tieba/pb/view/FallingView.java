package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.pb.view.FallingView;
import d.a.c.e.p.l;
import d.a.o0.e2.p.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FallingView extends View {

    /* renamed from: e  reason: collision with root package name */
    public List<c> f19680e;

    /* renamed from: f  reason: collision with root package name */
    public int f19681f;

    /* renamed from: g  reason: collision with root package name */
    public int f19682g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19683h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f19684i;
    public Handler j;
    public Paint k;

    public FallingView(Context context) {
        super(context);
        this.f19683h = false;
        this.f19684i = new Runnable() { // from class: d.a.o0.e2.p.b
            @Override // java.lang.Runnable
            public final void run() {
                FallingView.this.d();
            }
        };
        this.j = new Handler();
        b();
    }

    public void a(c cVar, int i2) {
        if (this.f19681f == 0) {
            this.f19681f = l.k(getContext());
        }
        if (this.f19682g == 0) {
            this.f19682g = l.i(getContext());
        }
        for (int i3 = 0; i3 < i2; i3++) {
            c cVar2 = new c(cVar.f57720i, this.f19681f, this.f19682g);
            cVar2.f57716e = (-i3) * 180;
            this.f19680e.add(cVar2);
        }
    }

    public final void b() {
        this.f19680e = new ArrayList();
        Paint paint = new Paint();
        this.k = paint;
        paint.setDither(true);
        setLayerType(1, null);
    }

    public boolean c() {
        return this.f19683h;
    }

    public /* synthetic */ void d() {
        invalidate();
    }

    public final int e(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    public void f() {
        this.f19683h = true;
        invalidate();
    }

    public void g() {
        this.f19683h = false;
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.f19684i);
        }
        this.f19680e.clear();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onDraw(canvas);
        if (this.f19680e.size() > 0) {
            for (int i2 = 0; i2 < this.f19680e.size(); i2++) {
                this.f19680e.get(i2).b(canvas, this.k);
            }
            this.j.postDelayed(this.f19684i, (currentTimeMillis + 5) - System.currentTimeMillis());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int e2 = e(1000, i3);
        int e3 = e(600, i2);
        setMeasuredDimension(e3, e2);
        this.f19681f = e3;
        this.f19682g = e2;
    }

    public FallingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19683h = false;
        this.f19684i = new Runnable() { // from class: d.a.o0.e2.p.b
            @Override // java.lang.Runnable
            public final void run() {
                FallingView.this.d();
            }
        };
        this.j = new Handler();
        b();
    }
}
