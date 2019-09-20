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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.m.h;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c {
    private NoNetworkView dpy;
    private PluginErrorTipView eYM;
    private com.baidu.tieba.personCenter.b.c inV;
    private com.baidu.tieba.view.d inW;
    private View inX;
    private FrameLayout inY;
    private a inZ;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private h refreshView;

    /* loaded from: classes4.dex */
    public interface a {
        void cL(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.dpy = (NoNetworkView) view.findViewById(R.id.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(R.id.person_center_navigation_bar);
            this.eYM = (PluginErrorTipView) view.findViewById(R.id.person_center_plugin_error_tip_view);
            this.inY = (FrameLayout) view.findViewById(R.id.layout_container);
            this.mListView = (BdTypeListView) view.findViewById(R.id.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.ds200));
            this.inX = new View(tbPageContext.getPageActivity());
            this.inX.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.inX);
            this.inV = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.inW = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.f fVar) {
        if (fVar != null) {
            this.inV.b(fVar);
            if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("clicked_blue_tip", false) || fVar.getUserData() == null || fVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.inV.notifyDataSetChanged();
    }

    public void V(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.mine));
        this.inW.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.inW.cdE();
        this.inW.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean bhs() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.inZ = aVar;
    }

    public void aJM() {
        if (!bhs()) {
            if (this.refreshView == null) {
                this.refreshView = new h(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.jQ()) {
                            c.this.aJN();
                            if (c.this.inZ != null) {
                                c.this.inZ.cL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.kO(this.mPageContext.getResources().getDimensionPixelSize(R.dimen.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.qY(this.mPageContext.getString(R.string.neterror));
            this.refreshView.attachView(this.inY, false);
            this.refreshView.atW();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aJN() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.inY);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.mTitle, R.color.cp_cont_b);
            am.l(this.inX, R.color.cp_bg_line_d);
            am.l(this.mListView, R.color.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            am.h(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h, i);
            this.inV.onChangeSkinType();
            this.dpy.onChangeSkinType(this.mPageContext, i);
            this.eYM.onChangeSkinType(this.mPageContext, i);
            this.inW.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.inV != null) {
            this.inV.cci();
        }
    }

    public void Q(int i, boolean z) {
        this.inW.Q(i, z);
    }

    public void cch() {
        if (this.inV != null) {
            this.inV.cch();
        }
    }

    public void cci() {
        if (this.inV != null) {
            this.inV.cci();
        }
    }
}
