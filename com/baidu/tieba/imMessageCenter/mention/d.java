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
    private NoNetworkView ePq;
    private com.baidu.tbadk.mvc.g.a gug;
    private AtMessageActivity izN;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> izU;
    private BdListView izV;
    private NavigationBar izW;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.izN = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bom() {
        this.rootView = this.izN.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.izN.setContentView(this.rootView);
        this.izV = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.izW = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.izW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.izW.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.izW.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.izN.getPageContext());
        this.mPullView.setTag(this.izN.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.izN);
        this.gug = new com.baidu.tbadk.mvc.g.a(this.izN);
        this.gug.createView();
        this.mHeaderView = new TextView(this.izN.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.izN.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.izV.setPullRefresh(this.mPullView);
        this.izV.addHeaderView(this.mHeaderView, 0);
        this.izV.setNextPage(this.gug);
        this.izV.setDividerHeight(0);
        this.ePq = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.ePq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ePq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.pm(z);
            }
        });
        this.izV.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.izN.bRj();
            }
        });
        this.izU = new com.baidu.tbadk.mvc.f.d<>(this.izN.getPageContext(), a.class, R.layout.mention_atme_item, this.izN.aZc());
        this.izU.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dr(this.izN)), NoDataViewFactory.d.cK(null, this.izN.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.izV.setAdapter((ListAdapter) this.izU);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.izU != null) {
                this.izU.aU(fVar.ckD());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.izU != null) {
            this.izU.b(tbPageContext, i);
        }
        if (this.gug != null) {
            this.gug.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.izW.onChangeSkinType(tbPageContext, i);
    }

    public void ckk() {
        if (this.izV != null) {
            this.izV.completePullRefreshPostDelayed(0L);
        }
    }

    public void pm(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.izV != null && this.izV.getWrappedAdapter() != null && this.izV.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.izV.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.gug != null) {
                if (aVar.aYX()) {
                    this.gug.display();
                    if (aVar.aYV()) {
                        this.gug.mV(R.string.loading);
                    } else if (aVar.aYW()) {
                        this.gug.mV(R.string.loading);
                    } else {
                        this.gug.mW(R.string.no_more_msg);
                    }
                } else {
                    this.gug.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                ckl();
            } else {
                ckk();
            }
        }
    }

    public void ckl() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.izV != null) {
            this.izV.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.izN);
        }
    }
}
