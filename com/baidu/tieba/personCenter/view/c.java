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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    private BdTypeListView fml;
    private NoNetworkView fns;
    private PluginErrorTipView hcq;
    private NavigationBarShadowView jgG;
    private com.baidu.tieba.personCenter.b.c kHc;
    private com.baidu.tieba.view.d kHd;
    private View kHe;
    private FrameLayout kHf;
    private a kHg;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.jgG != null && i == 1) {
                c.this.jgG.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.jgG != null && childAt != null && childAt.getTop() == 0) {
                    c.this.jgG.hide();
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cT(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.fns = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.jgG = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.hcq = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.kHf = (FrameLayout) view.findViewById(R.id.layout_container);
            this.fml = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.kHe = new View(tbPageContext.getPageActivity());
            this.kHe.setLayoutParams(layoutParams);
            this.fml.addFooterView(this.kHe);
            this.fml.setOnScrollListener(this.mOnScrollListener);
            this.kHc = new com.baidu.tieba.personCenter.b.c(this.fml, tbPageContext, bdUniqueId);
            this.kHd = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.kHc.setData(fVar.cRQ());
        }
    }

    public void notifyDataSetChanged() {
        this.kHc.notifyDataSetChanged();
    }

    public void aR(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.kHd.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.kHd.dqz();
        this.kHd.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bSS() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.kHg = aVar;
    }

    public void btN() {
        if (!bSS()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.btO();
                            if (c.this.kHg != null) {
                                c.this.kHg.cT(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.kHf, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void btO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.kHf);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            an.setBackgroundColor(this.kHe, R.color.cp_bg_line_d);
            an.setBackgroundColor(this.fml, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            an.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.kHc.onChangeSkinType();
            this.fns.onChangeSkinType(this.mPageContext, i);
            this.hcq.onChangeSkinType(this.mPageContext, i);
            this.kHd.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            an.setBackgroundResource(this.jgG, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.kHc != null) {
            this.kHc.cRN();
        }
    }

    public void ac(int i, boolean z) {
        this.kHd.ac(i, z);
    }

    public void cRM() {
        if (this.kHc != null) {
            this.kHc.cRM();
        }
    }

    public void cRN() {
        if (this.kHc != null) {
            this.kHc.cRN();
        }
    }
}
