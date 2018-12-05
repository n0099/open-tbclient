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
    private int bEP;
    private Runnable bER;
    private b gSY;
    private boolean gSZ;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gSY = null;
        this.gSZ = true;
        bvI();
    }

    private void bvI() {
        this.bER = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gSY = null;
        this.gSZ = true;
        bvI();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gSY = null;
        this.gSZ = true;
        bvI();
    }

    public void update(int i) {
        this.bEP = i;
    }

    public void startCountDown() {
        hN(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gSY = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gSZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bEo;

        private a(CountDownTextView countDownTextView) {
            this.bEo = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bEo.get();
            if (countDownTextView != null) {
                countDownTextView.hN(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hN(int i) {
        if (i > 0) {
            if (this.bEP == 0) {
                if (this.gSY != null && this.gSZ && getVisibility() == 0) {
                    this.gSY.ak(this);
                }
                setText(String.valueOf(this.bEP));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bEP > 0) {
                setText(String.valueOf(this.bEP));
            }
            this.mHandler.removeCallbacks(this.bER);
            this.mHandler.postDelayed(this.bER, 1000L);
            this.bEP -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hN(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Xj();
    }

    private void Xj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
