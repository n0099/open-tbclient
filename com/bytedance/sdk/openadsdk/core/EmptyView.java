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
/* loaded from: classes6.dex */
public class EmptyView extends View implements am.a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f27816a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27817b;

    /* renamed from: c  reason: collision with root package name */
    public a f27818c;

    /* renamed from: d  reason: collision with root package name */
    public View f27819d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Activity> f27820e;

    /* renamed from: f  reason: collision with root package name */
    public List<View> f27821f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public List<View> f27822g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27823h;

    /* renamed from: i  reason: collision with root package name */
    public int f27824i;
    public final Handler j;
    public final AtomicBoolean k;

    /* loaded from: classes6.dex */
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
            this.f27820e = new WeakReference<>((Activity) context);
        }
        this.f27819d = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void b() {
        a aVar;
        if (!this.k.getAndSet(false) || (aVar = this.f27818c) == null) {
            return;
        }
        aVar.a();
    }

    private void c() {
        a aVar;
        if (this.k.getAndSet(true) || (aVar = this.f27818c) == null) {
            return;
        }
        aVar.b();
    }

    private void d() {
        if (!this.f27817b || this.f27816a) {
            return;
        }
        this.f27816a = true;
        this.j.sendEmptyMessage(1);
    }

    private void e() {
        if (this.f27816a) {
            this.j.removeCallbacksAndMessages(null);
            this.f27816a = false;
        }
    }

    private boolean f() {
        Activity activity;
        boolean a2 = ak.a();
        WeakReference<Activity> weakReference = this.f27820e;
        boolean z = (weakReference == null || (activity = weakReference.get()) == null || activity.isFinishing()) ? false : true;
        boolean a3 = y.a(this.f27819d, 20, this.f27824i);
        if (!a2) {
            a3 = true;
        }
        if (a2 || !z) {
            return true;
        }
        return a3;
    }

    public void a() {
        a(this.f27821f, null);
        a(this.f27822g, null);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
        this.f27823h = false;
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
        this.f27823h = true;
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
        a aVar = this.f27818c;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void setAdType(int i2) {
        this.f27824i = i2;
    }

    public void setCallback(a aVar) {
        this.f27818c = aVar;
    }

    public void setNeedCheckingShow(boolean z) {
        this.f27817b = z;
        if (!z && this.f27816a) {
            e();
        } else if (!z || this.f27816a) {
        } else {
            d();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.f27821f = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.f27822g = list;
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
            } else if (this.f27823h) {
            } else {
                setNeedCheckingShow(true);
            }
        } else if (this.f27816a) {
            if (y.a(this.f27819d, 20, this.f27824i)) {
                e();
                this.j.sendEmptyMessageDelayed(2, 1000L);
                a aVar = this.f27818c;
                if (aVar != null) {
                    aVar.a(this.f27819d);
                    return;
                }
                return;
            }
            this.j.sendEmptyMessageDelayed(1, 1000L);
        }
    }
}
