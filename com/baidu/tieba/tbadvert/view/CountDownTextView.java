package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String anb;
    private int aru;
    private final Runnable dcy;
    private b jmP;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> dbO;

        private a(CountDownTextView countDownTextView) {
            this.dbO = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dbO.get();
            if (countDownTextView != null) {
                countDownTextView.mE(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aru = 0;
        this.anb = "";
        this.jmP = null;
        this.mHandler = new Handler();
        this.dcy = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.jmP = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mE(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEJ();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            mE(0);
        } else {
            aEJ();
        }
    }

    public void aj(String str, int i) {
        this.anb = str;
        if (i > 0) {
            this.aru = i;
        }
    }

    private void aEJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(int i) {
        this.aru -= i;
        if (this.aru == 0) {
            if (this.jmP != null) {
                this.jmP.bp(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aru > 0) {
            setText(String.format("%s %s", this.anb, Integer.valueOf(this.aru)));
        }
        this.mHandler.removeCallbacks(this.dcy);
        this.mHandler.postDelayed(this.dcy, 1000L);
    }
}
