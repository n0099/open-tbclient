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
    private NoNetworkView elL;
    private com.baidu.tbadk.mvc.g.a fPt;
    private AtMessageActivity hPQ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> hPX;
    private BdListView hPY;
    private NavigationBar hPZ;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.hPQ = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View beY() {
        this.rootView = this.hPQ.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.hPQ.setContentView(this.rootView);
        this.hPY = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.hPZ = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.hPZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hPZ.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.hPZ.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.hPQ.getPageContext());
        this.mPullView.setTag(this.hPQ.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.hPQ);
        this.fPt = new com.baidu.tbadk.mvc.g.a(this.hPQ);
        this.fPt.createView();
        this.mHeaderView = new TextView(this.hPQ.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hPQ.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.hPY.setPullRefresh(this.mPullView);
        this.hPY.addHeaderView(this.mHeaderView, 0);
        this.hPY.setNextPage(this.fPt);
        this.hPY.setDividerHeight(0);
        this.elL = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.elL.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.elL.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.oi(z);
            }
        });
        this.hPY.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.hPQ.bGJ();
            }
        });
        this.hPX = new com.baidu.tbadk.mvc.f.d<>(this.hPQ.getPageContext(), a.class, R.layout.mention_atme_item, this.hPQ.aQU());
        this.hPX.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dP(this.hPQ)), NoDataViewFactory.d.cz(null, this.hPQ.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.hPY.setAdapter((ListAdapter) this.hPX);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.hPX != null) {
                this.hPX.aK(fVar.cad());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hPX != null) {
            this.hPX.b(tbPageContext, i);
        }
        if (this.fPt != null) {
            this.fPt.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.hPZ.onChangeSkinType(tbPageContext, i);
    }

    public void bZK() {
        if (this.hPY != null) {
            this.hPY.completePullRefreshPostDelayed(0L);
        }
    }

    public void oi(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.hPY != null && this.hPY.getWrappedAdapter() != null && this.hPY.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hPY.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.fPt != null) {
                if (aVar.aQP()) {
                    this.fPt.display();
                    if (aVar.aQN()) {
                        this.fPt.mK(R.string.loading);
                    } else if (aVar.aQO()) {
                        this.fPt.mK(R.string.loading);
                    } else {
                        this.fPt.mL(R.string.no_more_msg);
                    }
                } else {
                    this.fPt.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bZL();
            } else {
                bZK();
            }
        }
    }

    public void bZL() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.hPY != null) {
            this.hPY.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.hPQ);
        }
    }
}
