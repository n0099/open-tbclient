package com.baidu.tieba.video.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class RecordLayout extends RelativeLayout {
    private float mDownX;
    private int mFlingDistance;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private VelocityTracker mVelocityTracker;
    private a nRd;

    /* loaded from: classes8.dex */
    public interface a {
        void dUj();

        void dUk();
    }

    public RecordLayout(Context context) {
        super(context);
        init();
    }

    public RecordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mFlingDistance = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds150);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getRawX();
                break;
            case 1:
            case 3:
                if (this.nRd != null) {
                    this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    float xVelocity = this.mVelocityTracker.getXVelocity();
                    int rawX = (int) (motionEvent.getRawX() - this.mDownX);
                    if (Math.abs(xVelocity) > this.mMinimumVelocity && Math.abs(rawX) > this.mFlingDistance) {
                        if (rawX > 0) {
                            this.nRd.dUk();
                        } else {
                            this.nRd.dUj();
                        }
                    } else if (Math.abs(rawX) > 0.5d * com.baidu.adp.lib.util.l.getEquipmentWidth(getContext())) {
                        if (rawX > 0) {
                            this.nRd.dUk();
                        } else {
                            this.nRd.dUk();
                        }
                    }
                    this.mVelocityTracker.clear();
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(a aVar) {
        this.nRd = aVar;
    }
}
