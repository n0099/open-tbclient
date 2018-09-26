package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public class DealEventView extends FrameLayout {
    private boolean bmV;
    private float fVd;
    private float hmE;
    private long huv;
    private a huw;
    private boolean hux;

    /* loaded from: classes2.dex */
    public interface a {
        void Qs();

        void Qt();

        void bGA();
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
                this.hmE = motionEvent.getX();
                this.fVd = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.huv < 300) {
                    this.bmV = true;
                    if (this.huw != null) {
                        this.huw.bGA();
                    }
                } else {
                    this.bmV = false;
                }
                this.huv = currentTimeMillis;
                break;
            case 1:
                if (this.hmE - motionEvent.getX() < 10.0f && this.fVd - motionEvent.getY() < 10.0f) {
                    this.hux = true;
                } else {
                    this.hux = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bmV && DealEventView.this.hux && DealEventView.this.huw != null) {
                            DealEventView.this.huw.Qs();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.hmE - motionEvent.getX() > 60.0f && (this.hmE - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.fVd) && !this.bmV && this.huw != null) {
                    this.huw.Qt();
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
        this.huw = aVar;
    }
}
