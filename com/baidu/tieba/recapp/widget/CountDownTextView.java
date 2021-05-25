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
    public int f20308e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f20309f;

    /* renamed from: g  reason: collision with root package name */
    public c f20310g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f20311h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f20312i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f20313e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f20313e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f20313e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f20309f = null;
        this.f20310g = null;
        this.f20312i = true;
        d();
    }

    public final void b(int i2) {
        if (i2 <= 0) {
            return;
        }
        int i3 = this.f20308e;
        if (i3 == 0) {
            if (this.f20310g != null && this.f20312i && getVisibility() == 0) {
                this.f20310g.a(this);
            }
            setText(String.valueOf(this.f20308e));
            this.f20309f.removeCallbacksAndMessages(null);
            return;
        }
        if (i3 > 0) {
            setText(String.valueOf(i3));
        }
        this.f20309f.removeCallbacks(this.f20311h);
        this.f20309f.postDelayed(this.f20311h, 1000L);
        this.f20308e -= i2;
    }

    public final void c() {
        this.f20309f.removeCallbacksAndMessages(null);
    }

    public final void d() {
        this.f20311h = new b();
        this.f20309f = new Handler();
    }

    public void e() {
        b(1);
    }

    public void f(int i2) {
        this.f20308e = i2;
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
        this.f20312i = z;
    }

    public void setTimeoutListener(c cVar) {
        this.f20310g = cVar;
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20309f = null;
        this.f20310g = null;
        this.f20312i = true;
        d();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20309f = null;
        this.f20310g = null;
        this.f20312i = true;
        d();
    }
}
