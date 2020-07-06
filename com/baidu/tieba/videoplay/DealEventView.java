package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class DealEventView extends FrameLayout {
    private float VU;
    private float VV;
    private boolean eSd;
    private long mfo;
    private a mfp;
    private boolean mfq;

    /* loaded from: classes11.dex */
    public interface a {
        void bml();

        void bmm();

        void dpL();
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
                this.VU = motionEvent.getX();
                this.VV = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mfo < 300) {
                    this.eSd = true;
                    if (this.mfp != null) {
                        this.mfp.dpL();
                    }
                } else {
                    this.eSd = false;
                }
                this.mfo = currentTimeMillis;
                break;
            case 1:
                if (this.VU - motionEvent.getX() < 10.0f && this.VV - motionEvent.getY() < 10.0f) {
                    this.mfq = true;
                } else {
                    this.mfq = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.eSd && DealEventView.this.mfq && DealEventView.this.mfp != null) {
                            DealEventView.this.mfp.bml();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.VU - motionEvent.getX() > 60.0f && (this.VU - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.VV) && !this.eSd && this.mfp != null) {
                    this.mfp.bmm();
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
        this.mfp = aVar;
    }
}
