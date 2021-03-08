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
    private BdTypeListView gAY;
    private NoNetworkView gCe;
    private PluginErrorTipView iKz;
    private NavigationBarShadowView kTg;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tieba.personCenter.b.c mwZ;
    private com.baidu.tieba.view.d mxa;
    private View mxb;
    private FrameLayout mxc;
    private a mxd;
    private com.baidu.tbadk.l.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kTg != null && i == 1) {
                c.this.kTg.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kTg != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kTg.hide();
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
            this.gCe = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kTg = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.iKz = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mxc = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gAY = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.mxb = new View(tbPageContext.getPageActivity());
            this.mxb.setLayoutParams(layoutParams);
            this.gAY.addFooterView(this.mxb);
            this.gAY.setOnScrollListener(this.mOnScrollListener);
            this.mwZ = new com.baidu.tieba.personCenter.b.c(this.gAY, tbPageContext, bdUniqueId);
            this.mxa = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.mwZ.setData(fVar.dwS());
        }
    }

    public void notifyDataSetChanged() {
        this.mwZ.notifyDataSetChanged();
    }

    public void bn(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.mxa.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.mxa.dWq();
        this.mxa.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cqZ() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.mxd = aVar;
    }

    public void bRH() {
        if (!cqZ()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.Xc();
                            if (c.this.mxd != null) {
                                c.this.mxd.dV(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.mxc, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Xc() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mxc);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mxb, R.color.CAM_X0201);
            ap.setBackgroundColor(this.gAY, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
            this.mwZ.onChangeSkinType();
            this.gCe.onChangeSkinType(this.mPageContext, i);
            this.iKz.onChangeSkinType(this.mPageContext, i);
            this.mxa.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kTg, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.mwZ != null) {
            this.mwZ.dwP();
        }
    }

    public void ae(int i, boolean z) {
        this.mxa.ae(i, z);
    }

    public void dwO() {
        if (this.mwZ != null) {
            this.mwZ.dwO();
        }
    }

    public void dwP() {
        if (this.mwZ != null) {
            this.mwZ.dwP();
        }
    }
}
