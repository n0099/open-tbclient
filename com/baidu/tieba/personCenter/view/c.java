package com.baidu.tieba.personCenter.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {
    private BdTypeListView dvB;
    private NoNetworkView dwI;
    private PluginErrorTipView fbx;
    private com.baidu.tieba.personCenter.b.c imE;
    private com.baidu.tieba.view.d imF;
    private View imG;
    private FrameLayout imH;
    private a imI;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cH(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dwI = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.fbx = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.imH = (FrameLayout) view.findViewById(R.id.layout_container);
            this.dvB = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.imG = new View(tbPageContext.getPageActivity());
            this.imG.setLayoutParams(layoutParams);
            this.dvB.addFooterView(this.imG);
            this.imE = new com.baidu.tieba.personCenter.b.c(this.dvB, tbPageContext, bdUniqueId);
            this.imF = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.imE.b(fVar);
            if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.CLICKED_BLUE_TIP, false) || fVar.getUserData() == null || fVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.imE.notifyDataSetChanged();
    }

    public void aa(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.imF.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(R.dimen.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(R.dimen.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.imF.caF();
        this.imF.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bfm() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.imI = aVar;
    }

    public void aJn() {
        if (!bfm()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.isNetworkAvailableForImmediately()) {
                            c.this.aJo();
                            if (c.this.imI != null) {
                                c.this.imI.cH(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.setLayoutMargin(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.setSubText(this.mPageContext.getString(R.string.neterror));
            this.refreshView.attachView(this.imH, false);
            this.refreshView.showRefreshButton();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aJo() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.imH);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
            am.setBackgroundColor(this.imG, R.color.cp_bg_line_d);
            am.setBackgroundColor(this.dvB, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.imE.onChangeSkinType();
            this.dwI.onChangeSkinType(this.mPageContext, i);
            this.fbx.onChangeSkinType(this.mPageContext, i);
            this.imF.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.imE != null) {
            this.imE.bZk();
        }
    }

    public void O(int i, boolean z) {
        this.imF.O(i, z);
    }

    public void bZj() {
        if (this.imE != null) {
            this.imE.bZj();
        }
    }

    public void bZk() {
        if (this.imE != null) {
            this.imE.bZk();
        }
    }
}
