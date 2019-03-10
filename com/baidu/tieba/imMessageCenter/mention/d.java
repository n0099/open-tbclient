package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView dbq;
    private com.baidu.tbadk.mvc.g.a eqr;
    private AtMessageActivity gxq;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gxx;
    private BdListView gxy;
    private NavigationBar gxz;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gxq = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDw() {
        this.rootView = this.gxq.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.gxq.setContentView(this.rootView);
        this.gxy = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.gxz = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.gxz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxz.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.gxz.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gxq.getPageContext());
        this.mPullView.setTag(this.gxq.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gxq);
        this.eqr = new com.baidu.tbadk.mvc.g.a(this.gxq);
        this.eqr.oM();
        this.mHeaderView = new TextView(this.gxq.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.gxq.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        this.gxy.setPullRefresh(this.mPullView);
        this.gxy.addHeaderView(this.mHeaderView, 0);
        this.gxy.setNextPage(this.eqr);
        this.gxy.setDividerHeight(0);
        this.dbq = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.dbq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dbq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                d.this.lG(z);
            }
        });
        this.gxy.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gxq.bfa();
            }
        });
        this.gxx = new com.baidu.tbadk.mvc.f.d<>(this.gxq.getPageContext(), a.class, d.h.mention_atme_item, this.gxq.aoK());
        this.gxx.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cP(this.gxq)), NoDataViewFactory.d.hU(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gxy.setAdapter((ListAdapter) this.gxx);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gxx != null) {
                this.gxx.ae(fVar.bxN());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gxx != null) {
            this.gxx.b(tbPageContext, i);
        }
        if (this.eqr != null) {
            this.eqr.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        this.gxz.onChangeSkinType(tbPageContext, i);
    }

    public void bxu() {
        if (this.gxy != null) {
            this.gxy.completePullRefreshPostDelayed(0L);
        }
    }

    public void lG(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        if (z && this.gxy != null && this.gxy.getWrappedAdapter() != null && this.gxy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gxy.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eqr != null) {
                if (aVar.aoE()) {
                    this.eqr.qT();
                    if (aVar.aoC()) {
                        this.eqr.jU(d.j.loading);
                    } else if (aVar.aoD()) {
                        this.eqr.jU(d.j.loading);
                    } else {
                        this.eqr.jV(d.j.no_more_msg);
                    }
                } else {
                    this.eqr.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bxv();
            } else {
                bxu();
            }
        }
    }

    public void bxv() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gxy != null) {
            this.gxy.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gxq);
        }
    }
}
