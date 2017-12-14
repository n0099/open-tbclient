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
/* loaded from: classes.dex */
public class c {
    private NoNetworkView blu;
    private PluginErrorTipView ctg;
    private com.baidu.tieba.personCenter.b.c ftt;
    private com.baidu.tieba.view.e ftu;
    private View ftv;
    private FrameLayout ftw;
    private a ftx;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void bt(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.blu = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.ctg = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.ftw = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.ftv = new View(tbPageContext.getPageActivity());
            this.ftv.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.ftv);
            this.ftt = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.ftu = new com.baidu.tieba.view.e(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null) {
            this.ftt.b(cVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || cVar.getUserData() == null || cVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.ftt.notifyDataSetChanged();
    }

    public void aa(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.ftu.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.ftu.bbi();
        this.ftu.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean atA() {
        if (this.refreshView != null) {
            return this.refreshView.EO();
        }
        return false;
    }

    public void a(a aVar) {
        this.ftx = aVar;
    }

    public void QD() {
        if (!atA()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.gV()) {
                            c.this.Pr();
                            if (c.this.ftx != null) {
                                c.this.ftx.bt(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fi(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gB(this.mPageContext.getString(d.j.neterror));
            this.refreshView.c(this.ftw, false);
            this.refreshView.EW();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.P(this.ftw);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.C0096d.cp_cont_b);
            aj.k(this.ftv, d.C0096d.cp_bg_line_d);
            aj.k(this.mListView, d.C0096d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.ftt.onChangeSkinType();
            this.blu.onChangeSkinType(this.mPageContext, i);
            this.ctg.onChangeSkinType(this.mPageContext, i);
            this.ftu.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.ftt != null) {
            this.ftt.bae();
        }
    }

    public void z(int i, boolean z) {
        this.ftu.z(i, z);
    }

    public void bad() {
        if (this.ftt != null) {
            this.ftt.bad();
        }
    }

    public void bae() {
        if (this.ftt != null) {
            this.ftt.bae();
        }
    }
}
