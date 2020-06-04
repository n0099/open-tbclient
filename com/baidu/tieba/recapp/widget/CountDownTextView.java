package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bVn;
    private Runnable eSe;
    private b kSg;
    private boolean kSh;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bs(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.kSg = null;
        this.kSh = true;
        cVV();
    }

    private void cVV() {
        this.eSe = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.kSg = null;
        this.kSh = true;
        cVV();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.kSg = null;
        this.kSh = true;
        cVV();
    }

    public void update(int i) {
        this.bVn = i;
    }

    public void startCountDown() {
        pl(1);
    }

    public void setTimeoutListener(b bVar) {
        this.kSg = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.kSh = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> eRw;

        private a(CountDownTextView countDownTextView) {
            this.eRw = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eRw.get();
            if (countDownTextView != null) {
                countDownTextView.pl(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(int i) {
        if (i > 0) {
            if (this.bVn == 0) {
                if (this.kSg != null && this.kSh && getVisibility() == 0) {
                    this.kSg.bs(this);
                }
                setText(String.valueOf(this.bVn));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bVn > 0) {
                setText(String.valueOf(this.bVn));
            }
            this.mHandler.removeCallbacks(this.eSe);
            this.mHandler.postDelayed(this.eSe, 1000L);
            this.bVn -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pl(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bnN();
    }

    private void bnN() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
