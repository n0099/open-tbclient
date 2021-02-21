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
    private ListViewPager lgu;
    private View lgv;
    private b lgw;
    private com.baidu.tieba.lego.view.a lgx;
    private a lgy;

    /* loaded from: classes9.dex */
    public interface a extends l {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.lgy = aVar;
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
        this.lgu.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.lgu.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.lgu.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.lgv != null) {
                if (z2) {
                    this.lgv.setVisibility(0);
                } else {
                    this.lgv.setVisibility(4);
                }
            }
            this.lgw.a((l) null);
            return;
        }
        if (this.lgv != null) {
            this.lgv.setVisibility(8);
        }
        this.lgw.a(new l() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.l
            public void aS(float f) {
                if (BannerFlowView.this.lgy != null) {
                    BannerFlowView.this.lgy.aS(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Ed(int i) {
                if (BannerFlowView.this.lgy != null) {
                    BannerFlowView.this.lgy.Ed(i);
                }
            }
        });
    }

    private void initView(Context context) {
        this.lgu = new ListViewPager(context);
        this.lgv = new View(context);
        this.foO = new IndicatorView(context);
        this.foO.setSpacing(0);
        bvD();
        this.lgw = new b(context, this.lgu, this.foO, null);
        this.lgx = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.fph);
        this.lgw.setAutoScrollIntervalTime(5000L);
        this.lgw.a(context, this.lgx);
        this.lgw.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.lgy != null) {
                    BannerFlowView.this.lgy.onPageSelected(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.lgu, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.lgv, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds16));
        addView(this.foO, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.lgw.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.lgw.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.lgu.removeAllViews();
        this.lgw.setDatas(list);
    }

    private void bvD() {
        ap.setBackgroundResource(this.lgv, R.drawable.bg_pic_shadow);
        this.foO.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.foO.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0778a> aVar) {
        if (this.lgx != null) {
            this.lgx.setOnItemClickListener(aVar);
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
