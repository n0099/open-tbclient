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
    private int chD;
    private Runnable fsm;
    private b lJR;
    private boolean lJS;
    private Handler mHandler;

    /* loaded from: classes20.dex */
    public interface b {
        void bD(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.lJR = null;
        this.lJS = true;
        doE();
    }

    private void doE() {
        this.fsm = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.lJR = null;
        this.lJS = true;
        doE();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.lJR = null;
        this.lJS = true;
        doE();
    }

    public void update(int i) {
        this.chD = i;
    }

    public void startCountDown() {
        sj(1);
    }

    public void setTimeoutListener(b bVar) {
        this.lJR = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.lJS = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class a implements Runnable {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sj(int i) {
        if (i > 0) {
            if (this.chD == 0) {
                if (this.lJR != null && this.lJS && getVisibility() == 0) {
                    this.lJR.bD(this);
                }
                setText(String.valueOf(this.chD));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.chD > 0) {
                setText(String.valueOf(this.chD));
            }
            this.mHandler.removeCallbacks(this.fsm);
            this.mHandler.postDelayed(this.fsm, 1000L);
            this.chD -= i;
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
        bCl();
    }

    private void bCl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
