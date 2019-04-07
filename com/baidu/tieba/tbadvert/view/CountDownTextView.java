package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String alN;
    private int aql;
    private final Runnable cQO;
    private b iJT;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bh(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> cQl;

        private a(CountDownTextView countDownTextView) {
            this.cQl = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cQl.get();
            if (countDownTextView != null) {
                countDownTextView.lD(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aql = 0;
        this.alN = "";
        this.iJT = null;
        this.mHandler = new Handler();
        this.cQO = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.iJT = bVar;
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
        this.alN = str;
        if (i > 0) {
            this.aql = i;
        }
    }

    private void axE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(int i) {
        this.aql -= i;
        if (this.aql == 0) {
            if (this.iJT != null) {
                this.iJT.bh(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aql > 0) {
            setText(String.format("%s %s", this.alN, Integer.valueOf(this.aql)));
        }
        this.mHandler.removeCallbacks(this.cQO);
        this.mHandler.postDelayed(this.cQO, 1000L);
    }
}
