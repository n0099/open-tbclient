package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes5.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    public static int B = 8;

    /* renamed from: a  reason: collision with root package name */
    public static float f27717a;

    /* renamed from: b  reason: collision with root package name */
    public static float f27718b;

    /* renamed from: c  reason: collision with root package name */
    public static float f27719c;

    /* renamed from: d  reason: collision with root package name */
    public static float f27720d;

    /* renamed from: e  reason: collision with root package name */
    public static long f27721e;
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

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27722a;

        /* renamed from: b  reason: collision with root package name */
        public double f27723b;

        /* renamed from: c  reason: collision with root package name */
        public double f27724c;

        /* renamed from: d  reason: collision with root package name */
        public long f27725d;

        public a(int i, double d2, double d3, long j) {
            this.f27722a = -1;
            this.f27722a = i;
            this.f27723b = d2;
            this.f27724c = d3;
            this.f27725d = j;
        }
    }

    static {
        if (ViewConfiguration.get(p.a()) != null) {
            B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f27717a = 0.0f;
        f27718b = 0.0f;
        f27719c = 0.0f;
        f27720d = 0.0f;
        f27721e = 0L;
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
            f27721e = System.currentTimeMillis();
            i = 0;
        } else if (actionMasked == 1) {
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            i = 3;
        } else if (actionMasked != 2) {
            i = actionMasked != 3 ? -1 : 4;
        } else {
            f27719c += Math.abs(motionEvent.getX() - f27717a);
            f27720d += Math.abs(motionEvent.getY() - f27718b);
            f27717a = motionEvent.getX();
            f27718b = motionEvent.getY();
            if (System.currentTimeMillis() - f27721e > 200) {
                float f2 = f27719c;
                int i2 = B;
                if (f2 > i2 || f27720d > i2) {
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
