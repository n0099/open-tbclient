package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private int biF;
    private final Runnable dYH;
    private b kgg;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes10.dex */
    public interface b {
        void bm(View view);
    }

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dYc;

        private a(CountDownTextView countDownTextView) {
            this.dYc = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dYc.get();
            if (countDownTextView != null) {
                countDownTextView.nW(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.biF = 0;
        this.mText = "";
        this.kgg = null;
        this.mHandler = new Handler();
        this.dYH = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.kgg = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        nW(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aWI();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            nW(0);
        } else {
            aWI();
        }
    }

    public void am(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.biF = i;
        }
    }

    private void aWI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nW(int i) {
        this.biF -= i;
        if (this.biF == 0) {
            if (this.kgg != null) {
                this.kgg.bm(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.biF > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.biF)));
        }
        this.mHandler.removeCallbacks(this.dYH);
        this.mHandler.postDelayed(this.dYH, 1000L);
    }
}
