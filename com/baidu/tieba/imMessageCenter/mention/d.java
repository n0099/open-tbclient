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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.DelReplyAtMsg.b;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView fsB;
    private com.baidu.tbadk.mvc.g.a hbH;
    private AtMessageActivity joH;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> joO;
    private BdListView joP;
    private NavigationBar joQ;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.joH = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bAi() {
        this.rootView = this.joH.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.joH.setContentView(this.rootView);
        this.joP = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.joQ = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.joQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.joQ.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.joQ.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.joH.getPageContext());
        this.mPullView.setTag(this.joH.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.joH);
        this.hbH = new com.baidu.tbadk.mvc.g.a(this.joH);
        this.hbH.createView();
        this.mHeaderView = new TextView(this.joH.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.joH.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.joP.setPullRefresh(this.mPullView);
        this.joP.addHeaderView(this.mHeaderView, 0);
        this.joP.setNextPage(this.hbH);
        this.joP.setDividerHeight(0);
        this.fsB = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fsB.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fsB.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.qA(z);
            }
        });
        this.joP.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.joH.cer();
            }
        });
        this.joO = new com.baidu.tbadk.mvc.f.d<>(this.joH.getPageContext(), a.class, R.layout.mention_atme_item, this.joH.bld());
        this.joO.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dP(this.joH)), NoDataViewFactory.d.m31do(null, this.joH.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.joP.setAdapter((ListAdapter) this.joO);
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
                public void cyM() {
                    if (!x.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.joO != null) {
                            d.this.joO.bf(d.this.mDataList);
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
            this.mDataList = fVar.czb();
            if (this.joO != null) {
                this.joO.bf(fVar.czb());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.joO != null) {
            this.joO.b(tbPageContext, i);
        }
        if (this.hbH != null) {
            this.hbH.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.joQ.onChangeSkinType(tbPageContext, i);
    }

    public void cyK() {
        if (this.joP != null) {
            this.joP.completePullRefreshPostDelayed(0L);
        }
    }

    public void qA(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.joP != null && this.joP.getWrappedAdapter() != null && this.joP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.joP.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.hbH != null) {
                if (aVar.bkY()) {
                    this.hbH.display();
                    if (aVar.bkW()) {
                        this.hbH.om(R.string.loading);
                    } else if (aVar.bkX()) {
                        this.hbH.om(R.string.loading);
                    } else {
                        this.hbH.on(R.string.no_more_msg);
                    }
                } else {
                    this.hbH.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cyL();
            } else {
                cyK();
            }
        }
    }

    public void cyL() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.joP != null) {
            this.joP.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.joH);
        }
    }
}
