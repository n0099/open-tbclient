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
    private int bFG;
    private Runnable bFI;
    private b gWZ;
    private boolean gXa;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gWZ = null;
        this.gXa = true;
        bxe();
    }

    private void bxe() {
        this.bFI = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gWZ = null;
        this.gXa = true;
        bxe();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gWZ = null;
        this.gXa = true;
        bxe();
    }

    public void update(int i) {
        this.bFG = i;
    }

    public void startCountDown() {
        hO(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gWZ = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gXa = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bFf;

        private a(CountDownTextView countDownTextView) {
            this.bFf = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bFf.get();
            if (countDownTextView != null) {
                countDownTextView.hO(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (i > 0) {
            if (this.bFG == 0) {
                if (this.gWZ != null && this.gXa && getVisibility() == 0) {
                    this.gWZ.ak(this);
                }
                setText(String.valueOf(this.bFG));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bFG > 0) {
                setText(String.valueOf(this.bFG));
            }
            this.mHandler.removeCallbacks(this.bFI);
            this.mHandler.postDelayed(this.bFI, 1000L);
            this.bFG -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        hO(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XI();
    }

    private void XI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
