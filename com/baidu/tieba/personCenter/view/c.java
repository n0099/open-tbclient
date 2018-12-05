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
    private NoNetworkView bOx;
    private PluginErrorTipView doq;
    private com.baidu.tieba.personCenter.b.c gst;
    private com.baidu.tieba.view.d gsu;
    private View gsv;
    private FrameLayout gsw;
    private a gsx;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private TextView mTitle;
    private g refreshView;

    /* loaded from: classes5.dex */
    public interface a {
        void bI(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mPageContext = tbPageContext;
            this.bOx = (NoNetworkView) view.findViewById(e.g.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(e.g.person_center_navigation_bar);
            this.doq = (PluginErrorTipView) view.findViewById(e.g.person_center_plugin_error_tip_view);
            this.gsw = (FrameLayout) view.findViewById(e.g.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(e.g.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(e.C0210e.ds200));
            this.gsv = new View(tbPageContext.getPageActivity());
            this.gsv.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.gsv);
            this.gst = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.gsu = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.data.e eVar) {
        if (eVar != null) {
            this.gst.b(eVar);
            if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) || eVar.getUserData() == null || eVar.getUserData().getPersonPrivate() == null) {
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gst.notifyDataSetChanged();
    }

    public void y(int i, String str) {
        this.mPageContext.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(e.j.mine));
        this.gsu.a(this.mPageContext.getPageActivity(), this.mNavigationBar);
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
        this.gsu.bpL();
        this.gsu.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aKa() {
        if (this.refreshView != null) {
            return this.refreshView.isViewAttached();
        }
        return false;
    }

    public void a(a aVar) {
        this.gsx = aVar;
    }

    public void aaX() {
        if (!aKa()) {
            if (this.refreshView == null) {
                this.refreshView = new g(this.mPageContext.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.kK()) {
                            c.this.aaY();
                            if (c.this.gsx != null) {
                                c.this.gsx.bI(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.gd(this.mPageContext.getResources().getDimensionPixelSize(e.C0210e.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.in(this.mPageContext.getString(e.j.neterror));
            this.refreshView.attachView(this.gsw, false);
            this.refreshView.NL();
            this.refreshView.onChangeSkinType();
        }
    }

    public void aaY() {
        if (this.refreshView != null) {
            this.refreshView.dettachView(this.gsw);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.mTitle, e.d.cp_cont_b);
            al.j(this.gsv, e.d.cp_bg_line_d);
            al.j(this.mListView, e.d.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)).mutate());
            this.gst.onChangeSkinType();
            this.bOx.onChangeSkinType(this.mPageContext, i);
            this.doq.onChangeSkinType(this.mPageContext, i);
            this.gsu.onChangeSkinType(i);
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.gst != null) {
            this.gst.boC();
        }
    }

    public void C(int i, boolean z) {
        this.gsu.C(i, z);
    }

    public void boB() {
        if (this.gst != null) {
            this.gst.boB();
        }
    }

    public void boC() {
        if (this.gst != null) {
            this.gst.boC();
        }
    }
}
