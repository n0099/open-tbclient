package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bnE;
    private final Runnable ecU;
    private b kkK;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes13.dex */
    public interface b {
        void bq(View view);
    }

    /* loaded from: classes13.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecp;

        private a(CountDownTextView countDownTextView) {
            this.ecp = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecp.get();
            if (countDownTextView != null) {
                countDownTextView.on(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bnE = 0;
        this.mText = "";
        this.kkK = null;
        this.mHandler = new Handler();
        this.ecU = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.kkK = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        on(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZr();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            on(0);
        } else {
            aZr();
        }
    }

    public void al(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bnE = i;
        }
    }

    private void aZr() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void on(int i) {
        this.bnE -= i;
        if (this.bnE == 0) {
            if (this.kkK != null) {
                this.kkK.bq(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bnE > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bnE)));
        }
        this.mHandler.removeCallbacks(this.ecU);
        this.mHandler.postDelayed(this.ecU, 1000L);
    }
}
