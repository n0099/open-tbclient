package com.baidu.tieba.yuyinala.liveroom.livepager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
/* loaded from: classes4.dex */
public class AlaLoopViewPager extends AlaVerticalViewPagerNew {
    private boolean huc;
    ViewPager.OnPageChangeListener hud;
    private ViewPager.OnPageChangeListener huf;
    private AlaLoopPagerAdapterWrapper onH;
    private a onI;

    /* loaded from: classes4.dex */
    public interface a {
        boolean Nw(int i);

        boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent);
    }

    public void setBoundaryCaching(boolean z) {
        this.huc = z;
        if (this.onH != null) {
            this.onH.setBoundaryCaching(z);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setAdapter(PagerAdapter pagerAdapter) {
        this.onH = new AlaLoopPagerAdapterWrapper(pagerAdapter);
        this.onH.setBoundaryCaching(this.huc);
        super.setAdapter(this.onH);
        setCurrentItem(0, false);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public PagerAdapter getAdapter() {
        return this.onH != null ? this.onH.cgM() : this.onH;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public int getCurrentItem() {
        if (this.onH != null) {
            return this.onH.wN(super.getCurrentItem());
        }
        return 0;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(this.onH.wO(i), z);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setCurrentItem(int i) {
        if (getCurrentItem() != i) {
            setCurrentItem(i, true);
        }
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.hud = onPageChangeListener;
    }

    public AlaLoopViewPager(Context context) {
        super(context);
        this.huc = false;
        this.huf = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hug = -1.0f;
            private float huh = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.onH.wN(i);
                if (this.huh != wN) {
                    this.huh = wN;
                    if (AlaLoopViewPager.this.hud != null) {
                        AlaLoopViewPager.this.hud.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.onH != null) {
                    int wN = AlaLoopViewPager.this.onH.wN(i);
                    if (f == 0.0f && this.hug == 0.0f && (i == 0 || i == AlaLoopViewPager.this.onH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hug = f;
                if (AlaLoopViewPager.this.hud != null) {
                    if (AlaLoopViewPager.this.onH != null && i != AlaLoopViewPager.this.onH.cgL() - 1) {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hud.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.onH != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.onH.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.onH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hud != null) {
                    AlaLoopViewPager.this.hud.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    public AlaLoopViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huc = false;
        this.huf = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.yuyinala.liveroom.livepager.AlaLoopViewPager.1
            private float hug = -1.0f;
            private float huh = -1.0f;

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                int wN = AlaLoopViewPager.this.onH.wN(i);
                if (this.huh != wN) {
                    this.huh = wN;
                    if (AlaLoopViewPager.this.hud != null) {
                        AlaLoopViewPager.this.hud.onPageSelected(wN);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                if (AlaLoopViewPager.this.onH != null) {
                    int wN = AlaLoopViewPager.this.onH.wN(i);
                    if (f == 0.0f && this.hug == 0.0f && (i == 0 || i == AlaLoopViewPager.this.onH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                    i = wN;
                }
                this.hug = f;
                if (AlaLoopViewPager.this.hud != null) {
                    if (AlaLoopViewPager.this.onH != null && i != AlaLoopViewPager.this.onH.cgL() - 1) {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, f, i2);
                    } else if (f > 0.5d) {
                        AlaLoopViewPager.this.hud.onPageScrolled(0, 0.0f, 0);
                    } else {
                        AlaLoopViewPager.this.hud.onPageScrolled(i, 0.0f, 0);
                    }
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                if (AlaLoopViewPager.this.onH != null) {
                    int currentItem = AlaLoopViewPager.super.getCurrentItem();
                    int wN = AlaLoopViewPager.this.onH.wN(currentItem);
                    if (i == 0 && (currentItem == 0 || currentItem == AlaLoopViewPager.this.onH.getCount() - 1)) {
                        AlaLoopViewPager.this.setCurrentItem(wN, false);
                    }
                }
                if (AlaLoopViewPager.this.hud != null) {
                    AlaLoopViewPager.this.hud.onPageScrollStateChanged(i);
                }
            }
        };
        init();
    }

    private void init() {
        super.setOnPageChangeListener(this.huf);
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean a(AlaVerticalViewPagerNew alaVerticalViewPagerNew, MotionEvent motionEvent) {
        if (this.onI != null) {
            return this.onI.a(alaVerticalViewPagerNew, motionEvent);
        }
        return true;
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.livepager.AlaVerticalViewPagerNew
    public boolean Nw(int i) {
        if (this.onI != null) {
            return this.onI.Nw(i);
        }
        return true;
    }

    public void setListener(a aVar) {
        this.onI = aVar;
    }
}
