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
    private BdTypeListView faQ;
    private NoNetworkView fbX;
    private PluginErrorTipView gPw;
    private NavigationBarShadowView iOQ;
    private com.baidu.tieba.personCenter.b.c kmf;
    private com.baidu.tieba.view.d kmg;
    private View kmh;
    private FrameLayout kmi;
    private a kmj;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private TextView mTitle;
    private h refreshView;
    private int mSkinType = 3;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.personCenter.view.c.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (c.this.iOQ != null && i == 1) {
                c.this.iOQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (c.this.iOQ != null && childAt != null && childAt.getTop() == 0) {
                    c.this.iOQ.hide();
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
            this.fbX = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.iOQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_person_center);
            this.gPw = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.kmi = (FrameLayout) view.findViewById(R.id.layout_container);
            this.faQ = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.kmh = new View(tbPageContext.getPageActivity());
            this.kmh.setLayoutParams(layoutParams);
            this.faQ.addFooterView(this.kmh);
            this.faQ.setOnScrollListener(this.mOnScrollListener);
            this.kmf = new com.baidu.tieba.personCenter.b.c(this.faQ, tbPageContext, bdUniqueId);
            this.kmg = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.f fVar) {
        if (fVar != null) {
            this.kmf.setData(fVar.cNj());
        }
    }

    public void notifyDataSetChanged() {
        this.kmf.notifyDataSetChanged();
    }

    public void aO(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.kmg.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        this.kmg.dlT();
        this.kmg.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bPM() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.kmj = aVar;
    }

    public void bqN() {
        if (!bPM()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.bqO();
                            if (c.this.kmj != null) {
                                c.this.kmj.cS(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.attachView(this.kmi, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void bqO() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.kmi);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.kmh, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.faQ, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.kmf.onChangeSkinType();
            this.fbX.onChangeSkinType(this.mPageContext, i);
            this.gPw.onChangeSkinType(this.mPageContext, i);
            this.kmg.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            am.setBackgroundResource(this.iOQ, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.kmf != null) {
            this.kmf.cNf();
        }
    }

    public void Z(int i, boolean z) {
        this.kmg.Z(i, z);
    }

    public void cNe() {
        if (this.kmf != null) {
            this.kmf.cNe();
        }
    }

    public void cNf() {
        if (this.kmf != null) {
            this.kmf.cNf();
        }
    }
}
