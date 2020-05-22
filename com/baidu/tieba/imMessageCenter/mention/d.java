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
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView fbX;
    private com.baidu.tbadk.mvc.g.a gIR;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> iOB;
    private BdListView iOC;
    private NavigationBar iOD;
    private AtMessageActivity iOu;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.iOu = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View btU() {
        this.rootView = this.iOu.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.iOu.setContentView(this.rootView);
        this.iOC = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.iOD = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.iOD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iOD.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.iOD.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.iOu.getPageContext());
        this.mPullView.setTag(this.iOu.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.iOu);
        this.gIR = new com.baidu.tbadk.mvc.g.a(this.iOu);
        this.gIR.createView();
        this.mHeaderView = new TextView(this.iOu.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iOu.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.iOC.setPullRefresh(this.mPullView);
        this.iOC.addHeaderView(this.mHeaderView, 0);
        this.iOC.setNextPage(this.gIR);
        this.iOC.setDividerHeight(0);
        this.fbX = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fbX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fbX.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.pI(z);
            }
        });
        this.iOC.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.iOu.bXF();
            }
        });
        this.iOB = new com.baidu.tbadk.mvc.f.d<>(this.iOu.getPageContext(), a.class, R.layout.mention_atme_item, this.iOu.bfm());
        this.iOB.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dJ(this.iOu)), NoDataViewFactory.d.dj(null, this.iOu.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.iOC.setAdapter((ListAdapter) this.iOB);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.iOB != null) {
                this.iOB.aP(fVar.crb());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.iOB != null) {
            this.iOB.b(tbPageContext, i);
        }
        if (this.gIR != null) {
            this.gIR.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.iOD.onChangeSkinType(tbPageContext, i);
    }

    public void cqI() {
        if (this.iOC != null) {
            this.iOC.completePullRefreshPostDelayed(0L);
        }
    }

    public void pI(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.iOC != null && this.iOC.getWrappedAdapter() != null && this.iOC.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iOC.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.gIR != null) {
                if (aVar.bfh()) {
                    this.gIR.display();
                    if (aVar.bff()) {
                        this.gIR.nx(R.string.loading);
                    } else if (aVar.bfg()) {
                        this.gIR.nx(R.string.loading);
                    } else {
                        this.gIR.ny(R.string.no_more_msg);
                    }
                } else {
                    this.gIR.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cqJ();
            } else {
                cqI();
            }
        }
    }

    public void cqJ() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.iOC != null) {
            this.iOC.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.iOu);
        }
    }
}
