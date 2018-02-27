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
    private NoNetworkView caX;
    private PluginErrorTipView dpj;
    private com.baidu.tieba.personCenter.b.c gjR;
    private f gjS;
    private View gjT;
    private FrameLayout gjU;
    private a gjV;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void cG(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.caX = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.dpj = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.gjU = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.gjT = new View(tbPageContext.getPageActivity());
            this.gjT.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.gjT);
            this.gjR = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.gjS = new f(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.gjR.b(dVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || dVar.getUserData() == null || dVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gjR.notifyDataSetChanged();
    }

    public void ac(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.gjS.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.gjS.bjM();
        this.gjS.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aCf() {
        if (this.refreshView != null) {
            return this.refreshView.MI();
        }
        return false;
    }

    public void a(a aVar) {
        this.gjV = aVar;
    }

    public void XL() {
        if (!aCf()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.ox()) {
                            c.this.XM();
                            if (c.this.gjV != null) {
                                c.this.gjV.cG(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.ib(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gW(this.mPageContext.getString(d.j.neterror));
            this.refreshView.j(this.gjU, false);
            this.refreshView.MQ();
            this.refreshView.onChangeSkinType();
        }
    }

    public void XM() {
        if (this.refreshView != null) {
            this.refreshView.bk(this.gjU);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.r(this.mTitle, d.C0141d.cp_cont_b);
            aj.t(this.gjT, d.C0141d.cp_bg_line_d);
            aj.t(this.mListView, d.C0141d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.gjR.onChangeSkinType();
            this.caX.onChangeSkinType(this.mPageContext, i);
            this.dpj.onChangeSkinType(this.mPageContext, i);
            this.gjS.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gjR != null) {
            this.gjR.biG();
        }
    }

    public void Q(int i, boolean z) {
        this.gjS.Q(i, z);
    }

    public void biF() {
        if (this.gjR != null) {
            this.gjR.biF();
        }
    }

    public void biG() {
        if (this.gjR != null) {
            this.gjR.biG();
        }
    }
}
