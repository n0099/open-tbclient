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
    private int aru;
    private Runnable dcy;
    private b iQU;
    private boolean iQV;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.iQU = null;
        this.iQV = true;
        cjU();
    }

    private void cjU() {
        this.dcy = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.iQU = null;
        this.iQV = true;
        cjU();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.iQU = null;
        this.iQV = true;
        cjU();
    }

    public void zZ(int i) {
        this.aru = i;
    }

    public void startCountDown() {
        mE(1);
    }

    public void setTimeoutListener(b bVar) {
        this.iQU = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.iQV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> dbO;

        private a(CountDownTextView countDownTextView) {
            this.dbO = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dbO.get();
            if (countDownTextView != null) {
                countDownTextView.mE(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mE(int i) {
        if (i > 0) {
            if (this.aru == 0) {
                if (this.iQU != null && this.iQV && getVisibility() == 0) {
                    this.iQU.bp(this);
                }
                setText(String.valueOf(this.aru));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aru > 0) {
                setText(String.valueOf(this.aru));
            }
            this.mHandler.removeCallbacks(this.dcy);
            this.mHandler.postDelayed(this.dcy, 1000L);
            this.aru -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mE(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aEJ();
    }

    private void aEJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
