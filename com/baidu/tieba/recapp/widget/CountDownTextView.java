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
    private int bAH;
    private Runnable bAJ;
    private b gKJ;
    private boolean gKK;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void al(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gKJ = null;
        this.gKK = true;
        but();
    }

    private void but() {
        this.bAJ = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gKJ = null;
        this.gKK = true;
        but();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gKJ = null;
        this.gKK = true;
        but();
    }

    public void update(int i) {
        this.bAH = i;
    }

    public void startCountDown() {
        hm(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gKJ = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gKK = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bAg;

        private a(CountDownTextView countDownTextView) {
            this.bAg = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bAg.get();
            if (countDownTextView != null) {
                countDownTextView.hm(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hm(int i) {
        if (i > 0) {
            if (this.bAH == 0) {
                if (this.gKJ != null && this.gKK && getVisibility() == 0) {
                    this.gKJ.al(this);
                }
                setText(String.valueOf(this.bAH));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bAH > 0) {
                setText(String.valueOf(this.bAH));
            }
            this.mHandler.removeCallbacks(this.bAJ);
            this.mHandler.postDelayed(this.bAJ, 1000L);
            this.bAH -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hm(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VU();
    }

    private void VU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
