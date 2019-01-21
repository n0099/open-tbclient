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
    private NoNetworkView bPm;
    private com.baidu.tbadk.mvc.g.a dgs;
    private AtMessageActivity fhj;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> fhq;
    private BdListView fhr;
    private NavigationBar fhs;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.fhj = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acA() {
        this.rootView = this.fhj.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.fhj.setContentView(this.rootView);
        this.fhr = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.fhs = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.fhs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fhs.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.fhs.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.fhj.getPageContext());
        this.mPullView.setTag(this.fhj.getUniqueId());
        this.mPullView.a(this.fhj);
        this.dgs = new com.baidu.tbadk.mvc.g.a(this.fhj);
        this.dgs.oH();
        this.mHeaderView = new TextView(this.fhj.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fhj.getPageContext().getPageActivity(), e.C0210e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        this.fhr.setPullRefresh(this.mPullView);
        this.fhr.addHeaderView(this.mHeaderView, 0);
        this.fhr.setNextPage(this.dgs);
        this.fhr.setDividerHeight(0);
        this.bPm = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bPm.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bPm.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bG(boolean z) {
                d.this.jg(z);
            }
        });
        this.fhr.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.fhj.aEq();
            }
        });
        this.fhq = new com.baidu.tbadk.mvc.f.d<>(this.fhj.getPageContext(), a.class, e.h.mention_atme_item, this.fhj.Pe());
        this.fhq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fhj.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.fhr.setAdapter((ListAdapter) this.fhq);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.fhq != null) {
                this.fhq.S(fVar.aXj());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fhq != null) {
            this.fhq.b(tbPageContext, i);
        }
        if (this.dgs != null) {
            this.dgs.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.fhs.onChangeSkinType(tbPageContext, i);
    }

    public void aWP() {
        if (this.fhr != null) {
            this.fhr.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void jg(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        if (z && this.fhr != null && this.fhr.getWrappedAdapter() != null && this.fhr.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fhr.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dgs != null) {
                if (aVar.OY()) {
                    this.dgs.pR();
                    if (aVar.OW()) {
                        this.dgs.gg(e.j.loading);
                    } else if (aVar.OX()) {
                        this.dgs.gg(e.j.loading);
                    } else {
                        this.dgs.gh(e.j.no_more_msg);
                    }
                } else {
                    this.dgs.hide();
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
        if (this.fhr != null) {
            this.fhr.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.fhj);
        }
    }
}
