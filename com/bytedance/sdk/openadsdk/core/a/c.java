package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.h.g;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected static int B;

    /* renamed from: a  reason: collision with root package name */
    private static float f4356a;
    private static float b;
    private static float c;
    private static float d;
    private static long e;
    protected int A;
    protected SparseArray<a> C = new SparseArray<>();
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected long w;
    protected long x;
    protected int y;
    protected int z;

    protected abstract void a(View view, int i, int i2, int i3, int i4);

    static {
        B = 8;
        if (ViewConfiguration.get(p.a()) != null) {
            B = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f4356a = 0.0f;
        b = 0.0f;
        c = 0.0f;
        d = 0.0f;
        e = 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g.a()) {
            a(view, this.s, this.t, this.u, this.v);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = -1;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.s = (int) motionEvent.getRawX();
                this.t = (int) motionEvent.getRawY();
                this.w = System.currentTimeMillis();
                this.y = motionEvent.getToolType(0);
                this.z = motionEvent.getDeviceId();
                this.A = motionEvent.getSource();
                e = System.currentTimeMillis();
                i = 0;
                break;
            case 1:
                this.u = (int) motionEvent.getRawX();
                this.v = (int) motionEvent.getRawY();
                this.x = System.currentTimeMillis();
                i = 3;
                break;
            case 2:
                c += Math.abs(motionEvent.getX() - f4356a);
                d += Math.abs(motionEvent.getY() - b);
                f4356a = motionEvent.getX();
                b = motionEvent.getY();
                if (System.currentTimeMillis() - e > 200 && (c > B || d > B)) {
                    i = 1;
                    break;
                } else {
                    i = 2;
                    break;
                }
                break;
            case 3:
                i = 4;
                break;
        }
        if (this.C.get(motionEvent.getActionMasked()) == null) {
            this.C.put(motionEvent.getActionMasked(), new a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4357a;
        public double b;
        public double c;
        public long d;

        public a(int i, double d, double d2, long j) {
            this.f4357a = -1;
            this.f4357a = i;
            this.b = d;
            this.c = d2;
            this.d = j;
        }
    }
}
