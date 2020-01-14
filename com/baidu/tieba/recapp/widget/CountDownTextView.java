package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    private int bju;
    private Runnable dYQ;
    private b jMW;
    private boolean jMX;
    private Handler mHandler;

    /* loaded from: classes11.dex */
    public interface b {
        void bq(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.jMW = null;
        this.jMX = true;
        cCl();
    }

    private void cCl() {
        this.dYQ = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.jMW = null;
        this.jMX = true;
        cCl();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.jMW = null;
        this.jMX = true;
        cCl();
    }

    public void update(int i) {
        this.bju = i;
    }

    public void startCountDown() {
        nW(1);
    }

    public void setTimeoutListener(b bVar) {
        this.jMW = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.jMX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> dYl;

        private a(CountDownTextView countDownTextView) {
            this.dYl = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dYl.get();
            if (countDownTextView != null) {
                countDownTextView.nW(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        if (i > 0) {
            if (this.bju == 0) {
                if (this.jMW != null && this.jMX && getVisibility() == 0) {
                    this.jMW.bq(this);
                }
                setText(String.valueOf(this.bju));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bju > 0) {
                setText(String.valueOf(this.bju));
            }
            this.mHandler.removeCallbacks(this.dYQ);
            this.mHandler.postDelayed(this.dYQ, 1000L);
            this.bju -= i;
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
        aXc();
    }

    private void aXc() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
