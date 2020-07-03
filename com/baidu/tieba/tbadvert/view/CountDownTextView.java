package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int cab;
    private final Runnable fcp;
    private b lKj;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes13.dex */
    public interface b {
        void bv(View view);
    }

    /* loaded from: classes13.dex */
    private static class a implements Runnable {
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

    public CountDownTextView(Context context) {
        super(context);
        this.cab = 0;
        this.mText = "";
        this.lKj = null;
        this.mHandler = new Handler();
        this.fcp = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.lKj = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pK(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bqn();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            pK(0);
        } else {
            bqn();
        }
    }

    public void av(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cab = i;
        }
    }

    private void bqn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(int i) {
        this.cab -= i;
        if (this.cab == 0) {
            if (this.lKj != null) {
                this.lKj.bv(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cab > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cab)));
        }
        this.mHandler.removeCallbacks(this.fcp);
        this.mHandler.postDelayed(this.fcp, 1000L);
    }
}
