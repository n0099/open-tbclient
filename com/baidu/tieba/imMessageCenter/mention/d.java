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
    private NoNetworkView bPl;
    private com.baidu.tbadk.mvc.g.a dgr;
    private AtMessageActivity fhi;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> fhp;
    private BdListView fhq;
    private NavigationBar fhr;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.fhi = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acA() {
        this.rootView = this.fhi.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.fhi.setContentView(this.rootView);
        this.fhq = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.fhr = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.fhr.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fhr.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.fhr.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.fhi.getPageContext());
        this.mPullView.setTag(this.fhi.getUniqueId());
        this.mPullView.a(this.fhi);
        this.dgr = new com.baidu.tbadk.mvc.g.a(this.fhi);
        this.dgr.oH();
        this.mHeaderView = new TextView(this.fhi.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fhi.getPageContext().getPageActivity(), e.C0210e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        this.fhq.setPullRefresh(this.mPullView);
        this.fhq.addHeaderView(this.mHeaderView, 0);
        this.fhq.setNextPage(this.dgr);
        this.fhq.setDividerHeight(0);
        this.bPl = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bPl.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bPl.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bG(boolean z) {
                d.this.jg(z);
            }
        });
        this.fhq.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.fhi.aEq();
            }
        });
        this.fhp = new com.baidu.tbadk.mvc.f.d<>(this.fhi.getPageContext(), a.class, e.h.mention_atme_item, this.fhi.Pe());
        this.fhp.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fhi.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.fhq.setAdapter((ListAdapter) this.fhp);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.fhp != null) {
                this.fhp.S(fVar.aXj());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fhp != null) {
            this.fhp.b(tbPageContext, i);
        }
        if (this.dgr != null) {
            this.dgr.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.fhr.onChangeSkinType(tbPageContext, i);
    }

    public void aWP() {
        if (this.fhq != null) {
            this.fhq.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void jg(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        if (z && this.fhq != null && this.fhq.getWrappedAdapter() != null && this.fhq.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fhq.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dgr != null) {
                if (aVar.OY()) {
                    this.dgr.pR();
                    if (aVar.OW()) {
                        this.dgr.gg(e.j.loading);
                    } else if (aVar.OX()) {
                        this.dgr.gg(e.j.loading);
                    } else {
                        this.dgr.gh(e.j.no_more_msg);
                    }
                } else {
                    this.dgr.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aWQ();
            } else {
                aWP();
            }
        }
    }

    public void aWQ() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.fhq != null) {
            this.fhq.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.fhi);
        }
    }
}
