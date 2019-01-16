package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private int bFF;
    private final Runnable bFH;
    private b htF;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> bFe;

        private a(CountDownTextView countDownTextView) {
            this.bFe = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bFe.get();
            if (countDownTextView != null) {
                countDownTextView.hO(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bFF = 0;
        this.mText = "";
        this.htF = null;
        this.mHandler = new Handler();
        this.bFH = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.htF = bVar;
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
            this.bFF = i;
        }
    }

    private void XI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        this.bFF -= i;
        if (this.bFF == 0) {
            if (this.htF != null) {
                this.htF.ak(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bFF > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bFF)));
        }
        this.mHandler.removeCallbacks(this.bFH);
        this.mHandler.postDelayed(this.bFH, 1000L);
    }
}
