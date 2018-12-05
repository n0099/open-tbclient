package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private int bEP;
    private final Runnable bER;
    private b hpl;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> bEo;

        private a(CountDownTextView countDownTextView) {
            this.bEo = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bEo.get();
            if (countDownTextView != null) {
                countDownTextView.hN(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bEP = 0;
        this.mText = "";
        this.hpl = null;
        this.mHandler = new Handler();
        this.bER = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.hpl = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hN(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Xj();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            hN(0);
        } else {
            Xj();
        }
    }

    public void N(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bEP = i;
        }
    }

    private void Xj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hN(int i) {
        this.bEP -= i;
        if (this.bEP == 0) {
            if (this.hpl != null) {
                this.hpl.ak(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bEP > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bEP)));
        }
        this.mHandler.removeCallbacks(this.bER);
        this.mHandler.postDelayed(this.bER, 1000L);
    }
}
