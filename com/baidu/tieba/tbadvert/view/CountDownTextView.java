package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21736e;

    /* renamed from: f  reason: collision with root package name */
    public String f21737f;

    /* renamed from: g  reason: collision with root package name */
    public c f21738g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f21739h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f21740i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f21741e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f21741e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f21741e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f21736e = 0;
        this.f21737f = "";
        this.f21738g = null;
        this.f21739h = new Handler();
        this.f21740i = new b();
    }

    public final void b(int i2) {
        int i3 = this.f21736e - i2;
        this.f21736e = i3;
        if (i3 == 0) {
            c cVar = this.f21738g;
            if (cVar != null) {
                cVar.a(this);
            }
            this.f21739h.removeCallbacksAndMessages(null);
            return;
        }
        if (i3 > 0) {
            setText(String.format("%s %s", this.f21737f, Integer.valueOf(i3)));
        }
        this.f21739h.removeCallbacks(this.f21740i);
        this.f21739h.postDelayed(this.f21740i, 1000L);
    }

    public final void c() {
        this.f21739h.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i2) {
        this.f21737f = str;
        if (i2 > 0) {
            this.f21736e = i2;
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
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 0) {
            b(0);
        } else {
            c();
        }
    }

    public void setTimeoutListener(c cVar) {
        this.f21738g = cVar;
    }
}
