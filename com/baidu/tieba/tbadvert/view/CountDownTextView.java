package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes26.dex */
public class CountDownTextView extends TextView {
    private int cEx;
    private final Runnable fQg;
    private Handler mHandler;
    private String mText;
    private b mVt;

    /* loaded from: classes26.dex */
    public interface b {
        void bM(View view);
    }

    /* loaded from: classes26.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> fPy;

        private a(CountDownTextView countDownTextView) {
            this.fPy = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fPy.get();
            if (countDownTextView != null) {
                countDownTextView.tk(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cEx = 0;
        this.mText = "";
        this.mVt = null;
        this.mHandler = new Handler();
        this.fQg = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.mVt = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tk(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bId();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            tk(0);
        } else {
            bId();
        }
    }

    public void ay(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cEx = i;
        }
    }

    private void bId() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk(int i) {
        this.cEx -= i;
        if (this.cEx == 0) {
            if (this.mVt != null) {
                this.mVt.bM(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cEx > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cEx)));
        }
        this.mHandler.removeCallbacks(this.fQg);
        this.mHandler.postDelayed(this.fQg, 1000L);
    }
}
