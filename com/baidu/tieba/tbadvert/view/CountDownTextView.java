package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes26.dex */
public class CountDownTextView extends TextView {
    private int cwb;
    private final Runnable fHL;
    private Handler mHandler;
    private b mIL;
    private String mText;

    /* loaded from: classes26.dex */
    public interface b {
        void bL(View view);
    }

    /* loaded from: classes26.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fHd;

        private a(CountDownTextView countDownTextView) {
            this.fHd = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fHd.get();
            if (countDownTextView != null) {
                countDownTextView.sZ(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cwb = 0;
        this.mText = "";
        this.mIL = null;
        this.mHandler = new Handler();
        this.fHL = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.mIL = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sZ(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGk();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sZ(0);
        } else {
            bGk();
        }
    }

    public void ay(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cwb = i;
        }
    }

    private void bGk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ(int i) {
        this.cwb -= i;
        if (this.cwb == 0) {
            if (this.mIL != null) {
                this.mIL.bL(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cwb > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cwb)));
        }
        this.mHandler.removeCallbacks(this.fHL);
        this.mHandler.postDelayed(this.fHL, 1000L);
    }
}
