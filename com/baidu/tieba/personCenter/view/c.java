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
import com.baidu.tieba.d;
import com.baidu.tieba.personCenter.view.h;
/* loaded from: classes.dex */
public class c implements h.a {
    private NoNetworkView bga;
    private com.baidu.tieba.personCenter.b.c fbb;
    private com.baidu.tieba.view.d fbc;
    private View fbd;
    private FrameLayout fbe;
    private h fbf;
    private a fbg;
    private TbPageContext mG;
    private BdTypeListView mListView;
    private NavigationBar mNavigationBar;
    private int mSkinType = 3;
    private TextView mTitle;
    private com.baidu.tbadk.j.g refreshView;

    /* loaded from: classes.dex */
    public interface a {
        void br(View view);
    }

    public c(View view, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        if (view != null) {
            this.mG = tbPageContext;
            this.bga = (NoNetworkView) view.findViewById(d.h.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.h.person_center_navigation_bar);
            this.fbe = (FrameLayout) view.findViewById(d.h.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.h.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.f.ds200));
            this.fbd = new View(tbPageContext.getPageActivity());
            this.fbd.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.fbd);
            this.fbb = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.fbc = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.fbb.b(cVar);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) && cVar.getUserData() != null && cVar.getUserData().getPersonPrivate() != null) {
                int BW = cVar.getUserData().getPersonPrivate().BW();
                if (2 == BW || 3 == BW) {
                    if (this.fbf == null) {
                        this.fbf = new h(this.mG.getContext());
                    }
                    this.fbf.a(this.fbe, TbadkCoreApplication.getInst().getSkinType());
                } else if (this.fbf != null) {
                    this.fbf.hide();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.fbb.notifyDataSetChanged();
    }

    public void S(int i, String str) {
        this.mG.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mG.getString(d.l.mine));
        this.fbc.a(this.mG.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mG.getResources().getDimension(d.f.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mG.getResources().getDimension(d.f.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.fbc.bxX();
        this.fbc.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aoO() {
        if (this.refreshView != null) {
            return this.refreshView.En();
        }
        return false;
    }

    public void a(a aVar) {
        this.fbg = aVar;
    }

    public void Pf() {
        if (!aoO()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.mG.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.gV()) {
                            c.this.Oc();
                            if (c.this.fbg != null) {
                                c.this.fbg.br(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fk(this.mG.getResources().getDimensionPixelSize(d.f.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gr(this.mG.getString(d.l.neterror));
            this.refreshView.c(this.fbe, false);
            this.refreshView.Ew();
            this.refreshView.onChangeSkinType();
        }
    }

    public void Oc() {
        if (this.refreshView != null) {
            this.refreshView.O(this.fbe);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.fbd, d.e.cp_bg_line_d);
            aj.k(this.mListView, d.e.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mG, i);
            this.fbb.onChangeSkinType();
            this.bga.onChangeSkinType(this.mG, i);
            this.fbc.onChangeSkinType(i);
            if (this.fbf != null) {
                this.fbf.onChangeSkinType(i);
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.fbf != null) {
            this.fbf.hide();
        }
        if (this.fbb != null) {
            this.fbb.aVn();
        }
    }

    public void y(int i, boolean z) {
        this.fbc.y(i, z);
    }

    public void aVm() {
        if (this.fbb != null) {
            this.fbb.aVm();
        }
    }

    public void aVn() {
        if (this.fbb != null) {
            this.fbb.aVn();
        }
    }

    @Override // com.baidu.tieba.personCenter.view.h.a
    public void aVt() {
        this.fbf = null;
    }
}
