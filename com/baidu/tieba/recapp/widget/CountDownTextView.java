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
    private int bnG;
    private Runnable edi;
    private b jOk;
    private boolean jOl;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bq(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.jOk = null;
        this.jOl = true;
        cDL();
    }

    private void cDL() {
        this.edi = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.jOk = null;
        this.jOl = true;
        cDL();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.jOk = null;
        this.jOl = true;
        cDL();
    }

    public void update(int i) {
        this.bnG = i;
    }

    public void startCountDown() {
        on(1);
    }

    public void setTimeoutListener(b bVar) {
        this.jOk = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.jOl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecD;

        private a(CountDownTextView countDownTextView) {
            this.ecD = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecD.get();
            if (countDownTextView != null) {
                countDownTextView.on(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        if (i > 0) {
            if (this.bnG == 0) {
                if (this.jOk != null && this.jOl && getVisibility() == 0) {
                    this.jOk.bq(this);
                }
                setText(String.valueOf(this.bnG));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bnG > 0) {
                setText(String.valueOf(this.bnG));
            }
            this.mHandler.removeCallbacks(this.edi);
            this.mHandler.postDelayed(this.edi, 1000L);
            this.bnG -= i;
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
        aZu();
    }

    private void aZu() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
