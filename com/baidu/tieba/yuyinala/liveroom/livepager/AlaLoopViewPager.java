package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean hkV;
    ViewPager.OnPageChangeListener hkW;
    private ViewPager.OnPageChangeListener hkY;
    private AlaLoopPagerAdapterWrapper nXc;
    private a nXd;

    /* loaded from: classes4.dex */
    public interface a {
        boolean Mb(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.hkV = z;
        if (this.nXc != null) {
            this.nXc.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.nXc = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.nXc.setBoundaryCaching(this.hkV);
        super.setAdapter(this.nXc);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.nXc != null ? this.nXc.cdA() : this.nXc;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.nXc != null) {
            return this.nXc.vK(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.nXc.vL(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hkW = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.hkV = false;
        this.hkY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hkZ = -1.0f;
            private float hla = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vK = AlaLoopViewPager.this.nXc.vK(i);
                if (this.hla != vK) {
                    this.hla = vK;
                    if (AlaLoopViewPager.this.hkW != null) {
                        AlaLoopViewPager.this.hkW.onPageSelected(vK);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.nXc != null) {
                    int vK = AlaLoopViewPager.this.nXc.vK(i);
                    if (f == 0.0f && this.hkZ == 0.0f && (i == 0 || i == AlaLoopViewPager.this.nXc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vK, false);
                    }
                    i = vK;
                }
                this.hkZ = f;
                if (AlaLoopViewPager.this.hkW != null) {
                    if (AlaLoopViewPager.this.nXc != null && i != AlaLoopViewPager.this.nXc.cdz() - 1) {
                        AlaLoopViewPager.this.hkW.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hkW.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hkW.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.nXc != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vK = AlaLoopViewPager.this.nXc.vK(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.nXc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vK, false);
                    }
                }
                if (AlaLoopViewPager.this.hkW != null) {
                    AlaLoopViewPager.this.hkW.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkV = false;
        this.hkY = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hkZ = -1.0f;
            private float hla = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int vK = AlaLoopViewPager.this.nXc.vK(i);
                if (this.hla != vK) {
                    this.hla = vK;
                    if (AlaLoopViewPager.this.hkW != null) {
                        AlaLoopViewPager.this.hkW.onPageSelected(vK);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.nXc != null) {
                    int vK = AlaLoopViewPager.this.nXc.vK(i);
                    if (f == 0.0f && this.hkZ == 0.0f && (i == 0 || i == AlaLoopViewPager.this.nXc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vK, false);
                    }
                    i = vK;
                }
                this.hkZ = f;
                if (AlaLoopViewPager.this.hkW != null) {
                    if (AlaLoopViewPager.this.nXc != null && i != AlaLoopViewPager.this.nXc.cdz() - 1) {
                        AlaLoopViewPager.this.hkW.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hkW.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hkW.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.nXc != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int vK = AlaLoopViewPager.this.nXc.vK(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.nXc.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(vK, false);
                    }
                }
                if (AlaLoopViewPager.this.hkW != null) {
                    AlaLoopViewPager.this.hkW.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.hkY);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.nXd != null) {
            return this.nXd.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean Mb(int i) {
        if (this.nXd != null) {
            return this.nXd.Mb(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.nXd = aVar;
    }
}
