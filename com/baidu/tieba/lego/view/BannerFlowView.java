package com.baidu.tieba.lego.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.viewpager.b;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.l;
import com.baidu.tieba.lego.view.a;
import java.util.List;
/* loaded from: classes9.dex */
public class BannerFlowView extends FrameLayout {
    private IndicatorView foO;
    private ListViewPager lgg;
    private View lgh;
    private b lgi;
    private com.baidu.tieba.lego.view.a lgj;
    private a lgk;

    /* loaded from: classes9.dex */
    public interface a extends l {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.lgk = aVar;
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
        this.lgg.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.lgg.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.lgg.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.lgh != null) {
                if (z2) {
                    this.lgh.setVisibility(0);
                } else {
                    this.lgh.setVisibility(4);
                }
            }
            this.lgi.a((l) null);
            return;
        }
        if (this.lgh != null) {
            this.lgh.setVisibility(8);
        }
        this.lgi.a(new l() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.l
            public void aS(float f) {
                if (BannerFlowView.this.lgk != null) {
                    BannerFlowView.this.lgk.aS(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Ed(int i) {
                if (BannerFlowView.this.lgk != null) {
                    BannerFlowView.this.lgk.Ed(i);
                }
            }
        });
    }

    private void initView(Context context) {
        this.lgg = new ListViewPager(context);
        this.lgh = new View(context);
        this.foO = new IndicatorView(context);
        this.foO.setSpacing(0);
        bvD();
        this.lgi = new b(context, this.lgg, this.foO, null);
        this.lgj = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.fph);
        this.lgi.setAutoScrollIntervalTime(5000L);
        this.lgi.a(context, this.lgj);
        this.lgi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.lgk != null) {
                    BannerFlowView.this.lgk.onPageSelected(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.lgg, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.lgh, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds16));
        addView(this.foO, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.lgi.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.lgi.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.lgg.removeAllViews();
        this.lgi.setDatas(list);
    }

    private void bvD() {
        ap.setBackgroundResource(this.lgh, R.drawable.bg_pic_shadow);
        this.foO.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.foO.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0777a> aVar) {
        if (this.lgj != null) {
            this.lgj.setOnItemClickListener(aVar);
        }
    }

    public void setIndicatorViewPosition(int i) {
        if (this.foO != null) {
            switch (i) {
                case 0:
                    this.foO.setVisibility(8);
                    return;
                case 1:
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.foO.getLayoutParams();
                    layoutParams.gravity = 85;
                    this.foO.setLayoutParams(layoutParams);
                    this.foO.setVisibility(0);
                    return;
                case 2:
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.foO.getLayoutParams();
                    layoutParams2.gravity = 81;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.rightMargin = 0;
                    this.foO.setLayoutParams(layoutParams2);
                    this.foO.setVisibility(0);
                    return;
                default:
                    this.foO.setVisibility(8);
                    return;
            }
        }
    }
}
