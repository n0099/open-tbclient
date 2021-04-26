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
    public boolean f28539a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28540b;

    /* renamed from: c  reason: collision with root package name */
    public a f28541c;

    /* renamed from: d  reason: collision with root package name */
    public View f28542d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f28543e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f28544f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<View> f28545g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28546h;

    /* renamed from: i  reason: collision with root package name */
    public int f28547i;
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
            this.f28543e = new WeakReference<>((Activity) context);
        }
        this.f28542d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        if (!this.k.getAndSet(false) || (aVar = this.f28541c) == null) {
            return;
        }
        aVar.a();
    }

    private void c() {
        a aVar;
        if (this.k.getAndSet(true) || (aVar = this.f28541c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        if (!this.f28540b || this.f28539a) {
            return;
        }
        this.f28539a = true;
        this.j.sendEmptyMessage(1);
    }

    private void e() {
        if (this.f28539a) {
            this.j.removeCallbacksAndMessages(null);
            this.f28539a = false;
        }
    }

    private boolean f() {
        Activity activity;
        boolean a2 = ak.a();
        WeakReference<Activity> weakReference = this.f28543e;
        boolean z = (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) ? false : true;
        boolean a3 = y.a(this.f28542d, 20, this.f28547i);
        if (!a2) {
            a3 = true;
        }
        if (a2 || !z) {
            return true;
        }
        return a3;
    }

    public void a() {
        a(this.f28544f, null);
        a(this.f28545g, null);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.f28546h = false;
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.f28546h = true;
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
        a aVar = this.f28541c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setAdType(int i2) {
        this.f28547i = i2;
    }

    public void setCallback(a aVar) {
        this.f28541c = aVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.f28540b = z;
        if (!z && this.f28539a) {
            e();
        } else if (!z || this.f28539a) {
        } else {
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.f28544f = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.f28545g = list;
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
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            if (f()) {
                this.j.sendEmptyMessageDelayed(2, 1000L);
            } else if (this.f28546h) {
            } else {
                setNeedCheckingShow(true);
            }
        } else if (this.f28539a) {
            if (y.a(this.f28542d, 20, this.f28547i)) {
                e();
                this.j.sendEmptyMessageDelayed(2, 1000L);
                a aVar = this.f28541c;
                if (aVar != null) {
                    aVar.a(this.f28542d);
                    return;
                }
                return;
            }
            this.j.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
