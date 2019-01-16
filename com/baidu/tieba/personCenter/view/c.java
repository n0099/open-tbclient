package com.baidu.tieba.personCenter.view;

import android.graphics.drawable.BitmapDrawable;
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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.e;
/* loaded from: classes5.dex */
public class c {
    private NoNetworkView bPl;
    private PluginErrorTipView drP;
    private com.baidu.tieba.personCenter.b.c gwo;
    private com.baidu.tieba.view.d gwp;
    private View gwq;
    private FrameLayout gwr;
    private a gws;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes5.dex */
    public interface a {
        void bL(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bPl = (NoNetworkView) view.findViewById(e.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(e.g.person_center_navigation_bar);
            this.drP = (PluginErrorTipView) view.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gwr = (FrameLayout) view.findViewById(e.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(e.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(e.C0210e.ds200));
            this.gwq = new View(tbPageContext.getPageActivity());
            this.gwq.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.gwq);
            this.gwo = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.gwp = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.gwo.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gwo.notifyDataSetChanged();
    }

    public void A(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(e.j.mine));
        this.gwp.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(e.C0210e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(e.C0210e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.gwp.brf();
        this.gwp.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aLn() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.gws = aVar;
    }

    public void abw() {
        if (!aLn()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            c.this.abx();
                            if (c.this.gws != null) {
                                c.this.gws.bL(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ge(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.iC(this.mPageContext.getString(e.j.neterror));
            this.refreshView.attachView(this.gwr, false);
            this.refreshView.Od();
            this.refreshView.onChangeSkinType();
        }
    }

    public void abx() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.gwr);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.gwq, e.d.cp_bg_line_d);
            al.j(this.mListView, e.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
            this.gwo.onChangeSkinType();
            this.bPl.onChangeSkinType(this.mPageContext, i);
            this.drP.onChangeSkinType(this.mPageContext, i);
            this.gwp.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gwo != null) {
            this.gwo.bpW();
        }
    }

    public void C(int i, boolean z) {
        this.gwp.C(i, z);
    }

    public void bpV() {
        if (this.gwo != null) {
            this.gwo.bpV();
        }
    }

    public void bpW() {
        if (this.gwo != null) {
            this.gwo.bpW();
        }
    }
}
