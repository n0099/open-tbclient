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
    private int aqt;
    private Runnable cZf;
    private b iHc;
    private boolean iHd;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void bn(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.iHc = null;
        this.iHd = true;
        cfZ();
    }

    private void cfZ() {
        this.cZf = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.iHc = null;
        this.iHd = true;
        cfZ();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.iHc = null;
        this.iHd = true;
        cfZ();
    }

    public void update(int i) {
        this.aqt = i;
    }

    public void startCountDown() {
        ms(1);
    }

    public void setTimeoutListener(b bVar) {
        this.iHc = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.iHd = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> cYz;

        private a(CountDownTextView countDownTextView) {
            this.cYz = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.cYz.get();
            if (countDownTextView != null) {
                countDownTextView.ms(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (i > 0) {
            if (this.aqt == 0) {
                if (this.iHc != null && this.iHd && getVisibility() == 0) {
                    this.iHc.bn(this);
                }
                setText(String.valueOf(this.aqt));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aqt > 0) {
                setText(String.valueOf(this.aqt));
            }
            this.mHandler.removeCallbacks(this.cZf);
            this.mHandler.postDelayed(this.cZf, 1000L);
            this.aqt -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ms(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aCN();
    }

    private void aCN() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
