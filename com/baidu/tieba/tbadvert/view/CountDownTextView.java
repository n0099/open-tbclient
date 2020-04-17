package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bLZ;
    private final Runnable eDp;
    private b kWG;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes13.dex */
    public interface b {
        void br(View view);
    }

    /* loaded from: classes13.dex */
    private static class a implements Runnable {
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

    public CountDownTextView(Context context) {
        super(context);
        this.bLZ = 0;
        this.mText = "";
        this.kWG = null;
        this.mHandler = new Handler();
        this.eDp = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.kWG = bVar;
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

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            oC(0);
        } else {
            bhC();
        }
    }

    public void au(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bLZ = i;
        }
    }

    private void bhC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oC(int i) {
        this.bLZ -= i;
        if (this.bLZ == 0) {
            if (this.kWG != null) {
                this.kWG.br(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bLZ > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bLZ)));
        }
        this.mHandler.removeCallbacks(this.eDp);
        this.mHandler.postDelayed(this.eDp, 1000L);
    }
}
