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
    private int bBs;
    private Runnable bBu;
    private b gMi;
    private boolean gMj;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gMi = null;
        this.gMj = true;
        btP();
    }

    private void btP() {
        this.bBu = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gMi = null;
        this.gMj = true;
        btP();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gMi = null;
        this.gMj = true;
        btP();
    }

    public void update(int i) {
        this.bBs = i;
    }

    public void startCountDown() {
        hz(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gMi = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gMj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bAR;

        private a(CountDownTextView countDownTextView) {
            this.bAR = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bAR.get();
            if (countDownTextView != null) {
                countDownTextView.hz(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hz(int i) {
        if (i > 0) {
            if (this.bBs == 0) {
                if (this.gMi != null && this.gMj && getVisibility() == 0) {
                    this.gMi.ak(this);
                }
                setText(String.valueOf(this.bBs));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bBs > 0) {
                setText(String.valueOf(this.bBs));
            }
            this.mHandler.removeCallbacks(this.bBu);
            this.mHandler.postDelayed(this.bBu, 1000L);
            this.bBs -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hz(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Wd();
    }

    private void Wd() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
