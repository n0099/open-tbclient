package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes26.dex */
public class CountDownTextView extends TextView {
    private int cPz;
    private Runnable gdP;
    private Handler mHandler;
    private b mPF;
    private boolean mPG;

    /* loaded from: classes26.dex */
    public interface b {
        void ca(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mPF = null;
        this.mPG = true;
        dGC();
    }

    private void dGC() {
        this.gdP = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mPF = null;
        this.mPG = true;
        dGC();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mPF = null;
        this.mPG = true;
        dGC();
    }

    public void update(int i) {
        this.cPz = i;
    }

    public void startCountDown() {
        uw(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mPF = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mPG = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> gdh;

        private a(CountDownTextView countDownTextView) {
            this.gdh = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gdh.get();
            if (countDownTextView != null) {
                countDownTextView.uw(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        if (i > 0) {
            if (this.cPz == 0) {
                if (this.mPF != null && this.mPG && getVisibility() == 0) {
                    this.mPF.ca(this);
                }
                setText(String.valueOf(this.cPz));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cPz > 0) {
                setText(String.valueOf(this.cPz));
            }
            this.mHandler.removeCallbacks(this.gdP);
            this.mHandler.postDelayed(this.gdP, 1000L);
            this.cPz -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uw(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bNE();
    }

    private void bNE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
