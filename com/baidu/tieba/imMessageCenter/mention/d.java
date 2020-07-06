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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView fns;
    private com.baidu.tbadk.mvc.g.a gWc;
    private AtMessageActivity jgj;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> jgq;
    private BdListView jgr;
    private NavigationBar jgs;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.jgj = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bwS() {
        this.rootView = this.jgj.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.jgj.setContentView(this.rootView);
        this.jgr = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.jgs = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.jgs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jgs.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.jgs.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.jgj.getPageContext());
        this.mPullView.setTag(this.jgj.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.jgj);
        this.gWc = new com.baidu.tbadk.mvc.g.a(this.jgj);
        this.gWc.createView();
        this.mHeaderView = new TextView(this.jgj.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jgj.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.jgr.setPullRefresh(this.mPullView);
        this.jgr.addHeaderView(this.mHeaderView, 0);
        this.jgr.setNextPage(this.gWc);
        this.jgr.setDividerHeight(0);
        this.fns = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fns.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fns.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.pS(z);
            }
        });
        this.jgr.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.jgj.caT();
            }
        });
        this.jgq = new com.baidu.tbadk.mvc.f.d<>(this.jgj.getPageContext(), a.class, R.layout.mention_atme_item, this.jgj.bhs());
        this.jgq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dK(this.jgj)), NoDataViewFactory.d.dm(null, this.jgj.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.jgr.setAdapter((ListAdapter) this.jgq);
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
                public void cuJ() {
                    if (!w.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.jgq != null) {
                            d.this.jgq.aZ(d.this.mDataList);
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
            this.mDataList = fVar.cvc();
            if (this.jgq != null) {
                this.jgq.aZ(fVar.cvc());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.jgq != null) {
            this.jgq.b(tbPageContext, i);
        }
        if (this.gWc != null) {
            this.gWc.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.jgs.onChangeSkinType(tbPageContext, i);
    }

    public void cuH() {
        if (this.jgr != null) {
            this.jgr.completePullRefreshPostDelayed(0L);
        }
    }

    public void pS(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.jgr != null && this.jgr.getWrappedAdapter() != null && this.jgr.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jgr.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.gWc != null) {
                if (aVar.bhn()) {
                    this.gWc.display();
                    if (aVar.bhl()) {
                        this.gWc.nU(R.string.loading);
                    } else if (aVar.bhm()) {
                        this.gWc.nU(R.string.loading);
                    } else {
                        this.gWc.nV(R.string.no_more_msg);
                    }
                } else {
                    this.gWc.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cuI();
            } else {
                cuH();
            }
        }
    }

    public void cuI() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.jgr != null) {
            this.jgr.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.jgj);
        }
    }
}
