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
    private int bnF;
    private Runnable ecV;
    private b jNY;
    private boolean jNZ;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bq(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.jNY = null;
        this.jNZ = true;
        cDK();
    }

    private void cDK() {
        this.ecV = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.jNY = null;
        this.jNZ = true;
        cDK();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.jNY = null;
        this.jNZ = true;
        cDK();
    }

    public void update(int i) {
        this.bnF = i;
    }

    public void startCountDown() {
        on(1);
    }

    public void setTimeoutListener(b bVar) {
        this.jNY = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.jNZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecq;

        private a(CountDownTextView countDownTextView) {
            this.ecq = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecq.get();
            if (countDownTextView != null) {
                countDownTextView.on(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        if (i > 0) {
            if (this.bnF == 0) {
                if (this.jNY != null && this.jNZ && getVisibility() == 0) {
                    this.jNY.bq(this);
                }
                setText(String.valueOf(this.bnF));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bnF > 0) {
                setText(String.valueOf(this.bnF));
            }
            this.mHandler.removeCallbacks(this.ecV);
            this.mHandler.postDelayed(this.ecV, 1000L);
            this.bnF -= i;
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
        aZt();
    }

    private void aZt() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
