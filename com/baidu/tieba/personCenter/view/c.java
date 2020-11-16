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
/* loaded from: classes21.dex */
public class c {
    private BdTypeListView ghN;
    private NoNetworkView giU;
    private PluginErrorTipView ikr;
    private NavigationBarShadowView kuN;
    private com.baidu.tieba.personCenter.b.c lWU;
    private com.baidu.tieba.view.d lWV;
    private View lWW;
    private FrameLayout lWX;
    private a lWY;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kuN != null && i == 1) {
                c.this.kuN.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kuN != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kuN.hide();
                }
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void dC(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.giU = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kuN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.ikr = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lWX = (FrameLayout) view.findViewById(R.id.layout_container);
            this.ghN = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.lWW = new View(tbPageContext.getPageActivity());
            this.lWW.setLayoutParams(layoutParams);
            this.ghN.addFooterView(this.lWW);
            this.ghN.setOnScrollListener(this.mOnScrollListener);
            this.lWU = new com.baidu.tieba.personCenter.b.c(this.ghN, tbPageContext, bdUniqueId);
            this.lWV = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.lWU.setData(fVar.dtc());
        }
    }

    public void notifyDataSetChanged() {
        this.lWU.notifyDataSetChanged();
    }

    public void bf(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.lWV.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.lWV.dSF();
        this.lWV.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cmm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.lWY = aVar;
    }

    public void bOt() {
        if (!cmm()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.VB();
                            if (c.this.lWY != null) {
                                c.this.lWY.dC(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.lWX, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void VB() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lWX);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.lWW, R.color.CAM_X0201);
            ap.setBackgroundColor(this.ghN, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
            this.lWU.onChangeSkinType();
            this.giU.onChangeSkinType(this.mPageContext, i);
            this.ikr.onChangeSkinType(this.mPageContext, i);
            this.lWV.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kuN, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.lWU != null) {
            this.lWU.dsZ();
        }
    }

    public void ag(int i, boolean z) {
        this.lWV.ag(i, z);
    }

    public void dsY() {
        if (this.lWU != null) {
            this.lWU.dsY();
        }
    }

    public void dsZ() {
        if (this.lWU != null) {
            this.lWU.dsZ();
        }
    }
}
