package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes20.dex */
public class CountDownTextView extends TextView {
    private int chD;
    private final Runnable fsm;
    private Handler mHandler;
    private String mText;
    private b mjn;

    /* loaded from: classes20.dex */
    public interface b {
        void bD(View view);
    }

    /* loaded from: classes20.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> frE;

        private a(CountDownTextView countDownTextView) {
            this.frE = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.frE.get();
            if (countDownTextView != null) {
                countDownTextView.sj(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.chD = 0;
        this.mText = "";
        this.mjn = null;
        this.mHandler = new Handler();
        this.fsm = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.mjn = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCl();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            sj(0);
        } else {
            bCl();
        }
    }

    public void ax(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.chD = i;
        }
    }

    private void bCl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        this.chD -= i;
        if (this.chD == 0) {
            if (this.mjn != null) {
                this.mjn.bD(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.chD > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.chD)));
        }
        this.mHandler.removeCallbacks(this.fsm);
        this.mHandler.postDelayed(this.fsm, 1000L);
    }
}
