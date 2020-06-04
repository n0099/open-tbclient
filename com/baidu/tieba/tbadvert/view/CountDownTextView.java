package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bVn;
    private final Runnable eSe;
    private b lqB;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes13.dex */
    public interface b {
        void bs(View view);
    }

    /* loaded from: classes13.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> eRw;

        private a(CountDownTextView countDownTextView) {
            this.eRw = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eRw.get();
            if (countDownTextView != null) {
                countDownTextView.pl(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bVn = 0;
        this.mText = "";
        this.lqB = null;
        this.mHandler = new Handler();
        this.eSe = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.lqB = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pl(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bnN();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            pl(0);
        } else {
            bnN();
        }
    }

    public void av(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bVn = i;
        }
    }

    private void bnN() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(int i) {
        this.bVn -= i;
        if (this.bVn == 0) {
            if (this.lqB != null) {
                this.lqB.bs(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bVn > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bVn)));
        }
        this.mHandler.removeCallbacks(this.eSe);
        this.mHandler.postDelayed(this.eSe, 1000L);
    }
}
