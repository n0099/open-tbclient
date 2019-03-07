package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private int aqg;
    private Runnable cQP;
    private b ioE;
    private boolean ioF;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bh(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.ioE = null;
        this.ioF = true;
        bXS();
    }

    private void bXS() {
        this.cQP = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.ioE = null;
        this.ioF = true;
        bXS();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.ioE = null;
        this.ioF = true;
        bXS();
    }

    public void update(int i) {
        this.aqg = i;
    }

    public void startCountDown() {
        lE(1);
    }

    public void setTimeoutListener(b bVar) {
        this.ioE = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.ioF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> cQm;

        private a(CountDownTextView countDownTextView) {
            this.cQm = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cQm.get();
            if (countDownTextView != null) {
                countDownTextView.lE(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        if (i > 0) {
            if (this.aqg == 0) {
                if (this.ioE != null && this.ioF && getVisibility() == 0) {
                    this.ioE.bh(this);
                }
                setText(String.valueOf(this.aqg));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aqg > 0) {
                setText(String.valueOf(this.aqg));
            }
            this.mHandler.removeCallbacks(this.cQP);
            this.mHandler.postDelayed(this.cQP, 1000L);
            this.aqg -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lE(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axH();
    }

    private void axH() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
