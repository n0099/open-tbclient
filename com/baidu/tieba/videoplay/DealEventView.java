package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DealEventView extends FrameLayout {
    private float NT;
    private float NU;
    private boolean cPt;
    private long jye;
    private a jyf;
    private boolean jyg;

    /* loaded from: classes6.dex */
    public interface a {
        void azb();

        void azc();

        void cuu();
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
                this.NT = motionEvent.getX();
                this.NU = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.jye < 300) {
                    this.cPt = true;
                    if (this.jyf != null) {
                        this.jyf.cuu();
                    }
                } else {
                    this.cPt = false;
                }
                this.jye = currentTimeMillis;
                break;
            case 1:
                if (this.NT - motionEvent.getX() < 10.0f && this.NU - motionEvent.getY() < 10.0f) {
                    this.jyg = true;
                } else {
                    this.jyg = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.cPt && DealEventView.this.jyg && DealEventView.this.jyf != null) {
                            DealEventView.this.jyf.azb();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.NT - motionEvent.getX() > 60.0f && (this.NT - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.NU) && !this.cPt && this.jyf != null) {
                    this.jyf.azc();
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
        this.jyf = aVar;
    }
}
