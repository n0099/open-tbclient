package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.live.tbadk.widget.SlideRatioViewPager;
/* loaded from: classes4.dex */
public class AlaActiveBannerViewPager extends SlideRatioViewPager {
    private View.OnTouchListener fGd;
    private boolean gBZ;
    private Handler mHandler;
    private SlideRatioViewPager.OnPageChangeListener mOnPageChangeListener;
    private Runnable mRunnable;

    public AlaActiveBannerViewPager(Context context) {
        super(context);
        this.gBZ = false;
        this.fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaActiveBannerViewPager.this.gBZ = true;
                } else {
                    AlaActiveBannerViewPager.this.gBZ = false;
                }
                return false;
            }
        };
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPager.2
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    AlaActiveBannerViewPager.this.gBZ = true;
                } else {
                    AlaActiveBannerViewPager.this.gBZ = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaActiveBannerViewPager.this.gBZ && AlaActiveBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaActiveBannerViewPager.this.setCurrentItem(AlaActiveBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaActiveBannerViewPager.this.mHandler.postDelayed(AlaActiveBannerViewPager.this.mRunnable, 10000L);
            }
        };
        init(context);
    }

    public AlaActiveBannerViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gBZ = false;
        this.fGd = new View.OnTouchListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPager.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    AlaActiveBannerViewPager.this.gBZ = true;
                } else {
                    AlaActiveBannerViewPager.this.gBZ = false;
                }
                return false;
            }
        };
        this.mOnPageChangeListener = new SlideRatioViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPager.2
            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
            }

            @Override // com.baidu.live.tbadk.widget.SlideRatioViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (i == 1) {
                    AlaActiveBannerViewPager.this.gBZ = true;
                } else {
                    AlaActiveBannerViewPager.this.gBZ = false;
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveBannerViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AlaActiveBannerViewPager.this.gBZ && AlaActiveBannerViewPager.this.getAdapter().getCount() > 3) {
                    AlaActiveBannerViewPager.this.setCurrentItem(AlaActiveBannerViewPager.this.getCurrentItem() + 1, false);
                }
                AlaActiveBannerViewPager.this.mHandler.postDelayed(AlaActiveBannerViewPager.this.mRunnable, 10000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mHandler = new Handler();
        addOnPageChangeListener(this.mOnPageChangeListener);
        setOnTouchListener(this.fGd);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void bZT() {
        if (getAdapter().getCount() > 1) {
            setCurrentItem(1);
            this.mHandler.removeCallbacks(this.mRunnable);
            this.mHandler.postDelayed(this.mRunnable, 10000L);
        }
    }

    public void release() {
        this.mHandler.removeCallbacks(this.mRunnable);
    }
}
