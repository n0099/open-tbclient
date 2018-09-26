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
    private int bwG;
    private Runnable bwI;
    private b gDk;
    private boolean gDl;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void al(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gDk = null;
        this.gDl = true;
        bre();
    }

    private void bre() {
        this.bwI = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gDk = null;
        this.gDl = true;
        bre();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gDk = null;
        this.gDl = true;
        bre();
    }

    public void update(int i) {
        this.bwG = i;
    }

    public void startCountDown() {
        he(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gDk = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gDl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bwe;

        private a(CountDownTextView countDownTextView) {
            this.bwe = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bwe.get();
            if (countDownTextView != null) {
                countDownTextView.he(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(int i) {
        if (i > 0) {
            if (this.bwG == 0) {
                if (this.gDk != null && this.gDl && getVisibility() == 0) {
                    this.gDk.al(this);
                }
                setText(String.valueOf(this.bwG));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bwG > 0) {
                setText(String.valueOf(this.bwG));
            }
            this.mHandler.removeCallbacks(this.bwI);
            this.mHandler.postDelayed(this.bwI, 1000L);
            this.bwG -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        he(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TY();
    }

    private void TY() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
