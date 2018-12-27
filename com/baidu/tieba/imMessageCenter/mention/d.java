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
    private NoNetworkView bOA;
    private com.baidu.tbadk.mvc.g.a dfF;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> fgC;
    private BdListView fgD;
    private NavigationBar fgE;
    private AtMessageActivity fgv;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.fgv = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acd() {
        this.rootView = this.fgv.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.fgv.setContentView(this.rootView);
        this.fgD = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.fgE = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.fgE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fgE.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.fgE.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.fgv.getPageContext());
        this.mPullView.setTag(this.fgv.getUniqueId());
        this.mPullView.a(this.fgv);
        this.dfF = new com.baidu.tbadk.mvc.g.a(this.fgv);
        this.dfF.oD();
        this.mHeaderView = new TextView(this.fgv.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fgv.getPageContext().getPageActivity(), e.C0210e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        this.fgD.setPullRefresh(this.mPullView);
        this.fgD.addHeaderView(this.mHeaderView, 0);
        this.fgD.setNextPage(this.dfF);
        this.fgD.setDividerHeight(0);
        this.bOA = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bOA.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bOA.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bF(boolean z) {
                d.this.jg(z);
            }
        });
        this.fgD.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.fgv.aDT();
            }
        });
        this.fgC = new com.baidu.tbadk.mvc.f.d<>(this.fgv.getPageContext(), a.class, e.h.mention_atme_item, this.fgv.OM());
        this.fgC.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fgv.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.fgD.setAdapter((ListAdapter) this.fgC);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.fgC != null) {
                this.fgC.R(fVar.aWJ());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fgC != null) {
            this.fgC.b(tbPageContext, i);
        }
        if (this.dfF != null) {
            this.dfF.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.fgE.onChangeSkinType(tbPageContext, i);
    }

    public void aWp() {
        if (this.fgD != null) {
            this.fgD.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void jg(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        if (z && this.fgD != null && this.fgD.getWrappedAdapter() != null && this.fgD.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fgD.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dfF != null) {
                if (aVar.OG()) {
                    this.dfF.pN();
                    if (aVar.OE()) {
                        this.dfF.gg(e.j.loading);
                    } else if (aVar.OF()) {
                        this.dfF.gg(e.j.loading);
                    } else {
                        this.dfF.gh(e.j.no_more_msg);
                    }
                } else {
                    this.dfF.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aWq();
            } else {
                aWp();
            }
        }
    }

    public void aWq() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.fgD != null) {
            this.fgD.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.fgv);
        }
    }
}
