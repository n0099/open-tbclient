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
    private int bLZ;
    private Runnable eDp;
    private b kza;
    private boolean kzb;
    private Handler mHandler;

    /* loaded from: classes13.dex */
    public interface b {
        void br(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.kza = null;
        this.kzb = true;
        cOG();
    }

    private void cOG() {
        this.eDp = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.kza = null;
        this.kzb = true;
        cOG();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.kza = null;
        this.kzb = true;
        cOG();
    }

    public void update(int i) {
        this.bLZ = i;
    }

    public void startCountDown() {
        oC(1);
    }

    public void setTimeoutListener(b bVar) {
        this.kza = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.kzb = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> eCH;

        private a(CountDownTextView countDownTextView) {
            this.eCH = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.eCH.get();
            if (countDownTextView != null) {
                countDownTextView.oC(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(int i) {
        if (i > 0) {
            if (this.bLZ == 0) {
                if (this.kza != null && this.kzb && getVisibility() == 0) {
                    this.kza.br(this);
                }
                setText(String.valueOf(this.bLZ));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bLZ > 0) {
                setText(String.valueOf(this.bLZ));
            }
            this.mHandler.removeCallbacks(this.eDp);
            this.mHandler.postDelayed(this.eDp, 1000L);
            this.bLZ -= i;
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
        bhC();
    }

    private void bhC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
