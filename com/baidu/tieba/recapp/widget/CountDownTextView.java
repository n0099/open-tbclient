package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class CountDownTextView extends TextView {

    /* renamed from: e  reason: collision with root package name */
    public int f20591e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f20592f;

    /* renamed from: g  reason: collision with root package name */
    public c f20593g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f20594h;
    public boolean i;

    /* loaded from: classes4.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f20595e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f20595e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f20595e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f20592f = null;
        this.f20593g = null;
        this.i = true;
        d();
    }

    public final void b(int i) {
        if (i <= 0) {
            return;
        }
        int i2 = this.f20591e;
        if (i2 == 0) {
            if (this.f20593g != null && this.i && getVisibility() == 0) {
                this.f20593g.a(this);
            }
            setText(String.valueOf(this.f20591e));
            this.f20592f.removeCallbacksAndMessages(null);
            return;
        }
        if (i2 > 0) {
            setText(String.valueOf(i2));
        }
        this.f20592f.removeCallbacks(this.f20594h);
        this.f20592f.postDelayed(this.f20594h, 1000L);
        this.f20591e -= i;
    }

    public final void c() {
        this.f20592f.removeCallbacksAndMessages(null);
    }

    public final void d() {
        this.f20594h = new b();
        this.f20592f = new Handler();
    }

    public void e() {
        b(1);
    }

    public void f(int i) {
        this.f20591e = i;
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
    }

    public void setEnableTimeoutListener(boolean z) {
        this.i = z;
    }

    public void setTimeoutListener(c cVar) {
        this.f20593g = cVar;
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20592f = null;
        this.f20593g = null;
        this.i = true;
        d();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20592f = null;
        this.f20593g = null;
        this.i = true;
        d();
    }
}
