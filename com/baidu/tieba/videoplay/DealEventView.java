package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class DealEventView extends FrameLayout {
    private boolean bvi;
    private float hCP;
    private long hKE;
    private a hKF;
    private boolean hKG;
    private float mLastY;

    /* loaded from: classes4.dex */
    public interface a {
        void TB();

        void TC();

        void bLq();
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
                this.hCP = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hKE < 300) {
                    this.bvi = true;
                    if (this.hKF != null) {
                        this.hKF.bLq();
                    }
                } else {
                    this.bvi = false;
                }
                this.hKE = currentTimeMillis;
                break;
            case 1:
                if (this.hCP - motionEvent.getX() < 10.0f && this.mLastY - motionEvent.getY() < 10.0f) {
                    this.hKG = true;
                } else {
                    this.hKG = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bvi && DealEventView.this.hKG && DealEventView.this.hKF != null) {
                            DealEventView.this.hKF.TB();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.hCP - motionEvent.getX() > 60.0f && (this.hCP - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY) && !this.bvi && this.hKF != null) {
                    this.hKF.TC();
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
        this.hKF = aVar;
    }
}
