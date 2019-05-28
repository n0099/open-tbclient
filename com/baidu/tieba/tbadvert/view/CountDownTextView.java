package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private String ama;
    private int aqt;
    private final Runnable cZe;
    private b jcP;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bn(View view);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> cYy;

        private a(CountDownTextView countDownTextView) {
            this.cYy = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cYy.get();
            if (countDownTextView != null) {
                countDownTextView.ms(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.aqt = 0;
        this.ama = "";
        this.jcP = null;
        this.mHandler = new Handler();
        this.cZe = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.jcP = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ms(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aCN();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            ms(0);
        } else {
            aCN();
        }
    }

    public void ah(String str, int i) {
        this.ama = str;
        if (i > 0) {
            this.aqt = i;
        }
    }

    private void aCN() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        this.aqt -= i;
        if (this.aqt == 0) {
            if (this.jcP != null) {
                this.jcP.bn(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.aqt > 0) {
            setText(String.format("%s %s", this.ama, Integer.valueOf(this.aqt)));
        }
        this.mHandler.removeCallbacks(this.cZe);
        this.mHandler.postDelayed(this.cZe, 1000L);
    }
}
