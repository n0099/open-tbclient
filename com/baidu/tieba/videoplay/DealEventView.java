package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes9.dex */
public class DealEventView extends FrameLayout {
    private float Bn;
    private boolean dOs;
    private long kED;
    private a kEE;
    private boolean kEF;
    private float mLastX;

    /* loaded from: classes9.dex */
    public interface a {
        void aSS();

        void aST();

        void cRp();
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
                this.Bn = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.kED < 300) {
                    this.dOs = true;
                    if (this.kEE != null) {
                        this.kEE.cRp();
                    }
                } else {
                    this.dOs = false;
                }
                this.kED = currentTimeMillis;
                break;
            case 1:
                if (this.mLastX - motionEvent.getX() < 10.0f && this.Bn - motionEvent.getY() < 10.0f) {
                    this.kEF = true;
                } else {
                    this.kEF = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.dOs && DealEventView.this.kEF && DealEventView.this.kEE != null) {
                            DealEventView.this.kEE.aSS();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.mLastX - motionEvent.getX() > 60.0f && (this.mLastX - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Bn) && !this.dOs && this.kEE != null) {
                    this.kEE.aST();
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
        this.kEE = aVar;
    }
}
