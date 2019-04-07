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
    private com.baidu.tbadk.mvc.g.a epZ;
    private AtMessageActivity gxc;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gxj;
    private BdListView gxk;
    private NavigationBar gxl;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gxc = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aDs() {
        this.rootView = this.gxc.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.gxc.setContentView(this.rootView);
        this.gxk = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.gxl = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.gxl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gxl.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.gxl.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gxc.getPageContext());
        this.mPullView.setTag(this.gxc.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gxc);
        this.epZ = new com.baidu.tbadk.mvc.g.a(this.gxc);
        this.epZ.oM();
        this.mHeaderView = new TextView(this.gxc.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.gxc.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        this.gxk.setPullRefresh(this.mPullView);
        this.gxk.addHeaderView(this.mHeaderView, 0);
        this.gxk.setNextPage(this.epZ);
        this.gxk.setDividerHeight(0);
        this.dbq = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.dbq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dbq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void dP(boolean z) {
                d.this.lG(z);
            }
        });
        this.gxk.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gxc.beX();
            }
        });
        this.gxj = new com.baidu.tbadk.mvc.f.d<>(this.gxc.getPageContext(), a.class, d.h.mention_atme_item, this.gxc.aoG());
        this.gxj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cP(this.gxc)), NoDataViewFactory.d.hT(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gxk.setAdapter((ListAdapter) this.gxj);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gxj != null) {
                this.gxj.ae(fVar.bxJ());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gxj != null) {
            this.gxj.b(tbPageContext, i);
        }
        if (this.epZ != null) {
            this.epZ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        this.gxl.onChangeSkinType(tbPageContext, i);
    }

    public void bxq() {
        if (this.gxk != null) {
            this.gxk.completePullRefreshPostDelayed(0L);
        }
    }

    public void lG(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kY());
        if (z && this.gxk != null && this.gxk.getWrappedAdapter() != null && this.gxk.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jH().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gxk.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.epZ != null) {
                if (aVar.aoA()) {
                    this.epZ.qT();
                    if (aVar.aoy()) {
                        this.epZ.jT(d.j.loading);
                    } else if (aVar.aoz()) {
                        this.epZ.jT(d.j.loading);
                    } else {
                        this.epZ.jU(d.j.no_more_msg);
                    }
                } else {
                    this.epZ.hide();
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
        if (this.gxk != null) {
            this.gxk.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gxc);
        }
    }
}
