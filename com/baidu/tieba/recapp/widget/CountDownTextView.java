package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes26.dex */
public class CountDownTextView extends TextView {
    private int cKq;
    private Runnable fVW;
    private b mAM;
    private boolean mAN;
    private Handler mHandler;

    /* loaded from: classes26.dex */
    public interface b {
        void bQ(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mAM = null;
        this.mAN = true;
        dBL();
    }

    private void dBL() {
        this.fVW = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mAM = null;
        this.mAN = true;
        dBL();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mAM = null;
        this.mAN = true;
        dBL();
    }

    public void update(int i) {
        this.cKq = i;
    }

    public void startCountDown() {
        tu(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mAM = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mAN = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fVo;

        private a(CountDownTextView countDownTextView) {
            this.fVo = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fVo.get();
            if (countDownTextView != null) {
                countDownTextView.tu(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
        if (i > 0) {
            if (this.cKq == 0) {
                if (this.mAM != null && this.mAN && getVisibility() == 0) {
                    this.mAM.bQ(this);
                }
                setText(String.valueOf(this.cKq));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cKq > 0) {
                setText(String.valueOf(this.cKq));
            }
            this.mHandler.removeCallbacks(this.fVW);
            this.mHandler.postDelayed(this.fVW, 1000L);
            this.cKq -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tu(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bKC();
    }

    private void bKC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
