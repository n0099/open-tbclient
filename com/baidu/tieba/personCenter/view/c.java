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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c {
    private BdTypeListView gwr;
    private NoNetworkView gxx;
    private PluginErrorTipView iCS;
    private NavigationBarShadowView kIN;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tieba.personCenter.b.c mlH;
    private com.baidu.tieba.view.d mlI;
    private View mlJ;
    private FrameLayout mlK;
    private a mlL;
    private com.baidu.tbadk.l.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kIN != null && i == 1) {
                c.this.kIN.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kIN != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kIN.hide();
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void dX(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.gxx = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kIN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.iCS = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mlK = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gwr = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.mlJ = new View(tbPageContext.getPageActivity());
            this.mlJ.setLayoutParams(layoutParams);
            this.gwr.addFooterView(this.mlJ);
            this.gwr.setOnScrollListener(this.mOnScrollListener);
            this.mlH = new com.baidu.tieba.personCenter.b.c(this.gwr, tbPageContext, bdUniqueId);
            this.mlI = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.mlH.setData(fVar.dut());
        }
    }

    public void notifyDataSetChanged() {
        this.mlH.notifyDataSetChanged();
    }

    public void bi(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.mlI.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.mlI.dTM();
        this.mlI.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cpC() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.mlL = aVar;
    }

    public void bQQ() {
        if (!cpC()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.Vq();
                            if (c.this.mlL != null) {
                                c.this.mlL.dX(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.mlK, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Vq() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mlK);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ao.setBackgroundColor(this.mlJ, R.color.CAM_X0201);
            ao.setBackgroundColor(this.gwr, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
            this.mlH.onChangeSkinType();
            this.gxx.onChangeSkinType(this.mPageContext, i);
            this.iCS.onChangeSkinType(this.mPageContext, i);
            this.mlI.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ao.setBackgroundResource(this.kIN, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.mlH != null) {
            this.mlH.duq();
        }
    }

    public void ae(int i, boolean z) {
        this.mlI.ae(i, z);
    }

    public void dup() {
        if (this.mlH != null) {
            this.mlH.dup();
        }
    }

    public void duq() {
        if (this.mlH != null) {
            this.mlH.duq();
        }
    }
}
