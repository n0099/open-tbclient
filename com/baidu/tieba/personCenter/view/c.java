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
    private BdTypeListView gih;
    private NoNetworkView gjn;
    private PluginErrorTipView ijD;
    private NavigationBarShadowView kud;
    private com.baidu.tieba.personCenter.b.c lWC;
    private com.baidu.tieba.view.d lWD;
    private View lWE;
    private FrameLayout lWF;
    private a lWG;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kud != null && i == 1) {
                c.this.kud.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kud != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kud.hide();
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dy(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.gjn = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kud = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.ijD = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lWF = (FrameLayout) view.findViewById(R.id.layout_container);
            this.gih = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.lWE = new View(tbPageContext.getPageActivity());
            this.lWE.setLayoutParams(layoutParams);
            this.gih.addFooterView(this.lWE);
            this.gih.setOnScrollListener(this.mOnScrollListener);
            this.lWC = new com.baidu.tieba.personCenter.b.c(this.gih, tbPageContext, bdUniqueId);
            this.lWD = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.lWC.setData(fVar.dtC());
        }
    }

    public void notifyDataSetChanged() {
        this.lWC.notifyDataSetChanged();
    }

    public void bh(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.lWD.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.lWD.dSG();
        this.lWD.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cmK() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.lWG = aVar;
    }

    public void bPa() {
        if (!cmK()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.Wk();
                            if (c.this.lWG != null) {
                                c.this.lWG.dy(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.lWF, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Wk() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lWF);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.lWE, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.gih, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.lWC.onChangeSkinType();
            this.gjn.onChangeSkinType(this.mPageContext, i);
            this.ijD.onChangeSkinType(this.mPageContext, i);
            this.lWD.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kud, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.lWC != null) {
            this.lWC.dtz();
        }
    }

    public void ag(int i, boolean z) {
        this.lWD.ag(i, z);
    }

    public void dty() {
        if (this.lWC != null) {
            this.lWC.dty();
        }
    }

    public void dtz() {
        if (this.lWC != null) {
            this.lWC.dtz();
        }
    }
}
