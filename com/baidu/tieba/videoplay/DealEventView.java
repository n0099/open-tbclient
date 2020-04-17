package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class DealEventView extends FrameLayout {
    private float UY;
    private float UZ;
    private boolean etb;
    private long lrD;
    private a lrE;
    private boolean lrF;

    /* loaded from: classes11.dex */
    public interface a {
        void bdA();

        void bdB();

        void ddU();
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
                this.UY = motionEvent.getX();
                this.UZ = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lrD < 300) {
                    this.etb = true;
                    if (this.lrE != null) {
                        this.lrE.ddU();
                    }
                } else {
                    this.etb = false;
                }
                this.lrD = currentTimeMillis;
                break;
            case 1:
                if (this.UY - motionEvent.getX() < 10.0f && this.UZ - motionEvent.getY() < 10.0f) {
                    this.lrF = true;
                } else {
                    this.lrF = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.etb && DealEventView.this.lrF && DealEventView.this.lrE != null) {
                            DealEventView.this.lrE.bdA();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.UY - motionEvent.getX() > 60.0f && (this.UY - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.UZ) && !this.etb && this.lrE != null) {
                    this.lrE.bdB();
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
        this.lrE = aVar;
    }
}
