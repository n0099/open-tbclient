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
    private Runnable glg;
    private int mCounter;
    private Handler mHandler;
    private b mZE;
    private boolean mZF;

    /* loaded from: classes8.dex */
    public interface b {
        void cf(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mZE = null;
        this.mZF = true;
        dEK();
    }

    private void dEK() {
        this.glg = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mZE = null;
        this.mZF = true;
        dEK();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mZE = null;
        this.mZF = true;
        dEK();
    }

    public void update(int i) {
        this.mCounter = i;
    }

    public void startCountDown() {
        th(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mZE = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mZF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> gke;

        private a(CountDownTextView countDownTextView) {
            this.gke = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gke.get();
            if (countDownTextView != null) {
                countDownTextView.th(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        if (i > 0) {
            if (this.mCounter == 0) {
                if (this.mZE != null && this.mZF && getVisibility() == 0) {
                    this.mZE.cf(this);
                }
                setText(String.valueOf(this.mCounter));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.mCounter > 0) {
                setText(String.valueOf(this.mCounter));
            }
            this.mHandler.removeCallbacks(this.glg);
            this.mHandler.postDelayed(this.glg, 1000L);
            this.mCounter -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        th(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMH();
    }

    private void bMH() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
