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
    private NoNetworkView dnM;
    private com.baidu.tbadk.mvc.g.a eKL;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gVC;
    private BdListView gVD;
    private NavigationBar gVE;
    private AtMessageActivity gVv;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gVv = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aLp() {
        this.rootView = this.gVv.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gVv.setContentView(this.rootView);
        this.gVD = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gVE = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gVE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gVE.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gVE.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gVv.getPageContext());
        this.mPullView.setTag(this.gVv.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gVv);
        this.eKL = new com.baidu.tbadk.mvc.g.a(this.gVv);
        this.eKL.nZ();
        this.mHeaderView = new TextView(this.gVv.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.gVv.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        this.gVD.setPullRefresh(this.mPullView);
        this.gVD.addHeaderView(this.mHeaderView, 0);
        this.gVD.setNextPage(this.eKL);
        this.gVD.setDividerHeight(0);
        this.dnM = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dnM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dnM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                d.this.mK(z);
            }
        });
        this.gVD.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gVv.boG();
            }
        });
        this.gVC = new com.baidu.tbadk.mvc.f.d<>(this.gVv.getPageContext(), a.class, R.layout.mention_atme_item, this.gVv.auU());
        this.gVC.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cv(this.gVv)), NoDataViewFactory.d.iN(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gVD.setAdapter((ListAdapter) this.gVC);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gVC != null) {
                this.gVC.al(fVar.bIq());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gVC != null) {
            this.gVC.b(tbPageContext, i);
        }
        if (this.eKL != null) {
            this.eKL.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        this.gVE.onChangeSkinType(tbPageContext, i);
    }

    public void bHX() {
        if (this.gVD != null) {
            this.gVD.completePullRefreshPostDelayed(0L);
        }
    }

    public void mK(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        if (z && this.gVD != null && this.gVD.getWrappedAdapter() != null && this.gVD.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gVD.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eKL != null) {
                if (aVar.auO()) {
                    this.eKL.qk();
                    if (aVar.auM()) {
                        this.eKL.kO(R.string.loading);
                    } else if (aVar.auN()) {
                        this.eKL.kO(R.string.loading);
                    } else {
                        this.eKL.kP(R.string.no_more_msg);
                    }
                } else {
                    this.eKL.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bHY();
            } else {
                bHX();
            }
        }
    }

    public void bHY() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gVD != null) {
            this.gVD.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gVv);
        }
    }
}
