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
    private NoNetworkView gAh;
    private com.baidu.tbadk.mvc.g.a iCh;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kQA;
    protected BdListView kQB;
    private NavigationBar kQC;
    private AtMessageActivity kQt;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kQt = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVk() {
        this.rootView = this.kQt.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kQt.setContentView(this.rootView);
        this.kQB = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kQC = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kQC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kQC.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kQC.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kQt.getPageContext());
        this.mPullView.setTag(this.kQt.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kQt);
        this.iCh = new com.baidu.tbadk.mvc.g.a(this.kQt);
        this.iCh.createView();
        this.mHeaderView = new TextView(this.kQt.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kQt.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kQB.setPullRefresh(this.mPullView);
        this.kQB.addHeaderView(this.mHeaderView, 0);
        this.kQB.setNextPage(this.iCh);
        this.kQB.setDividerHeight(0);
        this.gAh = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gAh.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gAh.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.tm(z);
            }
        });
        this.kQB.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kQt.cFy();
            }
        });
        this.kQA = new com.baidu.tbadk.mvc.f.d<>(this.kQt.getPageContext(), a.class, R.layout.mention_atme_item, this.kQt.bDI());
        this.kQA.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.j.eX(this.kQt)), NoDataViewFactory.d.dS(null, this.kQt.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kQB.setAdapter((ListAdapter) this.kQA);
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
                public void cZd() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kQA != null) {
                            d.this.kQA.bI(d.this.mDataList);
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
            this.mDataList = fVar.cZs();
            if (this.kQA != null) {
                this.kQA.bI(fVar.cZs());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kQA != null) {
            this.kQA.b(tbPageContext, i);
        }
        if (this.iCh != null) {
            this.iCh.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kQC.onChangeSkinType(tbPageContext, i);
    }

    public void cZb() {
        if (this.kQB != null) {
            this.kQB.completePullRefreshPostDelayed(0L);
        }
    }

    public void tm(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kQB != null && this.kQB.getWrappedAdapter() != null && this.kQB.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kQB.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.iCh != null) {
                if (aVar.bDD()) {
                    this.iCh.display();
                    if (aVar.bDB()) {
                        this.iCh.rr(R.string.loading);
                    } else if (aVar.bDC()) {
                        this.iCh.rr(R.string.loading);
                    } else {
                        this.iCh.rs(R.string.no_more_msg);
                    }
                } else {
                    this.iCh.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cZc();
            } else {
                cZb();
            }
        }
    }

    public void cZc() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kQB != null) {
            this.kQB.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kQt);
        }
    }
}
