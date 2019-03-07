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
    private b gLA;
    private com.baidu.tieba.lego.view.a gLB;
    private a gLC;
    private ListViewPager gLy;
    private View gLz;

    /* loaded from: classes2.dex */
    public interface a extends j {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.gLC = aVar;
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
        this.gLy.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.gLy.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.gLy.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.gLz != null) {
                if (z2) {
                    this.gLz.setVisibility(0);
                } else {
                    this.gLz.setVisibility(4);
                }
            }
            this.gLA.a((j) null);
            return;
        }
        if (this.gLz != null) {
            this.gLz.setVisibility(8);
        }
        this.gLA.a(new j() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.j
            public void aI(float f) {
                if (BannerFlowView.this.gLC != null) {
                    BannerFlowView.this.gLC.aI(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.j
            public void uY(int i) {
                if (BannerFlowView.this.gLC != null) {
                    BannerFlowView.this.gLC.uY(i);
                }
            }
        });
    }

    private void initView(Context context) {
        this.gLy = new ListViewPager(context);
        this.gLz = new View(context);
        this.bUP = new IndicatorView(context);
        this.bUP.setSpacing(0);
        aft();
        this.gLA = new b(context, this.gLy, this.bUP, null);
        this.gLB = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.bVj);
        this.gLA.setAutoScrollIntervalTime(TbConfig.NOTIFY_SOUND_INTERVAL);
        this.gLA.a(context, this.gLB);
        this.gLA.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.gLC != null) {
                    BannerFlowView.this.gLC.onPageSelected(i);
                }
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.gLy, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(context, d.e.ds80));
        layoutParams.gravity = 80;
        addView(this.gLz, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, l.h(context, d.e.ds20), l.h(context, d.e.ds16));
        addView(this.bUP, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.gLA.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.gLA.setMaxScrollCountLimit(i);
    }

    public void setData(List<m> list) {
        this.gLy.removeAllViews();
        this.gLA.setDatas(list);
    }

    private void aft() {
        al.k(this.gLz, d.f.bg_pic_shadow);
        this.bUP.setSelector(al.getDrawable(d.f.icon_diandian_white_s));
        this.bUP.setDrawable(al.getDrawable(d.f.icon_diandian_white_n));
    }

    public void setOnItemClickListener(c.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0270a> aVar) {
        if (this.gLB != null) {
            this.gLB.setOnItemClickListener(aVar);
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
