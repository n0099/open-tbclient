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
    private int aqh;
    private Runnable cQM;
    private b ioy;
    private boolean ioz;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bh(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.ioy = null;
        this.ioz = true;
        bXV();
    }

    private void bXV() {
        this.cQM = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.ioy = null;
        this.ioz = true;
        bXV();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.ioy = null;
        this.ioz = true;
        bXV();
    }

    public void update(int i) {
        this.aqh = i;
    }

    public void startCountDown() {
        lE(1);
    }

    public void setTimeoutListener(b bVar) {
        this.ioy = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.ioz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> cQj;

        private a(CountDownTextView countDownTextView) {
            this.cQj = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cQj.get();
            if (countDownTextView != null) {
                countDownTextView.lE(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lE(int i) {
        if (i > 0) {
            if (this.aqh == 0) {
                if (this.ioy != null && this.ioz && getVisibility() == 0) {
                    this.ioy.bh(this);
                }
                setText(String.valueOf(this.aqh));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aqh > 0) {
                setText(String.valueOf(this.aqh));
            }
            this.mHandler.removeCallbacks(this.cQM);
            this.mHandler.postDelayed(this.cQM, 1000L);
            this.aqh -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lE(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        axH();
    }

    private void axH() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
