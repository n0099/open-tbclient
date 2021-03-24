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
    public int f20897e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f20898f;

    /* renamed from: g  reason: collision with root package name */
    public c f20899g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f20900h;
    public boolean i;

    /* loaded from: classes5.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final WeakReference<CountDownTextView> f20901e;

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.f20901e.get();
            if (countDownTextView != null) {
                countDownTextView.b(1);
            }
        }

        public b(CountDownTextView countDownTextView) {
            this.f20901e = new WeakReference<>(countDownTextView);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.f20898f = null;
        this.f20899g = null;
        this.i = true;
        d();
    }

    public final void b(int i) {
        if (i <= 0) {
            return;
        }
        int i2 = this.f20897e;
        if (i2 == 0) {
            if (this.f20899g != null && this.i && getVisibility() == 0) {
                this.f20899g.a(this);
            }
            setText(String.valueOf(this.f20897e));
            this.f20898f.removeCallbacksAndMessages(null);
            return;
        }
        if (i2 > 0) {
            setText(String.valueOf(i2));
        }
        this.f20898f.removeCallbacks(this.f20900h);
        this.f20898f.postDelayed(this.f20900h, 1000L);
        this.f20897e -= i;
    }

    public final void c() {
        this.f20898f.removeCallbacksAndMessages(null);
    }

    public final void d() {
        this.f20900h = new b();
        this.f20898f = new Handler();
    }

    public void e() {
        b(1);
    }

    public void f(int i) {
        this.f20897e = i;
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
        this.f20899g = cVar;
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20898f = null;
        this.f20899g = null;
        this.i = true;
        d();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20898f = null;
        this.f20899g = null;
        this.i = true;
        d();
    }
}
