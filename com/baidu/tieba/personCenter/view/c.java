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
    private NoNetworkView gAv;
    private BdTypeListView gzp;
    private PluginErrorTipView iIQ;
    private NavigationBarShadowView kRe;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tieba.personCenter.b.c muX;
    private com.baidu.tieba.view.d muY;
    private View muZ;
    private FrameLayout mva;
    private a mvb;
    private com.baidu.tbadk.l.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kRe != null && i == 1) {
                c.this.kRe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kRe != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kRe.hide();
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
            this.gAv = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kRe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.iIQ = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mva = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gzp = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.muZ = new View(tbPageContext.getPageActivity());
            this.muZ.setLayoutParams(layoutParams);
            this.gzp.addFooterView(this.muZ);
            this.gzp.setOnScrollListener(this.mOnScrollListener);
            this.muX = new com.baidu.tieba.personCenter.b.c(this.gzp, tbPageContext, bdUniqueId);
            this.muY = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.muX.setData(fVar.dwJ());
        }
    }

    public void notifyDataSetChanged() {
        this.muX.notifyDataSetChanged();
    }

    public void bn(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.muY.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.muY.dWi();
        this.muY.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cqT() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.mvb = aVar;
    }

    public void bRB() {
        if (!cqT()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.WZ();
                            if (c.this.mvb != null) {
                                c.this.mvb.dV(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.mva, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void WZ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mva);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.muZ, R.color.CAM_X0201);
            ap.setBackgroundColor(this.gzp, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
            this.muX.onChangeSkinType();
            this.gAv.onChangeSkinType(this.mPageContext, i);
            this.iIQ.onChangeSkinType(this.mPageContext, i);
            this.muY.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kRe, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.muX != null) {
            this.muX.dwG();
        }
    }

    public void ae(int i, boolean z) {
        this.muY.ae(i, z);
    }

    public void dwF() {
        if (this.muX != null) {
            this.muX.dwF();
        }
    }

    public void dwG() {
        if (this.muX != null) {
            this.muX.dwG();
        }
    }
}
