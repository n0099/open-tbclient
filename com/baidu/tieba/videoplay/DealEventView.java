package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public class DealEventView extends FrameLayout {
    private float Vq;
    private float Vr;
    private boolean eHG;
    private long lKm;
    private a lKn;
    private boolean lKo;

    /* loaded from: classes11.dex */
    public interface a {
        void bjJ();

        void bjK();

        void dlg();
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
                this.Vq = motionEvent.getX();
                this.Vr = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.lKm < 300) {
                    this.eHG = true;
                    if (this.lKn != null) {
                        this.lKn.dlg();
                    }
                } else {
                    this.eHG = false;
                }
                this.lKm = currentTimeMillis;
                break;
            case 1:
                if (this.Vq - motionEvent.getX() < 10.0f && this.Vr - motionEvent.getY() < 10.0f) {
                    this.lKo = true;
                } else {
                    this.lKo = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.eHG && DealEventView.this.lKo && DealEventView.this.lKn != null) {
                            DealEventView.this.lKn.bjJ();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.Vq - motionEvent.getX() > 60.0f && (this.Vq - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Vr) && !this.eHG && this.lKn != null) {
                    this.lKn.bjK();
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
        this.lKn = aVar;
    }
}
