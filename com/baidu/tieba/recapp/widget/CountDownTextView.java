package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    private Runnable gnd;
    private int mCounter;
    private Handler mHandler;
    private b ncr;
    private boolean ncs;

    /* loaded from: classes7.dex */
    public interface b {
        void cf(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.ncr = null;
        this.ncs = true;
        dFa();
    }

    private void dFa() {
        this.gnd = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.ncr = null;
        this.ncs = true;
        dFa();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.ncr = null;
        this.ncs = true;
        dFa();
    }

    public void update(int i) {
        this.mCounter = i;
    }

    public void startCountDown() {
        tj(1);
    }

    public void setTimeoutListener(b bVar) {
        this.ncr = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.ncs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> glV;

        private a(CountDownTextView countDownTextView) {
            this.glV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.glV.get();
            if (countDownTextView != null) {
                countDownTextView.tj(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(int i) {
        if (i > 0) {
            if (this.mCounter == 0) {
                if (this.ncr != null && this.ncs && getVisibility() == 0) {
                    this.ncr.cf(this);
                }
                setText(String.valueOf(this.mCounter));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.mCounter > 0) {
                setText(String.valueOf(this.mCounter));
            }
            this.mHandler.removeCallbacks(this.gnd);
            this.mHandler.postDelayed(this.gnd, 1000L);
            this.mCounter -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tj(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMU();
    }

    private void bMU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
