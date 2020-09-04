package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes20.dex */
public class CountDownTextView extends TextView {
    private int chH;
    private Runnable fsq;
    private b lKe;
    private boolean lKf;
    private Handler mHandler;

    /* loaded from: classes20.dex */
    public interface b {
        void bD(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.lKe = null;
        this.lKf = true;
        doH();
    }

    private void doH() {
        this.fsq = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.lKe = null;
        this.lKf = true;
        doH();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.lKe = null;
        this.lKf = true;
        doH();
    }

    public void update(int i) {
        this.chH = i;
    }

    public void startCountDown() {
        sj(1);
    }

    public void setTimeoutListener(b bVar) {
        this.lKe = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.lKf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> frI;

        private a(CountDownTextView countDownTextView) {
            this.frI = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.frI.get();
            if (countDownTextView != null) {
                countDownTextView.sj(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        if (i > 0) {
            if (this.chH == 0) {
                if (this.lKe != null && this.lKf && getVisibility() == 0) {
                    this.lKe.bD(this);
                }
                setText(String.valueOf(this.chH));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.chH > 0) {
                setText(String.valueOf(this.chH));
            }
            this.mHandler.removeCallbacks(this.fsq);
            this.mHandler.postDelayed(this.fsq, 1000L);
            this.chH -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bCm();
    }

    private void bCm() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
