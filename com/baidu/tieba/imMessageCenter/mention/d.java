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
    private NoNetworkView giU;
    private com.baidu.tbadk.mvc.g.a idO;
    private AtMessageActivity kuq;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kux;
    protected BdListView kuy;
    private NavigationBar kuz;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kuq = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bRW() {
        this.rootView = this.kuq.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kuq.setContentView(this.rootView);
        this.kuy = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kuz = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kuz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kuz.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kuz.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kuq.getPageContext());
        this.mPullView.setTag(this.kuq.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kuq);
        this.idO = new com.baidu.tbadk.mvc.g.a(this.kuq);
        this.idO.createView();
        this.mHeaderView = new TextView(this.kuq.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kuq.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kuy.setPullRefresh(this.mPullView);
        this.kuy.addHeaderView(this.mHeaderView, 0);
        this.kuy.setNextPage(this.idO);
        this.kuy.setDividerHeight(0);
        this.giU = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.giU.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.giU.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.sA(z);
            }
        });
        this.kuy.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kuq.cAR();
            }
        });
        this.kux = new com.baidu.tbadk.mvc.f.d<>(this.kuq.getPageContext(), a.class, R.layout.mention_atme_item, this.kuq.bBn());
        this.kux.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.ec(this.kuq)), NoDataViewFactory.d.dS(null, this.kuq.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kuy.setAdapter((ListAdapter) this.kux);
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
                public void cWg() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kux != null) {
                            d.this.kux.bC(d.this.mDataList);
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
            this.mDataList = fVar.cWv();
            if (this.kux != null) {
                this.kux.bC(fVar.cWv());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kux != null) {
            this.kux.b(tbPageContext, i);
        }
        if (this.idO != null) {
            this.idO.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kuz.onChangeSkinType(tbPageContext, i);
    }

    public void cWe() {
        if (this.kuy != null) {
            this.kuy.completePullRefreshPostDelayed(0L);
        }
    }

    public void sA(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kuy != null && this.kuy.getWrappedAdapter() != null && this.kuy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kuy.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.idO != null) {
                if (aVar.bBh()) {
                    this.idO.display();
                    if (aVar.bBf()) {
                        this.idO.sf(R.string.loading);
                    } else if (aVar.bBg()) {
                        this.idO.sf(R.string.loading);
                    } else {
                        this.idO.sg(R.string.no_more_msg);
                    }
                } else {
                    this.idO.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cWf();
            } else {
                cWe();
            }
        }
    }

    public void cWf() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kuy != null) {
            this.kuy.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kuq);
        }
    }
}
