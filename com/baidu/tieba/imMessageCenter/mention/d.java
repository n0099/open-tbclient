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
    private NoNetworkView elv;
    private com.baidu.tbadk.mvc.g.a fOL;
    private AtMessageActivity hOq;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> hOx;
    private BdListView hOy;
    private NavigationBar hOz;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.hOq = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beT() {
        this.rootView = this.hOq.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.hOq.setContentView(this.rootView);
        this.hOy = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.hOz = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.hOz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hOz.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.hOz.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.hOq.getPageContext());
        this.mPullView.setTag(this.hOq.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.hOq);
        this.fOL = new com.baidu.tbadk.mvc.g.a(this.hOq);
        this.fOL.createView();
        this.mHeaderView = new TextView(this.hOq.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hOq.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.hOy.setPullRefresh(this.mPullView);
        this.hOy.addHeaderView(this.mHeaderView, 0);
        this.hOy.setNextPage(this.fOL);
        this.hOy.setDividerHeight(0);
        this.elv = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.elv.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.elv.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.oc(z);
            }
        });
        this.hOy.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.hOq.bGx();
            }
        });
        this.hOx = new com.baidu.tbadk.mvc.f.d<>(this.hOq.getPageContext(), a.class, R.layout.mention_atme_item, this.hOq.aQQ());
        this.hOx.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dQ(this.hOq)), NoDataViewFactory.d.cA(null, this.hOq.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.hOy.setAdapter((ListAdapter) this.hOx);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.hOx != null) {
                this.hOx.aK(fVar.bZL());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hOx != null) {
            this.hOx.b(tbPageContext, i);
        }
        if (this.fOL != null) {
            this.fOL.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.hOz.onChangeSkinType(tbPageContext, i);
    }

    public void bZs() {
        if (this.hOy != null) {
            this.hOy.completePullRefreshPostDelayed(0L);
        }
    }

    public void oc(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.hOy != null && this.hOy.getWrappedAdapter() != null && this.hOy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hOy.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.fOL != null) {
                if (aVar.aQL()) {
                    this.fOL.display();
                    if (aVar.aQJ()) {
                        this.fOL.mI(R.string.loading);
                    } else if (aVar.aQK()) {
                        this.fOL.mI(R.string.loading);
                    } else {
                        this.fOL.mJ(R.string.no_more_msg);
                    }
                } else {
                    this.fOL.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bZt();
            } else {
                bZs();
            }
        }
    }

    public void bZt() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.hOy != null) {
            this.hOy.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.hOq);
        }
    }
}
