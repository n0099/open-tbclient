package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DealEventView extends FrameLayout {
    private float Ql;
    private float Qm;
    private boolean cHh;
    private long jfu;
    private a jfv;
    private boolean jfw;

    /* loaded from: classes6.dex */
    public interface a {
        void atY();

        void atZ();

        void cmr();
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
                this.Ql = motionEvent.getX();
                this.Qm = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.jfu < 300) {
                    this.cHh = true;
                    if (this.jfv != null) {
                        this.jfv.cmr();
                    }
                } else {
                    this.cHh = false;
                }
                this.jfu = currentTimeMillis;
                break;
            case 1:
                if (this.Ql - motionEvent.getX() < 10.0f && this.Qm - motionEvent.getY() < 10.0f) {
                    this.jfw = true;
                } else {
                    this.jfw = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.cHh && DealEventView.this.jfw && DealEventView.this.jfv != null) {
                            DealEventView.this.jfv.atY();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.Ql - motionEvent.getX() > 60.0f && (this.Ql - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Qm) && !this.cHh && this.jfv != null) {
                    this.jfv.atZ();
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
        this.jfv = aVar;
    }
}
