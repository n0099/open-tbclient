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
/* loaded from: classes2.dex */
public class c {
    private NoNetworkView gAh;
    private BdTypeListView gzb;
    private PluginErrorTipView iIC;
    private NavigationBarShadowView kQQ;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tieba.personCenter.b.c muI;
    private com.baidu.tieba.view.d muJ;
    private View muK;
    private FrameLayout muL;
    private a muM;
    private com.baidu.tbadk.l.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kQQ != null && i == 1) {
                c.this.kQQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kQQ != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kQQ.hide();
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dV(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.gAh = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kQQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.iIC = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.muL = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gzb = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.muK = new View(tbPageContext.getPageActivity());
            this.muK.setLayoutParams(layoutParams);
            this.gzb.addFooterView(this.muK);
            this.gzb.setOnScrollListener(this.mOnScrollListener);
            this.muI = new com.baidu.tieba.personCenter.b.c(this.gzb, tbPageContext, bdUniqueId);
            this.muJ = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.muI.setData(fVar.dwC());
        }
    }

    public void notifyDataSetChanged() {
        this.muI.notifyDataSetChanged();
    }

    public void bn(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.muJ.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.muJ.dWa();
        this.muJ.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cqM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.muM = aVar;
    }

    public void bRu() {
        if (!cqM()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.WZ();
                            if (c.this.muM != null) {
                                c.this.muM.dV(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.muL, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.muL);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.muK, R.color.CAM_X0201);
            ap.setBackgroundColor(this.gzb, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
            this.muI.onChangeSkinType();
            this.gAh.onChangeSkinType(this.mPageContext, i);
            this.iIC.onChangeSkinType(this.mPageContext, i);
            this.muJ.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kQQ, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.muI != null) {
            this.muI.dwz();
        }
    }

    public void ae(int i, boolean z) {
        this.muJ.ae(i, z);
    }

    public void dwy() {
        if (this.muI != null) {
            this.muI.dwy();
        }
    }

    public void dwz() {
        if (this.muI != null) {
            this.muI.dwz();
        }
    }
}
