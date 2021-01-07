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
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.d<AtMessageActivity> {
    private NoNetworkView gCe;
    private com.baidu.tbadk.mvc.g.a iBe;
    private AtMessageActivity kMV;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kNc;
    protected BdListView kNd;
    private NavigationBar kNe;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kMV = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bYn() {
        this.rootView = this.kMV.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kMV.setContentView(this.rootView);
        this.kNd = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kNe = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kNe.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kNe.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kNe.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kMV.getPageContext());
        this.mPullView.setTag(this.kMV.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kMV);
        this.iBe = new com.baidu.tbadk.mvc.g.a(this.kMV);
        this.iBe.createView();
        this.mHeaderView = new TextView(this.kMV.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kMV.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kNd.setPullRefresh(this.mPullView);
        this.kNd.addHeaderView(this.mHeaderView, 0);
        this.kNd.setNextPage(this.iBe);
        this.kNd.setDividerHeight(0);
        this.gCe = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gCe.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gCe.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.td(z);
            }
        });
        this.kNd.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kMV.cId();
            }
        });
        this.kNc = new com.baidu.tbadk.mvc.f.d<>(this.kMV.getPageContext(), a.class, R.layout.mention_atme_item, this.kMV.bHj());
        this.kNc.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.fa(this.kMV)), NoDataViewFactory.d.dY(null, this.kMV.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kNd.setAdapter((ListAdapter) this.kNc);
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
                public void daX() {
                    if (!x.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kNc != null) {
                            d.this.kNc.bN(d.this.mDataList);
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
            this.mDataList = fVar.dbm();
            if (this.kNc != null) {
                this.kNc.bN(fVar.dbm());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kNc != null) {
            this.kNc.b(tbPageContext, i);
        }
        if (this.iBe != null) {
            this.iBe.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kNe.onChangeSkinType(tbPageContext, i);
    }

    public void daV() {
        if (this.kNd != null) {
            this.kNd.completePullRefreshPostDelayed(0L);
        }
    }

    public void td(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kNd != null && this.kNd.getWrappedAdapter() != null && this.kNd.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kNd.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.iBe != null) {
                if (aVar.bHe()) {
                    this.iBe.rV();
                    if (aVar.bHc()) {
                        this.iBe.sS(R.string.loading);
                    } else if (aVar.bHd()) {
                        this.iBe.sS(R.string.loading);
                    } else {
                        this.iBe.sT(R.string.no_more_msg);
                    }
                } else {
                    this.iBe.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                daW();
            } else {
                daV();
            }
        }
    }

    public void daW() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kNd != null) {
            this.kNd.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kMV);
        }
    }
}
