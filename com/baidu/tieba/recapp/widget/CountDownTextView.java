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
    private int bqP;
    private Runnable bqR;
    private b gvT;
    private boolean gvU;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void X(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gvT = null;
        this.gvU = true;
        box();
    }

    private void box() {
        this.bqR = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gvT = null;
        this.gvU = true;
        box();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gvT = null;
        this.gvU = true;
        box();
    }

    public void update(int i) {
        this.bqP = i;
    }

    public void startCountDown() {
        gE(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gvT = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gvU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bqo;

        private a(CountDownTextView countDownTextView) {
            this.bqo = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bqo.get();
            if (countDownTextView != null) {
                countDownTextView.gE(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(int i) {
        if (i > 0) {
            if (this.bqP == 0) {
                if (this.gvT != null && this.gvU && getVisibility() == 0) {
                    this.gvT.X(this);
                }
                setText(String.valueOf(this.bqP));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bqP > 0) {
                setText(String.valueOf(this.bqP));
            }
            this.mHandler.removeCallbacks(this.bqR);
            this.mHandler.postDelayed(this.bqR, 1000L);
            this.bqP -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gE(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Sl();
    }

    private void Sl() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
