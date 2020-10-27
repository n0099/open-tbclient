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
/* loaded from: classes22.dex */
public class c {
    private BdTypeListView gcr;
    private NoNetworkView gdx;
    private PluginErrorTipView idG;
    private NavigationBarShadowView koh;
    private com.baidu.tieba.personCenter.b.c lQG;
    private com.baidu.tieba.view.d lQH;
    private View lQI;
    private FrameLayout lQJ;
    private a lQK;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.koh != null && i == 1) {
                c.this.koh.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.koh != null && childAt != null && childAt.getTop() == 0) {
                    c.this.koh.hide();
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dt(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.gdx = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.koh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.idG = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lQJ = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gcr = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.lQI = new View(tbPageContext.getPageActivity());
            this.lQI.setLayoutParams(layoutParams);
            this.gcr.addFooterView(this.lQI);
            this.gcr.setOnScrollListener(this.mOnScrollListener);
            this.lQG = new com.baidu.tieba.personCenter.b.c(this.gcr, tbPageContext, bdUniqueId);
            this.lQH = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.lQG.setData(fVar.dra());
        }
    }

    public void notifyDataSetChanged() {
        this.lQG.notifyDataSetChanged();
    }

    public void bd(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.lQH.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.lQH.dQe();
        this.lQH.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cki() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.lQK = aVar;
    }

    public void bMA() {
        if (!cki()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.TK();
                            if (c.this.lQK != null) {
                                c.this.lQK.dt(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.lQJ, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void TK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lQJ);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.lQI, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.gcr, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.lQG.onChangeSkinType();
            this.gdx.onChangeSkinType(this.mPageContext, i);
            this.idG.onChangeSkinType(this.mPageContext, i);
            this.lQH.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.koh, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.lQG != null) {
            this.lQG.dqX();
        }
    }

    public void ag(int i, boolean z) {
        this.lQH.ag(i, z);
    }

    public void dqW() {
        if (this.lQG != null) {
            this.lQG.dqW();
        }
    }

    public void dqX() {
        if (this.lQG != null) {
            this.lQG.dqX();
        }
    }
}
