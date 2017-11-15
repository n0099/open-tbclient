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
    private NoNetworkView bgM;
    private PluginErrorTipView ckt;
    private com.baidu.tieba.personCenter.b.c fjB;
    private com.baidu.tieba.view.e fjC;
    private View fjD;
    private FrameLayout fjE;
    private h fjF;
    private a fjG;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private com.baidu.tbadk.k.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void bv(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bgM = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.ckt = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fjE = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.fjD = new View(tbPageContext.getPageActivity());
            this.fjD.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fjD);
            this.fjB = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fjC = new com.baidu.tieba.view.e(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.c cVar) {
        if (cVar != null) {
            this.fjB.b(cVar);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) && cVar.getUserData() != null && cVar.getUserData().getPersonPrivate() != null) {
                int Cr = cVar.getUserData().getPersonPrivate().Cr();
                if (2 == Cr || 3 == Cr) {
                    if (this.fjF == null) {
                        this.fjF = new h(this.mPageContext.getContext());
                    }
                    this.fjF.show(this.fjE, TbadkCoreApplication.getInst().getSkinType());
                } else if (this.fjF != null) {
                    this.fjF.hide();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fjB.notifyDataSetChanged();
    }

    public void U(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.fjC.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.fjC.bBu();
        this.fjC.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean ary() {
        if (this.refreshView != null) {
            return this.refreshView.EG();
        }
        return false;
    }

    public void a(a aVar) {
        this.fjG = aVar;
    }

    public void Pu() {
        if (!ary()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.k.g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.gV()) {
                            c.this.On();
                            if (c.this.fjG != null) {
                                c.this.fjG.bv(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fj(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gz(this.mPageContext.getString(d.j.neterror));
            this.refreshView.c(this.fjE, false);
            this.refreshView.EO();
            this.refreshView.onChangeSkinType();
        }
    }

    public void On() {
        if (this.refreshView != null) {
            this.refreshView.O(this.fjE);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.C0080d.cp_cont_b);
            aj.k(this.fjD, d.C0080d.cp_bg_line_d);
            aj.k(this.mListView, d.C0080d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.fjB.onChangeSkinType();
            this.bgM.onChangeSkinType(this.mPageContext, i);
            this.ckt.onChangeSkinType(this.mPageContext, i);
            this.fjC.onChangeSkinType(i);
            if (this.fjF != null) {
                this.fjF.onChangeSkinType(i);
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fjF != null) {
            this.fjF.hide();
        }
        if (this.fjB != null) {
            this.fjB.aYt();
        }
    }

    public void A(int i, boolean z) {
        this.fjC.A(i, z);
    }

    public void aYs() {
        if (this.fjB != null) {
            this.fjB.aYs();
        }
    }

    public void aYt() {
        if (this.fjB != null) {
            this.fjB.aYt();
        }
    }
}
