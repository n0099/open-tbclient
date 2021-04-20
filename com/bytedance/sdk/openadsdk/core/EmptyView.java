package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class EmptyView extends View implements am.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f27693a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27694b;

    /* renamed from: c  reason: collision with root package name */
    public a f27695c;

    /* renamed from: d  reason: collision with root package name */
    public View f27696d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f27697e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f27698f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<View> f27699g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27700h;
    public int i;
    public final Handler j;
    public final AtomicBoolean k;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(View view);

        void a(boolean z);

        void b();
    }

    public EmptyView(Context context, View view) {
        super(p.a());
        this.j = new am(Looper.getMainLooper(), this);
        this.k = new AtomicBoolean(true);
        if (context instanceof Activity) {
            this.f27697e = new WeakReference<>((Activity) context);
        }
        this.f27696d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        if (!this.k.getAndSet(false) || (aVar = this.f27695c) == null) {
            return;
        }
        aVar.a();
    }

    private void c() {
        a aVar;
        if (this.k.getAndSet(true) || (aVar = this.f27695c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        if (!this.f27694b || this.f27693a) {
            return;
        }
        this.f27693a = true;
        this.j.sendEmptyMessage(1);
    }

    private void e() {
        if (this.f27693a) {
            this.j.removeCallbacksAndMessages(null);
            this.f27693a = false;
        }
    }

    private boolean f() {
        Activity activity;
        boolean a2 = ak.a();
        WeakReference<Activity> weakReference = this.f27697e;
        boolean z = (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) ? false : true;
        boolean a3 = y.a(this.f27696d, 20, this.i);
        if (!a2) {
            a3 = true;
        }
        if (a2 || !z) {
            return true;
        }
        return a3;
    }

    public void a() {
        a(this.f27698f, null);
        a(this.f27699g, null);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.f27700h = false;
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.f27700h = true;
        c();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.f27695c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setAdType(int i) {
        this.i = i;
    }

    public void setCallback(a aVar) {
        this.f27695c = aVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.f27694b = z;
        if (!z && this.f27693a) {
            e();
        } else if (!z || this.f27693a) {
        } else {
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.f27698f = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.f27699g = list;
    }

    public void a(List<View> list, com.bytedance.sdk.openadsdk.core.a.c cVar) {
        if (com.bytedance.sdk.openadsdk.utils.s.b(list)) {
            for (View view : list) {
                view.setOnClickListener(cVar);
                view.setOnTouchListener(cVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            if (f()) {
                this.j.sendEmptyMessageDelayed(2, 1000L);
            } else if (this.f27700h) {
            } else {
                setNeedCheckingShow(true);
            }
        } else if (this.f27693a) {
            if (y.a(this.f27696d, 20, this.i)) {
                e();
                this.j.sendEmptyMessageDelayed(2, 1000L);
                a aVar = this.f27695c;
                if (aVar != null) {
                    aVar.a(this.f27696d);
                    return;
                }
                return;
            }
            this.j.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
