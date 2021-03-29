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
    public static float f28024a;

    /* renamed from: b  reason: collision with root package name */
    public static float f28025b;

    /* renamed from: c  reason: collision with root package name */
    public static float f28026c;

    /* renamed from: d  reason: collision with root package name */
    public static float f28027d;

    /* renamed from: e  reason: collision with root package name */
    public static long f28028e;
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
        public int f28029a;

        /* renamed from: b  reason: collision with root package name */
        public double f28030b;

        /* renamed from: c  reason: collision with root package name */
        public double f28031c;

        /* renamed from: d  reason: collision with root package name */
        public long f28032d;

        public a(int i, double d2, double d3, long j) {
            this.f28029a = -1;
            this.f28029a = i;
            this.f28030b = d2;
            this.f28031c = d3;
            this.f28032d = j;
        }
    }

    static {
        if (ViewConfiguration.get(p.a()) != null) {
            B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f28024a = 0.0f;
        f28025b = 0.0f;
        f28026c = 0.0f;
        f28027d = 0.0f;
        f28028e = 0L;
    }

    public abstract void a(View view, int i, int i2, int i3, int i4);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g.a()) {
            a(view, this.s, this.t, this.u, this.v);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.s = (int) motionEvent.getRawX();
            this.t = (int) motionEvent.getRawY();
            this.w = System.currentTimeMillis();
            this.y = motionEvent.getToolType(0);
            this.z = motionEvent.getDeviceId();
            this.A = motionEvent.getSource();
            f28028e = System.currentTimeMillis();
            i = 0;
        } else if (actionMasked == 1) {
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            i = 3;
        } else if (actionMasked != 2) {
            i = actionMasked != 3 ? -1 : 4;
        } else {
            f28026c += Math.abs(motionEvent.getX() - f28024a);
            f28027d += Math.abs(motionEvent.getY() - f28025b);
            f28024a = motionEvent.getX();
            f28025b = motionEvent.getY();
            if (System.currentTimeMillis() - f28028e > 200) {
                float f2 = f28026c;
                int i2 = B;
                if (f2 > i2 || f28027d > i2) {
                    i = 1;
                }
            }
            i = 2;
        }
        if (this.C.get(motionEvent.getActionMasked()) == null) {
            this.C.put(motionEvent.getActionMasked(), new a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return false;
    }
}
