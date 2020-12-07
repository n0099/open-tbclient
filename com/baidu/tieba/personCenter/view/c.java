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
    private BdTypeListView gpX;
    private NoNetworkView grd;
    private PluginErrorTipView ivk;
    private NavigationBarShadowView kIh;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tieba.personCenter.b.c mlc;
    private com.baidu.tieba.view.d mld;
    private View mle;
    private FrameLayout mlf;
    private a mlg;
    private com.baidu.tbadk.l.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kIh != null && i == 1) {
                c.this.kIh.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kIh != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kIh.hide();
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dN(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.grd = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kIh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.ivk = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.mlf = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gpX = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.mle = new View(tbPageContext.getPageActivity());
            this.mle.setLayoutParams(layoutParams);
            this.gpX.addFooterView(this.mle);
            this.gpX.setOnScrollListener(this.mOnScrollListener);
            this.mlc = new com.baidu.tieba.personCenter.b.c(this.gpX, tbPageContext, bdUniqueId);
            this.mld = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.mlc.setData(fVar.dyu());
        }
    }

    public void notifyDataSetChanged() {
        this.mlc.notifyDataSetChanged();
    }

    public void bf(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.mld.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.mld.dXZ();
        this.mld.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cqz() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.mlg = aVar;
    }

    public void bSe() {
        if (!cqz()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.l.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.Yb();
                            if (c.this.mlg != null) {
                                c.this.mlg.dN(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.mlf, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Yb() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.mlf);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
            ap.setBackgroundColor(this.mle, R.color.CAM_X0201);
            ap.setBackgroundColor(this.gpX, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.CAM_X0207, i);
            this.mlc.onChangeSkinType();
            this.grd.onChangeSkinType(this.mPageContext, i);
            this.ivk.onChangeSkinType(this.mPageContext, i);
            this.mld.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kIh, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.mlc != null) {
            this.mlc.dyr();
        }
    }

    public void ag(int i, boolean z) {
        this.mld.ag(i, z);
    }

    public void dyq() {
        if (this.mlc != null) {
            this.mlc.dyq();
        }
    }

    public void dyr() {
        if (this.mlc != null) {
            this.mlc.dyr();
        }
    }
}
