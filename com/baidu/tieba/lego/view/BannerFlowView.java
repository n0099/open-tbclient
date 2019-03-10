package com.baidu.tieba.lego.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.viewpager.c;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.j;
import com.baidu.tieba.lego.view.a;
import java.util.List;
/* loaded from: classes2.dex */
public class BannerFlowView extends FrameLayout {
    private IndicatorView bUP;
    private View gLA;
    private b gLB;
    private com.baidu.tieba.lego.view.a gLC;
    private a gLD;
    private ListViewPager gLz;

    /* loaded from: classes2.dex */
    public interface a extends j {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.gLD = aVar;
    }

    public BannerFlowView(Context context) {
        super(context);
        initView(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.gLz.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.gLz.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.gLz.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.gLA != null) {
                if (z2) {
                    this.gLA.setVisibility(0);
                } else {
                    this.gLA.setVisibility(4);
                }
            }
            this.gLB.a((j) null);
            return;
        }
        if (this.gLA != null) {
            this.gLA.setVisibility(8);
        }
        this.gLB.a(new j() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.j
            public void aI(float f) {
                if (BannerFlowView.this.gLD != null) {
                    BannerFlowView.this.gLD.aI(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.j
            public void uY(int i) {
                if (BannerFlowView.this.gLD != null) {
                    BannerFlowView.this.gLD.uY(i);
                }
            }
        });
    }

    private void initView(Context context) {
        this.gLz = new ListViewPager(context);
        this.gLA = new View(context);
        this.bUP = new IndicatorView(context);
        this.bUP.setSpacing(0);
        aft();
        this.gLB = new b(context, this.gLz, this.bUP, null);
        this.gLC = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.bVj);
        this.gLB.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.gLB.a(context, this.gLC);
        this.gLB.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.gLD != null) {
                    BannerFlowView.this.gLD.onPageSelected(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.gLz, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(context, d.e.ds80));
        layoutParams.gravity = 80;
        addView(this.gLA, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, l.h(context, d.e.ds20), l.h(context, d.e.ds16));
        addView(this.bUP, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.gLB.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.gLB.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.gLz.removeAllViews();
        this.gLB.setDatas(list);
    }

    private void aft() {
        al.k(this.gLA, d.f.bg_pic_shadow);
        this.bUP.setSelector(al.getDrawable(d.f.icon_diandian_white_s));
        this.bUP.setDrawable(al.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0270a> aVar) {
        if (this.gLC != null) {
            this.gLC.setOnItemClickListener(aVar);
        }
    }

    public void setIndicatorViewPosition(int i) {
        if (this.bUP != null) {
            switch (i) {
                case 0:
                    this.bUP.setVisibility(8);
                    return;
                case 1:
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.bUP.getLayoutParams();
                    layoutParams.gravity = 85;
                    this.bUP.setLayoutParams(layoutParams);
                    this.bUP.setVisibility(0);
                    return;
                case 2:
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bUP.getLayoutParams();
                    layoutParams2.gravity = 81;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.rightMargin = 0;
                    this.bUP.setLayoutParams(layoutParams2);
                    this.bUP.setVisibility(0);
                    return;
                default:
                    this.bUP.setVisibility(8);
                    return;
            }
        }
    }
}
