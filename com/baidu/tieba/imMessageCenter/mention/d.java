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
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView gjn;
    private com.baidu.tbadk.mvc.g.a icV;
    private AtMessageActivity ktG;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> ktN;
    private BdListView ktO;
    private NavigationBar ktP;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.ktG = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bSD() {
        this.rootView = this.ktG.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.ktG.setContentView(this.rootView);
        this.ktO = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.ktP = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.ktP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ktP.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.ktP.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.ktG.getPageContext());
        this.mPullView.setTag(this.ktG.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.ktG);
        this.icV = new com.baidu.tbadk.mvc.g.a(this.ktG);
        this.icV.createView();
        this.mHeaderView = new TextView(this.ktG.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.ktG.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.ktO.setPullRefresh(this.mPullView);
        this.ktO.addHeaderView(this.mHeaderView, 0);
        this.ktO.setNextPage(this.icV);
        this.ktO.setDividerHeight(0);
        this.gjn = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gjn.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gjn.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.sx(z);
            }
        });
        this.ktO.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.ktG.cBo();
            }
        });
        this.ktN = new com.baidu.tbadk.mvc.f.d<>(this.ktG.getPageContext(), a.class, R.layout.mention_atme_item, this.ktG.bBX());
        this.ktN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.ec(this.ktG)), NoDataViewFactory.d.dS(null, this.ktG.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ktO.setAdapter((ListAdapter) this.ktN);
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
                public void cWA() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.ktN != null) {
                            d.this.ktN.bC(d.this.mDataList);
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
            this.mDataList = fVar.cWP();
            if (this.ktN != null) {
                this.ktN.bC(fVar.cWP());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.ktN != null) {
            this.ktN.b(tbPageContext, i);
        }
        if (this.icV != null) {
            this.icV.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.ktP.onChangeSkinType(tbPageContext, i);
    }

    public void cWy() {
        if (this.ktO != null) {
            this.ktO.completePullRefreshPostDelayed(0L);
        }
    }

    public void sx(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.ktO != null && this.ktO.getWrappedAdapter() != null && this.ktO.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ktO.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.icV != null) {
                if (aVar.bBR()) {
                    this.icV.display();
                    if (aVar.bBP()) {
                        this.icV.rH(R.string.loading);
                    } else if (aVar.bBQ()) {
                        this.icV.rH(R.string.loading);
                    } else {
                        this.icV.rI(R.string.no_more_msg);
                    }
                } else {
                    this.icV.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cWz();
            } else {
                cWy();
            }
        }
    }

    public void cWz() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.ktO != null) {
            this.ktO.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.ktG);
        }
    }
}
