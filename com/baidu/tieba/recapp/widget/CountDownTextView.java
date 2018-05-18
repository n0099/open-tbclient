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
    private int aKc;
    private Runnable bgB;
    private b gfr;
    private boolean gfs;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void U(View view2);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gfr = null;
        this.gfs = true;
        bkr();
    }

    private void bkr() {
        this.bgB = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gfr = null;
        this.gfs = true;
        bkr();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gfr = null;
        this.gfs = true;
        bkr();
    }

    public void update(int i) {
        this.aKc = i;
    }

    public void startCountDown() {
        gx(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gfr = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gfs = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bfY;

        private a(CountDownTextView countDownTextView) {
            this.bfY = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bfY.get();
            if (countDownTextView != null) {
                countDownTextView.gx(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gx(int i) {
        if (i > 0) {
            if (this.aKc == 0) {
                if (this.gfr != null && this.gfs && getVisibility() == 0) {
                    this.gfr.U(this);
                }
                setText(String.valueOf(this.aKc));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.aKc > 0) {
                setText(String.valueOf(this.aKc));
            }
            this.mHandler.removeCallbacks(this.bgB);
            this.mHandler.postDelayed(this.bgB, 1000L);
            this.aKc -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        gx(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Od();
    }

    private void Od() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
