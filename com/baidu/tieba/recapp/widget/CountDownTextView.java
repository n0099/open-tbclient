package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bnE;
    private Runnable ecU;
    private b jNW;
    private boolean jNX;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bq(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.jNW = null;
        this.jNX = true;
        cDI();
    }

    private void cDI() {
        this.ecU = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.jNW = null;
        this.jNX = true;
        cDI();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.jNW = null;
        this.jNX = true;
        cDI();
    }

    public void update(int i) {
        this.bnE = i;
    }

    public void startCountDown() {
        on(1);
    }

    public void setTimeoutListener(b bVar) {
        this.jNW = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.jNX = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecp;

        private a(CountDownTextView countDownTextView) {
            this.ecp = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecp.get();
            if (countDownTextView != null) {
                countDownTextView.on(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        if (i > 0) {
            if (this.bnE == 0) {
                if (this.jNW != null && this.jNX && getVisibility() == 0) {
                    this.jNW.bq(this);
                }
                setText(String.valueOf(this.bnE));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bnE > 0) {
                setText(String.valueOf(this.bnE));
            }
            this.mHandler.removeCallbacks(this.ecU);
            this.mHandler.postDelayed(this.ecU, 1000L);
            this.bnE -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        on(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZr();
    }

    private void aZr() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
