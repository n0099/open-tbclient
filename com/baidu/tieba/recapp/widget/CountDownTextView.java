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
    private int cEx;
    private Runnable fQg;
    private Handler mHandler;
    private b muQ;
    private boolean muR;

    /* loaded from: classes26.dex */
    public interface b {
        void bM(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.muQ = null;
        this.muR = true;
        dzj();
    }

    private void dzj() {
        this.fQg = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.muQ = null;
        this.muR = true;
        dzj();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.muQ = null;
        this.muR = true;
        dzj();
    }

    public void update(int i) {
        this.cEx = i;
    }

    public void startCountDown() {
        tk(1);
    }

    public void setTimeoutListener(b bVar) {
        this.muQ = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.muR = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> fPy;

        private a(CountDownTextView countDownTextView) {
            this.fPy = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.fPy.get();
            if (countDownTextView != null) {
                countDownTextView.tk(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tk(int i) {
        if (i > 0) {
            if (this.cEx == 0) {
                if (this.muQ != null && this.muR && getVisibility() == 0) {
                    this.muQ.bM(this);
                }
                setText(String.valueOf(this.cEx));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.cEx > 0) {
                setText(String.valueOf(this.cEx));
            }
            this.mHandler.removeCallbacks(this.fQg);
            this.mHandler.postDelayed(this.fQg, 1000L);
            this.cEx -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        tk(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bId();
    }

    private void bId() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
