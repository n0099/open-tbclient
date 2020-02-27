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
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView elh;
    private com.baidu.tbadk.mvc.g.a fOw;
    private AtMessageActivity hOc;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> hOj;
    private BdListView hOk;
    private NavigationBar hOl;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.hOc = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beQ() {
        this.rootView = this.hOc.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.hOc.setContentView(this.rootView);
        this.hOk = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.hOl = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.hOl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hOl.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.hOl.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.hOc.getPageContext());
        this.mPullView.setTag(this.hOc.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.hOc);
        this.fOw = new com.baidu.tbadk.mvc.g.a(this.hOc);
        this.fOw.createView();
        this.mHeaderView = new TextView(this.hOc.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hOc.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.hOk.setPullRefresh(this.mPullView);
        this.hOk.addHeaderView(this.mHeaderView, 0);
        this.hOk.setNextPage(this.fOw);
        this.hOk.setDividerHeight(0);
        this.elh = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.elh.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.elh.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.oc(z);
            }
        });
        this.hOk.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.hOc.bGu();
            }
        });
        this.hOj = new com.baidu.tbadk.mvc.f.d<>(this.hOc.getPageContext(), a.class, R.layout.mention_atme_item, this.hOc.aQN());
        this.hOj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dQ(this.hOc)), NoDataViewFactory.d.cA(null, this.hOc.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.hOk.setAdapter((ListAdapter) this.hOj);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.hOj != null) {
                this.hOj.aK(fVar.bZI());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hOj != null) {
            this.hOj.b(tbPageContext, i);
        }
        if (this.fOw != null) {
            this.fOw.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.hOl.onChangeSkinType(tbPageContext, i);
    }

    public void bZp() {
        if (this.hOk != null) {
            this.hOk.completePullRefreshPostDelayed(0L);
        }
    }

    public void oc(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.hOk != null && this.hOk.getWrappedAdapter() != null && this.hOk.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hOk.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.fOw != null) {
                if (aVar.aQI()) {
                    this.fOw.display();
                    if (aVar.aQG()) {
                        this.fOw.mI(R.string.loading);
                    } else if (aVar.aQH()) {
                        this.fOw.mI(R.string.loading);
                    } else {
                        this.fOw.mJ(R.string.no_more_msg);
                    }
                } else {
                    this.fOw.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bZq();
            } else {
                bZp();
            }
        }
    }

    public void bZq() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.hOk != null) {
            this.hOk.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.hOc);
        }
    }
}
