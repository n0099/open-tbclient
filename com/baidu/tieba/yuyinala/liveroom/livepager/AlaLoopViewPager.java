package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes11.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hFP;
    ViewPager.OnPageChangeListener hFQ;
    private ViewPager.OnPageChangeListener hFS;
    private AlaLoopPagerAdapterWrapper owH;
    private a owI;

    /* loaded from: classes11.dex */
    public interface a {
        boolean LY(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hFP = z;
        if (this.owH != null) {
            this.owH.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.owH = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.owH.setBoundaryCaching(this.hFP);
        super.setAdapter(this.owH);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.owH != null ? this.owH.cgJ() : this.owH;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.owH != null) {
            return this.owH.vD(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.owH.vE(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hFQ = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hFP = false;
        this.hFS = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hFT = -1.0f;
            private float hFU = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vD = AlaLoopViewPager.this.owH.vD(i);
                if (this.hFU != vD) {
                    this.hFU = vD;
                    if (AlaLoopViewPager.this.hFQ != null) {
                        AlaLoopViewPager.this.hFQ.onPageSelected(vD);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.owH != null) {
                    int vD = AlaLoopViewPager.this.owH.vD(i);
                    if (f == 0.0f && this.hFT == 0.0f && (i == 0 || i == AlaLoopViewPager.this.owH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                    i = vD;
                }
                this.hFT = f;
                if (AlaLoopViewPager.this.hFQ != null) {
                    if (AlaLoopViewPager.this.owH != null && i != AlaLoopViewPager.this.owH.cgI() - 1) {
                        AlaLoopViewPager.this.hFQ.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFQ.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFQ.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.owH != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vD = AlaLoopViewPager.this.owH.vD(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.owH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                }
                if (AlaLoopViewPager.this.hFQ != null) {
                    AlaLoopViewPager.this.hFQ.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hFP = false;
        this.hFS = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hFT = -1.0f;
            private float hFU = -1.0f;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vD = AlaLoopViewPager.this.owH.vD(i);
                if (this.hFU != vD) {
                    this.hFU = vD;
                    if (AlaLoopViewPager.this.hFQ != null) {
                        AlaLoopViewPager.this.hFQ.onPageSelected(vD);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.owH != null) {
                    int vD = AlaLoopViewPager.this.owH.vD(i);
                    if (f == 0.0f && this.hFT == 0.0f && (i == 0 || i == AlaLoopViewPager.this.owH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                    i = vD;
                }
                this.hFT = f;
                if (AlaLoopViewPager.this.hFQ != null) {
                    if (AlaLoopViewPager.this.owH != null && i != AlaLoopViewPager.this.owH.cgI() - 1) {
                        AlaLoopViewPager.this.hFQ.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hFQ.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hFQ.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.owH != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vD = AlaLoopViewPager.this.owH.vD(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.owH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vD, false);
                    }
                }
                if (AlaLoopViewPager.this.hFQ != null) {
                    AlaLoopViewPager.this.hFQ.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hFS);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.owI != null) {
            return this.owI.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean LY(int i) {
        if (this.owI != null) {
            return this.owI.LY(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.owI = aVar;
    }
}
