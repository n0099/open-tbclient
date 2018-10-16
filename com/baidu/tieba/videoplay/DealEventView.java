package com.baidu.tieba.videoplay;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class DealEventView extends FrameLayout {
    private boolean bqX;
    private float gcD;
    private long hBH;
    private a hBI;
    private boolean hBJ;
    private float htT;

    /* loaded from: classes4.dex */
    public interface a {
        void Sm();

        void Sn();

        void bJM();
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
                this.htT = motionEvent.getX();
                this.gcD = motionEvent.getY();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hBH < 300) {
                    this.bqX = true;
                    if (this.hBI != null) {
                        this.hBI.bJM();
                    }
                } else {
                    this.bqX = false;
                }
                this.hBH = currentTimeMillis;
                break;
            case 1:
                if (this.htT - motionEvent.getX() < 10.0f && this.gcD - motionEvent.getY() < 10.0f) {
                    this.hBJ = true;
                } else {
                    this.hBJ = false;
                }
                postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.DealEventView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!DealEventView.this.bqX && DealEventView.this.hBJ && DealEventView.this.hBI != null) {
                            DealEventView.this.hBI.Sm();
                        }
                    }
                }, 300L);
                break;
            case 2:
                if (this.htT - motionEvent.getX() > 60.0f && (this.htT - motionEvent.getX()) - 10.0f > Math.abs(motionEvent.getY() - this.gcD) && !this.bqX && this.hBI != null) {
                    this.hBI.Sn();
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
        this.hBI = aVar;
    }
}
