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
    private int aql;
    private Runnable cQO;
    private b ioi;
    private boolean ioj;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bh(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.ioi = null;
        this.ioj = true;
        bXR();
    }

    private void bXR() {
        this.cQO = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.ioi = null;
        this.ioj = true;
        bXR();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.ioi = null;
        this.ioj = true;
        bXR();
    }

    public void update(int i) {
        this.aql = i;
    }

    public void startCountDown() {
        lD(1);
    }

    public void setTimeoutListener(b bVar) {
        this.ioi = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.ioj = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> cQl;

        private a(CountDownTextView countDownTextView) {
            this.cQl = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cQl.get();
            if (countDownTextView != null) {
                countDownTextView.lD(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lD(int i) {
        if (i > 0) {
            if (this.aql == 0) {
                if (this.ioi != null && this.ioj && getVisibility() == 0) {
                    this.ioi.bh(this);
                }
                setText(String.valueOf(this.aql));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aql > 0) {
                setText(String.valueOf(this.aql));
            }
            this.mHandler.removeCallbacks(this.cQO);
            this.mHandler.postDelayed(this.cQO, 1000L);
            this.aql -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lD(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axE();
    }

    private void axE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
