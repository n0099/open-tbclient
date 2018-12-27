package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class DealEventView extends FrameLayout {
    private boolean bvl;
    private float hGa;
    private long hNP;
    private a hNQ;
    private boolean hNR;
    private float mLastY;

    /* loaded from: classes4.dex */
    public interface a {
        void TD();

        void TE();

        void bMf();
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
                this.hGa = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hNP < 300) {
                    this.bvl = true;
                    if (this.hNQ != null) {
                        this.hNQ.bMf();
                    }
                } else {
                    this.bvl = false;
                }
                this.hNP = currentTimeMillis;
                break;
            case 1:
                if (this.hGa - motionEvent.getX() < 10.0f && this.mLastY - motionEvent.getY() < 10.0f) {
                    this.hNR = true;
                } else {
                    this.hNR = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bvl && DealEventView.this.hNR && DealEventView.this.hNQ != null) {
                            DealEventView.this.hNQ.TD();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.hGa - motionEvent.getX() > 60.0f && (this.hGa - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY) && !this.bvl && this.hNQ != null) {
                    this.hNQ.TE();
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
        this.hNQ = aVar;
    }
}
