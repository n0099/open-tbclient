package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private int bES;
    private final Runnable bEU;
    private b hsx;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> bEr;

        private a(CountDownTextView countDownTextView) {
            this.bEr = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bEr.get();
            if (countDownTextView != null) {
                countDownTextView.hO(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bES = 0;
        this.mText = "";
        this.hsx = null;
        this.mHandler = new Handler();
        this.bEU = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.hsx = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hO(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Xl();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            hO(0);
        } else {
            Xl();
        }
    }

    public void O(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bES = i;
        }
    }

    private void Xl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        this.bES -= i;
        if (this.bES == 0) {
            if (this.hsx != null) {
                this.hsx.ak(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bES > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bES)));
        }
        this.mHandler.removeCallbacks(this.bEU);
        this.mHandler.postDelayed(this.bEU, 1000L);
    }
}
