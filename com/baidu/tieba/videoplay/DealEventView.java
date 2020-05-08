package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class DealEventView extends FrameLayout {
    private float Vb;
    private float Vc;
    private boolean eth;
    private long lrH;
    private a lrI;
    private boolean lrJ;

    /* loaded from: classes11.dex */
    public interface a {
        void bdy();

        void bdz();

        void ddR();
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
                this.Vb = motionEvent.getX();
                this.Vc = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lrH < 300) {
                    this.eth = true;
                    if (this.lrI != null) {
                        this.lrI.ddR();
                    }
                } else {
                    this.eth = false;
                }
                this.lrH = currentTimeMillis;
                break;
            case 1:
                if (this.Vb - motionEvent.getX() < 10.0f && this.Vc - motionEvent.getY() < 10.0f) {
                    this.lrJ = true;
                } else {
                    this.lrJ = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.eth && DealEventView.this.lrJ && DealEventView.this.lrI != null) {
                            DealEventView.this.lrI.bdy();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.Vb - motionEvent.getX() > 60.0f && (this.Vb - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Vc) && !this.eth && this.lrI != null) {
                    this.lrI.bdz();
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
        this.lrI = aVar;
    }
}
