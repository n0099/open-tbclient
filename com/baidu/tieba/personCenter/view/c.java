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
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView eOe;
    private NoNetworkView ePl;
    private PluginErrorTipView gAH;
    private NavigationBarShadowView iAd;
    private com.baidu.tieba.personCenter.b.c jUj;
    private com.baidu.tieba.view.d jUk;
    private View jUl;
    private FrameLayout jUm;
    private a jUn;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.iAd != null && i == 1) {
                c.this.iAd.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.iAd != null && childAt != null && childAt.getTop() == 0) {
                    c.this.iAd.hide();
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cR(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.ePl = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.iAd = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.gAH = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jUm = (FrameLayout) view.findViewById(R.id.layout_container);
            this.eOe = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.jUl = new View(tbPageContext.getPageActivity());
            this.jUl.setLayoutParams(layoutParams);
            this.eOe.addFooterView(this.jUl);
            this.eOe.setOnScrollListener(this.mOnScrollListener);
            this.jUj = new com.baidu.tieba.personCenter.b.c(this.eOe, tbPageContext, bdUniqueId);
            this.jUk = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.jUj.setData(fVar.cGm());
        }
    }

    public void notifyDataSetChanged() {
        this.jUj.notifyDataSetChanged();
    }

    public void aJ(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.jUk.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.jUk.deF();
        this.jUk.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bJu() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.jUn = aVar;
    }

    public void bls() {
        if (!bJu()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.blt();
                            if (c.this.jUn != null) {
                                c.this.jUn.cR(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.jUm, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void blt() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jUm);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jUl, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.eOe, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.jUj.onChangeSkinType();
            this.ePl.onChangeSkinType(this.mPageContext, i);
            this.gAH.onChangeSkinType(this.mPageContext, i);
            this.jUk.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.iAd, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.jUj != null) {
            this.jUj.cGi();
        }
    }

    public void V(int i, boolean z) {
        this.jUk.V(i, z);
    }

    public void cGh() {
        if (this.jUj != null) {
            this.jUj.cGh();
        }
    }

    public void cGi() {
        if (this.jUj != null) {
            this.jUj.cGi();
        }
    }
}
