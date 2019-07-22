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
    private Runnable daE;
    private b iNu;
    private boolean iNv;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.iNu = null;
        this.iNv = true;
        ciQ();
    }

    private void ciQ() {
        this.daE = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.iNu = null;
        this.iNv = true;
        ciQ();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.iNu = null;
        this.iNv = true;
        ciQ();
    }

    public void zU(int i) {
        this.aqW = i;
    }

    public void startCountDown() {
        mz(1);
    }

    public void setTimeoutListener(b bVar) {
        this.iNu = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.iNv = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> cZV;

        private a(CountDownTextView countDownTextView) {
            this.cZV = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cZV.get();
            if (countDownTextView != null) {
                countDownTextView.mz(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(int i) {
        if (i > 0) {
            if (this.aqW == 0) {
                if (this.iNu != null && this.iNv && getVisibility() == 0) {
                    this.iNu.bp(this);
                }
                setText(String.valueOf(this.aqW));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aqW > 0) {
                setText(String.valueOf(this.aqW));
            }
            this.mHandler.removeCallbacks(this.daE);
            this.mHandler.postDelayed(this.daE, 1000L);
            this.aqW -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mz(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEd();
    }

    private void aEd() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
