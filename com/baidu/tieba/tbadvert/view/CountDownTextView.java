package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String alI;
    private int aqg;
    private final Runnable cQP;
    private b iKq;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bh(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
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

    public CountDownTextView(Context context) {
        super(context);
        this.aqg = 0;
        this.alI = "";
        this.iKq = null;
        this.mHandler = new Handler();
        this.cQP = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.iKq = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lE(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axI();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            lE(0);
        } else {
            axI();
        }
    }

    public void al(String str, int i) {
        this.alI = str;
        if (i > 0) {
            this.aqg = i;
        }
    }

    private void axI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        this.aqg -= i;
        if (this.aqg == 0) {
            if (this.iKq != null) {
                this.iKq.bh(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aqg > 0) {
            setText(String.format("%s %s", this.alI, Integer.valueOf(this.aqg)));
        }
        this.mHandler.removeCallbacks(this.cQP);
        this.mHandler.postDelayed(this.cQP, 1000L);
    }
}
