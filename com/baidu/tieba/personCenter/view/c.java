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
/* loaded from: classes21.dex */
public class c {
    private BdTypeListView fGf;
    private NoNetworkView fHl;
    private PluginErrorTipView hCk;
    private NavigationBarShadowView jMK;
    private com.baidu.tieba.personCenter.b.c loX;
    private com.baidu.tieba.view.d loY;
    private View loZ;
    private FrameLayout lpa;
    private a lpb;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.jMK != null && i == 1) {
                c.this.jMK.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.jMK != null && childAt != null && childAt.getTop() == 0) {
                    c.this.jMK.hide();
                }
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void dl(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.fHl = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.jMK = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.hCk = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lpa = (FrameLayout) view.findViewById(R.id.layout_container);
            this.fGf = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.loZ = new View(tbPageContext.getPageActivity());
            this.loZ.setLayoutParams(layoutParams);
            this.fGf.addFooterView(this.loZ);
            this.fGf.setOnScrollListener(this.mOnScrollListener);
            this.loX = new com.baidu.tieba.personCenter.b.c(this.fGf, tbPageContext, bdUniqueId);
            this.loY = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.loX.setData(fVar.dkj());
        }
    }

    public void notifyDataSetChanged() {
        this.loX.notifyDataSetChanged();
    }

    public void aR(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.loY.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.loY.dJk();
        this.loY.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean cdF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.lpb = aVar;
    }

    public void bHm() {
        if (!cdF()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.bHn();
                            if (c.this.lpb != null) {
                                c.this.lpb.dl(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.lpa, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void bHn() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lpa);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.loZ, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.fGf, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.loX.onChangeSkinType();
            this.fHl.onChangeSkinType(this.mPageContext, i);
            this.hCk.onChangeSkinType(this.mPageContext, i);
            this.loY.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.jMK, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.loX != null) {
            this.loX.dkg();
        }
    }

    public void ae(int i, boolean z) {
        this.loY.ae(i, z);
    }

    public void dkf() {
        if (this.loX != null) {
            this.loX.dkf();
        }
    }

    public void dkg() {
        if (this.loX != null) {
            this.loX.dkg();
        }
    }
}
