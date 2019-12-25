package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int biF;
    private Runnable dYH;
    private b jJp;
    private boolean jJq;
    private Handler mHandler;

    /* loaded from: classes10.dex */
    public interface b {
        void bm(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.jJp = null;
        this.jJq = true;
        cBd();
    }

    private void cBd() {
        this.dYH = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.jJp = null;
        this.jJq = true;
        cBd();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.jJp = null;
        this.jJq = true;
        cBd();
    }

    public void update(int i) {
        this.biF = i;
    }

    public void startCountDown() {
        nW(1);
    }

    public void setTimeoutListener(b bVar) {
        this.jJp = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.jJq = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> dYc;

        private a(CountDownTextView countDownTextView) {
            this.dYc = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dYc.get();
            if (countDownTextView != null) {
                countDownTextView.nW(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        if (i > 0) {
            if (this.biF == 0) {
                if (this.jJp != null && this.jJq && getVisibility() == 0) {
                    this.jJp.bm(this);
                }
                setText(String.valueOf(this.biF));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.biF > 0) {
                setText(String.valueOf(this.biF));
            }
            this.mHandler.removeCallbacks(this.dYH);
            this.mHandler.postDelayed(this.dYH, 1000L);
            this.biF -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        nW(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aWI();
    }

    private void aWI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
