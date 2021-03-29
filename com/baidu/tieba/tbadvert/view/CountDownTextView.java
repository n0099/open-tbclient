package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21451e;

    /* renamed from: f  reason: collision with root package name */
    public String f21452f;

    /* renamed from: g  reason: collision with root package name */
    public c f21453g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f21454h;
    public final Runnable i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f21455e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f21455e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f21455e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f21451e = 0;
        this.f21452f = "";
        this.f21453g = null;
        this.f21454h = new Handler();
        this.i = new b();
    }

    public final void b(int i) {
        int i2 = this.f21451e - i;
        this.f21451e = i2;
        if (i2 == 0) {
            c cVar = this.f21453g;
            if (cVar != null) {
                cVar.a(this);
            }
            this.f21454h.removeCallbacksAndMessages(null);
            return;
        }
        if (i2 > 0) {
            setText(String.format("%s %s", this.f21452f, Integer.valueOf(i2)));
        }
        this.f21454h.removeCallbacks(this.i);
        this.f21454h.postDelayed(this.i, 1000L);
    }

    public final void c() {
        this.f21454h.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i) {
        this.f21452f = str;
        if (i > 0) {
            this.f21451e = i;
        }
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
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            b(0);
        } else {
            c();
        }
    }

    public void setTimeoutListener(c cVar) {
        this.f21453g = cVar;
    }
}
