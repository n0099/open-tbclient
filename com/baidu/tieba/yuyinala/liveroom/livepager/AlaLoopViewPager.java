package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hFX;
    ViewPager.OnPageChangeListener hFY;
    private ViewPager.OnPageChangeListener hGa;
    private AlaLoopPagerAdapterWrapper oqV;
    private a oqW;

    /* loaded from: classes11.dex */
    public interface a {
        boolean Nj(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hFX = z;
        if (this.oqV != null) {
            this.oqV.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.oqV = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.oqV.setBoundaryCaching(this.hFX);
        super.setAdapter(this.oqV);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.oqV != null ? this.oqV.cjB() : this.oqV;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.oqV != null) {
            return this.oqV.wY(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.oqV.wZ(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hFY = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hFX = false;
        this.hGa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hGb = -1.0f;
            private float hGc = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wY = AlaLoopViewPager.this.oqV.wY(i);
                if (this.hGc != wY) {
                    this.hGc = wY;
                    if (AlaLoopViewPager.this.hFY != null) {
                        AlaLoopViewPager.this.hFY.onPageSelected(wY);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.oqV != null) {
                    int wY = AlaLoopViewPager.this.oqV.wY(i);
                    if (f == 0.0f && this.hGb == 0.0f && (i == 0 || i == AlaLoopViewPager.this.oqV.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                    i = wY;
                }
                this.hGb = f;
                if (AlaLoopViewPager.this.hFY != null) {
                    if (AlaLoopViewPager.this.oqV != null && i != AlaLoopViewPager.this.oqV.cjA() - 1) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.oqV != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wY = AlaLoopViewPager.this.oqV.wY(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.oqV.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                }
                if (AlaLoopViewPager.this.hFY != null) {
                    AlaLoopViewPager.this.hFY.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFX = false;
        this.hGa = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hGb = -1.0f;
            private float hGc = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wY = AlaLoopViewPager.this.oqV.wY(i);
                if (this.hGc != wY) {
                    this.hGc = wY;
                    if (AlaLoopViewPager.this.hFY != null) {
                        AlaLoopViewPager.this.hFY.onPageSelected(wY);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.oqV != null) {
                    int wY = AlaLoopViewPager.this.oqV.wY(i);
                    if (f == 0.0f && this.hGb == 0.0f && (i == 0 || i == AlaLoopViewPager.this.oqV.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                    i = wY;
                }
                this.hGb = f;
                if (AlaLoopViewPager.this.hFY != null) {
                    if (AlaLoopViewPager.this.oqV != null && i != AlaLoopViewPager.this.oqV.cjA() - 1) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFY.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFY.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.oqV != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wY = AlaLoopViewPager.this.oqV.wY(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.oqV.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wY, false);
                    }
                }
                if (AlaLoopViewPager.this.hFY != null) {
                    AlaLoopViewPager.this.hFY.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hGa);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.oqW != null) {
            return this.oqW.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean Nj(int i) {
        if (this.oqW != null) {
            return this.oqW.Nj(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.oqW = aVar;
    }
}
