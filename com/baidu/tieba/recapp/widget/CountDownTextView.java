package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bMe;
    private Runnable eDu;
    private b kze;
    private boolean kzf;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void br(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.kze = null;
        this.kzf = true;
        cOD();
    }

    private void cOD() {
        this.eDu = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.kze = null;
        this.kzf = true;
        cOD();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.kze = null;
        this.kzf = true;
        cOD();
    }

    public void update(int i) {
        this.bMe = i;
    }

    public void startCountDown() {
        oC(1);
    }

    public void setTimeoutListener(b bVar) {
        this.kze = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.kzf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> eCM;

        private a(CountDownTextView countDownTextView) {
            this.eCM = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eCM.get();
            if (countDownTextView != null) {
                countDownTextView.oC(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(int i) {
        if (i > 0) {
            if (this.bMe == 0) {
                if (this.kze != null && this.kzf && getVisibility() == 0) {
                    this.kze.br(this);
                }
                setText(String.valueOf(this.bMe));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bMe > 0) {
                setText(String.valueOf(this.bMe));
            }
            this.mHandler.removeCallbacks(this.eDu);
            this.mHandler.postDelayed(this.eDu, 1000L);
            this.bMe -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        oC(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bhA();
    }

    private void bhA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
