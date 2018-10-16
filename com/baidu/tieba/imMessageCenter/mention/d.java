package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView bJX;
    private com.baidu.tbadk.mvc.g.a cUX;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eVD;
    private BdListView eVE;
    private NavigationBar eVF;
    private AtMessageActivity eVw;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eVw = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aaK() {
        this.rootView = this.eVw.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.eVw.setContentView(this.rootView);
        this.eVE = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.eVF = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.eVF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eVF.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.eVF.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eVw.getPageContext());
        this.mPullView.setTag(this.eVw.getUniqueId());
        this.mPullView.a(this.eVw);
        this.cUX = new com.baidu.tbadk.mvc.g.a(this.eVw);
        this.cUX.oG();
        this.mHeaderView = new TextView(this.eVw.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.eVw.getPageContext().getPageActivity(), e.C0175e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kX());
        this.eVE.setPullRefresh(this.mPullView);
        this.eVE.addHeaderView(this.mHeaderView, 0);
        this.eVE.setNextPage(this.cUX);
        this.eVE.setDividerHeight(0);
        this.bJX = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bJX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bJX.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bn(boolean z) {
                d.this.iR(z);
            }
        });
        this.eVE.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eVw.aBW();
            }
        });
        this.eVD = new com.baidu.tbadk.mvc.f.d<>(this.eVw.getPageContext(), a.class, e.h.mention_atme_item, this.eVw.Ny());
        this.eVD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eVw.getResources().getDimension(e.C0175e.ds80)), NoDataViewFactory.d.dO(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eVE.setAdapter((ListAdapter) this.eVD);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eVD != null) {
                this.eVD.S(fVar.aUH());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eVD != null) {
            this.eVD.b(tbPageContext, i);
        }
        if (this.cUX != null) {
            this.cUX.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        this.eVF.onChangeSkinType(tbPageContext, i);
    }

    public void aUn() {
        if (this.eVE != null) {
            this.eVE.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void iR(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kX());
        if (z && this.eVE != null && this.eVE.getWrappedAdapter() != null && this.eVE.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jI().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eVE.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cUX != null) {
                if (aVar.Ns()) {
                    this.cUX.pQ();
                    if (aVar.Nq()) {
                        this.cUX.fD(e.j.loading);
                    } else if (aVar.Nr()) {
                        this.cUX.fD(e.j.loading);
                    } else {
                        this.cUX.fE(e.j.no_more_msg);
                    }
                } else {
                    this.cUX.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aUo();
            } else {
                aUn();
            }
        }
    }

    public void aUo() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eVE != null) {
            this.eVE.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eVw);
        }
    }
}
