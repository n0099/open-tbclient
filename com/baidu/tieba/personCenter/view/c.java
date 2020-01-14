package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.h;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c {
    private BdTypeListView efW;
    private NoNetworkView ehd;
    private PluginErrorTipView fSv;
    private NavigationBarShadowView hMA;
    private com.baidu.tieba.personCenter.b.c jhp;
    private com.baidu.tieba.view.d jhq;
    private View jhr;
    private FrameLayout jhs;
    private a jht;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.hMA != null && i == 1) {
                c.this.hMA.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.hMA != null && childAt != null && childAt.getTop() == 0) {
                    c.this.hMA.hide();
                }
            }
        }
    };

    /* loaded from: classes7.dex */
    public interface a {
        void cI(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.ehd = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.hMA = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.fSv = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jhs = (FrameLayout) view.findViewById(R.id.layout_container);
            this.efW = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.jhr = new View(tbPageContext.getPageActivity());
            this.jhr.setLayoutParams(layoutParams);
            this.efW.addFooterView(this.jhr);
            this.efW.setOnScrollListener(this.mOnScrollListener);
            this.jhp = new com.baidu.tieba.personCenter.b.c(this.efW, tbPageContext, bdUniqueId);
            this.jhq = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.jhp.setData(fVar.ctN());
        }
    }

    public void notifyDataSetChanged() {
        this.jhp.notifyDataSetChanged();
    }

    public void as(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.jhq.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.jhq.cRZ();
        this.jhq.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bxH() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.jht = aVar;
    }

    public void bae() {
        if (!bxH()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.baf();
                            if (c.this.jht != null) {
                                c.this.jht.cI(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.jhs, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void baf() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jhs);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jhr, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.efW, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.jhp.onChangeSkinType();
            this.ehd.onChangeSkinType(this.mPageContext, i);
            this.fSv.onChangeSkinType(this.mPageContext, i);
            this.jhq.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.hMA, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.jhp != null) {
            this.jhp.ctJ();
        }
    }

    public void Q(int i, boolean z) {
        this.jhq.Q(i, z);
    }

    public void ctI() {
        if (this.jhp != null) {
            this.jhp.ctI();
        }
    }

    public void ctJ() {
        if (this.jhp != null) {
            this.jhp.ctJ();
        }
    }
}
