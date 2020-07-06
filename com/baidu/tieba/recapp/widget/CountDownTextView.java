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
    private int cab;
    private Runnable fcp;
    private b llZ;
    private boolean lma;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bv(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.llZ = null;
        this.lma = true;
        dam();
    }

    private void dam() {
        this.fcp = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.llZ = null;
        this.lma = true;
        dam();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.llZ = null;
        this.lma = true;
        dam();
    }

    public void update(int i) {
        this.cab = i;
    }

    public void startCountDown() {
        pK(1);
    }

    public void setTimeoutListener(b bVar) {
        this.llZ = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.lma = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fbH;

        private a(CountDownTextView countDownTextView) {
            this.fbH = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fbH.get();
            if (countDownTextView != null) {
                countDownTextView.pK(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(int i) {
        if (i > 0) {
            if (this.cab == 0) {
                if (this.llZ != null && this.lma && getVisibility() == 0) {
                    this.llZ.bv(this);
                }
                setText(String.valueOf(this.cab));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cab > 0) {
                setText(String.valueOf(this.cab));
            }
            this.mHandler.removeCallbacks(this.fcp);
            this.mHandler.postDelayed(this.fcp, 1000L);
            this.cab -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pK(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bqo();
    }

    private void bqo() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
