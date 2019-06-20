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
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView dlX;
    private com.baidu.tbadk.mvc.g.a eFI;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gOA;
    private BdListView gOB;
    private NavigationBar gOC;
    private AtMessageActivity gOt;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gOt = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aJI() {
        this.rootView = this.gOt.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gOt.setContentView(this.rootView);
        this.gOB = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gOC = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gOC.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOC.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gOC.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gOt.getPageContext());
        this.mPullView.setTag(this.gOt.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gOt);
        this.eFI = new com.baidu.tbadk.mvc.g.a(this.gOt);
        this.eFI.nG();
        this.mHeaderView = new TextView(this.gOt.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.gOt.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        this.gOB.setPullRefresh(this.mPullView);
        this.gOB.addHeaderView(this.mHeaderView, 0);
        this.gOB.setNextPage(this.eFI);
        this.gOB.setDividerHeight(0);
        this.dlX = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dlX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dlX.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                d.this.mw(z);
            }
        });
        this.gOB.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gOt.bms();
            }
        });
        this.gOA = new com.baidu.tbadk.mvc.f.d<>(this.gOt.getPageContext(), a.class, R.layout.mention_atme_item, this.gOt.atK());
        this.gOA.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cu(this.gOt)), NoDataViewFactory.d.iH(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gOB.setAdapter((ListAdapter) this.gOA);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gOA != null) {
                this.gOA.al(fVar.bFv());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gOA != null) {
            this.gOA.b(tbPageContext, i);
        }
        if (this.eFI != null) {
            this.eFI.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        this.gOC.onChangeSkinType(tbPageContext, i);
    }

    public void bFc() {
        if (this.gOB != null) {
            this.gOB.completePullRefreshPostDelayed(0L);
        }
    }

    public void mw(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        if (z && this.gOB != null && this.gOB.getWrappedAdapter() != null && this.gOB.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gOB.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eFI != null) {
                if (aVar.atE()) {
                    this.eFI.pO();
                    if (aVar.atC()) {
                        this.eFI.kH(R.string.loading);
                    } else if (aVar.atD()) {
                        this.eFI.kH(R.string.loading);
                    } else {
                        this.eFI.kI(R.string.no_more_msg);
                    }
                } else {
                    this.eFI.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bFd();
            } else {
                bFc();
            }
        }
    }

    public void bFd() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gOB != null) {
            this.gOB.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gOt);
        }
    }
}
