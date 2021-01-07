package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private int cUw;
    private final Runnable gng;
    private Handler mHandler;
    private String mText;
    private b nws;

    /* loaded from: classes8.dex */
    public interface b {
        void cj(View view);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> gmy;

        private a(CountDownTextView countDownTextView) {
            this.gmy = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gmy.get();
            if (countDownTextView != null) {
                countDownTextView.uH(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.cUw = 0;
        this.mText = "";
        this.nws = null;
        this.mHandler = new Handler();
        this.gng = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.nws = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uH(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bPY();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            uH(0);
        } else {
            bPY();
        }
    }

    public void aC(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.cUw = i;
        }
    }

    private void bPY() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        this.cUw -= i;
        if (this.cUw == 0) {
            if (this.nws != null) {
                this.nws.cj(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.cUw > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.cUw)));
        }
        this.mHandler.removeCallbacks(this.gng);
        this.mHandler.postDelayed(this.gng, 1000L);
    }
}
