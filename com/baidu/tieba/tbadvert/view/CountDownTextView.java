package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* loaded from: classes13.dex */
public class CountDownTextView extends TextView {
    private int bnS;
    private final Runnable edy;
    private b kmA;
    private Handler mHandler;
    private String mText;

    /* loaded from: classes13.dex */
    public interface b {
        void bq(View view);
    }

    /* loaded from: classes13.dex */
    private static class a implements Runnable {
        private final WeakReference<CountDownTextView> ecT;

        private a(CountDownTextView countDownTextView) {
            this.ecT = new WeakReference<>(countDownTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            CountDownTextView countDownTextView = this.ecT.get();
            if (countDownTextView != null) {
                countDownTextView.op(1);
            }
        }
    }

    public CountDownTextView(Context context) {
        super(context);
        this.bnS = 0;
        this.mText = "";
        this.kmA = null;
        this.mHandler = new Handler();
        this.edy = new a();
    }

    public void setTimeoutListener(b bVar) {
        this.kmA = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        op(0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aZy();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            op(0);
        } else {
            aZy();
        }
    }

    public void al(String str, int i) {
        this.mText = str;
        if (i > 0) {
            this.bnS = i;
        }
    }

    private void aZy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(int i) {
        this.bnS -= i;
        if (this.bnS == 0) {
            if (this.kmA != null) {
                this.kmA.bq(this);
            }
            this.mHandler.removeCallbacksAndMessages(null);
            return;
        }
        if (this.bnS > 0) {
            setText(String.format("%s %s", this.mText, Integer.valueOf(this.bnS)));
        }
        this.mHandler.removeCallbacks(this.edy);
        this.mHandler.postDelayed(this.edy, 1000L);
    }
}
