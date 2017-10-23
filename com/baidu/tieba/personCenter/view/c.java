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
    private NoNetworkView bfM;
    private com.baidu.tieba.personCenter.b.c faN;
    private com.baidu.tieba.view.d faO;
    private View faP;
    private FrameLayout faQ;
    private h faR;
    private a faS;
    private TbPageContext mH;
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
            this.mH = tbPageContext;
            this.bfM = (NoNetworkView) view.findViewById(d.h.person_center_no_network_view);
            this.mNavigationBar = (NavigationBar) view.findViewById(d.h.person_center_navigation_bar);
            this.faQ = (FrameLayout) view.findViewById(d.h.layout_container);
            this.mNavigationBar.showBottomLine();
            this.mListView = (BdTypeListView) view.findViewById(d.h.person_center_listview);
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(d.f.ds200));
            this.faP = new View(tbPageContext.getPageActivity());
            this.faP.setLayoutParams(layoutParams);
            this.mListView.addFooterView(this.faP);
            this.faN = new com.baidu.tieba.personCenter.b.c(this.mListView, tbPageContext, bdUniqueId);
            this.faO = new com.baidu.tieba.view.d(1);
        }
    }

    public void b(com.baidu.tieba.personCenter.c.c cVar) {
        if (cVar != null) {
            this.faN.b(cVar);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("clicked_blue_tip", false) && cVar.getUserData() != null && cVar.getUserData().getPersonPrivate() != null) {
                int BQ = cVar.getUserData().getPersonPrivate().BQ();
                if (2 == BQ || 3 == BQ) {
                    if (this.faR == null) {
                        this.faR = new h(this.mH.getContext());
                    }
                    this.faR.a(this.faQ, TbadkCoreApplication.getInst().getSkinType());
                } else if (this.faR != null) {
                    this.faR.hide();
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.faN.notifyDataSetChanged();
    }

    public void S(int i, String str) {
        this.mH.showToast(str);
    }

    public void initView() {
        FrameLayout.LayoutParams layoutParams;
        this.mTitle = this.mNavigationBar.setCenterTextTitle(this.mH.getString(d.l.mine));
        this.faO.a(this.mH.getPageActivity(), this.mNavigationBar);
        View bottomLine = this.mNavigationBar.getBottomLine();
        if (bottomLine != null) {
            if (bottomLine.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) bottomLine.getLayoutParams();
                layoutParams.height = (int) this.mH.getResources().getDimension(d.f.ds1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mH.getResources().getDimension(d.f.ds1));
            }
            bottomLine.setLayoutParams(layoutParams);
        }
        this.faO.bxP();
        this.faO.setOnViewResponseListener(null);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public boolean aoJ() {
        if (this.refreshView != null) {
            return this.refreshView.Eh();
        }
        return false;
    }

    public void a(a aVar) {
        this.faS = aVar;
    }

    public void OZ() {
        if (!aoJ()) {
            if (this.refreshView == null) {
                this.refreshView = new com.baidu.tbadk.j.g(this.mH.getPageActivity(), new View.OnClickListener() { // from class: com.baidu.tieba.personCenter.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (j.gV()) {
                            c.this.NW();
                            if (c.this.faS != null) {
                                c.this.faS.br(view);
                            }
                        }
                    }
                });
            }
            this.refreshView.fj(this.mH.getResources().getDimensionPixelSize(d.f.ds180) - UtilHelper.getImmersiveStickyBarHeight());
            this.refreshView.gq(this.mH.getString(d.l.neterror));
            this.refreshView.c(this.faQ, false);
            this.refreshView.Eq();
            this.refreshView.onChangeSkinType();
        }
    }

    public void NW() {
        if (this.refreshView != null) {
            this.refreshView.O(this.faQ);
            this.refreshView = null;
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            aj.i(this.mTitle, d.e.cp_cont_b);
            aj.k(this.faP, d.e.cp_bg_line_d);
            aj.k(this.mListView, d.e.cp_bg_line_d);
            this.mNavigationBar.onChangeSkinType(this.mH, i);
            this.faN.onChangeSkinType();
            this.bfM.onChangeSkinType(this.mH, i);
            this.faO.onChangeSkinType(i);
            if (this.faR != null) {
                this.faR.onChangeSkinType(i);
            }
            if (this.refreshView != null) {
                this.refreshView.onChangeSkinType();
            }
            this.mSkinType = i;
        }
    }

    public void onDestroy() {
        if (this.faR != null) {
            this.faR.hide();
        }
        if (this.faN != null) {
            this.faN.aVi();
        }
    }

    public void y(int i, boolean z) {
        this.faO.y(i, z);
    }

    public void aVh() {
        if (this.faN != null) {
            this.faN.aVh();
        }
    }

    public void aVi() {
        if (this.faN != null) {
            this.faN.aVi();
        }
    }

    @Override // com.baidu.tieba.personCenter.view.h.a
    public void aVo() {
        this.faR = null;
    }
}
