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
    public static float f28557a;

    /* renamed from: b  reason: collision with root package name */
    public static float f28558b;

    /* renamed from: c  reason: collision with root package name */
    public static float f28559c;

    /* renamed from: d  reason: collision with root package name */
    public static float f28560d;

    /* renamed from: e  reason: collision with root package name */
    public static long f28561e;
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
        public int f28562a;

        /* renamed from: b  reason: collision with root package name */
        public double f28563b;

        /* renamed from: c  reason: collision with root package name */
        public double f28564c;

        /* renamed from: d  reason: collision with root package name */
        public long f28565d;

        public a(int i2, double d2, double d3, long j) {
            this.f28562a = -1;
            this.f28562a = i2;
            this.f28563b = d2;
            this.f28564c = d3;
            this.f28565d = j;
        }
    }

    static {
        if (ViewConfiguration.get(p.a()) != null) {
            B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f28557a = 0.0f;
        f28558b = 0.0f;
        f28559c = 0.0f;
        f28560d = 0.0f;
        f28561e = 0L;
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
            f28561e = System.currentTimeMillis();
            i2 = 0;
        } else if (actionMasked == 1) {
            this.u = (int) motionEvent.getRawX();
            this.v = (int) motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            i2 = 3;
        } else if (actionMasked != 2) {
            i2 = actionMasked != 3 ? -1 : 4;
        } else {
            f28559c += Math.abs(motionEvent.getX() - f28557a);
            f28560d += Math.abs(motionEvent.getY() - f28558b);
            f28557a = motionEvent.getX();
            f28558b = motionEvent.getY();
            if (System.currentTimeMillis() - f28561e > 200) {
                float f2 = f28559c;
                int i3 = B;
                if (f2 > i3 || f28560d > i3) {
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
