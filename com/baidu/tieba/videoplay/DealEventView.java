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
    private boolean dSy;
    private long kFD;
    private a kFE;
    private boolean kFF;
    private float mLastX;

    /* loaded from: classes11.dex */
    public interface a {
        void aVj();

        void aVk();

        void cSK();
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
                if (currentTimeMillis - this.kFD < 300) {
                    this.dSy = true;
                    if (this.kFE != null) {
                        this.kFE.cSK();
                    }
                } else {
                    this.dSy = false;
                }
                this.kFD = currentTimeMillis;
                break;
            case 1:
                if (this.mLastX - motionEvent.getX() < 10.0f && this.BF - motionEvent.getY() < 10.0f) {
                    this.kFF = true;
                } else {
                    this.kFF = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.dSy && DealEventView.this.kFF && DealEventView.this.kFE != null) {
                            DealEventView.this.kFE.aVj();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.mLastX - motionEvent.getX() > 60.0f && (this.mLastX - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.BF) && !this.dSy && this.kFE != null) {
                    this.kFE.aVk();
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
        this.kFE = aVar;
    }
}
