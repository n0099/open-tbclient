package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class CountDownTextView extends TextView {
    private Runnable glu;
    private int mCounter;
    private Handler mHandler;
    private b nae;
    private boolean naf;

    /* loaded from: classes8.dex */
    public interface b {
        void cf(View view);
    }

    public CountDownTextView(Context context) {
        super(context);
        this.mHandler = null;
        this.nae = null;
        this.naf = true;
        dES();
    }

    private void dES() {
        this.glu = new a();
        this.mHandler = new Handler();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.nae = null;
        this.naf = true;
        dES();
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.nae = null;
        this.naf = true;
        dES();
    }

    public void update(int i) {
        this.mCounter = i;
    }

    public void startCountDown() {
        th(1);
    }

    public void setTimeoutListener(b bVar) {
        this.nae = bVar;
    }

    public void setEnableTimeoutListener(boolean z) {
        this.naf = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        private final WeakReference<CountDownTextView> gks;

        private a(CountDownTextView countDownTextView) {
            this.gks = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.gks.get();
            if (countDownTextView != null) {
                countDownTextView.th(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(int i) {
        if (i > 0) {
            if (this.mCounter == 0) {
                if (this.nae != null && this.naf && getVisibility() == 0) {
                    this.nae.cf(this);
                }
                setText(String.valueOf(this.mCounter));
                this.mHandler.removeCallbacksAndMessages(null);
                return;
            }
            if (this.mCounter > 0) {
                setText(String.valueOf(this.mCounter));
            }
            this.mHandler.removeCallbacks(this.glu);
            this.mHandler.postDelayed(this.glu, 1000L);
            this.mCounter -= i;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        th(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bMO();
    }

    private void bMO() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}
