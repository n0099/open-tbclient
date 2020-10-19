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
    private BdTypeListView fSo;
    private NoNetworkView fTu;
    private PluginErrorTipView hRf;
    private NavigationBarShadowView kbI;
    private com.baidu.tieba.personCenter.b.c lEk;
    private com.baidu.tieba.view.d lEl;
    private View lEm;
    private FrameLayout lEn;
    private a lEo;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private com.baidu.tbadk.k.h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.kbI != null && i == 1) {
                c.this.kbI.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.kbI != null && childAt != null && childAt.getTop() == 0) {
                    c.this.kbI.hide();
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void dp(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.fTu = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.kbI = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.hRf = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.lEn = (FrameLayout) view.findViewById(R.id.layout_container);
            this.fSo = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.lEm = new View(tbPageContext.getPageActivity());
            this.lEm.setLayoutParams(layoutParams);
            this.fSo.addFooterView(this.lEm);
            this.fSo.setOnScrollListener(this.mOnScrollListener);
            this.lEk = new com.baidu.tieba.personCenter.b.c(this.fSo, tbPageContext, bdUniqueId);
            this.lEl = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.lEk.setData(fVar.dnT());
        }
    }

    public void notifyDataSetChanged() {
        this.lEk.notifyDataSetChanged();
    }

    public void bb(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.lEl.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.lEl.dMW();
        this.lEl.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean chb() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.lEo = aVar;
    }

    public void bJY() {
        if (!chb()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.SK();
                            if (c.this.lEo != null) {
                                c.this.lEo.dp(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.lEn, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void SK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.lEn);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setViewTextColor(this.mTitle, R.color.cp_cont_b);
            ap.setBackgroundColor(this.lEm, R.color.cp_bg_line_d);
            ap.setBackgroundColor(this.fSo, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            ap.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.lEk.onChangeSkinType();
            this.fTu.onChangeSkinType(this.mPageContext, i);
            this.hRf.onChangeSkinType(this.mPageContext, i);
            this.lEl.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            ap.setBackgroundResource(this.kbI, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.lEk != null) {
            this.lEk.dnQ();
        }
    }

    public void ag(int i, boolean z) {
        this.lEl.ag(i, z);
    }

    public void dnP() {
        if (this.lEk != null) {
            this.lEk.dnP();
        }
    }

    public void dnQ() {
        if (this.lEk != null) {
            this.lEk.dnQ();
        }
    }
}
