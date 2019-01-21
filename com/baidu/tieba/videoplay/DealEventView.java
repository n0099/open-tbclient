package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class DealEventView extends FrameLayout {
    private boolean bwa;
    private float hHi;
    private long hOX;
    private a hOY;
    private boolean hOZ;
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
                this.hHi = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hOX < 300) {
                    this.bwa = true;
                    if (this.hOY != null) {
                        this.hOY.bMO();
                    }
                } else {
                    this.bwa = false;
                }
                this.hOX = currentTimeMillis;
                break;
            case 1:
                if (this.hHi - motionEvent.getX() < 10.0f && this.mLastY - motionEvent.getY() < 10.0f) {
                    this.hOZ = true;
                } else {
                    this.hOZ = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bwa && DealEventView.this.hOZ && DealEventView.this.hOY != null) {
                            DealEventView.this.hOY.TZ();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.hHi - motionEvent.getX() > 60.0f && (this.hHi - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.mLastY) && !this.bwa && this.hOY != null) {
                    this.hOY.Ua();
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
        this.hOY = aVar;
    }
}
