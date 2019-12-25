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
/* loaded from: classes6.dex */
public class c {
    private BdTypeListView efM;
    private NoNetworkView egT;
    private PluginErrorTipView fPm;
    private NavigationBarShadowView hIX;
    private com.baidu.tieba.personCenter.b.c jdI;
    private com.baidu.tieba.view.d jdJ;
    private View jdK;
    private FrameLayout jdL;
    private a jdM;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.hIX != null && i == 1) {
                c.this.hIX.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.hIX != null && childAt != null && childAt.getTop() == 0) {
                    c.this.hIX.hide();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void cD(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.egT = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.hIX = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.fPm = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.jdL = (FrameLayout) view.findViewById(R.id.layout_container);
            this.efM = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.jdK = new View(tbPageContext.getPageActivity());
            this.jdK.setLayoutParams(layoutParams);
            this.efM.addFooterView(this.jdK);
            this.efM.setOnScrollListener(this.mOnScrollListener);
            this.jdI = new com.baidu.tieba.personCenter.b.c(this.efM, tbPageContext, bdUniqueId);
            this.jdJ = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.jdI.setData(fVar.csE());
        }
    }

    public void notifyDataSetChanged() {
        this.jdI.notifyDataSetChanged();
    }

    public void ao(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.jdJ.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.jdJ.cQU();
        this.jdJ.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bwF() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.jdM = aVar;
    }

    public void aZJ() {
        if (!bwF()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.aZK();
                            if (c.this.jdM != null) {
                                c.this.jdM.cD(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.jdL, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aZK() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.jdL);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.jdK, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.efM, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.jdI.onChangeSkinType();
            this.egT.onChangeSkinType(this.mPageContext, i);
            this.fPm.onChangeSkinType(this.mPageContext, i);
            this.jdJ.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.hIX, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.jdI != null) {
            this.jdI.csA();
        }
    }

    public void Q(int i, boolean z) {
        this.jdJ.Q(i, z);
    }

    public void csz() {
        if (this.jdI != null) {
            this.jdI.csz();
        }
    }

    public void csA() {
        if (this.jdI != null) {
            this.jdI.csA();
        }
    }
}
