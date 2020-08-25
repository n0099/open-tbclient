package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes18.dex */
public class DealEventView extends FrameLayout {
    private boolean fjj;
    private long mEt;
    private a mEu;
    private boolean mEv;
    private float mLastX;
    private float mLastY;

    /* loaded from: classes18.dex */
    public interface a {
        void byT();

        void byU();

        void dEp();
    }

    public DealEventView(Context context) {
        this(context, null);
    }

    public DealEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DealEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mEt < 300) {
                    this.fjj = true;
                    if (this.mEu != null) {
                        this.mEu.dEp();
                    }
                } else {
                    this.fjj = false;
                }
                this.mEt = currentTimeMillis;
                break;
            case 1:
                if (this.mLastX - motionEvent.getX() < 10.0f && this.mLastY - motionEvent.getY() < 10.0f) {
                    this.mEv = true;
                } else {
                    this.mEv = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.fjj && DealEventView.this.mEv && DealEventView.this.mEu != null) {
                            DealEventView.this.mEu.byT();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.mLastX - motionEvent.getX() > 60.0f && (this.mLastX - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY) && !this.fjj && this.mEu != null) {
                    this.mEu.byU();
                    break;
                }
                break;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt.getTag() instanceof AnimatorSet) {
                    ((AnimatorSet) childAt.getTag()).cancel();
                }
                i = i2 + 1;
            } else {
                super.removeAllViews();
                return;
            }
        }
    }

    public void setOnViewClickListener(a aVar) {
        this.mEu = aVar;
    }
}
