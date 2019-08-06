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
    private int aqW;
    private Runnable daL;
    private b iOy;
    private boolean iOz;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.iOy = null;
        this.iOz = true;
        cji();
    }

    private void cji() {
        this.daL = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.iOy = null;
        this.iOz = true;
        cji();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.iOy = null;
        this.iOz = true;
        cji();
    }

    public void zW(int i) {
        this.aqW = i;
    }

    public void startCountDown() {
        mA(1);
    }

    public void setTimeoutListener(b bVar) {
        this.iOy = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.iOz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> dac;

        private a(CountDownTextView countDownTextView) {
            this.dac = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dac.get();
            if (countDownTextView != null) {
                countDownTextView.mA(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(int i) {
        if (i > 0) {
            if (this.aqW == 0) {
                if (this.iOy != null && this.iOz && getVisibility() == 0) {
                    this.iOy.bp(this);
                }
                setText(String.valueOf(this.aqW));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aqW > 0) {
                setText(String.valueOf(this.aqW));
            }
            this.mHandler.removeCallbacks(this.daL);
            this.mHandler.postDelayed(this.daL, 1000L);
            this.aqW -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mA(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEf();
    }

    private void aEf() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
