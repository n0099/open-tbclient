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
    private float ccd;
    private boolean hhl;
    private a hiK;
    private long hiL;
    private long hiM;
    private boolean hiN;
    private float mDownX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes2.dex */
    public interface a {
        void bEB();

        void bEz();

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
                this.ccd = motionEvent.getY();
                this.hiL = System.currentTimeMillis();
                this.hiN = true;
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hiL < 100 && currentTimeMillis - this.hiM < 500) {
                    this.hhl = true;
                } else {
                    this.hhl = false;
                }
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                if (Math.abs(velocityTracker.getYVelocity()) > this.mMinimumVelocity && Math.abs(this.ccd - motionEvent.getY()) > 50.0f) {
                    this.hhl = false;
                    this.hiN = false;
                }
                if (this.hhl) {
                    if (this.hiK != null) {
                        this.hiK.u(motionEvent.getRawX(), motionEvent.getRawY());
                    }
                } else if (Math.abs(this.mDownX - motionEvent.getX()) > this.mTouchSlop && (this.mDownX - motionEvent.getX()) - 50.0f > Math.abs(this.ccd - motionEvent.getY()) && this.hiK != null) {
                    this.hiK.bEB();
                }
                if (!this.hhl && this.hiN && Math.abs(this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(this.ccd - motionEvent.getY()) < 30.0f) {
                    postDelayed(new Runnable() { // from class: com.baidu.tieba.videoplay.verticalviewpager.VerticalViewPager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!VerticalViewPager.this.hhl && VerticalViewPager.this.hiN && Math.abs(VerticalViewPager.this.mDownX - motionEvent.getX()) < 30.0f && Math.abs(VerticalViewPager.this.ccd - motionEvent.getY()) < 30.0f && VerticalViewPager.this.hiK != null) {
                                VerticalViewPager.this.hiK.bEz();
                            }
                        }
                    }, 300L);
                }
                this.hiM = currentTimeMillis;
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
        this.hiK = aVar;
    }
}
