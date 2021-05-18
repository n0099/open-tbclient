package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f20386e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f20387f;

    /* renamed from: g  reason: collision with root package name */
    public c f20388g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f20389h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20390i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f20391e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f20391e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f20391e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f20387f = null;
        this.f20388g = null;
        this.f20390i = true;
        d();
    }

    public final void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        int i3 = this.f20386e;
        if (i3 == 0) {
            if (this.f20388g != null && this.f20390i && getVisibility() == 0) {
                this.f20388g.a(this);
            }
            setText(String.valueOf(this.f20386e));
            this.f20387f.removeCallbacksAndMessages(null);
            return;
        }
        if (i3 > 0) {
            setText(String.valueOf(i3));
        }
        this.f20387f.removeCallbacks(this.f20389h);
        this.f20387f.postDelayed(this.f20389h, 1000L);
        this.f20386e -= i2;
    }

    public final void c() {
        this.f20387f.removeCallbacksAndMessages(null);
    }

    public final void d() {
        this.f20389h = new b();
        this.f20387f = new Handler();
    }

    public void e() {
        b(1);
    }

    public void f(int i2) {
        this.f20386e = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b(0);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void setEnableTimeoutListener(boolean z) {
        this.f20390i = z;
    }

    public void setTimeoutListener(c cVar) {
        this.f20388g = cVar;
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20387f = null;
        this.f20388g = null;
        this.f20390i = true;
        d();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20387f = null;
        this.f20388g = null;
        this.f20390i = true;
        d();
    }
}
