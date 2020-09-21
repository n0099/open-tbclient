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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.List;
/* loaded from: classes21.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView fHl;
    private com.baidu.tbadk.mvc.g.a hvG;
    private AtMessageActivity jMn;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> jMu;
    private BdListView jMv;
    private NavigationBar jMw;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.jMn = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bKO() {
        this.rootView = this.jMn.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.jMn.setContentView(this.rootView);
        this.jMv = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.jMw = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.jMw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jMw.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.jMw.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.jMn.getPageContext());
        this.mPullView.setTag(this.jMn.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.jMn);
        this.hvG = new com.baidu.tbadk.mvc.g.a(this.jMn);
        this.hvG.createView();
        this.mHeaderView = new TextView(this.jMn.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jMn.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.jMv.setPullRefresh(this.mPullView);
        this.jMv.addHeaderView(this.mHeaderView, 0);
        this.jMv.setNextPage(this.hvG);
        this.jMv.setDividerHeight(0);
        this.fHl = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fHl.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fHl.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.rq(z);
            }
        });
        this.jMv.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.jMn.csj();
            }
        });
        this.jMu = new com.baidu.tbadk.mvc.f.d<>(this.jMn.getPageContext(), a.class, R.layout.mention_atme_item, this.jMn.buV());
        this.jMu.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dW(this.jMn)), NoDataViewFactory.d.dG(null, this.jMn.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.jMv.setAdapter((ListAdapter) this.jMu);
        return this.rootView;
    }

    public void b(final FeedData feedData) {
        if (feedData != null) {
            com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a aVar = new com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.a();
            aVar.type = 2;
            aVar.threadId = com.baidu.adp.lib.f.b.toLong(feedData.getThread_id(), 0L);
            aVar.postId = com.baidu.adp.lib.f.b.toLong(feedData.getPost_id(), 0L);
            aVar.nid = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
            com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b bVar = new com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b(getPageContext());
            bVar.a(aVar);
            bVar.a(new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b.a
                public void cNk() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.jMu != null) {
                            d.this.jMu.bj(d.this.mDataList);
                        }
                    }
                }
            });
            bVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            this.mDataList = fVar.cNz();
            if (this.jMu != null) {
                this.jMu.bj(fVar.cNz());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.jMu != null) {
            this.jMu.b(tbPageContext, i);
        }
        if (this.hvG != null) {
            this.hvG.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.jMw.onChangeSkinType(tbPageContext, i);
    }

    public void cNi() {
        if (this.jMv != null) {
            this.jMv.completePullRefreshPostDelayed(0L);
        }
    }

    public void rq(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.jMv != null && this.jMv.getWrappedAdapter() != null && this.jMv.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mX().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jMv.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.hvG != null) {
                if (aVar.buP()) {
                    this.hvG.display();
                    if (aVar.buN()) {
                        this.hvG.qO(R.string.loading);
                    } else if (aVar.buO()) {
                        this.hvG.qO(R.string.loading);
                    } else {
                        this.hvG.qP(R.string.no_more_msg);
                    }
                } else {
                    this.hvG.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cNj();
            } else {
                cNi();
            }
        }
    }

    public void cNj() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.jMv != null) {
            this.jMv.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.jMn);
        }
    }
}
