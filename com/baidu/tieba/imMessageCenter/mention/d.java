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
    private NoNetworkView fTu;
    private com.baidu.tbadk.mvc.g.a hKB;
    private AtMessageActivity kbl;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kbs;
    private BdListView kbt;
    private NavigationBar kbu;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kbl = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bNy() {
        this.rootView = this.kbl.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kbl.setContentView(this.rootView);
        this.kbt = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kbu = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kbu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kbu.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kbu.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kbl.getPageContext());
        this.mPullView.setTag(this.kbl.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kbl);
        this.hKB = new com.baidu.tbadk.mvc.g.a(this.kbl);
        this.hKB.createView();
        this.mHeaderView = new TextView(this.kbl.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kbl.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kbt.setPullRefresh(this.mPullView);
        this.kbt.addHeaderView(this.mHeaderView, 0);
        this.kbt.setNextPage(this.hKB);
        this.kbt.setDividerHeight(0);
        this.fTu = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fTu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fTu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.rW(z);
            }
        });
        this.kbt.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kbl.cvG();
            }
        });
        this.kbs = new com.baidu.tbadk.mvc.f.d<>(this.kbl.getPageContext(), a.class, R.layout.mention_atme_item, this.kbl.bxF());
        this.kbs.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.ec(this.kbl)), NoDataViewFactory.d.dL(null, this.kbl.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kbt.setAdapter((ListAdapter) this.kbs);
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
                public void cQS() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kbs != null) {
                            d.this.kbs.bm(d.this.mDataList);
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
            this.mDataList = fVar.cRh();
            if (this.kbs != null) {
                this.kbs.bm(fVar.cRh());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kbs != null) {
            this.kbs.b(tbPageContext, i);
        }
        if (this.hKB != null) {
            this.hKB.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kbu.onChangeSkinType(tbPageContext, i);
    }

    public void cQQ() {
        if (this.kbt != null) {
            this.kbt.completePullRefreshPostDelayed(0L);
        }
    }

    public void rW(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kbt != null && this.kbt.getWrappedAdapter() != null && this.kbt.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kbt.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.hKB != null) {
                if (aVar.bxz()) {
                    this.hKB.display();
                    if (aVar.bxx()) {
                        this.hKB.rm(R.string.loading);
                    } else if (aVar.bxy()) {
                        this.hKB.rm(R.string.loading);
                    } else {
                        this.hKB.rn(R.string.no_more_msg);
                    }
                } else {
                    this.hKB.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cQR();
            } else {
                cQQ();
            }
        }
    }

    public void cQR() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kbt != null) {
            this.kbt.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kbl);
        }
    }
}
