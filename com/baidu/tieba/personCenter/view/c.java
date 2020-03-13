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
    private BdTypeListView eko;
    private NoNetworkView elv;
    private PluginErrorTipView fVe;
    private NavigationBarShadowView hOM;
    private FrameLayout jiA;
    private a jiB;
    private com.baidu.tieba.personCenter.b.c jix;
    private com.baidu.tieba.view.d jiy;
    private View jiz;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.hOM != null && i == 1) {
                c.this.hOM.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.hOM != null && childAt != null && childAt.getTop() == 0) {
                    c.this.hOM.hide();
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void cJ(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.elv = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.hOM = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.fVe = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jiA = (FrameLayout) view.findViewById(R.id.layout_container);
            this.eko = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.jiz = new View(tbPageContext.getPageActivity());
            this.jiz.setLayoutParams(layoutParams);
            this.eko.addFooterView(this.jiz);
            this.eko.setOnScrollListener(this.mOnScrollListener);
            this.jix = new com.baidu.tieba.personCenter.b.c(this.eko, tbPageContext, bdUniqueId);
            this.jiy = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.jix.setData(fVar.cvj());
        }
    }

    public void notifyDataSetChanged() {
        this.jix.notifyDataSetChanged();
    }

    public void au(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.jiy.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.jiy.cTx();
        this.jiy.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bzm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.jiB = aVar;
    }

    public void bcx() {
        if (!bzm()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.bcy();
                            if (c.this.jiB != null) {
                                c.this.jiB.cJ(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.jiA, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void bcy() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jiA);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jiz, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.eko, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.jix.onChangeSkinType();
            this.elv.onChangeSkinType(this.mPageContext, i);
            this.fVe.onChangeSkinType(this.mPageContext, i);
            this.jiy.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.hOM, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.jix != null) {
            this.jix.cvf();
        }
    }

    public void P(int i, boolean z) {
        this.jiy.P(i, z);
    }

    public void cve() {
        if (this.jix != null) {
            this.jix.cve();
        }
    }

    public void cvf() {
        if (this.jix != null) {
            this.jix.cvf();
        }
    }
}
