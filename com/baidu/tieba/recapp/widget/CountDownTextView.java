package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class CountDownTextView extends TextView {
    private int aKb;
    private Runnable bgA;
    private b gen;
    private boolean gep;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void U(View view2);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gen = null;
        this.gep = true;
        bks();
    }

    private void bks() {
        this.bgA = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gen = null;
        this.gep = true;
        bks();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gen = null;
        this.gep = true;
        bks();
    }

    public void update(int i) {
        this.aKb = i;
    }

    public void startCountDown() {
        gw(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gen = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gep = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bfX;

        private a(CountDownTextView countDownTextView) {
            this.bfX = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bfX.get();
            if (countDownTextView != null) {
                countDownTextView.gw(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(int i) {
        if (i > 0) {
            if (this.aKb == 0) {
                if (this.gen != null && this.gep && getVisibility() == 0) {
                    this.gen.U(this);
                }
                setText(String.valueOf(this.aKb));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aKb > 0) {
                setText(String.valueOf(this.aKb));
            }
            this.mHandler.removeCallbacks(this.bgA);
            this.mHandler.postDelayed(this.bgA, 1000L);
            this.aKb -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gw(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Of();
    }

    private void Of() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
