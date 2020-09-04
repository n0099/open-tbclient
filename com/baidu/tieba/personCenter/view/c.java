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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView fCT;
    private NoNetworkView fDZ;
    private PluginErrorTipView hvf;
    private NavigationBarShadowView jEi;
    private com.baidu.tieba.personCenter.b.c lgb;
    private com.baidu.tieba.view.d lgc;
    private View lgd;
    private FrameLayout lge;
    private a lgf;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.jEi != null && i == 1) {
                c.this.jEi.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.jEi != null && childAt != null && childAt.getTop() == 0) {
                    c.this.jEi.hide();
                }
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void dd(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.fDZ = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.jEi = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.hvf = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lge = (FrameLayout) view.findViewById(R.id.layout_container);
            this.fCT = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.lgd = new View(tbPageContext.getPageActivity());
            this.lgd.setLayoutParams(layoutParams);
            this.fCT.addFooterView(this.lgd);
            this.fCT.setOnScrollListener(this.mOnScrollListener);
            this.lgb = new com.baidu.tieba.personCenter.b.c(this.fCT, tbPageContext, bdUniqueId);
            this.lgc = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.lgb.setData(fVar.dgE());
        }
    }

    public void notifyDataSetChanged() {
        this.lgb.notifyDataSetChanged();
    }

    public void aQ(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.lgc.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.lgc.dFq();
        this.lgc.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cgx() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.lgf = aVar;
    }

    public void bFW() {
        if (!cgx()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.bFX();
                            if (c.this.lgf != null) {
                                c.this.lgf.dd(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.lge, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void bFX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lge);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.lgd, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.fCT, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.lgb.onChangeSkinType();
            this.fDZ.onChangeSkinType(this.mPageContext, i);
            this.hvf.onChangeSkinType(this.mPageContext, i);
            this.lgc.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.jEi, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.lgb != null) {
            this.lgb.dgB();
        }
    }

    public void ad(int i, boolean z) {
        this.lgc.ad(i, z);
    }

    public void dgA() {
        if (this.lgb != null) {
            this.lgb.dgA();
        }
    }

    public void dgB() {
        if (this.lgb != null) {
            this.lgb.dgB();
        }
    }
}
