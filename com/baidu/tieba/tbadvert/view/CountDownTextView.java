package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes20.dex */
public class CountDownTextView extends TextView {
    private int cbI;
    private final Runnable fgR;
    private b lRA;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes20.dex */
    public interface b {
        void bB(View view);
    }

    /* loaded from: classes20.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fgj;

        private a(CountDownTextView countDownTextView) {
            this.fgj = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fgj.get();
            if (countDownTextView != null) {
                countDownTextView.pX(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cbI = 0;
        this.mText = "";
        this.lRA = null;
        this.mHandler = new Handler();
        this.fgR = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.lRA = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pX(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        btq();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            pX(0);
        } else {
            btq();
        }
    }

    public void au(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cbI = i;
        }
    }

    private void btq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pX(int i) {
        this.cbI -= i;
        if (this.cbI == 0) {
            if (this.lRA != null) {
                this.lRA.bB(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cbI > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cbI)));
        }
        this.mHandler.removeCallbacks(this.fgR);
        this.mHandler.postDelayed(this.fgR, 1000L);
    }
}
