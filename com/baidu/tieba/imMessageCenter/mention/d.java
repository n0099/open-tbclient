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
    private NoNetworkView grd;
    private com.baidu.tbadk.mvc.g.a ioI;
    private AtMessageActivity kHK;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kHR;
    protected BdListView kHS;
    private NavigationBar kHT;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kHK = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVG() {
        this.rootView = this.kHK.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kHK.setContentView(this.rootView);
        this.kHS = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kHT = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kHT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kHT.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kHT.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kHK.getPageContext());
        this.mPullView.setTag(this.kHK.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kHK);
        this.ioI = new com.baidu.tbadk.mvc.g.a(this.kHK);
        this.ioI.createView();
        this.mHeaderView = new TextView(this.kHK.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kHK.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kHS.setPullRefresh(this.mPullView);
        this.kHS.addHeaderView(this.mHeaderView, 0);
        this.kHS.setNextPage(this.ioI);
        this.kHS.setDividerHeight(0);
        this.grd = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.grd.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.grd.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.tc(z);
            }
        });
        this.kHS.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kHK.cFh();
            }
        });
        this.kHR = new com.baidu.tbadk.mvc.f.d<>(this.kHK.getPageContext(), a.class, R.layout.mention_atme_item, this.kHK.bEP());
        this.kHR.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.eH(this.kHK)), NoDataViewFactory.d.dZ(null, this.kHK.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kHS.setAdapter((ListAdapter) this.kHR);
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
                public void dbs() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kHR != null) {
                            d.this.kHR.bG(d.this.mDataList);
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
            this.mDataList = fVar.dbH();
            if (this.kHR != null) {
                this.kHR.bG(fVar.dbH());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kHR != null) {
            this.kHR.b(tbPageContext, i);
        }
        if (this.ioI != null) {
            this.ioI.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kHT.onChangeSkinType(tbPageContext, i);
    }

    public void dbq() {
        if (this.kHS != null) {
            this.kHS.completePullRefreshPostDelayed(0L);
        }
    }

    public void tc(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kHS != null && this.kHS.getWrappedAdapter() != null && this.kHS.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kHS.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ioI != null) {
                if (aVar.bEJ()) {
                    this.ioI.su();
                    if (aVar.bEH()) {
                        this.ioI.sG(R.string.loading);
                    } else if (aVar.bEI()) {
                        this.ioI.sG(R.string.loading);
                    } else {
                        this.ioI.sH(R.string.no_more_msg);
                    }
                } else {
                    this.ioI.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                dbr();
            } else {
                dbq();
            }
        }
    }

    public void dbr() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kHS != null) {
            this.kHS.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kHK);
        }
    }
}
