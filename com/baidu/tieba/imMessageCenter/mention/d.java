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
    private NoNetworkView bKI;
    private com.baidu.tbadk.mvc.g.a cWd;
    private AtMessageActivity eWP;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eWW;
    private BdListView eWX;
    private NavigationBar eWY;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eWP = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aaV() {
        this.rootView = this.eWP.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.eWP.setContentView(this.rootView);
        this.eWX = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.eWY = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.eWY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWY.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.eWY.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eWP.getPageContext());
        this.mPullView.setTag(this.eWP.getUniqueId());
        this.mPullView.a(this.eWP);
        this.cWd = new com.baidu.tbadk.mvc.g.a(this.eWP);
        this.cWd.oE();
        this.mHeaderView = new TextView(this.eWP.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.eWP.getPageContext().getPageActivity(), e.C0200e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        this.eWX.setPullRefresh(this.mPullView);
        this.eWX.addHeaderView(this.mHeaderView, 0);
        this.eWX.setNextPage(this.cWd);
        this.eWX.setDividerHeight(0);
        this.bKI = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bKI.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bKI.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bE(boolean z) {
                d.this.ja(z);
            }
        });
        this.eWX.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eWP.aBu();
            }
        });
        this.eWW = new com.baidu.tbadk.mvc.f.d<>(this.eWP.getPageContext(), a.class, e.h.mention_atme_item, this.eWP.NH());
        this.eWW.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eWP.getResources().getDimension(e.C0200e.ds80)), NoDataViewFactory.d.ec(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eWX.setAdapter((ListAdapter) this.eWW);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eWW != null) {
                this.eWW.R(fVar.aUe());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eWW != null) {
            this.eWW.b(tbPageContext, i);
        }
        if (this.cWd != null) {
            this.cWd.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        this.eWY.onChangeSkinType(tbPageContext, i);
    }

    public void aTK() {
        if (this.eWX != null) {
            this.eWX.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void ja(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        if (z && this.eWX != null && this.eWX.getWrappedAdapter() != null && this.eWX.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eWX.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cWd != null) {
                if (aVar.NB()) {
                    this.cWd.pO();
                    if (aVar.Nz()) {
                        this.cWd.fR(e.j.loading);
                    } else if (aVar.NA()) {
                        this.cWd.fR(e.j.loading);
                    } else {
                        this.cWd.fS(e.j.no_more_msg);
                    }
                } else {
                    this.cWd.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aTL();
            } else {
                aTK();
            }
        }
    }

    public void aTL() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eWX != null) {
            this.eWX.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eWP);
        }
    }
}
