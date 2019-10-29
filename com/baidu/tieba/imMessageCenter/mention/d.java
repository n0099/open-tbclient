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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView dwI;
    private com.baidu.tbadk.mvc.g.a eVa;
    private AtMessageActivity gVq;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gVx;
    private BdListView gVy;
    private NavigationBar gVz;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gVq = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aKY() {
        this.rootView = this.gVq.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gVq.setContentView(this.rootView);
        this.gVy = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gVz = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gVz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gVz.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gVz.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gVq.getPageContext());
        this.mPullView.setTag(this.gVq.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gVq);
        this.eVa = new com.baidu.tbadk.mvc.g.a(this.gVq);
        this.eVa.createView();
        this.mHeaderView = new TextView(this.gVq.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.gVq.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.gVy.setPullRefresh(this.mPullView);
        this.gVy.addHeaderView(this.mHeaderView, 0);
        this.gVy.setNextPage(this.eVa);
        this.gVy.setDividerHeight(0);
        this.dwI = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dwI.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dwI.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.mB(z);
            }
        });
        this.gVy.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.gVq.bmw();
            }
        });
        this.gVx = new com.baidu.tbadk.mvc.f.d<>(this.gVq.getPageContext(), a.class, R.layout.mention_atme_item, this.gVq.awx());
        this.gVx.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cr(this.gVq)), NoDataViewFactory.d.iL(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gVy.setAdapter((ListAdapter) this.gVx);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gVx != null) {
                this.gVx.aF(fVar.bFO());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gVx != null) {
            this.gVx.b(tbPageContext, i);
        }
        if (this.eVa != null) {
            this.eVa.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gVz.onChangeSkinType(tbPageContext, i);
    }

    public void bFv() {
        if (this.gVy != null) {
            this.gVy.completePullRefreshPostDelayed(0L);
        }
    }

    public void mB(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.gVy != null && this.gVy.getWrappedAdapter() != null && this.gVy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gVy.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eVa != null) {
                if (aVar.aws()) {
                    this.eVa.le();
                    if (aVar.awq()) {
                        this.eVa.ke(R.string.loading);
                    } else if (aVar.awr()) {
                        this.eVa.ke(R.string.loading);
                    } else {
                        this.eVa.kf(R.string.no_more_msg);
                    }
                } else {
                    this.eVa.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bFw();
            } else {
                bFv();
            }
        }
    }

    public void bFw() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gVy != null) {
            this.gVy.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gVq);
        }
    }
}
