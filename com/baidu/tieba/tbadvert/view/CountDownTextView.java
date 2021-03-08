package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    private final Runnable gnd;
    private int mCounter;
    private Handler mHandler;
    private String mText;
    private b nEb;

    /* loaded from: classes7.dex */
    public interface b {
        void cf(View view);
    }

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> glV;

        private a(CountDownTextView countDownTextView) {
            this.glV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.glV.get();
            if (countDownTextView != null) {
                countDownTextView.tj(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mCounter = 0;
        this.mText = "";
        this.nEb = null;
        this.mHandler = new Handler();
        this.gnd = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.nEb = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMU();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tj(0);
        } else {
            bMU();
        }
    }

    public void aF(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.mCounter = i;
        }
    }

    private void bMU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        this.mCounter -= i;
        if (this.mCounter == 0) {
            if (this.nEb != null) {
                this.nEb.cf(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.mCounter > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.mCounter)));
        }
        this.mHandler.removeCallbacks(this.gnd);
        this.mHandler.postDelayed(this.gnd, 1000L);
    }
}
