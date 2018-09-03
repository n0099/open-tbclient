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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class c {
    private NoNetworkView bvB;
    private PluginErrorTipView cSw;
    private com.baidu.tieba.personCenter.b.c fVm;
    private com.baidu.tieba.view.d fVn;
    private View fVo;
    private FrameLayout fVp;
    private a fVq;
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
            this.bvB = (NoNetworkView) view.findViewById(f.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(f.g.person_center_navigation_bar);
            this.cSw = (PluginErrorTipView) view.findViewById(f.g.person_center_plugin_error_tip_view);
            this.fVp = (FrameLayout) view.findViewById(f.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(f.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(f.e.ds200));
            this.fVo = new View(tbPageContext.getPageActivity());
            this.fVo.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fVo);
            this.fVm = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fVn = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.fVm.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fVm.notifyDataSetChanged();
    }

    public void D(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(f.j.mine));
        this.fVn.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mPageContext.getResources().getDimension(f.e.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mPageContext.getResources().getDimension(f.e.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.fVn.biL();
        this.fVn.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aDg() {
        if (this.refreshView != null) {
            return this.refreshView.Jc();
        }
        return false;
    }

    public void a(a aVar) {
        this.fVq = aVar;
    }

    public void Um() {
        if (!aDg()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.js()) {
                            c.this.Un();
                            if (c.this.fVq != null) {
                                c.this.fVq.bt(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fg(this.mPageContext.getResources().getDimensionPixelSize(f.e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.hk(this.mPageContext.getString(f.j.neterror));
            this.refreshView.c(this.fVp, false);
            this.refreshView.Jk();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Un() {
        if (this.refreshView != null) {
            this.refreshView.Q(this.fVp);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.mTitle, f.d.cp_cont_b);
            am.j(this.fVo, f.d.cp_bg_line_d);
            am.j(this.mListView, f.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg)).mutate());
            this.fVm.onChangeSkinType();
            this.bvB.onChangeSkinType(this.mPageContext, i);
            this.cSw.onChangeSkinType(this.mPageContext, i);
            this.fVn.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fVm != null) {
            this.fVm.bhC();
        }
    }

    public void B(int i, boolean z) {
        this.fVn.B(i, z);
    }

    public void bhB() {
        if (this.fVm != null) {
            this.fVm.bhB();
        }
    }

    public void bhC() {
        if (this.fVm != null) {
            this.fVm.bhC();
        }
    }
}
