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
    private int bnS;
    private Runnable edy;
    private b jPM;
    private boolean jPN;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bq(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.jPM = null;
        this.jPN = true;
        cEf();
    }

    private void cEf() {
        this.edy = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.jPM = null;
        this.jPN = true;
        cEf();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.jPM = null;
        this.jPN = true;
        cEf();
    }

    public void update(int i) {
        this.bnS = i;
    }

    public void startCountDown() {
        op(1);
    }

    public void setTimeoutListener(b bVar) {
        this.jPM = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.jPN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecT;

        private a(CountDownTextView countDownTextView) {
            this.ecT = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecT.get();
            if (countDownTextView != null) {
                countDownTextView.op(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(int i) {
        if (i > 0) {
            if (this.bnS == 0) {
                if (this.jPM != null && this.jPN && getVisibility() == 0) {
                    this.jPM.bq(this);
                }
                setText(String.valueOf(this.bnS));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bnS > 0) {
                setText(String.valueOf(this.bnS));
            }
            this.mHandler.removeCallbacks(this.edy);
            this.mHandler.postDelayed(this.edy, 1000L);
            this.bnS -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        op(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZy();
    }

    private void aZy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
