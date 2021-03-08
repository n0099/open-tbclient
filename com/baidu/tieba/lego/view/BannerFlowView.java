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
/* loaded from: classes8.dex */
public class BannerFlowView extends FrameLayout {
    private IndicatorView fqo;
    private a liA;
    private ListViewPager liw;
    private View lix;
    private b liy;
    private com.baidu.tieba.lego.view.a liz;

    /* loaded from: classes8.dex */
    public interface a extends l {
        void onPageSelected(int i);
    }

    public void setOnPageSelected(a aVar) {
        this.liA = aVar;
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
        this.liw.setSwipeControlInterface(cVar);
        if (cVar != null) {
            this.liw.setDisableParentEvent(false);
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.liw.setDisableParentEvent(z);
    }

    public void setDescOnPic(boolean z, boolean z2) {
        if (z) {
            if (this.lix != null) {
                if (z2) {
                    this.lix.setVisibility(0);
                } else {
                    this.lix.setVisibility(4);
                }
            }
            this.liy.a((l) null);
            return;
        }
        if (this.lix != null) {
            this.lix.setVisibility(8);
        }
        this.liy.a(new l() { // from class: com.baidu.tieba.lego.view.BannerFlowView.1
            @Override // com.baidu.tieba.lego.card.view.l
            public void aW(float f) {
                if (BannerFlowView.this.liA != null) {
                    BannerFlowView.this.liA.aW(f);
                }
            }

            @Override // com.baidu.tieba.lego.card.view.l
            public void Eg(int i) {
                if (BannerFlowView.this.liA != null) {
                    BannerFlowView.this.liA.Eg(i);
                }
            }
        });
    }

    private void initView(Context context) {
        this.liw = new ListViewPager(context);
        this.lix = new View(context);
        this.fqo = new IndicatorView(context);
        this.fqo.setSpacing(0);
        bvG();
        this.liy = new b(context, this.liw, this.fqo, null);
        this.liz = new com.baidu.tieba.lego.view.a(context, com.baidu.tbadk.core.view.viewpager.bannerflow.a.fqH);
        this.liy.setAutoScrollIntervalTime(5000L);
        this.liy.a(context, this.liz);
        this.liy.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.lego.view.BannerFlowView.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (BannerFlowView.this.liA != null) {
                    BannerFlowView.this.liA.onPageSelected(i);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        addView(this.liw, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds80));
        layoutParams.gravity = 80;
        addView(this.lix, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 85;
        layoutParams2.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds16));
        addView(this.fqo, layoutParams2);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.liy.setAutoScrollIntervalTime(j);
    }

    public void setMaxScrollCountLimit(int i) {
        this.liy.setMaxScrollCountLimit(i);
    }

    public void setData(List<n> list) {
        this.liw.removeAllViews();
        this.liy.setDatas(list);
    }

    private void bvG() {
        ap.setBackgroundResource(this.lix, R.drawable.bg_pic_shadow);
        this.fqo.setSelector(ap.getDrawable(R.drawable.icon_diandian_white_s));
        this.fqo.setDrawable(ap.getDrawable(R.drawable.icon_diandian_white_n));
    }

    public void setOnItemClickListener(b.a<com.baidu.tbadk.core.view.viewpager.bannerflow.a, a.C0784a> aVar) {
        if (this.liz != null) {
            this.liz.setOnItemClickListener(aVar);
        }
    }

    public void setIndicatorViewPosition(int i) {
        if (this.fqo != null) {
            switch (i) {
                case 0:
                    this.fqo.setVisibility(8);
                    return;
                case 1:
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fqo.getLayoutParams();
                    layoutParams.gravity = 85;
                    this.fqo.setLayoutParams(layoutParams);
                    this.fqo.setVisibility(0);
                    return;
                case 2:
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fqo.getLayoutParams();
                    layoutParams2.gravity = 81;
                    layoutParams2.rightMargin = 0;
                    layoutParams2.rightMargin = 0;
                    this.fqo.setLayoutParams(layoutParams2);
                    this.fqo.setVisibility(0);
                    return;
                default:
                    this.fqo.setVisibility(8);
                    return;
            }
        }
    }
}
