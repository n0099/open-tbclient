package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private int cUw;
    private Runnable gng;
    private Handler mHandler;
    private b mUT;
    private boolean mUU;

    /* loaded from: classes8.dex */
    public interface b {
        void cj(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mUT = null;
        this.mUU = true;
        dGr();
    }

    private void dGr() {
        this.gng = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mUT = null;
        this.mUU = true;
        dGr();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mUT = null;
        this.mUU = true;
        dGr();
    }

    public void update(int i) {
        this.cUw = i;
    }

    public void startCountDown() {
        uH(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mUT = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mUU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> gmy;

        private a(CountDownTextView countDownTextView) {
            this.gmy = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gmy.get();
            if (countDownTextView != null) {
                countDownTextView.uH(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(int i) {
        if (i > 0) {
            if (this.cUw == 0) {
                if (this.mUT != null && this.mUU && getVisibility() == 0) {
                    this.mUT.cj(this);
                }
                setText(String.valueOf(this.cUw));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cUw > 0) {
                setText(String.valueOf(this.cUw));
            }
            this.mHandler.removeCallbacks(this.gng);
            this.mHandler.postDelayed(this.gng, 1000L);
            this.cUw -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uH(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bPX();
    }

    private void bPX() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
