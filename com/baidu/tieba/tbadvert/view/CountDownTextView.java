package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21450e;

    /* renamed from: f  reason: collision with root package name */
    public String f21451f;

    /* renamed from: g  reason: collision with root package name */
    public c f21452g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f21453h;
    public final Runnable i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f21454e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f21454e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f21454e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f21450e = 0;
        this.f21451f = "";
        this.f21452g = null;
        this.f21453h = new Handler();
        this.i = new b();
    }

    public final void b(int i) {
        int i2 = this.f21450e - i;
        this.f21450e = i2;
        if (i2 == 0) {
            c cVar = this.f21452g;
            if (cVar != null) {
                cVar.a(this);
            }
            this.f21453h.removeCallbacksAndMessages(null);
            return;
        }
        if (i2 > 0) {
            setText(String.format("%s %s", this.f21451f, Integer.valueOf(i2)));
        }
        this.f21453h.removeCallbacks(this.i);
        this.f21453h.postDelayed(this.i, 1000L);
    }

    public final void c() {
        this.f21453h.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i) {
        this.f21451f = str;
        if (i > 0) {
            this.f21450e = i;
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
        this.f21452g = cVar;
    }
}
