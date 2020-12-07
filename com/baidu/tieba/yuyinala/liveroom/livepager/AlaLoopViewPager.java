package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hua;
    ViewPager.OnPageChangeListener hub;
    private ViewPager.OnPageChangeListener hud;
    private AlaLoopPagerAdapterWrapper onF;
    private a onG;

    /* loaded from: classes4.dex */
    public interface a {
        boolean Nw(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hua = z;
        if (this.onF != null) {
            this.onF.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.onF = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.onF.setBoundaryCaching(this.hua);
        super.setAdapter(this.onF);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.onF != null ? this.onF.cgL() : this.onF;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.onF != null) {
            return this.onF.wN(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.onF.wO(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hub = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hua = false;
        this.hud = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hue = -1.0f;
            private float huf = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.onF.wN(i);
                if (this.huf != wN) {
                    this.huf = wN;
                    if (AlaLoopViewPager.this.hub != null) {
                        AlaLoopViewPager.this.hub.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.onF != null) {
                    int wN = AlaLoopViewPager.this.onF.wN(i);
                    if (f == 0.0f && this.hue == 0.0f && (i == 0 || i == AlaLoopViewPager.this.onF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hue = f;
                if (AlaLoopViewPager.this.hub != null) {
                    if (AlaLoopViewPager.this.onF != null && i != AlaLoopViewPager.this.onF.cgK() - 1) {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hub.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.onF != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.onF.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.onF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hub != null) {
                    AlaLoopViewPager.this.hub.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hua = false;
        this.hud = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hue = -1.0f;
            private float huf = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.onF.wN(i);
                if (this.huf != wN) {
                    this.huf = wN;
                    if (AlaLoopViewPager.this.hub != null) {
                        AlaLoopViewPager.this.hub.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.onF != null) {
                    int wN = AlaLoopViewPager.this.onF.wN(i);
                    if (f == 0.0f && this.hue == 0.0f && (i == 0 || i == AlaLoopViewPager.this.onF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hue = f;
                if (AlaLoopViewPager.this.hub != null) {
                    if (AlaLoopViewPager.this.onF != null && i != AlaLoopViewPager.this.onF.cgK() - 1) {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hub.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hub.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.onF != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.onF.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.onF.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hub != null) {
                    AlaLoopViewPager.this.hub.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hud);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.onG != null) {
            return this.onG.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean Nw(int i) {
        if (this.onG != null) {
            return this.onG.Nw(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.onG = aVar;
    }
}
