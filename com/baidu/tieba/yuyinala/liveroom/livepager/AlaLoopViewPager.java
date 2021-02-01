package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hFB;
    ViewPager.OnPageChangeListener hFC;
    private ViewPager.OnPageChangeListener hFE;
    private AlaLoopPagerAdapterWrapper owh;
    private a owi;

    /* loaded from: classes11.dex */
    public interface a {
        boolean LX(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hFB = z;
        if (this.owh != null) {
            this.owh.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.owh = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.owh.setBoundaryCaching(this.hFB);
        super.setAdapter(this.owh);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.owh != null ? this.owh.cgC() : this.owh;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.owh != null) {
            return this.owh.vD(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.owh.vE(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hFC = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hFB = false;
        this.hFE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hFF = -1.0f;
            private float hFG = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vD = AlaLoopViewPager.this.owh.vD(i);
                if (this.hFG != vD) {
                    this.hFG = vD;
                    if (AlaLoopViewPager.this.hFC != null) {
                        AlaLoopViewPager.this.hFC.onPageSelected(vD);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.owh != null) {
                    int vD = AlaLoopViewPager.this.owh.vD(i);
                    if (f == 0.0f && this.hFF == 0.0f && (i == 0 || i == AlaLoopViewPager.this.owh.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                    i = vD;
                }
                this.hFF = f;
                if (AlaLoopViewPager.this.hFC != null) {
                    if (AlaLoopViewPager.this.owh != null && i != AlaLoopViewPager.this.owh.cgB() - 1) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.owh != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vD = AlaLoopViewPager.this.owh.vD(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.owh.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                }
                if (AlaLoopViewPager.this.hFC != null) {
                    AlaLoopViewPager.this.hFC.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFB = false;
        this.hFE = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hFF = -1.0f;
            private float hFG = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vD = AlaLoopViewPager.this.owh.vD(i);
                if (this.hFG != vD) {
                    this.hFG = vD;
                    if (AlaLoopViewPager.this.hFC != null) {
                        AlaLoopViewPager.this.hFC.onPageSelected(vD);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.owh != null) {
                    int vD = AlaLoopViewPager.this.owh.vD(i);
                    if (f == 0.0f && this.hFF == 0.0f && (i == 0 || i == AlaLoopViewPager.this.owh.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                    i = vD;
                }
                this.hFF = f;
                if (AlaLoopViewPager.this.hFC != null) {
                    if (AlaLoopViewPager.this.owh != null && i != AlaLoopViewPager.this.owh.cgB() - 1) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFC.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFC.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.owh != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vD = AlaLoopViewPager.this.owh.vD(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.owh.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                }
                if (AlaLoopViewPager.this.hFC != null) {
                    AlaLoopViewPager.this.hFC.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hFE);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.owi != null) {
            return this.owi.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean LX(int i) {
        if (this.owi != null) {
            return this.owi.LX(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.owi = aVar;
    }
}
