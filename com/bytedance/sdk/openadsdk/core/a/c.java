package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    public static int B = 8;

    /* renamed from: a  reason: collision with root package name */
    public static float f27802a;

    /* renamed from: b  reason: collision with root package name */
    public static float f27803b;

    /* renamed from: c  reason: collision with root package name */
    public static float f27804c;

    /* renamed from: d  reason: collision with root package name */
    public static float f27805d;

    /* renamed from: e  reason: collision with root package name */
    public static long f27806e;
    public int A;
    public SparseArray<a> C = new SparseArray<>();
    public int s;
    public int t;
    public int u;
    public int v;
    public long w;
    public long x;
    public int y;
    public int z;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27807a;

        /* renamed from: b  reason: collision with root package name */
        public double f27808b;

        /* renamed from: c  reason: collision with root package name */
        public double f27809c;

        /* renamed from: d  reason: collision with root package name */
        public long f27810d;

        public a(int i2, double d2, double d3, long j) {
            this.f27807a = -1;
            this.f27807a = i2;
            this.f27808b = d2;
            this.f27809c = d3;
            this.f27810d = j;
        }
    }

    static {
        if (ViewConfiguration.get(p.a()) != null) {
            B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f27802a = 0.0f;
        f27803b = 0.0f;
        f27804c = 0.0f;
        f27805d = 0.0f;
        f27806e = 0L;
    }

    public abstract void a(View view, int i2, int i3, int i4, int i5);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g.a()) {
            a(view, this.s, this.t, this.u, this.v);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.s = (int) motionEvent.getRawX();
            this.t = (int) motionEvent.getRawY();
            this.w = System.currentTimeMillis();
            this.y = motionEvent.getToolType(0);
            this.z = motionEvent.getDeviceId();
            this.A = motionEvent.getSource();
            f27806e = System.currentTimeMillis();
            i2 = 0;
        } else if (actionMasked == 1) {
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            i2 = 3;
        } else if (actionMasked != 2) {
            i2 = actionMasked != 3 ? -1 : 4;
        } else {
            f27804c += Math.abs(motionEvent.getX() - f27802a);
            f27805d += Math.abs(motionEvent.getY() - f27803b);
            f27802a = motionEvent.getX();
            f27803b = motionEvent.getY();
            if (System.currentTimeMillis() - f27806e > 200) {
                float f2 = f27804c;
                int i3 = B;
                if (f2 > i3 || f27805d > i3) {
                    i2 = 1;
                }
            }
            i2 = 2;
        }
        if (this.C.get(motionEvent.getActionMasked()) == null) {
            this.C.put(motionEvent.getActionMasked(), new a(i2, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return false;
    }
}
