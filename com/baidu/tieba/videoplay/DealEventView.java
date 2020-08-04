package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes18.dex */
public class DealEventView extends FrameLayout {
    private float VM;
    private float VN;
    private boolean eYy;
    private long mmG;
    private a mmH;
    private boolean mmI;

    /* loaded from: classes18.dex */
    public interface a {
        void bqf();

        void bqg();

        void dsU();
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
                this.VM = motionEvent.getX();
                this.VN = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.mmG < 300) {
                    this.eYy = true;
                    if (this.mmH != null) {
                        this.mmH.dsU();
                    }
                } else {
                    this.eYy = false;
                }
                this.mmG = currentTimeMillis;
                break;
            case 1:
                if (this.VM - motionEvent.getX() < 10.0f && this.VN - motionEvent.getY() < 10.0f) {
                    this.mmI = true;
                } else {
                    this.mmI = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.eYy && DealEventView.this.mmI && DealEventView.this.mmH != null) {
                            DealEventView.this.mmH.bqf();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.VM - motionEvent.getX() > 60.0f && (this.VM - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.VN) && !this.eYy && this.mmH != null) {
                    this.mmH.bqg();
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
        this.mmH = aVar;
    }
}
