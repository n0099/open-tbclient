package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String alJ;
    private int aqh;
    private final Runnable cQM;
    private b iKi;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bh(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> cQj;

        private a(CountDownTextView countDownTextView) {
            this.cQj = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cQj.get();
            if (countDownTextView != null) {
                countDownTextView.lE(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aqh = 0;
        this.alJ = "";
        this.iKi = null;
        this.mHandler = new Handler();
        this.cQM = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.iKi = bVar;
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

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            lE(0);
        } else {
            axH();
        }
    }

    public void al(String str, int i) {
        this.alJ = str;
        if (i > 0) {
            this.aqh = i;
        }
    }

    private void axH() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        this.aqh -= i;
        if (this.aqh == 0) {
            if (this.iKi != null) {
                this.iKi.bh(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aqh > 0) {
            setText(String.format("%s %s", this.alJ, Integer.valueOf(this.aqh)));
        }
        this.mHandler.removeCallbacks(this.cQM);
        this.mHandler.postDelayed(this.cQM, 1000L);
    }
}
