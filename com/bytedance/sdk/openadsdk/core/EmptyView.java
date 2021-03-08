package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class EmptyView extends View implements al.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4354a;
    private boolean b;
    private a c;
    private View d;
    private List<View> e;
    @Nullable
    private List<View> f;
    private boolean g;
    private int h;
    private final Handler i;
    private final AtomicBoolean j;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(p.a());
        this.i = new al(Looper.getMainLooper(), this);
        this.j = new AtomicBoolean(true);
        this.d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.c != null) {
            this.c.a(z);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.g = false;
        b();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    private void b() {
        if (this.j.getAndSet(false) && this.c != null) {
            this.c.a();
        }
    }

    private void c() {
        if (!this.j.getAndSet(true) && this.c != null) {
            this.c.b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.g = true;
        c();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    public void setRefClickViews(List<View> list) {
        this.e = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.f = list;
    }

    public void a() {
        a(this.e, null);
        a(this.f, null);
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.a.c cVar) {
        if (com.bytedance.sdk.openadsdk.utils.s.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    private void d() {
        if (this.b && !this.f4354a) {
            this.f4354a = true;
            this.i.sendEmptyMessage(1);
        }
    }

    private void e() {
        if (this.f4354a) {
            this.i.removeCallbacksAndMessages(null);
            this.f4354a = false;
        }
    }

    public void setNeedCheckingShow(boolean z) {
        this.b = z;
        if (!z && this.f4354a) {
            e();
        } else if (z && !this.f4354a) {
            d();
        }
    }

    public void setCallback(a aVar) {
        this.c = aVar;
    }

    public void setAdType(int i) {
        this.h = i;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                if (this.f4354a) {
                    if (y.a(this.d, 20, this.h)) {
                        e();
                        this.i.sendEmptyMessageDelayed(2, 1000L);
                        if (this.c != null) {
                            this.c.a(this.d);
                            return;
                        }
                        return;
                    }
                    this.i.sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                return;
            case 2:
                boolean a2 = aj.a();
                if (y.a(this.d, 20, this.h) || !a2) {
                    this.i.sendEmptyMessageDelayed(2, 1000L);
                    return;
                } else if (!this.g) {
                    setNeedCheckingShow(true);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }
}
