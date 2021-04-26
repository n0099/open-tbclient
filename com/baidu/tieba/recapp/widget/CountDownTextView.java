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
    public int f21142e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f21143f;

    /* renamed from: g  reason: collision with root package name */
    public c f21144g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f21145h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21146i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f21147e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f21147e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f21147e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f21143f = null;
        this.f21144g = null;
        this.f21146i = true;
        d();
    }

    public final void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        int i3 = this.f21142e;
        if (i3 == 0) {
            if (this.f21144g != null && this.f21146i && getVisibility() == 0) {
                this.f21144g.a(this);
            }
            setText(String.valueOf(this.f21142e));
            this.f21143f.removeCallbacksAndMessages(null);
            return;
        }
        if (i3 > 0) {
            setText(String.valueOf(i3));
        }
        this.f21143f.removeCallbacks(this.f21145h);
        this.f21143f.postDelayed(this.f21145h, 1000L);
        this.f21142e -= i2;
    }

    public final void c() {
        this.f21143f.removeCallbacksAndMessages(null);
    }

    public final void d() {
        this.f21145h = new b();
        this.f21143f = new Handler();
    }

    public void e() {
        b(1);
    }

    public void f(int i2) {
        this.f21142e = i2;
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
        this.f21146i = z;
    }

    public void setTimeoutListener(c cVar) {
        this.f21144g = cVar;
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21143f = null;
        this.f21144g = null;
        this.f21146i = true;
        d();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21143f = null;
        this.f21144g = null;
        this.f21146i = true;
        d();
    }
}
