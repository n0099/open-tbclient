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
    private float bUb;
    private boolean gVK;
    private a gXi;
    private long gXj;
    private long gXk;
    private boolean gXl;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes2.dex */
    public interface a {
        void bzt();

        void bzv();

        void n(float f, float f2);
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

    private MotionEvent L(MotionEvent motionEvent) {
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
            z = super.onInterceptTouchEvent(L(motionEvent));
            try {
                L(motionEvent);
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
                this.bUb = motionEvent.getY();
                this.gXj = System.currentTimeMillis();
                this.gXl = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gXj < 100 && currentTimeMillis - this.gXk < 500) {
                    this.gVK = true;
                } else {
                    this.gVK = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.bUb - motionEvent.getY()) > 50.0f) {
                    this.gVK = false;
                    this.gXl = false;
                }
                if (this.gVK) {
                    if (this.gXi != null) {
                        this.gXi.n(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.bUb - motionEvent.getY()) && this.gXi != null) {
                    this.gXi.bzv();
                }
                if (!this.gVK && this.gXl && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.bUb - motionEvent.getY()) < 30.0f) {
                    postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!VerticalViewPager.this.gVK && VerticalViewPager.this.gXl && Math.abs(VerticalViewPager.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(VerticalViewPager.this.bUb - motionEvent.getY()) < 30.0f && VerticalViewPager.this.gXi != null) {
                                VerticalViewPager.this.gXi.bzt();
                            }
                        }
                    }, 300L);
                }
                this.gXk = currentTimeMillis;
                releaseVelocityTracker();
                break;
            case 3:
                releaseVelocityTracker();
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(L(motionEvent));
        L(motionEvent);
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
        this.gXi = aVar;
    }
}
