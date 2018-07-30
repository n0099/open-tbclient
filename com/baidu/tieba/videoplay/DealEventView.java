package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class DealEventView extends FrameLayout {
    private boolean bhc;
    private float fNq;
    private float heL;
    private long hmF;
    private a hmG;
    private boolean hmH;

    /* loaded from: classes2.dex */
    public interface a {
        void OA();

        void Oz();

        void bDJ();
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
                this.heL = motionEvent.getX();
                this.fNq = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hmF < 300) {
                    this.bhc = true;
                    if (this.hmG != null) {
                        this.hmG.bDJ();
                    }
                } else {
                    this.bhc = false;
                }
                this.hmF = currentTimeMillis;
                break;
            case 1:
                if (this.heL - motionEvent.getX() < 10.0f && this.fNq - motionEvent.getY() < 10.0f) {
                    this.hmH = true;
                } else {
                    this.hmH = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bhc && DealEventView.this.hmH && DealEventView.this.hmG != null) {
                            DealEventView.this.hmG.Oz();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.heL - motionEvent.getX() > 60.0f && (this.heL - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.fNq) && !this.bhc && this.hmG != null) {
                    this.hmG.OA();
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
        this.hmG = aVar;
    }
}
