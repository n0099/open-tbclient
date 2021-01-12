package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CountDownTextView extends TextView {
    private int cPK;
    private Runnable giz;
    private Handler mHandler;
    private b mQh;
    private boolean mQi;

    /* loaded from: classes7.dex */
    public interface b {
        void cj(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.mQh = null;
        this.mQi = true;
        dCA();
    }

    private void dCA() {
        this.giz = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.mQh = null;
        this.mQi = true;
        dCA();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.mQh = null;
        this.mQi = true;
        dCA();
    }

    public void update(int i) {
        this.cPK = i;
    }

    public void startCountDown() {
        tb(1);
    }

    public void setTimeoutListener(b bVar) {
        this.mQh = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.mQi = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> ghQ;

        private a(CountDownTextView countDownTextView) {
            this.ghQ = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ghQ.get();
            if (countDownTextView != null) {
                countDownTextView.tb(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(int i) {
        if (i > 0) {
            if (this.cPK == 0) {
                if (this.mQh != null && this.mQi && getVisibility() == 0) {
                    this.mQh.cj(this);
                }
                setText(String.valueOf(this.cPK));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cPK > 0) {
                setText(String.valueOf(this.cPK));
            }
            this.mHandler.removeCallbacks(this.giz);
            this.mHandler.postDelayed(this.giz, 1000L);
            this.cPK -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tb(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMg();
    }

    private void bMg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
