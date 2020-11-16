package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes25.dex */
public class CountDownTextView extends TextView {
    private int cIG;
    private final Runnable fVD;
    private Handler mHandler;
    private String mText;
    private b ncq;

    /* loaded from: classes25.dex */
    public interface b {
        void bT(View view);
    }

    /* loaded from: classes25.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fUV;

        private a(CountDownTextView countDownTextView) {
            this.fUV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fUV.get();
            if (countDownTextView != null) {
                countDownTextView.tS(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cIG = 0;
        this.mText = "";
        this.ncq = null;
        this.mHandler = new Handler();
        this.fVD = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.ncq = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tS(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bJV();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tS(0);
        } else {
            bJV();
        }
    }

    public void az(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cIG = i;
        }
    }

    private void bJV() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(int i) {
        this.cIG -= i;
        if (this.cIG == 0) {
            if (this.ncq != null) {
                this.ncq.bT(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cIG > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cIG)));
        }
        this.mHandler.removeCallbacks(this.fVD);
        this.mHandler.postDelayed(this.fVD, 1000L);
    }
}
