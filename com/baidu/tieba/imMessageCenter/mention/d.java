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
    private NoNetworkView gAv;
    private com.baidu.tbadk.mvc.g.a iCv;
    private AtMessageActivity kQH;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kQO;
    protected BdListView kQP;
    private NavigationBar kQQ;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kQH = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bVr() {
        this.rootView = this.kQH.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kQH.setContentView(this.rootView);
        this.kQP = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kQQ = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kQQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kQQ.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kQQ.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kQH.getPageContext());
        this.mPullView.setTag(this.kQH.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kQH);
        this.iCv = new com.baidu.tbadk.mvc.g.a(this.kQH);
        this.iCv.createView();
        this.mHeaderView = new TextView(this.kQH.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kQH.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kQP.setPullRefresh(this.mPullView);
        this.kQP.addHeaderView(this.mHeaderView, 0);
        this.kQP.setNextPage(this.iCv);
        this.kQP.setDividerHeight(0);
        this.gAv = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gAv.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gAv.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.tm(z);
            }
        });
        this.kQP.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kQH.cFF();
            }
        });
        this.kQO = new com.baidu.tbadk.mvc.f.d<>(this.kQH.getPageContext(), a.class, R.layout.mention_atme_item, this.kQH.bDI());
        this.kQO.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.j.eX(this.kQH)), NoDataViewFactory.d.dS(null, this.kQH.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kQP.setAdapter((ListAdapter) this.kQO);
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
                public void cZk() {
                    if (!y.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kQO != null) {
                            d.this.kQO.bI(d.this.mDataList);
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
            this.mDataList = fVar.cZz();
            if (this.kQO != null) {
                this.kQO.bI(fVar.cZz());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kQO != null) {
            this.kQO.b(tbPageContext, i);
        }
        if (this.iCv != null) {
            this.iCv.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kQQ.onChangeSkinType(tbPageContext, i);
    }

    public void cZi() {
        if (this.kQP != null) {
            this.kQP.completePullRefreshPostDelayed(0L);
        }
    }

    public void tm(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kQP != null && this.kQP.getWrappedAdapter() != null && this.kQP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kQP.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.iCv != null) {
                if (aVar.bDD()) {
                    this.iCv.display();
                    if (aVar.bDB()) {
                        this.iCv.rr(R.string.loading);
                    } else if (aVar.bDC()) {
                        this.iCv.rr(R.string.loading);
                    } else {
                        this.iCv.rs(R.string.no_more_msg);
                    }
                } else {
                    this.iCv.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cZj();
            } else {
                cZi();
            }
        }
    }

    public void cZj() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kQP != null) {
            this.kQP.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kQH);
        }
    }
}
