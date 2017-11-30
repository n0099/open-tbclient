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
    private NoNetworkView blt;
    private PluginErrorTipView csX;
    private View fsA;
    private FrameLayout fsB;
    private a fsC;
    private com.baidu.tieba.personCenter.b.c fsy;
    private com.baidu.tieba.view.e fsz;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void bq(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.blt = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.csX = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fsB = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.fsA = new View(tbPageContext.getPageActivity());
            this.fsA.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fsA);
            this.fsy = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fsz = new com.baidu.tieba.view.e(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null) {
            this.fsy.b(cVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || cVar.getUserData() == null || cVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fsy.notifyDataSetChanged();
    }

    public void aa(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.fsz.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.fsz.bba();
        this.fsz.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean atr() {
        if (this.refreshView != null) {
            return this.refreshView.EN();
        }
        return false;
    }

    public void a(a aVar) {
        this.fsC = aVar;
    }

    public void QD() {
        if (!atr()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.gV()) {
                            c.this.Pr();
                            if (c.this.fsC != null) {
                                c.this.fsC.bq(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fi(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gC(this.mPageContext.getString(d.j.neterror));
            this.refreshView.c(this.fsB, false);
            this.refreshView.EV();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Pr() {
        if (this.refreshView != null) {
            this.refreshView.O(this.fsB);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.C0082d.cp_cont_b);
            aj.k(this.fsA, d.C0082d.cp_bg_line_d);
            aj.k(this.mListView, d.C0082d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.fsy.onChangeSkinType();
            this.blt.onChangeSkinType(this.mPageContext, i);
            this.csX.onChangeSkinType(this.mPageContext, i);
            this.fsz.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fsy != null) {
            this.fsy.aZV();
        }
    }

    public void z(int i, boolean z) {
        this.fsz.z(i, z);
    }

    public void aZU() {
        if (this.fsy != null) {
            this.fsy.aZU();
        }
    }

    public void aZV() {
        if (this.fsy != null) {
            this.fsy.aZV();
        }
    }
}
