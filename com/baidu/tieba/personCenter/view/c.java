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
    private BdTypeListView fbb;
    private NoNetworkView fci;
    private PluginErrorTipView gPH;
    private NavigationBarShadowView iPD;
    private com.baidu.tieba.personCenter.b.c knl;
    private com.baidu.tieba.view.d knm;
    private View knn;
    private FrameLayout kno;
    private a knp;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.iPD != null && i == 1) {
                c.this.iPD.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.iPD != null && childAt != null && childAt.getTop() == 0) {
                    c.this.iPD.hide();
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cS(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.fci = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.iPD = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.gPH = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.kno = (FrameLayout) view.findViewById(R.id.layout_container);
            this.fbb = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.knn = new View(tbPageContext.getPageActivity());
            this.knn.setLayoutParams(layoutParams);
            this.fbb.addFooterView(this.knn);
            this.fbb.setOnScrollListener(this.mOnScrollListener);
            this.knl = new com.baidu.tieba.personCenter.b.c(this.fbb, tbPageContext, bdUniqueId);
            this.knm = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.knl.setData(fVar.cNz());
        }
    }

    public void notifyDataSetChanged() {
        this.knl.notifyDataSetChanged();
    }

    public void aO(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.knm.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.knm.dmi();
        this.knm.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bPO() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.knp = aVar;
    }

    public void bqP() {
        if (!bPO()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.bqQ();
                            if (c.this.knp != null) {
                                c.this.knp.cS(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.kno, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void bqQ() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.kno);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.knn, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.fbb, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.knl.onChangeSkinType();
            this.fci.onChangeSkinType(this.mPageContext, i);
            this.gPH.onChangeSkinType(this.mPageContext, i);
            this.knm.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.iPD, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.knl != null) {
            this.knl.cNv();
        }
    }

    public void Z(int i, boolean z) {
        this.knm.Z(i, z);
    }

    public void cNu() {
        if (this.knl != null) {
            this.knl.cNu();
        }
    }

    public void cNv() {
        if (this.knl != null) {
            this.knl.cNv();
        }
    }
}
