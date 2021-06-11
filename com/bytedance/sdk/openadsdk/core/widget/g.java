package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final a f28789a;

    /* renamed from: d  reason: collision with root package name */
    public float f28792d;

    /* renamed from: e  reason: collision with root package name */
    public float f28793e;

    /* renamed from: f  reason: collision with root package name */
    public int f28794f;

    /* renamed from: g  reason: collision with root package name */
    public int f28795g;
    public boolean k;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28790b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28791c = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28796h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28797i = false;
    public final View.OnTouchListener j = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.g.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (g.this.f28789a.m()) {
                return g.this.f28790b || !g.this.f28791c;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                g gVar = g.this;
                gVar.k = gVar.a(motionEvent);
                g.this.f28792d = x;
                g.this.f28793e = y;
                g.this.f28794f = (int) x;
                g.this.f28795g = (int) y;
                g.this.f28796h = true;
                if (g.this.f28789a != null && g.this.f28791c && !g.this.f28790b) {
                    g.this.f28789a.a(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - g.this.f28794f) > 20.0f || Math.abs(y - g.this.f28795g) > 20.0f) {
                    g.this.f28796h = false;
                }
                if (!g.this.f28790b) {
                    g.this.f28796h = true;
                }
                g.this.f28797i = false;
                g.this.f28792d = 0.0f;
                g.this.f28793e = 0.0f;
                g.this.f28794f = 0;
                if (g.this.f28789a != null) {
                    g.this.f28789a.a(view, g.this.f28796h);
                }
                g.this.k = false;
            } else if (action != 2) {
                if (action == 3) {
                    g.this.k = false;
                }
            } else if (g.this.f28790b && !g.this.k) {
                float abs = Math.abs(x - g.this.f28792d);
                float abs2 = Math.abs(y - g.this.f28793e);
                if (!g.this.f28797i) {
                    if (abs <= 20.0f && abs2 <= 20.0f) {
                        return true;
                    }
                    g.this.f28797i = true;
                }
                if (g.this.f28789a != null) {
                    g.this.f28789a.l();
                }
                g.this.f28792d = x;
                g.this.f28793e = y;
            }
            return g.this.f28790b || !g.this.f28791c;
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view, boolean z);

        void l();

        boolean m();
    }

    public g(a aVar) {
        this.f28789a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.f28791c = z;
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
