package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    private int bju;
    private final Runnable dYQ;
    private b kjO;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes11.dex */
    public interface b {
        void bq(View view);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dYl;

        private a(CountDownTextView countDownTextView) {
            this.dYl = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dYl.get();
            if (countDownTextView != null) {
                countDownTextView.nW(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bju = 0;
        this.mText = "";
        this.kjO = null;
        this.mHandler = new Handler();
        this.dYQ = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.kjO = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        nW(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aXc();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            nW(0);
        } else {
            aXc();
        }
    }

    public void an(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bju = i;
        }
    }

    private void aXc() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        this.bju -= i;
        if (this.bju == 0) {
            if (this.kjO != null) {
                this.kjO.bq(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bju > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bju)));
        }
        this.mHandler.removeCallbacks(this.dYQ);
        this.mHandler.postDelayed(this.dYQ, 1000L);
    }
}
