package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean heZ;
    ViewPager.OnPageChangeListener hfa;
    private ViewPager.OnPageChangeListener hfc;
    private AlaLoopPagerAdapterWrapper nPT;
    private a nPU;

    /* loaded from: classes4.dex */
    public interface a {
        boolean LJ(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.heZ = z;
        if (this.nPT != null) {
            this.nPT.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.nPT = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.nPT.setBoundaryCaching(this.heZ);
        super.setAdapter(this.nPT);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.nPT != null ? this.nPT.caZ() : this.nPT;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.nPT != null) {
            return this.nPT.vx(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.nPT.vy(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hfa = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.heZ = false;
        this.hfc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hfd = -1.0f;
            private float hfe = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vx = AlaLoopViewPager.this.nPT.vx(i);
                if (this.hfe != vx) {
                    this.hfe = vx;
                    if (AlaLoopViewPager.this.hfa != null) {
                        AlaLoopViewPager.this.hfa.onPageSelected(vx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.nPT != null) {
                    int vx = AlaLoopViewPager.this.nPT.vx(i);
                    if (f == 0.0f && this.hfd == 0.0f && (i == 0 || i == AlaLoopViewPager.this.nPT.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                    i = vx;
                }
                this.hfd = f;
                if (AlaLoopViewPager.this.hfa != null) {
                    if (AlaLoopViewPager.this.nPT != null && i != AlaLoopViewPager.this.nPT.caY() - 1) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.nPT != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vx = AlaLoopViewPager.this.nPT.vx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.nPT.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                }
                if (AlaLoopViewPager.this.hfa != null) {
                    AlaLoopViewPager.this.hfa.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.heZ = false;
        this.hfc = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hfd = -1.0f;
            private float hfe = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vx = AlaLoopViewPager.this.nPT.vx(i);
                if (this.hfe != vx) {
                    this.hfe = vx;
                    if (AlaLoopViewPager.this.hfa != null) {
                        AlaLoopViewPager.this.hfa.onPageSelected(vx);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.nPT != null) {
                    int vx = AlaLoopViewPager.this.nPT.vx(i);
                    if (f == 0.0f && this.hfd == 0.0f && (i == 0 || i == AlaLoopViewPager.this.nPT.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                    i = vx;
                }
                this.hfd = f;
                if (AlaLoopViewPager.this.hfa != null) {
                    if (AlaLoopViewPager.this.nPT != null && i != AlaLoopViewPager.this.nPT.caY() - 1) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hfa.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hfa.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.nPT != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vx = AlaLoopViewPager.this.nPT.vx(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.nPT.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vx, false);
                    }
                }
                if (AlaLoopViewPager.this.hfa != null) {
                    AlaLoopViewPager.this.hfa.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hfc);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.nPU != null) {
            return this.nPU.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean LJ(int i) {
        if (this.nPU != null) {
            return this.nPU.LJ(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.nPU = aVar;
    }
}
