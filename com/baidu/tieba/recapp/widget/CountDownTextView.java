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
    private int cPz;
    private Runnable gdN;
    private Handler mHandler;
    private b mPD;
    private boolean mPE;

    /* loaded from: classes26.dex */
    public interface b {
        void ca(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mPD = null;
        this.mPE = true;
        dGB();
    }

    private void dGB() {
        this.gdN = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mPD = null;
        this.mPE = true;
        dGB();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mPD = null;
        this.mPE = true;
        dGB();
    }

    public void update(int i) {
        this.cPz = i;
    }

    public void startCountDown() {
        uw(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mPD = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mPE = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> gdf;

        private a(CountDownTextView countDownTextView) {
            this.gdf = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gdf.get();
            if (countDownTextView != null) {
                countDownTextView.uw(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        if (i > 0) {
            if (this.cPz == 0) {
                if (this.mPD != null && this.mPE && getVisibility() == 0) {
                    this.mPD.ca(this);
                }
                setText(String.valueOf(this.cPz));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cPz > 0) {
                setText(String.valueOf(this.cPz));
            }
            this.mHandler.removeCallbacks(this.gdN);
            this.mHandler.postDelayed(this.gdN, 1000L);
            this.cPz -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        uw(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bND();
    }

    private void bND() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
