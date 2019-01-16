package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class DealEventView extends FrameLayout {
    private boolean bvZ;
    private float hHh;
    private long hOW;
    private a hOX;
    private boolean hOY;
    private float mLastY;

    /* loaded from: classes4.dex */
    public interface a {
        void TZ();

        void Ua();

        void bMO();
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
                this.hHh = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hOW < 300) {
                    this.bvZ = true;
                    if (this.hOX != null) {
                        this.hOX.bMO();
                    }
                } else {
                    this.bvZ = false;
                }
                this.hOW = currentTimeMillis;
                break;
            case 1:
                if (this.hHh - motionEvent.getX() < 10.0f && this.mLastY - motionEvent.getY() < 10.0f) {
                    this.hOY = true;
                } else {
                    this.hOY = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bvZ && DealEventView.this.hOY && DealEventView.this.hOX != null) {
                            DealEventView.this.hOX.TZ();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.hHh - motionEvent.getX() > 60.0f && (this.hHh - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY) && !this.bvZ && this.hOX != null) {
                    this.hOX.Ua();
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
        this.hOX = aVar;
    }
}
