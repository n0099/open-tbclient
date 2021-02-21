package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private final Runnable glu;
    private int mCounter;
    private Handler mHandler;
    private String mText;
    private b nBW;

    /* loaded from: classes8.dex */
    public interface b {
        void cf(View view);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> gks;

        private a(CountDownTextView countDownTextView) {
            this.gks = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gks.get();
            if (countDownTextView != null) {
                countDownTextView.th(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mCounter = 0;
        this.mText = "";
        this.nBW = null;
        this.mHandler = new Handler();
        this.glu = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.nBW = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        th(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMO();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            th(0);
        } else {
            bMO();
        }
    }

    public void aE(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.mCounter = i;
        }
    }

    private void bMO() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        this.mCounter -= i;
        if (this.mCounter == 0) {
            if (this.nBW != null) {
                this.nBW.cf(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.mCounter > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.mCounter)));
        }
        this.mHandler.removeCallbacks(this.glu);
        this.mHandler.postDelayed(this.glu, 1000L);
    }
}
