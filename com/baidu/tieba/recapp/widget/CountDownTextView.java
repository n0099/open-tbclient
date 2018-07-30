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
    private int bqN;
    private Runnable bqP;
    private b gvQ;
    private boolean gvR;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void X(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gvQ = null;
        this.gvR = true;
        bow();
    }

    private void bow() {
        this.bqP = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gvQ = null;
        this.gvR = true;
        bow();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gvQ = null;
        this.gvR = true;
        bow();
    }

    public void update(int i) {
        this.bqN = i;
    }

    public void startCountDown() {
        gF(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gvQ = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gvR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bqm;

        private a(CountDownTextView countDownTextView) {
            this.bqm = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bqm.get();
            if (countDownTextView != null) {
                countDownTextView.gF(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gF(int i) {
        if (i > 0) {
            if (this.bqN == 0) {
                if (this.gvQ != null && this.gvR && getVisibility() == 0) {
                    this.gvQ.X(this);
                }
                setText(String.valueOf(this.bqN));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bqN > 0) {
                setText(String.valueOf(this.bqN));
            }
            this.mHandler.removeCallbacks(this.bqP);
            this.mHandler.postDelayed(this.bqP, 1000L);
            this.bqN -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gF(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Sh();
    }

    private void Sh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
