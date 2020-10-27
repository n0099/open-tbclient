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
    private NoNetworkView gdx;
    private com.baidu.tbadk.mvc.g.a hWY;
    private AtMessageActivity knK;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> knR;
    private BdListView knS;
    private NavigationBar knT;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.knK = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bQd() {
        this.rootView = this.knK.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.knK.setContentView(this.rootView);
        this.knS = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.knT = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.knT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.knT.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.knT.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.knK.getPageContext());
        this.mPullView.setTag(this.knK.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.knK);
        this.hWY = new com.baidu.tbadk.mvc.g.a(this.knK);
        this.hWY.createView();
        this.mHeaderView = new TextView(this.knK.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.knK.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.knS.setPullRefresh(this.mPullView);
        this.knS.addHeaderView(this.mHeaderView, 0);
        this.knS.setNextPage(this.hWY);
        this.knS.setDividerHeight(0);
        this.gdx = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gdx.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gdx.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.so(z);
            }
        });
        this.knS.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.knK.cyN();
            }
        });
        this.knR = new com.baidu.tbadk.mvc.f.d<>(this.knK.getPageContext(), a.class, R.layout.mention_atme_item, this.knK.bzy());
        this.knR.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.ec(this.knK)), NoDataViewFactory.d.dS(null, this.knK.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.knS.setAdapter((ListAdapter) this.knR);
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
                public void cTZ() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.knR != null) {
                            d.this.knR.bv(d.this.mDataList);
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
            this.mDataList = fVar.cUo();
            if (this.knR != null) {
                this.knR.bv(fVar.cUo());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.knR != null) {
            this.knR.b(tbPageContext, i);
        }
        if (this.hWY != null) {
            this.hWY.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.knT.onChangeSkinType(tbPageContext, i);
    }

    public void cTX() {
        if (this.knS != null) {
            this.knS.completePullRefreshPostDelayed(0L);
        }
    }

    public void so(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.knS != null && this.knS.getWrappedAdapter() != null && this.knS.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.knS.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.hWY != null) {
                if (aVar.bzs()) {
                    this.hWY.display();
                    if (aVar.bzq()) {
                        this.hWY.rx(R.string.loading);
                    } else if (aVar.bzr()) {
                        this.hWY.rx(R.string.loading);
                    } else {
                        this.hWY.ry(R.string.no_more_msg);
                    }
                } else {
                    this.hWY.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cTY();
            } else {
                cTX();
            }
        }
    }

    public void cTY() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.knS != null) {
            this.knS.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.knK);
        }
    }
}
