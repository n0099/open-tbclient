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
    private int bFF;
    private Runnable bFH;
    private b gWY;
    private boolean gWZ;
    private Handler mHandler;

    /* loaded from: classes3.dex */
    public interface b {
        void ak(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.gWY = null;
        this.gWZ = true;
        bxe();
    }

    private void bxe() {
        this.bFH = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.gWY = null;
        this.gWZ = true;
        bxe();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.gWY = null;
        this.gWZ = true;
        bxe();
    }

    public void update(int i) {
        this.bFF = i;
    }

    public void startCountDown() {
        hO(1);
    }

    public void setTimeoutListener(b bVar) {
        this.gWY = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.gWZ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> bFe;

        private a(CountDownTextView countDownTextView) {
            this.bFe = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.bFe.get();
            if (countDownTextView != null) {
                countDownTextView.hO(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (i > 0) {
            if (this.bFF == 0) {
                if (this.gWY != null && this.gWZ && getVisibility() == 0) {
                    this.gWY.ak(this);
                }
                setText(String.valueOf(this.bFF));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.bFF > 0) {
                setText(String.valueOf(this.bFF));
            }
            this.mHandler.removeCallbacks(this.bFH);
            this.mHandler.postDelayed(this.bFH, 1000L);
            this.bFF -= i;
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
