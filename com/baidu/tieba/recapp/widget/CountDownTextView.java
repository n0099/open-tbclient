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
    private int aKs;
    private Runnable dlc;
    private b iPb;
    private boolean iPc;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bp(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.iPb = null;
        this.iPc = true;
        cha();
    }

    private void cha() {
        this.dlc = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.iPb = null;
        this.iPc = true;
        cha();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.iPb = null;
        this.iPc = true;
        cha();
    }

    public void yE(int i) {
        this.aKs = i;
    }

    public void startCountDown() {
        lI(1);
    }

    public void setTimeoutListener(b bVar) {
        this.iPb = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.iPc = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> dku;

        private a(CountDownTextView countDownTextView) {
            this.dku = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.dku.get();
            if (countDownTextView != null) {
                countDownTextView.lI(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(int i) {
        if (i > 0) {
            if (this.aKs == 0) {
                if (this.iPb != null && this.iPc && getVisibility() == 0) {
                    this.iPb.bp(this);
                }
                setText(String.valueOf(this.aKs));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aKs > 0) {
                setText(String.valueOf(this.aKs));
            }
            this.mHandler.removeCallbacks(this.dlc);
            this.mHandler.postDelayed(this.dlc, 1000L);
            this.aKs -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        lI(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aES();
    }

    private void aES() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
