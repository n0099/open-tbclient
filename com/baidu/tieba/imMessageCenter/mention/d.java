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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView egT;
    private com.baidu.tbadk.mvc.g.a fIQ;
    private AtMessageActivity hIB;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> hII;
    private BdListView hIJ;
    private NavigationBar hIK;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.hIB = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bci() {
        this.rootView = this.hIB.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.hIB.setContentView(this.rootView);
        this.hIJ = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.hIK = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.hIK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hIK.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.hIK.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.hIB.getPageContext());
        this.mPullView.setTag(this.hIB.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.hIB);
        this.fIQ = new com.baidu.tbadk.mvc.g.a(this.hIB);
        this.fIQ.createView();
        this.mHeaderView = new TextView(this.hIB.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hIB.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.hIJ.setPullRefresh(this.mPullView);
        this.hIJ.addHeaderView(this.mHeaderView, 0);
        this.hIJ.setNextPage(this.fIQ);
        this.hIJ.setDividerHeight(0);
        this.egT = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.egT.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.egT.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.nO(z);
            }
        });
        this.hIJ.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.hIB.bDQ();
            }
        });
        this.hII = new com.baidu.tbadk.mvc.f.d<>(this.hIB.getPageContext(), a.class, R.layout.mention_atme_item, this.hIB.aOf());
        this.hII.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dM(this.hIB)), NoDataViewFactory.d.cr(null, this.hIB.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.hIJ.setAdapter((ListAdapter) this.hII);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.hII != null) {
                this.hII.aL(fVar.bWY());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hII != null) {
            this.hII.b(tbPageContext, i);
        }
        if (this.fIQ != null) {
            this.fIQ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.hIK.onChangeSkinType(tbPageContext, i);
    }

    public void bWF() {
        if (this.hIJ != null) {
            this.hIJ.completePullRefreshPostDelayed(0L);
        }
    }

    public void nO(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.hIJ != null && this.hIJ.getWrappedAdapter() != null && this.hIJ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gy().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hIJ.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.fIQ != null) {
                if (aVar.aOa()) {
                    this.fIQ.lw();
                    if (aVar.aNY()) {
                        this.fIQ.mr(R.string.loading);
                    } else if (aVar.aNZ()) {
                        this.fIQ.mr(R.string.loading);
                    } else {
                        this.fIQ.ms(R.string.no_more_msg);
                    }
                } else {
                    this.fIQ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bWG();
            } else {
                bWF();
            }
        }
    }

    public void bWG() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.hIJ != null) {
            this.hIJ.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.hIB);
        }
    }
}
