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
    private int bqg;
    private Runnable bqi;
    private b guD;
    private boolean guE;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void V(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.guD = null;
        this.guE = true;
        bpQ();
    }

    private void bpQ() {
        this.bqi = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.guD = null;
        this.guE = true;
        bpQ();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.guD = null;
        this.guE = true;
        bpQ();
    }

    public void update(int i) {
        this.bqg = i;
    }

    public void startCountDown() {
        gz(1);
    }

    public void setTimeoutListener(b bVar) {
        this.guD = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.guE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bpF;

        private a(CountDownTextView countDownTextView) {
            this.bpF = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bpF.get();
            if (countDownTextView != null) {
                countDownTextView.gz(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(int i) {
        if (i > 0) {
            if (this.bqg == 0) {
                if (this.guD != null && this.guE && getVisibility() == 0) {
                    this.guD.V(this);
                }
                setText(String.valueOf(this.bqg));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bqg > 0) {
                setText(String.valueOf(this.bqg));
            }
            this.mHandler.removeCallbacks(this.bqi);
            this.mHandler.postDelayed(this.bqi, 1000L);
            this.bqg -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gz(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RZ();
    }

    private void RZ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
