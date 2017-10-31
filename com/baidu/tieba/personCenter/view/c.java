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
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    private NoNetworkView bgD;
    private PluginErrorTipView ckc;
    private com.baidu.tieba.personCenter.b.c fje;
    private com.baidu.tieba.view.e fjf;
    private View fjg;
    private FrameLayout fjh;
    private h fji;
    private a fjj;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void bu(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bgD = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.ckc = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fjh = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.fjg = new View(tbPageContext.getPageActivity());
            this.fjg.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fjg);
            this.fje = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fjf = new com.baidu.tieba.view.e(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null) {
            this.fje.b(cVar);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) && cVar.getUserData() != null && cVar.getUserData().getPersonPrivate() != null) {
                int Cf = cVar.getUserData().getPersonPrivate().Cf();
                if (2 == Cf || 3 == Cf) {
                    if (this.fji == null) {
                        this.fji = new h(this.mPageContext.getContext());
                    }
                    this.fji.show(this.fjh, TbadkCoreApplication.getInst().getSkinType());
                } else if (this.fji != null) {
                    this.fji.hide();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fje.notifyDataSetChanged();
    }

    public void U(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.fjf.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.fjf.bBi();
        this.fjf.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean ari() {
        if (this.refreshView != null) {
            return this.refreshView.Eu();
        }
        return false;
    }

    public void a(a aVar) {
        this.fjj = aVar;
    }

    public void Pj() {
        if (!ari()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.gV()) {
                            c.this.Oc();
                            if (c.this.fjj != null) {
                                c.this.fjj.bu(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fk(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gy(this.mPageContext.getString(d.j.neterror));
            this.refreshView.c(this.fjh, false);
            this.refreshView.EC();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this.fjh);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.C0080d.cp_cont_b);
            aj.k(this.fjg, d.C0080d.cp_bg_line_d);
            aj.k(this.mListView, d.C0080d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.fje.onChangeSkinType();
            this.bgD.onChangeSkinType(this.mPageContext, i);
            this.ckc.onChangeSkinType(this.mPageContext, i);
            this.fjf.onChangeSkinType(i);
            if (this.fji != null) {
                this.fji.onChangeSkinType(i);
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fji != null) {
            this.fji.hide();
        }
        if (this.fje != null) {
            this.fje.aYl();
        }
    }

    public void z(int i, boolean z) {
        this.fjf.z(i, z);
    }

    public void aYk() {
        if (this.fje != null) {
            this.fje.aYk();
        }
    }

    public void aYl() {
        if (this.fje != null) {
            this.fje.aYl();
        }
    }
}
