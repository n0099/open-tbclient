package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes26.dex */
public class CountDownTextView extends TextView {
    private int cKq;
    private final Runnable fVW;
    private Handler mHandler;
    private String mText;
    private b nbp;

    /* loaded from: classes26.dex */
    public interface b {
        void bQ(View view);
    }

    /* loaded from: classes26.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fVo;

        private a(CountDownTextView countDownTextView) {
            this.fVo = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fVo.get();
            if (countDownTextView != null) {
                countDownTextView.tu(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cKq = 0;
        this.mText = "";
        this.nbp = null;
        this.mHandler = new Handler();
        this.fVW = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.nbp = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tu(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bKC();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tu(0);
        } else {
            bKC();
        }
    }

    public void aA(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cKq = i;
        }
    }

    private void bKC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
        this.cKq -= i;
        if (this.cKq == 0) {
            if (this.nbp != null) {
                this.nbp.bQ(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cKq > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cKq)));
        }
        this.mHandler.removeCallbacks(this.fVW);
        this.mHandler.postDelayed(this.fVW, 1000L);
    }
}
