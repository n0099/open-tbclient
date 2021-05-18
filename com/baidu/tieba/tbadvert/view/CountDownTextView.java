package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f20980e;

    /* renamed from: f  reason: collision with root package name */
    public String f20981f;

    /* renamed from: g  reason: collision with root package name */
    public c f20982g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f20983h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f20984i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f20985e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f20985e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f20985e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f20980e = 0;
        this.f20981f = "";
        this.f20982g = null;
        this.f20983h = new Handler();
        this.f20984i = new b();
    }

    public final void b(int i2) {
        int i3 = this.f20980e - i2;
        this.f20980e = i3;
        if (i3 == 0) {
            c cVar = this.f20982g;
            if (cVar != null) {
                cVar.a(this);
            }
            this.f20983h.removeCallbacksAndMessages(null);
            return;
        }
        if (i3 > 0) {
            setText(String.format("%s %s", this.f20981f, Integer.valueOf(i3)));
        }
        this.f20983h.removeCallbacks(this.f20984i);
        this.f20983h.postDelayed(this.f20984i, 1000L);
    }

    public final void c() {
        this.f20983h.removeCallbacksAndMessages(null);
    }

    public void d(String str, int i2) {
        this.f20981f = str;
        if (i2 > 0) {
            this.f20980e = i2;
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
        this.f20982g = cVar;
    }
}
