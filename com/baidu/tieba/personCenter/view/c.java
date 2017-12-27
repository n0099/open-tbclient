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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
import com.baidu.tieba.view.f;
/* loaded from: classes.dex */
public class c {
    private NoNetworkView bYJ;
    private PluginErrorTipView dhI;
    private com.baidu.tieba.personCenter.b.c ggu;
    private f ggv;
    private View ggw;
    private FrameLayout ggx;
    private a ggy;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void cF(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bYJ = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.dhI = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.ggx = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.ggw = new View(tbPageContext.getPageActivity());
            this.ggw.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.ggw);
            this.ggu = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.ggv = new f(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.ggu.b(dVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || dVar.getUserData() == null || dVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ggu.notifyDataSetChanged();
    }

    public void aa(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.ggv.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(d.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(d.e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.ggv.biB();
        this.ggv.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aAF() {
        if (this.refreshView != null) {
            return this.refreshView.Mn();
        }
        return false;
    }

    public void a(a aVar) {
        this.ggy = aVar;
    }

    public void Yb() {
        if (!aAF()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ow()) {
                            c.this.WQ();
                            if (c.this.ggy != null) {
                                c.this.ggy.cF(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ih(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gE(this.mPageContext.getString(d.j.neterror));
            this.refreshView.j(this.ggx, false);
            this.refreshView.Mv();
            this.refreshView.onChangeSkinType();
        }
    }

    public void WQ() {
        if (this.refreshView != null) {
            this.refreshView.bi(this.ggx);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.mTitle, d.C0108d.cp_cont_b);
            aj.t(this.ggw, d.C0108d.cp_bg_line_d);
            aj.t(this.mListView, d.C0108d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.ggu.onChangeSkinType();
            this.bYJ.onChangeSkinType(this.mPageContext, i);
            this.dhI.onChangeSkinType(this.mPageContext, i);
            this.ggv.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ggu != null) {
            this.ggu.bhv();
        }
    }

    public void K(int i, boolean z) {
        this.ggv.K(i, z);
    }

    public void bhu() {
        if (this.ggu != null) {
            this.ggu.bhu();
        }
    }

    public void bhv() {
        if (this.ggu != null) {
            this.ggu.bhv();
        }
    }
}
