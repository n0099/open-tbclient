package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class DealEventView extends FrameLayout {
    private float BF;
    private boolean dTd;
    private boolean kHA;
    private long kHy;
    private a kHz;
    private float mLastX;

    /* loaded from: classes11.dex */
    public interface a {
        void aVq();

        void aVr();

        void cTh();
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
                this.BF = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.kHy < 300) {
                    this.dTd = true;
                    if (this.kHz != null) {
                        this.kHz.cTh();
                    }
                } else {
                    this.dTd = false;
                }
                this.kHy = currentTimeMillis;
                break;
            case 1:
                if (this.mLastX - motionEvent.getX() < 10.0f && this.BF - motionEvent.getY() < 10.0f) {
                    this.kHA = true;
                } else {
                    this.kHA = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.dTd && DealEventView.this.kHA && DealEventView.this.kHz != null) {
                            DealEventView.this.kHz.aVq();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.mLastX - motionEvent.getX() > 60.0f && (this.mLastX - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.BF) && !this.dTd && this.kHz != null) {
                    this.kHz.aVr();
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
        this.kHz = aVar;
    }
}
