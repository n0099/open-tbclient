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
/* loaded from: classes16.dex */
public class c {
    private BdTypeListView frv;
    private NoNetworkView fsB;
    private PluginErrorTipView hhZ;
    private NavigationBarShadowView jpe;
    private com.baidu.tieba.personCenter.b.c kQe;
    private com.baidu.tieba.view.d kQf;
    private View kQg;
    private FrameLayout kQh;
    private a kQi;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.jpe != null && i == 1) {
                c.this.jpe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.jpe != null && childAt != null && childAt.getTop() == 0) {
                    c.this.jpe.hide();
                }
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void cZ(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.fsB = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.jpe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.hhZ = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.kQh = (FrameLayout) view.findViewById(R.id.layout_container);
            this.frv = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.kQg = new View(tbPageContext.getPageActivity());
            this.kQg.setLayoutParams(layoutParams);
            this.frv.addFooterView(this.kQg);
            this.frv.setOnScrollListener(this.mOnScrollListener);
            this.kQe = new com.baidu.tieba.personCenter.b.c(this.frv, tbPageContext, bdUniqueId);
            this.kQf = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.kQe.setData(fVar.cVG());
        }
    }

    public void notifyDataSetChanged() {
        this.kQe.notifyDataSetChanged();
    }

    public void aT(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.kQf.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.kQf.dtM();
        this.kQf.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bWj() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.kQi = aVar;
    }

    public void bwW() {
        if (!bWj()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.bwX();
                            if (c.this.kQi != null) {
                                c.this.kQi.cZ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.kQh, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void bwX() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.kQh);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ao.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ao.setBackgroundColor(this.kQg, R.color.cp_bg_line_d);
            ao.setBackgroundColor(this.frv, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ao.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.kQe.onChangeSkinType();
            this.fsB.onChangeSkinType(this.mPageContext, i);
            this.hhZ.onChangeSkinType(this.mPageContext, i);
            this.kQf.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ao.setBackgroundResource(this.jpe, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.kQe != null) {
            this.kQe.cVD();
        }
    }

    public void ab(int i, boolean z) {
        this.kQf.ab(i, z);
    }

    public void cVC() {
        if (this.kQe != null) {
            this.kQe.cVC();
        }
    }

    public void cVD() {
        if (this.kQe != null) {
            this.kQe.cVD();
        }
    }
}
