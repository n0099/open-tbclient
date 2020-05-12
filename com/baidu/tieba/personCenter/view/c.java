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
    private BdTypeListView eOj;
    private NoNetworkView ePq;
    private PluginErrorTipView gAN;
    private NavigationBarShadowView iAj;
    private com.baidu.tieba.personCenter.b.c jUn;
    private com.baidu.tieba.view.d jUo;
    private View jUp;
    private FrameLayout jUq;
    private a jUr;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.iAj != null && i == 1) {
                c.this.iAj.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.iAj != null && childAt != null && childAt.getTop() == 0) {
                    c.this.iAj.hide();
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
            this.ePq = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.iAj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.gAN = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jUq = (FrameLayout) view.findViewById(R.id.layout_container);
            this.eOj = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.jUp = new View(tbPageContext.getPageActivity());
            this.jUp.setLayoutParams(layoutParams);
            this.eOj.addFooterView(this.jUp);
            this.eOj.setOnScrollListener(this.mOnScrollListener);
            this.jUn = new com.baidu.tieba.personCenter.b.c(this.eOj, tbPageContext, bdUniqueId);
            this.jUo = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.jUn.setData(fVar.cGk());
        }
    }

    public void notifyDataSetChanged() {
        this.jUn.notifyDataSetChanged();
    }

    public void aJ(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.jUo.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.jUo.deD();
        this.jUo.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bJt() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.jUr = aVar;
    }

    public void blq() {
        if (!bJt()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.blr();
                            if (c.this.jUr != null) {
                                c.this.jUr.cR(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.jUq, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void blr() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jUq);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jUp, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.eOj, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.jUn.onChangeSkinType();
            this.ePq.onChangeSkinType(this.mPageContext, i);
            this.gAN.onChangeSkinType(this.mPageContext, i);
            this.jUo.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.iAj, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.jUn != null) {
            this.jUn.cGg();
        }
    }

    public void V(int i, boolean z) {
        this.jUo.V(i, z);
    }

    public void cGf() {
        if (this.jUn != null) {
            this.jUn.cGf();
        }
    }

    public void cGg() {
        if (this.jUn != null) {
            this.jUn.cGg();
        }
    }
}
