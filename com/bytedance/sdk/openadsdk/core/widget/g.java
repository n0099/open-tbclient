package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final a f7112a;
    private float d;
    private float e;
    private int f;
    private int g;
    private boolean k;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7113b = false;
    private boolean c = false;
    private boolean h = true;
    private boolean i = false;
    private final View.OnTouchListener j = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.f7112a.m()) {
                return g.this.f7113b || !g.this.c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    g.this.k = g.this.a(motionEvent);
                    g.this.d = x;
                    g.this.e = y;
                    g.this.f = (int) x;
                    g.this.g = (int) y;
                    g.this.h = true;
                    if (g.this.f7112a != null && g.this.c && !g.this.f7113b) {
                        g.this.f7112a.a(view, true);
                        break;
                    }
                    break;
                case 1:
                    if (Math.abs(x - g.this.f) > 20.0f || Math.abs(y - g.this.g) > 20.0f) {
                        g.this.h = false;
                    }
                    if (!g.this.f7113b) {
                        g.this.h = true;
                    }
                    g.this.i = false;
                    g.this.d = 0.0f;
                    g.this.e = 0.0f;
                    g.this.f = 0;
                    if (g.this.f7112a != null) {
                        g.this.f7112a.a(view, g.this.h);
                    }
                    g.this.k = false;
                    break;
                case 2:
                    if (g.this.f7113b && !g.this.k) {
                        float abs = Math.abs(x - g.this.d);
                        float abs2 = Math.abs(y - g.this.e);
                        if (!g.this.i) {
                            if (abs <= 20.0f && abs2 <= 20.0f) {
                                return true;
                            }
                            g.this.i = true;
                        }
                        if (g.this.f7112a != null) {
                            g.this.f7112a.l();
                        }
                        g.this.d = x;
                        g.this.e = y;
                        break;
                    }
                    break;
                case 3:
                    g.this.k = false;
                    break;
            }
            return g.this.f7113b || !g.this.c;
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public g(a aVar) {
        this.f7112a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            int c = ak.c(p.a().getApplicationContext());
            int d = ak.d(p.a().getApplicationContext());
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            return rawX <= ((float) c) * 0.01f || rawX >= ((float) c) * 0.99f || rawY <= ((float) d) * 0.01f || rawY >= ((float) d) * 0.99f;
        }
        return false;
    }
}
