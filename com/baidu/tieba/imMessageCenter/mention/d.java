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
    private NoNetworkView gxx;
    private com.baidu.tbadk.mvc.g.a iwx;
    private AtMessageActivity kIq;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> kIx;
    protected BdListView kIy;
    private NavigationBar kIz;
    private List<FeedData> mDataList;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    protected View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.kIq = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bUv() {
        this.rootView = this.kIq.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.kIq.setContentView(this.rootView);
        this.kIy = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.kIz = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.kIz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kIz.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.kIz.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.kIq.getPageContext());
        this.mPullView.setTag(this.kIq.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.kIq);
        this.iwx = new com.baidu.tbadk.mvc.g.a(this.kIq);
        this.iwx.createView();
        this.mHeaderView = new TextView(this.kIq.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.kIq.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.kIy.setPullRefresh(this.mPullView);
        this.kIy.addHeaderView(this.mHeaderView, 0);
        this.kIy.setNextPage(this.iwx);
        this.kIy.setDividerHeight(0);
        this.gxx = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.gxx.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.gxx.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.sZ(z);
            }
        });
        this.kIy.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.kIq.cEl();
            }
        });
        this.kIx = new com.baidu.tbadk.mvc.f.d<>(this.kIq.getPageContext(), a.class, R.layout.mention_atme_item, this.kIq.bDq());
        this.kIx.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.eY(this.kIq)), NoDataViewFactory.d.dX(null, this.kIq.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.kIy.setAdapter((ListAdapter) this.kIx);
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
                public void cXf() {
                    if (!x.isEmpty(d.this.mDataList)) {
                        d.this.mDataList.remove(feedData);
                        if (d.this.kIx != null) {
                            d.this.kIx.bN(d.this.mDataList);
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
            this.mDataList = fVar.cXu();
            if (this.kIx != null) {
                this.kIx.bN(fVar.cXu());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.kIx != null) {
            this.kIx.b(tbPageContext, i);
        }
        if (this.iwx != null) {
            this.iwx.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.kIz.onChangeSkinType(tbPageContext, i);
    }

    public void cXd() {
        if (this.kIy != null) {
            this.kIy.completePullRefreshPostDelayed(0L);
        }
    }

    public void sZ(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.kIy != null && this.kIy.getWrappedAdapter() != null && this.kIy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.4
                @Override // java.lang.Runnable
                public void run() {
                    d.this.kIy.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.iwx != null) {
                if (aVar.bDl()) {
                    this.iwx.rV();
                    if (aVar.bDj()) {
                        this.iwx.rm(R.string.loading);
                    } else if (aVar.bDk()) {
                        this.iwx.rm(R.string.loading);
                    } else {
                        this.iwx.rn(R.string.no_more_msg);
                    }
                } else {
                    this.iwx.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cXe();
            } else {
                cXd();
            }
        }
    }

    public void cXe() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.kIy != null) {
            this.kIy.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.kIq);
        }
    }
}
