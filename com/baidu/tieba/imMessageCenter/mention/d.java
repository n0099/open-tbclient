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
    private NoNetworkView dbr;
    private com.baidu.tbadk.mvc.g.a eqa;
    private AtMessageActivity gxd;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gxk;
    private BdListView gxl;
    private NavigationBar gxm;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gxd = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDs() {
        this.rootView = this.gxd.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.gxd.setContentView(this.rootView);
        this.gxl = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.gxm = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.gxm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxm.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.gxm.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gxd.getPageContext());
        this.mPullView.setTag(this.gxd.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gxd);
        this.eqa = new com.baidu.tbadk.mvc.g.a(this.gxd);
        this.eqa.oM();
        this.mHeaderView = new TextView(this.gxd.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.gxd.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        this.gxl.setPullRefresh(this.mPullView);
        this.gxl.addHeaderView(this.mHeaderView, 0);
        this.gxl.setNextPage(this.eqa);
        this.gxl.setDividerHeight(0);
        this.dbr = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.dbr.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dbr.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                d.this.lG(z);
            }
        });
        this.gxl.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gxd.beX();
            }
        });
        this.gxk = new com.baidu.tbadk.mvc.f.d<>(this.gxd.getPageContext(), a.class, d.h.mention_atme_item, this.gxd.aoG());
        this.gxk.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cP(this.gxd)), NoDataViewFactory.d.hT(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gxl.setAdapter((ListAdapter) this.gxk);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gxk != null) {
                this.gxk.ae(fVar.bxJ());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gxk != null) {
            this.gxk.b(tbPageContext, i);
        }
        if (this.eqa != null) {
            this.eqa.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        this.gxm.onChangeSkinType(tbPageContext, i);
    }

    public void bxq() {
        if (this.gxl != null) {
            this.gxl.completePullRefreshPostDelayed(0L);
        }
    }

    public void lG(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        if (z && this.gxl != null && this.gxl.getWrappedAdapter() != null && this.gxl.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gxl.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eqa != null) {
                if (aVar.aoA()) {
                    this.eqa.qT();
                    if (aVar.aoy()) {
                        this.eqa.jT(d.j.loading);
                    } else if (aVar.aoz()) {
                        this.eqa.jT(d.j.loading);
                    } else {
                        this.eqa.jU(d.j.no_more_msg);
                    }
                } else {
                    this.eqa.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bxr();
            } else {
                bxq();
            }
        }
    }

    public void bxr() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gxl != null) {
            this.gxl.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gxd);
        }
    }
}
