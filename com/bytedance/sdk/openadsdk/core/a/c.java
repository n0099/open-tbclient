package com.bytedance.sdk.openadsdk.core.a;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.openadsdk.core.h.j;
import com.bytedance.sdk.openadsdk.core.p;
/* loaded from: classes6.dex */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected static int A;

    /* renamed from: a  reason: collision with root package name */
    private static float f6445a;

    /* renamed from: b  reason: collision with root package name */
    private static float f6446b;
    private static float c;
    private static float d;
    private static long e;
    protected SparseArray<a> B = new SparseArray<>();
    protected int r;
    protected int s;
    protected int t;
    protected int u;
    protected long v;
    protected long w;
    protected int x;
    protected int y;
    protected int z;

    protected abstract void a(View view, int i, int i2, int i3, int i4);

    static {
        A = 8;
        if (ViewConfiguration.get(p.a()) != null) {
            A = ViewConfiguration.get(p.a()).getScaledTouchSlop();
        }
        f6445a = 0.0f;
        f6446b = 0.0f;
        c = 0.0f;
        d = 0.0f;
        e = 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j.a()) {
            a(view, this.r, this.s, this.t, this.u);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i = -1;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.r = (int) motionEvent.getRawX();
                this.s = (int) motionEvent.getRawY();
                this.v = System.currentTimeMillis();
                this.x = motionEvent.getToolType(0);
                this.y = motionEvent.getDeviceId();
                this.z = motionEvent.getSource();
                e = System.currentTimeMillis();
                i = 0;
                break;
            case 1:
                this.t = (int) motionEvent.getRawX();
                this.u = (int) motionEvent.getRawY();
                this.w = System.currentTimeMillis();
                i = 3;
                break;
            case 2:
                c += Math.abs(motionEvent.getX() - f6445a);
                d += Math.abs(motionEvent.getY() - f6446b);
                f6445a = motionEvent.getX();
                f6446b = motionEvent.getY();
                if (System.currentTimeMillis() - e > 200 && (c > A || d > A)) {
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
        if (this.B.get(motionEvent.getActionMasked()) == null) {
            this.B.put(motionEvent.getActionMasked(), new a(i, motionEvent.getSize(), motionEvent.getPressure(), System.currentTimeMillis()));
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6447a;

        /* renamed from: b  reason: collision with root package name */
        public double f6448b;
        public double c;
        public long d;

        public a(int i, double d, double d2, long j) {
            this.f6447a = -1;
            this.f6447a = i;
            this.f6448b = d;
            this.c = d2;
            this.d = j;
        }
    }
}
