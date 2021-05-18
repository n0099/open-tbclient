package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final a f28757a;

    /* renamed from: d  reason: collision with root package name */
    public float f28760d;

    /* renamed from: e  reason: collision with root package name */
    public float f28761e;

    /* renamed from: f  reason: collision with root package name */
    public int f28762f;

    /* renamed from: g  reason: collision with root package name */
    public int f28763g;
    public boolean k;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28758b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28759c = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28764h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28765i = false;
    public final View.OnTouchListener j = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.f28757a.m()) {
                return g.this.f28758b || !g.this.f28759c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                g gVar = g.this;
                gVar.k = gVar.a(motionEvent);
                g.this.f28760d = x;
                g.this.f28761e = y;
                g.this.f28762f = (int) x;
                g.this.f28763g = (int) y;
                g.this.f28764h = true;
                if (g.this.f28757a != null && g.this.f28759c && !g.this.f28758b) {
                    g.this.f28757a.a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - g.this.f28762f) > 20.0f || Math.abs(y - g.this.f28763g) > 20.0f) {
                    g.this.f28764h = false;
                }
                if (!g.this.f28758b) {
                    g.this.f28764h = true;
                }
                g.this.f28765i = false;
                g.this.f28760d = 0.0f;
                g.this.f28761e = 0.0f;
                g.this.f28762f = 0;
                if (g.this.f28757a != null) {
                    g.this.f28757a.a(view, g.this.f28764h);
                }
                g.this.k = false;
            } else if (action != 2) {
                if (action == 3) {
                    g.this.k = false;
                }
            } else if (g.this.f28758b && !g.this.k) {
                float abs = Math.abs(x - g.this.f28760d);
                float abs2 = Math.abs(y - g.this.f28761e);
                if (!g.this.f28765i) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    g.this.f28765i = true;
                }
                if (g.this.f28757a != null) {
                    g.this.f28757a.l();
                }
                g.this.f28760d = x;
                g.this.f28761e = y;
            }
            return g.this.f28758b || !g.this.f28759c;
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public g(a aVar) {
        this.f28757a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.f28759c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            int c2 = al.c(p.a().getApplicationContext());
            int d2 = al.d(p.a().getApplicationContext());
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = c2;
            if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
                float f3 = d2;
                if (rawY > 0.01f * f3 && rawY < f3 * 0.99f) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
