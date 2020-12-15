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
    private NoNetworkView grf;
    private com.baidu.tbadk.mvc.g.a ioK;
    private AtMessageActivity kHM;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kHT;
    protected BdListView kHU;
    private NavigationBar kHV;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kHM = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVH() {
        this.rootView = this.kHM.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kHM.setContentView(this.rootView);
        this.kHU = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kHV = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kHV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kHV.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kHV.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kHM.getPageContext());
        this.mPullView.setTag(this.kHM.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kHM);
        this.ioK = new com.baidu.tbadk.mvc.g.a(this.kHM);
        this.ioK.createView();
        this.mHeaderView = new TextView(this.kHM.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kHM.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kHU.setPullRefresh(this.mPullView);
        this.kHU.addHeaderView(this.mHeaderView, 0);
        this.kHU.setNextPage(this.ioK);
        this.kHU.setDividerHeight(0);
        this.grf = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.grf.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.grf.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.tc(z);
            }
        });
        this.kHU.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kHM.cFi();
            }
        });
        this.kHT = new com.baidu.tbadk.mvc.f.d<>(this.kHM.getPageContext(), a.class, R.layout.mention_atme_item, this.kHM.bEP());
        this.kHT.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.eH(this.kHM)), NoDataViewFactory.d.dZ(null, this.kHM.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kHU.setAdapter((ListAdapter) this.kHT);
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
                public void dbt() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kHT != null) {
                            d.this.kHT.bG(d.this.mDataList);
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
            this.mDataList = fVar.dbI();
            if (this.kHT != null) {
                this.kHT.bG(fVar.dbI());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kHT != null) {
            this.kHT.b(tbPageContext, i);
        }
        if (this.ioK != null) {
            this.ioK.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kHV.onChangeSkinType(tbPageContext, i);
    }

    public void dbr() {
        if (this.kHU != null) {
            this.kHU.completePullRefreshPostDelayed(0L);
        }
    }

    public void tc(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kHU != null && this.kHU.getWrappedAdapter() != null && this.kHU.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kHU.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ioK != null) {
                if (aVar.bEJ()) {
                    this.ioK.su();
                    if (aVar.bEH()) {
                        this.ioK.sG(R.string.loading);
                    } else if (aVar.bEI()) {
                        this.ioK.sG(R.string.loading);
                    } else {
                        this.ioK.sH(R.string.no_more_msg);
                    }
                } else {
                    this.ioK.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                dbs();
            } else {
                dbr();
            }
        }
    }

    public void dbs() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kHU != null) {
            this.kHU.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kHM);
        }
    }
}
