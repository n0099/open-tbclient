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
    private Runnable eRT;
    private b kQX;
    private boolean kQY;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void bs(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.kQX = null;
        this.kQY = true;
        cVF();
    }

    private void cVF() {
        this.eRT = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.kQX = null;
        this.kQY = true;
        cVF();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.kQX = null;
        this.kQY = true;
        cVF();
    }

    public void update(int i) {
        this.bVn = i;
    }

    public void startCountDown() {
        pj(1);
    }

    public void setTimeoutListener(b bVar) {
        this.kQX = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.kQY = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> eRl;

        private a(CountDownTextView countDownTextView) {
            this.eRl = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eRl.get();
            if (countDownTextView != null) {
                countDownTextView.pj(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pj(int i) {
        if (i > 0) {
            if (this.bVn == 0) {
                if (this.kQX != null && this.kQY && getVisibility() == 0) {
                    this.kQX.bs(this);
                }
                setText(String.valueOf(this.bVn));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bVn > 0) {
                setText(String.valueOf(this.bVn));
            }
            this.mHandler.removeCallbacks(this.eRT);
            this.mHandler.postDelayed(this.eRT, 1000L);
            this.bVn -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        pj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bnL();
    }

    private void bnL() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
