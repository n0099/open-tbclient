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
    public static float f27916a;

    /* renamed from: b  reason: collision with root package name */
    public static float f27917b;

    /* renamed from: c  reason: collision with root package name */
    public static float f27918c;

    /* renamed from: d  reason: collision with root package name */
    public static float f27919d;

    /* renamed from: e  reason: collision with root package name */
    public static long f27920e;
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
        public int f27921a;

        /* renamed from: b  reason: collision with root package name */
        public double f27922b;

        /* renamed from: c  reason: collision with root package name */
        public double f27923c;

        /* renamed from: d  reason: collision with root package name */
        public long f27924d;

        public a(int i2, double d2, double d3, long j) {
            this.f27921a = -1;
            this.f27921a = i2;
            this.f27922b = d2;
            this.f27923c = d3;
            this.f27924d = j;
        }
    }

    static {
        if (ViewConfiguration.get(p.a()) != null) {
            B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f27916a = 0.0f;
        f27917b = 0.0f;
        f27918c = 0.0f;
        f27919d = 0.0f;
        f27920e = 0L;
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
            f27920e = System.currentTimeMillis();
            i2 = 0;
        } else if (actionMasked == 1) {
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            i2 = 3;
        } else if (actionMasked != 2) {
            i2 = actionMasked != 3 ? -1 : 4;
        } else {
            f27918c += Math.abs(motionEvent.getX() - f27916a);
            f27919d += Math.abs(motionEvent.getY() - f27917b);
            f27916a = motionEvent.getX();
            f27917b = motionEvent.getY();
            if (System.currentTimeMillis() - f27920e > 200) {
                float f2 = f27918c;
                int i3 = B;
                if (f2 > i3 || f27919d > i3) {
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
