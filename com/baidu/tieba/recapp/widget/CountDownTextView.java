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
    private int cjJ;
    private Runnable fvC;
    private b lSY;
    private boolean lSZ;
    private Handler mHandler;

    /* loaded from: classes25.dex */
    public interface b {
        void bH(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.lSY = null;
        this.lSZ = true;
        dsr();
    }

    private void dsr() {
        this.fvC = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.lSY = null;
        this.lSZ = true;
        dsr();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.lSY = null;
        this.lSZ = true;
        dsr();
    }

    public void update(int i) {
        this.cjJ = i;
    }

    public void startCountDown() {
        sB(1);
    }

    public void setTimeoutListener(b bVar) {
        this.lSY = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.lSZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fuU;

        private a(CountDownTextView countDownTextView) {
            this.fuU = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fuU.get();
            if (countDownTextView != null) {
                countDownTextView.sB(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sB(int i) {
        if (i > 0) {
            if (this.cjJ == 0) {
                if (this.lSY != null && this.lSZ && getVisibility() == 0) {
                    this.lSY.bH(this);
                }
                setText(String.valueOf(this.cjJ));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cjJ > 0) {
                setText(String.valueOf(this.cjJ));
            }
            this.mHandler.removeCallbacks(this.fvC);
            this.mHandler.postDelayed(this.fvC, 1000L);
            this.cjJ -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sB(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bDy();
    }

    private void bDy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
