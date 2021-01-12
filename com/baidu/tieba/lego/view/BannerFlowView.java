package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.l;
import com.baidu.tieba.lego.view.a;
import java.util.List;
/* loaded from: classes8.dex */
public class BannerFlowView extends FrameLayout {
    private IndicatorView fmw;
    private ListViewPager kYc;
    private View kYd;
    private b kYe;
    private com.baidu.tieba.lego.view.a kYf;
    private a kYg;

    /* loaded from: classes8.dex */
    public interface a extends l {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.kYg = aVar;
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
        this.kYc.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.kYc.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.kYc.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.kYd != null) {
                if (z2) {
                    this.kYd.setVisibility(0);
                } else {
                    this.kYd.setVisibility(4);
                }
            }
            this.kYe.a((l) null);
            return;
        }
        if (this.kYd != null) {
            this.kYd.setVisibility(8);
        }
        this.kYe.a(new l() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.l
            public void aP(float f) {
                if (BannerFlowView.this.kYg != null) {
                    BannerFlowView.this.kYg.aP(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void DL(int i) {
                if (BannerFlowView.this.kYg != null) {
                    BannerFlowView.this.kYg.DL(i);
                }
            }
        });
    }

    private void initView(Context context) {
        this.kYc = new ListViewPager(context);
        this.kYd = new View(context);
        this.fmw = new IndicatorView(context);
        this.fmw.setSpacing(0);
        bvj();
        this.kYe = new b(context, this.kYc, this.fmw, null);
        this.kYf = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.fmP);
        this.kYe.setAutoScrollIntervalTime(5000L);
        this.kYe.a(context, this.kYf);
        this.kYe.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.kYg != null) {
                    BannerFlowView.this.kYg.onPageSelected(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.kYc, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.kYd, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds16));
        addView(this.fmw, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.kYe.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.kYe.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.kYc.removeAllViews();
        this.kYe.setDatas(list);
    }

    private void bvj() {
        ao.setBackgroundResource(this.kYd, R.drawable.bg_pic_shadow);
        this.fmw.setSelector(ao.getDrawable(R.drawable.icon_diandian_white_s));
        this.fmw.setDrawable(ao.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0775a> aVar) {
        if (this.kYf != null) {
            this.kYf.setOnItemClickListener(aVar);
        }
    }

    public void setIndicatorViewPosition(int i) {
        if (this.fmw != null) {
            switch (i) {
                case 0:
                    this.fmw.setVisibility(8);
                    return;
                case 1:
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fmw.getLayoutParams();
                    layoutParams.gravity = 85;
                    this.fmw.setLayoutParams(layoutParams);
                    this.fmw.setVisibility(0);
                    return;
                case 2:
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fmw.getLayoutParams();
                    layoutParams2.gravity = 81;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.rightMargin = 0;
                    this.fmw.setLayoutParams(layoutParams2);
                    this.fmw.setVisibility(0);
                    return;
                default:
                    this.fmw.setVisibility(8);
                    return;
            }
        }
    }
}
