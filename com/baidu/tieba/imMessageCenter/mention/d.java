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
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.d<AtMessageActivity> {
    private NoNetworkView gCe;
    private com.baidu.tbadk.mvc.g.a iEe;
    private AtMessageActivity kSJ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kSQ;
    protected BdListView kSR;
    private NavigationBar kSS;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kSJ = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVx() {
        this.rootView = this.kSJ.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kSJ.setContentView(this.rootView);
        this.kSR = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kSS = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kSS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kSS.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kSS.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kSJ.getPageContext());
        this.mPullView.setTag(this.kSJ.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kSJ);
        this.iEe = new com.baidu.tbadk.mvc.g.a(this.kSJ);
        this.iEe.createView();
        this.mHeaderView = new TextView(this.kSJ.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kSJ.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kSR.setPullRefresh(this.mPullView);
        this.kSR.addHeaderView(this.mHeaderView, 0);
        this.kSR.setNextPage(this.iEe);
        this.kSR.setDividerHeight(0);
        this.gCe = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gCe.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gCe.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.tm(z);
            }
        });
        this.kSR.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kSJ.cFL();
            }
        });
        this.kSQ = new com.baidu.tbadk.mvc.f.d<>(this.kSJ.getPageContext(), a.class, R.layout.mention_atme_item, this.kSJ.bDL());
        this.kSQ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.j.eW(this.kSJ)), NoDataViewFactory.d.dS(null, this.kSJ.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kSR.setAdapter((ListAdapter) this.kSQ);
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
                public void cZr() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kSQ != null) {
                            d.this.kSQ.bI(d.this.mDataList);
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
            this.mDataList = fVar.cZG();
            if (this.kSQ != null) {
                this.kSQ.bI(fVar.cZG());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kSQ != null) {
            this.kSQ.b(tbPageContext, i);
        }
        if (this.iEe != null) {
            this.iEe.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kSS.onChangeSkinType(tbPageContext, i);
    }

    public void cZp() {
        if (this.kSR != null) {
            this.kSR.completePullRefreshPostDelayed(0L);
        }
    }

    public void tm(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kSR != null && this.kSR.getWrappedAdapter() != null && this.kSR.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kSR.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.iEe != null) {
                if (aVar.bDG()) {
                    this.iEe.display();
                    if (aVar.bDE()) {
                        this.iEe.rs(R.string.loading);
                    } else if (aVar.bDF()) {
                        this.iEe.rs(R.string.loading);
                    } else {
                        this.iEe.rt(R.string.no_more_msg);
                    }
                } else {
                    this.iEe.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cZq();
            } else {
                cZp();
            }
        }
    }

    public void cZq() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kSR != null) {
            this.kSR.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kSJ);
        }
    }
}
