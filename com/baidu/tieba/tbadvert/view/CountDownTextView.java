package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private int bFG;
    private final Runnable bFI;
    private b htG;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> bFf;

        private a(CountDownTextView countDownTextView) {
            this.bFf = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bFf.get();
            if (countDownTextView != null) {
                countDownTextView.hO(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bFG = 0;
        this.mText = "";
        this.htG = null;
        this.mHandler = new Handler();
        this.bFI = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.htG = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hO(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XI();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            hO(0);
        } else {
            XI();
        }
    }

    public void O(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bFG = i;
        }
    }

    private void XI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        this.bFG -= i;
        if (this.bFG == 0) {
            if (this.htG != null) {
                this.htG.ak(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bFG > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bFG)));
        }
        this.mHandler.removeCallbacks(this.bFI);
        this.mHandler.postDelayed(this.bFI, 1000L);
    }
}
