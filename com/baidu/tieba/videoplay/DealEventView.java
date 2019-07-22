package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DealEventView extends FrameLayout {
    private float Oj;
    private float Ok;
    private boolean cQQ;
    private long jEq;
    private a jEr;
    private boolean jEs;

    /* loaded from: classes6.dex */
    public interface a {
        void aAp();

        void aAq();

        void cxi();
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
                this.Oj = motionEvent.getX();
                this.Ok = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.jEq < 300) {
                    this.cQQ = true;
                    if (this.jEr != null) {
                        this.jEr.cxi();
                    }
                } else {
                    this.cQQ = false;
                }
                this.jEq = currentTimeMillis;
                break;
            case 1:
                if (this.Oj - motionEvent.getX() < 10.0f && this.Ok - motionEvent.getY() < 10.0f) {
                    this.jEs = true;
                } else {
                    this.jEs = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.cQQ && DealEventView.this.jEs && DealEventView.this.jEr != null) {
                            DealEventView.this.jEr.aAp();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.Oj - motionEvent.getX() > 60.0f && (this.Oj - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Ok) && !this.cQQ && this.jEr != null) {
                    this.jEr.aAq();
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
        this.jEr = aVar;
    }
}
