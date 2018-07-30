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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.plugin.PluginErrorTipView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c {
    private NoNetworkView bvz;
    private PluginErrorTipView cSz;
    private com.baidu.tieba.personCenter.b.c fVp;
    private com.baidu.tieba.view.d fVq;
    private View fVr;
    private FrameLayout fVs;
    private a fVt;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes2.dex */
    public interface a {
        void bt(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bvz = (NoNetworkView) view.findViewById(d.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.g.person_center_navigation_bar);
            this.cSz = (PluginErrorTipView) view.findViewById(d.g.person_center_plugin_error_tip_view);
            this.fVs = (FrameLayout) view.findViewById(d.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.e.ds200));
            this.fVr = new View(tbPageContext.getPageActivity());
            this.fVr.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fVr);
            this.fVp = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fVq = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.d dVar) {
        if (dVar != null) {
            this.fVp.b(dVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || dVar.getUserData() == null || dVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fVp.notifyDataSetChanged();
    }

    public void D(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(d.j.mine));
        this.fVq.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.fVq.biO();
        this.fVq.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aDj() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    public void a(a aVar) {
        this.fVt = aVar;
    }

    public void Uj() {
        if (!aDj()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.js()) {
                            c.this.Uk();
                            if (c.this.fVt != null) {
                                c.this.fVt.bt(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fh(this.mPageContext.getResources().getDimensionPixelSize(d.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.hk(this.mPageContext.getString(d.j.neterror));
            this.refreshView.c(this.fVs, false);
            this.refreshView.Jk();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Uk() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.fVs);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.mTitle, d.C0140d.cp_cont_b);
            am.j(this.fVr, d.C0140d.cp_bg_line_d);
            am.j(this.mListView, d.C0140d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)).mutate());
            this.fVp.onChangeSkinType();
            this.bvz.onChangeSkinType(this.mPageContext, i);
            this.cSz.onChangeSkinType(this.mPageContext, i);
            this.fVq.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fVp != null) {
            this.fVp.bhH();
        }
    }

    public void B(int i, boolean z) {
        this.fVq.B(i, z);
    }

    public void bhG() {
        if (this.fVp != null) {
            this.fVp.bhG();
        }
    }

    public void bhH() {
        if (this.fVp != null) {
            this.fVp.bhH();
        }
    }
}
