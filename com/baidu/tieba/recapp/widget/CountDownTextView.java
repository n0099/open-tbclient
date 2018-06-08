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
    private int boG;
    private Runnable boI;
    private b gqL;
    private boolean gqM;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void U(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gqL = null;
        this.gqM = true;
        bpp();
    }

    private void bpp() {
        this.boI = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gqL = null;
        this.gqM = true;
        bpp();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gqL = null;
        this.gqM = true;
        bpp();
    }

    public void update(int i) {
        this.boG = i;
    }

    public void startCountDown() {
        gy(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gqL = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gqM = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bof;

        private a(CountDownTextView countDownTextView) {
            this.bof = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bof.get();
            if (countDownTextView != null) {
                countDownTextView.gy(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(int i) {
        if (i > 0) {
            if (this.boG == 0) {
                if (this.gqL != null && this.gqM && getVisibility() == 0) {
                    this.gqL.U(this);
                }
                setText(String.valueOf(this.boG));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.boG > 0) {
                setText(String.valueOf(this.boG));
            }
            this.mHandler.removeCallbacks(this.boI);
            this.mHandler.postDelayed(this.boI, 1000L);
            this.boG -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gy(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RC();
    }

    private void RC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
