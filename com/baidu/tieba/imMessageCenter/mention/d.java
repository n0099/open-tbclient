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
    private NoNetworkView eli;
    private com.baidu.tbadk.mvc.g.a fOy;
    private AtMessageActivity hOe;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> hOl;
    private BdListView hOm;
    private NavigationBar hOn;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.hOe = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beS() {
        this.rootView = this.hOe.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.hOe.setContentView(this.rootView);
        this.hOm = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.hOn = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.hOn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hOn.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.hOn.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.hOe.getPageContext());
        this.mPullView.setTag(this.hOe.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.hOe);
        this.fOy = new com.baidu.tbadk.mvc.g.a(this.hOe);
        this.fOy.createView();
        this.mHeaderView = new TextView(this.hOe.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hOe.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.hOm.setPullRefresh(this.mPullView);
        this.hOm.addHeaderView(this.mHeaderView, 0);
        this.hOm.setNextPage(this.fOy);
        this.hOm.setDividerHeight(0);
        this.eli = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.eli.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.eli.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.oc(z);
            }
        });
        this.hOm.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.hOe.bGw();
            }
        });
        this.hOl = new com.baidu.tbadk.mvc.f.d<>(this.hOe.getPageContext(), a.class, R.layout.mention_atme_item, this.hOe.aQP());
        this.hOl.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dQ(this.hOe)), NoDataViewFactory.d.cA(null, this.hOe.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.hOm.setAdapter((ListAdapter) this.hOl);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.hOl != null) {
                this.hOl.aK(fVar.bZK());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hOl != null) {
            this.hOl.b(tbPageContext, i);
        }
        if (this.fOy != null) {
            this.fOy.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.hOn.onChangeSkinType(tbPageContext, i);
    }

    public void bZr() {
        if (this.hOm != null) {
            this.hOm.completePullRefreshPostDelayed(0L);
        }
    }

    public void oc(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.hOm != null && this.hOm.getWrappedAdapter() != null && this.hOm.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hOm.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.fOy != null) {
                if (aVar.aQK()) {
                    this.fOy.display();
                    if (aVar.aQI()) {
                        this.fOy.mI(R.string.loading);
                    } else if (aVar.aQJ()) {
                        this.fOy.mI(R.string.loading);
                    } else {
                        this.fOy.mJ(R.string.no_more_msg);
                    }
                } else {
                    this.fOy.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bZs();
            } else {
                bZr();
            }
        }
    }

    public void bZs() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.hOm != null) {
            this.hOm.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.hOe);
        }
    }
}
