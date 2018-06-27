package com.baidu.tieba.videoplay.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.tieba.videoplay.verticalviewpager.transforms.DefaultTransformer;
/* loaded from: classes2.dex */
public class VerticalViewPager extends ViewPager {
    private float ceo;
    private boolean hls;
    private a hmP;
    private long hmQ;
    private long hmR;
    private boolean hmS;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes2.dex */
    public interface a {
        void bEZ();

        void bFb();

        void u(float f, float f2);
    }

    public VerticalViewPager(Context context) {
        this(context, null);
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setPageTransformer(false, new DefaultTransformer());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
    }

    private MotionEvent M(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        IllegalArgumentException e;
        try {
            z = super.onInterceptTouchEvent(M(motionEvent));
            try {
                M(motionEvent);
            } catch (IllegalArgumentException e2) {
                e = e2;
                e.printStackTrace();
                return z;
            }
        } catch (IllegalArgumentException e3) {
            z = false;
            e = e3;
        }
        return z;
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mDownX = motionEvent.getX();
                this.ceo = motionEvent.getY();
                this.hmQ = System.currentTimeMillis();
                this.hmS = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hmQ < 100 && currentTimeMillis - this.hmR < 500) {
                    this.hls = true;
                } else {
                    this.hls = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.ceo - motionEvent.getY()) > 50.0f) {
                    this.hls = false;
                    this.hmS = false;
                }
                if (this.hls) {
                    if (this.hmP != null) {
                        this.hmP.u(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.ceo - motionEvent.getY()) && this.hmP != null) {
                    this.hmP.bFb();
                }
                if (!this.hls && this.hmS && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.ceo - motionEvent.getY()) < 30.0f) {
                    postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!VerticalViewPager.this.hls && VerticalViewPager.this.hmS && Math.abs(VerticalViewPager.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(VerticalViewPager.this.ceo - motionEvent.getY()) < 30.0f && VerticalViewPager.this.hmP != null) {
                                VerticalViewPager.this.hmP.bEZ();
                            }
                        }
                    }, 300L);
                }
                this.hmR = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(M(motionEvent));
        M(motionEvent);
        return onTouchEvent;
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void setOnViewClickListener(a aVar) {
        this.hmP = aVar;
    }
}
