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
    private AtMessageActivity gxp;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gxw;
    private BdListView gxx;
    private NavigationBar gxy;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gxp = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDv() {
        this.rootView = this.gxp.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.gxp.setContentView(this.rootView);
        this.gxx = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.gxy = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.gxy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxy.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.gxy.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gxp.getPageContext());
        this.mPullView.setTag(this.gxp.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gxp);
        this.eqr = new com.baidu.tbadk.mvc.g.a(this.gxp);
        this.eqr.oM();
        this.mHeaderView = new TextView(this.gxp.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.gxp.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        this.gxx.setPullRefresh(this.mPullView);
        this.gxx.addHeaderView(this.mHeaderView, 0);
        this.gxx.setNextPage(this.eqr);
        this.gxx.setDividerHeight(0);
        this.dbq = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.dbq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dbq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                d.this.lG(z);
            }
        });
        this.gxx.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gxp.beZ();
            }
        });
        this.gxw = new com.baidu.tbadk.mvc.f.d<>(this.gxp.getPageContext(), a.class, d.h.mention_atme_item, this.gxp.aoK());
        this.gxw.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cP(this.gxp)), NoDataViewFactory.d.hU(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gxx.setAdapter((ListAdapter) this.gxw);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gxw != null) {
                this.gxw.ae(fVar.bxM());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gxw != null) {
            this.gxw.b(tbPageContext, i);
        }
        if (this.eqr != null) {
            this.eqr.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        this.gxy.onChangeSkinType(tbPageContext, i);
    }

    public void bxt() {
        if (this.gxx != null) {
            this.gxx.completePullRefreshPostDelayed(0L);
        }
    }

    public void lG(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        if (z && this.gxx != null && this.gxx.getWrappedAdapter() != null && this.gxx.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gxx.startPullRefresh();
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
                bxu();
            } else {
                bxt();
            }
        }
    }

    public void bxu() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gxx != null) {
            this.gxx.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gxp);
        }
    }
}
