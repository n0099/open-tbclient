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
    private int cwb;
    private Runnable fHL;
    private Handler mHandler;
    private b mit;
    private boolean miu;

    /* loaded from: classes26.dex */
    public interface b {
        void bL(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mit = null;
        this.miu = true;
        dwc();
    }

    private void dwc() {
        this.fHL = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mit = null;
        this.miu = true;
        dwc();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mit = null;
        this.miu = true;
        dwc();
    }

    public void update(int i) {
        this.cwb = i;
    }

    public void startCountDown() {
        sZ(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mit = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.miu = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fHd;

        private a(CountDownTextView countDownTextView) {
            this.fHd = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fHd.get();
            if (countDownTextView != null) {
                countDownTextView.sZ(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sZ(int i) {
        if (i > 0) {
            if (this.cwb == 0) {
                if (this.mit != null && this.miu && getVisibility() == 0) {
                    this.mit.bL(this);
                }
                setText(String.valueOf(this.cwb));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cwb > 0) {
                setText(String.valueOf(this.cwb));
            }
            this.mHandler.removeCallbacks(this.fHL);
            this.mHandler.postDelayed(this.fHL, 1000L);
            this.cwb -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sZ(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bGk();
    }

    private void bGk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
