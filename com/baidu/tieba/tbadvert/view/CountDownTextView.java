package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String alO;
    private int aqm;
    private final Runnable cQP;
    private b iJU;
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
                countDownTextView.lD(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aqm = 0;
        this.alO = "";
        this.iJU = null;
        this.mHandler = new Handler();
        this.cQP = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.iJU = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lD(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axE();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            lD(0);
        } else {
            axE();
        }
    }

    public void al(String str, int i) {
        this.alO = str;
        if (i > 0) {
            this.aqm = i;
        }
    }

    private void axE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(int i) {
        this.aqm -= i;
        if (this.aqm == 0) {
            if (this.iJU != null) {
                this.iJU.bh(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aqm > 0) {
            setText(String.format("%s %s", this.alO, Integer.valueOf(this.aqm)));
        }
        this.mHandler.removeCallbacks(this.cQP);
        this.mHandler.postDelayed(this.cQP, 1000L);
    }
}
