package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f21136e;

    /* renamed from: f  reason: collision with root package name */
    public String f21137f;

    /* renamed from: g  reason: collision with root package name */
    public c f21138g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f21139h;
    public final Runnable i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f21140e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f21140e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f21140e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f21136e = 0;
        this.f21137f = "";
        this.f21138g = null;
        this.f21139h = new Handler();
        this.i = new b();
    }

    public final void b(int i) {
        int i2 = this.f21136e - i;
        this.f21136e = i2;
        if (i2 == 0) {
            c cVar = this.f21138g;
            if (cVar != null) {
                cVar.a(this);
            }
            this.f21139h.removeCallbacksAndMessages(null);
            return;
        }
        if (i2 > 0) {
            setText(String.format("%s %s", this.f21137f, Integer.valueOf(i2)));
        }
        this.f21139h.removeCallbacks(this.i);
        this.f21139h.postDelayed(this.i, 1000L);
    }

    public final void c() {
        this.f21139h.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i) {
        this.f21137f = str;
        if (i > 0) {
            this.f21136e = i;
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
        this.f21138g = cVar;
    }
}
