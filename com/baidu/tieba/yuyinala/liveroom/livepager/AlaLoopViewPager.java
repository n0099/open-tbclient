package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hkC;
    ViewPager.OnPageChangeListener hkD;
    private ViewPager.OnPageChangeListener hkF;
    private AlaLoopPagerAdapterWrapper nYF;
    private a nYG;

    /* loaded from: classes4.dex */
    public interface a {
        boolean ME(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hkC = z;
        if (this.nYF != null) {
            this.nYF.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.nYF = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.nYF.setBoundaryCaching(this.hkC);
        super.setAdapter(this.nYF);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.nYF != null ? this.nYF.ccT() : this.nYF;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.nYF != null) {
            return this.nYF.wi(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.nYF.wj(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hkD = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hkC = false;
        this.hkF = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hkG = -1.0f;
            private float hkH = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wi = AlaLoopViewPager.this.nYF.wi(i);
                if (this.hkH != wi) {
                    this.hkH = wi;
                    if (AlaLoopViewPager.this.hkD != null) {
                        AlaLoopViewPager.this.hkD.onPageSelected(wi);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.nYF != null) {
                    int wi = AlaLoopViewPager.this.nYF.wi(i);
                    if (f == 0.0f && this.hkG == 0.0f && (i == 0 || i == AlaLoopViewPager.this.nYF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                    i = wi;
                }
                this.hkG = f;
                if (AlaLoopViewPager.this.hkD != null) {
                    if (AlaLoopViewPager.this.nYF != null && i != AlaLoopViewPager.this.nYF.ccS() - 1) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.nYF != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wi = AlaLoopViewPager.this.nYF.wi(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.nYF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                }
                if (AlaLoopViewPager.this.hkD != null) {
                    AlaLoopViewPager.this.hkD.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkC = false;
        this.hkF = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hkG = -1.0f;
            private float hkH = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wi = AlaLoopViewPager.this.nYF.wi(i);
                if (this.hkH != wi) {
                    this.hkH = wi;
                    if (AlaLoopViewPager.this.hkD != null) {
                        AlaLoopViewPager.this.hkD.onPageSelected(wi);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.nYF != null) {
                    int wi = AlaLoopViewPager.this.nYF.wi(i);
                    if (f == 0.0f && this.hkG == 0.0f && (i == 0 || i == AlaLoopViewPager.this.nYF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                    i = wi;
                }
                this.hkG = f;
                if (AlaLoopViewPager.this.hkD != null) {
                    if (AlaLoopViewPager.this.nYF != null && i != AlaLoopViewPager.this.nYF.ccS() - 1) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hkD.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hkD.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.nYF != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wi = AlaLoopViewPager.this.nYF.wi(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.nYF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wi, false);
                    }
                }
                if (AlaLoopViewPager.this.hkD != null) {
                    AlaLoopViewPager.this.hkD.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hkF);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.nYG != null) {
            return this.nYG.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean ME(int i) {
        if (this.nYG != null) {
            return this.nYG.ME(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.nYG = aVar;
    }
}
