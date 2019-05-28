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
    private NavigationBar gOA;
    private AtMessageActivity gOr;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gOy;
    private BdListView gOz;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gOr = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aJI() {
        this.rootView = this.gOr.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gOr.setContentView(this.rootView);
        this.gOz = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gOA = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gOA.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOA.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gOA.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gOr.getPageContext());
        this.mPullView.setTag(this.gOr.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gOr);
        this.eFI = new com.baidu.tbadk.mvc.g.a(this.gOr);
        this.eFI.nG();
        this.mHeaderView = new TextView(this.gOr.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.gOr.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        this.gOz.setPullRefresh(this.mPullView);
        this.gOz.addHeaderView(this.mHeaderView, 0);
        this.gOz.setNextPage(this.eFI);
        this.gOz.setDividerHeight(0);
        this.dlX = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dlX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dlX.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                d.this.mv(z);
            }
        });
        this.gOz.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gOr.bms();
            }
        });
        this.gOy = new com.baidu.tbadk.mvc.f.d<>(this.gOr.getPageContext(), a.class, R.layout.mention_atme_item, this.gOr.atK());
        this.gOy.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cu(this.gOr)), NoDataViewFactory.d.iH(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gOz.setAdapter((ListAdapter) this.gOy);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gOy != null) {
                this.gOy.al(fVar.bFu());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gOy != null) {
            this.gOy.b(tbPageContext, i);
        }
        if (this.eFI != null) {
            this.eFI.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        this.gOA.onChangeSkinType(tbPageContext, i);
    }

    public void bFb() {
        if (this.gOz != null) {
            this.gOz.completePullRefreshPostDelayed(0L);
        }
    }

    public void mv(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        if (z && this.gOz != null && this.gOz.getWrappedAdapter() != null && this.gOz.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gOz.startPullRefresh();
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
                bFc();
            } else {
                bFb();
            }
        }
    }

    public void bFc() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gOz != null) {
            this.gOz.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gOr);
        }
    }
}
