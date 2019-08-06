package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String amD;
    private int aqW;
    private final Runnable daL;
    private b jkt;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dac;

        private a(CountDownTextView countDownTextView) {
            this.dac = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dac.get();
            if (countDownTextView != null) {
                countDownTextView.mA(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aqW = 0;
        this.amD = "";
        this.jkt = null;
        this.mHandler = new Handler();
        this.daL = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.jkt = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mA(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEf();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            mA(0);
        } else {
            aEf();
        }
    }

    public void ah(String str, int i) {
        this.amD = str;
        if (i > 0) {
            this.aqW = i;
        }
    }

    private void aEf() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(int i) {
        this.aqW -= i;
        if (this.aqW == 0) {
            if (this.jkt != null) {
                this.jkt.bp(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aqW > 0) {
            setText(String.format("%s %s", this.amD, Integer.valueOf(this.aqW)));
        }
        this.mHandler.removeCallbacks(this.daL);
        this.mHandler.postDelayed(this.daL, 1000L);
    }
}
