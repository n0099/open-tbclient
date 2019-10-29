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
    private int aKK;
    private Runnable dlT;
    private b iPS;
    private boolean iPT;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.iPS = null;
        this.iPT = true;
        chc();
    }

    private void chc() {
        this.dlT = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.iPS = null;
        this.iPT = true;
        chc();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.iPS = null;
        this.iPT = true;
        chc();
    }

    public void yF(int i) {
        this.aKK = i;
    }

    public void startCountDown() {
        lJ(1);
    }

    public void setTimeoutListener(b bVar) {
        this.iPS = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.iPT = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> dll;

        private a(CountDownTextView countDownTextView) {
            this.dll = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dll.get();
            if (countDownTextView != null) {
                countDownTextView.lJ(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(int i) {
        if (i > 0) {
            if (this.aKK == 0) {
                if (this.iPS != null && this.iPT && getVisibility() == 0) {
                    this.iPS.bp(this);
                }
                setText(String.valueOf(this.aKK));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aKK > 0) {
                setText(String.valueOf(this.aKK));
            }
            this.mHandler.removeCallbacks(this.dlT);
            this.mHandler.postDelayed(this.dlT, 1000L);
            this.aKK -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lJ(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEU();
    }

    private void aEU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
