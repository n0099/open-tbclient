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
/* loaded from: classes9.dex */
public class BannerFlowView extends FrameLayout {
    private IndicatorView frg;
    private ListViewPager lcJ;
    private View lcK;
    private b lcL;
    private com.baidu.tieba.lego.view.a lcM;
    private a lcN;

    /* loaded from: classes9.dex */
    public interface a extends l {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.lcN = aVar;
    }

    public BannerFlowView(Context context) {
        super(context);
        eO(context);
    }

    public BannerFlowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        eO(context);
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.lcJ.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.lcJ.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.lcJ.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.lcK != null) {
                if (z2) {
                    this.lcK.setVisibility(0);
                } else {
                    this.lcK.setVisibility(4);
                }
            }
            this.lcL.a((l) null);
            return;
        }
        if (this.lcK != null) {
            this.lcK.setVisibility(8);
        }
        this.lcL.a(new l() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.l
            public void aP(float f) {
                if (BannerFlowView.this.lcN != null) {
                    BannerFlowView.this.lcN.aP(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Fr(int i) {
                if (BannerFlowView.this.lcN != null) {
                    BannerFlowView.this.lcN.Fr(i);
                }
            }
        });
    }

    private void eO(Context context) {
        this.lcJ = new ListViewPager(context);
        this.lcK = new View(context);
        this.frg = new IndicatorView(context);
        this.frg.setSpacing(0);
        bzd();
        this.lcL = new b(context, this.lcJ, this.frg, null);
        this.lcM = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.frA);
        this.lcL.setAutoScrollIntervalTime(5000L);
        this.lcL.a(context, this.lcM);
        this.lcL.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.lcN != null) {
                    BannerFlowView.this.lcN.onPageSelected(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.lcJ, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.lcK, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds16));
        addView(this.frg, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.lcL.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.lcL.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.lcJ.removeAllViews();
        this.lcL.setDatas(list);
    }

    private void bzd() {
        ao.setBackgroundResource(this.lcK, R.drawable.bg_pic_shadow);
        this.frg.setSelector(ao.getDrawable(R.drawable.icon_diandian_white_s));
        this.frg.setDrawable(ao.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0792a> aVar) {
        if (this.lcM != null) {
            this.lcM.setOnItemClickListener(aVar);
        }
    }

    public void setIndicatorViewPosition(int i) {
        if (this.frg != null) {
            switch (i) {
                case 0:
                    this.frg.setVisibility(8);
                    return;
                case 1:
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.frg.getLayoutParams();
                    layoutParams.gravity = 85;
                    this.frg.setLayoutParams(layoutParams);
                    this.frg.setVisibility(0);
                    return;
                case 2:
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.frg.getLayoutParams();
                    layoutParams2.gravity = 81;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.rightMargin = 0;
                    this.frg.setLayoutParams(layoutParams2);
                    this.frg.setVisibility(0);
                    return;
                default:
                    this.frg.setVisibility(8);
                    return;
            }
        }
    }
}
