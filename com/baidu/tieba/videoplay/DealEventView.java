package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes6.dex */
public class DealEventView extends FrameLayout {
    private float Ql;
    private float Qm;
    private boolean cHk;
    private long jfj;
    private a jfk;
    private boolean jfl;

    /* loaded from: classes6.dex */
    public interface a {
        void atV();

        void atW();

        void cmp();
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
                this.Ql = motionEvent.getX();
                this.Qm = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.jfj < 300) {
                    this.cHk = true;
                    if (this.jfk != null) {
                        this.jfk.cmp();
                    }
                } else {
                    this.cHk = false;
                }
                this.jfj = currentTimeMillis;
                break;
            case 1:
                if (this.Ql - motionEvent.getX() < 10.0f && this.Qm - motionEvent.getY() < 10.0f) {
                    this.jfl = true;
                } else {
                    this.jfl = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.cHk && DealEventView.this.jfl && DealEventView.this.jfk != null) {
                            DealEventView.this.jfk.atV();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.Ql - motionEvent.getX() > 60.0f && (this.Ql - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.Qm) && !this.cHk && this.jfk != null) {
                    this.jfk.atW();
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
        this.jfk = aVar;
    }
}
