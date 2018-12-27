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
    private int bES;
    private Runnable bEU;
    private b gVT;
    private boolean gVU;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gVT = null;
        this.gVU = true;
        bwv();
    }

    private void bwv() {
        this.bEU = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gVT = null;
        this.gVU = true;
        bwv();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gVT = null;
        this.gVU = true;
        bwv();
    }

    public void update(int i) {
        this.bES = i;
    }

    public void startCountDown() {
        hO(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gVT = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gVU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bEr;

        private a(CountDownTextView countDownTextView) {
            this.bEr = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bEr.get();
            if (countDownTextView != null) {
                countDownTextView.hO(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (i > 0) {
            if (this.bES == 0) {
                if (this.gVT != null && this.gVU && getVisibility() == 0) {
                    this.gVT.ak(this);
                }
                setText(String.valueOf(this.bES));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bES > 0) {
                setText(String.valueOf(this.bES));
            }
            this.mHandler.removeCallbacks(this.bEU);
            this.mHandler.postDelayed(this.bEU, 1000L);
            this.bES -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hO(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Xl();
    }

    private void Xl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
