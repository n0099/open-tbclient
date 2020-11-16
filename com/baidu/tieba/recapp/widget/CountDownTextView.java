package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes25.dex */
public class CountDownTextView extends TextView {
    private int cIG;
    private Runnable fVD;
    private b mBt;
    private boolean mBu;
    private Handler mHandler;

    /* loaded from: classes25.dex */
    public interface b {
        void bT(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mBt = null;
        this.mBu = true;
        dBp();
    }

    private void dBp() {
        this.fVD = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mBt = null;
        this.mBu = true;
        dBp();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mBt = null;
        this.mBu = true;
        dBp();
    }

    public void update(int i) {
        this.cIG = i;
    }

    public void startCountDown() {
        tS(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mBt = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mBu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fUV;

        private a(CountDownTextView countDownTextView) {
            this.fUV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fUV.get();
            if (countDownTextView != null) {
                countDownTextView.tS(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tS(int i) {
        if (i > 0) {
            if (this.cIG == 0) {
                if (this.mBt != null && this.mBu && getVisibility() == 0) {
                    this.mBt.bT(this);
                }
                setText(String.valueOf(this.cIG));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cIG > 0) {
                setText(String.valueOf(this.cIG));
            }
            this.mHandler.removeCallbacks(this.fVD);
            this.mHandler.postDelayed(this.fVD, 1000L);
            this.cIG -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tS(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bJV();
    }

    private void bJV() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
