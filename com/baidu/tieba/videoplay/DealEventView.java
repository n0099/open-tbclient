package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DealEventView extends FrameLayout {
    private float Oj;
    private float Ok;
    private boolean cQX;
    private long jFx;
    private a jFy;
    private boolean jFz;

    /* loaded from: classes6.dex */
    public interface a {
        void aAr();

        void aAs();

        void cxE();
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
                this.Oj = motionEvent.getX();
                this.Ok = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.jFx < 300) {
                    this.cQX = true;
                    if (this.jFy != null) {
                        this.jFy.cxE();
                    }
                } else {
                    this.cQX = false;
                }
                this.jFx = currentTimeMillis;
                break;
            case 1:
                if (this.Oj - motionEvent.getX() < 10.0f && this.Ok - motionEvent.getY() < 10.0f) {
                    this.jFz = true;
                } else {
                    this.jFz = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.cQX && DealEventView.this.jFz && DealEventView.this.jFy != null) {
                            DealEventView.this.jFy.aAr();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.Oj - motionEvent.getX() > 60.0f && (this.Oj - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Ok) && !this.cQX && this.jFy != null) {
                    this.jFy.aAs();
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
        this.jFy = aVar;
    }
}
