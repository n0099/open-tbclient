package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes25.dex */
public class CountDownTextView extends TextView {
    private int cjJ;
    private final Runnable fvC;
    private Handler mHandler;
    private String mText;
    private b mtb;

    /* loaded from: classes25.dex */
    public interface b {
        void bH(View view);
    }

    /* loaded from: classes25.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fuU;

        private a(CountDownTextView countDownTextView) {
            this.fuU = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fuU.get();
            if (countDownTextView != null) {
                countDownTextView.sB(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cjJ = 0;
        this.mText = "";
        this.mtb = null;
        this.mHandler = new Handler();
        this.fvC = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.mtb = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sB(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sB(0);
        } else {
            bDy();
        }
    }

    public void ax(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cjJ = i;
        }
    }

    private void bDy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        this.cjJ -= i;
        if (this.cjJ == 0) {
            if (this.mtb != null) {
                this.mtb.bH(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cjJ > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cjJ)));
        }
        this.mHandler.removeCallbacks(this.fvC);
        this.mHandler.postDelayed(this.fvC, 1000L);
    }
}
