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
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView fDZ;
    private com.baidu.tbadk.mvc.g.a hoC;
    private AtMessageActivity jDL;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> jDS;
    private BdListView jDT;
    private NavigationBar jDU;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.jDL = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bJE() {
        this.rootView = this.jDL.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.jDL.setContentView(this.rootView);
        this.jDT = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.jDU = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.jDU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jDU.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.jDU.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.jDL.getPageContext());
        this.mPullView.setTag(this.jDL.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.jDL);
        this.hoC = new com.baidu.tbadk.mvc.g.a(this.jDL);
        this.hoC.createView();
        this.mHeaderView = new TextView(this.jDL.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.jDL.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.jDT.setPullRefresh(this.mPullView);
        this.jDT.addHeaderView(this.mHeaderView, 0);
        this.jDT.setNextPage(this.hoC);
        this.jDT.setDividerHeight(0);
        this.fDZ = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fDZ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fDZ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.ri(z);
            }
        });
        this.jDT.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.jDL.coW();
            }
        });
        this.jDS = new com.baidu.tbadk.mvc.f.d<>(this.jDL.getPageContext(), a.class, R.layout.mention_atme_item, this.jDL.btR());
        this.jDS.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dX(this.jDL)), NoDataViewFactory.d.dE(null, this.jDL.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.jDT.setAdapter((ListAdapter) this.jDS);
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
                public void cJE() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.jDS != null) {
                            d.this.jDS.bf(d.this.mDataList);
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
            this.mDataList = fVar.cJT();
            if (this.jDS != null) {
                this.jDS.bf(fVar.cJT());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.jDS != null) {
            this.jDS.b(tbPageContext, i);
        }
        if (this.hoC != null) {
            this.hoC.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.jDU.onChangeSkinType(tbPageContext, i);
    }

    public void cJC() {
        if (this.jDT != null) {
            this.jDT.completePullRefreshPostDelayed(0L);
        }
    }

    public void ri(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.jDT != null && this.jDT.getWrappedAdapter() != null && this.jDT.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mS().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jDT.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.hoC != null) {
                if (aVar.btL()) {
                    this.hoC.display();
                    if (aVar.btJ()) {
                        this.hoC.qx(R.string.loading);
                    } else if (aVar.btK()) {
                        this.hoC.qx(R.string.loading);
                    } else {
                        this.hoC.qy(R.string.no_more_msg);
                    }
                } else {
                    this.hoC.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cJD();
            } else {
                cJC();
            }
        }
    }

    public void cJD() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.jDT != null) {
            this.jDT.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.jDL);
        }
    }
}
