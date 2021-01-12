package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes10.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hBr;
    ViewPager.OnPageChangeListener hBs;
    private ViewPager.OnPageChangeListener hBu;
    private AlaLoopPagerAdapterWrapper omo;
    private a omp;

    /* loaded from: classes10.dex */
    public interface a {
        boolean LC(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hBr = z;
        if (this.omo != null) {
            this.omo.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.omo = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.omo.setBoundaryCaching(this.hBr);
        super.setAdapter(this.omo);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.omo != null ? this.omo.cfJ() : this.omo;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.omo != null) {
            return this.omo.vs(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.omo.vt(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hBs = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hBr = false;
        this.hBu = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hBv = -1.0f;
            private float hBw = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vs = AlaLoopViewPager.this.omo.vs(i);
                if (this.hBw != vs) {
                    this.hBw = vs;
                    if (AlaLoopViewPager.this.hBs != null) {
                        AlaLoopViewPager.this.hBs.onPageSelected(vs);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.omo != null) {
                    int vs = AlaLoopViewPager.this.omo.vs(i);
                    if (f == 0.0f && this.hBv == 0.0f && (i == 0 || i == AlaLoopViewPager.this.omo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vs, false);
                    }
                    i = vs;
                }
                this.hBv = f;
                if (AlaLoopViewPager.this.hBs != null) {
                    if (AlaLoopViewPager.this.omo != null && i != AlaLoopViewPager.this.omo.cfI() - 1) {
                        AlaLoopViewPager.this.hBs.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hBs.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hBs.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.omo != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vs = AlaLoopViewPager.this.omo.vs(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.omo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vs, false);
                    }
                }
                if (AlaLoopViewPager.this.hBs != null) {
                    AlaLoopViewPager.this.hBs.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hBr = false;
        this.hBu = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hBv = -1.0f;
            private float hBw = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vs = AlaLoopViewPager.this.omo.vs(i);
                if (this.hBw != vs) {
                    this.hBw = vs;
                    if (AlaLoopViewPager.this.hBs != null) {
                        AlaLoopViewPager.this.hBs.onPageSelected(vs);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.omo != null) {
                    int vs = AlaLoopViewPager.this.omo.vs(i);
                    if (f == 0.0f && this.hBv == 0.0f && (i == 0 || i == AlaLoopViewPager.this.omo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vs, false);
                    }
                    i = vs;
                }
                this.hBv = f;
                if (AlaLoopViewPager.this.hBs != null) {
                    if (AlaLoopViewPager.this.omo != null && i != AlaLoopViewPager.this.omo.cfI() - 1) {
                        AlaLoopViewPager.this.hBs.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hBs.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hBs.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.omo != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vs = AlaLoopViewPager.this.omo.vs(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.omo.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vs, false);
                    }
                }
                if (AlaLoopViewPager.this.hBs != null) {
                    AlaLoopViewPager.this.hBs.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hBu);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.omp != null) {
            return this.omp.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean LC(int i) {
        if (this.omp != null) {
            return this.omp.LC(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.omp = aVar;
    }
}
