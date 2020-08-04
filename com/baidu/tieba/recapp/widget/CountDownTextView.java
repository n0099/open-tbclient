package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes20.dex */
public class CountDownTextView extends TextView {
    private int cbI;
    private Runnable fgR;
    private b ltx;
    private boolean lty;
    private Handler mHandler;

    /* loaded from: classes20.dex */
    public interface b {
        void bB(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.ltx = null;
        this.lty = true;
        ddt();
    }

    private void ddt() {
        this.fgR = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.ltx = null;
        this.lty = true;
        ddt();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.ltx = null;
        this.lty = true;
        ddt();
    }

    public void update(int i) {
        this.cbI = i;
    }

    public void startCountDown() {
        pX(1);
    }

    public void setTimeoutListener(b bVar) {
        this.ltx = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.lty = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fgj;

        private a(CountDownTextView countDownTextView) {
            this.fgj = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fgj.get();
            if (countDownTextView != null) {
                countDownTextView.pX(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        if (i > 0) {
            if (this.cbI == 0) {
                if (this.ltx != null && this.lty && getVisibility() == 0) {
                    this.ltx.bB(this);
                }
                setText(String.valueOf(this.cbI));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cbI > 0) {
                setText(String.valueOf(this.cbI));
            }
            this.mHandler.removeCallbacks(this.fgR);
            this.mHandler.postDelayed(this.fgR, 1000L);
            this.cbI -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pX(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btq();
    }

    private void btq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
