package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DealEventView extends FrameLayout {
    private float NR;
    private float NT;
    private boolean cPu;
    private long jyh;
    private a jyi;
    private boolean jyj;

    /* loaded from: classes6.dex */
    public interface a {
        void azb();

        void azc();

        void cut();
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
                this.NR = motionEvent.getX();
                this.NT = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.jyh < 300) {
                    this.cPu = true;
                    if (this.jyi != null) {
                        this.jyi.cut();
                    }
                } else {
                    this.cPu = false;
                }
                this.jyh = currentTimeMillis;
                break;
            case 1:
                if (this.NR - motionEvent.getX() < 10.0f && this.NT - motionEvent.getY() < 10.0f) {
                    this.jyj = true;
                } else {
                    this.jyj = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.cPu && DealEventView.this.jyj && DealEventView.this.jyi != null) {
                            DealEventView.this.jyi.azb();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.NR - motionEvent.getX() > 60.0f && (this.NR - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.NT) && !this.cPu && this.jyi != null) {
                    this.jyi.azc();
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
        this.jyi = aVar;
    }
}
